package com.example.aminsuyanto.tes;



import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aminsuyanto.tes.activity.DetailActivity;
import com.example.aminsuyanto.tes.model.zodiakModel;
import com.example.aminsuyanto.tes.model.zodiakParcel;
import com.example.aminsuyanto.tes.retrofit.ApiInterface;
import com.example.aminsuyanto.tes.retrofit.ApiService;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    @BindView(R.id.tillName)
    TextInputLayout tillName;
    @BindView(R.id.tillDate)
    TextInputLayout tillDate;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etDate)
    EditText etDate;
    @BindView(R.id.pb_loading)
    ProgressBar pb_loading;
    @BindView(R.id.ivLogo)
    ImageView ivlogo;
    @BindView(R.id.lin_loading)
    LinearLayout lin_loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pb_loading.setAlpha(0.0f);
        etDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    Calendar c = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(MainActivity.this,
                            c.get(Calendar.YEAR),
                            c.get(Calendar.MONTH),
                            c.get(Calendar.DAY_OF_MONTH)
                    );
                    Calendar now = Calendar.getInstance();
                    dpd.setMaxDate(now);
                    dpd.setVersion(DatePickerDialog.Version.VERSION_2);
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                }
            }
        });
            etDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(MainActivity.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    Calendar c = Calendar.getInstance();
                    dpd.setMaxDate(now);
                    dpd.setVersion(DatePickerDialog.Version.VERSION_2);
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                }
            });


    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        int month = monthOfYear +1;
        String date = dayOfMonth +"-" + month + "-" + year;
        etDate.setText(date);
    }
    @OnClick(R.id.btn_cek)
    public void submit() {
        if(isValidate()){
            isLoading (true);
            ApiInterface client = ApiService.createService(ApiInterface.class);
            String nama = etName.getText().toString();
            String date = etDate.getText().toString();
            Call<zodiakModel> call = client.callzodiak(nama,date);
            call.enqueue(new Callback<zodiakModel>() {
                @Override
                public void onResponse(Call<zodiakModel> call, Response<zodiakModel> response) {
                    if (response.isSuccessful()) {
                        isLoading(false);
                        ArrayList<zodiakParcel> zodiakParcels = new ArrayList<zodiakParcel>();
                        zodiakParcels.add(0, getData(response.body()));
                        Intent i = new Intent(MainActivity.this, DetailActivity.class);
                        i.putParcelableArrayListExtra("zodiak", zodiakParcels);

                        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP) {
                            View sharedView = ivlogo;
                            String transitionName = "logo";
                            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,sharedView,transitionName);
                            startActivity(i,activityOptions.toBundle());
                        } else {
                            startActivity(i);
                        }
                    } else {
                        Toast.makeText(MainActivity.this,"Oops Salah", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<zodiakModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_LONG).show();
                    }
            });
        }
    }
    public zodiakParcel getData(zodiakModel response){
        zodiakParcel zodiakParcel = new zodiakParcel();
        zodiakParcel.setNama(response.getNama());
        zodiakParcel.setLahir(response.getLahir());
        zodiakParcel.setUsia(response.getUsia());
        zodiakParcel.setZodiak(response.getZodiak());
        zodiakParcel.setHarianumum(response.getRamalan().getHarian().getUmum());
        zodiakParcel.setHariancintasingle(response.getRamalan().getHarian().getPercintaan().getSingle());
        zodiakParcel.setHariancintacouple(response.getRamalan().getHarian().getPercintaan().getCouple());
        zodiakParcel.setHariankarir(response.getRamalan().getHarian().getKarir_keuangan());
        zodiakParcel.setMingguanumum(response.getRamalan().getMingguan().getUmum());
        return zodiakParcel;
    }
    private boolean isValidate(){
        boolean result = true;
        String name = etName.getText().toString();
        String date = etDate.getText().toString();
        if (name==null || name.trim().length()==0){
            tillName.setError("Nama Tidak Boleh Kosong");
            result = false;
        }else {
            tillName.setErrorEnabled(false);
        }
        if (date==null || date.trim().length()==0){
            tillDate.setError("Tanggal Harus Diisi");
            result = false;
        }else {
            tillDate.setErrorEnabled(false);
        }
        return result;
    }
    private void isLoading(boolean status){
        if (status){
            pb_loading.animate().alpha(1.0f).setDuration(500);
            lin_loading.animate().alpha(0.0f).setDuration(500);
        }else {
            pb_loading.animate().alpha(0.0f).setDuration(500);
            lin_loading.animate().alpha(1.0f).setDuration(500);
        }
    }

}

package com.example.aminsuyanto.tes.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aminsuyanto.tes.R;
import com.example.aminsuyanto.tes.model.zodiakParcel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.tvnama)
    TextView tvnama;
    @BindView(R.id.tvlahir)
    TextView tvlahir;
    @BindView(R.id.tvusia)
    TextView tvusia;
    @BindView(R.id.tvzodiak)
    TextView tvzodiak;
    @BindView(R.id.tvramalanhariini)
    TextView tvramalanhariini;
    @BindView(R.id.tvramalancintahariini)
    TextView tvramalancintahariini;
    @BindView(R.id.tvramalankeuanganhariini)
    TextView tvramalankeuanganhariini;
    @BindView(R.id.tvramalanmingguini)
    TextView tvramalanmingguini;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        ArrayList<zodiakParcel> zodiakParcels = this.getIntent().getParcelableArrayListExtra("zodiak");

        tvnama.setText(zodiakParcels.get(0).getNama());
        tvlahir.setText(zodiakParcels.get(0).getLahir());
        tvusia.setText(zodiakParcels.get(0).getUsia());
        tvzodiak.setText(zodiakParcels.get(0).getZodiak());
        tvramalanhariini.setText(zodiakParcels.get(0).getHarianumum());
        tvramalancintahariini.setText("Kalau Kamu single"+zodiakParcels.get(0).getHariancintasingle()+"Nah kalau kamu punya pacar"+zodiakParcels.get(0).getHariancintacouple());
        tvramalankeuanganhariini.setText(zodiakParcels.get(0).getHariankarir());
        tvramalanmingguini.setText(zodiakParcels.get(0).getMingguanumum());


    }
}

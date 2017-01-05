package example.iksandecade.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.iksandecade.retrofitsample.model.ZodiakParcel;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.tvNama)
    TextView tvNama;
    @BindView(R.id.tvLahir)
    TextView tvLahir;
    @BindView(R.id.tvUsia)
    TextView tvUsia;
    @BindView(R.id.tvZodiak)
    TextView tvZodiak;
    @BindView(R.id.tvRamalan)
    TextView tvRamalan;
    @BindView(R.id.tvCinta)
    TextView tvCinta;
    @BindView(R.id.tvKeuangan)
    TextView tvKeuangan;
    @BindView(R.id.tvRamalanMinggu)
    TextView tvRamalanMinggu;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        ArrayList<ZodiakParcel> zodiakModels = this.getIntent().getParcelableArrayListExtra("zodiak");


        tvNama.setText(zodiakModels.get(0).getNama());
        tvLahir.setText(zodiakModels.get(0).getLahir());
        tvUsia.setText(zodiakModels.get(0).getUsia());
        tvZodiak.setText(zodiakModels.get(0).getZodiak());
        tvRamalan.setText(zodiakModels.get(0).getHarianUmum());
        tvCinta.setText("Kalau kamu single " + zodiakModels.get(0).getHarianCintaSingle() + " Nah, kalau kamu punya pasangan " + zodiakModels.get(0).getHarianCintaCouple());
        tvKeuangan.setText(zodiakModels.get(0).getHarianKarir());
        tvRamalanMinggu.setText(zodiakModels.get(0).getMingguanUmum());
    }
}

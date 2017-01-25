package example.iksandecade.retrofitsample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.iksandecade.retrofitsample.model.ZodiakModel;
import example.iksandecade.retrofitsample.model.ZodiakParcel;
import example.iksandecade.retrofitsample.retrofit.RetrofitSampleClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @BindView(R.id.tilName)
    TextInputLayout tilName;
    @BindView(R.id.tilDate)
    TextInputLayout tilDate;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etDate)
    EditText etDate;
    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    @BindView(R.id.linLoading)
    LinearLayout linLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String data = getIntent().getStringExtra("data");
        if (data != null) {
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        }
        pbLoading.setAlpha(0.0f);
        etDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            MainActivity.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    Calendar c = Calendar.getInstance();
                    dpd.setMaxDate(c);
                    dpd.setVersion(DatePickerDialog.Version.VERSION_2);
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                }
            }
        });
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        MainActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                Calendar c = Calendar.getInstance();
                dpd.setMaxDate(c);
                dpd.setVersion(DatePickerDialog.Version.VERSION_2);
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
    }

    @OnClick(R.id.btnSubmit)
    public void submit() {
        if (isValidate()) {
            isLoading(true);

            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://ibacor.com")
                    .build();
            String nama = etName.getText().toString();
            String date = etDate.getText().toString();
            RetrofitSampleClient client = retrofit.create(RetrofitSampleClient.class);
            Observable<ZodiakModel> call = client.callZodiak(nama, date);
            call.subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ZodiakModel>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            isLoading(false);
                            Toast.makeText(MainActivity.this, "Opps, Something wrong", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNext(ZodiakModel zodiakModel) {
                            isLoading(false);
                            ArrayList<ZodiakParcel> zodiakParcels = new ArrayList<ZodiakParcel>();
                            zodiakParcels.add(0, getData(zodiakModel));
                            Intent i = new Intent(MainActivity.this, DetailActivity.class);
                            i.putParcelableArrayListExtra("zodiak", zodiakParcels);

                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                                View sharedView = ivLogo;
                                String transitionName = "logo";
                                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, sharedView, transitionName);
                                startActivity(i, activityOptions.toBundle());
                            } else {
                                startActivity(i);
                            }
                        }
                    });

        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        int month = monthOfYear + 1;
        String date = dayOfMonth + "-" + month + "-" + year;
        etDate.setText(date);
    }

    public ZodiakParcel getData(ZodiakModel response) {
        ZodiakParcel zodiakParcel = new ZodiakParcel();
        zodiakParcel.setNama(response.getNama());
        zodiakParcel.setLahir(response.getLahir());
        zodiakParcel.setUsia(response.getUsia());
        zodiakParcel.setZodiak(response.getZodiak());
        zodiakParcel.setHarianUmum(response.getRamalan().getHarian().getUmum());
        zodiakParcel.setHarianCintaSingle(response.getRamalan().getHarian().getPercintaan().getSingle());
        zodiakParcel.setHarianCintaCouple(response.getRamalan().getHarian().getPercintaan().getCouple());
        zodiakParcel.setHarianKarir(response.getRamalan().getHarian().getKarirKeuangan());
        zodiakParcel.setMingguanUmum(response.getRamalan().getMingguan().getUmum());

        return zodiakParcel;

    }

    private boolean isValidate() {
        boolean result = true;

        String name = etName.getText().toString();
        String date = etDate.getText().toString();

        if (name == null || name.trim().length() == 0) {
            tilName.setError("Nama tidak boleh kosong");
            result = false;
        } else {
            tilName.setErrorEnabled(false);
        }

        if (date == null || date.trim().length() == 0) {
            tilDate.setError("Tanggal harus diisi");
            result = false;
        } else {
            tilName.setErrorEnabled(false);
        }

        return result;
    }

    private void isLoading(boolean status) {
        if (status) {
            pbLoading.animate().alpha(1.0f).setDuration(500);
            linLoading.animate().alpha(0.0f).setDuration(500);
        } else {
            pbLoading.animate().alpha(0.0f).setDuration(500);
            linLoading.animate().alpha(1.0f).setDuration(500);
        }
    }
}

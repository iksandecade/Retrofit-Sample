package example.iksandecade.retrofitsample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by
 * Name         : Ihksan Sukmawan
 * Alias        : iksandecade
 * Email        : iksandecade@gmail.com
 * Company      : Meridian.id
 * Date         : 05-Jan-17
 * Project      : MyApplication
 */

public class ZodiakParcel implements Parcelable {
    String nama;
    String lahir;
    String usia;
    String zodiak;
    String harianUmum;
    String harianCintaSingle;
    String harianCintaCouple;
    String harianKarir;
    String mingguanUmum;

    public ZodiakParcel() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getZodiak() {
        return zodiak;
    }

    public void setZodiak(String zodiak) {
        this.zodiak = zodiak;
    }

    public String getHarianUmum() {
        return harianUmum;
    }

    public void setHarianUmum(String harianUmum) {
        this.harianUmum = harianUmum;
    }

    public String getHarianCintaSingle() {
        return harianCintaSingle;
    }

    public void setHarianCintaSingle(String harianCintaSingle) {
        this.harianCintaSingle = harianCintaSingle;
    }

    public String getHarianCintaCouple() {
        return harianCintaCouple;
    }

    public void setHarianCintaCouple(String harianCintaCouple) {
        this.harianCintaCouple = harianCintaCouple;
    }

    public String getHarianKarir() {
        return harianKarir;
    }

    public void setHarianKarir(String harianKarir) {
        this.harianKarir = harianKarir;
    }

    public String getMingguanUmum() {
        return mingguanUmum;
    }

    public void setMingguanUmum(String mingguanUmum) {
        this.mingguanUmum = mingguanUmum;
    }

    protected ZodiakParcel(Parcel in) {
        nama = in.readString();
        lahir = in.readString();
        usia = in.readString();
        zodiak = in.readString();
        harianUmum = in.readString();
        harianCintaSingle = in.readString();
        harianCintaCouple = in.readString();
        harianKarir = in.readString();
        mingguanUmum = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(lahir);
        dest.writeString(usia);
        dest.writeString(zodiak);
        dest.writeString(harianUmum);
        dest.writeString(harianCintaSingle);
        dest.writeString(harianCintaCouple);
        dest.writeString(harianKarir);
        dest.writeString(mingguanUmum);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ZodiakParcel> CREATOR = new Parcelable.Creator<ZodiakParcel>() {
        @Override
        public ZodiakParcel createFromParcel(Parcel in) {
            return new ZodiakParcel(in);
        }

        @Override
        public ZodiakParcel[] newArray(int size) {
            return new ZodiakParcel[size];
        }
    };
}
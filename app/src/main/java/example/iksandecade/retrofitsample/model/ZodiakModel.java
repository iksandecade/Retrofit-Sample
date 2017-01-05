package example.iksandecade.retrofitsample.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by
 * Name         : Ihksan Sukmawan
 * Alias        : iksandecade
 * Email        : iksandecade@gmail.com
 * Company      : Meridian.id
 * Date         : 05-Jan-17
 * Project      : MyApplication
 */

public class ZodiakModel implements Parcelable {
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("lahir")
    @Expose
    private String lahir;
    @SerializedName("usia")
    @Expose
    private String usia;
    @SerializedName("zodiak")
    @Expose
    private String zodiak;
    @SerializedName("ramalan")
    @Expose
    private RamalanModel ramalan;

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

    public RamalanModel getRamalan() {
        return ramalan;
    }

    public void setRamalan(RamalanModel ramalan) {
        this.ramalan = ramalan;
    }

    protected ZodiakModel(Parcel in) {
        nama = in.readString();
        lahir = in.readString();
        usia = in.readString();
        zodiak = in.readString();
        ramalan = (RamalanModel) in.readValue(RamalanModel.class.getClassLoader());
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
        dest.writeValue(ramalan);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ZodiakModel> CREATOR = new Parcelable.Creator<ZodiakModel>() {
        @Override
        public ZodiakModel createFromParcel(Parcel in) {
            return new ZodiakModel(in);
        }

        @Override
        public ZodiakModel[] newArray(int size) {
            return new ZodiakModel[size];
        }
    };
}
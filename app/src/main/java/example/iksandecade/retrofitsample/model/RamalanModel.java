package example.iksandecade.retrofitsample.model;

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

public class RamalanModel {
    @SerializedName("harian")
    @Expose
    private HarianModel harian;
    @SerializedName("mingguan")
    @Expose
    private MingguanModel mingguan;

    public HarianModel getHarian() {
        return harian;
    }

    public void setHarian(HarianModel harian) {
        this.harian = harian;
    }

    public MingguanModel getMingguan() {
        return mingguan;
    }

    public void setMingguan(MingguanModel mingguan) {
        this.mingguan = mingguan;
    }
}

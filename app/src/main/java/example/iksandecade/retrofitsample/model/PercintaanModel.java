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

public class PercintaanModel {
    @SerializedName("single")
    @Expose
    private String single;
    @SerializedName("couple")
    @Expose
    private String couple;

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getCouple() {
        return couple;
    }

    public void setCouple(String couple) {
        this.couple = couple;
    }
}

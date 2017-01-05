package example.iksandecade.retrofitsample.retrofit;

import example.iksandecade.retrofitsample.model.ZodiakModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by
 * Name         : Ihksan Sukmawan
 * Alias        : iksandecade
 * Email        : iksandecade@gmail.com
 * Company      : Meridian.id
 * Date         : 05-Jan-17
 * Project      : MyApplication
 */

public interface RetrofitSampleClient {
    @GET("/api/zodiak")
    Call<ZodiakModel> callZodiak(
            @Query("nama") String nama,
            @Query("tgl") String tanggal
    );
}

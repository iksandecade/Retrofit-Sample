package example.iksandecade.retrofitsample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by
 * Name         : Ihksan Sukmawan
 * Alias        : iksandecade
 * Email        : iksandecade@gmail.com
 * Company      : Meridian.id
 * Date         : 09-Jan-17
 * Project      : MyApplication
 */

public class IntetPlaystoreActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
//        try {
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
//        }
    }
}

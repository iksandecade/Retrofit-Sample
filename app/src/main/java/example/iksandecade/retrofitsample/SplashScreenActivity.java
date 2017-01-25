package example.iksandecade.retrofitsample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.relSplash)
    RelativeLayout relSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        relSplash.setOnClickListener(view -> gotoMain());
    }


    private void gotoMain() {
        Intent i = new Intent(this, MainActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            View sharedView = ivLogo;
            String transitionName = "logo";
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this, sharedView, transitionName);
            startActivity(i, activityOptions.toBundle());
        } else {
            startActivity(i);
        }
    }

}

package com.givenchdy.cvbuilder.cvbuilder.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.givenchdy.cvbuilder.cvbuilder.Controllers.PdfController;
import com.givenchdy.cvbuilder.cvbuilder.Helpers.ContextSingleton;
import com.givenchdy.cvbuilder.cvbuilder.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends Activity {


    @Bind(R.id.logoImageID) ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        ContextSingleton.getInstance().setContext(getApplicationContext());

        Animation scaleAnim = AnimationUtils.loadAnimation(this, R.anim.text_scalein);
        logo.setAnimation(scaleAnim);

        //add the two animation to one animation set
        AnimationSet animationSet = new AnimationSet(true);

        animationSet.addAnimation(scaleAnim);
        animationSet.startNow();

        scaleAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent3 = new Intent(SplashActivity.this, HomeActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //Used to start new activity from non-activity class:
                finish();
                ContextSingleton.getContext().startActivity(intent3);

                PdfController.createCvFolder("cv");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}

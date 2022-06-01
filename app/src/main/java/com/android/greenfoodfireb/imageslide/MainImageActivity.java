package com.android.greenfoodfireb.imageslide;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.android.greenfoodfireb.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainImageActivity extends AppCompatActivity {

    ViewPager viewPager;
    //add images from drawable to array
    int images[] = {R.drawable.login_background, R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5, R.drawable.image_6,R.drawable.image_7, R.drawable.image_8, R.drawable.image_9, R.drawable.image_10, R.drawable.image_12 };

    int currentPageCunter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main_image );

        //find view by id
        viewPager = findViewById(R.id.viewpager);
        //add adapter
        viewPager.setAdapter(new SliderAdapter(images, MainImageActivity.this));

        //auto change image
        final Handler handler = new Handler();
        final Runnable update  = new Runnable() {
            @Override
            public void run() {
                if (currentPageCunter == images.length){
                    currentPageCunter = 0 ;

                }

                viewPager.setCurrentItem(currentPageCunter++,true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },2000,2000);

    }
}







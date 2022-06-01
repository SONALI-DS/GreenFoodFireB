package com.android.greenfoodfireb;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.android.greenfoodfireb.imageslide.SliderAdapter;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {

    SNavigationDrawer sNavigationDrawer;
    int color1=0;
    Class fragmentClass;
    public static Fragment fragment;


    ViewPager viewPager;
    //add images from drawable to array
    int images[] = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5, R.drawable.image_6,R.drawable.image_7, R.drawable.image_8, R.drawable.image_9, R.drawable.image_10, R.drawable.image_12 };

    int currentPageCunter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main2);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List< MenuItem > menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Menu",R.color.orange_500));
        menuItems.add(new MenuItem("My Profile",R.color.orange_500));
        menuItems.add(new MenuItem("Payment Method",R.color.orange_500));
       // menuItems.add(new MenuItem("WishList",R.color.orange_500));
        menuItems.add(new MenuItem("About Us",R.color.orange_500));
        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass =  MainMenuFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();
        }


        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);

                switch (position){
                    case 0:{
                        color1 = R.color.orange_500;
                        fragmentClass = MainMenuFragment.class;
                        break;
                    }
                    case 1:{
                        color1 = R.color.orange_500;
                        fragmentClass = MyProfileFragment.class;
                        break;
                    }
//                    case 2:{
//                        color1 = R.color.white;
//                        fragmentClass = WishListFragment.class;
//                        break;
//                    }
                    case 2:{
                        color1 = R.color.yellow;
                        fragmentClass = PaymentFragment.class;
                        break;
                    }
                    case 3:{
                        color1 = R.color.red;
                        fragmentClass = AboutUsFragment.class;
                        break;
                    }

                }
                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening(){

                    }

                    @Override
                    public void onDrawerClosing(){
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State "+newState);
                    }
                });
            }
        });


        //find view by id
        viewPager = findViewById(R.id.viewpager);
        //add adapter
        viewPager.setAdapter(new SliderAdapter(images, this));

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

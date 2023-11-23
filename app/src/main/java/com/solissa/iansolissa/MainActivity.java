package com.solissa.iansolissa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.sql.SQLOutput;



public class MainActivity extends AppCompatActivity {

    public class logo{

        public ImageView logoapk;
        public  View decorView;
      public Animation animation;

//      method inisialisasi
       public void inisialisasi(){
           this.logoapk=(ImageView) findViewById(R.id.splash_logo);
           this.decorView = getWindow().getDecorView();
       }

        //      method implementasi
       public void implementasi(){
           this.logoapk.startAnimation(logo.this.animation);
       }
        //      method hide status bar
       public void hidestatusbar(){
           this.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
       }

        //      method hide action bar
       public void hideactionbar(){
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
        }


//      method timer
        public void timer(){

         new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, login.class));
                finish();
            }
        }, 5000);

        }
    }


@Override
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    logo ian = new logo();
//        inisisalisasi objek -> mengkonseksikan variabel widget dengan object sesungguhnya
    ian.inisialisasi();
//                summber animasi ada dimana
    ian.animation = AnimationUtils.loadAnimation(this , R.anim.fade);

//        implementasi animasi
      ian.implementasi();
        // inisialisasi view

        // Hide the status bar.
       ian.hidestatusbar();
        // Hide ActionBar
     ian.hideactionbar();

        // timer
       ian.timer();



    }

}
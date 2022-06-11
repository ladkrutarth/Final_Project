package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  private Button button;
   MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //now we can create two types of slider first using viewpager
        //and another using third party library which is easy to use let's get started
        ImageSlider imageSlider = findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://picsum.photos/id/896/300/200", "Image 1"));
        slideModels.add(new SlideModel("https://picsum.photos/id/894/300/200", "Image 2"));
        slideModels.add(new SlideModel("https://picsum.photos/id/892/300/200", "Image 3"));
        slideModels.add(new SlideModel("https://picsum.photos/id/891/300/200", "Image 4"));
        imageSlider.setImageList(slideModels, true);
         button = (Button) findViewById(R.id.btn);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                 startActivity(intent);
             }
         });


    }

    public  void play(View v)
    {
        if (mp == null)
        {
            mp = MediaPlayer.create(this,R.raw.audio);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        mp.start();
    }
    public  void  Pause(View v)
    {
          if (mp!= null)
          {
              mp.pause();
          }
    }
    public void Stop(View v)
    {
        stopPlayer();
    }
     private void stopPlayer()
     {
         if (mp!=null)
         {
             mp.release();
             mp = null;
             Toast.makeText(this,"MediaPlayer released",Toast.LENGTH_LONG).show();
         }
     }

     protected void onStop()
     {
        super.onStop();
        stopPlayer();
     }
    }
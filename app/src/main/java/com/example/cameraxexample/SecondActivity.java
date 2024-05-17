package com.example.cameraxexample;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class SecondActivity extends AppCompatActivity {


    ImageView takenimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scond_activity);

        takenimage=findViewById(R.id.takenimage);

        Intent intent = getIntent();
        String data = intent.getStringExtra("uri");

        Log.d("ameen","Second Activity"+ data);

        Glide.with(this).load(data).addListener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, @Nullable Object o, @NonNull Target<Drawable> target, boolean b) {
                Log.d("ameen","Second Failed");

                return false;
            }

            @Override
            public boolean onResourceReady(@NonNull Drawable drawable, @NonNull Object o, Target<Drawable> target, @NonNull DataSource dataSource, boolean b) {
                Log.d("ameen","Second ready"+ data);
                return false;
            }
        }).into(takenimage);


    }
}
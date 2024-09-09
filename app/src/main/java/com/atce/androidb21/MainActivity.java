package com.atce.androidb21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    TextView txtName;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName=findViewById(R.id.txtName);
        txtName.setText(R.string.text);
        img=findViewById(R.id.img);
        String imUrl="https://b9.dd.icdn.ru/c/cotton-candy/0/imgsrc.ru_35139200JlE.jpg";
//        img.setImageResource(R.drawable.baseline_favorite_24);
//        Picasso.get().load(R.drawable.baseline_favorite_24).into(img);
        Picasso.get().load(imUrl).into(img);



    }
}
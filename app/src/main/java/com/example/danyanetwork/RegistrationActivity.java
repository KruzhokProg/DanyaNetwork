package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    Animation anim, anim2;
    EditText etAnim;
    Button btn123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etAnim = findViewById(R.id.etAnim);
        btn123 = findViewById(R.id.btn123);
    }

    public void btn123(View view) {
        anim =  AnimationUtils.loadAnimation(this, R.anim.et_move);
        anim2 =  AnimationUtils.loadAnimation(this, R.anim.tbn_move);
        etAnim.setVisibility(View.VISIBLE);
        etAnim.setAnimation(anim);
        btn123.setAnimation(anim2);
    }
}
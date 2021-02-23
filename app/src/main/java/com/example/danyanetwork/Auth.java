package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Auth extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setClickable(false);


        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( s.toString().contains("@") && s.toString().contains(".")){
                    btnNext.setClickable(true);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextValidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.white));
                }
                else{
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void btnNextClick(View view) {
    }

    public void btnForgetClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog = builder.create();
        final View customLayout = getLayoutInflater().inflate(R.layout.forget_emai_dialog, null);
        Button btnSendEmail = customLayout.findViewById(R.id.btnSendEmailRecover);
        EditText etEmailRecover = customLayout.findViewById(R.id.etEmailDialog);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{etEmailRecover.getText().toString()});
                i.putExtra(Intent.EXTRA_SUBJECT, "Email recover from android");
                i.putExtra(Intent.EXTRA_TEXT   , "follow link");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        builder.setTitle( "Восстановить пароль")
//                .setView(customLayout)
//                .setPositiveButton("Отправить", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        EditText editText = customLayout.findViewById(R.id.etEmailDialog);
//
//                    }
//        });

        dialog.setTitle("Восстановление пароля");
        dialog.setView(customLayout);
        dialog.show();
    }

    public void goToReg(View view) {
        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }
}
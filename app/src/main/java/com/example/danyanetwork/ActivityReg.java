package com.example.danyanetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.TransitionManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.danyanetwork.Model.RegInfo;
import com.example.danyanetwork.Network.ApiClient;
import com.example.danyanetwork.Network.ApiService;

import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityReg extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");

    EditText etEmailReg, etPasswordReg, etPasswordConfirm, etCompanyName;
    Button btnNext, btnType;
    boolean isEmailValid, isPassValid, isPassConfirmValid, isGone;
    ImageView imgvPass, imgvPassConfirm, imgvEmail;
    Integer roleId;
    ConstraintLayout trans_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imgvEmail = findViewById(R.id.imgvCloseEmail);
        imgvPass = findViewById(R.id.imgvPassword);
        imgvPassConfirm = findViewById(R.id.imgvClosePassConfirm);
        etEmailReg = findViewById(R.id.etEmailReg);
        etPasswordReg = findViewById(R.id.etPassReg);
        btnNext = findViewById(R.id.btnNextReg);
        trans_layout = findViewById(R.id.transition_container);
        btnType = findViewById(R.id.btnType);
        btnNext.setClickable(false);
        isEmailValid = false;
        isPassValid = false;
        roleId = 1;
        etCompanyName = findViewById(R.id.etCompanyName);

        etEmailReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String emailInputReg = s.toString();


                if (emailInputReg.isEmpty()){
                    isEmailValid = false;
                }
                else if (s.toString().contains("@") && s.toString().contains(".")) {
                    isEmailValid = true;
                }
                else{
                    isEmailValid = false;
                }

                if(isEmailValid == false){
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                    imgvEmail.setVisibility(View.VISIBLE);
                }
                else{
                    imgvEmail.setVisibility(View.INVISIBLE);
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        etPasswordReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String passwordInputReg = etPasswordReg.getEditableText().toString().trim();

                if (isEmailValid = true) {
                    imgvEmail.setVisibility(View.INVISIBLE);
                }

                if (passwordInputReg.isEmpty()) {
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                    isPassValid = false;
                    imgvPass.setVisibility(View.VISIBLE);
                } else if (!PASSWORD_PATTERN.matcher(passwordInputReg).matches()) {
                    btnNext.setClickable(false);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextInvalidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.btnNextInvalidTextColor));
                    isPassValid = false;
                    imgvPass.setVisibility(View.VISIBLE);
                } else if (PASSWORD_PATTERN.matcher(passwordInputReg).matches() && isEmailValid == true) {
                    btnNext.setClickable(true);
                    btnNext.setBackgroundColor(getResources().getColor(R.color.btnNextValidColorBack));
                    btnNext.setTextColor(getResources().getColor(R.color.white));
                    isPassValid = true;
                    etPasswordReg.setError(null);
                    imgvPass.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void Registration(View view) {
        RegInfo r = new RegInfo();
        String Email = etEmailReg.getText().toString();
        String Password = etPasswordReg.getText().toString();
        Integer RoleId = 1;
        String PhoneNumber = "123";
        String CompanyName = "test";
        r.setEmail(Email);
        r.setPassword(Password);
        r.setRoleId(RoleId);
        r.setPhoneNumber(PhoneNumber);
        r.setCompanyName(CompanyName);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ResponseBody> call = apiService.createUser(r);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(ActivityReg.this, "Добро пожаловать " + etEmailReg.getText().toString(), Toast.LENGTH_SHORT).show();
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(ActivityReg.this, Auth.class);
                        startActivity(i);
                    }
                }, 1500);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(ActivityReg.this, "Ошибка: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnType_Click(View view) {
        TransitionManager.beginDelayedTransition(trans_layout);
        isGone = !isGone;
        if(isGone){
            etCompanyName.setVisibility(View.GONE);
            btnType.setText("Я компания");
        }
        else{
            etCompanyName.setVisibility(View.VISIBLE);
            btnType.setText("Я частник");
        }

    }
}
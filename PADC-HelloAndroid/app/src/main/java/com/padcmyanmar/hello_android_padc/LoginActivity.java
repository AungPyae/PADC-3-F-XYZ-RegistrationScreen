package com.padcmyanmar.hello_android_padc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by aung on 11/5/17.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String CORRECT_EMAIL = "abc@gmail.com";
    private static final String CORRECT_PASSWORD = "Abcdefg"; //Constant Attribute

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgetPassword;
    private TextView btnToRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassword = findViewById(R.id.et_password);
        btnForgetPassword = findViewById(R.id.btn_forget_password);
        btnToRegister = findViewById(R.id.btn_to_register);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailOrPhone = etEmailOrPhone.getText().toString();
                String password = etPassword.getText().toString();

                if(TextUtils.isEmpty(emailOrPhone)) {
                    etEmailOrPhone.setError("Email or phone cannot be empty.");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    etPassword.setError("Password cannot be empty.");
                    return;
                }

                if(TextUtils.equals(emailOrPhone, CORRECT_EMAIL)
                        && TextUtils.equals(password, CORRECT_PASSWORD)) {
                    //Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    Intent intent = HelloAndroidActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                } else {
                    Snackbar.make(v, "Incorrect email or password. Please try again.",
                            Snackbar.LENGTH_INDEFINITE).show();
                }

                //Snackbar.make(v, "Login button clicked.", Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        btnToRegister = findViewById(R.id.btn_to_register);
        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RegisterActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }
}

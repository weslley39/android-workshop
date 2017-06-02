package com.weslleyneri.gestta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {
    final static String TAG = Login.class.getSimpleName();

    @BindView(R.id.activity_login_input_user) protected EditText editText;
    @BindView(R.id.activity_login_input_pass) protected EditText editTextPass;
    @BindView(R.id.activity_login_button_enter) protected Button buttonEnter;
    @BindView(R.id.activity_login_button_forgot) protected Button buttonForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_login_button_enter)
    protected void performLogin() {
        Log.d(TAG, "User: " + editText.getText().toString());
        Log.d(TAG, "Pass: " + editTextPass.getText().toString());

    }

}

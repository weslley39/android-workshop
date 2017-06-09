package io.redspark.gestta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    final static String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.activity_login_input_user)
    protected TextInputLayout editTextUser;
    @BindView(R.id.activity_login_input_pass)
    protected TextInputLayout editTextPass;
    @BindView(R.id.activity_login_button_enter)
    protected Button buttonEnter;
    @BindView(R.id.activity_login_button_forgot)
    protected Button buttonForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            editTextUser.getEditText().setText(savedInstanceState.getString("usuario"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("usuario", editTextUser.getEditText().getText().toString());
        outState.putString("pass", editTextPass.getEditText().getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        editTextUser.getEditText().setText(savedInstanceState.getString("usuario"));
    }

    @OnClick(R.id.activity_login_button_enter)
    protected void performLogin() {
        Intent goToMain = new Intent(this, MainActivity.class);
        goToMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(goToMain);
    }

    @OnClick(R.id.activity_login_button_forgot)
    protected void openForgotActivity() {
        Intent goToForgot = new Intent(this, ForgotPassActivity.class);
        startActivity(goToForgot);
    }
}

package io.redspark.gestta;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends AppCompatActivity {

    static final private String TAG = ForgotPasswordActivity.class.getSimpleName();

    @BindView(R.id.activity_forgot_input_email)
    protected TextInputLayout mInputLayoutEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_forgot_button_recovery)
    protected void sendEmailToRecoveryPassword() {
        Log.d(TAG, "Recuperar senha");

        finish();
    }
}

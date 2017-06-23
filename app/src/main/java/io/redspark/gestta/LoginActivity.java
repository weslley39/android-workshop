package io.redspark.gestta;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.redspark.gestta.database.User;
import io.redspark.gestta.managers.LoginManager;
import io.redspark.gestta.restfull.utils.IServiceResponse;

public class LoginActivity extends AppCompatActivity {

    static final private String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.activity_login_input_layout_user)
    protected TextInputLayout mInputLayoutUser;

    @BindView(R.id.activity_login_input_layout_password)
    protected TextInputLayout mInputLayoutPassword;

    private final LoginManager mLoginManager = new LoginManager();
    private MaterialDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);


    }

    @OnClick(R.id.activity_login_button_enter)
    protected void performLogin() {
        String user = mInputLayoutUser.getEditText().getText().toString();
        String password = mInputLayoutPassword.getEditText().getText().toString();

        Log.d(TAG, "Perform Login - User: " + user + " | Password: " + password);

        mProgressDialog = new MaterialDialog.Builder(this)
                .cancelable(false)
                .widgetColorRes(R.color.primaryButton)
                .title("Aguarde")
                .content("Processando dados")
                .progress(true, 0)
                .show();

        mLoginManager.performLogin(user, password, new IServiceResponse<User>() {
            @Override
            public void onSuccess(User data) {
                mProgressDialog.dismiss();

                Toast.makeText(LoginActivity.this, "Bem Vindo " + data.getName(), Toast.LENGTH_LONG).show();

                Intent goToMain = new Intent(LoginActivity.this, MainActivity.class);
                goToMain.addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK
                );
                startActivity(goToMain);
            }

            @Override
            public void onError(String error) {
                mProgressDialog.dismiss();
                Log.e(TAG, error);
            }
        });
    }

    @OnClick(R.id.activity_login_button_forgot)
    protected void openForgotPasswordScreen() {
        Intent goToForgotPassword = new Intent(this, ForgotPasswordActivity.class);
        startActivity(goToForgotPassword);
    }
}

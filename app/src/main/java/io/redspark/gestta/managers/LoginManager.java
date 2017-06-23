package io.redspark.gestta.managers;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import io.redspark.gestta.database.User;
import io.redspark.gestta.restfull.services.LoginService;
import io.redspark.gestta.restfull.services.UserService;
import io.redspark.gestta.restfull.utils.IServiceResponse;
import io.redspark.gestta.utils.GesttaApplication;

/**
 * Created by weslleyneri on 22/06/15.
 */

public class LoginManager {

    private static final String TOKEN_KEY = "io.redspark.gestta.token";

    public static String getToken() {
        SharedPreferences sharedPreferences = GesttaApplication.getPreferences();
        String token = sharedPreferences.getString(TOKEN_KEY, "");
        return token;
    }

    private void setToken(String token) {
        SharedPreferences sharedPreferences = GesttaApplication.getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN_KEY, token);
        editor.apply();
    }

    private final String TAG = LoginManager.class.getSimpleName();

    public void performLogin(String user, String password, final IServiceResponse<User> callback) {
        new LoginService().login(user, password, new IServiceResponse<String>() {
            @Override
            public void onSuccess(String data) {
                Log.e(TAG, "Token: " + data);
                setToken(data);
                getUser(callback);
            }

            @Override
            public void onError(String error) {
                Log.e(TAG, error);
             }
        });
    }

    private void getUser(final IServiceResponse<User> callback) {
        new UserService().me(new IServiceResponse<User>() {
            @Override
            public void onSuccess(User data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

}

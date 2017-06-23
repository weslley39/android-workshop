package io.redspark.gestta.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.orm.SugarContext;

/**
 * Created by weslleyneri on 22/06/15.
 */

public class GesttaApplication extends Application {

    public static GesttaApplication application;
    public static SharedPreferences getPreferences() {
        return application.getSharedPreferences("io.redspark.gestta.preferences", Context.MODE_PRIVATE);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
        GesttaApplication.application = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}

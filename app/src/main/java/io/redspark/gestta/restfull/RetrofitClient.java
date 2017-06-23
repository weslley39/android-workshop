package io.redspark.gestta.restfull;

import java.io.IOException;

import io.redspark.gestta.BuildConfig;
import io.redspark.gestta.managers.LoginManager;
import io.redspark.gestta.utils.GesttaApplication;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by weslleyneri on 22/06/15.
 */

public class RetrofitClient {

    public static Retrofit newInstance() {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.addConverterFactory(JacksonConverterFactory.create());
        retrofitBuilder.baseUrl(BuildConfig.BASE_URL);

        final String token = LoginManager.getToken();
        if (!token.isEmpty()) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder requestBuilder = chain.request().newBuilder();
                            requestBuilder.addHeader("Authorization", token);
                            Request request = requestBuilder.build();
                            return chain.proceed(request);
                        }
                    }).build();

            retrofitBuilder.client(client);
        }

        return retrofitBuilder.build();
    }

}

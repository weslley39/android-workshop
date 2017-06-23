package io.redspark.gestta.restfull.services;

import io.redspark.gestta.restfull.RetrofitClient;
import io.redspark.gestta.restfull.interfaces.ILoginService;
import io.redspark.gestta.restfull.utils.IServiceResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by weslleyneri on 22/06/15.
 */

public class LoginService {

    public Call<ResponseBody> login(String email, String password, final IServiceResponse<String> callback) {
        Retrofit retrofit = RetrofitClient.newInstance();
        ILoginService service = retrofit.create(ILoginService.class);

        Call<ResponseBody> call = service.doLogin(email, password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    String token = response.headers().get("Authorization");
                    callback.onSuccess(token);
                } else {
                    callback.onError("Não autorizado");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onError(t.toString());
            }

        });

        return call;
    }

}

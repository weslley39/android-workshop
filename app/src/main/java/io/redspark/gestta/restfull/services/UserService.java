package io.redspark.gestta.restfull.services;

import io.redspark.gestta.database.User;
import io.redspark.gestta.restfull.RetrofitClient;
import io.redspark.gestta.restfull.interfaces.IUserService;
import io.redspark.gestta.restfull.utils.IServiceResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by weslleyneri on 22/06/15.
 */

public class UserService {

    public Call<User> me(final IServiceResponse<User> callback) {
        Retrofit retrofit = RetrofitClient.newInstance();
        IUserService service = retrofit.create(IUserService.class);

        Call<User> call= service.me();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Invalid Request");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onError(t.toString());
            }
        });

        return call;
    }

}

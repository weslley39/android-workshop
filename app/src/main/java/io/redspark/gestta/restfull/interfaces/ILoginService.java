package io.redspark.gestta.restfull.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by weslleyneri on 22/06/15.
 */

public interface ILoginService {

    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    @FormUrlEncoded
    @POST("core/login")
    Call<ResponseBody> doLogin(
            @Field("email") String email,
            @Field("password") String password
    );

}

package io.redspark.gestta.restfull.interfaces;

import io.redspark.gestta.database.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by weslleyneri on 22/06/15.
 */

public interface IUserService {

    @GET("core/company/user/me")
    Call<User> me();

}

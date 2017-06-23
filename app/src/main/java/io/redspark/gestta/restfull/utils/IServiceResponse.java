package io.redspark.gestta.restfull.utils;

/**
 * Created by weslleyneri on 22/06/15.
 */

public interface IServiceResponse<T> {

    void onSuccess(T data);
    void onError(String error);

}

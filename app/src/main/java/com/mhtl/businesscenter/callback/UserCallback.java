package com.mhtl.businesscenter.callback;

import com.google.gson.Gson;
import com.mhtl.businesscenter.model.UserAccount;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * Created by liuwei on 7/5/16.
 */
public abstract  class UserCallback extends Callback<UserAccount>{
    @Override
    public UserAccount parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        UserAccount user = new Gson().fromJson(string, UserAccount.class);
        return user;
    }
}

package com.mhtl.businesscenter.services;

import com.mhtl.businesscenter.utils.DataUtils;

/**
 * Created by liuwei on 7/5/16.
 */
public class LoginStatus {

    public static boolean isLogin() {
        boolean isLogin = false;

        isLogin = DataUtils.getLoginState();
        return isLogin;
    }

    public static void setLogin(boolean isLogin) {
        DataUtils.setLoginState(isLogin);
    }

}

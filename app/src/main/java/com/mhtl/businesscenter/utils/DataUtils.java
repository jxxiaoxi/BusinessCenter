package com.mhtl.businesscenter.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.mhtl.businesscenter.BusinessCenterApplication;

/**
 * Created by liuwei on 7/5/16.
 */
public class DataUtils {
    private static SharedPreferences mInfo;

    //获得SharedPreferences实例
    private static SharedPreferences getSharePreferences() {
        if (mInfo == null) {
            Context context = BusinessCenterApplication.getContext();
            mInfo = context != null ? context.getSharedPreferences("appInfo", Context.MODE_APPEND) : null;
        }
        return mInfo;
    }

    public static void setLoginState(boolean state) {
        getSharePreferences().edit().putBoolean("login_state", state).commit();
    }

    public static boolean getLoginState() {
        return getSharePreferences().getBoolean("login_state", false);
    }


}

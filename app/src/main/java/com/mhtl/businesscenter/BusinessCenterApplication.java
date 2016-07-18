package com.mhtl.businesscenter;

import android.app.Application;
import android.content.Context;

/**
 * Created by liuwei on 6/6/16.
 */
public class BusinessCenterApplication extends Application {
    private static BusinessCenterApplication mAiiApp = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mAiiApp = this;
    }

    public static Context getContext() {
        if (mAiiApp != null)
            return mAiiApp.getApplicationContext();
        else
            return null;
    }
}



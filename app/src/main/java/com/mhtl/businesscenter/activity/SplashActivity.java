package com.mhtl.businesscenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.mhtl.businesscenter.R;
import com.mhtl.businesscenter.services.LoginStatus;

public class SplashActivity extends BaseActivity {
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        toMainOrLogin();
    }

    /**
     * @author lw
     * create at 7/4/16 3:02 PM
     * function :判断用户是否已登入
     */
    private void toMainOrLogin() {
        //mHandler.postDelayed(mRunnable, 3000);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }

    @Override
    public boolean isFullScreen() {
        return true;
    }


    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (LoginStatus.isLogin()) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }

            SplashActivity.this.finish();
        }
    };
}

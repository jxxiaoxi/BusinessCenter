package com.mhtl.businesscenter.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.mhtl.businesscenter.R;
import com.mhtl.businesscenter.model.HomeTab;
import com.mhtl.businesscenter.utils.Constant;
import com.mhtl.businesscenter.utils.LogUtils;
import com.mhtl.businesscenter.utils.SystemUtils;
import com.mhtl.businesscenter.widget.AppUpdatePop;
import com.mhtl.businesscenter.widget.CustomFragmentTabHost;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {
    private CustomFragmentTabHost mTabHost;
    public static final String TAG = "MainActivity";
    private AppUpdatePop appUpdatePop;
    FrameLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost = (CustomFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        //mTabHost.getTabWidget().setDividerDrawable(null);
        initTabs();
        mTabHost.setOnTabChangedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // checkAppUpdate();
    }

    private void initTabs() {
        HomeTab[] tabs = HomeTab.values();
        for (int i = 0; i < tabs.length; i++) {
            HomeTab tab = tabs[i];
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getResName()));
            View indicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            ImageView pic = (ImageView) indicator.findViewById(R.id.tab_pic);

            Drawable icon = getResources().getDrawable(tab.getResIcon());
            title.setText(getString(tab.getResName()));
            pic.setImageDrawable(icon);

            tabSpec.setIndicator(indicator);
            tabSpec.setContent(new TabHost.TabContentFactory() {
                @Override
                public View createTabContent(String s) {
                    return new View(MainActivity.this);
                }
            });
            mTabHost.addTab(tabSpec, tab.getClz(), null);
        }
    }

    @Override
    public void onTabChanged(String s) {
        LogUtils.e(TAG, "tab : " + s);
    }

    private void checkAppUpdate() {
        int appVersion = SystemUtils.getVersionCode(this);
        LogUtils.e(TAG, appVersion + "");
        OkHttpUtils
                .post()
                .url(Constant.HOST)
                .addParams("app_version_number", Integer.toString(appVersion))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        //update apk
                        if (true) {
                            new Handler().postDelayed(new Runnable() {//Unable to add window -- token null is not valid; is your activity running?

                                @Override
                                public void run() {
                                    showUpdatePop("www.baidu.com", "appVersion", "appInfo");
                                }
                            }, 1500);
                        }

                    }
                });
    }

    private void showUpdatePop(String appUrl, String appVersion, String appInfo) {
        if (appUpdatePop == null) {
            appUpdatePop = new AppUpdatePop(this, appUrl, appVersion, appInfo);
        }
        LogUtils.e("liuwei", "showUpdatePop : " + findViewById(R.id.main) + "  ;appUpdatePop :  " + appUpdatePop);
        appUpdatePop.showAtLocation(findViewById(R.id.main), Gravity.CENTER, 0, 0);
    }
}

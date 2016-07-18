package com.mhtl.businesscenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.mhtl.businesscenter.R;
import com.umeng.analytics.MobclickAgent;

public class BaseActivity extends AppCompatActivity {
    public enum TransitionMode {
        LEFT, RIGHT, TOP, BOTTOM, SCALE_FADE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (openOverridePendingTransition()) {
            if (null == getOverridePendingTransitionMode()) {
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
            } else {
                switch (getOverridePendingTransitionMode()) {

                    case LEFT:
                        overridePendingTransition(R.anim.left_in, R.anim.right_out);
                        break;
                    case RIGHT:
                        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
                        break;
                    case TOP:
                        overridePendingTransition(R.anim.top_in, R.anim.bottom_out);
                        break;
                    case BOTTOM:
                        overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
                        break;
                    case SCALE_FADE:
                        overridePendingTransition(R.anim.scale_fade_in, 0);
                        break;

                }
            }

        }

        super.onCreate(savedInstanceState);
        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_base);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public boolean isFullScreen() {
        return false;
    }

    /**
     * 是否开启Activity跳转动画
     *
     * @return true开启Activity跳转动画，false不开启Activity跳转动画
     */
    public boolean openOverridePendingTransition() {
        return true;
    }

    /**
     * Activity跳转动画模式，默认为TransitionMode.RIGHT 右侧进入左侧退出
     *
     * @return
     */
    public TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override
    public void finish() {
        super.finish();
        if (openOverridePendingTransition()) {

            if (null == getOverridePendingTransitionMode()) {
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
            } else {
                switch (getOverridePendingTransitionMode()) {

                    case LEFT:
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                        break;
                    case RIGHT:
                        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);
                        break;
                    case TOP:
                        overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
                        break;
                    case BOTTOM:
                        overridePendingTransition(R.anim.top_in, R.anim.bottom_out);
                        break;
                    case SCALE_FADE:
                        overridePendingTransition(0, R.anim.scale_fade_out);
                        break;


                }
            }

        }
    }
}

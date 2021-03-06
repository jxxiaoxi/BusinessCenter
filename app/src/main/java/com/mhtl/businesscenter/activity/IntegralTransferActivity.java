package com.mhtl.businesscenter.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

import com.mhtl.businesscenter.R;

import org.w3c.dom.Text;

/*
* 积分转账
*
**/

public class IntegralTransferActivity extends BaseActivity {
    private TextView tv_100, tv_200, tv_300, tv_400, tv_500, tv_600, tv_700, tv_1000, tv_2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_transfer);
        initUI();
    }

    private void initUI() {
        tv_100 = (TextView) findViewById(R.id.tv_100);
        setPartTextColor(tv_100);
        tv_200 = (TextView) findViewById(R.id.tv_200);
        setPartTextColor(tv_200);
        tv_300 = (TextView) findViewById(R.id.tv_300);
        setPartTextColor(tv_300);
        tv_400 = (TextView) findViewById(R.id.tv_400);
        setPartTextColor(tv_400);
        tv_500 = (TextView) findViewById(R.id.tv_500);
        setPartTextColor(tv_500);
        tv_600 = (TextView) findViewById(R.id.tv_600);
        setPartTextColor(tv_600);
        tv_700 = (TextView) findViewById(R.id.tv_700);
        setPartTextColor(tv_700);
        tv_1000 = (TextView) findViewById(R.id.tv_1000);
        setPartTextColor(tv_1000);
        tv_2000 = (TextView) findViewById(R.id.tv_2000);
        setPartTextColor(tv_2000);

    }
}

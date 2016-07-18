package com.mhtl.businesscenter.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mhtl.businesscenter.R;

public class CustomProgressDialog  extends Dialog {

    private final static String DEFAULT_LOADING_TEXT = "正在加载...";

    public CustomProgressDialog(Context context , String message) {
        this(context, R.style.CustomProgressDialog,message);
    }

    public CustomProgressDialog(Context context, int themeResId , String message) {
        super(context, themeResId);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_loading, null);
        TextView textView = (TextView) view.findViewById(R.id.id_tv_loadingmsg);
        if(!TextUtils.isEmpty(message)){
            textView.setText(message);
        }else{
            textView.setText(DEFAULT_LOADING_TEXT);
        }
        this.setContentView(view);
    }

}

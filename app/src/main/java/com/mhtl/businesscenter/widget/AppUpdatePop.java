package com.mhtl.businesscenter.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mhtl.businesscenter.R;

/**
 * Created by liuwei on 7/7/16.
 */
public class AppUpdatePop  extends PopupWindow {

    public AppUpdatePop(Context context, final String appUrl, String appVersion, String appInfo) {
        super();
        View parent = LayoutInflater.from(context).inflate(R.layout.pop_app_update, null);
        this.setContentView(parent);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x80000000);
        this.setBackgroundDrawable(dw);
        TextView tv_version = (TextView) parent.findViewById(R.id.popup_update_version);
        TextView tv_info = (TextView) parent.findViewById(R.id.popup_update_content);
        TextView tv_cancle = (TextView) parent.findViewById(R.id.popup_update_cancel);
        TextView tv_ok = (TextView) parent.findViewById(R.id.popup_update_ok);
        if (TextUtils.isEmpty(appVersion)) {
            tv_version.setText(context.getString(R.string.app_update_version_default));
        } else {
            tv_version.setText(String.format(context.getString(R.string.app_update_version), appVersion));
        }
        if (TextUtils.isEmpty(appInfo)) {
            tv_info.setText(context.getString(R.string.app_update_info_default));
        } else {
            tv_info.setText(String.format(context.getString(R.string.app_update_info), appInfo));
        }

        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                     }
        });
    }
}

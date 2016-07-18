package com.mhtl.businesscenter.utils;

import android.content.Context;
import android.content.DialogInterface;

import com.mhtl.businesscenter.widget.CustomProgressDialog;

/**
 * Created by liuwei on 7/5/16.
 */
public class DialogHelper  {


    /**
     * 获取一个耗时等待对话框
     * @param context
     * @param msg
     * @param onCancelListener
     * @return
     */
    public static CustomProgressDialog showLoadingDialog(Context context , String msg , DialogInterface.OnCancelListener onCancelListener){
        return showLoadingDialog(context,true,msg,onCancelListener);
    }

    /**
     * 获取一个耗时等待对话框
     * @param context
     * @param canCancelOutside 是否可以取消,true表示可以取消，false不可以取消此时设置OnCanceListener无效
     * @param msg
     * @param onCancelListener
     * @return
     */
    public static CustomProgressDialog showLoadingDialog(Context context , boolean canCancelOutside , String msg , DialogInterface.OnCancelListener onCancelListener){

        try{
            CustomProgressDialog waitDialog = new CustomProgressDialog(context,msg);
            waitDialog.setCanceledOnTouchOutside(canCancelOutside);
            if(onCancelListener != null && canCancelOutside){
                waitDialog.setOnCancelListener(onCancelListener);
            }
            waitDialog.show();

            return waitDialog ;
        }catch (Exception e){
            e.printStackTrace();
        }


        return null ;
    }

    public static void dismissCustomProgressDialog(CustomProgressDialog dialog){
        if(dialog!= null){
            dialog.dismiss();
            dialog = null;
        }
    }
}

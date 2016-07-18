package com.mhtl.businesscenter.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mhtl.businesscenter.R;
import com.mhtl.businesscenter.services.LoginStatus;
import com.mhtl.businesscenter.utils.DialogHelper;
import com.mhtl.businesscenter.utils.SystemUtils;
import com.mhtl.businesscenter.widget.CustomProgressDialog;

public class LoginActivity extends BaseActivity {
    private EditText ed_account, ed_password;
    private Button bt_loging;
    private TextView tv_password_forget;
    CustomProgressDialog mProgressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_account = (EditText) findViewById(R.id.ed_account);
        ed_password = (EditText) findViewById(R.id.ed_password);
        bt_loging = (Button) findViewById(R.id.bt_loging);
        tv_password_forget = (TextView) findViewById(R.id.tv_password_forget);
        bt_loging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loggin();
            }
        });

        tv_password_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetPassword();
            }
        });
    }

    private void forgetPassword() {
    }

    private void loggin() {
        String account = null;
        String password = null;
        account = ed_account.getText().toString().trim();
        password = ed_password.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, getString(R.string.login_error1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, getString(R.string.login_error2), Toast.LENGTH_SHORT).show();
            return;
        }

        if (!SystemUtils.isOnline(this)) {
            Toast.makeText(this, getString(R.string.newwork_error), Toast.LENGTH_SHORT).show();
            return;
        }
        mProgressDialog = DialogHelper.showLoadingDialog(this, getString(R.string.logining), new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
            }
        });
        new Handler().postDelayed(new Runnable() {
            public void run() {
                DialogHelper.dismissCustomProgressDialog(mProgressDialog);
                toMain();
            }
        }, 3000);
//        OkHttpUtils
//                .post()
//                .url(Constant.HOST)
//                .addParams("username", account)
//                .addParams("password", password)
//                .build()
//                .execute(new UserCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        //login fail
//                        DialogHelper.dismissCustomProgressDialog(mProgressDialog);
//                    }
//
//                    @Override
//                    public void onResponse(UserAccount response, int id) {
//                        //Response ok
//                        DialogHelper.dismissCustomProgressDialog(mProgressDialog);
//                        toMain();
//                    }
//                });

    }

    private void toMain() {
        startActivity(new Intent(this, MainActivity.class));
        LoginStatus.setLogin(true);
        finish();
    }

    @Override
    public boolean openOverridePendingTransition() {
        return super.openOverridePendingTransition();
    }

    @Override
    public TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.SCALE_FADE;
    }
}

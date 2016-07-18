package com.mhtl.businesscenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mhtl.businesscenter.R;
import com.mhtl.businesscenter.activity.OtherRegisterActivity;
import com.mhtl.businesscenter.activity.OwnRegisterActivity;

public class RegisterFragment extends Fragment {
    Button bt_own_register,bt_other_register;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        bt_own_register = (Button) view.findViewById(R.id.bt_own_register);
        bt_other_register = (Button) view.findViewById(R.id.bt_other_register);
        initListener();
    }

    private void initListener() {
        bt_own_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OwnRegisterActivity.class));
            }
        });

        bt_other_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OtherRegisterActivity.class));
            }
        });
    }

}

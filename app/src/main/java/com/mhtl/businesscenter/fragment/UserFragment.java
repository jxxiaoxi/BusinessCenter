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


public class UserFragment extends Fragment {
    Button bt_cover_list, bt_network, bt_sales_info, bt_modify_password, bt_user_info_modify, bt_user_info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        bt_cover_list = (Button) view.findViewById(R.id.bt_cover_list);
        bt_network = (Button) view.findViewById(R.id.bt_network);

        bt_sales_info = (Button) view.findViewById(R.id.bt_sales_info);
        bt_modify_password = (Button) view.findViewById(R.id.bt_modify_password);

        bt_user_info_modify = (Button) view.findViewById(R.id.bt_user_info_modify);
        bt_user_info = (Button) view.findViewById(R.id.bt_user_info);

        initListener();
    }

    private void initListener() {
        bt_cover_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OwnRegisterActivity.class));
            }
        });

        bt_network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OtherRegisterActivity.class));
            }
        });

        bt_sales_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OwnRegisterActivity.class));
            }
        });

        bt_modify_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OtherRegisterActivity.class));
            }
        });
        bt_user_info_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OwnRegisterActivity.class));
            }
        });

        bt_user_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OtherRegisterActivity.class));
            }
        });
    }

}

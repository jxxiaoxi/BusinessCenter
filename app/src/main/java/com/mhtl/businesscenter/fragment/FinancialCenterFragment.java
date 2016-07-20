package com.mhtl.businesscenter.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mhtl.businesscenter.R;
import com.mhtl.businesscenter.activity.GoldTransferActivity;
import com.mhtl.businesscenter.activity.IntegralTransferActivity;
import com.mhtl.businesscenter.activity.RechargeActivity;
import com.mhtl.businesscenter.activity.WithdRawalsActivity;


public class FinancialCenterFragment extends Fragment {
    private Button integral_transfer,gold_transfer,recharge,withd_rawals;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_financial_center, container, false);
        initView(view);
        return view;
    }
    private void initView(View view) {
        integral_transfer = (Button) view.findViewById(R.id.integral_transfer);
        gold_transfer = (Button) view.findViewById(R.id.gold_transfer);
        recharge = (Button) view.findViewById(R.id.recharge);
        withd_rawals = (Button) view.findViewById(R.id.withd_rawals);
        initListener();
    }

    private void initListener() {
        integral_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), IntegralTransferActivity.class));
            }
        });

        gold_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GoldTransferActivity.class));
            }
        });

        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RechargeActivity.class));
            }
        });

        withd_rawals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WithdRawalsActivity.class));
            }
        });
    }
}
package com.mhtl.businesscenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhtl.businesscenter.R;
import com.mhtl.businesscenter.adapter.ProductAdapter;
import com.mhtl.businesscenter.widget.SpinerPopWindow.AbstractSpinerAdapter;
import com.mhtl.businesscenter.widget.SpinerPopWindow.SpinerPopWindow;

import java.util.ArrayList;
import java.util.List;

public class OwnRegisterActivity extends BaseActivity implements AbstractSpinerAdapter.IOnItemSelectListener {
    private SpinerPopWindow mSpinerPopWindow;
    ProductAdapter mAdapter;
    private List<String> mData;
    private int mProId;

    ImageView iv_drop_up;
    TextView tv_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_register);
        tv_product = (TextView) findViewById(R.id.tv_product);

        iv_drop_up = (ImageView) findViewById(R.id.iv_drop_up);
        iv_drop_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSpinWindow();
            }
        });

        mAdapter = new ProductAdapter(this);
        mData = getProducts();
        mAdapter.refreshData(mData, 0);
        mSpinerPopWindow = new SpinerPopWindow(this);
        mSpinerPopWindow.setAdatper(mAdapter);
        mSpinerPopWindow.setItemListener(this);
    }

    private void showSpinWindow() {
        mSpinerPopWindow.setWidth(tv_product.getWidth());
        mSpinerPopWindow.showAsDropDown(tv_product);
        iv_drop_up.setBackgroundResource(R.drawable.down_arrow);
    }

    @Override
    public void onItemClick(int pos) {
        if (mData != null && mData.size() > 0) {
            tv_product.setText(mData.get(pos));
            mProId = pos + 1;
        }
    }

    public List<String> getProducts() {
        List<String> products = new ArrayList<String>();
        String[] problems = {"1800", "2000", "3000"};
        for (int i = 0; i < problems.length; i++) {
            products.add(problems[i]);
        }
        return products;
    }
}

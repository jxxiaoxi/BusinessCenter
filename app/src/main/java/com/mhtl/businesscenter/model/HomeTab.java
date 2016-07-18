package com.mhtl.businesscenter.model;


import com.mhtl.businesscenter.R;
import com.mhtl.businesscenter.fragment.FinancialCenterFragment;
import com.mhtl.businesscenter.fragment.RegisterFragment;
import com.mhtl.businesscenter.fragment.SystemFragment;
import com.mhtl.businesscenter.fragment.UserFragment;

public enum HomeTab {

    USER(0, R.string.home_tab_user_center, R.drawable.tab_user, UserFragment.class),
    PAYCHECK(1, R.string.home_tab_paycheck, R.drawable.tab_paycheck, FinancialCenterFragment.class),
    REGISTER(2, R.string.home_tab_user_register, R.drawable.tab_register, RegisterFragment.class),
    SYSTEM(3, R.string.home_tab_system_management, R.drawable.tab_system, SystemFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private HomeTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}

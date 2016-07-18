package com.mhtl.businesscenter.widget.ptr;

import android.view.View;

public interface PtrHandler {


    public boolean checkCanDoRefresh(final PtrFrameLayout frame, final View content, final View header);

    /**
     * When refresh begin
     *
     * @param frame
     */
    public void onRefreshBegin(final PtrFrameLayout frame);
}
package com.mhtl.businesscenter.widget.ptr.util;

import android.content.Context;
import android.text.TextUtils;

import com.mhtl.businesscenter.R;
import com.mhtl.businesscenter.widget.ptr.PtrClassicDefaultHeader;
import com.mhtl.businesscenter.widget.ptr.PtrFrameLayout;
import com.mhtl.businesscenter.widget.ptr.PtrHandler;
import com.mhtl.businesscenter.widget.ptr.header.MaterialHeader;
import com.mhtl.businesscenter.widget.ptr.loadmore.LoadMoreHandler;
import com.mhtl.businesscenter.widget.ptr.loadmore.LoadMoreListViewContainer;

/**
 * Author: Zxy
 * Email:  278489710@qq.com
 * Date:   2015/12/30.
 */
public final class PtrHelper {

    /**
     * 创建一个符合Material Design的下拉刷新控件的样式
     * @param context
     * @param frameLayout PtrFrameLayout
     * @param ptrHandler 下拉刷新监听器
     * @return
     */
    public static PtrFrameLayout createMaterialStyle(Context context , PtrFrameLayout frameLayout , PtrHandler ptrHandler){

        if(frameLayout == null){
            throw  new NullPointerException("PtrFrameLayout is null");
        }

        final MaterialHeader header = new MaterialHeader(context);
        int[] colors = context.getResources().getIntArray(R.array.google_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, PtrLocalDisplay.dp2px(15), 0, PtrLocalDisplay.dp2px(10));
        header.setPtrFrameLayout(frameLayout);

        frameLayout.setLoadingMinTime(1000);
        frameLayout.setDurationToCloseHeader(1500);
        frameLayout.setHeaderView(header);
        frameLayout.addPtrUIHandler(header);
        frameLayout.setPtrHandler(ptrHandler);
        return frameLayout ;
    }

    /**
     *创建一个经典样式的下拉刷新控件的样式
     * @param context
     * @param frameLayout PtrFrameLayout
     * @param ptrHandler 下拉刷新监听器
     * @param lastUpdateTimeKey 设置上次更新时间的提示，如果设置为null则不显示上次更新提示
     * @return
     */
    public static PtrFrameLayout createClassicStyle(Context context ,PtrFrameLayout frameLayout ,PtrHandler ptrHandler , String lastUpdateTimeKey){
        if(frameLayout == null){
            throw  new NullPointerException("PtrFrameLayout is null");
        }

        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(context);
        if(!TextUtils.isEmpty(lastUpdateTimeKey)){
            header.setLastUpdateTimeKey(lastUpdateTimeKey);
        }
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        frameLayout.setLoadingMinTime(1000);
        frameLayout.setDurationToCloseHeader(1500);
        frameLayout.setHeaderView(header);
        frameLayout.addPtrUIHandler(header);
        frameLayout.setPtrHandler(ptrHandler);

        return frameLayout ;
    }

    /**
     * 创建一个支持ListView加载更多控件的默认样式
     * @param isAutoLoad 是否开启自动加载更多，默认是自动加载更多 ， true自动加载更多，false点击加载更多
     * @param context
     * @param loadMoreListViewContainer
     * @param handler
     * @return
     */
    public static LoadMoreListViewContainer createListViewLoadMoreStyle(boolean isAutoLoad , Context context , LoadMoreListViewContainer loadMoreListViewContainer , LoadMoreHandler handler){
        if(loadMoreListViewContainer == null){
            throw  new NullPointerException("LoadMoreListViewContainer is null");
        }

        loadMoreListViewContainer.setAutoLoadMore(isAutoLoad);
        loadMoreListViewContainer.setShowLoadingForFirstPage(true);
        loadMoreListViewContainer.useDefaultFooter();
        loadMoreListViewContainer.setLoadMoreHandler(handler);
        return loadMoreListViewContainer ;
    }
}

package com.mhtl.businesscenter.widget.ptr.loadmore;

public interface LoadMoreUIHandler {

    public void onLoading(LoadMoreContainer container);

    public void onLoadFinish(LoadMoreContainer container, boolean empty, boolean hasMore);

    public void onLoadFinish(LoadMoreContainer container, boolean empty, boolean hasMore, boolean showHasMoreHint) ;

    public void onWaitToLoadMore(LoadMoreContainer container);

    public void onLoadError(LoadMoreContainer container, int errorCode, String errorMessage);
}
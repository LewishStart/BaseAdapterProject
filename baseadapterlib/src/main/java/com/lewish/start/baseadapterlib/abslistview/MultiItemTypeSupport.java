package com.lewish.start.baseadapterlib.abslistview;

/**
 * author: sundong
 * created at 2017/3/22 15:56
 */
public interface MultiItemTypeSupport<T> {
    /**
     * 得到布局Id
     */
    int getLayoutId(int position, T t);

    /**
     * 一共有多少种View?
     */
    int getViewTypeCount();

    /**
     * 得到Item的View的类型
     */
    int getItemViewType(int position, T t);
}
package com.lewish.start.baseadapterlib.recyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * author: sundong
 * created at 2017/3/22 15:57
 */
public interface OnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);

    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}
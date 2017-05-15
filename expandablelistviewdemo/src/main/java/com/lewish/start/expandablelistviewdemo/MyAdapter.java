package com.lewish.start.expandablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * author: sundong
 * created at 2017/5/15 16:03
 */
public class MyAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<GroupBean> mGroupBeanList;
    private int mGroupViewResId;
    private int mEntryViewResId;

    public MyAdapter(Context mContext, List<GroupBean> groupBeanList, int groupViewResId, int entryViewResId) {
        this.mContext = mContext;
        this.mGroupBeanList = groupBeanList;
        this.mGroupViewResId = groupViewResId;
        this.mEntryViewResId = entryViewResId;
    }

    public void setGroupBeanList(List<GroupBean> groupBeanList) {
        this.mGroupBeanList = groupBeanList;
    }

    @Override
    public int getGroupCount() {
        return mGroupBeanList == null ? 0 : mGroupBeanList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        GroupBean groupBean = mGroupBeanList.get(groupPosition);

        return groupBean.entryBeanList == null ? 0 : groupBean.entryBeanList.size();
    }

    @Override
    public GroupBean getGroup(int groupPosition) {
        return mGroupBeanList.get(groupPosition);
    }

    @Override
    public GroupBean.EntryBean getChild(int groupPosition, int childPosition) {
        return mGroupBeanList.get(groupPosition).entryBeanList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mGroupViewResId, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.mTvLabelExpandGroup);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvTitle.setText(getGroup(groupPosition).groupName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mEntryViewResId, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.mTvLabelExpandEntry);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.tvTitle.setText(getGroup(groupPosition).groupName);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ChildViewHolder {
        TextView tvTitle;
    }

    private static class GroupViewHolder {
        TextView tvTitle;
    }
}

package com.lewish.start.expandablelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.List;

/**
 * author: sundong
 * created at 2017/5/15 17:21
 */
public class MainActivity extends AppCompatActivity {
    private ExpandableListView mExpandableListView;
    private List<GroupBean> groupBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandableListView = (ExpandableListView) findViewById(R.id.mExpandableListView);
    }
}

package com.lewish.start.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lewish.start.baseadapterlib.ViewHolder;
import com.lewish.start.baseadapterlib.abslistview.CommonAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: sundong
 * created at 2017/3/22 16:09
 */
public class MainActivity extends AppCompatActivity {
    private List<String> mDatas = new ArrayList<>(Arrays.asList("MultiItem ListView",
            "RecyclerView",
            "MultiItem RecyclerView"));
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = ((ListView) findViewById(R.id.id_listview_list));
        mListView.setAdapter(new CommonAdapter<String>(this, R.layout.item_list, mDatas) {
            @Override
            public void convert(ViewHolder holder, String o,int position) {
                holder.setText(R.id.id_item_list_title, o);
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                    default:
                        intent = new Intent(MainActivity.this, MultiItemListViewActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, MultiItemRvActivity.class);
                        break;

                }
                if (intent != null)
                    startActivity(intent);
            }
        });
    }


}

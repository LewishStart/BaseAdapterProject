package com.lewish.start.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lewish.start.baseadapterlib.recyclerview.OnItemClickListener;
import com.lewish.start.sample.adapter.ChatAdapterForRv;
import com.lewish.start.sample.bean.ChatMessage;

/**
 * author: sundong
 * created at 2017/3/22 16:09
 */
public class MultiItemRvActivity extends AppCompatActivity
{
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ChatAdapterForRv adapter = new ChatAdapterForRv(this, ChatMessage.MOCK_DATAS);
        adapter.setOnItemClickListener(new OnItemClickListener<ChatMessage>()
        {
            @Override
            public void onItemClick(ViewGroup parent, View view, ChatMessage o, int position)
            {
                Toast.makeText(MultiItemRvActivity.this, "Click:" + position + " => " + o.getContent(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, ChatMessage o, int position)
            {
                Toast.makeText(MultiItemRvActivity.this, "LongClick:" + position + " => " + o.getContent(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mRecyclerView.setAdapter(adapter);
    }


}

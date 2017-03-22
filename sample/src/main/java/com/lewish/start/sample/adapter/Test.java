package com.lewish.start.sample.adapter;

import android.content.Context;

import com.lewish.start.baseadapterlib.ViewHolder;
import com.lewish.start.baseadapterlib.abslistview.MultiItemCommonAdapter;
import com.lewish.start.baseadapterlib.abslistview.MultiItemTypeSupport;
import com.lewish.start.sample.R;
import com.lewish.start.sample.bean.ChatMessage;

import java.util.List;

/**
 * author: sundong
 * created at 2017/3/22 16:09
 */
public class Test extends MultiItemCommonAdapter<ChatMessage> {

    public Test(Context context, List<ChatMessage> datas) {
        super(context, datas, new MultiItemTypeSupport<ChatMessage>() {
            @Override
            public int getLayoutId(int position, ChatMessage chatMessage) {
                if (chatMessage.isComMeg()) {
                    return R.layout.main_chat_from_msg;
                }
                return R.layout.main_chat_send_msg;
            }

            @Override
            public int getViewTypeCount() {
                return 2;
            }

            @Override
            public int getItemViewType(int position, ChatMessage chatMessage) {
                if (chatMessage.isComMeg()) {
                    return ChatMessage.RECIEVE_MSG;
                }
                return ChatMessage.SEND_MSG;
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, ChatMessage chatMessage,int position) {
        switch (holder.getLayoutId()) {
            case R.layout.main_chat_from_msg:
                holder.setText(R.id.chat_from_content, chatMessage.getContent());
                holder.setText(R.id.chat_from_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_from_icon, chatMessage.getIcon());
                break;
            case R.layout.main_chat_send_msg:
                holder.setText(R.id.chat_send_content, chatMessage.getContent());
                holder.setText(R.id.chat_send_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_send_icon, chatMessage.getIcon());
                break;
        }
    }
}

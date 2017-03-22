package com.lewish.start.sample.adapter;

import android.content.Context;

import com.lewish.start.baseadapterlib.ViewHolder;
import com.lewish.start.baseadapterlib.recyclerview.MultiItemCommonAdapter;
import com.lewish.start.baseadapterlib.recyclerview.MultiItemTypeSupport;
import com.lewish.start.sample.R;
import com.lewish.start.sample.bean.ChatMessage;

import java.util.List;

/**
 * author: sundong
 * created at 2017/3/22 16:08
 */
public class ChatAdapterForRv extends MultiItemCommonAdapter<ChatMessage>
{
    public ChatAdapterForRv(Context context, List<ChatMessage> datas)
    {
        super(context, datas, new MultiItemTypeSupport<ChatMessage>()
        {
            @Override
            public int getLayoutId(int itemType)
            {
                if (itemType == ChatMessage.RECIEVE_MSG)
                {
                    return R.layout.main_chat_from_msg;
                } else
                    return R.layout.main_chat_send_msg;
            }

            @Override
            public int getItemViewType(int postion, ChatMessage msg)
            {
                if (msg.isComMeg())
                {
                    return ChatMessage.RECIEVE_MSG;
                }
                return ChatMessage.SEND_MSG;
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, ChatMessage chatMessage)
    {

        switch (holder.getLayoutId())
        {
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

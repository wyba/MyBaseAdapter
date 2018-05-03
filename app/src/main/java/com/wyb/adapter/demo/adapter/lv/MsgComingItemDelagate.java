package com.wyb.adapter.demo.adapter.lv;


import com.wyb.adapter.demo.R;
import com.wyb.baseadapter.abslistview.ViewHolder;
import com.wyb.baseadapter.abslistview.base.ItemViewDelegate;

import com.wyb.adapter.demo.bean.ChatMessage;

/**
 * Created by zhy on 16/6/22.
 */
public class MsgComingItemDelagate implements ItemViewDelegate<ChatMessage> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.main_chat_from_msg;
    }

    @Override
    public boolean isForViewType(ChatMessage item, int position) {
        return item.isComMeg();
    }

    @Override
    public void convert(ViewHolder holder, ChatMessage chatMessage, int position) {
        holder.setText(R.id.chat_from_content, chatMessage.getContent());
        holder.setText(R.id.chat_from_name, chatMessage.getName());
        holder.setImageResource(R.id.chat_from_icon, chatMessage.getIcon());
    }
}

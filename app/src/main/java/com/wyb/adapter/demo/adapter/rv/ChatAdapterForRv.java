package com.wyb.adapter.demo.adapter.rv;

import android.content.Context;


import com.wyb.adapter.demo.bean.ChatMessage;
import com.wyb.rvadapter.MultiItemTypeAdapter;

import java.util.List;


/**
 * Created by zhy on 15/9/4.
 */
public class ChatAdapterForRv extends MultiItemTypeAdapter<ChatMessage> {
    public ChatAdapterForRv(Context context, List<ChatMessage> datas) {
        super(context, datas);

        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }
}

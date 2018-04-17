package com.wyb.adapter.demo.adapter.lv;

import android.content.Context;

import com.wyb.lvadapter.abslistview.MultiItemTypeAdapter;
import com.wyb.adapter.demo.bean.ChatMessage;

import java.util.List;

public class ChatAdapter extends MultiItemTypeAdapter<ChatMessage> {

    public ChatAdapter(Context context, List<ChatMessage> datas) {
        super(context, datas);
        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }

}

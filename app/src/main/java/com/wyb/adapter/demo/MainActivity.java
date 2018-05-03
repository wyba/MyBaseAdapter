package com.wyb.adapter.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.wyb.baseadapter.abslistview.CommonAdapter;
import com.wyb.baseadapter.abslistview.ViewHolder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView lv_menu;

    private List<String> mDatas = new ArrayList<>(Arrays.asList("MultiItem ListView", "RecyclerView", "MultiItem RecyclerView"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("base-adapter");

        lv_menu = findViewById(R.id.lv_menu);

        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(this, R.layout.item_menu, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.lv_menu_item_tv_title, item);
            }

            @Override
            public void onViewHolderCreated(ViewHolder holder, View itemView) {
                super.onViewHolderCreated(holder, itemView);
            }
        };

        lv_menu.setAdapter(commonAdapter);

        lv_menu.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position){
            case 0:
                    startActivity(new Intent(this,MultiItemListViewActivity.class));
                break;

            case 1:
                startActivity(new Intent(this,RecyclerViewActivity.class));
                break;

            case 2:
                startActivity(new Intent(this,MultiItemRvActivity.class));
                break;
        }

    }
}

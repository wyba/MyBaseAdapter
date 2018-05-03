# base-adapter

努力打造一个ListView、GirdView通用的adapter,同时也在为RecycleView更好使用的adapter

## 目录

* [1.APK](#1apk)
* [2.Usage](#2usage)
    * [工程依赖 build.gradle](#工程依赖-buildgradle)
        * [(1).project](#1project)
        * [(2).app](#2app)
    * [Use it](#use-it)
        * [(1).普通的ListView](#1普通的listview)
        * [(2).多类型Item ListView](#2多类型item-listview)
        * [(3).普通的RecycleView](#3普通的recycleview)
        * [(4).多类型Item RecycleView](#4多类型item-recycleview)

## 1.APK
 
 [Demo DownLoad](/app/release/app-release.apk?raw=true)
        
## 2.Usage

### 工程依赖 build.gradle

#### (1).project

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

#### (2).app

listview及gridview通用adapter

	dependencies {
	        compile 'com.github.wyba:base-adapter:V1.3.0'
	}
	
recyclerview通用adapter如下	

	dependencies {
	        implementation 'com.github.wyba.base-adapter:rv-library:V1.4.0'
	}

### Use it

#### (1).普通的ListView

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

#### (2).多类型Item ListView

    public class ChatAdapter extends MultiItemTypeAdapter<ChatMessage> {
    
        public ChatAdapter(Context context, List<ChatMessage> datas) {
            super(context, datas);
            addItemViewDelegate(new MsgSendItemDelagate());
            addItemViewDelegate(new MsgComingItemDelagate());
        }
    
    }

#### (3).普通的RecycleView

            mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
    //        mRecyclerView.setHasFixedSize(true);
    //        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    //        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    
            mAdapter = new CommonAdapter<String>(this, R.layout.item_menu, mDatas) {
                @Override
                protected void convert(ViewHolder holder, String s, int position) {
                    holder.setText(R.id.lv_menu_item_tv_title, s + " : " + holder.getAdapterPosition() + " , " + holder.getLayoutPosition());
                }
            };
    
            initHeaderAndFooter();
    
    //        initEmptyView();
    
            mLoadMoreWrapper = new LoadMoreWrapper(mHeaderAndFooterWrapper);
            mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
            mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < 10; i++) {
                                mDatas.add("Add:" + i);
                            }
                            mLoadMoreWrapper.notifyDataSetChanged();
    
                        }
                    }, 3000);
                }
            });
    
            mRecyclerView.setAdapter(mLoadMoreWrapper);
            mAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    Toast.makeText(RecyclerViewActivity.this, "pos = " + position, Toast.LENGTH_SHORT).show();
                    mAdapter.notifyItemRemoved(position);
                }
    
                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    return false;
                }
            });

#### (4).多类型Item RecycleView

        public class ChatAdapterForRv extends MultiItemTypeAdapter<ChatMessage> {
        
            public ChatAdapterForRv(Context context, List<ChatMessage> datas) {
                super(context, datas);
                addItemViewDelegate(new MsgSendItemDelagate());
                addItemViewDelegate(new MsgComingItemDelagate());
            }
        
        }
        
        
      ChatAdapterForRv adapter = new ChatAdapterForRv(this, mDatas);
    
            mLoadMoreWrapper = new LoadMoreWrapper(adapter);
    
            mLoadMoreWrapper.setLoadMoreView(LayoutInflater.from(this).inflate(R.layout.default_loading, mRecyclerView, false));
    
            mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            boolean coming = Math.random() > 0.5;
                            ChatMessage msg = null;
                            msg = new ChatMessage(coming ? R.drawable.renma : R.drawable.xiaohei, coming ? "人马" : "xiaohei", "where are you " + mDatas.size(),
                                    null, coming);
                            mDatas.add(msg);
                            mLoadMoreWrapper.notifyDataSetChanged();
    
                        }
                    }, 3000);
                }
            });
    
            adapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    Toast.makeText(MultiItemRvActivity.this, "Click:" + position, Toast.LENGTH_SHORT).show();
                }
    
                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    Toast.makeText(MultiItemRvActivity.this, "LongClick:" + position, Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            mRecyclerView.setAdapter(mLoadMoreWrapper);
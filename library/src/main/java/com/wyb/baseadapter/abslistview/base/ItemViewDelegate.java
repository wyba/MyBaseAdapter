package com.wyb.baseadapter.abslistview.base;


import com.wyb.baseadapter.abslistview.ViewHolder;


public interface ItemViewDelegate<T> {

      int getItemViewLayoutId();

      boolean isForViewType(T item, int position);

      void convert(ViewHolder holder, T t, int position);

}

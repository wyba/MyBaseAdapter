# base-adapter-library

Add it in your root build.gradle at the end of repositories:

Step 1. Add the JitPack repository to your build file

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}


Step 2. Add the dependency

	dependencies {
	        compile 'com.github.wyba:base-adapter-library:V1.0.0'
	}

Step 3.Use it

	public class MyAdapter extends CommonAdapter<MyData>{

        /**
         * 构造方法
         * @param context
         * @param layoutId  item布局
         * @param datas     数据源
         */
        public MyAdapter(Context context, int layoutId, List<MyData> datas) {
            super(context, layoutId, datas);
        }

        @Override
        protected void convert(ViewHolder viewHolder, MyData item, int position) {
           TextView tv_xx = (TextView)viewHolder.getView(R.id.xx);//获取控件
            tv_xx.setText(item.getXX());
            //或者以下
            viewHolder.setText(R.id.xx,item.getXX());
        }
    }
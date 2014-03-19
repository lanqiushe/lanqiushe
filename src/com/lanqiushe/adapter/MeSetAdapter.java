 
package com.lanqiushe.adapter;

 
import com.lanqiushe.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

 

public class MeSetAdapter extends BaseAdapter {
    private Context context;
    private String[] array;
    public MeSetAdapter(Context context,String[] array){
    	this.context = context;
    	this.array = array;
    }
 	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return array.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView==null){
			holder = new ViewHolder();
			convertView  = View.inflate(context, R.layout.item_set, null);
			holder.category = (TextView) convertView.findViewById(R.id.item_set_category_tv);
			holder.status = (TextView) convertView.findViewById(R.id.item_set_status_tv);
			convertView.setTag(holder);
		}else{
			holder  = (ViewHolder) convertView.getTag();
		}
		holder.category.setText(array[position]);
		return convertView;
	}
	private static class ViewHolder{
		TextView category,status;
	}

}

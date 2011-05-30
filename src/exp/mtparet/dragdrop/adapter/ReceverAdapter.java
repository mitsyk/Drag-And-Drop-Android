package exp.mtparet.dragdrop.adapter;

import java.util.ArrayList;

import exp.mtparet.dragdrop.R;
import exp.mtparet.dragdrop.data.OneItem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ReceverAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<OneItem> alPicture;
	
	public ReceverAdapter(Context context, ArrayList<OneItem> alPicture ) {
		this.context = context;
		this.alPicture = alPicture;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return alPicture.size();
	}

	@Override
	public OneItem getItem(int position) {
		// TODO Auto-generated method stub
		return alPicture.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = (RelativeLayout)RelativeLayout.inflate(context,R.layout.item_list, null);

		}
		
		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		iv.setImageDrawable(context.getResources().getDrawable(alPicture.get(position).getId()));
		iv.setContentDescription(this.alPicture.get(position).getName());
		
		return convertView;
	}
	
	public void addPicture(OneItem onItem, int position){
		
		if(position < alPicture.size()){
			alPicture.add(position, onItem);
		}else{
			alPicture.add(onItem);
		}
		
		notifyDataSetChanged();
	}
	
	public void addPicture(OneItem onItem){

		alPicture.add(onItem);

		notifyDataSetChanged();
	}
	
	public void removeItem(int arg1){
		alPicture.remove(arg1);
		notifyDataSetChanged();
	}
	
	public void clear(){
		this.alPicture.clear();
		this.notifyDataSetChanged();
	}


}
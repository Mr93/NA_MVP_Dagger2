package com.designpattern.admin.designpattern.V;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.designpattern.admin.designpattern.M.Object.DataModel;
import com.designpattern.admin.designpattern.R;
import com.loopj.android.image.SmartImageView;

import java.util.List;

/**
 * Created by Admin on 9/7/2016.
 */
public class DataAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    List<DataModel> dataModel;
    DataModel resultp = new DataModel();

    public DataAdapter(Context context,List<DataModel> arraylist) {
        this.context = context;
        dataModel = arraylist;
    }

    @Override
    public int getCount() {
        return dataModel.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        SmartImageView img_thumb;
        TextView tv_NgayDang;
        TextView tv_Title;
	    TextView tv_Domain;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_listview, parent, false);
        resultp = dataModel.get(position);
        img_thumb = (SmartImageView) itemView.findViewById(R.id.img_thumb);
        tv_NgayDang = (TextView) itemView.findViewById(R.id.tv_NgayDang);
        tv_Title = (TextView) itemView.findViewById(R.id.tv_Title);
	    tv_Domain = (TextView) itemView.findViewById(R.id.tv_Domain);
        img_thumb.setImageUrl(resultp.getImage());
        tv_NgayDang.setText(resultp.getPubDate());
        tv_Title.setText(resultp.getTitle());
	    tv_Domain.setText(resultp.getDomain());
        return itemView;
    }
}

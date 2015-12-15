package com.nunc.Homewised.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.model.ItemObject;

import java.util.ArrayList;

public class ItemslistAdapter extends BaseAdapter {
    Context ctx;

    private int lastPosition = -1;

    ArrayList<ItemObject> itemList = new ArrayList<ItemObject>();




    private class ViewHolder {


        private TextView itemName,quantity,tvTotal;

    }

    public ItemslistAdapter(Context context, ArrayList<ItemObject> itemList) {
        ctx = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) ctx
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(
                    R.layout.itemslistdataadd, null);
            holder = new ViewHolder();

            holder.itemName = (TextView) convertView.findViewById(R.id.tvitemName);
            holder.quantity = (TextView) convertView.findViewById(R.id.tvitemQuantity);
            holder.tvTotal=(TextView)convertView.findViewById(R.id.tvitemTotal);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ItemObject rowItem = (ItemObject) getItem(position);



        holder.itemName.setText(rowItem.getItemName());
        holder.quantity.setText(""+rowItem.getQuantity());

        holder.tvTotal.setText(""+(rowItem.getUnitePrice()+rowItem.getLabor()));

        return convertView;
    }


}
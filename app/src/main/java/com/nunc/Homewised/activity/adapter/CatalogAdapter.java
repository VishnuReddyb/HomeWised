package com.nunc.Homewised.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.model.Catalog;

import java.util.ArrayList;

public class CatalogAdapter extends BaseAdapter {
    Context ctx;

    private int lastPosition = -1;

    ArrayList<Catalog> Datastring = new ArrayList<Catalog>();




    private class ViewHolder {
        //TextView jobid, text_airconditon_repair, text_airconditon_time, text_airconditon_address, text_cust;
        TextView text_airfilter_name,text_airfilter_address,text_price,text_airfilter_title,text_airfilter_price;
        private ImageView img_rightside;

    }

    public CatalogAdapter(Context context, ArrayList<Catalog> Datastring) {
        ctx = context;
        this.Datastring = Datastring;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Datastring.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return Datastring.get(position);
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
                    R.layout.catalog_listitems, null);
            holder = new ViewHolder();
            holder.img_rightside = (ImageView) convertView
                    .findViewById(R.id.img_rightside);

            holder.text_airfilter_name = (TextView) convertView.findViewById(R.id.text_airfilter_name);
            holder.text_airfilter_address = (TextView) convertView.findViewById(R.id.text_airfilter_address);
            holder.text_price = (TextView) convertView.findViewById(R.id.text_price);
            holder.text_airfilter_title = (TextView) convertView.findViewById(R.id.text_airfilter_title);
            holder.text_airfilter_price = (TextView) convertView.findViewById(R.id.text_airfilter_price);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Catalog rowItem = (Catalog) getItem(position);

        holder.text_airfilter_title.setText(rowItem.getText_airfilter_title());
        holder.text_price.setText(rowItem.getText_price());
        holder.text_airfilter_address.setText(rowItem.getText_airfilter_address());
        holder.text_airfilter_name.setText(rowItem.getText_airfilter_name());

//        holder.btn_schedule.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
////                ScheduleDetails scheduledetails = new ScheduleDetails();
////               FragmentUtil.addFragmentForWalker((Activity)ctx,scheduledetails,null,false,true,"ScheduleDetails");
//
//
//            }
//        });
        return convertView;
    }
}
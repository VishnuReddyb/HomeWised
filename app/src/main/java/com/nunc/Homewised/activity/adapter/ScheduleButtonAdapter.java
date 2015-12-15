package com.nunc.Homewised.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.model.ScheduleButtonmodel;

import java.util.ArrayList;

public class ScheduleButtonAdapter extends BaseAdapter {
    Context ctx;

    private int lastPosition = -1;

    ArrayList<ScheduleButtonmodel> Datastring = new ArrayList<ScheduleButtonmodel>();




    private class ViewHolder {


        private CheckBox chck_accepted;
        private  TextView text_cusname;
    }

    public ScheduleButtonAdapter(Context context, ArrayList<ScheduleButtonmodel> Datastring) {
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
                    R.layout.shedulebutton_listitems, null);
            holder = new ViewHolder();

            holder.chck_accepted = (CheckBox) convertView.findViewById(R.id.chck_accepted);
            holder.text_cusname=(TextView)convertView.findViewById(R.id.text_cusname);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ScheduleButtonmodel rowItem = (ScheduleButtonmodel) getItem(position);



        holder.text_cusname.setText(rowItem.getText_cusname());
       // holder.mapmarker.setText(rowItem.getText_cust());

        /*holder.mapmarker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"RoutMap ",Toast.LENGTH_SHORT).show();
                RouteMap routemap = new RouteMap();
                FragmentUtil.addFragmentForWalker((Activity) ctx, routemap, null, false, true, "RouteMap");


            }
        });

        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ScheduleDetails scheduledetails = new ScheduleDetails();
                FragmentUtil.addFragmentForWalker((Activity) ctx, scheduledetails, null, false, true, "ScheduleDetails");

            }
        });*/
        return convertView;
    }
}
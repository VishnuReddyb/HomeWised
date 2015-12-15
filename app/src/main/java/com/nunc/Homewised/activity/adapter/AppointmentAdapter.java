package com.nunc.Homewised.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;
import com.nunc.Homewised.activity.Fragments.RouteMap;
import com.nunc.Homewised.activity.Fragments.ScheduleButton;
import com.nunc.Homewised.activity.Fragments.ScheduleDetails;
import com.nunc.Homewised.activity.model.Appointment;

import java.util.ArrayList;

public class AppointmentAdapter extends BaseAdapter {
    Context ctx;

    private int lastPosition = -1;

    ArrayList<Appointment> Datastring = new ArrayList<Appointment>();




    private class ViewHolder {
        TextView jobid, text_airconditon_repair, text_airconditon_time, text_airconditon_address, text_cust;
        //TextView title_cassboss, app_price, install_price, text_desc;
        private ImageView img_rightside,mapmarker;
        private Button btn_schedule;
    }

    public AppointmentAdapter(Context context, ArrayList<Appointment> Datastring) {
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
                    R.layout.appointment_listitems, null);
            holder = new ViewHolder();
            holder.img_rightside = (ImageView) convertView
                    .findViewById(R.id.img_rightside);
            holder.mapmarker = (ImageView) convertView
                    .findViewById(R.id.mapmarker);

            holder.jobid = (TextView) convertView.findViewById(R.id.jobid);
            holder.text_airconditon_repair = (TextView) convertView.findViewById(R.id.text_airconditon_repair);
            holder.text_airconditon_time = (TextView) convertView.findViewById(R.id.text_airconditon_time);
            holder.text_airconditon_address = (TextView) convertView.findViewById(R.id.text_airconditon_address);
            holder.text_cust = (TextView) convertView.findViewById(R.id.text_cust);
            holder.btn_schedule = (Button) convertView.findViewById(R.id.btn_schedule);
            holder.mapmarker = (ImageView) convertView.findViewById(R.id.mapmarker);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Appointment rowItem = (Appointment) getItem(position);

        holder.jobid.setText(rowItem.getJobid());
        holder.text_airconditon_repair.setText(rowItem.getText_airconditon_repair());
        holder.text_airconditon_time.setText(rowItem.getText_airconditon_time());
        holder.text_airconditon_address.setText(rowItem.getText_airconditon_address());
        holder.text_cust.setText(rowItem.getText_cust());
       // holder.mapmarker.setText(rowItem.getText_cust());
        holder.btn_schedule.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ScheduleButton schedulebutton= new ScheduleButton();

                FragmentUtil.addFragment((Activity) ctx, schedulebutton, null, false, true, "ScheduleButton");
               // Toast.makeText(ctx,"schedule ",Toast.LENGTH_SHORT).show();


            }
        });
        holder.mapmarker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(ctx,"RoutMap ",Toast.LENGTH_SHORT).show();
                RouteMap routemap = new RouteMap();
                FragmentUtil.addFragment((Activity) ctx, routemap, null, false, true, "RouteMap");


            }
        });

        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ScheduleDetails scheduledetails = new ScheduleDetails();
                FragmentUtil.addFragment((Activity) ctx, scheduledetails, null, false, true, "ScheduleDetails");



            }
        });
        return convertView;
    }
}
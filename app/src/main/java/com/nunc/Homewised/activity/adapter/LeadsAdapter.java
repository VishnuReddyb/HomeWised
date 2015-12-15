package com.nunc.Homewised.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.nunc.Homewised.activity.Fragments.LeadsListDetails;
import com.nunc.Homewised.activity.model.Leads;

import java.util.ArrayList;

public class LeadsAdapter extends BaseAdapter {
    Context ctx;

    private int lastPosition = -1;

    ArrayList<Leads> Datastring = new ArrayList<Leads>();




    private class ViewHolder {
        //TextView jobid, text_airconditon_repair, text_airconditon_time, text_airconditon_address, text_cust;
        TextView text_name,text_address,text_notes;
        private ImageView img_rightside,imag_phone;
        private Button btn_addappointment;
    }

    public LeadsAdapter(Context context, ArrayList<Leads> Datastring) {
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
                    R.layout.leads_listitems, null);
            holder = new ViewHolder();
            holder.img_rightside = (ImageView) convertView
                    .findViewById(R.id.img_rightside);
            holder.imag_phone=(ImageView)convertView.findViewById(R.id.imag_phone);

            holder.text_name = (TextView) convertView.findViewById(R.id.text_name);
            holder.text_address = (TextView) convertView.findViewById(R.id.text_address);
            holder.text_notes = (TextView) convertView.findViewById(R.id.text_notes);

            holder.btn_addappointment = (Button) convertView.findViewById(R.id.btn_addappointment);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Leads rowItem = (Leads) getItem(position);

        holder.text_name.setText(rowItem.getText_name());
        holder.text_address.setText(rowItem.getText_address());
        holder.text_notes.setText(rowItem.getText_notes());

        convertView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                LeadsListDetails leadslistdetails=new LeadsListDetails();


                FragmentUtil.addFragment((Activity)ctx, leadslistdetails, null, false, true, "LeadsListDetails");

            }
        });

        holder.imag_phone.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7416083252"));
                ctx.startActivity(callIntent);
               /* Intent intent = new Intent(ctx,ForgotPassword.class);
                ctx.startActivity(intent);*/

            }
        });
        return convertView;
    }
}
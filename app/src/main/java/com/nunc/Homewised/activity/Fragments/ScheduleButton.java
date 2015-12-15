package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;
import com.nunc.Homewised.activity.adapter.ScheduleButtonAdapter;
import com.nunc.Homewised.activity.model.ScheduleButtonmodel;

import java.util.ArrayList;


/**
 * Created by nunc on 07-12-2015.
 */
public class ScheduleButton extends Fragment {
    View rootView;
    private Activity activity;
    private Button btn_continue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.schedulebutton, container, false);
        btn_continue=(Button)rootView.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignatureFragment signatureFragment=new SignatureFragment();
                FragmentUtil.addFragment(activity, signatureFragment, null, false, true, "SignatureFragment");

            }
        });
       // ListView leadslistView = (ListView) rootView.findViewById(R.id.schedulebutton_list);
//        leadslistView.setAdapter(new ScheduleButtonAdapter(activity, customerstlistData));
        this.activity = getActivity();
        updateList();
        return rootView;
    }

    private void updateList() {
        ArrayList<ScheduleButtonmodel> ScheduleButtonlist = new ArrayList<ScheduleButtonmodel>();

        ScheduleButtonmodel schedulebutton = new ScheduleButtonmodel();

        schedulebutton.setText_cusname("Accepted" + "\t");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("UnScheduled");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("Declined");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("New");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("ScheduleHold");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("Scheduled");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("ReScheduled");
        ScheduleButtonlist.add(schedulebutton);


        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("WorkStarted");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("WorkOnHold");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("OnWayToWork");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("Cancelled");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("Completed");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("Rejected");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("Invoiced");
        ScheduleButtonlist.add(schedulebutton);

        schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("Revised");
        ScheduleButtonlist.add(schedulebutton);


          schedulebutton  = new ScheduleButtonmodel();
        schedulebutton.setText_cusname("Archived");
        ScheduleButtonlist.add(schedulebutton);


        ListView listView = (ListView) rootView.findViewById(R.id.schedulebutton_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activity,
                        "Click ListItem Number " + position, Toast.LENGTH_SHORT)
                        .show();
                CatalogDetails  catalogdetails = new CatalogDetails();
                FragmentUtil.addFragment(activity, catalogdetails, null, false, true, "CatalogDetails");
            }
        });

        /*Toast.makeText(activity,
                "Click ListItem Number " + position, Toast.LENGTH_SHORT)
                .show();*/
        listView.setAdapter(new ScheduleButtonAdapter(activity, ScheduleButtonlist));

    }
}

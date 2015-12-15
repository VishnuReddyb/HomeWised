package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;

/**
 * Created by nunc on 19-11-2015.
 */
public class ScheduleDetails extends Fragment {
    View rootView;
    private Button btn_editjob, btn_addsubjob,btn_viewcustomer;
    private ImageView img_add,imzge_officephone,image_homephone;
    private Activity activity;

    public ScheduleDetails() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.scheduledetails, container, false);
        this.activity = getActivity();
        btn_editjob = (Button) rootView.findViewById(R.id.btn_editjob);
        btn_addsubjob = (Button) rootView.findViewById(R.id.btn_addsubjob);
        btn_viewcustomer = (Button) rootView.findViewById(R.id.btn_viewcustomer);

        img_add = (ImageView) rootView.findViewById(R.id.img_add);
        imzge_officephone = (ImageView) rootView.findViewById(R.id.imzge_officephone);
        image_homephone = (ImageView) rootView.findViewById(R.id.image_homephone);


        btn_editjob.setOnClickListener(new Buttonclick());
        btn_addsubjob.setOnClickListener(new Buttonclick());
        img_add.setOnClickListener(new Buttonclick());
        image_homephone.setOnClickListener(new Buttonclick());
        imzge_officephone.setOnClickListener(new Buttonclick());
        btn_viewcustomer.setOnClickListener(new Buttonclick());

       /* btn_editjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditJobFragment editjobfragment = new EditJobFragment();
                FragmentUtil.addFragmentForWalker(activity, editjobfragment, null, false, true, "EditJobFragment");
            }
        });
        btn_addsubjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddQuoteFragment addquotefragment = new AddQuoteFragment();
                FragmentUtil.addFragmentForWalker(activity, addquotefragment, null, false, true, "AddQuoteFragment");
            }
        });
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppointmentAddButton appointmentaddbutton = new AppointmentAddButton();
                FragmentUtil.addFragmentForWalker(activity, appointmentaddbutton, null, false, true, "AppointmentAddButton");
            }
        });
*/
        // Inflate the layout for this fragment
        return rootView;
    }


    private class Buttonclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v==img_add){
                AppointmentAddButton appointmentaddbutton = new AppointmentAddButton();
                FragmentUtil.addFragment(activity, appointmentaddbutton, null, false, true, "AppointmentAddButton");
            }
            else if(v==btn_addsubjob){
                AddQuoteFragment addquotefragment = new AddQuoteFragment();
                FragmentUtil.addFragment(activity, addquotefragment, null, false, true, "AddQuoteFragment");
            }else if(v==btn_editjob){
                EditJobFragment editjobfragment = new EditJobFragment();
                FragmentUtil.addFragment(activity, editjobfragment, null, false, true, "EditJobFragment");
            }else if(v==imzge_officephone){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7416083252"));
                activity.startActivity(callIntent);
            }else if(v==image_homephone){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9493030423"));
                activity.startActivity(callIntent);

            }
            else if(v==btn_viewcustomer){

                Customerdetalils customerdetalils=new Customerdetalils();
                FragmentUtil.addFragment(activity, customerdetalils, null, false, true, "Customerdetalils");
//
//                AppointmentAddButton appointmentaddbutton = new AppointmentAddButton();
//                FragmentUtil.addFragment(activity, appointmentaddbutton, null, false, true, "AppointmentAddButton");


                        }

        }
    }
}

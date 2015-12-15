package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;

/**
 * Created by NUNC on 21-11-2015.
 */
public class AppointmentAddButton extends Fragment {
    View rootView;
    private EditText edt_customername,edt_customephonenumber;
    private LinearLayout lin_addcustomer;
    private ImageView img_add;
    private Button btn_addjob,btn_addquote,btn_viewcustomer;
    private Activity activity;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.appointmentadd, container, false);
        this.activity = getActivity();
        edt_customername=(EditText)rootView.findViewById(R.id.edt_customername);
        edt_customephonenumber=(EditText)rootView.findViewById(R.id.edt_customephonenumber);
        btn_addjob=(Button)rootView.findViewById(R.id.btn_addjob);
        btn_addquote=(Button)rootView.findViewById(R.id.btn_addquote);
        btn_viewcustomer=(Button)rootView.findViewById(R.id.btn_viewcustomer);
        btn_addjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditJobFragment editJobFragment = new EditJobFragment();
                FragmentUtil.addFragment(activity, editJobFragment, null, false, true, "EditJobFragment");
            }
        });
        btn_addquote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddQuoteFragment addQuoteFragment = new AddQuoteFragment();
                FragmentUtil.addFragment(activity, addQuoteFragment, null, false, true, "AddQuoteFragment");
            }
        });
        btn_viewcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customerdetalils customerdetalils=new Customerdetalils();
                FragmentUtil.addFragment(activity, customerdetalils, null, false, true, "Customerdetalils");
            }
        });
        img_add=(ImageView)rootView.findViewById(R.id.img_add);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAddressInformation addcustomerbutton = new AddAddressInformation();
                FragmentUtil.addFragment(activity, addcustomerbutton, null, false, true, "AddAddressInformation");

            }
        });
        return rootView;
    }
}
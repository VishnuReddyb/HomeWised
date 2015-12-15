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
 * Created by nunc on 21-11-2015.
 */
public class LeadsListDetails extends Fragment {
    private Button btn_addquote,btn_addjob,btn_view_customer;
    ImageView home,phone;
    private Activity activity;
    View rootView;

    public LeadsListDetails(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_leadslistdetails, container, false);
        this.activity = getActivity();
        btn_addquote=(Button)rootView.findViewById(R.id.btn_addquote);
        btn_addjob=(Button)rootView.findViewById(R.id.btn_addjob);
        btn_view_customer=(Button)rootView.findViewById(R.id.btn_view_customer);

                home=(ImageView)rootView.findViewById(R.id.home);
        phone=(ImageView)rootView.findViewById(R.id.phone);
        home.setOnClickListener(new ButtonClick());
        phone.setOnClickListener(new ButtonClick());
        btn_addjob.setOnClickListener(new ButtonClick());
        btn_addquote.setOnClickListener(new ButtonClick());
        btn_view_customer.setOnClickListener(new ButtonClick());





        // Inflate the layout for this fragment
        return rootView;
    }

    private class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v==btn_addjob){
                EditJobFragment editjobfragment= new EditJobFragment();
                FragmentUtil.addFragment(activity, editjobfragment, null, false, true, "EditJobFragment");

            }else  if(v==btn_addquote){
                AddQuoteFragment addquotefragment = new AddQuoteFragment();
                FragmentUtil.addFragment(activity, addquotefragment, null, false, true, "AddQuoteFragment");

            }else if(v==phone){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7416083252"));
                startActivity(callIntent);


            }else if(v==home){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7416083252"));
                startActivity(callIntent);


            }else if(v==btn_view_customer){

                LeadViewCustomer leadviewcustomer= new LeadViewCustomer();
                FragmentUtil.addFragment(activity, leadviewcustomer, null, false, true, "LeadViewCustomer");

            }
        }
    }
}

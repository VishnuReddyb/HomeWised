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
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;

/**
 * Created by nunc on 01-12-2015.
 */
public class LeadViewCustomer extends Fragment {
private TextView text_viewcustome_email,text_viewcustomer_address,text_homenumber,text_officenumber,text_viewcustomername;
    private ImageView home,img_home;
    private Button btn_addjob,btn_addquote;
    View rootView;
    private Activity activity;
    public LeadViewCustomer() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.leadsview_customer, container, false);
this.activity=getActivity();
        btn_addjob=(Button)rootView.findViewById(R.id.btn_addjob);
        btn_addquote=(Button)rootView.findViewById(R.id.btn_addquote);

        img_home= (ImageView) rootView.findViewById(R.id.img_home);
        home= (ImageView) rootView.findViewById(R.id.home);

        text_viewcustome_email= (TextView) rootView.findViewById(R.id.text_viewcustome_email);
        text_viewcustomer_address= (TextView) rootView.findViewById(R.id.text_viewcustomer_address);
        text_homenumber= (TextView) rootView.findViewById(R.id.text_homenumber);
        text_officenumber= (TextView) rootView.findViewById(R.id.text_officenumber);
        text_viewcustomername= (TextView) rootView.findViewById(R.id.text_viewcustomername);
        img_home.setOnClickListener(new Buttonclicke());
        btn_addjob.setOnClickListener(new Buttonclicke());
        btn_addquote.setOnClickListener(new Buttonclicke());

         // Inflate the layout for this fragment
        return rootView;
    }

    private class Buttonclicke implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v==btn_addjob){
                EditJobFragment editjobfragment= new EditJobFragment();
                FragmentUtil.addFragment(activity, editjobfragment, null, false, true, "EditJobFragment");

            }
            /*else  if(v==btn_addquote){
                AddQuoteFragment addquotefragment = new AddQuoteFragment();
                FragmentUtil.addFragmentForWalker(activity, addquotefragment, null, false, true, "AddQuoteFragment");

            }*/
                else if(v==img_home){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7416083252"));
                startActivity(callIntent);


            }
            else if(v==home){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7416083252"));
                startActivity(callIntent);


            }


        }
    }
}

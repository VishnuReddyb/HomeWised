package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;
import com.nunc.Homewised.activity.adapter.CustomersAdapter;
import com.nunc.Homewised.activity.model.Customersmodel;

import java.util.ArrayList;


/**
 * Created by nunc .
 */
public class CustomersFragment extends Fragment {
    private final int PREVIOUS_TYPE = 1;
    private final int PRESENT_TYPE = 0;
    private final int PAST_TYPE = 2;
    ListView leadslistView;
    View rootView;
    private Button btn_lastsevendays, btn_today, btn_nextsevendays,btn_continue;
    private TextView text_customer_today, text_customer_lastsevendays, text_customer_nextsevendays;
    private Activity activity;

    public CustomersFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_customers, container, false);
        this.activity = getActivity();
            /*BUTTON*/
        btn_today = (Button) rootView.findViewById(R.id.btn_today);
        btn_lastsevendays = (Button) rootView.findViewById(R.id.btn_lastsevendays);
        btn_nextsevendays = (Button) rootView.findViewById(R.id.btn_nextsevendays);
        btn_continue = (Button) rootView.findViewById(R.id.btn_continue);
        /*TEXTVIEW*/
        text_customer_today = (TextView) rootView.findViewById(R.id.text_customer_today);
        text_customer_lastsevendays = (TextView) rootView.findViewById(R.id.text_customer_lastsevendays);
        text_customer_nextsevendays = (TextView) rootView.findViewById(R.id.text_customer_nextsevendays);


        btn_today.setOnClickListener(new ButtonClick());
        btn_lastsevendays.setOnClickListener(new ButtonClick());
        btn_nextsevendays.setOnClickListener(new ButtonClick());
        //btn_continue.setOnClickListener(new ButtonClick());
        customersGetingData(PRESENT_TYPE);

       // setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return rootView;
    }

    private void customersGetingData(int type) {


        ArrayList<Customersmodel>customersestlist = new ArrayList<Customersmodel>();
        Customersmodel customernames = new Customersmodel();

        customernames.setText_cusname("Accepted"+"\t"+ type);
        customersestlist.add(customernames);

        customernames  = new Customersmodel();
        customernames.setText_cusname("UnScheduled");
        customersestlist.add(customernames);

        customernames  = new Customersmodel();
        customernames.setText_cusname("Declined");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("New");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("ScheduleHold");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("Scheduled");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("ReScheduled");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("WorkStarted");
        customernames  = new Customersmodel();
        customernames.setText_cusname("WorkOnHold");
        customersestlist.add(customernames);
      customernames  = new Customersmodel();
        customernames.setText_cusname("OnWayToWork");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("Cancelled");
        customernames  = new Customersmodel();
        customernames.setText_cusname("Completed");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("Rejected");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("Invoiced");
        customernames  = new Customersmodel();
        customernames.setText_cusname("Revised");
        customersestlist.add(customernames);
        customernames  = new Customersmodel();
        customernames.setText_cusname("Archived");

        customersestlist.add(customernames);



        updateList(customersestlist);
    }


    private void updateList(ArrayList<Customersmodel> customerstlistData) {
         leadslistView = (ListView) rootView.findViewById(R.id.customer_list);
        //this.leadslistView.setSelector(R.drawable.button_background);
        //leadslistView.setSelector(R.drawable.list_item_selector);
       /* leadslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i=0; i<leadslistView.getAdapter().getCount();i++)
                {
                    leadslistView.getChildAt(i).setBackgroundColor(Color.GRAY);
                }

                parent.getChildAt(position).setBackgroundColor(Color.TRANSPARENT);
            }
        });*/
        leadslistView.setAdapter(new CustomersAdapter(activity, customerstlistData));
        leadslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customerdetalils customerdetalils=new Customerdetalils();
                FragmentUtil.addFragment(activity, customerdetalils, null, false, true, "Customerdetalils");
            }
        });
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (menu.findItem(R.id.action_plus) != null)
            menu.findItem(R.id.action_plus).setVisible(false);

    }


    private class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == btn_today) {
                btn_today.setBackgroundColor(getResources().getColor(R.color.white));
                btn_today.setTextColor(getResources().getColor(R.color.blue));
                btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.blue));
                btn_today.setTextColor(getResources().getColor(R.color.white));
                btn_today.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_nextsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_nextsevendays.setTextColor(getResources().getColor(R.color.blue));

                text_customer_today.setVisibility(View.VISIBLE);
                text_customer_lastsevendays.setVisibility(View.GONE);
                text_customer_nextsevendays.setVisibility(View.GONE);

                customersGetingData(PRESENT_TYPE);

            } else if (v == btn_lastsevendays) {
                btn_today.setBackgroundColor(getResources().getColor(R.color.white));
                btn_today.setTextColor(getResources().getColor(R.color.blue));
                /*btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.blue));*/
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_nextsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_nextsevendays.setTextColor(getResources().getColor(R.color.blue));


                text_customer_today.setVisibility(View.GONE);
                text_customer_lastsevendays.setVisibility(View.VISIBLE);
                text_customer_nextsevendays.setVisibility(View.GONE);
                customersGetingData(PREVIOUS_TYPE);


            } else if (v == btn_nextsevendays) {
                btn_today.setBackgroundColor(getResources().getColor(R.color.white));
                btn_today.setTextColor(getResources().getColor(R.color.blue));
                btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.blue));
                btn_nextsevendays.setTextColor(getResources().getColor(R.color.white));
                btn_nextsevendays.setBackgroundColor(getResources().getColor(R.color.blue));
                text_customer_today.setVisibility(View.GONE);
                text_customer_lastsevendays.setVisibility(View.GONE);
                text_customer_nextsevendays.setVisibility(View.VISIBLE);
                customersGetingData(PAST_TYPE);


            }
           /* else if (v==btn_continue){
                SignatureFragment signatureFragment=new SignatureFragment();
                FragmentUtil.addFragmentForWalker(activity, signatureFragment, null, false, true, "SignatureFragment");
                //Toast.makeText(activity, "btn_continue ", Toast.LENGTH_SHORT).show();


            }*/

        }
    }
}

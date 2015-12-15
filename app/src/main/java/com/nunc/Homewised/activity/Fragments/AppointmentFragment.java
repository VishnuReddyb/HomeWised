package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.adapter.AppointmentAdapter;
import com.nunc.Homewised.activity.model.Appointment;

import java.util.ArrayList;



/**
 * Created by NUNC.
 */
public class AppointmentFragment extends Fragment {
    public static final String ARG_PLANET_NUMBER = "planet_number";

    private Activity activity;
    View rootView;
    ListView listView;
    private Button btn_nextsevendays, btn_today, btn_lastsevendays;
    private TextView text_todays,text_nextsevendays,text_lastsevendays;
    private final  int PREVIOUS_TYPE=0;
    private final  int PRESENT_TYPE=1;
    private final  int PAST_TYPE=2;

    public AppointmentFragment() {

        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.appointmentlist, container, false);
        btn_nextsevendays = (Button) rootView.findViewById(R.id.btn_nextsevendays);
        btn_lastsevendays = (Button) rootView.findViewById(R.id.btn_lastsevendays);
        btn_today = (Button) rootView.findViewById(R.id.btn_today);
        /*Textview*/
         text_todays=(TextView)rootView.findViewById(R.id.text_todays);
        text_nextsevendays=(TextView)rootView.findViewById(R.id.text_nextsevendays);
        text_lastsevendays=(TextView)rootView.findViewById(R.id.text_lastsevendays);


        btn_today.setOnClickListener(new ButtonClick());
        btn_lastsevendays.setOnClickListener(new ButtonClick());
        btn_nextsevendays.setOnClickListener(new ButtonClick());

        this.activity = getActivity();
        Log.e("Today Button Clicke",text_todays.getText().toString());
        getListData(PRESENT_TYPE);



        // Inflate the layout for this fragment
        return rootView;
    }
    private void getListData(int type){

        ArrayList<Appointment> Appointmentlist = new ArrayList<Appointment>();
        Appointment appointmentpage = new Appointment();
        appointmentpage.setJobid("Vishnu" + "\t" + "Pagenumber" + type);
      //  appointmentpage.setText_airconditon_repair("Air Conditioning Reapir");
        appointmentpage.setText_airconditon_time("12/11/2015  02:30PM   12/11/2015  04:30PM");
        appointmentpage.setText_airconditon_address("Mark Hiller Phone-201 345 567");
        appointmentpage.setText_cust("CUST -1019");
        Appointmentlist.add(appointmentpage);
        appointmentpage = new Appointment();
        appointmentpage.setJobid(" Naresh" );
       // appointmentpage.setText_airconditon_repair("Air Conditioning Reapir");
        appointmentpage.setText_airconditon_time("12/11/2015  01:30PM   12/11/2015  03:30PM");
        appointmentpage.setText_airconditon_address("Mark Hiller Phone-201 345 567");
        appointmentpage.setText_cust("CUST -2039");
        Appointmentlist.add(appointmentpage);
        appointmentpage = new Appointment();
        appointmentpage.setJobid(" Ashok" );
       // appointmentpage.setText_airconditon_repair("Air Conditioning Reapir");
        appointmentpage.setText_airconditon_time("12/11/2015  10:30AM   12/11/2015  12:30PM");
        appointmentpage.setText_airconditon_address("Mark Hiller Phone-201 345 567");
        appointmentpage.setText_cust("CUST -2039");
        Appointmentlist.add(appointmentpage);

        updateList(Appointmentlist);
    }



    private void updateList(ArrayList<Appointment> appointmentlistData) {

        listView = (ListView) rootView.findViewById(R.id.appointment_list);






        listView.setAdapter(new AppointmentAdapter(activity, appointmentlistData));
    }


    private class ButtonClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v==btn_today){
                btn_today.setBackgroundColor(getResources().getColor(R.color.white));
                btn_today.setTextColor(getResources().getColor(R.color.blue));
                btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.blue));
                btn_today.setTextColor(getResources().getColor(R.color.white));
                btn_today.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_nextsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_nextsevendays.setTextColor(getResources().getColor(R.color.blue));


                text_todays.setVisibility(View.VISIBLE);
                text_nextsevendays.setVisibility(View.GONE);
                text_lastsevendays.setVisibility(View.GONE);
                getListData(PRESENT_TYPE);

            }else if(v==btn_lastsevendays){
                btn_today.setBackgroundColor(getResources().getColor(R.color.white));
                btn_today.setTextColor(getResources().getColor(R.color.blue));
              /*  btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.blue));*/
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_nextsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_nextsevendays.setTextColor(getResources().getColor(R.color.blue));

                text_todays.setVisibility(View.GONE);
                text_nextsevendays.setVisibility(View.GONE);
                text_lastsevendays.setVisibility(View.VISIBLE);
                getListData(PREVIOUS_TYPE);

            }else if(v==btn_nextsevendays){
               btn_today.setBackgroundColor(getResources().getColor(R.color.white));
                btn_today.setTextColor(getResources().getColor(R.color.blue));
                btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.blue));
              btn_nextsevendays.setTextColor(getResources().getColor(R.color.white));
                btn_nextsevendays.setBackgroundColor(getResources().getColor(R.color.blue));


                text_todays.setVisibility(View.GONE);
                text_nextsevendays.setVisibility(View.VISIBLE);
                text_lastsevendays.setVisibility(View.GONE);
                getListData(PAST_TYPE);

            }

        }
    }
}

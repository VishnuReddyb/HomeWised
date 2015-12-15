package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.adapter.LeadsAdapter;
import com.nunc.Homewised.activity.model.Leads;

import java.util.ArrayList;

/**
 * Created NUNC.
 */
public class LeadsFragments extends Fragment {
    private Activity activity;
    private Button btn_lastsevendays, btn_today;
    View rootView;
    private TextView text_leads_todays, text_leads_sevendays;

    private final int PREVIOUS_TYPE = 1;
    private final int PRESENT_TYPE = 0;


    ListView listView;

    public LeadsFragments() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_leads, container, false);


        btn_lastsevendays = (Button) rootView.findViewById(R.id.btn_lastsevendays);
        btn_today = (Button) rootView.findViewById(R.id.btn_today);

        /*Textview*/
        text_leads_todays = (TextView) rootView.findViewById(R.id.text_leads_todays);
        text_leads_sevendays = (TextView) rootView.findViewById(R.id.text_leads_sevendays);

setHasOptionsMenu(true);
        this.activity = getActivity();
        // Inflate the layout for this fragment

        btn_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.white));
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.blue));
                btn_today.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_today.setTextColor(getResources().getColor(R.color.white));
                text_leads_sevendays.setVisibility(View.GONE);
                text_leads_todays.setVisibility(View.VISIBLE);
                updateList(PRESENT_TYPE);

            }
        });
        btn_lastsevendays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_lastsevendays.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_lastsevendays.setTextColor(getResources().getColor(R.color.white));
                btn_today.setBackgroundColor(getResources().getColor(R.color.white));
                btn_today.setTextColor(getResources().getColor(R.color.blue));
                text_leads_sevendays.setVisibility(View.VISIBLE);
                text_leads_todays.setVisibility(View.GONE);
                updateList(PREVIOUS_TYPE);
            }
        });
        updateList(PRESENT_TYPE);
        return rootView;
    }


    private void updateList(int type) {
        ArrayList<Leads> Leadslist = new ArrayList<Leads>();
        Leads leads = new Leads();
        leads.setText_name(" Joshua (TEST)Rowe (TEST)");
        leads.setText_address("Test Address,TestCity,MI,11111,us\nPhone-201 345 567" + type);

       // leads.setText_notes("Notes:Need Services ASAP\n" +"{" + "Pagenumber" + type + "}");
        Leadslist.add(leads);
        leads = new Leads();
        leads.setText_name(" Ashok (TEST)Rowe (TEST)");
        leads.setText_address("Test Address,TestCity,MI,11111,us\nPhone-201 345 567"+type);

       // leads.setText_notes("Notes:Need Services ASAP\n" + "{" + "Pagenumber" + type + "}");
        Leadslist.add(leads);
        LeadsupdateList(Leadslist);


    }

    private void LeadsupdateList(ArrayList<Leads> leadslistData) {
        ListView leadslistView = (ListView) rootView.findViewById(R.id.Leads_list);

        leadslistView.setAdapter(new LeadsAdapter(activity, leadslistData));

    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (menu.findItem(R.id.action_plus) != null)
            menu.findItem(R.id.action_plus).setVisible(false);

    }
}
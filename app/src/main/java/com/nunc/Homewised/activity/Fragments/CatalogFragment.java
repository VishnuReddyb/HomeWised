package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;
import com.nunc.Homewised.activity.adapter.CatalogAdapter;
import com.nunc.Homewised.activity.model.Catalog;

import java.util.ArrayList;

/**
 * Created by NUNC.
 */
public class CatalogFragment extends Fragment {
    private EditText edt_search;
    //catalog_list
    View rootView;
    private Activity activity;
    public CatalogFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.fragment_catalog, container, false);
        this.activity = getActivity();
        edt_search=(EditText)rootView.findViewById(R.id.edt_search);
        //edt_search.clearComposingText();
CatalogUpdates();
        // Inflate the layout for this fragment
        return rootView;
    }

    private void CatalogUpdates() {
        ArrayList<Catalog> Cataloglist = new ArrayList<Catalog>();
        Catalog catalogs = new Catalog();
        catalogs.setText_airfilter_title("Home Wised");
        catalogs.setText_price("$20.59");
        catalogs.setText_airfilter_address("GE,WAP204090");
        catalogs.setText_airfilter_name("Home Wised");

        Cataloglist.add(catalogs);
        catalogs = new Catalog();
        catalogs.setText_airfilter_title("Vishnu");
        catalogs.setText_price("$40.00");
        catalogs.setText_airfilter_address("GE,WSX4050789");
        catalogs.setText_airfilter_name("Vishnu");
        Cataloglist.add(catalogs);
        ListView listView = (ListView) rootView.findViewById(R.id.catalog_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(activity,
//                        "Click ListItem Number " + position, Toast.LENGTH_SHORT)
//                        .show();
                CatalogDetails  catalogdetails = new CatalogDetails();
                FragmentUtil.addFragment(activity, catalogdetails, null, false, true, "CatalogDetails");
            }
        });
        listView.setAdapter(new CatalogAdapter(activity, Cataloglist));


    }


}

package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;

/**
 * Created by nunc on 19-11-2015.
 */
public class CatalogDetails extends Fragment {
    private TextView text_catdetails_lenght, text_catdetails_price, text_catdetails_width, text_catdetails_hight, text_catdetails_brandname,
            text_catdetails_serialnumber, text_catdetails_airfiltername;
    private Button btn_editproduct;

    View rootView;
    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.catalogdetails, container, false);
        this.activity = getActivity();

        btn_editproduct = (Button) rootView.findViewById(R.id.btn_editproduct);
        text_catdetails_lenght = (TextView) rootView.findViewById(R.id.text_catdetails_lenght);
        text_catdetails_price = (TextView) rootView.findViewById(R.id.text_catdetails_price);
        text_catdetails_width = (TextView) rootView.findViewById(R.id.text_catdetails_width);
        text_catdetails_hight = (TextView) rootView.findViewById(R.id.text_catdetails_hight);
        text_catdetails_brandname = (TextView) rootView.findViewById(R.id.text_catdetails_brandname);
        text_catdetails_serialnumber = (TextView) rootView.findViewById(R.id.text_catdetails_serialnumber);
        text_catdetails_airfiltername = (TextView) rootView.findViewById(R.id.text_catdetails_airfiltername);


        btn_editproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CatalogEditProduct catalogeditproduct = new CatalogEditProduct();
               FragmentUtil.addFragment(activity, catalogeditproduct, null, false, true, "CatalogEditProduct");
            }
        });
        return rootView;
    }
}


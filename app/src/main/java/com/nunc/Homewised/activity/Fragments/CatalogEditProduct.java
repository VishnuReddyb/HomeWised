package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;

/**
 * Created by nunc on 19-11-2015.
 */
public class CatalogEditProduct extends Fragment {
    View rootView;
    private Activity activity;
    private LinearLayout add_product, produce_umo;
    private Button btn_add_product, btn_product_umo, btn_done;
    private EditText edt_catalogsearch, edt_productname, edt_description, edt_serialnumber, edt_brandname, edt_warranty_period, edt_warranty_team,
            edt_catalog_length, edt_catalog_umo, edt_catalog_width, edt_catalog_width_umo, edt_catalog_height, edt_catalog_height_umo,
            edt_catalog_quantity, edt_catalog_quantity_umo, edt_catalog_price, edt_catalog_price_umo, edt_catalog_comment;
    private final  int PREVIOUS_TYPE=0;
    private final  int PRESENT_TYPE=1;
    private final  int PAST_TYPE=2;
    public CatalogEditProduct() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.editcatalog, container, false);
        this.activity = getActivity();
        /*Buttons ids*/
        btn_add_product = (Button) rootView.findViewById(R.id.btn_add_product);
        btn_product_umo = (Button) rootView.findViewById(R.id.btn_product_umo);
        btn_done = (Button) rootView.findViewById(R.id.btn_done);

        /*LinerLayouts ids*/
        add_product = (LinearLayout) rootView.findViewById(R.id.add_product);
        produce_umo = (LinearLayout) rootView.findViewById(R.id.produce_umo);
        /*EditTedt ids*/
        /*ADD PRODUCT*/
        edt_catalogsearch=(EditText)rootView.findViewById(R.id.edt_catalogsearch);
        edt_productname=(EditText)rootView.findViewById(R.id.edt_productname);
        edt_description=(EditText)rootView.findViewById(R.id.edt_description);
        edt_serialnumber=(EditText)rootView.findViewById(R.id.edt_serialnumber);
        edt_brandname=(EditText)rootView.findViewById(R.id.edt_brandname);
        edt_warranty_period=(EditText)rootView.findViewById(R.id.edt_warranty_period);
        edt_warranty_team=(EditText)rootView.findViewById(R.id.edt_warranty_team);


        /*PRODUCT UMO*/
        edt_catalog_length=(EditText)rootView.findViewById(R.id.edt_catalog_length);
        edt_catalog_umo=(EditText)rootView.findViewById(R.id.edt_catalog_umo);
        edt_catalog_width=(EditText)rootView.findViewById(R.id.edt_catalog_width);
        edt_catalog_width_umo=(EditText)rootView.findViewById(R.id.edt_catalog_width_umo);
        edt_catalog_height=(EditText)rootView.findViewById(R.id.edt_catalog_height);
        edt_catalog_height_umo=(EditText)rootView.findViewById(R.id.edt_catalog_height_umo);
        edt_catalog_quantity=(EditText)rootView.findViewById(R.id.edt_catalog_quantity);
        edt_catalog_quantity_umo=(EditText)rootView.findViewById(R.id.edt_catalog_quantity_umo);
        edt_catalog_price=(EditText)rootView.findViewById(R.id.edt_catalog_price);
        edt_catalog_price_umo=(EditText)rootView.findViewById(R.id.edt_catalog_price_umo);
        edt_catalog_comment=(EditText)rootView.findViewById(R.id.edt_catalog_comment);



        btn_add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                produce_umo.setVisibility(View.GONE);
                add_product.setVisibility(View.VISIBLE);
                btn_add_product.setTextColor(getResources().getColor(R.color.white));
                btn_add_product.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_product_umo.setBackgroundColor(getResources().getColor(R.color.white));
                btn_product_umo.setTextColor(getResources().getColor(R.color.blue));

            }
        });
        btn_product_umo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                produce_umo.setVisibility(View.VISIBLE);
                add_product.setVisibility(View.GONE);
                btn_add_product.setBackgroundColor(getResources().getColor(R.color.white));
                btn_product_umo.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_product_umo.setTextColor(getResources().getColor(R.color.white));
                btn_add_product.setTextColor(getResources().getColor(R.color.blue));

            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edt_catalogsearch.getText().toString().trim().length() > 0 &&
                        edt_productname.getText().toString().trim().length() > 0 &&
                        edt_description.getText().toString().trim().length() > 0 &&
                        edt_serialnumber.getText().toString().trim().length() > 0 &&
                        edt_brandname.getText().toString().trim().length() > 0 &&
                        edt_warranty_period.getText().toString().trim().length() > 0 &&
                        edt_warranty_team.getText().toString().trim().length() > 0 &&
                        edt_catalog_length.getText().toString().trim().length() > 0 &&
                        edt_catalog_umo.getText().toString().trim().length() > 0 &&
                        edt_catalog_width.getText().toString().trim().length() > 0 &&
                        edt_catalog_width_umo.getText().toString().trim().length() > 0 &&
                        edt_catalog_height.getText().toString().trim().length() > 0 &&
                        edt_catalog_height_umo.getText().toString().trim().length() > 0 &&
                        edt_catalog_quantity.getText().toString().trim().length() > 0 &&
                        edt_catalog_quantity_umo.getText().toString().trim().length() > 0 &&
                        edt_catalog_price.getText().toString().trim().length() > 0 &&
                        edt_catalog_price_umo.getText().toString().trim().length() > 0 &&
                        edt_catalog_comment.getText().toString().trim().length() > 0) {


                    AppointmentFragment appointmentfragment = new AppointmentFragment();
                    FragmentUtil.addFragment(activity, appointmentfragment, null, false, true, "AppointmentFragment");
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.setCustomAnimations(R.anim.fedin, R.anim.fedout);
                } else {
                    Toast.makeText(activity, "Please Enter All Fields",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
} /**/

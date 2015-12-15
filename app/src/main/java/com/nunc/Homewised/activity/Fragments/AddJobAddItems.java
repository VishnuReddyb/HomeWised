package com.nunc.Homewised.activity.Fragments;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;
import com.nunc.Homewised.activity.TimeAndDate.Constants;
import com.nunc.Homewised.activity.model.ItemObject;
import com.nunc.Homewised.activity.model.JobObject;

/**
 * Created by nunc on 20-11-2015.
 */
public class AddJobAddItems extends Fragment {
    View rootView;
    private Button  btn_cancel, btn_done;
    private Activity activity;
    ActionBar actionbar;
    private Switch btn_switch;
    private EditText edt_addcatalog,edt_itemname,edt_description,edt_itemnumber,edt_manufacturer,
            edt_dimes_L,edt_dimes_W,edt_dimes_H,edt_umo_L,edt_umo_W,edt_umo_H,edt_quantity,edt_uniteprice,edt_labor;
     JobObject jobDataObject;
    private int  selectedPosition=-1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      Bundle bundle=getArguments();
         jobDataObject=(JobObject)bundle.getSerializable("OBJECT");
        int value=bundle.getInt("extraparamInt");
        if(value>Constants.OPTIONAL_PARAM_INT){
            selectedPosition=value;
        }


        rootView = inflater.inflate(R.layout.addjob_additemes, container, false);
        this.activity = getActivity();

        //this.activity.getActionBar().hide();
       // actionbar=getActionBar();
//        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        edt_addcatalog=(EditText)rootView.findViewById(R.id.edt_addcatalog);
        edt_itemname=(EditText)rootView.findViewById(R.id.edt_itemname);
        edt_description=(EditText)rootView.findViewById(R.id.edt_description);
        edt_itemnumber=(EditText)rootView.findViewById(R.id.edt_itemnumber);
        edt_manufacturer=(EditText)rootView.findViewById(R.id.edt_manufacturer);
        edt_dimes_L=(EditText)rootView.findViewById(R.id.edt_dimes_L);
        edt_dimes_W=(EditText)rootView.findViewById(R.id.edt_dimes_W);
        edt_dimes_H=(EditText)rootView.findViewById(R.id.edt_dimes_H);
        edt_umo_L=(EditText)rootView.findViewById(R.id.edt_umo_L);
        edt_umo_W=(EditText)rootView.findViewById(R.id.edt_umo_W);
        edt_umo_H=(EditText)rootView.findViewById(R.id.edt_umo_H);
        edt_quantity=(EditText)rootView.findViewById(R.id.edt_quantity);
        edt_uniteprice=(EditText)rootView.findViewById(R.id.edt_uniteprice);
        edt_labor=(EditText)rootView.findViewById(R.id.edt_labor);


        btn_cancel=(Button)rootView.findViewById(R.id.btn_cancel);
        btn_done=(Button)rootView.findViewById(R.id.btn_done);


        if(selectedPosition>-1){
            bindValuesToUI(selectedPosition);
        }




        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_addcatalog.getText().toString().trim().length()>0&&
                                edt_itemname.getText().toString().trim().length()>0&&
                                edt_description.getText().toString().trim().length()>0&&
                                edt_itemnumber.getText().toString().trim().length()>0&&
                                edt_manufacturer.getText().toString().trim().length()>0&&
                                edt_dimes_L.getText().toString().trim().length()>0&&
                                edt_dimes_W.getText().toString().trim().length()>0&&
                                edt_dimes_H.getText().toString().trim().length()>0&&
                                edt_umo_L.getText().toString().trim().length()>0&&
                                edt_umo_W.getText().toString().trim().length()>0&&
                                edt_umo_H.getText().toString().trim().length()>0&&
                                edt_quantity.getText().toString().trim().length()>0&&
                                edt_uniteprice.getText().toString().trim().length()>0&&
                                edt_labor.getText().toString().trim().length()>0){

                    addDataToJobObject();

                    AddQuoteFragment  addjobfragment = new AddQuoteFragment();
                    FragmentUtil.addFragmentwithObject(activity, addjobfragment, jobDataObject, null, false, true, "AddQuoteFragment", Constants.OPTIONAL_PARAM_INT);
                }else{
                    Toast.makeText(activity, "Please Enter All Fields",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditJobFragment  editjobfragment = new EditJobFragment();
                FragmentUtil.addFragment(activity, editjobfragment, null, false, true, "EditJobFragment");
            }
        });

        return rootView;
    }


    private void addDataToJobObject(){
        ItemObject itemObj=new ItemObject();
        itemObj.setCatalogName(edt_addcatalog.getText().toString());
        itemObj.setItemName(edt_itemname.getText().toString());
        itemObj.setDescriptionName(edt_description.getText().toString());
        itemObj.setItemNumber(edt_itemnumber.getText().toString());
        itemObj.setManufactuer(edt_manufacturer.getText().toString());
        itemObj.setDimensionsL(Double.parseDouble(edt_dimes_L.getText().toString()));
        itemObj.setDimensionsW(Double.parseDouble(edt_dimes_W.getText().toString()));
        itemObj.setDimensionsH(Double.parseDouble(edt_dimes_H.getText().toString()));
        itemObj.setUmoL(Double.parseDouble(edt_umo_L.getText().toString()));
        itemObj.setUmoW(Double.parseDouble(edt_umo_W.getText().toString()));
        itemObj.setUmoH(Double.parseDouble(edt_umo_H.getText().toString()));
        itemObj.setQuantity(Double.parseDouble(edt_quantity.getText().toString()));
        itemObj.setUnitePrice(Double.parseDouble(edt_uniteprice.getText().toString()));
        itemObj.setLabor(Double.parseDouble(edt_labor.getText().toString()));

        if(selectedPosition>-1){
            jobDataObject.getLitemsList().set(selectedPosition,itemObj);
        }
        else{
            jobDataObject.getLitemsList().add(itemObj);
        }


    }

    private void bindValuesToUI(int selectedPosition){

        ItemObject editItemObject=jobDataObject.getLitemsList().get(selectedPosition);
        edt_addcatalog.setText(editItemObject.getCatalogName());
        edt_itemname.setText(editItemObject.getItemName());
        edt_description.setText(editItemObject.getDescriptionName());
        edt_itemnumber.setText(editItemObject.getItemNumber());
        edt_manufacturer.setText(editItemObject.getManufactuer());
        edt_dimes_L.setText(Double.toString(editItemObject.getDimensionsL()));
        edt_dimes_W.setText(Double.toString(editItemObject.getDimensionsW()));
        edt_dimes_H.setText(Double.toString(editItemObject.getDimensionsH()));
        edt_umo_L.setText(Double.toString(editItemObject.getUmoL()));
        edt_umo_H.setText(Double.toString(editItemObject.getUmoH()));
        edt_umo_W.setText(Double.toString(editItemObject.getUmoW()));
        edt_quantity.setText(Double.toString(editItemObject.getQuantity()));
        edt_uniteprice.setText(Double.toString(editItemObject.getUnitePrice()));
        edt_labor.setText(Double.toString(editItemObject.getLabor()));


        //
    }
}

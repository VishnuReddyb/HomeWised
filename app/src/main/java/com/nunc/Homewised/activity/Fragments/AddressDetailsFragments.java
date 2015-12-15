package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;
import com.nunc.Homewised.activity.TimeAndDate.Constants;
import com.nunc.Homewised.activity.model.AddressObj;
import com.nunc.Homewised.activity.model.CustomerObject;


/**
 * Created by nunc.
 */
public class AddressDetailsFragments extends Fragment {
    private EditText edt_type,edt_address1,edt_address2,edt_city,edt_county,edt_zipcode,edt_country;
    private Spinner spinner_state;
    private Button btn_cancel,btn_done;
    private CheckBox check_serviceaddress;
    View rootView;
    private Activity activity;
    CustomerObject customerObject;
      private int  selectedPosition=-1;
    public AddressDetailsFragments() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_addressdetalis, container, false);
         activity = getActivity();


        Bundle bundle=getArguments();
        customerObject=(CustomerObject)bundle.getSerializable("OBJECT");
        int value=bundle.getInt("extraparamInt");
        if(value> Constants.OPTIONAL_PARAM_INT){
            selectedPosition=value;
        }


        check_serviceaddress= (CheckBox) rootView.findViewById(R.id.check_serviceaddress);
        spinner_state=(Spinner)rootView.findViewById(R.id.spinner_state);
        edt_type= (EditText) rootView.findViewById(R.id.edt_type);
        edt_address1= (EditText) rootView.findViewById(R.id.edt_address1);
        edt_address2= (EditText) rootView.findViewById(R.id.edt_address2);
        edt_city= (EditText) rootView.findViewById(R.id.edt_city);
        edt_county= (EditText) rootView.findViewById(R.id.edt_county);
        edt_zipcode= (EditText) rootView.findViewById(R.id.edt_zipcode);
        edt_country= (EditText) rootView.findViewById(R.id.edt_country);
        btn_cancel= (Button) rootView.findViewById(R.id.btn_cancel);
        btn_done= (Button) rootView.findViewById(R.id.btn_done);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btn_cancel.ca

            }
        });






        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( edt_address1.getText().toString().trim().length() > 0

                        && edt_city.getText().toString().trim().length() > 0
                        && spinner_state.toString().trim().length() > 0

                        && edt_zipcode.getText().toString().trim().length() > 0
                        &&
                        edt_country.getText().toString().trim().length() > 0) {
                    addDataToCustomerObject();

                    Toast.makeText(activity, "successfully added data",
                            Toast.LENGTH_SHORT).show();
                    AddAddressInformation addcustomerbutton = new AddAddressInformation();
                    FragmentUtil.addFragment(getActivity(),
                            addcustomerbutton, null, false, true,
                            "AddAddressInformation");
                } else {
                    Toast.makeText(activity, "Please Enter All Fields",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        check_serviceaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }



    private void addDataToCustomerObject() {
        AddressObj addressObj=new AddressObj();
        addressObj.setType(edt_type.getText().toString());
        addressObj.setAddress1(edt_address1.getText().toString());
        addressObj.setAddress2(edt_address2.getText().toString());
        addressObj.setCity(edt_city.getText().toString());
        addressObj.setCounty(edt_county.getText().toString());
        addressObj.setStates(spinner_state.getSelectedItem().toString());
        addressObj.setZipcode(edt_zipcode.getText().toString());
        addressObj.setCountry(edt_country.getText().toString());
        if(selectedPosition==Constants.PRIMARYADDRESS){
            customerObject.setPrimaryAddress(addressObj);
            if(check_serviceaddress.isChecked()){
                customerObject.setServiceAddress(addressObj);
            }

        }else if (selectedPosition==Constants.SERVICEADDRESS){

            customerObject.setServiceAddress(addressObj);

        }



    }



}

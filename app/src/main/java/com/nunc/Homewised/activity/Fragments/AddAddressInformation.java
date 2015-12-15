package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;
import com.nunc.Homewised.activity.PhoneNumberUsFormat;
import com.nunc.Homewised.activity.TimeAndDate.Constants;
import com.nunc.Homewised.activity.model.CustomerObject;

import java.util.Locale;

/**
 * Created NUNC.
 */
public class AddAddressInformation extends Fragment {
    View rootView;

    private Spinner spinner_state;
    private EditText edt_companyname, edt_firstname, edt_middelname, edt_lastname, edt_username, edt_email, edt_type,
            edt_address1, edt_address2, edt_city, edt_zipcode, edt_county, edt_country,
            edt_phone, edt_mobilenumber, edt_homephone, edt_fax, edt_alt_email;
    //edt_password,,
    private EditText edt_hearabout, edt_preferred_communcation, edt_industry, edt_notes;
    private Button btn_otherinfo, btn_address, btn_profileinfo, btn_save;
    private boolean status;
    private LinearLayout lin_profileinfo, lin_address, lin_addbutton, lin_total_layout, lin_otherinfo, lin_address_details;
    private RelativeLayout rel_officeaddress, rel_serviceaddress, rel_primaryaddress;
    private TextView text_address, text_profile;
    private Activity activity;
    private CustomerObject customerObject= new CustomerObject();


    public AddAddressInformation() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.addcustomerinformation, container, false);
        activity = getActivity();
        edt_companyname = (EditText) rootView.findViewById(R.id.edt_companyname);
        edt_firstname = (EditText) rootView.findViewById(R.id.edt_firstname);
        edt_middelname = (EditText) rootView.findViewById(R.id.edt_middelname);
        edt_lastname = (EditText) rootView.findViewById(R.id.edt_lastname);
        edt_username = (EditText) rootView.findViewById(R.id.edt_username);
        edt_phone = (EditText) rootView.findViewById(R.id.edt_phone);
        edt_mobilenumber = (EditText) rootView.findViewById(R.id.edt_mobilenumber);
        edt_homephone = (EditText) rootView.findViewById(R.id.edt_homephone);
        // edt_password = (EditText) rootView.findViewById(R.id.edt_password);
        edt_fax = (EditText) rootView.findViewById(R.id.edt_fax);
        edt_email = (EditText) rootView.findViewById(R.id.edt_email);
        edt_type = (EditText) rootView.findViewById(R.id.edt_type);
        edt_address1 = (EditText) rootView.findViewById(R.id.edt_address1);
        edt_address2 = (EditText) rootView.findViewById(R.id.edt_address2);
        edt_city = (EditText) rootView.findViewById(R.id.edt_city);
        edt_zipcode = (EditText) rootView.findViewById(R.id.edt_zipcode);
        edt_county = (EditText) rootView.findViewById(R.id.edt_county);
        edt_country = (EditText) rootView.findViewById(R.id.edt_country);
        edt_alt_email = (EditText) rootView.findViewById(R.id.edt_alt_email);

        spinner_state = (Spinner) rootView.findViewById(R.id.spinner_state);

        /*other information*/
        edt_hearabout = (EditText) rootView.findViewById(R.id.edt_hearabout);
        edt_preferred_communcation = (EditText) rootView.findViewById(R.id.edt_preferred_communcation);
        edt_industry = (EditText) rootView.findViewById(R.id.edt_industry);
        edt_notes = (EditText) rootView.findViewById(R.id.edt_notes);


        // btn_edit = (Button) rootView.findViewById(R.id.btn_edit);
        btn_save = (Button) rootView.findViewById(R.id.btn_save);

        btn_address = (Button) rootView.findViewById(R.id.btn_address);
        btn_profileinfo = (Button) rootView.findViewById(R.id.btn_profileinfo);
        btn_otherinfo = (Button) rootView.findViewById(R.id.btn_otherinfo);



        lin_profileinfo = (LinearLayout) rootView.findViewById(R.id.lin_profileinfo);
        lin_address = (LinearLayout) rootView.findViewById(R.id.lin_address);
        lin_otherinfo = (LinearLayout) rootView.findViewById(R.id.lin_otherinfo);
        lin_address_details = (LinearLayout) rootView.findViewById(R.id.lin_address_details);

        rel_officeaddress = (RelativeLayout) rootView.findViewById(R.id.rel_officeaddress);
        rel_serviceaddress = (RelativeLayout) rootView.findViewById(R.id.rel_serviceaddress);
        rel_primaryaddress = (RelativeLayout) rootView.findViewById(R.id.rel_primaryaddress);

        //lin_addbutton=(LinearLayout)rootView.findViewById(R.id.lin_addbutton);

        // lin_total_layout=(LinearLayout)rootView.findViewById(R.id.lin_total_layout);

        PhoneNumberUsFormat edt_mobilenumber1 = new PhoneNumberUsFormat();
        edt_mobilenumber.addTextChangedListener(edt_mobilenumber1);

        PhoneNumberUsFormat edt_homephone1 = new PhoneNumberUsFormat();
        edt_homephone.addTextChangedListener(edt_homephone1);


        UsFormatNumber edt_phone1 = new UsFormatNumber(edt_phone);
        edt_phone.addTextChangedListener(edt_phone1);

        text_address = (TextView) rootView.findViewById(R.id.text_address);
        text_profile = (TextView) rootView.findViewById(R.id.text_profile);



        rel_primaryaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddressDetailsFragments addressdetailsfragments = new AddressDetailsFragments();
                /*FragmentUtil.addFragment(getActivity(),
                        addressdetailsfragments, null, false, true,
                        "AddressDetailsFragments");
*/
                FragmentUtil.addFragmentwithObject(getActivity(), addressdetailsfragments, customerObject, null, false, true, "AddressDetailsFragments", Constants.PRIMARYADDRESS);


            }
        });
        rel_serviceaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressDetailsFragments addressdetailsfragments = new AddressDetailsFragments();
                FragmentUtil.addFragmentwithObject(getActivity(), addressdetailsfragments, customerObject, null, false, true, "AddressDetailsFragments", Constants.SERVICEADDRESS);




            }
        });

        btn_profileinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_address.setBackgroundColor(getResources().getColor(R.color.white));
                btn_address.setTextColor(getResources().getColor(R.color.blue));
                btn_profileinfo.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_profileinfo.setTextColor(getResources().getColor(R.color.white));
                btn_otherinfo.setBackgroundColor(getResources().getColor(R.color.white));
                btn_otherinfo.setTextColor(getResources().getColor(R.color.blue));


                lin_profileinfo.setVisibility(View.VISIBLE);
                lin_otherinfo.setVisibility(View.GONE);
                lin_address.setVisibility(View.GONE);

                //lin_total_layout.setVisibility(View.VISIBLE);


            }
        });
        btn_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_address.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_address.setTextColor(getResources().getColor(R.color.white));
                btn_profileinfo.setBackgroundColor(getResources().getColor(R.color.white));
                btn_profileinfo.setTextColor(getResources().getColor(R.color.blue));
                btn_otherinfo.setBackgroundColor(getResources().getColor(R.color.white));
                btn_otherinfo.setTextColor(getResources().getColor(R.color.blue));

                lin_profileinfo.setVisibility(View.GONE);
                // lin_total_layout.setVisibility(View.VISIBLE);
                lin_address.setVisibility(View.VISIBLE);
                lin_otherinfo.setVisibility(View.GONE);
                lin_address_details.setVisibility(View.GONE);
                //text_address.setVisibility(View.GONE);
                //btn_save.setVisibility(View.VISIBLE);
            }
        });
        btn_otherinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_address.setBackgroundColor(getResources().getColor(R.color.white));
                btn_address.setTextColor(getResources().getColor(R.color.blue));
                btn_profileinfo.setBackgroundColor(getResources().getColor(R.color.white));
                btn_profileinfo.setTextColor(getResources().getColor(R.color.blue));
                btn_otherinfo.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_otherinfo.setTextColor(getResources().getColor(R.color.white));

                lin_address_details.setVisibility(View.GONE);
                lin_profileinfo.setVisibility(View.GONE);
                // lin_total_layout.setVisibility(View.VISIBLE);
                lin_address.setVisibility(View.GONE);
                lin_otherinfo.setVisibility(View.VISIBLE);

                //text_address.setVisibility(View.GONE);
                //btn_save.setVisibility(View.VISIBLE);
            }
        });



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edt_companyname.getText().toString().trim().length() > 0
                        && edt_firstname.getText().toString().trim().length() > 0
                        && edt_middelname.getText().toString().trim().length() > 0
                        && edt_lastname.getText().toString().trim().length() > 0
                        && edt_username.getText().toString().trim().length() > 0
                        && edt_fax.getText().toString().trim().length() > 0
                        && edt_email.getText().toString().trim().length() > 0
                        && edt_type.getText().toString().trim().length() > 0
                        && edt_address1.getText().toString().trim().length() > 0
                        && edt_address2.getText().toString().trim().length() > 0
                        && edt_city.getText().toString().trim().length() > 0
                        && spinner_state.toString().trim().length() > 0
                        && edt_zipcode.getText().toString().trim().length() > 0
                        && edt_county.getText().toString().trim().length() > 0 &&
                        edt_country.getText().toString().trim().length() > 0
                       && edt_hearabout.getText().toString().trim().length() > 0
                       && edt_preferred_communcation.getText().toString().trim().length() > 0
                       && edt_industry.getText().toString().trim().length() > 0
                       && edt_notes.getText().toString().trim().length() > 0
                                       ) {
                    /*AppointmentFragment appointmentfragment = new AppointmentFragment();
                FragmentUtil.addFragment(getActivity(),
                        appointmentfragment, null, false, true,
                        "AppointmentFragment");*/
                } else {
                    Toast.makeText(activity, "Please Enter All Fields",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }






    private class UsFormatNumber implements TextWatcher {
        EditText et1;
        private boolean mFormatting; // this is a flag which prevents the  stack overflow.
        private int mAfter;

        public UsFormatNumber(EditText et) {
            this.et1 = et;


        }


        @Override
        //called before the text is changed...
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // flag to detect backspace..
            mAfter = after;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            // Make sure to ignore calls to afterTextChanged caused by the work done below
            if (!mFormatting) {
                mFormatting = true;
                // using US formatting...
                if (mAfter != 0) // in case back space ain't clicked...
                    PhoneNumberUtils.formatNumber(s, PhoneNumberUtils.getFormatTypeForLocale(Locale.US));
                mFormatting = false;
            }
        }
    }

    private class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
}


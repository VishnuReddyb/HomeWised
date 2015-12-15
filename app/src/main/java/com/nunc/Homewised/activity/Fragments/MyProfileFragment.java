package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;

import java.util.Locale;

/**
 * Created NUNC.
 */
public class MyProfileFragment extends Fragment {
    View rootView;

    private EditText edt_companyname, edt_firstname, edt_middelname, edt_lastname, edt_username,
            edt_password, edt_work, edt_mobilenumber, edt_homephone, edt_fax, edt_alt_email, edt_type,
            edt_address1, edt_address2, edt_city,  edt_zipcode, edt_county, edt_country;
    private Button btn_edit, btn_save,btn_address,btn_profileinfo;
    private boolean status;
    private Spinner spinner_state;
    private LinearLayout lin_profile,lin_address,lin_addbutton,lin_total_layout;
    private TextView text_address,text_profile;
    private Activity activity;

    public MyProfileFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.myprofile, container, false);
        activity = getActivity();
        edt_companyname = (EditText) rootView.findViewById(R.id.edt_companyname);
        edt_firstname = (EditText) rootView.findViewById(R.id.edt_firstname);
        edt_middelname = (EditText) rootView.findViewById(R.id.edt_middelname);
        edt_lastname = (EditText) rootView.findViewById(R.id.edt_lastname);
        edt_username = (EditText) rootView.findViewById(R.id.edt_username);
        edt_password = (EditText) rootView.findViewById(R.id.edt_password);
        edt_work = (EditText) rootView.findViewById(R.id.edt_work);
        edt_mobilenumber = (EditText) rootView.findViewById(R.id.edt_mobilenumber);
        edt_homephone = (EditText) rootView.findViewById(R.id.edt_homephone);
        edt_fax = (EditText) rootView.findViewById(R.id.edt_fax);
        edt_alt_email = (EditText) rootView.findViewById(R.id.edt_alt_email);
        edt_type = (EditText) rootView.findViewById(R.id.edt_type);
        edt_address1 = (EditText) rootView.findViewById(R.id.edt_address1);
        edt_address2 = (EditText) rootView.findViewById(R.id.edt_address2);
        edt_city = (EditText) rootView.findViewById(R.id.edt_city);
        edt_zipcode = (EditText) rootView.findViewById(R.id.edt_zipcode);
        edt_county = (EditText) rootView.findViewById(R.id.edt_county);
        edt_country = (EditText) rootView.findViewById(R.id.edt_country);

        spinner_state = (Spinner) rootView.findViewById(R.id.spinner_state);

        btn_edit = (Button) rootView.findViewById(R.id.btn_edit);
        btn_save = (Button) rootView.findViewById(R.id.btn_save);

        btn_address = (Button) rootView.findViewById(R.id.btn_address);
        btn_profileinfo = (Button) rootView.findViewById(R.id.btn_profileinfo);

        lin_profile=(LinearLayout)rootView.findViewById(R.id.lin_profile);
        lin_address=(LinearLayout)rootView.findViewById(R.id.lin_address);
        lin_addbutton=(LinearLayout)rootView.findViewById(R.id.lin_addbutton);
        lin_total_layout=(LinearLayout)rootView.findViewById(R.id.lin_total_layout);

        text_address=(TextView)rootView.findViewById(R.id.text_address);
        text_profile=(TextView)rootView.findViewById(R.id.text_profile);
        eidtable();
        setHasOptionsMenu(true);

        /*PhoneNumberUsFormat edt_mobilenumber1 =new PhoneNumberUsFormat();
        edt_mobilenumber.addTextChangedListener(edt_mobilenumber1);
        PhoneNumberUsFormat edt_homephone1 =new PhoneNumberUsFormat();
        edt_homephone.addTextChangedListener(edt_homephone1);*/
        UsFormatNumber edt_homephone1=new UsFormatNumber(edt_homephone);
        edt_homephone.addTextChangedListener(edt_homephone1);
        UsFormatNumber edt_mobilenumber1=new UsFormatNumber(edt_mobilenumber);
        edt_mobilenumber.addTextChangedListener(edt_mobilenumber1);
        UsFormatNumber edt_work1=new UsFormatNumber(edt_work);
        edt_work.addTextChangedListener(edt_work1);
        /*edt_homephone.addTextChangedListener(new TextWatcher() {
            private boolean mFormatting; // this is a flag which prevents the  stack overflow.
            private int mAfter;

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // nothing to do here..
            }

            //called before the text is changed...
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //nothing to do here...
                mAfter = after; // flag to detect backspace..

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
        });
        edt_mobilenumber.addTextChangedListener(new TextWatcher() {
            private boolean mFormatting; // this is a flag which prevents the  stack overflow.
            private int mAfter;

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // nothing to do here..
            }

            //called before the text is changed...
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //nothing to do here...
                mAfter = after; // flag to detect backspace..

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
        });
*/
        btn_profileinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_address.setBackgroundColor(getResources().getColor(R.color.white));
                btn_address.setTextColor(getResources().getColor(R.color.blue));
                btn_profileinfo.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_profileinfo.setTextColor(getResources().getColor(R.color.white));
                lin_profile.setVisibility(View.VISIBLE);
                btn_save.setVisibility(View.GONE);
                lin_total_layout.setVisibility(View.VISIBLE);
                lin_address.setVisibility(View.GONE);
                text_address.setVisibility(View.GONE);

            }
        });
        btn_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_address.setBackgroundColor(getResources().getColor(R.color.blue));
                btn_address.setTextColor(getResources().getColor(R.color.white));
                btn_profileinfo.setBackgroundColor(getResources().getColor(R.color.white));
                btn_profileinfo.setTextColor(getResources().getColor(R.color.blue));
                lin_profile.setVisibility(View.GONE);
                lin_total_layout.setVisibility(View.VISIBLE);
                lin_address.setVisibility(View.VISIBLE);
                text_address.setVisibility(View.GONE);
                btn_save.setVisibility(View.VISIBLE);
            } });


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_edit.setVisibility(View.GONE);
                btn_save.setVisibility(View.VISIBLE);
                lin_addbutton.setVisibility(View.VISIBLE);
                lin_total_layout.setVisibility(View.VISIBLE);
                lin_profile.setVisibility(View.VISIBLE);
                lin_address.setVisibility(View.GONE);
                btn_save.setVisibility(View.GONE);
                text_profile.setVisibility(View.GONE);
                text_address.setVisibility(View.VISIBLE);

                noteditable(true);

            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edt_companyname.getText().toString().trim().length()>0
                        &&edt_firstname.getText().toString().trim().length()>0
                        &&edt_middelname.getText().toString().trim().length()>0
                        &&edt_lastname.getText().toString().trim().length()>0
                        && edt_username.getText().toString().trim().length()>0
                        && edt_password.getText().toString().trim().length()>0
                        && edt_work.getText().toString().trim().length()>0
                        && edt_mobilenumber.getText().toString().trim().length()>0
                        && edt_homephone.getText().toString().trim().length()>0
                        &&edt_fax.getText().toString().trim().length()>0
                        && edt_alt_email.getText().toString().trim().length()>0
                        &&edt_type.getText().toString().trim().length()>0
                        &&edt_address1.getText().toString().trim().length()>0
                        && edt_address2.getText().toString().trim().length()>0
                        && edt_city.getText().toString().trim().length()>0
                        && spinner_state.toString().trim().length()>0
                        && edt_zipcode.getText().toString().trim().length()>0
                        &&edt_county.getText().toString().trim().length()>0&&
                        edt_country.getText().toString().trim().length()>0 ){
                    AppointmentFragment appointmentfragment = new AppointmentFragment();
                    FragmentUtil.addFragment(getActivity(),
                            appointmentfragment, null, false, true,
                            "AppointmentFragment");
                }else{
                    Toast.makeText(activity, "Please Enter All Fields",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

    private void eidtable() {
        edt_companyname.setEnabled(false);
        edt_firstname.setEnabled(false);
        edt_middelname.setEnabled(false);
        edt_lastname.setEnabled(false);
        edt_username.setEnabled(false);
        edt_password.setEnabled(false);
        ;
        edt_work.setEnabled(false);
        edt_mobilenumber.setEnabled(false);
        edt_homephone.setEnabled(false);
        edt_fax.setEnabled(false);
        edt_alt_email.setEnabled(false);
        edt_type.setEnabled(false);
        edt_address1.setEnabled(false);
        edt_address2.setEnabled(false);
        edt_city.setEnabled(false);
        spinner_state.setEnabled(false);
        edt_zipcode.setEnabled(false);
        edt_county.setEnabled(false);
        edt_country.setEnabled(false);
    }


    private void noteditable(boolean status) {


        edt_companyname.setEnabled(status);
        edt_firstname.setEnabled(status);
        edt_middelname.setEnabled(status);
        edt_lastname.setEnabled(status);
        edt_username.setEnabled(status);
        edt_password.setEnabled(status);
        edt_work.setEnabled(status);
        edt_mobilenumber.setEnabled(status);
        edt_homephone.setEnabled(status);
        edt_fax.setEnabled(status);
        edt_alt_email.setEnabled(status);
        edt_type.setEnabled(status);
        edt_address1.setEnabled(status);
        edt_address2.setEnabled(status);
        edt_city.setEnabled(status);
        spinner_state.setEnabled(status);
        edt_zipcode.setEnabled(status);
        edt_county.setEnabled(status);
        edt_country.setEnabled(status);
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (menu.findItem(R.id.action_plus) != null)
            menu.findItem(R.id.action_plus).setVisible(false);

    }

    private class UsFormatNumber  implements TextWatcher{
        private boolean mFormatting; // this is a flag which prevents the  stack overflow.
        private int mAfter;
        EditText et1;
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
}

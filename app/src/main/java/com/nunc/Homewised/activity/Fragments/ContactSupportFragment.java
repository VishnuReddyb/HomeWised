package com.nunc.Homewised.activity.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nunc.Homewised.R;


/**
 * Created by NUNC.
 */
public class ContactSupportFragment extends Fragment {
    private TextView text_phone, text_email;
    View rootView;

    public ContactSupportFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contactsupport, container, false);
        text_phone = (TextView) rootView.findViewById(R.id.text_phone);
        text_email = (TextView) rootView.findViewById(R.id.text_email);
setHasOptionsMenu(true);

        text_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7416083252"));
                startActivity(callIntent);

            }
        });
        text_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"b.vishnu5c5@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (menu.findItem(R.id.action_plus) != null)
            menu.findItem(R.id.action_plus).setVisible(false);

    }
}

package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;
import com.nunc.Homewised.activity.TimeAndDate.Constants;
import com.nunc.Homewised.activity.adapter.ItemslistAdapter;
import com.nunc.Homewised.activity.model.JobObject;

/**
 * Created by nunc on 19-11-2015.
 */
public class AddQuoteFragment extends Fragment implements View.OnClickListener {
    static int TAKE_PICTURE = 1;
    View rootView;
    ImageView img_dateandtime;
    Uri photoPath;
    ListView itemsList;
    private Activity activity;
    private LinearLayout lin_quote, lin_items, lin_time, lin_attachments, lin_background, lin_cancel;
    private Button btn_quote, btn_items, btn_time, btn_attachments, btn_add_items, btn_save, btn_camera, btn_photoalbum, btn_cancel, btn_addcancel, btn_adddone;
    private EditText edt_jodid, edt_addsubjob, edt_title, edt_type, edt_status,
            edt_notes, edt_category, edt_appointment_time, edt_attachment, edt_othercharges, edt_discount, edt_tax;
    private TextView text_titlename, text_total;
    private JobObject jobDataObj = new JobObject();

    public AddQuoteFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.add_quote, container, false);
        this.activity = getActivity();
        activity.setTitle("EditJob");
        edt_jodid = (EditText) rootView.findViewById(R.id.edt_jodid);
        edt_addsubjob = (EditText) rootView.findViewById(R.id.edt_addsubjob);
        edt_title = (EditText) rootView.findViewById(R.id.edt_title);
        edt_type = (EditText) rootView.findViewById(R.id.edt_type);
        edt_status = (EditText) rootView.findViewById(R.id.edt_status);
        edt_notes = (EditText) rootView.findViewById(R.id.edt_notes);
        img_dateandtime = (ImageView) rootView.findViewById(R.id.img_dateandtime);

        edt_appointment_time = (EditText) rootView.findViewById(R.id.edt_appointment_time);



                /*items edit texts*/
        edt_category = (EditText) rootView.findViewById(R.id.edt_category);
        edt_othercharges = (EditText) rootView.findViewById(R.id.edt_othercharges);
        edt_discount = (EditText) rootView.findViewById(R.id.edt_discount);
        edt_tax = (EditText) rootView.findViewById(R.id.edt_tax);
        text_total = (TextView) rootView.findViewById(R.id.text_total);


        lin_quote = (LinearLayout) rootView.findViewById(R.id.lin_quote);
        lin_items = (LinearLayout) rootView.findViewById(R.id.lin_items);
        lin_time = (LinearLayout) rootView.findViewById(R.id.lin_time);
        lin_attachments = (LinearLayout) rootView.findViewById(R.id.lin_attachments);
        lin_background = (LinearLayout) rootView.findViewById(R.id.lin_background);
        lin_cancel = (LinearLayout) rootView.findViewById(R.id.lin_cancel);


        btn_quote = (Button) rootView.findViewById(R.id.btn_quote);
        btn_items = (Button) rootView.findViewById(R.id.btn_items);
        btn_time = (Button) rootView.findViewById(R.id.btn_time);
        btn_attachments = (Button) rootView.findViewById(R.id.btn_attachments);
        btn_add_items = (Button) rootView.findViewById(R.id.btn_add_items);
        btn_save = (Button) rootView.findViewById(R.id.btn_save);
        btn_camera = (Button) rootView.findViewById(R.id.btn_camera);
        btn_photoalbum = (Button) rootView.findViewById(R.id.btn_photoalbum);
        btn_cancel = (Button) rootView.findViewById(R.id.btn_cancel);
/*title */

        text_titlename = (TextView) rootView.findViewById(R.id.text_titlename);
        btn_addcancel = (Button) rootView.findViewById(R.id.btn_addcancel);
        btn_adddone = (Button) rootView.findViewById(R.id.btn_adddone);
        itemsList = (ListView) rootView.findViewById(R.id.list_additems);

        btn_add_items.setOnClickListener(this);
        btn_attachments.setOnClickListener(this);
        btn_time.setOnClickListener(this);
        btn_items.setOnClickListener(this);
        btn_quote.setOnClickListener(this);
        btn_photoalbum.setOnClickListener(this);
        btn_camera.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        btn_adddone.setOnClickListener(this);
        btn_addcancel.setOnClickListener(this);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_othercharges.getText().toString().trim().length() > 0
                        && edt_category.getText().toString().trim().length() > 0
                        && edt_discount.getText().toString().trim().length() > 0
                        && edt_tax.getText().toString().trim().length() > 0

                        ) {
                    AppointmentFragment appointmentfragment = new AppointmentFragment();
               /* FragmentUtil.addFragmentForWalker(getActivity(),
                        appointmentfragment, null, false, true,
                        "AppointmentFragment");*/
                } else {
                    Toast.makeText(activity, "Please Enter All Fields",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        Bundle bundle = getArguments();
        if (bundle != null) {
            jobDataObj = (JobObject) bundle.getSerializable("OBJECT");

        }

        updateList();

        // Inflate the layout for this fragment
        return rootView;
    }

    private void updateList() {


        itemsList.setAdapter(new ItemslistAdapter(activity, jobDataObj.getLitemsList()));
        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                AddJobAddItems editjobadditems = new AddJobAddItems();

                //callItemsFragment(editjobadditems,"AddJobAddItems");



                FragmentUtil.addFragmentwithObject(activity, editjobadditems, jobDataObj, null, false, true, "AddJobAddItems",position);


            }
        });

    }


    @Override
    public void onClick(View v) {
        if (v == btn_attachments) {
            lin_quote.setVisibility(View.GONE);
            lin_items.setVisibility(View.GONE);
            lin_time.setVisibility(View.GONE);
            lin_cancel.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.VISIBLE);
            btn_quote.setBackgroundColor(getResources().getColor(R.color.white));
            btn_quote.setTextColor(getResources().getColor(R.color.blue));

            btn_items.setBackgroundColor(getResources().getColor(R.color.white));
            btn_items.setTextColor(getResources().getColor(R.color.blue));

            btn_time.setBackgroundColor(getResources().getColor(R.color.white));
            btn_time.setTextColor(getResources().getColor(R.color.blue));

            btn_attachments.setBackgroundColor(getResources().getColor(R.color.blue));
            btn_attachments.setTextColor(getResources().getColor(R.color.white));
        } else if (v == btn_time) {
            lin_quote.setVisibility(View.GONE);
            lin_items.setVisibility(View.GONE);
            lin_time.setVisibility(View.VISIBLE);
            lin_attachments.setVisibility(View.GONE);
            lin_cancel.setVisibility(View.GONE);
            btn_quote.setBackgroundColor(getResources().getColor(R.color.white));
            btn_quote.setTextColor(getResources().getColor(R.color.blue));

            btn_items.setBackgroundColor(getResources().getColor(R.color.white));
            btn_items.setTextColor(getResources().getColor(R.color.blue));

            btn_time.setBackgroundColor(getResources().getColor(R.color.blue));
            btn_time.setTextColor(getResources().getColor(R.color.white));

            btn_attachments.setBackgroundColor(getResources().getColor(R.color.white));
            btn_attachments.setTextColor(getResources().getColor(R.color.blue));
        } else if (v == btn_items) {

            lin_cancel.setVisibility(View.GONE);
            lin_quote.setVisibility(View.GONE);
            lin_items.setVisibility(View.VISIBLE);
            lin_time.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.GONE);

            btn_quote.setBackgroundColor(getResources().getColor(R.color.white));
            btn_quote.setTextColor(getResources().getColor(R.color.blue));

            btn_items.setBackgroundColor(getResources().getColor(R.color.blue));
            btn_items.setTextColor(getResources().getColor(R.color.white));

            btn_time.setBackgroundColor(getResources().getColor(R.color.white));
            btn_time.setTextColor(getResources().getColor(R.color.blue));

            btn_attachments.setBackgroundColor(getResources().getColor(R.color.white));
            btn_attachments.setTextColor(getResources().getColor(R.color.blue));

        } else if (v == btn_quote) {
            lin_quote.setVisibility(View.VISIBLE);
            lin_items.setVisibility(View.GONE);
            lin_time.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.GONE);
            lin_cancel.setVisibility(View.GONE);
            btn_quote.setBackgroundColor(getResources().getColor(R.color.blue));
            btn_quote.setTextColor(getResources().getColor(R.color.white));
            btn_items.setBackgroundColor(getResources().getColor(R.color.white));
            btn_items.setTextColor(getResources().getColor(R.color.blue));
            btn_time.setTextColor(getResources().getColor(R.color.blue));
            btn_time.setBackgroundColor(getResources().getColor(R.color.white));
            btn_attachments.setBackgroundColor(getResources().getColor(R.color.white));
            btn_attachments.setTextColor(getResources().getColor(R.color.blue));
        } else if (v == btn_add_items) {


            AddJobAddItems editjobadditems = new AddJobAddItems();

            //callItemsFragment(editjobadditems,"AddJobAddItems");


            FragmentUtil.addFragmentwithObject(activity, editjobadditems, jobDataObj, null, false, true, "AddJobAddItems", Constants.OPTIONAL_PARAM_INT);

        } else if (v == btn_camera) {
            /*Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
            startActivityForResult(intent, 1);*/
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, TAKE_PICTURE);


        } else if (v == btn_photoalbum) {

            lin_cancel.setVisibility(View.VISIBLE);
            lin_attachments.setVisibility(View.GONE);


        } else if (v == btn_cancel) {
            lin_cancel.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.VISIBLE);

        } else if (v == btn_addcancel) {


        } else if (v == btn_adddone) {
            if (edt_title.getText().toString().trim().length() > 0
                    && edt_type.getText().toString().trim().length() > 0
                    && edt_status.getText().toString().trim().length() > 0
                    && edt_notes.getText().toString().trim().length() > 0
                    && edt_category.getText().toString().trim().length() > 0
                    && edt_othercharges.getText().toString().trim().length() > 0
                    && edt_discount.getText().toString().trim().length() > 0
                    && edt_tax.getText().toString().trim().length() > 0
                    && edt_appointment_time.getText().toString().trim().length() > 0
                    ) {
                AppointmentFragment appointmentfragment = new AppointmentFragment();
               /* FragmentUtil.addFragmentForWalker(getActivity(),
                        appointmentfragment, null, false, true,
                        "AppointmentFragment");*/
                Toast.makeText(activity, "successfully added",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "Please Enter All Fields",
                        Toast.LENGTH_SHORT).show();
            }
        }


    }



}
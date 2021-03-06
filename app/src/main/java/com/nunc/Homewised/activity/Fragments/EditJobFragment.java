package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.FragmentUtil;

import java.util.Calendar;

/**
 * Created by nunc on 19-11-2015.
 */
public class EditJobFragment extends Fragment implements View.OnClickListener {
    View rootView;
    private Activity activity;
    private LinearLayout lin_jobs, lin_items, lin_time, lin_attachments,lin_cancel, lin_background;
    private Button btn_job, btn_items, btn_time, btn_attachments, btn_add_items,btn_save,btn_camera,btn_photoalbum,btn_cancel,btn_editcancel,btn_editdone;
    private EditText edt_jodid, edt_addsubjob, edt_title, edt_type, edt_status,
            edt_notes, edt_category, edt_attachment,edt_othercharges,edt_discount,edt_tax,edt_total,
    edt_start_time,edt_end_time;
private ImageView img_dateandtime;
private TextView text_titlename;

    Uri photoPath;
    static int TAKE_PICTURE = 1;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    public EditJobFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.edit_job, container, false);
        this.activity = getActivity();
        activity.setTitle("EditJob");




        edt_jodid = (EditText) rootView.findViewById(R.id.edt_jodid);
        edt_addsubjob = (EditText) rootView.findViewById(R.id.edt_addsubjob);
        edt_title = (EditText) rootView.findViewById(R.id.edt_title);
        edt_type = (EditText) rootView.findViewById(R.id.edt_type);
        edt_status = (EditText) rootView.findViewById(R.id.edt_status);
        edt_notes = (EditText) rootView.findViewById(R.id.edt_notes);

        edt_start_time = (EditText) rootView.findViewById(R.id.edt_appointment_time);
        edt_end_time = (EditText) rootView.findViewById(R.id.edt_appointment_time);
        img_dateandtime = (ImageView) rootView.findViewById(R.id.img_dateandtime);



                /*items edit texts*/
        edt_category = (EditText) rootView.findViewById(R.id.edt_category);
        edt_othercharges = (EditText) rootView.findViewById(R.id.edt_othercharges);
        edt_discount = (EditText) rootView.findViewById(R.id.edt_discount);
        edt_tax = (EditText) rootView.findViewById(R.id.edt_tax);
        edt_total = (EditText) rootView.findViewById(R.id.edt_total);


        lin_jobs = (LinearLayout) rootView.findViewById(R.id.lin_jobs);
        lin_items = (LinearLayout) rootView.findViewById(R.id.lin_items);
        lin_time = (LinearLayout) rootView.findViewById(R.id.lin_time);
        lin_attachments = (LinearLayout) rootView.findViewById(R.id.lin_attachments);
        lin_background = (LinearLayout) rootView.findViewById(R.id.lin_background);
        lin_cancel = (LinearLayout) rootView.findViewById(R.id.lin_cancel);


        btn_job = (Button) rootView.findViewById(R.id.btn_job);
        btn_items = (Button) rootView.findViewById(R.id.btn_items);
        btn_time = (Button) rootView.findViewById(R.id.btn_time);
        btn_attachments = (Button) rootView.findViewById(R.id.btn_attachments);
        btn_add_items = (Button) rootView.findViewById(R.id.btn_add_items);
        btn_save = (Button) rootView.findViewById(R.id.btn_save);
        btn_camera = (Button) rootView.findViewById(R.id.btn_camera);
        btn_photoalbum = (Button) rootView.findViewById(R.id.btn_photoalbum);
        btn_cancel = (Button) rootView.findViewById(R.id.btn_cancel);
/*title bar*/

                btn_editcancel = (Button) rootView.findViewById(R.id.btn_editcancel);
                btn_editdone = (Button) rootView.findViewById(R.id.btn_editdone);
        text_titlename=(TextView)rootView.findViewById(R.id.text_titlename);

        btn_add_items.setOnClickListener(this);
        btn_attachments.setOnClickListener(this);
        btn_time.setOnClickListener(this);
        btn_items.setOnClickListener(this);
        btn_job.setOnClickListener(this);
        btn_photoalbum.setOnClickListener(this);
        btn_camera.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
        btn_editcancel.setOnClickListener(this);
        btn_editdone.setOnClickListener(this);
        /*edt_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Start Time",
                        Toast.LENGTH_SHORT).show();

            }
        });
*/
        img_dateandtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(listener)
                        .setInitialDate(new Date())
                                //.setMinDate(minDate)
                                //.setMaxDate(maxDate)
                                //.setIs24HourTime(true)
                                //.setTheme(SlideDateTimePicker.HOLO_DARK)
                                //.setIndicatorColor(Color.parseColor("#990000"))
                        .build()
                        .show();*/
                Toast.makeText(activity,"Date And Time",Toast.LENGTH_SHORT).show();
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_othercharges.getText().toString().trim().length()>0
                        &&edt_category.getText().toString().trim().length()>0
                        &&edt_discount.getText().toString().trim().length()>0
                        &&edt_tax.getText().toString().trim().length()>0
                        && edt_total.getText().toString().trim().length()>0
                        ){
                    AppointmentFragment appointmentfragment = new AppointmentFragment();
               /* FragmentUtil.addFragmentForWalker(getActivity(),
                        appointmentfragment, null, false, true,
                        "AppointmentFragment");*/
                }else{
                    Toast.makeText(activity, "Please Enter All Fields",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }


    @Override
    public void onClick(View v) {
        if (v == btn_attachments) {
            lin_jobs.setVisibility(View.GONE);
            lin_items.setVisibility(View.GONE);
            lin_time.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.VISIBLE);
            btn_job.setBackgroundColor(getResources().getColor(R.color.white));
            btn_job.setTextColor(getResources().getColor(R.color.blue));

            btn_items.setBackgroundColor(getResources().getColor(R.color.white));
            btn_items.setTextColor(getResources().getColor(R.color.blue));

            btn_time.setBackgroundColor(getResources().getColor(R.color.white));
            btn_time.setTextColor(getResources().getColor(R.color.blue));

            btn_attachments.setBackgroundColor(getResources().getColor(R.color.blue));
            btn_attachments.setTextColor(getResources().getColor(R.color.white));
        } else if (v == btn_time) {
            lin_jobs.setVisibility(View.GONE);
            lin_items.setVisibility(View.GONE);
            lin_time.setVisibility(View.VISIBLE);
            lin_attachments.setVisibility(View.GONE);
            lin_cancel.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.GONE);

            btn_job.setBackgroundColor(getResources().getColor(R.color.white));
            btn_job.setTextColor(getResources().getColor(R.color.blue));

            btn_items.setBackgroundColor(getResources().getColor(R.color.white));
            btn_items.setTextColor(getResources().getColor(R.color.blue));

            btn_time.setBackgroundColor(getResources().getColor(R.color.blue));
            btn_time.setTextColor(getResources().getColor(R.color.white));

            btn_attachments.setBackgroundColor(getResources().getColor(R.color.white));
            btn_attachments.setTextColor(getResources().getColor(R.color.blue));
        } else if (v == btn_items) {


            lin_jobs.setVisibility(View.GONE);
            lin_items.setVisibility(View.VISIBLE);
            lin_time.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.GONE);
            lin_cancel.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.GONE);


            btn_job.setBackgroundColor(getResources().getColor(R.color.white));
            btn_job.setTextColor(getResources().getColor(R.color.blue));

            btn_items.setBackgroundColor(getResources().getColor(R.color.blue));
            btn_items.setTextColor(getResources().getColor(R.color.white));

            btn_time.setBackgroundColor(getResources().getColor(R.color.white));
            btn_time.setTextColor(getResources().getColor(R.color.blue));

            btn_attachments.setBackgroundColor(getResources().getColor(R.color.white));
            btn_attachments.setTextColor(getResources().getColor(R.color.blue));

        }  else if (v == btn_job) {
            lin_jobs.setVisibility(View.VISIBLE);
            lin_items.setVisibility(View.GONE);
            lin_time.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.GONE);
            lin_cancel.setVisibility(View.GONE);


            btn_job.setBackgroundColor(getResources().getColor(R.color.blue));
            btn_job.setTextColor(getResources().getColor(R.color.white));
            btn_items.setBackgroundColor(getResources().getColor(R.color.white));
            btn_items.setTextColor(getResources().getColor(R.color.blue));
            btn_time.setTextColor(getResources().getColor(R.color.blue));
            btn_time.setBackgroundColor(getResources().getColor(R.color.white));
            btn_attachments.setBackgroundColor(getResources().getColor(R.color.white));
            btn_attachments.setTextColor(getResources().getColor(R.color.blue));
        } else if (v == btn_add_items) {

            AddJobAddItems editjobadditems = new AddJobAddItems();
            FragmentUtil.addFragment(activity, editjobadditems, null, false, true, "AddJobAddItems");
        }
        else  if (v==btn_camera){
            /*Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
            startActivityForResult(intent, 1);*/
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, TAKE_PICTURE);


        }
        else if (v==btn_photoalbum){
            lin_cancel.setVisibility(View.VISIBLE);
            lin_attachments.setVisibility(View.GONE);



        }else if (v==btn_cancel){
            lin_cancel.setVisibility(View.GONE);
            lin_attachments.setVisibility(View.VISIBLE);

       }else if (v==btn_editcancel){
            //activity.finish();

        }

      else if (v==btn_editdone){
            if(edt_jodid.getText().toString().trim().length()>0
                    &&edt_title.getText().toString().trim().length()>0
                    &&edt_type.getText().toString().trim().length()>0
                    &&edt_status.getText().toString().trim().length()>0
                    && edt_notes.getText().toString().trim().length()>0
                    && edt_title.getText().toString().trim().length()>0
                    && edt_category.getText().toString().trim().length()>0
                    && edt_othercharges.getText().toString().trim().length()>0
                    && edt_discount.getText().toString().trim().length()>0
                    && edt_tax.getText().toString().trim().length()>0
                    && edt_total.getText().toString().trim().length()>0
                    ){
                AppointmentFragment appointmentfragment = new AppointmentFragment();
               /* FragmentUtil.addFragmentForWalker(getActivity(),
                        appointmentfragment, null, false, true,
                        "AppointmentFragment");*/

                Toast.makeText(activity, "successfully added",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(activity, "Please Enter All Fields",
                        Toast.LENGTH_SHORT).show();
            }
        }


    }
   /* private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date)
        {
            Toast.makeText(activity,
                    mFormatter.format(date), Toast.LENGTH_SHORT).show();
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel()
        {
            Toast.makeText(activity,
                    "Canceled", Toast.LENGTH_SHORT).show();
        }
    };*/

}
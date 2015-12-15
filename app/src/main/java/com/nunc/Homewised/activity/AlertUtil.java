package com.nunc.Homewised.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nunc.Homewised.R;


/**
 * Created by nunc on 14-11-2015.
 */
public class AlertUtil {


    public static void displaylogoutDialog(final Activity activity) {
        // TODO Auto-generated method stub
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setCancelable(false);
        alertDialog.setTitle("HomeWised");

        // set dialog message
        alertDialog.setMessage("Are you sure you want to Signout?");
        alertDialog.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();

                        Intent intent = new Intent(activity,
                                LoginActivity.class);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.fedin,
                                R.anim.fedout);
                        activity.finish();
                    }

                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                }).setIcon(android.R.drawable.ic_dialog_alert);
        AlertDialog alert = alertDialog.create();
        alert.show();
        Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);

        /*nbutton.setTextColor(activity.getResources().getColor(
                R.color.alert_color));*/
        nbutton.setTextSize(15);

        Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);

        /*pbutton.setTextColor(activity.getResources().getColor(
                R.color.alert_color));*/
        pbutton.setTextSize(15);

    }

    public static void customAlert(Context context, String message) {
         final Dialog dialog = new Dialog(context);
       // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.alertpop);

        Button close = (Button) dialog.findViewById(R.id.btn_close);
        TextView text = (TextView) dialog.findViewById(R.id.text_alert);
        //dialog.getWindow().setLayout(650, 470);
        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations =
                R.style.Dialoganimationoutupinup;
        text.setText(message);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });
        dialog.show();

    }
    public  static void displayalert(Context context, String message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.alertpopup, null);
        alertDialogBuilder.setView(view);
    }

}

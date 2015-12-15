package com.nunc.Homewised.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nunc.Homewised.R;


/**
 * Created by NUNC on 13-11-2015.
 */
public class ForgotPassword extends Activity {
    private EditText ed_email;
    private Button forgot_password;
    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);
        this.context = this;
        ed_email = (EditText) findViewById(R.id.ed_email);
        forgot_password = (Button) findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(new BtnClicklistener());


    }

    private boolean validation() {
        return ed_email.getText().toString().trim().length() > 0;
    }

    private class BtnClicklistener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String email = ed_email.getText().toString().trim();
            if (validation()) {

                boolean failFlag = false;
                if (!Validation.isValidEmail(ed_email.getText()
                        .toString().trim())) {
                    failFlag = true;
                    ed_email.setError("Invalid Email");
                }// if all are fine
                if (failFlag == false) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(R.anim.fedin, R.anim.fedout);
                    //Toast.makeText(getApplicationContext(), "Valid Email Address.", Toast.LENGTH_SHORT).show();

                }


            } else {
                   /* Toast.makeText(getApplicationContext(),
                            "Please Enter email and password",
                            Toast.LENGTH_SHORT).show();
                    //ed_email.setError("Invalid Email");*/

            }


        }

    }

}

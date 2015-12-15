package com.nunc.Homewised.activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nunc.Homewised.R;


/**
 * Created by nunc on 13-11-2015.
 */
public class LoginActivity extends AppCompatActivity {
    BroadcastReceiver myReceiver;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    //  private EditText ed_email, ed_password;
    private Button btn_login;
    private TextView tv_forget_pwd;
    private EditText  inputEmail, inputPassword;
    private TextInputLayout  inputLayoutEmail, inputLayoutPassword;
    private Activity context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initializeViewComponents();


    }

    private void initializeViewComponents() {

        inputLayoutEmail = (TextInputLayout) findViewById(R.id.usernameWrapper);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.passwordWrapper);

        inputEmail = (EditText) findViewById(R.id.usernameemail);
        inputPassword = (EditText) findViewById(R.id.password);

       /* ed_email = (EditText) findViewById(R.id.ed_email);
        ed_password = (EditText) findViewById(R.id.ed_password);*/
        tv_forget_pwd = (TextView) findViewById(R.id.tv_forget_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_forget_pwd.setPaintFlags(tv_forget_pwd.getPaintFlags()
                | Paint.UNDERLINE_TEXT_FLAG);


        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomeWisedMainActivity.class));
                  overridePendingTransition(R.anim.fedin, R.anim.fedout);
               // submitForm();
            }
        });
       tv_forget_pwd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               /*if (!validateEmail()) {


                   return;


               }*/
               if (!validateEmail()) {



                   LayoutInflater inflater = getLayoutInflater();
                   View layout = inflater.inflate(R.layout.alertpop,
                           (ViewGroup) findViewById(R.id.toast_layout_root));


                   TextView text = (TextView) layout.findViewById(R.id.text_alert);
                   text.setText("Please enter your email to reset password");

                   Toast toast = new Toast(getApplicationContext());
                   toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                   toast.setDuration(Toast.LENGTH_SHORT);
                   toast.setView(layout);
                   toast.show();


               } else {
                   LayoutInflater inflater = getLayoutInflater();
                   View layout = inflater.inflate(R.layout.alertpop,
                           (ViewGroup) findViewById(R.id.toast_layout_root));


                   TextView text = (TextView) layout.findViewById(R.id.text_alert);
                   text.setText("A reset Password link has been send to the provided email id");

                   Toast toast = new Toast(getApplicationContext());
                   toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                   toast.setDuration(Toast.LENGTH_LONG);
                   toast.setView(layout);
                   toast.show();
                   //  Toast.makeText(getApplicationContext(),"A reset Password link has been send to the provided email id", Toast.LENGTH_SHORT).show();


                   /*AlertUtil
                           .customAlert(
                                   context,
                                   "A reset Password link has been send to the provided email id");*/

               }

               /*startActivity(new Intent(getApplicationContext(), Singnat.class));
               overridePendingTransition(R.anim.fedin, R.anim.fedout);
               // submitForm();*/
           }
       });
    }


    /**
     * Validating form
     */
    private void submitForm() {


        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }
        startActivity(new Intent(getApplicationContext(), HomeWisedMainActivity.class));
          overridePendingTransition(R.anim.fedin, R.anim.fedout);
       // Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }



    private boolean validateEmail() {
      //  String email = inputEmail.getText().toString().trim();

        if (!Validation.isValidEmail(inputEmail.getText()
                .toString().trim())) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (!Validation.isValidPassword(inputPassword.getText()
                .toString().trim())) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        /*finish();
        super.onBackPressed();*/
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {

                case R.id.usernameemail:
                    validateEmail();
                    break;
                case R.id.password:
                    validatePassword();
                    break;
            }
        }
    }
}

/*    }


    private class BtnClicklistener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            if (v == btn_login) {

                startActivity(new Intent(getApplicationContext(), HomeWisedMainActivity.class));
                overridePendingTransition(R.anim.fedin, R.anim.fedout);
                *//*if(validateField()){

                    boolean failFlag = false;
                    if (!Validation.isValidEmail(ed_email.getText()
                            .toString().trim())) {
                        failFlag = true;
                        ed_email.setError("Invalid Email");
                    }else if (!Validation.isValidPassword(ed_password.getText()
                            .toString().trim())) {
                        failFlag = true;
                        ed_password.setError("Invalid Password");
                    }// if all are fine
                    if (failFlag == false) {
                        startActivity(new Intent(getApplicationContext(), HomeWisedMainActivity.class));
                        overridePendingTransition(R.anim.fedin, R.anim.fedout);
                        //Toast.makeText(getApplicationContext(), "Valid Email Address.", Toast.LENGTH_SHORT).show();

                    }



                }else{
                    Toast.makeText(getApplicationContext(),
                            "Please Enter email and password",
                            Toast.LENGTH_SHORT).show();
                    //ed_email.setError("Invalid Email");

                }*//*

                *//*if(validateField(emailInput)){

                    startActivity(new Intent(getApplicationContext(), HomeWisedMainActivity.class));
                    overridePendingTransition(R.anim.fedin, R.anim.fedout);

                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Please Enter email and password",
                            Toast.LENGTH_SHORT).show();
                    ed_email.setError("Invalid Email");
                    ed_password.setError("Invalid Email");
                }*//*

            } else if (v==tv_forget_pwd){
                startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
                overridePendingTransition(R.anim.fedin, R.anim.fedout);
            }

        }

        private boolean validateField() {

            if (ed_email.getText().toString().trim().length() > 0
                    && ed_password.getText().toString().trim().length() > 0) {

                return true;
            } else {
                return false;
            }

        }
        }

    *//*@Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        LogoutService.timer.cancel();
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        LogoutService.timer.start();

    }*//*
}*/

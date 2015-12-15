package info.androidhive.materialdesign.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import info.androidhive.materialdesign.R;


/**
 * Created by nunc_dayal on 13-11-2015.
 */
public class LoginActivity extends Activity {
    private EditText ed_email, ed_password;
    private Button btn_login;
    private TextView tv_forget_pwd;

    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initializeViewComponents();
    }

    private void initializeViewComponents() {
        ed_email = (EditText) findViewById(R.id.ed_email);
        ed_password = (EditText) findViewById(R.id.ed_password);
        tv_forget_pwd = (TextView) findViewById(R.id.tv_forget_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_forget_pwd.setPaintFlags(tv_forget_pwd.getPaintFlags()
                | Paint.UNDERLINE_TEXT_FLAG);
        btn_login.setOnClickListener(new BtnClicklistener());
        tv_forget_pwd.setOnClickListener(new BtnClicklistener());


    }

    private class BtnClicklistener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == btn_login) {

//                Intent i= new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(i);
                startActivity(new  Intent(getApplicationContext(),MainActivity.class));
            }

            else if (v==tv_forget_pwd){
               startActivity(new Intent(getApplicationContext(),ForgotPassword.class));

            }

        }
    }
}

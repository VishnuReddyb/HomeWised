package com.nunc.Homewised.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nunc.Homewised.R;
import com.nunc.Homewised.activity.Fragments.AddAddressInformation;
import com.nunc.Homewised.activity.Fragments.AppointmentAddButton;
import com.nunc.Homewised.activity.Fragments.AppointmentFragment;
import com.nunc.Homewised.activity.Fragments.CatalogFragment;
import com.nunc.Homewised.activity.Fragments.ContactSupportFragment;
import com.nunc.Homewised.activity.Fragments.CustomersFragment;
import com.nunc.Homewised.activity.Fragments.Invoices;
import com.nunc.Homewised.activity.Fragments.LeadsFragments;
import com.nunc.Homewised.activity.Fragments.MyProfileFragment;
import com.nunc.Homewised.activity.Fragments.PrefsFragment;

public class HomeWisedMainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = HomeWisedMainActivity.class.getSimpleName();

    private Toolbar mToolbar;

    private FragmentDrawer drawerFragment;
    private Activity context;

    private Toast toast;
    private long lastBackPressTime = 0;
    private int selectedPosition=0;
    //private HomeNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        this.context = this;
        //navigator = new HomeNavigator();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_plus:
                Bundle args;
                Fragment detail;
                FragmentManager fragmentManager;


                switch (selectedPosition){
                    case 0: args = new Bundle();
                        args.putString("Menu", "You pressed done button.");
                        detail = new AppointmentAddButton();
                        detail.setArguments(args);
                        fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container_body, detail).commit();
                        break;
                    case 1:

                        args = new Bundle();
                        args.putString("Menu", "You pressed done button.");
                        detail = new AddAddressInformation();
                        detail.setArguments(args);
                        fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container_body, detail).commit();

break;
//                *//*Intent intent = new Intent(HomeWisedMainActivity.this, Invoices.class);
//                startActivity(intent);

                }

               // Not implemented here
                return false;
           /* case R.id.action_settings:
                // Do Fragment menu item stuff here
                Bundle argss = new Bundle();
                argss.putString("Menu", "You pressed done button.");
                Fragment details = new AddAddressInformation();
                details.setArguments(argss);
                FragmentManager fragmentManagers = getFragmentManager();
                fragmentManagers.beginTransaction().replace(R.id.container_body, details).commit();
                Toast.makeText(getApplicationContext(), "Homewised action is selected!", Toast.LENGTH_SHORT).show();

                return true;*/
            default:
                break;
        }

        return false;
       /* int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_plus) {
            Bundle args = new Bundle();
            args.putString("Menu", "You pressed done button.");
            Fragment detail = new AppointmentAddButton();
            detail.setArguments(args);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container_body, detail).commit();
            *//*Intent intent = new Intent(HomeWisedMainActivity.this, Invoices.class);
            startActivity(intent);*//*
*//*Phone dialer*//**//*
            Intent dialer= new Intent(Intent.ACTION_DIAL);
            startActivity(dialer);*//*
           *//* *//**//*Speech alert open*//**//*
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            startActivityForResult(intent, 1234);*//*

            //Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();

            return true;
        }

        else if(id == R.id.action_plus){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }
*/
       // return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        if (getFragmentManager().getBackStackEntryCount() > 0) {

            if (!isCurrentWalkHomeFragment().equalsIgnoreCase(
                    "HomeWisedMainActivity"))
                getFragmentManager().popBackStack();
            else {
                Toast.makeText(getApplicationContext(), "Are your sure want to Logout?)",
                        Toast.LENGTH_LONG).show();

            }

        }

    /*@Override
    public void onBackPressed() {



        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();


        }*/

        /*if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            toast = Toast.makeText(this, "Press back again to close this app", Toast.LENGTH_SHORT);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            super.onBackPressed();
        }*/
        /*new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        HomeWisedMainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();*/


    }

    private String isCurrentWalkHomeFragment() {

        String activeFragmentName = getFragmentManager().getBackStackEntryAt(
                getFragmentManager().getBackStackEntryCount() - 1).getName();
        return activeFragmentName;

    }



    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {


        Bundle args = new Bundle();
        args.putString("HomeWised", "HomeWised");
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        selectedPosition=position;
        if (position == 0) {
            fragment = new AppointmentFragment();
            title = getString(R.string.title_appointent);

        } else if (position == 1) {
            fragment = new CustomersFragment();
            title = getString(R.string.title_customers);

            // View v=findViewById(R.id.action_plus);
        } else if (position == 2) {
            fragment = new LeadsFragments();
            title = getString(R.string.title_leads);



        } else if (position == 3) {
            fragment = new MyProfileFragment();
            title = getString(R.string.title_myprofile);
        } else if (position == 4) {
            fragment = new Invoices();
            title = getString(R.string.title_invoices);

        } else if (position == 5) {
            fragment = new CatalogFragment();
            title = getString(R.string.title_catalog);

        } else if (position == 6) {
            fragment = new ContactSupportFragment();
            title = "ContactSupport";
        } else if (position == 7) {
            fragment = new PrefsFragment();
            title = "Settings";


        } else if (position == 8) {

            AlertUtil.displaylogoutDialog(context);
            title = getString(R.string.title_sight_out);

        }
        if (fragment != null) {
            fragment.setArguments(args);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_body, fragment).commit();
            getSupportActionBar().setTitle(title);
        } else {
            HomeWisedLog.d("HomeWisedMainActivity", "Error in creating fragment");

        }
    }
}
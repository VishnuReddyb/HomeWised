package com.nunc.Homewised.activity;

import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.Locale;

/**
 * Created by NUNC 21-11-2015.
 */
public class PhoneNumberUsFormat implements TextWatcher {
    private boolean mFormatting; // this is a flag which prevents the  stack overflow.
    private int mAfter;
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        mAfter  =   after; // flag to detect backspace..


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // nothing to do here.

    }

    @Override
    public void afterTextChanged(Editable s) {

        if (!mFormatting) {
            mFormatting = true;
            // using US formatting...
            if(mAfter!=0) // in case back space ain't clicked...
                PhoneNumberUtils.formatNumber(s, PhoneNumberUtils.getFormatTypeForLocale(Locale.US));
            mFormatting = false;
        }

    }
}

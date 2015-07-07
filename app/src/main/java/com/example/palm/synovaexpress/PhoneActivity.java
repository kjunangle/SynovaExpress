package com.example.palm.synovaexpress;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by paloppop on 7/6/2015.
 */
public class PhoneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String phoneNumS = getIntent().getExtras().getString("phoneNumber");
        Integer phoneNum = Integer.parseInt(phoneNumS);

        MyPhoneListener phoneListener = new MyPhoneListener();
        TelephonyManager telephonyManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        try {
            // set the data
            //for input telephone number
            String uri = "tel:0" + phoneNum;
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
            startActivity(callIntent);
        }catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Your call has failed...",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private class MyPhoneListener extends PhoneStateListener {
        private boolean onCall = false;

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);

            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    // phone ringing...
                    //if incoming number == 080000 print sophittha (think for try)
                    Toast.makeText(PhoneActivity.this, incomingNumber + " calls you",
                            Toast.LENGTH_LONG).show();
                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK:
                    // one call exists that is dialing, active, or on hold
                    //Toast.makeText(MainActivity.this, "on call...",Toast.LENGTH_SHORT).show();

                    //because user answers the incoming call
                    onCall = true;
                    break;

                case TelephonyManager.CALL_STATE_IDLE:
                    // in initialization of the class and at the end of phone call
                    // detect flag from CALL_STATE_OFFHOOK
                    if (onCall == true) {
                        //Toast.makeText(MainActivity.this, "restart app after call",Toast.LENGTH_LONG).show();

                        //restart our application
                        //Intent restart = getBaseContext().getPackageManager().
                        //getLaunchIntentForPackage(getBaseContext().getPackageName());

                        Intent intent = new Intent(PhoneActivity.this,InformationActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        onCall = false;
                    }
                    break;

                default:
                    break;
            }

        }
    }
}

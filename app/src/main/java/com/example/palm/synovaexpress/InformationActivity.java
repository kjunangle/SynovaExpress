package com.example.palm.synovaexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by paloppop on 7/5/2015.
 */
public class InformationActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    ImageButton scan_btn,pending_btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        textView = (TextView)findViewById(R.id.phone);
        textView.setText("0831039888");

        SeekBar seekBar = (SeekBar)findViewById(R.id.slider);
        seekBar.setMax(100);
        seekBar.setProgress(0);
        seekBar.setOnSeekBarChangeListener(this);

        scan_btn = (ImageButton)findViewById(R.id.scanButton);
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationActivity.this,ScanOutputActivity.class);
                startActivity(intent);
            }
        });

        pending_btn = (ImageButton)findViewById(R.id.pendingButton);
        pending_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationActivity.this,PendingActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(i >= 90){
            Intent intent = new Intent(InformationActivity.this,PhoneActivity.class);
            intent.putExtra("phoneNumber",textView.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

package com.example.palm.synovaexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by paloppop on 7/5/2015.
 */
public class InformationActivity extends Activity {

    ImageButton scan_btn,pending_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

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
}

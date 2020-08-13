package com.pwdnagpur.notify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    TextView id;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        id = findViewById(R.id.id);
        name = findViewById(R.id.name);

        Intent intent = getIntent();
            String value1 = intent.getStringExtra("workid");
            String value2 = intent.getStringExtra("name");
            id.setText(value1);
            name.setText(value2);




    }
}

package com.endurance.fgtv1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Jipsa on 3/13/2017.
 */

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        String userName = getIntent().getStringExtra("UserName");

        TextView tv = (TextView) findViewById(R.id.userTV);
        tv.setText(userName);
    }

}

package com.endurance.fgtv1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Jipsa on 3/14/2017.
 */

public class Birthday extends Activity {
    Button buttonCalender;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birthday);
    }

    public void showDialogonButtonClick(){
            buttonCalender = (Button) findViewById(R.id.buttonCalender);
           buttonCalender.setOnClickListener(
                   new View.onClickListener()
           );
        }
    }
}

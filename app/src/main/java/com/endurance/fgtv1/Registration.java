package com.endurance.fgtv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jipsa on 3/13/2017.
 */

public class Registration extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }

    public void onNextClick(View view){
        if(view.getId()==R.id.buttonNext1){

            EditText userName = (EditText) findViewById(R.id.userName);
            EditText pwd1 = (EditText) findViewById(R.id.pwd1);
            EditText pwd2 = (EditText) findViewById(R.id.pwd2);

            String userNameStr = userName.getText().toString();
            String pwd1str = pwd1.getText().toString();
            String pwd2str = pwd2.getText().toString();

            if(!pwd1str.equals(pwd2str)){

                Toast toast = Toast.makeText(Registration.this, "Passwords don't match!",Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                //insert data to db
                Contact c = new Contact();
                c.setUserName(userNameStr);
                c.setPassword(pwd1str);

                helper.insertContact(c);

                Intent intent = new Intent(Registration.this, Birthday.class);
                startActivity(intent);

               // c.setDob();
               // c.setHeight();
                //c.setWeight();
            }

        }
    }
}

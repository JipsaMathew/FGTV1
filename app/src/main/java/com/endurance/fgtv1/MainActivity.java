package com.endurance.fgtv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
        if(view.getId()==R.id.buttonLogin){  //if id of button matches with the id of button clicked

            EditText userName = (EditText) findViewById(R.id.userName);
            String uName = userName.getText().toString();

            EditText password = (EditText) findViewById(R.id.password);
            String pass = password.getText().toString();

            //searchPass() returns the password values corresponding to the user from db
            String pwd = helper.searchPass(uName);

            if(pass.equals(pwd)) {

                Intent intent = new Intent(MainActivity.this, Home.class); //intent is used to start a new activity
                intent.putExtra("UserName", uName);
                startActivity(intent);
            }
            else{
                Toast toast = Toast.makeText(MainActivity.this, "User name and password don't match!",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        if(view.getId()==R.id.buttonRegister){
            Intent intent = new Intent(MainActivity.this, Registration.class);
            startActivity(intent);
        }
    }
}

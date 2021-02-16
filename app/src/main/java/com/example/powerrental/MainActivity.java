// Author: Hieu Dang
// Date: 02/16/2021
// Description: The app determines the cost of a power washer or tiller.

package com.example.powerrental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Display the icon in Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Declare object variables for the View
        final EditText txtNumOfDays =findViewById(R.id.txtNumOfDays);
        final RadioButton radPowerWasher = findViewById(R.id.radWasher);
        final RadioButton radTiller = findViewById(R.id.radTiller);
        final Button btnComputeCost = findViewById(R.id.btnCompute);
        final TextView txtFinalCost = findViewById(R.id.txtFinalCost);

        //Compute Cost Button Event Listener
        btnComputeCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declare local variables
                final double POWER_WASHER_COST = 55.99;
                final double TILLER_COST = 68.99;
                double totalCost = 0.0;
                DecimalFormat hundred = new DecimalFormat("#.##");

                //Get Number of Days
                int numOfDays = parseInt(txtNumOfDays.getText().toString());
                //Toast.makeText(MainActivity.this, String.valueOf(numOfDays), Toast.LENGTH_LONG).show();
                if(numOfDays > 7){
                    //Show warning message: Can not rent more than 7 days
                    Toast.makeText(MainActivity.this, "Warning: Can not rent more than 7 days", Toast.LENGTH_LONG).show();
                }else{
                    //Get selected Power source, check to see if user has selected an option
                    if(radPowerWasher.isChecked() == false && radTiller.isChecked() == false){
                        //Show warning message: Please select one of the Power options
                        Toast.makeText(MainActivity.this, "Warning: Please select one of the Power options", Toast.LENGTH_LONG).show();
                    }else{
                        //Calculate Cost
                        if(radPowerWasher.isChecked()){
                            totalCost = POWER_WASHER_COST * numOfDays;
                        }else{
                            totalCost = TILLER_COST * numOfDays;
                        }
                        //Show Total Cost
                        txtFinalCost.setText("Total cost is $" + hundred.format(totalCost).toString());
                    }


                }


            }
        });


    }
}
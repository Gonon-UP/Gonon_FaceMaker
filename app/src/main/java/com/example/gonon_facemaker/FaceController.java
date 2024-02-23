package com.example.gonon_facemaker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class FaceController implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    //a reference to the activity I'm part of
    private MainActivity myActivity;
    private Face face;


    //ctor requires a MainActivity so it can call findViewById()
    public FaceController(MainActivity initActivity) {
        myActivity = initActivity;
    }


    @Override
    public void onClick(View view) {
        face.randomize();
        RadioGroup radiogroup = myActivity.findViewById(R.id.llRadioButton);
        if (view instanceof RadioButton) {
            RadioButton clickedRadioGroup = (RadioButton) view;
            String buttonLabel = clickedRadioGroup.getText().toString();
            if (buttonLabel.equalsIgnoreCase("Bald")) {
                face.setHairStyle(0);
            }
            else if (buttonLabel.equalsIgnoreCase("Straight hair")) {
                face.setHairStyle(1);
            }
            else if (buttonLabel.equalsIgnoreCase("Buzz cut")) {
                face.setHairStyle(2);
            }
        }
        face.invalidate();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {


        Spinner mySpinner = myActivity.findViewById(R.id.hair_Spinner);
//        FaceController controller = new FaceController(myActivity);
//        mySpinner.setOnItemClickListener(controller);
        if (pos == 0)   {
            face.setHairStyle(pos);
        }
        else if (pos == 1)   {
            face.setHairStyle(pos);
        }
        else if (pos == 3)   {
            face.setHairStyle(pos);
        }
        face.invalidate();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // do nothing

    }


//    @Override
//    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
//        // Handle the checked radio button here
//        if(checkedId == R.id.Ba) {
//            // Do something when radio button 1 is selected
//        } else if(checkedId == R.id.radio_button2) {
//            // Do something when radio button 2 is selected
//    }


}

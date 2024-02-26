package com.example.gonon_facemaker;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;



public class FaceController implements View.OnClickListener, AdapterView.OnItemSelectedListener,
        RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    //a reference to the activity I'm part of
    private MainActivity myActivity;
    private Face face;

    private int red, green, blue, radioOption, radioId;
    private RadioButton radioButton;



    //ctor requires a MainActivity so it can call findViewById()
    public FaceController(Face initface, MainActivity initActivity) {
        face = initface;
        myActivity = initActivity;
    }


    @Override
    public void onClick(View view) {


        face.randomize();

        // Updates seekbar when random button is pressed
        if (radioOption == 0) {
            radioButton = myActivity.findViewById(R.id.hair_RadioButton);
            radioButton.setChecked(true);
            updateProgressBar(face.getHairColor());
        }
        if (radioOption == 1)   {
            radioButton = myActivity.findViewById(R.id.eyes_RadioButton);
            radioButton.setChecked(true);
            updateProgressBar(face.getEyeColor());
        }
        if (radioOption == 2)   {
            radioButton = myActivity.findViewById(R.id.skin_RadioButton);
            radioButton.setChecked(true);
            updateProgressBar(face.getSkinColor());
        }
        spinnerOnCreate();


        face.invalidate();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

        int temp = adapterView.getSelectedItemPosition();
        if (temp == 0) {
            face.setHairStyle(0);
        } else if (temp == 1) {
            face.setHairStyle(1);
        } else if (temp == 2) {
            face.setHairStyle(2);
        }
        face.invalidate();
    }


    // To update spinner selection upon randomizing
    public void spinnerOnCreate() {
        Spinner spinnerOnCreate = myActivity.findViewById(R.id.hair_Spinner);
        spinnerOnCreate.setSelection(face.getHairStyle());
        face.invalidate();
    }




    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // do nothing

    }


    /* Citation:
    * https://stackoverflow.com/questions/6780981/android-radiogroup-how-to-configure-the-event-listener
    *
    * Problem: Had trouble implementing the radio group
    */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        radioId = checkedId;
        // RadioOption will be used to set seekbar changes
        if (checkedId == R.id.hair_RadioButton) {
            radioOption = 0;
            updateProgressBar(face.getHairColor());

        }
        else if (checkedId == R.id.eyes_RadioButton) {
            radioOption = 1;
            updateProgressBar(face.getEyeColor());

        }
        else if (checkedId == R.id.skin_RadioButton) {
            radioOption = 2;
            updateProgressBar(face.getSkinColor());
        }

        face.invalidate();

    }


    // Sets up all the rgb values to seekbar
    public void updateProgressBar(int color)    {
        SeekBar redSeek = myActivity.findViewById(R.id.RED_seekBar);
        SeekBar greenSeek = myActivity.findViewById(R.id.GREEN_seekBar);
        SeekBar blueSeek = myActivity.findViewById(R.id.BLUE_seekBar);

        redSeek.setProgress(Color.red(color));
        greenSeek.setProgress(Color.green(color));
        blueSeek.setProgress(Color.blue(color));


        face.invalidate();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        TextView redText = myActivity.findViewById(R.id.RED_textView);
        TextView greenText = myActivity.findViewById(R.id.GREEN_textView);
        TextView blueText = myActivity.findViewById(R.id.BLUE_textView);


        if (seekBar == (myActivity.findViewById(R.id.RED_seekBar))) {
            redText.setText("RED = " + progress);
            red = progress;
        } else if (seekBar == myActivity.findViewById(R.id.GREEN_seekBar)) {
            greenText.setText("GREEN = " + progress);
            green = progress;
        } else if (seekBar == myActivity.findViewById(R.id.BLUE_seekBar)) {
            blueText.setText("BLUE = " + progress);
            blue = progress;
        }

        int COLOR = Color.argb(255, red, green, blue);

        if (radioId == R.id.hair_RadioButton)   {
            face.setHairColor(COLOR);
        }
        else if (radioId == R.id.eyes_RadioButton)   {
            face.setEyeColor(COLOR);
        }
        else if (radioId == R.id.skin_RadioButton)   {
            face.setSkinColor(COLOR);
        }
        face.invalidate();
}




    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

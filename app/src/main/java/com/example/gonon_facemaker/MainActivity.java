/* @author Eduardo Gonon
 * CS301 Facemaker HW
 */


package com.example.gonon_facemaker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView red_textView;
    private TextView green_textView;
    private TextView blue_textView;
    private SeekBar red_seekBar;
    private SeekBar green_seekBar;
    private SeekBar blue_seekBar;




    // Step one is to implement onSeekBarChangeListener
    // onCreate will be executed the first time the app is run
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Face face = findViewById(R.id.Face_surfaceView);

        FaceController faceController = new FaceController(face,this);


        // Reference for random button
        Button myRand = findViewById(R.id.random_button);
        myRand.setOnClickListener(faceController);


        // Reference for radio button
        RadioGroup radioGroup = findViewById(R.id.face_radioGroup);
        radioGroup.setOnCheckedChangeListener(faceController);

//        RadioButton hairButton = findViewById(R.id.hair_RadioButton);
//        hairButton.setOnClickListener(faceController);
//
//        RadioButton eyeButton = findViewById(R.id.eyes_RadioButton);
//        eyeButton.setOnClickListener(faceController);
//
//        RadioButton skinButton = findViewById(R.id.skin_RadioButton);
//        skinButton.setOnClickListener(faceController);



        // References for seekbars & textviews
        red_textView = (TextView) findViewById(R.id.RED_textView);
        red_textView.setOnClickListener(faceController);

        green_textView = (TextView) findViewById(R.id.GREEN_textView);
        green_textView.setOnClickListener(faceController);

        blue_textView = (TextView) findViewById(R.id.BLUE_textView);
        blue_textView.setOnClickListener(faceController);



        red_seekBar = (SeekBar) findViewById(R.id.RED_seekBar);
        red_seekBar.setOnSeekBarChangeListener(faceController);

        green_seekBar = (SeekBar) findViewById(R.id.GREEN_seekBar);
        green_seekBar.setOnSeekBarChangeListener(faceController);

        blue_seekBar = (SeekBar) findViewById(R.id.BLUE_seekBar);
        blue_seekBar.setOnSeekBarChangeListener(faceController);


        /* Problem: Creating a spinner for the face
         * Citation: https://developer.android.com/develop/ui/views/components/spinner#java
        */


        // Reference for spinner
        Spinner spinner_List = findViewById(R.id.hair_Spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayList<String> hairList = new ArrayList<>();
        hairList.add("Bald");
        hairList.add("Straight hair");
        hairList.add("Buzz cut");

        ArrayAdapter<String> hairListAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                hairList
        );
        // Specify the layout to use when the list of choices appears.
        hairListAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        // Apply the adapter to the spinner

        spinner_List.setAdapter(hairListAdapter);
        spinner_List.setOnItemSelectedListener(faceController);
    }
}
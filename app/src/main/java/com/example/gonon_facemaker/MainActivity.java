/* @author Eduardo Gonon
 * CS301 Facemaker HW
 */


package com.example.gonon_facemaker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import kotlin._Assertions;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerList;
    private TextView red_textView;
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

        Face FaceView = findViewById(R.id.Face_surfaceView);

        //FaceController faceController = new FaceController(FaceView, this);




        // References for seekbars & textviews
        red_textView = (TextView) findViewById(R.id.RED_textView);
        green_textView = (TextView) findViewById(R.id.GREEN_textView);
        blue_textView = (TextView) findViewById(R.id.BLUE_textView);

        red_seekBar = (SeekBar) findViewById(R.id.RED_seekBar);
        green_seekBar = (SeekBar) findViewById(R.id.GREEN_seekBar);
        blue_seekBar = (SeekBar) findViewById(R.id.BLUE_seekBar);


        // All these will be for setting seekbar changes
        red_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (seekBar == findViewById(R.id.RED_seekBar)) {
                    red_textView.setText("RED = " + i);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });

        green_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (seekBar == findViewById(R.id.GREEN_seekBar)) {
                    green_textView.setText("GREEN = " + i);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blue_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (seekBar == findViewById(R.id.BLUE_seekBar)) {
                    blue_textView.setText("BLUE = " + i);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        spinnerList = findViewById(R.id.hair_Spinner);

        ArrayList<String> hairList = new ArrayList<>();
            hairList.add("Bald");
            hairList.add("Straight hair");
            hairList.add("Buzz cut");

        ArrayAdapter<String> hairListAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                hairList
        );
        hairListAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinnerList.setAdapter(hairListAdapter);
    }
}
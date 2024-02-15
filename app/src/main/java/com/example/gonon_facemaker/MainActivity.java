/* @author Eduardo Gonon
 * CS301 Facemaker HW
 */


package com.example.gonon_facemaker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // It is better to create a private MainActivity myActivity instead
        red_textView = (TextView) findViewById(R.id.RED_textView);
        green_textView = (TextView) findViewById(R.id.GREEN_textView);
        blue_textView = (TextView) findViewById(R.id.BLUE_textView);


        red_seekBar = (SeekBar) findViewById(R.id.RED_seekBar);
        green_seekBar = (SeekBar) findViewById(R.id.GREEN_seekBar);
        blue_seekBar = (SeekBar) findViewById(R.id.BLUE_seekBar);


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

        ArrayList<String> hairlist = new ArrayList<>();
            hairlist.add("Curly Hair");
            hairlist.add("Straight hair");
            hairlist.add("Bald");
            hairlist.add("Pompadour Hair");

        ArrayAdapter<String> hairlistAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                hairlist
        );
        hairlistAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinnerList.setAdapter(hairlistAdapter);
    }
}
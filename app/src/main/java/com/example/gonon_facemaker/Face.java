package com.example.gonon_facemaker;
import java.util.Random;

/*
 *
 * In addition to the MainActivity subclass, add a Face class in your project
 * Basic class to describe what a face is and it's characteristics
 *
 */
public class Face {

    // Initializing properties private all
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle; // Identifies which hair style the face has


    // Constructor for face
    public Face(int _skinColor, int _eyeColor, int _hairColor, int _hairStyle) {
        this.skinColor = _skinColor ;
        this.eyeColor = _eyeColor;
        this.hairColor = _hairColor;
        this.hairStyle = _hairStyle;
    }

    public static void main(String[] args) {
        // Main method
    }
// helper method
//    static void randomize(int _skinColor, int _eyeColor, int _hairColor, int _hairStyle)    {
//        this.skinColor = _skinColor;
//        this.eyeColor = _eyeColor;
//        this.hairColor = _hairColor;
//        this.hairStyle = _hairStyle;
//
//    }

}
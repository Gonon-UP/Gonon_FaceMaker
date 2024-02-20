/* @author Eduardo Gonon
 * CS301 Facemaker HW
 */

package com.example.gonon_facemaker;
import java.util.Random;
import android.graphics.Canvas;
import android.graphics.Color;

/*
 *
 * In addition to the MainActivity subclass, add a Face class in your project
 * Basic class to describe what a face is and it's characteristics
 *
 */
public class Face {

    // Initializing properties
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle; // Identifies which hair style the face has

    public Face()   {
        randomize();
    }


    // randomize method will randomize all four int properties for face
    public void randomize() {
        Random random = new Random();

        // Randomizing int values for property values
        this.skinColor = Color.argb(255, 55, 55, 55);
        this.eyeColor = random.nextInt(256);
        this.hairColor = random.nextInt(256);
        this.hairStyle = random.nextInt(4); // Total of 4 hairstyle options
    }


    public void onDraw(Canvas canvas)   {
        // To be implemented soon
//        drawFace(canvas, yellow);
//        drawEyes(canvas, black);
//        drawHair(canvas, black, 1);
    }


    // Getter methods for instance variables
    public int getSkinColor() {
        return this.skinColor;
    }

    public int getEyeColor()    {
        return this.eyeColor;
    }

    public int getHairColor()   {
        return this.hairColor;
    }

    public int getHairStyle() {
        return hairStyle;
    }



    // Setter methods for instance variables
    public void setSkinColor(int skinColor) {
        this.skinColor = skinColor;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }
}
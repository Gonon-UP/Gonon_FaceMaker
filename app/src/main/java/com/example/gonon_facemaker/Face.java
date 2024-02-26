/* @author Eduardo Gonon
 * CS301 Facemaker HW
 */

package com.example.gonon_facemaker;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.RadioButton;
import android.widget.SeekBar;

/*
 *
 * In addition to the MainActivity subclass, add a Face class in your project
 * Basic class to describe what a face is and it's characteristics
 *
 */
public class Face extends SurfaceView {

    public Paint hairPaint = new Paint();
    public Paint eyePaint = new Paint();
    public Paint skinPaint = new Paint();
    private final Paint black = new Paint();
    // Initializing properties
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle; // Identifies which hair style the face has


    private float width;
    private float height;

    private static final int BALD = 0;
    private static final int STRAIGHT = 1;
    private static final int BUZZCUT = 2;





    // Preliminary stages for SurfaceView
    public Face(Context context) {
        super(context);
    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public Face(Context context, AttributeSet attrs)    {

        super(context, attrs);

        randomize();

        this.setWillNotDraw(false);
    }


    // randomize method will randomize all four int properties for face
    public void randomize() {
        Random random = new Random();

        // Randomizing int values for property values
        this.skinColor = Color.argb(255, random.nextInt(255),
                random.nextInt(255), random.nextInt(255));

        this.eyeColor = Color.argb(255, random.nextInt(255),
                random.nextInt(255), random.nextInt(255));

        this.hairColor = Color.argb(255, random.nextInt(255),
                random.nextInt(255), random.nextInt(255));

        this.hairStyle = random.nextInt(3); // Total of 4 hairstyle options


    }


    public void drawFace(Canvas canvas)
    {
        // For face
        canvas.drawCircle(width, height, 300,
                skinPaint);

        // Mouth
        canvas.drawOval(width - 180, height - 10,width + 180,
                height + 190, black);

        // Smile
        canvas.drawRect(width - 180, height + 60,
                width + 180, height + 90, black);
        canvas.drawOval(width - 180, height - 11,
                width + 180, height + 130, skinPaint);
    }


    public void drawEyes(Canvas canvas)    {
        // For eyes
        canvas.drawCircle(width - 130, height - 100,
                45,  eyePaint); // Left eye
        canvas.drawCircle(width + 130, height - 100,
                45, eyePaint); // Right eye
    }

    public void drawHair(Canvas canvas)   {
        int i;
        // Draw nothing, bald
        if (hairStyle == BALD)    {
           // do nothing
        }
        // Straight hair
        else if (hairStyle == STRAIGHT) {
            for (i = 0; i < 400; i += 20) {
                canvas.drawLine(width - 200 + i, height - 300,
                        width - 200 + i, height - 200, hairPaint);
            }
        }
        //
        else if (hairStyle == BUZZCUT)   {
            //draw simple mouth
            canvas.drawArc(width - 220, height - 300,
                    width + 220, height - 100,
                    180, 180, false, hairPaint);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        black.setColor(0xFF000000);

        height = getHeight() / 2;
        hairPaint.setColor(hairColor);
        eyePaint.setColor(eyeColor);
        skinPaint.setColor(skinColor);


        drawFace(canvas);
        drawEyes(canvas);
        drawHair(canvas);
    }





    // Retrieves dimensions of the layout width
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec) / 2;
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
        return this.hairStyle;
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

    public void updateProgressBar(int colors) {
    }
}
/* @author Eduardo Gonon
 * CS301 Facemaker HW
 */

package com.example.gonon_facemaker;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/*
 *
 * In addition to the MainActivity subclass, add a Face class in your project
 * Basic class to describe what a face is and it's characteristics
 *
 */
public class Face extends SurfaceView {

    // Initializing properties
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle; // Identifies which hair style the face has



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

        this.hairStyle = random.nextInt(4); // Total of 4 hairstyle options
    }


    //It's a good habit to create Paint objects just once rather than
    //recreate them each time onDraw() is called
    private final Paint black = new Paint();
    private final Paint yellow = new Paint();
    private float width;

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

        //hex colors
        black.setColor(0xFF000000);
        yellow.setColor(0xFFFFFF00);
        Paint white = new Paint();
        white.setColor(0xFFFFFFFF);

        this.setWillNotDraw(false);
    }

    public void drawFace(Canvas canvas, Paint Color) // Location on canvas
    {
        // For face
        canvas.drawCircle((width / 2), 350, 300,
                Color);

        // Mouth
        canvas.drawOval((width / 2) - 180, 340,(width / 2) + 180,
                540, black);

        // Smile
        canvas.drawRect((width / 2) - 180, 410,
                (width / 2) + 180, 440, black);
        canvas.drawOval((width / 2) - 180, 339,
                (width / 2) + 180, 480, Color);
    }

    public void drawEyes(Canvas canvas, Paint Color)    {
        // For eyes
        canvas.drawCircle((width / 2) - 130, 250, 45,  Color); // Left eye
        canvas.drawCircle((width / 2) + 130, 250, 45, Color); // Right eye
    }

    public void drawHair(Canvas canvas, Paint Color, int option)   {
        int i;
        if (option == 0)    {
            // Draw nothing, bald
            //canvas.drawLine((width / 2) - 200, 150, );
            canvas.drawPoint((width / 2) - 250, 150, black);
            canvas.drawPoint((width / 2) + 250, 150, black);
            canvas.drawPoint((width / 2), 50, black);
        }
        else if (option == 1) {
            for (i = 0; i < 400; i += 20) {
                canvas.drawLine((width / 2) - 200 + i, 50,
                        (width / 2) - 200 + i, 150, Color);
            }
        }
        else if (option == 2)   {
            // Draw Curly Hair
        }
        else if (option == 3)   {
            // draw
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawFace(canvas, yellow);
        drawEyes(canvas, black);
        drawHair(canvas, black, 0);
    }




    // Retrieves dimensions of the layout width
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
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
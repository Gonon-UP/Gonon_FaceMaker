/* @author Eduardo Gonon
 * CS301 Face maker HW
 */


package com.example.gonon_facemaker;
import static android.graphics.Color.BLACK;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class Face_SurfaceView extends SurfaceView {

    //It's a good habit to create Paint objects just once rather than
    //recreate them each time onDraw() is called
    private Paint black = new Paint();
    private Paint yellow = new Paint();
    private float width;

    // Preliminary stages for SurfaceView
    public Face_SurfaceView(Context context) {
        super(context);
    }

    public Face_SurfaceView(Context context, AttributeSet attrs)    {

        super(context, attrs);

        //hex colors
        black.setColor(0xFF000000);
        yellow.setColor(0xFFFFFF00);

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
        drawHair(canvas, black, 1);
    }


    public Face_SurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Face_SurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    // Retrieves dimensions of the layout width
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
    }
}

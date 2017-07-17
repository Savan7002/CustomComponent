package com.custom.indianic.custome;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class CustomClass extends View {

    private Paint paint;
    private Paint paint1;
    private Paint paintLine;
    private Paint paintText;
    private Context context;
    private String type = "V";
    private int count;
    private float width;

    public CustomClass(Context context) {
        super(context);
    }

    /**
     * Constructor which passes current context and attribute set from xml file
     *
     * @param context
     * @param attrs
     */
    public CustomClass(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        paint = new Paint();
        paint1 = new Paint();
        paintLine = new Paint();
        paintText = new Paint();
        paintLine.setColor(Color.BLACK);
        paintLine.setStrokeWidth(2f);
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(30f);
        init(attrs);
    }

    /**
     * Method which is initialise attributes which comes from xml file
     * @param attrs
     */
    private void init(AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomClass);
            try {
                final int color1 = a.getColor(R.styleable.CustomClass_color1, context.getResources().getColor(android.R.color.holo_blue_light));
                final int color2 = a.getColor(R.styleable.CustomClass_color2, context.getResources().getColor(android.R.color.holo_blue_light));
                width = a.getDimension(R.styleable.CustomClass_width, 50f);
                count = a.getInt(R.styleable.CustomClass_count, 5);
                type = a.getString(R.styleable.CustomClass_type);
                paint.setStrokeWidth(width);
                paint1.setStrokeWidth(width);
                paint.setColor(color1);
                paint1.setColor(color2);
            } finally {
                a.recycle();
            }
        }
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (type.equals("H")) {
            int x = 50;
            int y = 100;
            canvas.drawLine(50,50,50,getMeasuredHeight(),paintLine);
            for (int i = 0; i < count; i++) {
                final int rmdWidth = randomeWidth();
                if ((i % 2) == 0) {
                    canvas.drawLine(50, y, rmdWidth, y, paint);
                } else {
                    canvas.drawLine(50, y, rmdWidth, y, paint1);
                }
                canvas.drawText(""+(getMeasuredWidth() + rmdWidth)+"%",rmdWidth + 10,y+10,paintText);
                canvas.drawText(""+(i + 1),30,y+10,paintText);
                y += width*2;
            }
        } else {
            int x = 50;
            int y = 100;
            canvas.drawLine(0,getMeasuredHeight()-100,getMeasuredWidth(),getMeasuredHeight()-100,paintLine);
            for (int i = 0; i < count; i++) {
                final int rmdHeight = randomeHeight();
                if ((i % 2) == 0) {
                    canvas.drawLine(x, rmdHeight, x, getMeasuredHeight()-100, paint);
                } else {
                    canvas.drawLine(x, rmdHeight, x, getMeasuredHeight()-100, paint1);
                }
                canvas.drawText(""+(getMeasuredHeight() - rmdHeight)+"%",x-25,rmdHeight - 50,paintText);
                canvas.drawText(""+(i + 1),x-20,getMeasuredHeight()-70,paintText);
                x += width*2;
            }
        }
    }

    /**
     * Method which is returns rendom width for horizontal lines
     *
     * @return
     */
    private int randomeWidth() {
        final Random r = new Random();
        return r.nextInt((getMeasuredWidth() - 100) - 50) + 50;
    }

    /**
     * Method which is returns rendom height for vertical lines
     *
     * @return
     */
    private int randomeHeight() {
        final Random r = new Random();
        return r.nextInt((getMeasuredHeight() - 100) - 100) + 100;
    }

    /**
     * Method which is set the type of graph horizonatl or vertical
     * @param vType
     */
    public void setType(final String vType) {
        type = vType;
    }

}

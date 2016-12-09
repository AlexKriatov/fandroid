package com.example.a5androidintern1.customtoucheventcanvas;


import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;


public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(new GraphicsView(this));
    }


    static public class GraphicsView extends View {
        private float x = 40;
        private float y = 40;
        Paint paint = new Paint();
        static Canvas c = new Canvas();


        public GraphicsView(Context context) {
            super(context);


        }

        @Override
        protected void onDraw(Canvas canvas) {
            RectF rectF = new RectF(45,10,55,100);
            RectF rectFx = new RectF(100,100,100,100);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);

            canvas.drawColor(Color.BLUE);
            canvas.drawCircle(x, y, 20, paint);
            canvas.drawRect(rectF,paint);
            canvas.drawPoint(30,10,paint);
            super.onDraw(canvas);
        }


    }
}
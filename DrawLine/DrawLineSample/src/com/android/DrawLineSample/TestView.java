package com.android.DrawLineSample;

import java.util.Random;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.util.DisplayMetrics;

class TestView extends View {

	public Canvas canvas;
	public Paint p;
	private Bitmap bitmap;
	float x,y;
	int bgColor;
	Random rand;
	
	public TestView(Context context) {
		super(context);
	    DisplayMetrics dm = getResources().getDisplayMetrics();
		int SCREEN_WIDTH = dm.widthPixels;
		int SCREEN_HEIGHT = dm.heightPixels;
		bgColor = Color.WHITE;
		bitmap = Bitmap.createBitmap(SCREEN_WIDTH, SCREEN_HEIGHT, Bitmap.Config.ARGB_8888);
		canvas = new Canvas();
		canvas.setBitmap(bitmap);
		rand = new Random();
		p = new Paint(Paint.DITHER_FLAG);
		p.setAntiAlias(true);
		p.setColor(Color.RED);
		p.setStrokeCap(Paint.Cap.ROUND);
		p.setStrokeWidth(8);
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			canvas.drawLine(x, y, event.getX(), event.getY(), p);
			invalidate();
		}

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			x = event.getX();				
			y = event.getY();
			canvas.drawPoint(x, y, p);
			invalidate();
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
		
		}
		x = event.getX();
		y = event.getY();
		return true;
	}
	
	@Override
	public void onDraw(Canvas c) {			    		
		c.drawBitmap(bitmap, 0, 0, null);	      
	}
	
	public void setPenColor(String color){
		if (color.equals("Red"))
			p.setColor(Color.RED);
		if (color.equals("Blue"))
			p.setColor(Color.BLUE);
		if (color.equals("Green"))
			p.setColor(Color.GREEN);
		if (color.equals("Black"))
			p.setColor(Color.BLACK);
		if (color.equals("White"))
			p.setColor(Color.WHITE);
	}
	
	public void setBackColor(String color){
		if (color.equals("Red"))
			canvas.drawColor(Color.RED);
		if (color.equals("Blue"))
			canvas.drawColor(Color.BLUE);
		if (color.equals("Green"))
			canvas.drawColor(Color.GREEN);
		if (color.equals("Black"))
			canvas.drawColor(Color.BLACK);
		if (color.equals("White"))
			canvas.drawColor(Color.WHITE);
	}
 }

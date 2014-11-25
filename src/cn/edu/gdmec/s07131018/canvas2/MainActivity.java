package cn.edu.gdmec.s07131018.canvas2;

import java.util.ArrayList;
import java.util.List;

import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	private List<PointF> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}
	private class MyView extends View{
		Paint paint = new Paint();
		public MyView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			list = new ArrayList<PointF>();
			paint.setColor(Color.BLACK);
			paint.setStrokeWidth(5);
		}
		protected void onDraw(Canvas canvas){
			for (PointF f:list){
				canvas.drawPoint(f.x, f.y, paint);
			}
		}
		public boolean onTouchEvent(MotionEvent event){
			PointF pointF = new PointF(event.getX(), event.getY());
			list.add(pointF);
			invalidate();
			return true;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

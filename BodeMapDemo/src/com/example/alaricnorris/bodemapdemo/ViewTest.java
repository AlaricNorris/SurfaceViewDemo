package com.example.alaricnorris.bodemapdemo ;

import android.app.Activity ;
import android.content.Context ;
import android.graphics.Canvas ;
import android.graphics.Color ;
import android.graphics.Paint ;
import android.graphics.Path ;
import android.graphics.Rect ;
import android.os.Bundle ;
import android.util.Log ;
import android.view.MotionEvent ;
import android.view.SurfaceHolder ;
import android.view.SurfaceView ;
import android.view.View ;
import android.view.View.OnTouchListener ;

public class ViewTest extends Activity implements OnTouchListener {

	/** Called when the activity is first created. */
	@ Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState) ;
		MyView myView = new MyView(this) ;
		setContentView(R.layout.fragment_main) ;
		myView.setOnTouchListener(this) ;
	}

	//视图内部类
	//线程内部类
	/**
	 * 	(non-Javadoc)
	 * 	@see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
	 */
	@ Override
	public boolean onTouch(View arg0 , MotionEvent arg1) {
		Log.i("tag" , "getRawX:" + arg1.getRawX()) ;
		Log.i("tag" , "getX:" + arg1.getX()) ;
		return false ;
	}
}
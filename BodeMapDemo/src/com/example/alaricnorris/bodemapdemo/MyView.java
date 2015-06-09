package com.example.alaricnorris.bodemapdemo ;

import android.content.Context ;
import android.view.SurfaceHolder ;
import android.view.SurfaceView ;

public class MyView extends SurfaceView implements SurfaceHolder.Callback {

		private SurfaceHolder holder ;

		private MyThread myThread ;

		public MyView(Context context) {
			super(context) ;
			// TODO Auto-generated constructor stub
			holder = this.getHolder() ;
			holder.addCallback(this) ;
			myThread = new MyThread(holder) ;//创建一个绘图线程
		}

		@ Override
		public void surfaceChanged(SurfaceHolder holder , int format , int width , int height) {
			// TODO Auto-generated method stub
		}

		@ Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			myThread.isRun = true ;
			myThread.start() ;
		}

		@ Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			myThread.isRun = false ;
		}
	}
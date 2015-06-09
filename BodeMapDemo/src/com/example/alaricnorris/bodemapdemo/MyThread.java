package com.example.alaricnorris.bodemapdemo ;

import android.graphics.Canvas ;
import android.graphics.Color ;
import android.graphics.Paint ;
import android.graphics.Path ;
import android.graphics.Rect ;
import android.view.SurfaceHolder ;

public class MyThread extends Thread {

	private SurfaceHolder holder ;

	public boolean isRun ;

	public MyThread(SurfaceHolder holder) {
		this.holder = holder ;
		isRun = true ;
	}

	@ Override
	public void run() {
		int count = 0 ;
		while(isRun) {
			Canvas c = null ;
			try {
				synchronized(holder) {
					c = holder.lockCanvas() ;//锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操作了。
					c.drawColor(Color.BLACK) ;//设置画布背景颜色
					Paint p = new Paint() ; //创建画笔
					p.setColor(Color.WHITE) ;
					Rect r = new Rect(100 , 50 , 300 , 250) ;
					c.drawRect(r , p) ;
					c.drawText("这是第" + (count ++ ) + "秒" , 100 , 310 , p) ;
					// 你可以绘制很多任意多边形，比如下面画六连形  
					p.reset() ;//重置  
					p.setColor(Color.LTGRAY) ;
					p.setStyle(Paint.Style.STROKE) ;//设置空心  
					Path path1 = new Path() ;
					path1.moveTo(180 , 200) ;
					path1.lineTo(200 , 200) ;
					path1.lineTo(210 , 210) ;
					path1.lineTo(200 , 220) ;
					path1.lineTo(180 , 220) ;
					path1.lineTo(170 , 210) ;
					path1.close() ;//封闭  
					c.drawPath(path1 , p) ;
					Thread.sleep(1000) ;//睡眠时间为1秒
				}
			}
			catch(Exception e) {
				// TODO: handle exception
				e.printStackTrace() ;
			}
			finally {
				if(c != null) {
					holder.unlockCanvasAndPost(c) ;//结束锁定画图，并提交改变。
				}
			}
		}
	}
}

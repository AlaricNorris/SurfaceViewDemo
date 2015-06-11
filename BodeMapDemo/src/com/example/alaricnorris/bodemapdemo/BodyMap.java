/**
 * 	BodyMayImageView.java
 * 	com.example.alaricnorris.bodemapdemo
 * 	Function： 	TODO 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-9 		20144L151
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodemapdemo ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.Map ;
import java.util.Set ;
import android.content.Context ;
import android.content.res.TypedArray ;
import android.graphics.Bitmap ;
import android.graphics.BitmapFactory ;
import android.graphics.Canvas ;
import android.graphics.Color ;
import android.graphics.Paint ;
import android.graphics.Paint.Style ;
import android.graphics.Path ;
import android.graphics.Point ;
import android.graphics.Rect ;
import android.graphics.RectF ;
import android.graphics.Region ;
import android.graphics.RegionIterator ;
import android.os.Handler ;
import android.util.AttributeSet ;
import android.util.Log ;
import android.view.MotionEvent ;
import android.widget.ImageView ;
import android.widget.Toast ;

/**
 *	ClassName:	BodyMayImageView
 *	Function: 	TODO ADD FUNCTION
 *	Reason:	 	TODO ADD REASON
 *	@author   	20144L151		
 *	@contact  	Norris.sly@gmail.com
 *	@version  	Ver 1.0
 *	@since   	I used to be a programmer like you, then I took an arrow in the knee 
 *	@Date	 	2015		2015-6-9		下午4:15:07
 *	@see 	 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Fields 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Methods	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 * 	Modified By 	20144L151		 2015-6-9下午4:15:07
 *	Modifications:	TODO
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class BodyMap extends ImageView {

	private Context mContext ;

	//保存所有热点区域
	private Map<String , MapArea> mMapArea ;

	//保存点击的区域
	private Set<String> mFocus ;

	//点击时Path区域的转换，用于触摸点的判断
	protected RectF mPathRectF = new RectF() ;

	public static final int MIN_WIDTH = 320 ;

	public static final int MIN_HEIGHT = 480 ;

	public static final int DEAULT_INNER_MARGIN = 20 ;

	private int mWidth = 0 ;

	private int mHeight = 0 ;

	/**
	 * 	多边形颜色
	 * 	int			:		mPolygenColor	
	 * 	@since Ver 1.0
	 */
	private int mPolygenColor ;

	/**
	 * 	内边距
	 * 	int			:		mInnerMargin	
	 * 	@since Ver 1.0
	 */
	private int mInnerMargin ;

	/**
	 * 	是否绘制多边形
	 * 	boolean			:		showPolygen	
	 * 	@since Ver 1.0
	 */
	private boolean showPolygen ;

	/**
	 * 	人体图绘制的矩形范围
	 * 	Rect			:		mRect_Bound	
	 * 	@since Ver 1.0
	 */
	private Rect mRect_Bound ;

	private Paint mPaint ;

	/**
	 * 	人体图
	 * 	Bitmap			:		mImage	
	 * 	@since Ver 1.0
	 */
	private Bitmap mImage ;

	/**
	 *	mImage
	 *	@param   mImage    the mImage to set
	 */
	public void setImage(Bitmap mImage) {
		//TODO
		this.mImage = mImage ;
		requestLayout() ;
	}

	/**
	 * 	Creates a new instance of BodyMayImageView.
	 * 	@param context
	 * 	@param attrs
	 * 	@param defStyle
	 */
	public BodyMap(Context context , AttributeSet attrs , int defStyle) {
		super(context , attrs , defStyle) ;
		mContext = context ;
		TypedArray mTypedArray = context.getTheme().obtainStyledAttributes(attrs ,
				R.styleable.BodyMap , defStyle , 0) ;
		int n = mTypedArray.getIndexCount() ;
		for(int i = 0 ; i < n ; i ++ ) {
			int attrIndex = mTypedArray.getIndex(i) ;
			switch(attrIndex) {
				case R.styleable.BodyMap_image :
					mImage = BitmapFactory.decodeResource(getResources() ,
							mTypedArray.getResourceId(attrIndex , 0)) ;
					break ;
				case R.styleable.BodyMap_showPolygon :
					showPolygen = mTypedArray.getBoolean(attrIndex , true) ;
					break ;
				case R.styleable.BodyMap_PolygonColor :
					// 默认颜色设置为黑色  
					mPolygenColor = mTypedArray.getColor(attrIndex , Color.LTGRAY) ;
					break ;
				case R.styleable.BodyMap_innerMargin :
					mInnerMargin = mTypedArray.getDimensionPixelSize(attrIndex ,
							DEAULT_INNER_MARGIN) ;
					break ;
			}
		}
		mTypedArray.recycle() ;
		mPaint = new Paint() ;
		mPaint.setColor(mPolygenColor) ;
		mPaint.setStyle(Style.FILL) ;
		mRect_Bound = new Rect() ;
		initDatas() ;
	}

	private void initDatas() {
		mMapArea = new HashMap<String , MapArea>() ;
		mFocus = new HashSet<String>() ;
		initMapArea() ;
	}

	/**
	 * 	Creates a new instance of BodyMayImageView.
	 * 	@param context
	 * 	@param attrs
	 */
	public BodyMap(Context context , AttributeSet attrs) {
		this(context , attrs , 0) ;
	}

	/**
	 * 	Creates a new instance of BodyMayImageView.
	 * 	@param context
	 */
	public BodyMap(Context context) {
		this(context , null) ;
	}

	ArrayList<Point> mPoints = new ArrayList<Point>() ;
	{
		mPoints.add(new Point(147 , 1)) ;
		mPoints.add(new Point(141 , 2)) ;
		mPoints.add(new Point(137 , 4)) ;
		mPoints.add(new Point(131 , 7)) ;
		mPoints.add(new Point(123 , 20)) ;
		mPoints.add(new Point(121 , 30)) ;
		mPoints.add(new Point(116 , 44)) ;
		mPoints.add(new Point(123 , 56)) ;
		mPoints.add(new Point(126 , 64)) ;
		mPoints.add(new Point(147 , 77)) ;
		mPoints.add(new Point(169 , 64)) ;
		mPoints.add(new Point(174 , 56)) ;
		mPoints.add(new Point(179 , 44)) ;
		mPoints.add(new Point(174 , 30)) ;
		mPoints.add(new Point(172 , 20)) ;
		mPoints.add(new Point(164 , 7)) ;
		mPoints.add(new Point(158 , 4)) ;
		mPoints.add(new Point(154 , 2)) ;
	}

	/**
	 * 	(non-Javadoc)
	 * 	@see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@ Override
	protected void onDraw(Canvas canvas) {
		try {
			customDraw(canvas) ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		super.onDraw(canvas) ;
	}

	/**
	 * 	customDraw:()
	 *  ──────────────────────────────────
	 * 	@param canvas	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-11下午11:17:34
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void customDraw(Canvas canvas) {
		mPaint.setStyle(Paint.Style.FILL) ;//设置填满  
		Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.body_male_front) ;
//		mRect_Bound.left = mWidth / 2 - mImage.getWidth() / 2 ;
//		mRect_Bound.right = mWidth / 2 + mImage.getWidth() / 2 ;
//		mRect_Bound.top = (mHeight) / 2 - mImage.getHeight() / 2 ;
//		mRect_Bound.bottom = (mHeight) / 2 + mImage.getHeight() / 2 ;
		mPaint.setColor(mPolygenColor) ;
		canvas.drawRect(mRect_Bound , mPaint) ;
		canvas.drawBitmap(bitmap , null , mRect_Bound , mPaint) ;
		//进行触摸区域绘制
//		for(String key : mFocus) {
//			Path path = mMapArea.get(key).getPath() ;
//			canvas.drawPath(path , mPaint) ;
//		}
		Path mPath = new Path() ;
		for(int i = 0 ; i < mPoints.size() ; i ++ ) {
			if(i == 0) {
				mPath.moveTo(mPoints.get(i).x , mPoints.get(i).y) ;
			}
			mPath.lineTo(mPoints.get(i).x , mPoints.get(i).y) ;
			if(i == mPoints.size() - 1) {
				mPath.lineTo(mPoints.get(0).x , mPoints.get(0).y) ;
			}
		}
		mRegion.setPath(mPath , new Region(0 , 0 , mImage.getWidth() , mImage.getHeight())) ;
		mPaint.setARGB(222 , 88 , 88 , 88) ;
		drawRegion(canvas , mRegion , mPaint) ;
	}

	Region mRegion = new Region() ;

	//这个函数不懂没关系，下面会细讲  
	private void drawRegion(Canvas canvas , Region rgn , Paint paint) {
		Log.i("tag" , "drawRegion") ;
		RegionIterator iter = new RegionIterator(rgn) ;
		Rect r = new Rect() ;
		while(iter.next(r)) {
			Log.i("tag" , "Rect" + r.toShortString()) ;
			canvas.drawRect(r , paint) ;
		}
	}

	@ Override
	protected void onMeasure(int widthMeasureSpec , int heightMeasureSpec) {
		int widthMode = MeasureSpec.getMode(widthMeasureSpec) ;
		int widthSize = MeasureSpec.getSize(widthMeasureSpec) ;
		if(widthMode == MeasureSpec.EXACTLY) {
			Log.i(getClass().getName() , "width EXACTLY") ;
			mWidth = widthSize ;
		}
		else {
			//TODO Rect
			if(mImage == null)
				mWidth = (int) (getPaddingLeft() + mInnerMargin * 2 + getPaddingRight()) ;
			else
//				mWidth = (int) (getPaddingLeft() + mImage.getWidth() + mInnerMargin * 2 + getPaddingRight()) ;
				mWidth = mImage.getWidth() ;
		}
		int heightMode = MeasureSpec.getMode(heightMeasureSpec) ;
		int heightSize = MeasureSpec.getSize(heightMeasureSpec) ;
		if(heightMode == MeasureSpec.EXACTLY) {
			Log.i(getClass().getName() , "height EXACTLY") ;
			mHeight = heightSize ;
		}
		else {
			//TODO Rect
			if(mImage == null)
				mHeight = (int) (getPaddingTop() + mInnerMargin * 2 + getPaddingBottom()) ;
			else
//				mHeight = (int) (getPaddingTop() + mImage.getHeight() + mInnerMargin * 2 + getPaddingBottom()) ;
				mHeight = mImage.getHeight() ;
		}
		mRect_Bound.left = 0 ;
		mRect_Bound.right = mWidth ;
		mRect_Bound.top = 0 ;
		mRect_Bound.bottom = mHeight ;
//		mRect_Bound.left = getPaddingLeft() + mInnerMargin ;
//		mRect_Bound.right = mWidth - getPaddingRight() - mInnerMargin ;
//		mRect_Bound.top = getPaddingTop() + mInnerMargin ;
//		mRect_Bound.bottom = mHeight - getPaddingBottom() - mInnerMargin ;
		setMeasuredDimension(mWidth , mHeight) ;
		ScaleDegreeX = mRect_Bound.width() / mWidth ;
		ScaleDegreeY = mRect_Bound.height() / mHeight ;
		initMapArea() ;
	}

	@ Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i("tag" , "onTouchEvent" + event.toString()) ;
		Log.i("tag" , "xy" + event.getX() + event.getY()) ;
//		if(mHandler != null) {
//			checkAreas(event) ;
//			if( ! mFocus.isEmpty()) {
//				MapArea area = null ;
//				for(String key : mFocus) {
//					area = mMapArea.get(key) ;
//					invalidate() ;
//					mHandler.obtainMessage(0 , area.getPtKeys()).sendToTarget() ;
//				}
//			}
//		}
		if(mRegion.contains((int) event.getX() , (int) event.getY())) {
			Log.i("tag" , "yeah" + event.getX() + event.getY()) ;
			Toast.makeText(getContext() , "yeah" , 0).show() ;
		}
		return super.onTouchEvent(event) ;
	}

	private void checkAreas(MotionEvent event) {
		mFocus.clear() ;
		for(String key : mMapArea.keySet()) {
			mPathRectF.setEmpty() ;
			Path path = mMapArea.get(key).getPath() ;
			path.computeBounds(mPathRectF , true) ;
			if(mPathRectF.contains(event.getX() , event.getY())) {
				mFocus.add(key) ;
				break ;
			}
		}
	}

	private float ScaleDegreeX ;

	private float ScaleDegreeY ;

	//进行不同材质机器的兼容
	private float toDip(Context context , float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density ;
		return (int) (pxValue * scale + 0.5f) ;
	}

	public void initMapArea() {
		mMapArea.clear() ;
		mFocus.clear() ;
		String[] keys = mContext.getResources().getStringArray(R.array.map_area) ;
		MapArea bodyArea = null ;
		int idenId = - 1 ;
		if(keys != null) {
			for(String key : keys) {
				idenId = mContext.getResources().getIdentifier(key , "array" ,
						mContext.getPackageName()) ;
				int[] paths = mContext.getResources().getIntArray(idenId) ;
				idenId = mContext.getResources().getIdentifier(key + "_code" , "array" ,
						mContext.getPackageName()) ;
				String[] ptKeys = mContext.getResources().getStringArray(idenId) ;
				bodyArea = new MapArea(ptKeys , paths) ;
				mMapArea.put(key , bodyArea) ;
			}
		}
	}

	private Handler mHandler = new Handler() ;

	public void setHandler(Handler handler) {
		this.mHandler = handler ;
	}

	//区域对象
	class MapArea {

		private String[] mPtKeys ;

		private Path mPath ;

		public MapArea(String[] ptKeys , int[] paths) {
			super() ;
			this.mPtKeys = ptKeys ;
			mPath = new Path() ;
			int len = paths.length ;
			//每两个点做一个坐标
			for(int i = 0 ; i < len ; i = i + 2) {
				if(i == 0) {
					mPath.moveTo(convertLocation(toDip(mContext , paths[i])) ,
							convertLocation(toDip(mContext , paths[i + 1]))) ;
				}
				else {
					mPath.lineTo(convertLocation(toDip(mContext , paths[i])) ,
							convertLocation(toDip(mContext , paths[i + 1]))) ;
				}
			}
			mPath.close() ;
		}

		public String[] getPtKeys() {
			return mPtKeys ;
		}

		public void setPtKeys(String[] ptKeys) {
			this.mPtKeys = ptKeys ;
		}

		public Path getPath() {
			return mPath ;
		}

		protected float convertLocation(float inLocation) {
			return inLocation + mInnerMargin ;
		}
	}
}

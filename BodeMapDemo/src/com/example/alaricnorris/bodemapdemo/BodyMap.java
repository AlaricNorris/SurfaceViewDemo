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
import android.graphics.Region ;
import android.graphics.RegionIterator ;
import android.text.TextUtils ;
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

	public static final int MIN_WIDTH = 320 ;

	public static final int MIN_HEIGHT = 480 ;

	public static final int DEAULT_INNER_MARGIN = 20 ;

	private int mWidth = 0 ;

	private int mHeight = 0 ;

	/**
	 * 	检测区域颜色
	 * 	int			:		mDetectRegionColor	
	 * 	@since Ver 1.0
	 */
	private int mDetectRegionColor ;

	/**
	 * 	是否绘制检测区域
	 * 	boolean			:		showDetectRegion	
	 * 	@since Ver 1.0
	 */
	private boolean showDetectRegion ;

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
	private Bitmap mBitmap ;

	/**
	 *	mImage
	 *	@param   mImage    the mImage to set
	 */
	public void setImage(Bitmap mImage) {
		//TODO
		this.mBitmap = mImage ;
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
		if(isInEditMode()) {
			return ;
		}
		TypedArray mTypedArray = context.getTheme().obtainStyledAttributes(attrs ,
				R.styleable.BodyMap , defStyle , 0) ;
		int n = mTypedArray.getIndexCount() ;
		for(int i = 0 ; i < n ; i ++ ) {
			int attrIndex = mTypedArray.getIndex(i) ;
			switch(attrIndex) {
				case R.styleable.BodyMap_image :
					mBitmap = BitmapFactory.decodeResource(getResources() ,
							mTypedArray.getResourceId(attrIndex , 0)) ;
					break ;
				case R.styleable.BodyMap_showdetectRegion :
					showDetectRegion = mTypedArray.getBoolean(attrIndex , false) ;
					break ;
				case R.styleable.BodyMap_detectRegionColor :
					// 默认颜色设置为黑色  
					mDetectRegionColor = mTypedArray.getColor(attrIndex , Color.LTGRAY) ;
					break ;
				case R.styleable.BodyMap_imagesLayers :
					mImageLayersNames = getResources().getStringArray(
							mTypedArray.getResourceId(attrIndex , 0)) ;
					break ;
				case R.styleable.BodyMap_XCoordinates :
					XCoordinates = getResources().getIntArray(
							mTypedArray.getResourceId(attrIndex , 0)) ;
					break ;
				case R.styleable.BodyMap_YCoordinates :
					YCoordinates = getResources().getIntArray(
							mTypedArray.getResourceId(attrIndex , 0)) ;
					break ;
			}
		}
		mTypedArray.recycle() ;
		Log.i("tag" + getClass().getSimpleName() , "mImageLayersNames:" + mImageLayersNames) ;
		mPaint = new Paint() ;
		mPaint.setColor(mDetectRegionColor) ;
		mPaint.setStyle(Style.FILL) ;
		mRect_Bound = new Rect() ;
		mPoints = new ArrayList<Point>() ;
		if(XCoordinates != null && XCoordinates.length > 0) {
			for(int i = 0 ; i < XCoordinates.length ; i ++ ) {
				mPoints.add(new Point(XCoordinates[i] , YCoordinates[i])) ;
			}
		}
		try {
			if(mImageLayersNames != null && mImageLayersNames.length > 0) {
				for(int i = 0 ; i < mImageLayersNames.length ; i ++ ) {
					mHashMap.put(
							mImageLayersNames[i] ,
							BitmapFactory.decodeResource(
									getResources() ,
									mTypedArray.getResourceId(
											getResources().getIdentifier(mImageLayersNames[i] ,
													"drawable" , mContext.getPackageName()) , 0))) ;
				}
			}
		}
		catch(Exception e) {
			Log.e("tag" , "Exception" + e.toString()) ;
			e.printStackTrace() ;
		}
		Log.i("tag" , "mHashMap" + mHashMap) ;
	}

	private String[] mImageLayersNames ;

	private HashMap<String , Bitmap> mHashMap ;

	private String choosedImageName ;

	private int[] XCoordinates ;

	private int[] YCoordinates ;

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
//		drawBody(canvas) ;
		super.onDraw(canvas) ;
//		if(isInEditMode()) {
//			return ;
//		}
		try {
			drawDetectRegion(canvas) ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		drawChoosedLayer(canvas) ;
	}

	/**
	 * 	drawChoosedLayer:()
	 *  ──────────────────────────────────
	 * 	@param canvas	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	20144L151		 2015-6-13下午4:32:12
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void drawChoosedLayer(Canvas canvas) {
		if(TextUtils.isEmpty(choosedImageName)) {
			return ;
		}
		canvas.drawBitmap(mHashMap.get(choosedImageName) , super.getImageMatrix() , mPaint) ;
	}

	/**
	 * 	drawBody:(画人体图)
	 *  ──────────────────────────────────
	 * 	@param canvas	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	20144L151		 2015-6-13下午2:38:32
	 *	Modifications:	init
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void drawBody(Canvas canvas) {
		mPaint.setStyle(Paint.Style.FILL) ;//设置填满  
		Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.body_male_front) ;
//		mRect_Bound.left = mWidth / 2 - mImage.getWidth() / 2 ;
//		mRect_Bound.right = mWidth / 2 + mImage.getWidth() / 2 ;
//		mRect_Bound.top = (mHeight) / 2 - mImage.getHeight() / 2 ;
//		mRect_Bound.bottom = (mHeight) / 2 + mImage.getHeight() / 2 ;
		mPaint.setColor(mDetectRegionColor) ;
		canvas.drawRect(mRect_Bound , mPaint) ;
		canvas.drawBitmap(bitmap , null , mRect_Bound , mPaint) ;
	}

	/**
	 * 	customDraw:(绘制检测区域)
	 *  ──────────────────────────────────
	 * 	@param canvas	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-11下午11:17:34
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void drawDetectRegion(Canvas canvas) {
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
		mPath.transform(super.getImageMatrix()) ;
		mRegion.setPath(mPath , new Region(0 , 0 , getWidth() , getHeight())) ;
		mPaint.setColor(mDetectRegionColor) ;
		if(showDetectRegion) {
			drawRegion(canvas , mRegion , mPaint) ;
		}
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

//	@ Override
//	protected void onMeasure(int widthMeasureSpec , int heightMeasureSpec) {
//		int widthMode = MeasureSpec.getMode(widthMeasureSpec) ;
//		int widthSize = MeasureSpec.getSize(widthMeasureSpec) ;
//		if(widthMode == MeasureSpec.EXACTLY) {
//			Log.i(getClass().getName() , "width EXACTLY") ;
//			mWidth = widthSize ;
//		}
//		else {
//			//TODO Rect
//			if(mImage == null)
//				mWidth = (int) (getPaddingLeft() + mInnerMargin * 2 + getPaddingRight()) ;
//			else
////				mWidth = (int) (getPaddingLeft() + mImage.getWidth() + mInnerMargin * 2 + getPaddingRight()) ;
//				mWidth = mImage.getWidth() ;
//		}
//		int heightMode = MeasureSpec.getMode(heightMeasureSpec) ;
//		int heightSize = MeasureSpec.getSize(heightMeasureSpec) ;
//		if(heightMode == MeasureSpec.EXACTLY) {
//			Log.i(getClass().getName() , "height EXACTLY") ;
//			mHeight = heightSize ;
//		}
//		else {
//			//TODO Rect
//			if(mImage == null)
//				mHeight = (int) (getPaddingTop() + mInnerMargin * 2 + getPaddingBottom()) ;
//			else
////				mHeight = (int) (getPaddingTop() + mImage.getHeight() + mInnerMargin * 2 + getPaddingBottom()) ;
//				mHeight = mImage.getHeight() ;
//		}
//		mRect_Bound.left = 0 ;
//		mRect_Bound.right = mWidth ;
//		mRect_Bound.top = 0 ;
//		mRect_Bound.bottom = mHeight ;
////		mRect_Bound.left = getPaddingLeft() + mInnerMargin ;
////		mRect_Bound.right = mWidth - getPaddingRight() - mInnerMargin ;
////		mRect_Bound.top = getPaddingTop() + mInnerMargin ;
////		mRect_Bound.bottom = mHeight - getPaddingBottom() - mInnerMargin ;
//		setMeasuredDimension(mWidth , mHeight) ;
//		ScaleDegreeX = mRect_Bound.width() / mWidth ;
//		ScaleDegreeY = mRect_Bound.height() / mHeight ;
//	}
	@ Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO 根据事件来响应不同feedback
		Log.i("tag" , "onTouchEvent" + event.toString()) ;
		Log.i("tag" , "xy" + event.getX() + event.getY()) ;
		if(mRegion.contains((int) event.getX() , (int) event.getY())) {
			Log.i("tag" , "yeah!!!!!!!!") ;
			choosedImageName = mImageLayersNames[0] ;
		}
		else {
			choosedImageName = null ;
		}
		invalidate() ;
		return true ;
	}

	private float ScaleDegreeX ;

	private float ScaleDegreeY ;

	//进行不同材质机器的兼容
	private float toDip(Context context , float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density ;
		return (int) (pxValue * scale + 0.5f) ;
	}
}

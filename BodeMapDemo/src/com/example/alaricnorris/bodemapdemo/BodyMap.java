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

import android.content.Context ;
import android.content.res.TypedArray ;
import android.graphics.Bitmap ;
import android.graphics.BitmapFactory ;
import android.graphics.Canvas ;
import android.graphics.Color ;
import android.graphics.Paint ;
import android.graphics.Rect ;
import android.util.AttributeSet ;
import android.util.Log ;
import android.util.TypedValue ;
import android.view.View ;

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
public class BodyMap extends View {

	public static final int MIN_WIDTH = 320 ;

	public static final int MIN_HEIGHT = 480 ;

	/** 
	* 文本的颜色 
	*/
	private int mPolygenColor ;

	/** 
	 * 文本的大小 
	 */
	private int mInnerMargin ;

	private boolean showPolygen ;

	/** 
	 * 绘制时控制文本绘制的范围 
	 */
	private Rect mRect_Bound ;

	private Paint mPaint ;

	private Bitmap mImage ;

	public static final int DEAULT_INNER_MARGIN = 20 ;

	/**
	 * 	Creates a new instance of BodyMayImageView.
	 * 	@param context
	 * 	@param attrs
	 * 	@param defStyle
	 */
	public BodyMap(Context context , AttributeSet attrs , int defStyle) {
		super(context , attrs , defStyle) ;
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
		mRect_Bound = new Rect() ;
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

	/**
	 * 	(non-Javadoc)
	 * 	@see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@ Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas) ;
		mPaint.setStyle(Paint.Style.FILL) ;//设置填满  
		canvas.drawCircle(mRect_Bound.left , mRect_Bound.top , 60 , mPaint) ;
		Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.body_male_front) ;
		canvas.drawBitmap(bitmap , null , mRect_Bound , mPaint) ;
	}

	private int mWidth = 0 ;

	private int mHeight = 0 ;

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
				mWidth = (int) (getPaddingLeft() + mImage.getWidth() + mInnerMargin * 2 + getPaddingRight()) ;
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
				mHeight = (int) (getPaddingTop() + mImage.getHeight() + mInnerMargin * 2 + getPaddingBottom()) ;
		}
		mRect_Bound.left = getPaddingLeft() + mInnerMargin ;
		mRect_Bound.right = mWidth - getPaddingRight() - mInnerMargin ;
		mRect_Bound.top = getPaddingTop() + mInnerMargin ;
		mRect_Bound.bottom = mHeight - getPaddingBottom() - mInnerMargin ;
		setMeasuredDimension(mWidth , mHeight) ;
	}
}

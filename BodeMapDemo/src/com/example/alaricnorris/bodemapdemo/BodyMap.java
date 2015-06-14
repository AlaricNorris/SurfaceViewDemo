/**
 * 	BodyMayImageView.java
 * 	com.example.alaricnorris.bodemapdemo
 * 	Function： 	人体视图组件 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-9 		20144L151
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodemapdemo ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.Map ;
import java.util.Map.Entry ;
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
import android.os.Handler ;
import android.text.TextUtils ;
import android.util.AttributeSet ;
import android.util.Log ;
import android.view.MotionEvent ;
import android.widget.ImageView ;
import android.widget.Toast ;

/**
 *	ClassName:	BodyMayImageView
 *	Function: 	人体视图
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

	private String mPreferenceJsonString ;

	/**
	 * 	人体图绘制的矩形范围
	 * 	Rect			:		mRect_Bound	
	 * 	@since Ver 1.0
	 */
	private Rect mRect_Bound ;

	/**
	 * 	画笔
	 * 	Paint			:		mPaint	
	 * 	@since Ver 1.0
	 */
	private Paint mPaint ;

	/**
	 * 	人体图
	 * 	Bitmap			:		mImage	
	 * 	@since Ver 1.0
	 */
	@ Deprecated
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
		TypedArray mTypedArray = mContext.obtainStyledAttributes(attrs , R.styleable.BodyMap) ;
		/*int n = mTypedArray.getIndexCount() ;
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
		}*/
		Log.i("tag" , "mImageLayersNames:" + mImageLayersNames) ;
		Log.i("tag" , "---------------------------") ;
		try {
			{
				mBitmap = BitmapFactory.decodeResource(getResources() ,
						mTypedArray.getResourceId(R.styleable.BodyMap_image , 0)) ;
				showDetectRegion = mTypedArray.getBoolean(R.styleable.BodyMap_showdetectRegion ,
						false) ;
				mDetectRegionColor = mTypedArray.getColor(R.styleable.BodyMap_detectRegionColor ,
						Color.LTGRAY) ;
				mImageLayersNames = getResources().getStringArray(
						mTypedArray.getResourceId(R.styleable.BodyMap_imagesLayers , 0)) ;
				XCoordinates = getResources().getIntArray(
						mTypedArray.getResourceId(R.styleable.BodyMap_XCoordinates , 0)) ;
				YCoordinates = getResources().getIntArray(
						mTypedArray.getResourceId(R.styleable.BodyMap_YCoordinates , 0)) ;
				if(mBitmap != null) {
					super.setImageBitmap(mBitmap) ;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		mTypedArray.recycle() ;
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
		for(int i = 0 ; i < mPoints.size() ; i ++ ) {
			if(i == 0) {
				mPath.moveTo(mPoints.get(i).x , mPoints.get(i).y) ;
				continue ;
			}
			mPath.lineTo(mPoints.get(i).x , mPoints.get(i).y) ;
			if(i == mPoints.size() - 1) {
				mPath.lineTo(mPoints.get(0).x , mPoints.get(0).y) ;
			}
		}
		try {
			if(mImageLayersNames != null && mImageLayersNames.length > 0) {
				for(int i = 0 ; i < mImageLayersNames.length ; i ++ ) {
					mHashMap.put(mImageLayersNames[i] , BitmapFactory.decodeResource(
							getResources() ,
							getResources().getIdentifier(mImageLayersNames[i] , "drawable" ,
									mContext.getPackageName()))) ;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		Log.i("tag" , "mHashMap" + mHashMap) ;
		Entry<String , Bitmap> mObject = mHashMap.entrySet().iterator().next() ;
	}

	private String[] mImageLayersNames ;

	private HashMap<String , Bitmap> mHashMap = new HashMap<String , Bitmap>() ;

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

	HashMap<String , ArrayList<Point>> mHashmap_RegionPoints ;

	ArrayList<Point> mPoints = new ArrayList<Point>() ;

	HashMap<String , Region> mHashmap_Regions ;

	Region mRegion = new Region() ;

	private boolean isInModifying ;

	/**
	 * 	(non-Javadoc)
	 * 	@see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@ Override
	protected void onDraw(Canvas canvas) {
//		drawBody(canvas) ;
		super.onDraw(canvas) ;
		if(isInModifying) {
			return ;
		}
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

	Path mPath = new Path() ;

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
		if(mPoints == null) {
			return ;
		}
		mPath.transform(super.getImageMatrix()) ;
		mRegion.setPath(mPath , new Region(0 , 0 , getWidth() , getHeight())) ;
		mPaint.setColor(mDetectRegionColor) ;
		if(true) {
			Log.i("tag" , "drawDetectRegion" + mRegions) ;
			if(mRegions != null) {
				for(int i = 0 ; i < mRegions.size() ; i ++ ) {
					drawRegion(canvas , mRegions.get(i) , mPaint) ;
				}
			}
			drawRegion(canvas , mRegion , mPaint) ;
		}
	}

	/**
	 * 	drawRegion:()
	 *  ──────────────────────────────────
	 * 	@param canvas
	 * 	@param rgn
	 * 	@param paint	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-13下午8:36:13
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void drawRegion(Canvas canvas , Region rgn , Paint paint) {
		Log.i("tag" , "drawRegion" + rgn) ;
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
		switch(event.getAction()) {
			case MotionEvent.ACTION_DOWN :
			case MotionEvent.ACTION_MOVE :
				if(mRegion.contains((int) event.getX() , (int) event.getY())) {
					choosedImageName = mImageLayersNames[0] ;
				}
				else {
					choosedImageName = null ;
				}
				invalidate() ;
				break ;
			case MotionEvent.ACTION_UP :
				if(mRegion.contains((int) event.getX() , (int) event.getY())) {
					// TODO
					Log.i("tag" , "Bingo") ;
					if(mHandler != null) {
						mHandler.sendEmptyMessage(1) ;
					}
					Toast.makeText(getContext() , "Bingo" , 0).show() ;
				}
				choosedImageName = null ;
				invalidate() ;
				break ;
			default :
				break ;
		}
		return true ;
	}

	private Handler mHandler ;

	/**
	 * 	(non-Javadoc)
	 * 	@see android.widget.ImageView#onDetachedFromWindow()
	 */
	@ Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow() ;
		isInModifying = true ;
		try {
			if(mHashMap != null) {
				Iterator<Entry<String , Bitmap>> mIterator = mHashMap.entrySet().iterator() ;
				while(mIterator.hasNext()) {
					Map.Entry<java.lang.String , android.graphics.Bitmap> entry = (Map.Entry<java.lang.String , android.graphics.Bitmap>) mIterator
							.next() ;
					entry.getValue().recycle() ;
					Log.i("tag" , "recycle") ;
				}
			}
			mHashMap = null ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		Log.i("tag" , "onDetachedFromWindow") ;
		isInModifying = false ;
		System.gc() ;
	}

	/*private float ScaleDegreeX ;

	private float ScaleDegreeY ;

	//进行不同材质机器的兼容
	private float toDip(Context context , float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density ;
		return (int) (pxValue * scale + 0.5f) ;
	}*/
	/** 
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
	 */
	public static int dip2px(Context context , float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density ;
		return (int) (dpValue * scale + 0.5f) ;
	}

	/** 
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
	 */
	public static int px2dip(Context context , float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density ;
		return (int) (pxValue / scale + 0.5f) ;
	}

	/**
	 * 	mImageLayersNames
	 * 	@return  	the mImageLayersNames
	 */
	public String[] getmImageLayersNames() {
		return mImageLayersNames ;
	}

	/**
	 *	mImageLayersNames
	 *	@param   mImageLayersNames    the mImageLayersNames to set
	 */
	public void setmImageLayersNames(String[] mImageLayersNames) {
		mContext.getResources().getString(R.id.a) ;
		this.mImageLayersNames = mImageLayersNames ;
	}

	private BodyParams mBodyParams ;

	/**
	 * 	mBodyParams
	 * 	@return  	the mBodyParams
	 */
	public BodyParams getBodyParams() {
		return mBodyParams ;
	}

	private ArrayList<Region> mRegions = new ArrayList<Region>() ;

	/**
	 *	mBodyParams
	 *	@param   mBodyParams    the mBodyParams to set
	 */
	public void setBodyParams(BodyParams mBodyParams) {
		if( ! isParamsValid(mBodyParams)) {
			Toast.makeText(getContext() , "Invalid" , 0).show() ;
			return ;
		}
		this.mBodyParams = mBodyParams ;
		parseBodyParams(this.mBodyParams) ;
	}

	/**
	 * 	parseBodyParams:()
	 *  ──────────────────────────────────
	 * 	@param inBodyParams	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-14下午11:05:39
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void parseBodyParams(BodyParams inBodyParams) {
		int size = inBodyParams.getLayerNames().size() ;
		mImageLayersNames = new String[size] ;
		for(int i = 0 ; i < inBodyParams.getLayerNames().size() ; i ++ ) {
			mImageLayersNames[i] = inBodyParams.getLayerNames().get(i) ;
		}
		Iterator<Entry<String , ArrayList<Point>>> regionsIterator = inBodyParams.getRegions()
				.entrySet().iterator() ;
		mRegions = new ArrayList<Region>() ;
		int index = 0 ;
		while(regionsIterator.hasNext()) {
			Entry<String , ArrayList<Point>> entry = (Entry<String , ArrayList<Point>>) regionsIterator
					.next() ;
			ArrayList<Point> mArrayList = entry.getValue() ;
			if(mArrayList == null) {
				continue ;
			}
			else {
				Path tempPath = new Path() ;
				for(int i = 0 ; i < mArrayList.size() ; i ++ ) {
					Log.i("tag" , "iter" + mArrayList.get(i).x) ;
					if(i == 0) {
						tempPath.moveTo(px2dip(mContext , mArrayList.get(i).x) ,
								px2dip(mContext , mArrayList.get(i).y)) ;
					}
					tempPath.lineTo(px2dip(mContext , mArrayList.get(i).x) ,
							px2dip(mContext , mArrayList.get(i).y)) ;
					if(i == mArrayList.size() - 1) {
						tempPath.lineTo(px2dip(mContext , mArrayList.get(0).x) ,
								px2dip(mContext , mArrayList.get(0).y)) ;
					}
				}
				tempPath.transform(super.getImageMatrix()) ;
				Log.i("tag" , "tempPath" + tempPath.isEmpty()) ;
				Region tempRegion = new Region() ;
				tempRegion.setPath(tempPath , new Region(0 , 0 , getWidth() , getHeight())) ;
				mRegions.add(tempRegion) ;
			}
			index ++ ;
		}
		Log.i("tag" , "mRegions" + mRegions) ;
	}

	/**
	 * 	isParamsValid:()
	 *  ──────────────────────────────────
	 * 	@return	
	 *	@version	Ver 1.0	
	 * 	@param 		inBodyParams 
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-14下午11:00:52
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private boolean isParamsValid(BodyParams inBodyParams) {
		if(inBodyParams == null) {
			return false ;
		}
		if(inBodyParams.getLayerNames() == null || inBodyParams.getRegions() == null) {
			return false ;
		}
		if(inBodyParams.getLayerNames().size() != inBodyParams.getRegions().size()) {
			return false ;
		}
		// 迭代图层名称  判空
		Iterator<String> layerNamesIterator = inBodyParams.getLayerNames().iterator() ;
		while(layerNamesIterator.hasNext()) {
			String tempString = (String) layerNamesIterator.next() ;
			if(TextUtils.isEmpty(tempString))
				return false ;
		}
		//　迭代检测区域　判Key 
		Iterator<Entry<String , ArrayList<Point>>> regionsIterator = inBodyParams.getRegions()
				.entrySet().iterator() ;
		int index = 0 ;
		while(regionsIterator.hasNext()) {
			Entry<String , ArrayList<Point>> entry = (Entry<String , ArrayList<Point>>) regionsIterator
					.next() ;
			if(TextUtils.isEmpty(entry.getKey()) || entry.getKey().length() == 0) {
				return false ;
			}
			if( ! entry.getKey().equals(inBodyParams.getLayerNames().get(index))) {
				return false ;
			}
			index ++ ;
		}
		return true ;
	}
}

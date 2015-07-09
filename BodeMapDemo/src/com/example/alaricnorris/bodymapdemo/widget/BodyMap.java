/**
 * 	BodyMayImageView.java
 * 	com.example.alaricnorris.bodemapdemo
 * 	Function： 	人体视图组件 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-9 		20144L151
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodymapdemo.widget ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.LinkedHashMap ;
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
import android.os.Message ;
import android.text.TextUtils ;
import android.util.AttributeSet ;
import android.util.DisplayMetrics ;
import android.util.Log ;
import android.view.MotionEvent ;
import android.view.WindowManager ;
import android.widget.ImageView ;
import android.widget.Toast ;
import com.example.alaricnorris.bodymapdemo.BuildConfig ;
import com.example.alaricnorris.bodymapdemo.R ;
import com.google.gson.Gson ;

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
 *	Modifications:	init
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class BodyMap extends ImageView {

	private Context mContext ;

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

	private String DefaultBodyParams ;

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
		if(mImage != null) {
			this.mBitmap = mImage ;
			super.setImageBitmap(mBitmap) ;
		}
		requestLayout() ;
	}

	/**
	 * 	图片名集合
	 * 	String[]			:		mImageLayersNames	
	 * 	@since Ver 1.0
	 */
	private String[] mImageLayersNames ;

	/**
	 * 	以图片名为Key 对应的Bitmap为Value
	 * 	HashMap<String,Bitmap>			:		mHashMap_BodyPart_Images	
	 * 	@since Ver 1.0
	 */
	private HashMap<String , Bitmap> mHashMap_BodyPart_Images = new HashMap<String , Bitmap>() ;

	/**
	 * 	{@link BodyParams#getMessageBundles()}
	 * 	HashMap<String,Integer>			:		mHashMap_MessageBundles	
	 * 	@since Ver 1.0
	 */
	private HashMap<String , Integer> mHashMap_MessageBundles = new HashMap<String , Integer>() ;

	/**
	 * 	碰撞检测到已选择的身体部位对应的图片名称
	 * 	String			:		choosedImageName	
	 * 	@since Ver 1.0
	 */
	private String choosedImageName ;

	/**
	 * 	Creates a new instance of BodyMayImageView.
	 * 	@param context
	 * 	@param attrs
	 * 	@param defStyle
	 */
	public BodyMap(Context context , AttributeSet attrs , int defStyle) {
		super(context , attrs , defStyle) ;
		mContext = context ;
		WindowManager mWindowManager = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE) ;
		DisplayMetrics outMetrics = new DisplayMetrics() ;
		mWindowManager.getDefaultDisplay().getMetrics(outMetrics) ;
		mRegion_WholeCanvas = new Region(0 , 0 , outMetrics.widthPixels , outMetrics.heightPixels) ;
		if(isInEditMode()) {
			return ;
		}
		TypedArray mTypedArray = mContext.obtainStyledAttributes(attrs , R.styleable.BodyMap) ;
		Log.i("tag" , "mImageLayersNames:" + mImageLayersNames) ;
		Log.i("tag" , "---------------------------") ;
		try {
			{
				showDetectRegion = mTypedArray.getBoolean(R.styleable.BodyMap_showdetectRegion ,
						false) ;
				mDetectRegionColor = mTypedArray.getColor(R.styleable.BodyMap_detectRegionColor ,
						Color.LTGRAY) ;
				mImageLayersNames = getResources().getStringArray(
						mTypedArray.getResourceId(R.styleable.BodyMap_imagesLayers , 0)) ;
				mBitmap = BitmapFactory.decodeResource(getResources() ,
						mTypedArray.getResourceId(R.styleable.BodyMap_image , 0)) ;
				if(mBitmap != null) {
					super.setImageBitmap(mBitmap) ;
				}
				DefaultBodyParams = mTypedArray.getString(R.styleable.BodyMap_bodyParam) ;
				setBodyParams(new Gson().fromJson(DefaultBodyParams , BodyParams.class)) ;
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		mTypedArray.recycle() ;
		mPaint = new Paint() ;
		mPaint.setColor(mDetectRegionColor) ;
		mPaint.setStyle(Style.FILL) ;
		try {
			if(mImageLayersNames != null && mImageLayersNames.length > 0) {
				for(int i = 0 ; i < mImageLayersNames.length ; i ++ ) {
					mHashMap_BodyPart_Images.put(mImageLayersNames[i] , BitmapFactory
							.decodeResource(
									getResources() ,
									getResources().getIdentifier(mImageLayersNames[i] , "drawable" ,
											mContext.getPackageName()))) ;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
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
	 * 	@see android.widget.ImageView#onDetachedFromWindow()
	 */
	@ Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow() ;
		isModifying = true ;
		try {
			if(mHashMap_BodyPart_Images != null) {
				Iterator<Entry<String , Bitmap>> mIterator = mHashMap_BodyPart_Images.entrySet()
						.iterator() ;
				while(mIterator.hasNext()) {
					Entry<String , Bitmap> entry = (Entry<String , Bitmap>) mIterator.next() ;
					entry.getValue().recycle() ;
				}
			}
			mHashMap_BodyPart_Images = null ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		isModifying = false ;
		System.gc() ;
	}

	/**
	 * 	(non-Javadoc)
	 * 	@see android.view.View#onLayout(boolean, int, int, int, int)
	 */
	@ Override
	protected void onLayout(boolean changed , int left , int top , int right , int bottom) {
		super.onLayout(changed , left , top , right , bottom) ;
		if(changed) {
			super.setFrame(left , top , right , bottom) ;
		}
	}

	/**
	 * 	(non-Javadoc)
	 * 	@see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@ Override
	protected void onDraw(Canvas canvas) {
		if(isModifying) {
			return ;
		}
		if(isInEditMode()) {
			return ;
		}
		super.onDraw(canvas) ;
		try {
			drawDetectRegion(canvas) ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		drawChoosedLayer(canvas) ;
	}

	private boolean isModifying ;

	/**
	 * 	drawChoosedLayer:()
	 *  ──────────────────────────────────
	 * 	@param canvas	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	20144L151		 2015-6-13下午4:32:12
	 *	Modifications:	init
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void drawChoosedLayer(Canvas canvas) {
		if(TextUtils.isEmpty(choosedImageName)) {
			return ;
		}
		canvas.drawBitmap(mHashMap_BodyPart_Images.get(choosedImageName) , super.getImageMatrix() ,
				mPaint) ;
	}

	private boolean hasTransformed ;

	Region mRegion_WholeCanvas ;

	/**
	 * 	customDraw:(绘制检测区域)
	 *  ──────────────────────────────────
	 * 	@param 		canvas	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-11下午11:17:34
	 *	Modifications:	init
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void drawDetectRegion(Canvas canvas) {
		if( ! hasTransformed) {
			if(mPaths != null) {
				for(Path tempPath : mPaths) {
					tempPath.transform(super.getImageMatrix()) ;
				}
			}
			hasTransformed = true ;
		}
		mPaint.setColor(mDetectRegionColor) ;
		if(showDetectRegion) {
			if(mHashMap_Regions != null && mHashMap_Regions.entrySet() != null) {
				Iterator<Entry<String , Region>> mIterator = mHashMap_Regions.entrySet().iterator() ;
				int index = 0 ;
				while(mIterator.hasNext()) {
					Entry<String , Region> entry = (Entry<String , Region>) mIterator.next() ;
					entry.getValue().setPath(mPaths.get(index) , mRegion_WholeCanvas) ;
					mPaint.setColor(mDetectRegionColor + (0xFF006666 * index)) ;
					drawRegion(canvas , entry.getValue() , mPaint) ;
					index ++ ;
				}
			}
//			if(mPaths != null) {
//				for(int i = 0 ; i < mPaths.size() ; i ++ ) {
//					Region tempRegion = new Region() ;
//					tempRegion.setPath(mPaths.get(i) , mRegion_WholeCanvas) ;
//					mRegions.add(tempRegion) ;
//					drawRegion(canvas , tempRegion , mPaint) ;
//				}
//			}
		}
	}

	/**
	 * 	drawRegion:()
	 *  ──────────────────────────────────
	 * 	@param inCanvas
	 * 	@param inRegion
	 * 	@param inPaint	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-13下午8:36:13
	 *	Modifications:	init
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void drawRegion(Canvas inCanvas , Region inRegion , Paint inPaint) {
		RegionIterator mRegionIterator = new RegionIterator(inRegion) ;
		Rect mRect = new Rect() ;
		while(mRegionIterator.next(mRect)) {
			inCanvas.drawRect(mRect , inPaint) ;
		}
	}

	@ Override
	public boolean onTouchEvent(MotionEvent event) {
		switch(event.getAction()) {
		// down事件和move事件一致
			case MotionEvent.ACTION_DOWN :
			case MotionEvent.ACTION_MOVE :
				if(mHashMap_Regions != null && mHashMap_Regions.entrySet() != null) {
					Iterator<Entry<String , Region>> mIterator = mHashMap_Regions.entrySet()
							.iterator() ;
					while(mIterator.hasNext()) {
						Entry<String , Region> entry = (Entry<String , Region>) mIterator.next() ;
						if(entry.getValue().contains((int) event.getX() , (int) event.getY())) {
							choosedImageName = entry.getKey() ;
							if(BuildConfig.DEBUG) {
								Log.i("tag" + "Detect" , "In" + choosedImageName) ;
							}
							break ;
						}
						else {
							choosedImageName = null ;
						}
					}
				}
				break ;
			case MotionEvent.ACTION_UP :
				//up事件对已选区域做判断，触发选择事件
				if(mHashMap_Regions != null && mHashMap_Regions.entrySet() != null) {
					Iterator<Entry<String , Region>> mIterator = mHashMap_Regions.entrySet()
							.iterator() ;
					while(mIterator.hasNext()) {
						Entry<String , Region> entry = (Entry<String , Region>) mIterator.next() ;
						if(entry.getValue().contains((int) event.getX() , (int) event.getY())) {
							if(BuildConfig.DEBUG) {
								Log.i("tag" , entry.getKey() + "Yeah!!!") ;
							}
							if(mHandler != null) {
								Message message = new Message() ;
								message.what = mHashMap_MessageBundles.get(choosedImageName) ;
								mHandler.sendMessage(message) ;
							}
							break ;
						}
					}
				}
				choosedImageName = null ;
				break ;
			default :
				break ;
		}
		invalidate() ;
		return true ;
	}

	private Handler mHandler ;

	/**
	 * 	mHandler
	 * 	@return  	the mHandler
	 */
	public Handler getHandler() {
		return mHandler ;
	}

	/**
	 *	mHandler
	 *	@param   mHandler    the mHandler to set
	 */
	public void setHandler(Handler mHandler) {
		this.mHandler = mHandler ;
	}

	/**
	 * 	当前使用的为1280*720 即xhdpi 即density=2
	 * 	float			:		scale	
	 * 	@since Ver 1.0
	 */
	public static final float currentDensity = 2 ;

	public static int computeToDP(float pxValue) {
		return (int) (pxValue / currentDensity + 0.5f) ;
	}

	public static int computeToPX(float dpValue) {
		return (int) (dpValue * currentDensity + 0.5f) ;
	}

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

	private LinkedHashMap<String , Region> mHashMap_Regions = new LinkedHashMap<String , Region>() ;

	private ArrayList<Path> mPaths = new ArrayList<Path>() ;

	/**
	 *	mBodyParams
	 *	@param   inBodyParams    the mBodyParams to set
	 */
	public void setBodyParams(BodyParams inBodyParams) {
		if( ! checkBodyParamsValid(inBodyParams)) {
			Toast.makeText(getContext() , "InvalidParams" , 0).show() ;
			return ;
		}
		this.mBodyParams = inBodyParams ;
		parseBodyParams(this.mBodyParams) ;
		invalidate() ;
	}

	/**
	 * 	parseBodyParams:()
	 *  ──────────────────────────────────
	 * 	@param inBodyParams	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-14下午11:05:39
	 *	Modifications:	init
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void parseBodyParams(BodyParams inBodyParams) {
		if(inBodyParams == null) {
			return ;
		}
		int size = inBodyParams.getLayerNames().size() ;
		mImageLayersNames = new String[size] ;
		for(int i = 0 ; i < inBodyParams.getLayerNames().size() ; i ++ ) {
			mImageLayersNames[i] = inBodyParams.getLayerNames().get(i) ;
		}
		isModifying = true ;
		try {
			if(mHashMap_BodyPart_Images != null) {
				Iterator<Entry<String , Bitmap>> mIterator = mHashMap_BodyPart_Images.entrySet()
						.iterator() ;
				while(mIterator.hasNext()) {
					Entry<String , Bitmap> entry = (Entry<String , Bitmap>) mIterator.next() ;
					entry.getValue().recycle() ;
				}
			}
			mHashMap_BodyPart_Images = null ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		try {
			if( ! TextUtils.isEmpty(inBodyParams.getImageName())) {
				if(mBitmap != null) {
					mBitmap.recycle() ;
				}
				mBitmap = BitmapFactory.decodeResource(
						getResources() ,
						getResources().getIdentifier(inBodyParams.getImageName() , "drawable" ,
								mContext.getPackageName())) ;
				setImage(mBitmap) ;
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		try {
			if(mImageLayersNames != null && mImageLayersNames.length > 0) {
				mHashMap_BodyPart_Images = new HashMap<String , Bitmap>() ;
				for(int i = 0 ; i < mImageLayersNames.length ; i ++ ) {
					mHashMap_BodyPart_Images.put(mImageLayersNames[i] , BitmapFactory
							.decodeResource(
									getResources() ,
									getResources().getIdentifier(mImageLayersNames[i] , "drawable" ,
											mContext.getPackageName()))) ;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		isModifying = false ;
		Iterator<Entry<String , ArrayList<Point>>> regionsIterator = inBodyParams.getRegions()
				.entrySet().iterator() ;
		mPaths = new ArrayList<Path>() ;
		mHashMap_Regions = new LinkedHashMap<String , Region>() ;
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
					// 解决屏幕适配问题
					if(i == 0) {
						tempPath.moveTo(dip2px(getContext() , computeToDP(mArrayList.get(i).x)) ,
								dip2px(getContext() , computeToDP(mArrayList.get(i).y))) ;
					}
					tempPath.lineTo(dip2px(getContext() , computeToDP(mArrayList.get(i).x)) ,
							dip2px(getContext() , computeToDP(mArrayList.get(i).y))) ;
					if(i == mArrayList.size() - 1) {
						tempPath.lineTo(dip2px(getContext() , computeToDP(mArrayList.get(0).x)) ,
								dip2px(getContext() , computeToDP(mArrayList.get(0).y))) ;
					}
//					if(i == 0) {
//						tempPath.moveTo(mArrayList.get(i).x , mArrayList.get(i).y) ;
//					}
//					tempPath.lineTo(mArrayList.get(i).x , mArrayList.get(i).y) ;
//					if(i == mArrayList.size() - 1) {
//						tempPath.lineTo(mArrayList.get(0).x , mArrayList.get(0).y) ;
//					}
				}
				tempPath.transform(super.getImageMatrix()) ;
				hasTransformed = true ;
				mPaths.add(tempPath) ;
				Region tempRegion = new Region() ;
				tempRegion.setPath(tempPath , mRegion_WholeCanvas) ;
//				mRegions.add(tempRegion) ;
				mHashMap_Regions.put(entry.getKey() , tempRegion) ;
			}
		}
		// 添加Handler所需Message参数的HashMap
		if(inBodyParams.getMessageBundles() == null || inBodyParams.getMessageBundles().size() == 0) {
			return ;
		}
		mHashMap_MessageBundles = inBodyParams.getMessageBundles() ;
	}

	/**
	 * 	checkBodyParamsValid:()
	 *  ──────────────────────────────────
	 * 	@return	
	 *	@version	Ver 1.0	
	 * 	@param 		inBodyParams 
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-14下午11:00:52
	 *	Modifications:	init
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private boolean checkBodyParamsValid(BodyParams inBodyParams) {
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
			if(TextUtils.isEmpty(entry.getKey()) || entry.getKey().length() == 0)
				return false ;
			if( ! entry.getKey().equals(inBodyParams.getLayerNames().get(index)))
				return false ;
			index ++ ;
		}
		return true ;
	}

	/**
	 * 	showDetectRegion
	 * 	@return  	the showDetectRegion
	 */
	public boolean isShowDetectRegion() {
		return showDetectRegion ;
	}

	/**
	 *	showDetectRegion
	 *	@param   showDetectRegion    the showDetectRegion to set
	 */
	public void setShowDetectRegion(boolean showDetectRegion) {
		this.showDetectRegion = showDetectRegion ;
		invalidate() ;
	}
}

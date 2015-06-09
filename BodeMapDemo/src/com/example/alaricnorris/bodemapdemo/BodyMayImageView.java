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
import android.util.AttributeSet ;
import android.widget.ImageView ;

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
public class BodyMayImageView extends ImageView {

	/**
	 * 	Creates a new instance of BodyMayImageView.
	 * 	@param context
	 * 	@param attrs
	 * 	@param defStyle
	 */
	public BodyMayImageView(Context context , AttributeSet attrs , int defStyle) {
		super(context , attrs , defStyle) ;
	}

	/**
	 * 	Creates a new instance of BodyMayImageView.
	 * 	@param context
	 * 	@param attrs
	 */
	private BodyMayImageView(Context context , AttributeSet attrs) {
		this(context , attrs , 0) ;
	}

	/**
	 * 	Creates a new instance of BodyMayImageView.
	 * 	@param context
	 */
	private BodyMayImageView(Context context) {
		this(context , null) ;
	}
}

/**
 * 	Constants.java
 * 	com.example.alaricnorris.bodemapdemo.widget
 * 	Function： 	TODO 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-15 		20144L151
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodemapdemo.widget ;

import java.util.ArrayList ;
import java.util.LinkedHashMap ;
import android.graphics.Point ;
import android.util.Log ;
import com.google.gson.Gson ;

/**
 *	ClassName:	Constants
 *	Function: 	TODO ADD FUNCTION
 *	Reason:	 	TODO ADD REASON
 *	@author   	20144L151		
 *	@contact  	Norris.sly@gmail.com
 *	@version  	Ver 1.0
 *	@since   	I used to be a programmer like you, then I took an arrow in the knee 
 *	@Date	 	2015		2015-6-15		上午10:36:48
 *	@see 	 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Fields 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Methods	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 * 	Modified By 	20144L151		 2015-6-15上午10:36:48
 *	Modifications:	TODO
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class Constants {

	// {"layerNames":["female_front_1head","female_front_2neck","female_front_3breast","female_front_4arms","female_front_5belly","female_front_6pussy","female_front_7legs"],"regions":{"female_front_1head":[{"x":135,"y":0},{"x":240,"y":0},{"x":232,"y":125},{"x":142,"y":125}],"female_front_2neck":[{"x":171,"y":120},{"x":165,"y":147},{"x":140,"y":158},{"x":188,"y":168},{"x":239,"y":161},{"x":210,"y":147},{"x":200,"y":123}],"female_front_3breast":[{"x":133,"y":153},{"x":246,"y":153},{"x":240,"y":229},{"x":132,"y":231}],"female_front_4arms":[],"female_front_5belly":[{"x":139,"y":255},{"x":232,"y":255},{"x":245,"y":337},{"x":120,"y":337}],"female_front_6pussy":[{"x":120,"y":337},{"x":245,"y":337},{"x":174,"y":399}],"female_front_7legs":[]}}
	public static BodyParams mBodyParams_Female_Front ;
	static {
		ArrayList<String> layerNames = new ArrayList<String>() ;
		layerNames.add("body_part_female_front_1head") ;
		layerNames.add("body_part_female_front_2neck") ;
		layerNames.add("body_part_female_front_3breast") ;
		layerNames.add("body_part_female_front_4arms") ;
		layerNames.add("body_part_female_front_5belly") ;
		layerNames.add("body_part_female_front_6underpants") ;
		layerNames.add("body_part_female_front_7legs") ;
		LinkedHashMap<String , ArrayList<Point>> regions = new LinkedHashMap<String , ArrayList<Point>>() ;
		ArrayList<Point> mPoints = new ArrayList<Point>() ;
		mPoints.add(new Point(135 , 0)) ;
		mPoints.add(new Point(240 , 0)) ;
		mPoints.add(new Point(232 , 125)) ;
		mPoints.add(new Point(142 , 125)) ;
		regions.put(layerNames.get(0) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		mPoints.add(new Point(171 , 120)) ;
		mPoints.add(new Point(165 , 147)) ;
		mPoints.add(new Point(140 , 158)) ;
		mPoints.add(new Point(188 , 168)) ;
		mPoints.add(new Point(239 , 161)) ;
		mPoints.add(new Point(210 , 147)) ;
		mPoints.add(new Point(200 , 123)) ;
		regions.put(layerNames.get(1) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		mPoints.add(new Point(133 , 153)) ;
		mPoints.add(new Point(246 , 153)) ;
		mPoints.add(new Point(240 , 229)) ;
		mPoints.add(new Point(132 , 231)) ;
		regions.put(layerNames.get(2) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		// 左手
		mPoints.add(new Point(132 , 231)) ;
		mPoints.add(new Point(133 , 153)) ;
		mPoints.add(new Point(0 , 428)) ;
		mPoints.add(new Point(59 , 427)) ;
		mPoints.add(new Point(132 , 231)) ;
		// 右手
		mPoints.add(new Point(240 , 229)) ;
		mPoints.add(new Point(246 , 153)) ;
		mPoints.add(new Point(375 , 429)) ;
		mPoints.add(new Point(319 , 424)) ;
		mPoints.add(new Point(240 , 229)) ;
		regions.put(layerNames.get(3) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		mPoints.add(new Point(139 , 255)) ;
		mPoints.add(new Point(232 , 255)) ;
		mPoints.add(new Point(245 , 337)) ;
		mPoints.add(new Point(120 , 337)) ;
		regions.put(layerNames.get(4) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		mPoints.add(new Point(120 , 337)) ;
		mPoints.add(new Point(245 , 337)) ;
		mPoints.add(new Point(174 , 399)) ;
		regions.put(layerNames.get(5) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		// 左腿
		mPoints.add(new Point(174 , 399)) ;
		mPoints.add(new Point(120 , 337)) ;
		mPoints.add(new Point(123 , 780)) ;
		mPoints.add(new Point(166 , 799)) ;
		mPoints.add(new Point(174 , 399)) ;
		// 右腿
		mPoints.add(new Point(193 , 410)) ;
		mPoints.add(new Point(245 , 337)) ;
		mPoints.add(new Point(241 , 777)) ;
		mPoints.add(new Point(194 , 799)) ;
		mPoints.add(new Point(193 , 410)) ;
		regions.put(layerNames.get(6) , mPoints) ;
		mBodyParams_Female_Front = new BodyParams(layerNames , regions) ;
		Gson mGson = new Gson() ;
		Log.i("tag" , "" + mGson.toJson(mBodyParams_Female_Front)) ;
	}
}

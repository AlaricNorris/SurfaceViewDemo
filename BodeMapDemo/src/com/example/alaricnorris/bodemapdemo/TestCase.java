/**
 * 	TestCase.java
 * 	com.example.alaricnorris.bodemapdemo
 * 	Function： 	TODO 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-14 		AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodemapdemo ;

import java.util.ArrayList ;
import java.util.LinkedHashMap ;
import android.graphics.Point ;
import android.test.AndroidTestCase ;
import android.util.Log ;
import com.example.alaricnorris.bodemapdemo.widget.BodyMap ;
import com.example.alaricnorris.bodemapdemo.widget.BodyParams ;
import com.google.gson.Gson ;

/**
 *	ClassName:	TestCase
 *	Function: 	TODO ADD FUNCTION
 *	Reason:	 	TODO ADD REASON
 *	@author   	AlaricNorris		
 *	@contact  	Norris.sly@gmail.com
 *	@version  	Ver 1.0
 *	@since   	I used to be a programmer like you, then I took an arrow in the knee 
 *	@Date	 	2015		2015-6-14		下午9:47:51
 *	@see 	 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Fields 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Methods	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 * 	Modified By 	AlaricNorris		 2015-6-14下午9:47:51
 *	Modifications:	TODO
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class TestCase extends AndroidTestCase {

	public void testParse() {
//		testToJson() ;
//		testFromJson() ;
		testasdf() ;
	}

	/**
	 * 	testasdf:()
	 *  ──────────────────────────────────	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	20144L151		 2015-6-15下午8:50:20
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void testasdf() {
		int dpValue = 100 ;
		Log.i("tag" , "" + BodyMap.dip2px(getContext() , dpValue)) ;
		Log.i("tag" , "" + BodyMap.px2dip(getContext() , BodyMap.dip2px(getContext() , dpValue))) ;
	}

	/**
	 * 	testFromJson:()
	 *  ──────────────────────────────────	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-14下午11:34:53
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	public void testFromJson() {
		Gson mGson = new Gson() ;
		mGson.fromJson(
				"{\"layerNames\":[\"female_front_1head\",\"female_front_2neck\"],\"regions\":{\"female_front_1head\":[{\"x\":135,\"y\":0},{\"x\":240,\"y\":0},{\"x\":232,\"y\":125},{\"x\":142,\"y\":125}],\"female_front_2neck\":[{\"x\":171,\"y\":120},{\"x\":165,\"y\":147},{\"x\":140,\"y\":158},{\"x\":188,\"y\":168},{\"x\":239,\"y\":161},{\"x\":210,\"y\":147},{\"x\":200,\"y\":123}]}}" ,
				BodyParams.class) ;
		Log.i("tag" ,
				""
						+ mGson.fromJson(
								"{\"layerNames\":[\"female_front_1head\",\"female_front_2neck\"],\"regions\":{\"female_front_1head\":[{\"x\":135,\"y\":0},{\"x\":240,\"y\":0},{\"x\":232,\"y\":125},{\"x\":142,\"y\":125}],\"female_front_2neck\":[{\"x\":171,\"y\":120},{\"x\":165,\"y\":147},{\"x\":140,\"y\":158},{\"x\":188,\"y\":168},{\"x\":239,\"y\":161},{\"x\":210,\"y\":147},{\"x\":200,\"y\":123}]}}" ,
								BodyParams.class)) ;
	}

	/**
	 * 	testToJson:()
	 *  ──────────────────────────────────	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	AlaricNorris		 2015-6-14下午9:50:56
	 *	Modifications:	TODO
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 *
	{\"layerNames\":[\"female_front_1head\",\"female_front_2neck\",\"female_front_3breast\"],\"regions\":{\"female_front_1head\":[{\"x\":135,\"y\":0},{\"x\":240,\"y\":0},{\"x\":232,\"y\":125},{\"x\":142,\"y\":125}],\"female_front_2neck\":[{\"x\":171,\"y\":120},{\"x\":165,\"y\":147},{\"x\":140,\"y\":158},{\"x\":188,\"y\":168},{\"x\":239,\"y\":161},{\"x\":210,\"y\":147},{\"x\":200,\"y\":123}]}}
	 *
	 *
	 */
	public void testToJson() {
		ArrayList<String> layerNames = new ArrayList<String>() ;
		layerNames.add("female_front_1head") ;
		layerNames.add("female_front_2neck") ;
		layerNames.add("female_front_3breast") ;
		layerNames.add("female_front_4arms") ;
		layerNames.add("female_front_5belly") ;
		layerNames.add("female_front_6pussy") ;
		layerNames.add("female_front_7legs") ;
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
		regions.put(layerNames.get(3) , new ArrayList<Point>()) ;
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
		regions.put(layerNames.get(6) , new ArrayList<Point>()) ;
		BodyParams mBodyParams = new BodyParams(layerNames , regions) ;
		Gson mGson = new Gson() ;
		Log.i("tag" , "" + mGson.toJson(mBodyParams)) ;
	}
}

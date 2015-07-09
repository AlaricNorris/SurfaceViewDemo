/**
 * 	TestCase.java
 * 	com.example.alaricnorris.bodemapdemo
 * 	Function： 	TODO 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-14 		AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodymapdemo ;

import java.util.ArrayList ;
import java.util.LinkedHashMap ;
import android.graphics.Point ;
import android.test.AndroidTestCase ;
import android.util.Log ;
import com.example.alaricnorris.bodymapdemo.widget.BodyMap ;
import com.example.alaricnorris.bodymapdemo.widget.BodyParams ;
import com.example.alaricnorris.bodymapdemo.widget.Constants ;
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
//		testasdf() ;
		testBodyParamsToJson() ;
	}

	/**
	 * 	testBodyParamsToJson:()
	 *  ──────────────────────────────────	
	 *	@version	Ver 1.0	
	 * 	@since  	I used to be a programmer like you, then I took an arrow in the knee　
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 * 	Modified By 	20144L151		 2015-6-23下午2:49:10
	 *	Modifications:	init
	 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
	 */
	private void testBodyParamsToJson() {
		Gson mGson = new Gson() ;
		// {"imageName":"body_map_female_back","layerNames":["body_part_female_back_1head","body_part_female_back_2neck","body_part_female_back_3back","body_part_female_back_4arms","body_part_female_back_5hip","body_part_female_back_6legs"],"messageBundles":{"body_part_female_back_1head":1,"body_part_female_back_2neck":2,"body_part_female_back_3back":6,"body_part_female_back_4arms":4,"body_part_female_back_5hip":8,"body_part_female_back_6legs":4},"regions":{"body_part_female_back_1head":[{"x":140,"y":1},{"x":237,"y":1},{"x":215,"y":117},{"x":151,"y":117}],"body_part_female_back_2neck":[{"x":151,"y":117},{"x":215,"y":117},{"x":235,"y":158},{"x":139,"y":157}],"body_part_female_back_3back":[{"x":139,"y":157},{"x":235,"y":158},{"x":247,"y":166},{"x":240,"y":225},{"x":246,"y":343},{"x":123,"y":346},{"x":133,"y":230},{"x":119,"y":173}],"body_part_female_back_4arms":[{"x":133,"y":230},{"x":119,"y":173},{"x":1,"y":428},{"x":55,"y":429},{"x":133,"y":230},{"x":240,"y":225},{"x":247,"y":166},{"x":375,"y":430},{"x":321,"y":425},{"x":240,"y":225}],"body_part_female_back_5hip":[{"x":123,"y":346},{"x":246,"y":343},{"x":257,"y":412},{"x":111,"y":411}],"body_part_female_back_6legs":[{"x":175,"y":425},{"x":111,"y":411},{"x":126,"y":796},{"x":166,"y":799},{"x":175,"y":425},{"x":195,"y":440},{"x":257,"y":412},{"x":239,"y":785},{"x":195,"y":776},{"x":195,"y":440}]}}
		Log.i("tag" + "BodyParams_Female_Back" , mGson.toJson(Constants.BodyParams_Female_Back)) ;
		// {"imageName":"body_map_female_front","layerNames":["body_part_female_front_1head","body_part_female_front_2neck","body_part_female_front_3breast","body_part_female_front_4arms","body_part_female_front_5belly","body_part_female_front_6underpants","body_part_female_front_7legs"],"messageBundles":{"body_part_female_front_1head":1,"body_part_female_front_2neck":2,"body_part_female_front_3breast":3,"body_part_female_front_4arms":4,"body_part_female_front_5belly":5,"body_part_female_front_6underpants":7,"body_part_female_front_7legs":4},"regions":{"body_part_female_front_1head":[{"x":135,"y":0},{"x":240,"y":0},{"x":232,"y":125},{"x":142,"y":125}],"body_part_female_front_2neck":[{"x":171,"y":120},{"x":165,"y":147},{"x":140,"y":158},{"x":188,"y":168},{"x":239,"y":161},{"x":210,"y":147},{"x":200,"y":123}],"body_part_female_front_3breast":[{"x":133,"y":153},{"x":246,"y":153},{"x":240,"y":229},{"x":132,"y":231}],"body_part_female_front_4arms":[{"x":132,"y":231},{"x":133,"y":153},{"x":0,"y":428},{"x":59,"y":427},{"x":132,"y":231},{"x":240,"y":229},{"x":246,"y":153},{"x":375,"y":429},{"x":319,"y":424},{"x":240,"y":229}],"body_part_female_front_5belly":[{"x":139,"y":255},{"x":232,"y":255},{"x":245,"y":337},{"x":120,"y":337}],"body_part_female_front_6underpants":[{"x":120,"y":337},{"x":245,"y":337},{"x":174,"y":399}],"body_part_female_front_7legs":[{"x":174,"y":399},{"x":120,"y":337},{"x":123,"y":780},{"x":166,"y":799},{"x":174,"y":399},{"x":193,"y":410},{"x":245,"y":337},{"x":241,"y":777},{"x":194,"y":799},{"x":193,"y":410}]}}
		Log.i("tag" + "BodyParams_Female_Front" , mGson.toJson(Constants.BodyParams_Female_Front)) ;
		// {"imageName":"body_map_male_back","layerNames":["body_part_male_back_1head","body_part_male_back_2neck","body_part_male_back_3back","body_part_male_back_4arms","body_part_male_back_5hip","body_part_male_back_6legs"],"messageBundles":{"body_part_male_back_1head":1,"body_part_male_back_2neck":2,"body_part_male_back_3back":6,"body_part_male_back_4arms":4,"body_part_male_back_5hip":8,"body_part_male_back_6legs":4},"regions":{"body_part_male_back_1head":[{"x":160,"y":2},{"x":232,"y":2},{"x":232,"y":94},{"x":158,"y":93}],"body_part_male_back_2neck":[{"x":158,"y":93},{"x":232,"y":94},{"x":248,"y":128},{"x":146,"y":128}],"body_part_male_back_3back":[{"x":146,"y":128},{"x":248,"y":128},{"x":290,"y":147},{"x":270,"y":240},{"x":261,"y":328},{"x":134,"y":331},{"x":121,"y":244},{"x":101,"y":147}],"body_part_male_back_4arms":[{"x":121,"y":244},{"x":101,"y":147},{"x":1,"y":399},{"x":31,"y":451},{"x":121,"y":244},{"x":270,"y":240},{"x":290,"y":147},{"x":397,"y":401},{"x":372,"y":451},{"x":270,"y":240}],"body_part_male_back_5hip":[{"x":134,"y":331},{"x":261,"y":328},{"x":275,"y":408},{"x":120,"y":409}],"body_part_male_back_6legs":[{"x":192,"y":416},{"x":120,"y":409},{"x":112,"y":776},{"x":173,"y":776},{"x":192,"y":416},{"x":205,"y":416},{"x":275,"y":408},{"x":284,"y":776},{"x":222,"y":776},{"x":205,"y":416}]}}
		Log.i("tag" + "BodyParams_Male_Back" , mGson.toJson(Constants.BodyParams_Male_Back)) ;
		// {"imageName":"body_map_male_front","layerNames":["body_part_male_front_1head","body_part_male_front_2neck","body_part_male_front_3breast","body_part_male_front_4arms","body_part_male_front_5belly","body_part_male_front_6underpants","body_part_male_front_7legs"],"messageBundles":{"body_part_male_front_1head":1,"body_part_male_front_2neck":2,"body_part_male_front_3breast":3,"body_part_male_front_4arms":4,"body_part_male_front_5belly":5,"body_part_male_front_6underpants":7,"body_part_male_front_7legs":4},"regions":{"body_part_male_front_1head":[{"x":151,"y":0},{"x":237,"y":0},{"x":238,"y":94},{"x":151,"y":94}],"body_part_male_front_2neck":[{"x":151,"y":94},{"x":238,"y":94},{"x":245,"y":142},{"x":142,"y":142}],"body_part_male_front_3breast":[{"x":109,"y":126},{"x":142,"y":142},{"x":245,"y":142},{"x":269,"y":126},{"x":256,"y":268},{"x":128,"y":264}],"body_part_male_front_4arms":[{"x":123,"y":245},{"x":109,"y":126},{"x":1,"y":404},{"x":32,"y":442},{"x":123,"y":245},{"x":268,"y":245},{"x":269,"y":126},{"x":391,"y":396},{"x":360,"y":454},{"x":268,"y":245}],"body_part_male_front_5belly":[{"x":128,"y":264},{"x":256,"y":268},{"x":268,"y":349},{"x":130,"y":349}],"body_part_male_front_6underpants":[{"x":122,"y":374},{"x":273,"y":368},{"x":207,"y":430},{"x":185,"y":430}],"body_part_male_front_7legs":[{"x":185,"y":430},{"x":122,"y":374},{"x":114,"y":774},{"x":168,"y":774},{"x":185,"y":430},{"x":207,"y":430},{"x":273,"y":368},{"x":281,"y":775},{"x":226,"y":775},{"x":207,"y":430}]}}
		Log.i("tag" + "BodyParams_Male_Front" , mGson.toJson(Constants.BodyParams_Male_Front)) ;
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

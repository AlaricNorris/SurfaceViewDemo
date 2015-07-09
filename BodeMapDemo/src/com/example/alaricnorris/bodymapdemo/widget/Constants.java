/**
 * 	Constants.java
 * 	com.example.alaricnorris.bodemapdemo.widget
 * 	Function： 	  
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-15 		20144L151
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodymapdemo.widget ;

import java.util.ArrayList ;
import java.util.LinkedHashMap ;
import android.graphics.Point ;
import android.util.Log ;
import com.google.gson.Gson ;

/**
 *	ClassName:	Constants
 *	Function: 	 
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
 *	Modifications:	init
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class Constants {

	/**
	 * 	头部
	 * 	int			:		MSG_WHAT_PART1_HEAD	
	 * 	@since Ver 1.0
	 */
	public static final int MSG_WHAT_PART1_HEAD = 0x0001 ;

	/**
	 * 	颈部
	 * 	int			:		MSG_WHAT_PART2_NECK	
	 * 	@since Ver 1.0
	 */
	public static final int MSG_WHAT_PART2_NECK = 0x0002 ;

	/**
	 *  胸部
	 * 	int			:		MSG_WHAT_PART3_BEEAST	
	 * 	@since Ver 1.0
	 */
	public static final int MSG_WHAT_PART3_BEEAST = 0x0003 ;

	/**
	 * 	四肢
	 * 	int			:		MSG_WHAT_PART4_ARMS_LEGS	
	 * 	@since Ver 1.0
	 */
	public static final int MSG_WHAT_PART4_ARMS_LEGS = 0x0004 ;

	/**
	 * 	腹部
	 * 	int			:		MSG_WHAT_PART5_BELLY	
	 * 	@since Ver 1.0
	 */
	public static final int MSG_WHAT_PART5_BELLY = 0x0005 ;

	/**
	 * 	背部
	 * 	int			:		MSG_WHAT_PART6_BACK	
	 * 	@since Ver 1.0
	 */
	public static final int MSG_WHAT_PART6_BACK = 0x0006 ;

	/**
	 * 	根部
	 * 	int			:		MSG_WHAT_PART7_UNDERPANTS	
	 * 	@since Ver 1.0
	 */
	public static final int MSG_WHAT_PART7_UNDERPANTS = 0x0007 ;

	/**
	 * 	臀部
	 * 	int			:		MSG_WHAT_PART8_HIP	
	 * 	@since Ver 1.0
	 */
	public static final int MSG_WHAT_PART8_HIP = 0x0008 ;

	// {"layerNames":["female_front_1head","female_front_2neck","female_front_3breast","female_front_4arms","female_front_5belly","female_front_6pussy","female_front_7legs"],"regions":{"female_front_1head":[{"x":135,"y":0},{"x":240,"y":0},{"x":232,"y":125},{"x":142,"y":125}],"female_front_2neck":[{"x":171,"y":120},{"x":165,"y":147},{"x":140,"y":158},{"x":188,"y":168},{"x":239,"y":161},{"x":210,"y":147},{"x":200,"y":123}],"female_front_3breast":[{"x":133,"y":153},{"x":246,"y":153},{"x":240,"y":229},{"x":132,"y":231}],"female_front_4arms":[],"female_front_5belly":[{"x":139,"y":255},{"x":232,"y":255},{"x":245,"y":337},{"x":120,"y":337}],"female_front_6pussy":[{"x":120,"y":337},{"x":245,"y":337},{"x":174,"y":399}],"female_front_7legs":[]}}
	public static final BodyParams BodyParams_Female_Front ;
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
		LinkedHashMap<String , Integer> messageBundles = new LinkedHashMap<String , Integer>() ;
		ArrayList<Point> mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(0) , MSG_WHAT_PART1_HEAD) ;
		mPoints.add(new Point(135 , 0)) ;
		mPoints.add(new Point(240 , 0)) ;
		mPoints.add(new Point(232 , 125)) ;
		mPoints.add(new Point(142 , 125)) ;
		regions.put(layerNames.get(0) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(1) , MSG_WHAT_PART2_NECK) ;
		mPoints.add(new Point(171 , 120)) ;
		mPoints.add(new Point(165 , 147)) ;
		mPoints.add(new Point(140 , 158)) ;
		mPoints.add(new Point(188 , 168)) ;
		mPoints.add(new Point(239 , 161)) ;
		mPoints.add(new Point(210 , 147)) ;
		mPoints.add(new Point(200 , 123)) ;
		regions.put(layerNames.get(1) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(2) , MSG_WHAT_PART3_BEEAST) ;
		mPoints.add(new Point(133 , 153)) ;
		mPoints.add(new Point(246 , 153)) ;
		mPoints.add(new Point(240 , 229)) ;
		mPoints.add(new Point(132 , 231)) ;
		regions.put(layerNames.get(2) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(3) , MSG_WHAT_PART4_ARMS_LEGS) ;
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
		messageBundles.put(layerNames.get(4) , MSG_WHAT_PART5_BELLY) ;
		mPoints.add(new Point(139 , 255)) ;
		mPoints.add(new Point(232 , 255)) ;
		mPoints.add(new Point(245 , 337)) ;
		mPoints.add(new Point(120 , 337)) ;
		regions.put(layerNames.get(4) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(5) , MSG_WHAT_PART7_UNDERPANTS) ;
		mPoints.add(new Point(120 , 337)) ;
		mPoints.add(new Point(245 , 337)) ;
		mPoints.add(new Point(174 , 399)) ;
		regions.put(layerNames.get(5) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(6) , MSG_WHAT_PART4_ARMS_LEGS) ;
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
		BodyParams_Female_Front = new BodyParams(layerNames , regions , messageBundles ,
				"body_map_female_front") ;
		Gson mGson = new Gson() ;
		Log.i("tag" , "" + mGson.toJson(BodyParams_Female_Front)) ;
	}

	public static final BodyParams BodyParams_Female_Back ;
	static {
		ArrayList<String> layerNames = new ArrayList<String>() ;
		layerNames.add("body_part_female_back_1head") ;
		layerNames.add("body_part_female_back_2neck") ;
		layerNames.add("body_part_female_back_3back") ;
		layerNames.add("body_part_female_back_4arms") ;
		layerNames.add("body_part_female_back_5hip") ;
		layerNames.add("body_part_female_back_6legs") ;
		LinkedHashMap<String , ArrayList<Point>> regions = new LinkedHashMap<String , ArrayList<Point>>() ;
		LinkedHashMap<String , Integer> messageBundles = new LinkedHashMap<String , Integer>() ;
		ArrayList<Point> mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(0) , MSG_WHAT_PART1_HEAD) ;
		// head
		mPoints.add(new Point(140 , 1)) ;
		mPoints.add(new Point(237 , 1)) ;
		mPoints.add(new Point(215 , 117)) ;
		mPoints.add(new Point(151 , 117)) ;
		regions.put(layerNames.get(0) , mPoints) ;
		// neck
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(1) , MSG_WHAT_PART2_NECK) ;
		mPoints.add(new Point(151 , 117)) ;
		mPoints.add(new Point(215 , 117)) ;
		mPoints.add(new Point(235 , 158)) ;
		mPoints.add(new Point(139 , 157)) ;
		// back
		regions.put(layerNames.get(1) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(2) , MSG_WHAT_PART6_BACK) ;
		mPoints.add(new Point(139 , 157)) ;
		mPoints.add(new Point(235 , 158)) ;
		mPoints.add(new Point(247 , 166)) ;
		mPoints.add(new Point(240 , 225)) ;
		mPoints.add(new Point(246 , 343)) ;
		mPoints.add(new Point(123 , 346)) ;
		mPoints.add(new Point(133 , 230)) ;
		mPoints.add(new Point(119 , 173)) ;
		regions.put(layerNames.get(2) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(3) , MSG_WHAT_PART4_ARMS_LEGS) ;
		// 左手
		mPoints.add(new Point(133 , 230)) ;
		mPoints.add(new Point(119 , 173)) ;
		mPoints.add(new Point(1 , 428)) ;
		mPoints.add(new Point(55 , 429)) ;
		mPoints.add(new Point(133 , 230)) ;
		// 右手
		mPoints.add(new Point(240 , 225)) ;
		mPoints.add(new Point(247 , 166)) ;
		mPoints.add(new Point(375 , 430)) ;
		mPoints.add(new Point(321 , 425)) ;
		mPoints.add(new Point(240 , 225)) ;
		regions.put(layerNames.get(3) , mPoints) ;
		// 臀部
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(4) , MSG_WHAT_PART8_HIP) ;
		mPoints.add(new Point(123 , 346)) ;
		mPoints.add(new Point(246 , 343)) ;
		mPoints.add(new Point(257 , 412)) ;
		mPoints.add(new Point(111 , 411)) ;
		regions.put(layerNames.get(4) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(5) , MSG_WHAT_PART4_ARMS_LEGS) ;
		// 左腿
		mPoints.add(new Point(175 , 425)) ;
		mPoints.add(new Point(111 , 411)) ;
		mPoints.add(new Point(126 , 796)) ;
		mPoints.add(new Point(166 , 799)) ;
		mPoints.add(new Point(175 , 425)) ;
		// 右腿
		mPoints.add(new Point(195 , 440)) ;
		mPoints.add(new Point(257 , 412)) ;
		mPoints.add(new Point(239 , 785)) ;
		mPoints.add(new Point(195 , 776)) ;
		mPoints.add(new Point(195 , 440)) ;
		regions.put(layerNames.get(5) , mPoints) ;
		BodyParams_Female_Back = new BodyParams(layerNames , regions , messageBundles ,
				"body_map_female_back") ;
		Gson mGson = new Gson() ;
		Log.i("tag" , "" + mGson.toJson(BodyParams_Female_Back)) ;
	}

	public static final BodyParams BodyParams_Male_Front ;
	static {
		ArrayList<String> layerNames = new ArrayList<String>() ;
		layerNames.add("body_part_male_front_1head") ;
		layerNames.add("body_part_male_front_2neck") ;
		layerNames.add("body_part_male_front_3breast") ;
		layerNames.add("body_part_male_front_4arms") ;
		layerNames.add("body_part_male_front_5belly") ;
		layerNames.add("body_part_male_front_6underpants") ;
		layerNames.add("body_part_male_front_7legs") ;
		LinkedHashMap<String , ArrayList<Point>> regions = new LinkedHashMap<String , ArrayList<Point>>() ;
		LinkedHashMap<String , Integer> messageBundles = new LinkedHashMap<String , Integer>() ;
		ArrayList<Point> mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(0) , MSG_WHAT_PART1_HEAD) ;
		// 头
		mPoints.add(new Point(151 , 0)) ;
		mPoints.add(new Point(237 , 0)) ;
		mPoints.add(new Point(238 , 94)) ;
		mPoints.add(new Point(151 , 94)) ;
		regions.put(layerNames.get(0) , mPoints) ;
		//　颈
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(1) , MSG_WHAT_PART2_NECK) ;
		mPoints.add(new Point(151 , 94)) ;
		mPoints.add(new Point(238 , 94)) ;
		mPoints.add(new Point(245 , 142)) ;
		mPoints.add(new Point(142 , 142)) ;
		regions.put(layerNames.get(1) , mPoints) ;
		// 胸
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(2) , MSG_WHAT_PART3_BEEAST) ;
		mPoints.add(new Point(109 , 126)) ;
		mPoints.add(new Point(142 , 142)) ;
		mPoints.add(new Point(245 , 142)) ;
		mPoints.add(new Point(269 , 126)) ;
		mPoints.add(new Point(256 , 268)) ;
		mPoints.add(new Point(128 , 264)) ;
		regions.put(layerNames.get(2) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(3) , MSG_WHAT_PART4_ARMS_LEGS) ;
		// 左手
		mPoints.add(new Point(123 , 245)) ;
		mPoints.add(new Point(109 , 126)) ;
		mPoints.add(new Point(1 , 404)) ;
		mPoints.add(new Point(32 , 442)) ;
		mPoints.add(new Point(123 , 245)) ;
		// 右手
		mPoints.add(new Point(268 , 245)) ;
		mPoints.add(new Point(269 , 126)) ;
		mPoints.add(new Point(391 , 396)) ;
		mPoints.add(new Point(360 , 454)) ;
		mPoints.add(new Point(268 , 245)) ;
		regions.put(layerNames.get(3) , mPoints) ;
		// 腹
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(4) , MSG_WHAT_PART5_BELLY) ;
		mPoints.add(new Point(128 , 264)) ;
		mPoints.add(new Point(256 , 268)) ;
		mPoints.add(new Point(268 , 349)) ;
		mPoints.add(new Point(130 , 349)) ;
		regions.put(layerNames.get(4) , mPoints) ;
		// 根
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(5) , MSG_WHAT_PART7_UNDERPANTS) ;
		mPoints.add(new Point(122 , 374)) ;
		mPoints.add(new Point(273 , 368)) ;
		mPoints.add(new Point(207 , 430)) ;
		mPoints.add(new Point(185 , 430)) ;
		regions.put(layerNames.get(5) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(6) , MSG_WHAT_PART4_ARMS_LEGS) ;
		// 左腿
		mPoints.add(new Point(185 , 430)) ;
		mPoints.add(new Point(122 , 374)) ;
		mPoints.add(new Point(114 , 774)) ;
		mPoints.add(new Point(168 , 774)) ;
		mPoints.add(new Point(185 , 430)) ;
		// 右腿
		mPoints.add(new Point(207 , 430)) ;
		mPoints.add(new Point(273 , 368)) ;
		mPoints.add(new Point(281 , 775)) ;
		mPoints.add(new Point(226 , 775)) ;
		mPoints.add(new Point(207 , 430)) ;
		regions.put(layerNames.get(6) , mPoints) ;
		BodyParams_Male_Front = new BodyParams(layerNames , regions , messageBundles ,
				"body_map_male_front") ;
	}

	public static final BodyParams BodyParams_Male_Back ;
	static {
		ArrayList<String> layerNames = new ArrayList<String>() ;
		layerNames.add("body_part_male_back_1head") ;
		layerNames.add("body_part_male_back_2neck") ;
		layerNames.add("body_part_male_back_3back") ;
		layerNames.add("body_part_male_back_4arms") ;
		layerNames.add("body_part_male_back_5hip") ;
		layerNames.add("body_part_male_back_6legs") ;
		LinkedHashMap<String , ArrayList<Point>> regions = new LinkedHashMap<String , ArrayList<Point>>() ;
		LinkedHashMap<String , Integer> messageBundles = new LinkedHashMap<String , Integer>() ;
		ArrayList<Point> mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(0) , MSG_WHAT_PART1_HEAD) ;
		// 头
		mPoints.add(new Point(160 , 2)) ;
		mPoints.add(new Point(232 , 2)) ;
		mPoints.add(new Point(232 , 94)) ;
		mPoints.add(new Point(158 , 93)) ;
		regions.put(layerNames.get(0) , mPoints) ;
		// 颈
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(1) , MSG_WHAT_PART2_NECK) ;
		mPoints.add(new Point(158 , 93)) ;
		mPoints.add(new Point(232 , 94)) ;
		mPoints.add(new Point(248 , 128)) ;
		mPoints.add(new Point(146 , 128)) ;
		regions.put(layerNames.get(1) , mPoints) ;
		// 背
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(2) , MSG_WHAT_PART6_BACK) ;
		mPoints.add(new Point(146 , 128)) ;
		mPoints.add(new Point(248 , 128)) ;
		mPoints.add(new Point(290 , 147)) ;
		mPoints.add(new Point(270 , 240)) ;
		mPoints.add(new Point(261 , 328)) ;
		mPoints.add(new Point(134 , 331)) ;
		mPoints.add(new Point(121 , 244)) ;
		mPoints.add(new Point(101 , 147)) ;
		regions.put(layerNames.get(2) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(3) , MSG_WHAT_PART4_ARMS_LEGS) ;
		// 左手
		mPoints.add(new Point(121 , 244)) ;
		mPoints.add(new Point(101 , 147)) ;
		mPoints.add(new Point(1 , 399)) ;
		mPoints.add(new Point(31 , 451)) ;
		mPoints.add(new Point(121 , 244)) ;
		// 右手
		mPoints.add(new Point(270 , 240)) ;
		mPoints.add(new Point(290 , 147)) ;
		mPoints.add(new Point(397 , 401)) ;
		mPoints.add(new Point(372 , 451)) ;
		mPoints.add(new Point(270 , 240)) ;
		regions.put(layerNames.get(3) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(4) , MSG_WHAT_PART8_HIP) ;
		// 臀
		mPoints.add(new Point(134 , 331)) ;
		mPoints.add(new Point(261 , 328)) ;
		mPoints.add(new Point(275 , 408)) ;
		mPoints.add(new Point(120 , 409)) ;
		regions.put(layerNames.get(4) , mPoints) ;
		mPoints = new ArrayList<Point>() ;
		messageBundles.put(layerNames.get(5) , MSG_WHAT_PART4_ARMS_LEGS) ;
		// 左腿
		mPoints.add(new Point(192 , 416)) ;
		mPoints.add(new Point(120 , 409)) ;
		mPoints.add(new Point(112 , 776)) ;
		mPoints.add(new Point(173 , 776)) ;
		mPoints.add(new Point(192 , 416)) ;
		// 右腿
		mPoints.add(new Point(205 , 416)) ;
		mPoints.add(new Point(275 , 408)) ;
		mPoints.add(new Point(284 , 776)) ;
		mPoints.add(new Point(222 , 776)) ;
		mPoints.add(new Point(205 , 416)) ;
		regions.put(layerNames.get(5) , mPoints) ;
		BodyParams_Male_Back = new BodyParams(layerNames , regions , messageBundles ,
				"body_map_male_back") ;
	}
}

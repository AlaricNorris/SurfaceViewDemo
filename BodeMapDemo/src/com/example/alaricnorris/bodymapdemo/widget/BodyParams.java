/**
 * 	BodyParams.java
 * 	com.example.alaricnorris.bodemapdemo
 * 	Function： 	人体图参数 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-14 		AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodymapdemo.widget ;

import java.io.Serializable ;
import java.util.ArrayList ;
import java.util.LinkedHashMap ;
import android.graphics.Point ;

/**
 *	ClassName:	BodyParams
 *	Function: 	人体图参数
 *	@author   	AlaricNorris		
 *	@contact  	Norris.sly@gmail.com
 *	@version  	Ver 1.0
 *	@since   	I used to be a programmer like you, then I took an arrow in the knee 
 *	@Date	 	2015		2015-6-14		下午10:25:00
 *	@see 	 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Fields 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Methods	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 * 	Modified By 	AlaricNorris		 2015-6-14下午10:25:00
 *	Modifications:	init
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class BodyParams implements Serializable {

	/**
	 * 	long			:		serialVersionUID	
	 * 	@since Ver 1.0
	 */
	private static final long serialVersionUID = 1L ;

	/**
	 * 	身体部位图片层名称
	 * 	ArrayList<String>			:		layerNames	
	 * 	@since Ver 1.0
	 */
	private ArrayList<String> layerNames ;

	/**
	 * 	检测区域(Point列表)
	 * 	LinkedHashMap<String,ArrayList<Point>>			:		regions	
	 * 	@since Ver 1.0
	 */
	private LinkedHashMap<String , ArrayList<Point>> regions ;

	/**
	 * 	BundleIndex 用图片名称做Key，Value为身体部位的Index
	 * 	{@link Constants#MSG_WHAT_PART1_HEAD}
	 * 	LinkedHashMap<String,Integer>			:		messageBundles	
	 * 	@since Ver 1.0
	 */
	private LinkedHashMap<String , Integer> messageBundles ;

	/**
	 * 	图片名称
	 * 	String			:		imageName	
	 * 	@since Ver 1.0
	 */
	private String imageName ;

	/**
	 * 	Creates a new instance of BodyParams.
	 */
	public BodyParams() {
		super() ;
	}

	/**
	 * 	Creates a new instance of BodyParams.
	 * 	@param layerNames
	 * 	@param regions
	 */
	public BodyParams(ArrayList<String> layerNames ,
			LinkedHashMap<String , ArrayList<Point>> regions) {
		super() ;
		this.layerNames = layerNames ;
		this.regions = regions ;
	}

	/**
	 * 	Creates a new instance of BodyParams.
	 * 	@param layerNames
	 * 	@param regions
	 * 	@param imageName
	 */
	public BodyParams(ArrayList<String> layerNames ,
			LinkedHashMap<String , ArrayList<Point>> regions , String imageName) {
		super() ;
		this.layerNames = layerNames ;
		this.regions = regions ;
		this.imageName = imageName ;
	}

	/**
	 * 	Creates a new instance of BodyParams.
	 * 	@param layerNames
	 * 	@param regions
	 * 	@param messageBundles
	 * 	@param imageName
	 */
	public BodyParams(ArrayList<String> layerNames ,
			LinkedHashMap<String , ArrayList<Point>> regions ,
			LinkedHashMap<String , Integer> messageBundles , String imageName) {
		super() ;
		this.layerNames = layerNames ;
		this.regions = regions ;
		this.messageBundles = messageBundles ;
		this.imageName = imageName ;
	}

	/**
	 * 	layerNames
	 * 	@return  	the layerNames
	 */
	public ArrayList<String> getLayerNames() {
		return layerNames ;
	}

	/**
	 *	layerNames
	 *	@param   layerNames    the layerNames to set
	 */
	public void setLayerNames(ArrayList<String> layerNames) {
		this.layerNames = layerNames ;
	}

	/**
	 * 	regions
	 * 	@return  	the regions
	 */
	public LinkedHashMap<String , ArrayList<Point>> getRegions() {
		return regions ;
	}

	/**
	 *	regions
	 *	@param   regions    the regions to set
	 */
	public void setRegions(LinkedHashMap<String , ArrayList<Point>> regions) {
		this.regions = regions ;
	}

	/**
	 * 	imageName
	 * 	@return  	the imageName
	 */
	public String getImageName() {
		return imageName ;
	}

	/**
	 *	imageName
	 *	@param   imageName    the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName ;
	}

	/**
	 * 	messageBundles
	 * 	@return  	the messageBundles
	 */
	public LinkedHashMap<String , Integer> getMessageBundles() {
		return messageBundles ;
	}

	/**
	 *	messageBundles
	 *	@param   messageBundles    the messageBundles to set
	 */
	public void setMessageBundles(LinkedHashMap<String , Integer> messageBundles) {
		this.messageBundles = messageBundles ;
	}

	/**
	 * 	(non-Javadoc)
	 * 	@see java.lang.Object#toString()
	 */
	@ Override
	public String toString() {
		return "BodyParams [layerNames=" + layerNames + ", regions=" + regions
				+ ", messageBundles=" + messageBundles + ", imageName=" + imageName + "]" ;
	}
}

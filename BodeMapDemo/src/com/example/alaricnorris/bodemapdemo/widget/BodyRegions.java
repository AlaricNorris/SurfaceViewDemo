/**
 * 	BodyRegions.java
 * 	com.example.alaricnorris.bodemapdemo
 * 	Function： 	TODO 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-14 		AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodemapdemo.widget ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.LinkedHashMap ;
import android.graphics.Point ;

/**
 *	ClassName:	BodyRegions
 *	Function: 	TODO ADD FUNCTION
 *	Reason:	 	TODO ADD REASON
 *	@author   	AlaricNorris		
 *	@contact  	Norris.sly@gmail.com
 *	@version  	Ver 1.0
 *	@since   	I used to be a programmer like you, then I took an arrow in the knee 
 *	@Date	 	2015		2015-6-14		下午2:22:46
 *	@see 	 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Fields 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Methods	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 * 	Modified By 	AlaricNorris		 2015-6-14下午2:22:46
 *	Modifications:	TODO
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class BodyRegions {

	private LinkedHashMap<String , ArrayList<Point>> regions ;

	/**
	 * 	Creates a new instance of BodyRegions.
	 */
	public BodyRegions() {
		super() ;
	}

	/**
	 * 	Creates a new instance of BodyRegions.
	 * 	@param regions
	 */
	public BodyRegions(LinkedHashMap<String , ArrayList<Point>> regions) {
		super() ;
		this.regions = regions ;
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
	 * 	(non-Javadoc)
	 * 	@see java.lang.Object#toString()
	 */
	@ Override
	public String toString() {
		return "BodyRegions [regions=" + regions + "]" ;
	}
}

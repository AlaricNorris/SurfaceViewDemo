/**
 * 	BodyLayers.java
 * 	com.example.alaricnorris.bodemapdemo
 * 	Function： 	TODO 
 *   ver     date      		author
 * 	──────────────────────────────────
 *   		 2015-6-14 		AlaricNorris
 *	Copyright (c) 2015, TNT All Rights Reserved.
 */
package com.example.alaricnorris.bodemapdemo.widget ;

import java.util.ArrayList ;

/**
 *	ClassName:	BodyLayers
 *	Function: 	TODO ADD FUNCTION
 *	Reason:	 	TODO ADD REASON
 *	@author   	AlaricNorris		
 *	@contact  	Norris.sly@gmail.com
 *	@version  	Ver 1.0
 *	@since   	I used to be a programmer like you, then I took an arrow in the knee 
 *	@Date	 	2015		2015-6-14		下午2:23:51
 *	@see 	 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Fields 	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 *	@Methods	
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 * 	Modified By 	AlaricNorris		 2015-6-14下午2:23:51
 *	Modifications:	TODO
 *	──────────────────────────────────────────────────────────────────────────────────────────────────────
 */
public class BodyLayers {

	private ArrayList<String> layerNames ;

	/**
	 * 	Creates a new instance of BodyLayers.
	 */
	public BodyLayers() {
		super() ;
	}

	/**
	 * 	Creates a new instance of BodyLayers.
	 * 	@param layerNames
	 */
	public BodyLayers(ArrayList<String> layerNames) {
		super() ;
		this.layerNames = layerNames ;
	}

	/**
	 * 	(non-Javadoc)
	 * 	@see java.lang.Object#toString()
	 */
	@ Override
	public String toString() {
		return "BodyLayers [layerNames=" + layerNames + "]" ;
	}
}

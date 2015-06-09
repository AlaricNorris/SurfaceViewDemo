package com.example.alaricnorris.bodemapdemo;
import android.util.Log ;

/**
 * Body map which contains the details for a specific part of the body
 * @author 20144L157
 *
 */
public class BodyPart{
	//the vertices of the container
	private int verts = 4;
	private int[] vertx;
	private int[] verty;
	
	//part information
	public String ID;
	public String name;
	private final int SIDE;
	private final int SEX;
	
	private PartsContainer container;
	
	private boolean normalized = false;

	public BodyPart(int x1, int y1, int x2, int y2, int x3, int y3, int x4,
			int y4, String ID, String name, final int SIDE, final int SEX) {
		int[] tempx = { x1, x2, x3, x4 };
		vertx = tempx;
		int[] tempy = { y1, y2, y3, y4 };
		verty = tempy;
		this.ID = ID;
		this.name = name;
		this.SIDE = SIDE;
		this.SEX = SEX;
	}

	/**
	 * Determine if the testing point x,y is inside this body part
	 * @param testx
	 * @param testy
	 * @param SIDE
	 * @param SEX
	 * @return
	 */
	public boolean isInside(float testx, float testy, int SIDE, int SEX) {
		if (this.SIDE != 2 && this.SIDE != SIDE)
			return false;

		if (this.SEX != 2 && this.SEX != SEX)
			return false;

		int i, j;
		boolean c = false;
		for (i = 0, j = verts - 1; i < verts; j = i++) {
			if (((verty[i] > testy) != (verty[j] > testy))
					&& (testx < (vertx[j] - vertx[i]) * (testy - verty[i])
							/ (verty[j] - verty[i]) + vertx[i]))
				c = !c;
		}
		return c;
	}

	/**
	 * Recalculate the screen width and height
	 */
	public void normalizeToScrn(double wRatio, double hRatio) {
		if (normalized)
			return;
		
		String log = "";
		for (int i = 0; i < vertx.length; i++) {
			log += "("+vertx[i]+"," + verty[i]+"), ";
		}
		Log.d("pzs", this.name+" before: " + log);
		
		for (int i = 0; i < vertx.length; i++) {
			vertx[i] = calcWidth(vertx[i], wRatio);
			verty[i] = calcHeight(verty[i], hRatio);
		}
		
		log = "";
		for (int i = 0; i < vertx.length; i++) {
			log += "("+vertx[i]+"," + verty[i]+"), ";
		}
		Log.d("pzs", this.name+" after: " + log);
		
		normalized = true;
	}
	
	/**
	 * Convert the image height to the screen height
	 * @param f
	 * @return
	 */
	public int calcHeight(int f, double hRatio) {
		return (int) (f / hRatio);
	}

	/**
	 * Convert the image width to the screen width
	 * @param f
	 * @return
	 */
	public int calcWidth(int f, double wRatio) {
		return (int) (f / wRatio);
	}
	
	public void setContainer(PartsContainer container){
		this.container = container;
	}
	
	public PartsContainer getContainer() {
		return container;
	}

}


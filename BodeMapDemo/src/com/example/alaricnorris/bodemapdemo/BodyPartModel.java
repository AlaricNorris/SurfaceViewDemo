package com.example.alaricnorris.bodemapdemo;

import java.util.ArrayList;
import java.util.List;

public class BodyPartModel {

	private double pWidth, pHeight;

	public double hRatio;
	public double wRatio;

	private List<BodyPart> parts;

	private double threshold = 0.7;

	public BodyPartModel(double pHeight, double pWidth) {
		parts = new ArrayList<BodyPart>();
		this.pHeight = pHeight;
		this.pWidth = pWidth;
	}

	public void normalizeToScrn(double scrnWidth, double scrnHeight) {
		this.wRatio = pWidth / scrnWidth;
		this.hRatio = pHeight / scrnHeight;
		for (BodyPart part : parts) {
			part.normalizeToScrn(this.wRatio, this.hRatio);
		}
	}

	public boolean isReachThreshold(double x) {
		return (calcWidth((int) x) > (calcWidth((int) this.pWidth) * threshold));
	}

	/**
	 * Convert the image width to the screen width
	 * 
	 * @param f
	 * @return
	 */
	private int calcWidth(int f) {
		return (int) (f / wRatio);
	}

	public void add(BodyPart part) {
		parts.add(part);
	}

	public void addContainerTo(BodyPart part, List<ResultData> list) {
		PartsContainer container = new PartsContainer(list);
		container.setList(list);
		part.setContainer(container);
	}

	public BodyPart getPart(float x, float y, int sideShown, int sexShown) {
		for (BodyPart thisMap : parts) {
			// determine if the point is inside this body map
			if (thisMap.isInside(x, y, sideShown, sexShown)) {
				return thisMap;
			}
		}

		return null;

	}

}

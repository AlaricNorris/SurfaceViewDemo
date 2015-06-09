package com.example.alaricnorris.bodemapdemo;

import java.io.Serializable;

public class ResultData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String name;
	public String sortLetter;

	private int age;
	private int ADULT = 0;
	private int CHILD = 1;
	private int ALL = 2;

	public boolean isAdult() {
		if (age == ADULT)
			return true;
		else
			return false;
	}

	public void setAdult() {
		age = ADULT;
	}

	public boolean isChild() {
		if (age == CHILD)
			return true;
		else
			return false;
	}

	public void setChild() {
		age = CHILD;
	}
}

package com.example.alaricnorris.bodemapdemo;

import java.util.ArrayList;
import java.util.List;

public class PartsContainer {
	private List<ResultData> list;

	public PartsContainer(){
		list = new ArrayList<ResultData>();
	}
	
	public PartsContainer(List<ResultData> list) {
		this.list = list;
	}

	public void add(ResultData data) {
		list.add(data);
	}
	
	public void add(String id, String name){
		ResultData temp = new ResultData();
		temp.id = id;
		temp.name = name;
		list.add(temp);
	}

	public List<ResultData> getList() {
		return list;
	}

	public void setList(List<ResultData> data) {
		this.list = data;
	}
	
}
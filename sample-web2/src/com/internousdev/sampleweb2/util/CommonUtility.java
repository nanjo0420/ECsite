package com.internousdev.sampleweb2.util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtility {
	public String getRandomValue(){
		String value="";
		double d;
		for(int i=1; i <= 16; i++){
			d=Math.random() * 10;
			value=value+((int)d);
		}
		return value;
	}

	//ゲストユーザーにランダムのIDを与える


	public String[] parseArrayList(String s){
		return s.split(", ",0);
	}

	//Listを指定サイズ毎に分割


	public <E> List<List<E>> devideList(List<E> list, int size){
	//Listがnullまたは空の場合、もしくはsizeが0以下の場合は空のListを返す
		if(list == null || list.isEmpty() || size <= 0){
			return null;
		}
				int block = list.size() / size + (list.size() % size > 0 ? 1 : 0 );
				//true 1 faluse 0
		List<List<E>> devidedList = new ArrayList<List<E>>(block);
		for (int i = 0; i < block; i++){
			int start = i * size;
			int end = Math.min(start + size, list.size());
			devidedList.add(new ArrayList<E>(list.subList(start, end)));
		}
		return devidedList;
	}
}

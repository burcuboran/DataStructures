package test;

import java.util.*;
import java.util.Map.Entry;

public class WordCountComparator implements Comparator<Map.Entry<String,Integer>>{

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		
		int val = o2.getValue() - o1.getValue();
		
		if (val == 0) {
			val = o1.getKey().compareTo(o2.getKey());
		}
		
		return val;
	}

}
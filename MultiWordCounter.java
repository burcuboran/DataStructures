package textproc;

import java.util.HashMap;

public class MultiWordCounter implements TextProcessor {
	private HashMap<String, Integer> landscapes ;
	
	public MultiWordCounter(String[] ls) {
		//this.landscapes = ls;
		//this.n = new int[ls.length];
		
		landscapes = new HashMap<String, Integer>();
		for (int i=0;i<ls.length;i++) {
			landscapes.put(ls[i], 0);
		}	
	}
	
	public void process(String w) {
			for (String s: landscapes.keySet()) {				
				if (s.equals(w)) { // if an element of Hashmap matches the given word, 
					landscapes.put(s, landscapes.get(s)+1) ; //increase the counter by 1
			    } 
			}	
	}
	
	public void report() {
		
		for (String s: landscapes.keySet()) {
			System.out.println(s + ": " + landscapes.get(s));
		}
	}
	
}

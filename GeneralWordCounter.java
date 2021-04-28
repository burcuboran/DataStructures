package test;

// import java.io.File;
import java.util.*;

public class GeneralWordCounter implements TextProcessor {
	private Map<String, Integer> gwords = new TreeMap<String, Integer>();
	private Set<String> stopwords ;
	
	public GeneralWordCounter(Set<String> sw) {
		this.stopwords = sw;		
	}	
	
	public void process(String w) {
		//String a[] = w.split(" "); // split this text into an array of single words
		
		//for (String fw : stopwords ) { // loop for forbiden-words
		//	if (fw.equalsIgnoreCase(w)) return; // no need to go further if word is forbiden
		//}
		
		if (stopwords.contains(w)) return;
		
		// If map is empty, or map-element doesn't exist
		if (gwords.get(w)==null || gwords.isEmpty()) {
			gwords.put(w, 1);
		} else {		
			//for (String s: gwords.keySet()) { // loop for general-words to count	
			//gwords.get(w);
				//if (s.equalsIgnoreCase(w)) { // if an element of Hashmap matches the given word, 
					gwords.put(w, gwords.get(w)+1) ; //increase the counter by 1
					//return;
			    //} 
			//}
		}

	}
	
	public void report() {
			/*
			for (String s: gwords.keySet()) {
				if (gwords.get(s)>199) System.out.println(s + ": " + gwords.get(s));
			}
			*/
	
		Set<Map.Entry<String, Integer>> wordSet = gwords.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		
		wordList.sort(new WordCountComparator());
		 
		for (int i = 0; i < 5; i++) {
			System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
		}
		
		TreeSet<String> sorted = new TreeSet<String>(gwords.keySet());
		
		System.out.println("Gwords sorted alphabeticaly : ");
		
		String s = sorted.first();
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println(i + ": " + s);
			s = sorted.higher(s);
		}
				
	}
		

	public Set <Map.Entry<String, Integer> > getWords () {
		return gwords.entrySet();
	}
	
}

package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	public void process(String w) {

			if (word.equals(w)) { // if a single word matches the given word, 
		        n++; //increase the counter by 1
		    } 
	}

	public void report() {
		System.out.println(word + ": " + n);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
			
			TextProcessor p = new SingleWordCounter("nils");
	
			Scanner s = new Scanner(new File("nilsholg.txt"));
			s.findWithinHorizon("\uFEFF", 1);
			s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
			
			while (s.hasNext()) {
				String word = s.next().toLowerCase();

				p.process(word);
			}

			s.close();

			p.report();
	}

}

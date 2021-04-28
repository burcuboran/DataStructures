package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor n = new SingleWordCounter("norge");//D4 norge count
		TextProcessor mp = new MultiWordCounter(REGIONS);//D6
		
		Scanner s = new Scanner(new File("lab1/nilsholg.txt"));
//		s.findWithinHorizon("\uFEFF", 1);
//		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
//
//		// handeling Generalwords counter
		Scanner scan = new Scanner(new File("lab1/undantagsord.txt"));
		HashSet<String> stopwords = new HashSet<String>(); // a suitable set is instantiated
		// words are read from the scanner ’scan’
		// and saved in the set
		while (scan.hasNext()) {
			String word = scan.next();
			stopwords.add(word);			
		}
//		scan.close();		
		TextProcessor r = new GeneralWordCounter(stopwords);		
		
		long t0 = System.nanoTime();
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			//p.process(word);
			//n.process(word);//D4 norge count
			mp.process(word);//D5-6
			r.process(word);//D7
		}
		long t1 = System.nanoTime();

		s.close();
		
		//p.report();
		
		System.out.println(""); System.out.println("D4:");
		//n.report();//D4 norge count
		
		
		System.out.println(""); System.out.println("D5-6:");
		mp.report();
		
		
		System.out.println(""); System.out.println("D7-8:");		
		r.report();
		
		System.out.println("time of excution: " + (t1 - t0) / 1000000.0 + " ms");
	}
}
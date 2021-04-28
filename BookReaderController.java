package test;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class BookReaderController extends Application{
	GeneralWordCounter q;

	public static void main(String[] args) {
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		Scene scene = new Scene(root,470, 450);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Scanner s = new Scanner(new File("lab3/nilsholg.txt"));
		Scanner scan = new Scanner(new File("lab3/undantagsord.txt"));
		
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		Set<String> undantagsord = new HashSet<String>();
		
		q = new GeneralWordCounter(undantagsord);
		
		while(scan.hasNext()) {
			String word = scan.next().toLowerCase();
			undantagsord.add(word);
		}
		
		
		while (s.hasNext()) {
				String word = s.next().toLowerCase();
				q.process(word);
		}
		
		ObservableList<Map.Entry<String, Integer>> words = FXCollections.observableArrayList(q.getWords());
		ListView<Map.Entry<String, Integer>> listView = new ListView<Map.Entry<String, Integer>>(words);
		
		s.close();
		scan.close();
		
		root.setTop(listView);
		
		HBox hbox = new HBox(2);
		HBox hbox2 = new HBox(2);
		
		Button Alphabetic = new Button ("Alphabetic Des");
		Button Alphabetic2 = new Button ("Alphabetic Asc");
		Button Frequency = new Button ("Frequency Des");
		Button Frequency2 = new Button ("Frequency Asc");
		Button Find = new Button("Find");
		TextField tf = new TextField("Type a text to find");
		hbox.getChildren().addAll(Alphabetic, Alphabetic2, Frequency, Frequency2);
		hbox2.getChildren().addAll(Find, tf);

		root.setCenter(hbox);
		root.setBottom(hbox2);
		
		Frequency.setOnAction(event -> words.sort((m1, m2)-> m2.getValue().compareTo(m1.getValue())));
		Alphabetic.setOnAction(event -> words.sort((m1, m2)-> m2.getKey().compareTo(m1.getKey())));
		Frequency2.setOnAction(event -> words.sort((m1, m2)-> m1.getValue().compareTo(m2.getValue())));
		Alphabetic2.setOnAction(event -> words.sort((m1, m2)-> m1.getKey().compareTo(m2.getKey())));

		Find.setOnAction(event ->{
			for (Map.Entry<String,Integer> txt: words){
				if (txt.getKey().equals(tf.getText().toLowerCase())){
					listView.scrollTo(txt);
				}
			}
		});
	
	}

	
}



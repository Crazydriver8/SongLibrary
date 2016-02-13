package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SongLibraryController {
	@FXML ListView<String> listView;
	@FXML Button add;
	@FXML Button edit;
	@FXML Button delete;
	@FXML TextField name;
	@FXML TextField artist;
	@FXML TextField album;
	@FXML TextField year;
	
	ListView<String> list = new ListView<String>();
	ObservableList<String> data = FXCollections.observableArrayList("temp", "temp");
	
	public void start() {
		listView.setItems(data);
	}
	//set up the list view
	public ListView<Music> getListView(ObservableList<Music> obList) {
		ListView<Music> listView = new ListView<Music>(obList);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);
        
        /*listView.getSelectionModel().selectedItemProperty().addListener(
        	new ChangeListener<String>() {
    	       	@SuppressWarnings("unused")
				public void changed(ObservableValue<? extends String> ov, String oldVal, String newVal) {
    	       		System.out.println("Selected: " + newVal);
    	       		//behavior for viewing data associated with name
    	       	}
        	}
        );*/
        
        return listView;
	}
	
	//make a list
	public ObservableList<String> makeObservableArrayList(ArrayList<String> arList) {
		ObservableList<String> obList = FXCollections.observableArrayList(arList);
		return obList;
	}
	
	//read from user defined file for data
	public ArrayList<String> read(String path) throws FileNotFoundException {
		Scanner s = new Scanner(new File(path));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
			list.add(s.next());
		}
		s.close();
		return list;
	}
	
	//Get which button was pressed and act
	public void convert(ActionEvent e) {
		Button b = (Button)e.getSource();
		if (b == add) {
			System.out.println("add pressed");
		}
		if (b == edit) {
			System.out.println("edit pressed");
		}
		if (b == delete) {
			System.out.println("delete pressed");
		}
	}
	
	//add button behavior
	
	//edit button behavior
	
	//delete button behavior
	
}

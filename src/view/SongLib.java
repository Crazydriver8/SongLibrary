package view;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Music;

public class SongLib {
	private Stage primaryStage;

    // ... AFTER THE OTHER VARIABLES ...

    /**
     * The data as an observable list of Musics.
     */
    private ObservableList<Music> MusicData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public void Main() {
        // Add some sample data
        MusicData.add(new Music("Golddigger", "temp"));
        MusicData.add(new Music("Waves", "temp"));
        MusicData.add(new Music("Wonderful", "temp"));
        MusicData.add(new Music("High Fashion", "temp"));
        MusicData.add(new Music("Real Friends", "temp"));
        MusicData.add(new Music("3500", "temp"));
        MusicData.add(new Music("White Iverson", "temp"));
        MusicData.add(new Music("Initiation", "temp"));
        MusicData.add(new Music("A-Team", "temp"));
    }

    /**
     * Returns the data as an observable list of Musics. 
     * @return
     */
    public ObservableList<Music> getMusicData() {
        return MusicData;
    }

    // ... THE REST OF THE CLASS ...
	
    
	/*@Override
	public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Song Library");
	        
	        

	        initRootLayout();

	        showSongOverview();
	    }*/

	private void showSongOverview() {
		 try {
		        // Load song overview.
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(SongLib.class.getResource("view/songOverview.fxml"));
		        AnchorPane personOverview = (AnchorPane) loader.load();


		        // Give the controller access to the main app.
		        MusicOverviewController controller = loader.getController();
		        controller.setSongLib(this);

		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}		
	

	public void initRootLayout(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/songoverview.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			MusicOverviewController control = loader.getController();
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}

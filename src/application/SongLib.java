package application;
/*
 * author Bilal Bari and Brandon Berrios
 */
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.Music;
import view.MusicEdit;
import view.MusicOverviewController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class SongLib extends Application {
	

    private Stage primaryStage;

    // ... AFTER THE OTHER VARIABLES ...

    /**
     * The data as an observable list of Musics.
     */
    private ObservableList<Music> MusicData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public SongLib() {
        // Add some sample data
        MusicData.add(new Music("Golddigger", ""));
        MusicData.add(new Music("Waves", ""));
        MusicData.add(new Music("Wonderful", ""));
        MusicData.add(new Music("High Fashion", ""));
        MusicData.add(new Music("Real Friends", ""));
        MusicData.add(new Music("3500", ""));
        MusicData.add(new Music("White Iverson", ""));
        MusicData.add(new Music("Initiation", ""));
        MusicData.add(new Music("A-Team", ""));
    }

    /**
     * Returns the data as an observable list of Musics. 
     * @return
     */
    public ObservableList<Music> getMusicData() {
        return MusicData;
    }

    // ... THE REST OF THE CLASS ...
	
    
	@Override
	public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Song Library");
	        
	        initRootLayout();

	        showSongOverview();
	    }

	private void showSongOverview() {
		 try {
		        // Load song overview.
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(SongLib.class.getResource("view/songOverview.fxml"));
		        AnchorPane SongOverview = (AnchorPane) loader.load();


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
	
	
	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	/**
	 * Opens a dialog to edit details for the specified Songs. If the user
	 * clicks OK, the changes are saved into the provided music object and true
	 * is returned.
	 * 
	 * @param music the music object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showPersonEditDialog(Music music) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(SongLib.class.getResource("view/MusicEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit music");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        MusicEdit controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setmusic(music);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}

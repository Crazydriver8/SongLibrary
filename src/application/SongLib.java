package application;
/*
 * author Bilal Bari and Brandon Berrios
 */
	
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Music;
import view.MusicOverviewController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


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
    public void Constructor() {
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
	
    
	public void init(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Song Library");
	        
	        

	        initRootLayout();

	        showSongOverview();
	    }

	private void showSongOverview() {
		 // Load song overview.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SongLib.class.getResource("view/songOverview.fxml"));
		// Give the controller access to the main app.
		MusicOverviewController controller = loader.getController();
		controller.setSongLib(this);
		}		
	

	public void initRootLayout(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/songoverview.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
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

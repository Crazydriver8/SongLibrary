package view;
/*
 * author Bilal Bari and Brandon Berrios
 */

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;


public class MusicOverviewController {
    @FXML
    private ListView<Music> MusicTable;
    @FXML
    private ListView<Music> SongTitleColumn;
    @FXML
    private ListView<Music> ArtistColumn;
   

    @FXML
    private Label SongTitleLabel;
    @FXML
    private Label ArtistLabel;
    @FXML
    private Label AlbumLabel;
    @FXML
    private Label YearLabel;
   

    // Reference to the main application.
    private SongLib SongLib;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MusicOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     * @param <SongTitleColumn>
     */
    @FXML
    private void initialize() {
        // Initialize the Music table with the two columns.
        SongTitleColumn.setCellFactory(cellData -> ((Object) cellData).getValue().SongTitleProperty());
       
		ArtistColumn.setCellFactory(cellData -> ((Object) cellData).getValue().ArtistProperty());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * @param <SongLib>
     * 
     * @param SongLib
     */
    @SuppressWarnings("unchecked")
	public <SongLib> void setSongLib(view.SongLib SongLib) {
        this.SongLib = SongLib;

        // Add observable list data to the table
        MusicTable.setItems(((SongLib) SongLib).getMusicData());
    }
    
    /**
     * Fills all text fields to show details about the Music.
     * If the specified Music is null, all text fields are cleared.
     * 
     * @param Music the Music or null
     */
    private void showMusicDetails(Music music) {
        if (music != null) {
            // Fill the labels with info from the Music object.
            ArtistLabel.setText(music.getSongTitle());
            ArtistLabel.setText(music.getArtist());
            AlbumLabel.setText(music.getAlbum());
            YearLabel.setText(Integer.toString(music.getYear()));
           
            // TODO: We need a way to convert the birthday into a String! 
            // birthdayLabel.setText(...);
        } else {
            // Music is null, remove all the text.
            SongTitleLabel.setText("");
            ArtistLabel.setText("");
            AlbumLabel.setText("");
            YearLabel.setText("");
            
        }
    }

    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteMusic() {
        int selectedIndex = MusicTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            MusicTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(SongLib.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Music Selected");
            alert.setContentText("Please select some Music in the table.");

            alert.showAndWait();
        }
    }
}
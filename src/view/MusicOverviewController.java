package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
//import javafx.scene.control.ListColumn;
import javafx.scene.control.ListView;
import application.SongLib;


public class MusicOverviewController {
    @FXML
    private ListView<Music> MusicTable;
    @FXML
    private ListCell<Music> SongTitleColumn;
   

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
    /*@FXML
    private <SongTitleColumn> void initialize() {
        // Initialize the Music table with the two columns.
        SongTitleColumn.setCellValueFactory(cellData -> cellData.getValue().SongTitleProperty());
        Object ArtistColumn;
		ArtistColumn.setCellValueFactory(cellData -> cellData.getValue().ArtistProperty());
    }*/

    /**
     * Is called by the main application to give a reference back to itself.
     * @param <SongLib>
     * 
     * @param SongLib
     */
    public void setSongLib(SongLib SongLib) {
        this.SongLib = SongLib;

        // Add observable list data to the table
        MusicTable.setItems(((SongLib) SongLib).getMusicData());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
    private void showPersonDetails(Music music) {
        if (music != null) {
            // Fill the labels with info from the person object.
            ArtistLabel.setText(music.getSongTitle());
            ArtistLabel.setText(music.getArtist());
            AlbumLabel.setText(music.getAlbum());
            YearLabel.setText(Integer.toString(music.getYear()));
           
            // TODO: We need a way to convert the birthday into a String! 
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            SongTitleLabel.setText("");
            ArtistLabel.setText("");
            AlbumLabel.setText("");
            YearLabel.setText("");
            
        }
    }
}
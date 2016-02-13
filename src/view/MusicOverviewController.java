package view;
import application.SongLib;
/*
 * author Bilal Bari and Brandon Berrios
 */

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


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
    @FXML
    private Label label;
   

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
        SongTitleColumn.setCellFactory(cellData -> cellData.getValue().SongTitleProperty());
       
		ArtistColumn.setCellFactory(cellData -> cellData.getValue().ArtistProperty());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * @param <SongLib>
     * 
     * @param SongLib
     */
    @SuppressWarnings({ "unchecked", "hiding" })
	public <SongLib> void setSongLib(SongLib SongLib) {

        // Add observable list data to the table
        MusicTable.setItems((ObservableList<Music>) SongLib.getUserData());
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
            alert.setHeaderText("No song Selected");
            alert.setContentText("Please select some Music in the table.");

            alert.showAndWait();
        }
    }

/**
 * Opens a dialog to edit details for the specified Music. If the user
 * clicks OK, the changes are saved into the provided Music object and true
 * is returned.
 * 
 * @param Music the Music object to be edited
 * @return true if the user clicked OK, false otherwise.
 */
public boolean showMusicEditDialog(Music Music) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SongLib.class.getResource("view/MusicEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Music");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(SongLib);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the Music into the controller.
        MusicEdit controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setmusic(Music);

        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new song.
     */
    @FXML
    private void handleNewMusic() {
        Music tempMusic = new Music();
        boolean okClicked = SongLib.showPersonEditDialog(tempMusic);
        if (okClicked) {
            SongLib.getMusicData().add(tempMusic);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected Music.
     */
    @FXML
    private void handleEditMusic() {
        Music selectedMusic = MusicTable.getSelectionModel().getSelectedItem();
        if (selectedMusic != null) {
            boolean okClicked = SongLib.showPersonEditDialog(selectedMusic);
            if (okClicked) {
                showMusicDetails(selectedMusic);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(SongLib.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No song Selected");
            alert.setContentText("Please select a song in the table.");

            alert.showAndWait();
        }
    }
}
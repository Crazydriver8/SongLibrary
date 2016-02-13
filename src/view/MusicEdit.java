package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.Music;

public class MusicEdit {

    @FXML
    private TextField SongNameField;
    @FXML
    private TextField ArtistField;
    @FXML
    private TextField AlbumField;
    @FXML
    private TextField YearField;
   

    private Stage dialogStage;
    private Music music;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the music to be edited in the dialog.
     * 
     * @param music
     */
    public void setmusic(Music music) {
        this.music = music;

        SongNameField.setText(music.getSongTitle());
        ArtistField.setText(music.getArtist());
        AlbumField.setText(music.getAlbum());
        YearField.setText(Integer.toString(music.getYear()));
        
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            music.setArtist(SongNameField.getText());
            music.setArtist(ArtistField.getText());
            music.setAlbum(AlbumField.getText());
            music.setYear(Integer.parseInt(YearField.getText()));
           
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (SongNameField.getText() == null || SongNameField.getText().length() == 0) {
            errorMessage += "Enter something!\n"; 
        }
        if (ArtistField.getText() == null || ArtistField.getText().length() == 0) {
            errorMessage += "Enter something!\n"; 
        }
        if (AlbumField.getText() == null || AlbumField.getText().length() == 0) {
            errorMessage += "Enter something!\n"; 
        }

        if (YearField.getText() == null || YearField.getText().length() == 0) {
            errorMessage += "Not a number!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(YearField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Not a valid year (must be an integer)!\n"; 
            }
        }

     
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}

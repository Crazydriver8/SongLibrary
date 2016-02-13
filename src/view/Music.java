package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Music {

	private final StringProperty SongTitle;
    private final StringProperty Artist;
    private final StringProperty Album;
    private final IntegerProperty Year;

    /**
     * Default constructor.
     */
    public Music() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param SongTitle
     * @param Artist
     */
    public Music(String SongTitle, String Artist) {
        this.SongTitle = new SimpleStringProperty(SongTitle);
        this.Artist = new SimpleStringProperty(Artist);

        // Some initial dummy data, just for convenient testing.
        this.Album = new SimpleStringProperty("some Album");
        this.Year = new SimpleIntegerProperty(1234);
    }

    public String getSongTitle() {
        return SongTitle.get();
    }

    public void setSongTitle(String SongTitle) {
        this.SongTitle.set(SongTitle);
    }

    public StringProperty SongTitleProperty() {
        return SongTitle;
    }

    public String getArtist() {
        return Artist.get();
    }

    public void setArtist(String Artist) {
        this.Artist.set(Artist);
    }

    public StringProperty ArtistProperty() {
        return Artist;
    }

    public String getAlbum() {
        return Album.get();
    }

    public void setAlbum(String Album) {
        this.Album.set(Album);
    }

    public StringProperty AlbumProperty() {
        return Album;
    }

    public int getYear() {
        return Year.get();
    }

    public void setYear(int Year) {
        this.Year.set(Year);
    }

    public IntegerProperty YearProperty() {
        return Year;
    }
}
  

  
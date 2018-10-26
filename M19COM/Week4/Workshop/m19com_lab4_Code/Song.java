/**
 * Class to represent songs     ** DO NOT MODIFY **
 * @author Alkis Stavrinides
 * @version 1.2 - 30/1/12 (Exercise_5 for m19com Lab4)
 */
public class Song implements Comparable<Song>
{
    private String artist;
    private String album;
    private String title;
    
    /**
     * Full constructor only
     */
    public Song(String artist, String album, String title)
    {
        this.artist = artist;
        this.album = album;
        this.title = title;
    }
    
    /**
     * Get the song's artist
     * @return  the artist
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Get the song's album
     * @return  the album
     */
    public String getAlbum()
    {
        return album;
    }
    
    /**
     * Get the song's title
     * @return  the title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Override default equals based on string representation
     * @param obj  the object we are comparing against
     * @return  true if same string reps, else false
     */
    public boolean equals(Object other)
    {
        if(!(other instanceof Song)) return false;
        return this.toString().equals(((Song) other).toString());
    }
    
    /**
     * Implement Comparable based on string representation
     * @param other  the object we are comparing against
     * @return  same as compareTo() of string reps
     */
    public int compareTo(Song other)
    {
        return this.toString().compareTo(other.toString());
    }
    
    /**
     * Return a string with artist, album and song title
     * concatenated in that order, separated by vertical bars
     * @return  a printable string representation 
     */
    public String toString()
    {
        return artist + "|" + album + "|" + title;
    }
}

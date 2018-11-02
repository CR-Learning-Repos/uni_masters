import java.util.*;

/**
 * Class to represent a "playlist" of songs
 * @author Alkis Stavrinides
 * @version 1.2 - 30/1/12 (Exercise_5 for m19com Lab4)
 */
public class PlayList implements SongList
{
    public ArrayList<Song> Songs = new ArrayList<Song>();
    /**
     * Constructor
     */
    public PlayList()
    {
    }
    
    /**
     * Get the song at a given position in the list
     * @param ...
     * @return ...
     */
    public Song get(int i)
    {
        return Songs.get(i);
    }
    
   /**
     * Add a given song to the list
     * @param ...
     * @return ...
     */
    public boolean add(Song song)
    {
        return  Songs.add(song);
    }
    
	 
    /**
     * Remove a given song from the list
     * @param ...
     * @return ...
     */
    public boolean remove(Song song)
    {
        return  Songs.remove(song);
    }
    
	 
    /**
     * Add all songs from another song list 
     * @param ...
     * @return ...
     */
    public boolean merge(SongList list)
    {
        int size = list.size();
        for(int i = 0; i < size - 1; i++)
        {
         Song song = list.get(i);
         this.add(song);
        }
        
        return true;
    }    
	   
    
    /**
     * Check if the list contains a given song
     * @return ...
     */
    public boolean contains(Song song)
    {
        return Songs.contains(song);
    }
  
    
    /**
     * Find a song matching a given string
     * @param ...
     * @return ...
     */
    public Song find(String str)
    {
       return  Songs.stream()
        .filter((song) -> song.getTitle() == str)
         .findFirst().get();
    }
    
	 
    /**
     * Clear the list
     */
    public void clear()
    {
      Songs.clear();
    }
    
	 
    /**
     * Get the size of the list (= number of songs)
     * @return ...
     */
    public int size()
    {
        return Songs.size();
    }
	 
	 
	 /**
     * Get the size of the list (= number of songs)
     * @return ...
     */
	 public boolean sort()
	 {
         Songs.sort((p1, p2) -> p1.compareTo(p2));
	 		return true;
	 }
	 
    
    /**
     * Convert list to single string with \n after each song
     * @return ...
     */
    public String toString()
    {
         String var = "";
         
         for(Song song : Songs){
            var += song.getTitle();
         }
         
        return var;
    }
}

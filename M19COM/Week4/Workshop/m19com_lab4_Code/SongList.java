/**
 * Interface for a class representing jTunes song lists  ** DO NOT MODIFY **
 * @author Faiyaz Doctor
 * @version 1.3 - 18/10/12 (Exercise_5 for m19com Lab4)
 */
 
public interface SongList
{
	/**
	* Get the song at a given position in the list
	* @param i the list position (0 <= i < size())
	* @return the Song object at that position
	* @throws IndexOutOfBoundsException if i<0 or i>=size()
	*/
	public Song get(int i) throws IndexOutOfBoundsException;
	// POST: if i < 0 or i >= size() the exception is thrown,
	// else the song at position i in our list is returned


	/**
	* Add a given song to the list
	* @param song the song to add
	* @return true if successful, else false
	* @throws NullPointerException if song is null
	*/
	public boolean add(Song song) throws NullPointerException;
	// POST: if song is null the exception is thrown; else
	// the song is added to our list and true is returned,
	// or false if the song was not added for some reason


	/**
	* Remove a given song from the list
	* @param song the song to remove
	* @return true if successful, else false
	* @throws NullPointerException if song is null
	*/
	public boolean remove(Song song) throws NullPointerException;
	// POST: if song is null the exception is thrown; othewise
	// if the song is not in our list false is returned, else
	// one instance of the song is removed and true is returned


	/**
	* Add all songs from another song list
	* @param list the other song list
	* @return true if at least 1 song added, else false
	* @throws NullPointerException if list is null
	*/
	public boolean merge(SongList list) throws NullPointerException;
	// POST: if list is null the exception is thrown; otherwise
	// each song in the given list is added if possible, and
	// true is returned if at least 1 song was added, else false


	/**
	* Check if a given song is in the list
	* @param song the song to search for
	* @return true if song in the list, else false
	* @throws NullPointerException if song is null
	*/
	public boolean contains(Song song) throws NullPointerException;
	// POST: if song is null the exception is thrown; otherwise
	// if the given song is found true is returned, else false

	
	/**
	* Find a song matching a given string
	* @param str the string to be matched
	* @return a matching song, or null if no match
	* @throws NullPointerException if str is null
	*/
	public Song find(String str) throws NullPointerException;
	// POST: if str is null the exception is thrown; otherwise
	// if a song is found whose string representation contains
	// the given string then that song is returned, else null

	
	/**
	* Clear the list
	*/
	public void clear();
	// POST: the list is cleared (made empty)


	/**
	* Get the size of the list (= number of songs)
	* @return the list size
	*/
	public int size();
	// POST: the list size (= number of songs) is returned
	
	
	/**
    * Sort the list of songs into ascending order by title
    * @return true if successful, else false
    */
   public boolean sort();
   // POST: the list of songs are sorted in ascending order by title
   // if the list is not sorted false is returned, else true is returned
	
	
	/**
	* Convert list to a single string with \n after each song
	* @return the string as above
	*/
	public String toString();
	// POST: a string is returned of the form “S0\nS1\nS2\n...”
	// where each Si is the string representation of ith song	
	
}
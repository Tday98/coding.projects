/** @author your_name
 */

public class Playlist {

    //TODO: Declare class variables
    String[] nextFive;

    public Playlist() {
        //TODO: Playlist constructor definition
        nextFive = new String[5];
    }

    /** @param songName
     *   @return boolean of whether the song was added successfully or not
     */
    public boolean makeRequest(String songName) {
        //TODO: makeRequest definition
        if (!searchList(songName)) {
            addSong(songName);
            return true;
        }
        return false;
    }

    /** @param songName
     *	  @return boolean of whether the song is in the list
     */
    private boolean searchList(String songName) {
        //TODO: getReward definition
        for (int i = 0; i < nextFive.length; i++) {
            if (nextFive[i] != null && nextFive[i].equals(songName)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /** @param songName
     */
    private void addSong(String songName) {
        //TODO: addSong definition
        for (int i = 0; i < nextFive.length; i++) {
            if (nextFive[i] == null) {
                nextFive[i] = songName;
                break;
            }
        }
    }

    /** @return String next song in the list
     */
    public String getNextSong() {
        //TODO: getNextSong definition
        String nextSong = nextFive[0];
        for (int i = 0; i < nextFive.length; i++) {
            if (i <= 3) {nextFive[i] = nextFive[i+1];}
            else {nextFive[4] = null;}
        }
        return nextSong;
    }

    public static void main(String[] args) {
        //Do not alter this main method
        Playlist playlist = new Playlist();
        playlist.makeRequest("Hey Jude");
        playlist.makeRequest("Here Comes the Sun");
        playlist.makeRequest("Hey Jude");
        playlist.makeRequest("Penny Lane");
        System.out.println(playlist.getNextSong());
        System.out.println(playlist.getNextSong());
        System.out.println(playlist.getNextSong());
        playlist.makeRequest("I Want to Hold Your Hand");
        System.out.println(playlist.getNextSong());
    }

}
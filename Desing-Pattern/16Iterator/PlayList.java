import java.util.List;
import java.util.ArrayList;

class PlayList{

    private List<Song> songs;

    PlayList(){
        songs = new ArrayList<Song>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public Iterator playAllIterator(){
        return new PlayAll(songs);
    }

    public Iterator favouriteIterator(){
        return new Favourite(songs);
    }

    public Iterator shuffleIterator(){
        return new Shuffle(songs);
    }
};

import java.util.*;


class Shuffle implements Iterator{

    private List<Song> songs;
    private int index = 0;

    Shuffle(List<Song> songs){
        this.songs = new ArrayList<Song>();
        
        for(Song song : songs){
            this.songs.add(song);
        }

        Collections.shuffle(this.songs);
    }

    public boolean hasNext(){
        return this.index < this.songs.size();
    }

    public Song next(){
        return this.songs.get(this.index++);
    }
};
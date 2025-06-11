import java.util.List;
import java.util.ArrayList;


class PlayAll implements Iterator{

    private List<Song> songs;
    private int index = 0;

    PlayAll(List<Song> songs){
        this.songs = new ArrayList<Song>();
        this.songs = songs;
    }

    public boolean hasNext(){
        return this.index < this.songs.size();
    }

    public Song next(){
        return this.songs.get(this.index++);
    }
};
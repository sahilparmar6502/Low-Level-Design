import java.util.List;
import java.util.ArrayList;

class Favourite implements Iterator{

    private List<Song> songs;
    private int index = 0;

    Favourite(List<Song> songs){
        this.songs = new ArrayList<Song>();
        
        for(Song song : songs){
            if(song.isFavourite()){
                this.songs.add(song);
            }
        }
    }

    public boolean hasNext(){
        return this.index < this.songs.size();
    }

    public Song next(){
        return this.songs.get(this.index++);
    }
};
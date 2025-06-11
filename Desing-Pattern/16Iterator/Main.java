
public class Main{

    public static void playSong(Iterator iterator){
        while(iterator.hasNext()){
            System.out.println("Playing:"+iterator.next().getTitle());
        }
        System.out.println();
    }

    public static void main(String args[]){

        PlayList playList = new PlayList();
        playList.addSong(new Song("1song",true));
        playList.addSong(new Song("2song",true));
        playList.addSong(new Song("3song",false));
        playList.addSong(new Song("4song",true));
        playList.addSong(new Song("5song",false));

        Iterator playAll = playList.playAllIterator();
        Iterator favourite = playList.favouriteIterator();
        Iterator shuffle = playList.shuffleIterator();

        playSong(shuffle);
    }
};
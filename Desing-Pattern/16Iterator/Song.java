
class Song{
    private String title;
    private boolean fav;

    Song(String title,boolean fav){
        this.title = title;
        this.fav = fav;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean isFavourite(){
        return this.fav;
    }
};
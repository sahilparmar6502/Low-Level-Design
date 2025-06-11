
class Bidder{

    private String name;
    private AuctionMediator auction;

    public Bidder(String name,AuctionMediator auction){
        this.name = name;
        this.auction = auction;
    }

    public void placeBid(int amount){
        System.out.println(this.name+ "placed bid amount:" + amount);
        auction.placeBid(this,amount);
    }

    public String getName(){
        return this.name;
    }

    public void notify(String message){
        System.out.println(this.name + " notified: "+message);
    }
};
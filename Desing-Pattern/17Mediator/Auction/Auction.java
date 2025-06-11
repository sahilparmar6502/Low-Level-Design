import java.util.List;
import java.util.ArrayList;

class Auction implements AuctionMediator{

    private List<Bidder> bidders = new ArrayList<Bidder>();
    private int highestBid = 0;
    private Bidder highestBidder = null;

    public void registerBidder(Bidder bidder){
        this.bidders.add(bidder);
    }

    public void placeBid(Bidder bidder,int amount){
        if(amount > this.highestBid){
            this.highestBid = amount;
            this.highestBidder = bidder;

            for(Bidder b : this.bidders){
                if(b != bidder)
                    b.notify("New bid is placed. amount:"+amount+" by:"+bidder.getName());
            }
            System.out.println();
        }
        else{
            bidder.notify("your bid is too low.");
        }
    }
};

public class Main{

    public static void main(String args[]){

        AuctionMediator auction = new Auction();

        Bidder bidder1 = new Bidder("Alice",auction);
        Bidder bidder2 = new Bidder("Bob",auction);
        Bidder bidder3 = new Bidder("John",auction);

        auction.registerBidder(bidder1);
        auction.registerBidder(bidder2);
        auction.registerBidder(bidder3);

        bidder1.placeBid(340);
        bidder2.placeBid(320);
    }
};
package Utility;

import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;

// singleton pattern

public class Snake{
    private static Snake instance;
    private Deque<Pair> body;
    private Map<Pair,Boolean> positionMap;

    private Snake(){
        this.body = new LinkedList<>();
        this.positionMap = new HashMap<>();

        Pair inititalPos = new Pair(0,0);
        this.body.offerFirst(inititalPos);
        this.positionMap.put(inititalPos,true);
    }

    public static Snake getInstance(){
        
        if(instance == null){
            instance = new Snake();
        }
        return instance;
    }

    public Pair peekFirst(){
        return this.body.peekFirst();
    }

    public Pair peekLast(){
        return this.body.peekLast();
    }

    public void addFirst(Pair pair){
        this.body.addFirst(pair);
    }

    public void pollLast(){
        this.body.pollLast();
    }

    public void put(Pair pair){
        this.positionMap.put(pair,true);
    }

    public void remove(Pair pair){
        this.positionMap.remove(pair);
    }

    public int getSize(){
        return this.body.size();
    }

    public boolean bitesItself(Pair newHead){

        Pair currTail = this.body.peekLast();

        if(this.positionMap.containsKey(newHead) && !(newHead.getRow() == currTail.getRow() && newHead.getCol() == currTail.getCol())){
            return true;
        }
        return false;
    }
};
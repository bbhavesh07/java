import java.util.*;


//1. create a final class
//2. markk all members private final.
//3. if you have any reference variable make it immutable by making its clone(deep copy).
//4. If you have any collection as a member return its unmodifiable version.
//5. Create only getters and not setters.
final class Immutable{
    final private int totalScore;
    final private String name;
    final private Score object;
    final private List<Score> scores;
    Immutable(int totalScore, String name, Score object, List<Score> scores){
        this.totalScore = totalScore;
        this.name = name;
        this.object = object;
        this.scores = scores;
    }
    public int getTotalScore(){
        return this.totalScore;
    }
    public String getName(){
        return this.name;
    }
    public Score getScore(){
        return this.object.clone(); //this must be deep copy and not shallow copy
    }
    public List<Score> getScores(){ // unmodifiableList is a wrapper which throws exceptions for add/set/remvoe
        return Collections.unmodifiableList(new ArrayList<Score>(this.scores));
        //please note new ArrayList inside unmodifiableList, if you pass original list there is a problem
        //because one who passed list in constructor has the reference to list and he can still modify this list.
        //In constructor itself we can create a new unmodifiable list and assign it so that nobody has a reference.
    }
}

class Score implements Cloneable{
    int score;
    int category;
    Score(int score, int cat){
        this.score = score;
        this.category = cat;
    }
    protected Score clone(){
        try{
            return (Score)super.clone(); //this is shallow copy, but ok for now because members are primitive
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
}
public class ImmutableEx {
    public static void main(String args[]){
        Immutable immutable = new Immutable(10, "Bhavesh", new Score(1, 1),
                new ArrayList<Score>(){
                {
                    add(new Score(1, 1));
                }});

        Set<String> set = new HashSet(Arrays.asList("O_ACH,O_ST,O,Top,W,ST,ALL_RE,ALL_OR,ALL_MI,ALL_MO,OR_MI,OR_MO,RE_MI,RE_MO,ALL,ALL_MON,ABT_U,ABT_M,W_ABTUX,M_ABTUX,O_ABTUX,W_ABTMX,M_ABTMX,O_ABTMX,IDT,IIT,W_IDT_X,M_IDT_X,O_IDT_X,W_IIT_X,M_IIT_X,O_IIT_X,B_P2P,M_P2P,H_P2P,W_P2P,M_P2P_X,W_P2P_X,M_P2P_X,ACH,EDT_M,EDT_U,W_EDTMX,O_EDTMX,M_EDTMX,W_EDTUX,O_EDTUX,M_EDTUX,W_AEIT,O_AEIT,B_AEIT,H_AEIT,M_AEIT,EIT,M_EIT_X,W_EIT_X,O_EIT_X,M_AEITX,W_AEITX,O_AEITX".split(",")));
        Set<String> code = new HashSet(Arrays.asList("O_EDTMX,O_EIT_X,W_AEITX,O_IDT_X,O_ACH_X,O_ABTMX,H_P2P,O_AEIT,M_IIT_X,IDT,O_ABTUX,O_EDTUX,W_IIT_X,O_AEITX,ALL_MON,W_P2P,EIT,Top,IIT,W_IDT_X,W_ST_X,M_AEIT,M_IDT_X,M_ACH_X,W_ABTUX,M_ABTMX,M_EDTMX,W_P2P_X,EDT_U,M_ABTUX,M_P2P_X,M_EDTUX,EDT_M,O,H_AEIT,O_IIT_X,ABT_M,M_P2P,B_AEIT,W_EDTUX,W_ACH_X,ABT_U,O_ST_X,W_ABTMX,M_EIT_X,W_EDTMX,ST,ACH,M_AEITX,W_EIT_X,M_ST_X,O_ACH,O_ST,W_AEIT,B_P2P".split(",")));
        /*for(String slice: set){
            if(!code.contains(slice))
                System.out.println(slice);
        }*/

        for(String slice: code){
            if(!set.contains(slice))
                System.out.println(slice);
        }
    }
}

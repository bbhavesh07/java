import java.util.*;
public class FindCyclicWord {
    public static Integer cyclicString( String str ) {
        char ch = str.charAt(0);
        int res = 0, ind = 0;
        int len = str.length();
        List<Integer> poss = new ArrayList();
        while((ind = str.indexOf(ch, ++ind)) != -1){
            poss.add(ind);
        }
        for(int pos: poss){
            int tmp = pos;
            int start = 0;
            boolean found  = true;
            while(tmp < len){
                if(start >= tmp || str.charAt(start) != str.charAt(tmp)){
                    found  = false;
                    break;
                }
                tmp++;
                start++;
            }
            //System.out.println(pos + " " + tmp + " " + start);
            if(found)
                return pos;

        }
        return len;
    }
}
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test12 {
    static class User{
        private int id;
        private String name, email;
    }
    private static void removeDup(List<User> users){
        Set<String> set = new HashSet();
        for(int i = 0; i < users.size(); i++){
            if(set.contains(users.get(i).email))
                users.remove(i);
            else set.add(users.get(i).email);
        }
    }
    private static String convert(int num){
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        while(num > 0){
            if(cnt == 3 || (cnt > 3 && cnt % 2 != 0)){
                res.append(",");
            }
            res.append(num % 10);
            num = num / 10;
            cnt++;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(Test12.convert(100000));
    }
}

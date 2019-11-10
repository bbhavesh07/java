import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static boolean isMatch(String s, String p) {
        Matcher matcher = Pattern.compile(p).matcher(s);
        return matcher.matches();
    }

    public static void main(String arg[]){
        System.out.println(isMatch("abbabc", ".*b.*ab."));
    }
}

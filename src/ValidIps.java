import java.util.ArrayList;
import java.util.List;

//asonawane@qualys.com

public class ValidIps {
    private static List<String> res = new ArrayList<String>();
    static void generateValidIpsRec(String str, int count, String ip, int idx) {
            if (isValidIp(ip, str.length()))
                res.add(ip);
            if (idx >= str.length())
                return;
            if (count < 3) {
                generateValidIpsRec(str, count, ip + str.charAt(idx), idx + 1);
                generateValidIpsRec(str, ++count, ip + str.charAt(idx)+ ".", idx + 1);
            }
            else {
                generateValidIpsRec(str, count, ip + str.charAt(idx), idx + 1);
            }
    }
    public static void main(String[] args){
        generateValidIps("1256698");
        for(String ip: res)
            System.out.println(ip);
        res = new ArrayList<>();
        System.out.println("My Results:");
        generateValidIpsRec("1256698", 0, "", 0);
        for(String ip: res)
            System.out.println(ip);
    }

    private static void generateValidIps(String str) {
        int size = str.length();
        if (size < 3 || size > 12)
            return;
        String ip = str;
        for(int i = 1; i < size - 2; i++) {
            for(int j = i + 1; j < size - 1; j++) {
                for(int k = j + 1; k < size; k++) {
                    ip = ip.substring(0, k) + "." + ip.substring(k);
                    ip = ip.substring(0, j) + "." + ip.substring(j);
                    ip = ip.substring(0, i) + "." + ip.substring(i);

                    if(isValidIp(ip)) {
                        res.add(ip);
                    }
                    ip = str;
                }
            }
        }

    }
    private static boolean isValidIp(String ip, int len)
    {
        String a[] = ip.split("[.]");
        if(a.length != 4 || ip.length() != len+3) return false;
        for(String s : a) {
            if(s.isEmpty()) return false;
            int i = Integer.parseInt(s);
            if(s.length() > 3 || i < 0 || i > 255)
                return false;
            if(s.length() > 1 && i == 0)
                return false;
            if(s.length() > 1 && s.charAt(0) == '0')
                return false;
        }

        return true;
    }

    private static boolean isValidIp(String ip)
    {
        String a[] = ip.split("[.]");
        for(String s : a) {
            int i = Integer.parseInt(s);
            if(s.length() > 3 || i < 0 || i > 255)
                return false;
            if(s.length() > 1 && i == 0)
                return false;
            if(s.length() > 1 && s.charAt(0) == '0')
                return false;
        }

        return true;
    }
}

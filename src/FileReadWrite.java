import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileReadWrite {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("C:\\ifm5\\create-image\\KI\\ifm-main\\src\\main\\java\\com\\actimize\\fraud\\ki\\library\\tree.txt"));
        br.lines().filter(s->s.toLowerCase().contains("ki.java")).forEach(s->System.out.println(s));
    }
}

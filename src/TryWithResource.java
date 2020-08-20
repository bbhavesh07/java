import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResource {
    public static void main(String[] args) throws Exception{
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) { // both scanner and printer are closed at the end of try
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        }
    }
}
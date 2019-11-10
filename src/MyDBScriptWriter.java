import java.io.*;

public class MyDBScriptWriter {
    String fileName = "C:\\Actimize\\svn\\fraud_framework\\Sparkathon\\script.sql";
    BufferedWriter bufferedWriter =null;
    FileWriter fileWriter = null;
    public MyDBScriptWriter(){

        try {
            // Assume default encoding.
            this.fileWriter =
                    new FileWriter(this.fileName);

            // Always wrap FileWriter in BufferedWriter.
            this.bufferedWriter =
                    new BufferedWriter(fileWriter);
        }
        catch(IOException ex) {
            System.out.println(
                    "Error creating buffered writer to file '"
                            + this.fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

    }
    public void write(String line) {
        try {
            this.bufferedWriter.write(line);
            this.bufferedWriter.newLine();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error creating buffered writer to file '"
                            + this.fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }


    }
    public void close() {
        try {
            this.bufferedWriter.close();
        }
        catch(IOException ex) {
                System.out.println(
                        "Error creating buffered writer to file '"
                                + this.fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }
    }
}

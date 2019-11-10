import java.io.*;

public class MyCSVReader {
    public static void main(String [] args) {
        MyDBScriptWriter dbScriptWriter = new MyDBScriptWriter();

        // The name of the file to open.
        String fileName = "C:\\Actimize\\svn\\fraud_framework\\Sparkathon\\temp.csv";

        // This will reference one line at a time
        String line = null;
        String sqlLine = "";
        String lineArr[] = new String[30];

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            dbScriptWriter.write("set define off;");
            while((line = bufferedReader.readLine()) != null) {
                lineArr = line.split(",");
                String merchant = "'";
                sqlLine ="";
                for(int i = 0; i < lineArr.length; i++){
                    lineArr[i].replaceAll("'", "\''");
                    //lineArr[i].replaceAll("&", "\\&");
                    switch (i){
                        case 0:
                            sqlLine += lineArr[0] + ",";
                            break;
                        case 1:
                            sqlLine += lineArr[0] + ",";
                            break;
                        case 2 :
                            sqlLine = sqlLine + "'" + lineArr[2] + "',";
                            break;
                        case 3 :
                            sqlLine = sqlLine + "'" + lineArr[3] + "',";
                            break;
                        case 4 :
                            sqlLine = sqlLine + "'" + lineArr[4] + "',";
                            break;
                        case 5 :
                            sqlLine = sqlLine + "'" + lineArr[5] + "',";
                            break;
                         case 6:
                            sqlLine += lineArr[0] + ",";
                            break;
                        case 7 :
                            sqlLine = sqlLine + "'" + lineArr[7] + "',";
                            break;
                        case 8 :
                            sqlLine = sqlLine + "TO_DATE('" + lineArr[8] + "', 'MM/DD/YYYY HH:MI:SS AM'),";
                            break;
                        case 9 :
                            sqlLine = sqlLine + "TO_DATE('" + lineArr[9] + "', 'MM/DD/YYYY HH:MI:SS AM'),";
                            break;
                        /*case 10 :
                            sqlLine = sqlLine + "'" + lineArr[10] + "',";
                            break;*/
                        default:
                            merchant += lineArr[i];
                            break;

                    }


                }
                sqlLine += merchant + "')";
                sqlLine = "INSERT INTO TRANSACTIONS VALUES(" + sqlLine +";";
                dbScriptWriter.write(sqlLine);

            }
            dbScriptWriter.write("commit;");
            dbScriptWriter.close();
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}

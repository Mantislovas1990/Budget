package Model;

import java.io.*;
import java.util.List;

public class File {

    public void saveRecordToCsv(List<Record> list)  {

        try{
            FileWriter fileWriter = new FileWriter("records.csv",false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println();
        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}

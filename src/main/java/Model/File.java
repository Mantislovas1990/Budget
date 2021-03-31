package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

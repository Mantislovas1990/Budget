package model.jason_serializer.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import service.BudgetServiceImpl;

import java.io.File;
import java.io.IOException;

public class SaveRecord {


    public void saveRecordsToFile(BudgetServiceImpl list) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File("Records.json"), list.getAllRecords());

    }
}

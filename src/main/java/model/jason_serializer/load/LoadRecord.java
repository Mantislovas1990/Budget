package model.jason_serializer.load;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.budget.Record;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoadRecord {

    public List<Record> loadRecordsFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File("Records.json"), new TypeReference<List<Record>>() {});
    }
}



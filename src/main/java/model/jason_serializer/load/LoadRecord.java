package model.jason_serializer.load;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.budget.Record;


import java.io.IOException;
import java.util.List;

public class LoadRecord {
    public void loadRecordsFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.readValue("Records.json", new TypeReference<List<Record>>() {
        });
    }
}



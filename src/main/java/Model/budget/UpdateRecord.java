package Model.budget;

import Model.Record;
import Model.UpdatableRecord;

import java.util.List;

public interface UpdateRecord {

    List<Record> updateRecord(UpdatableRecord updatableRecord, int selectedId);

}

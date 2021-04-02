package model.budget;

import model.Enum.Category;

public interface UpdatableRecord {
     Double getSum();
     Category getCategory();
     String getAdditionalInfo();

}

package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("errorMessages")
public class ErrorMessageModel {
    @ExcelCellName("key")
    public String key;
    @ExcelCellName("errorMessage")
    public String errorMessage;

    public String getKey() {
        return key;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

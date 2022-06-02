package org.example.utilities;

import com.poiji.bind.Poiji;
import org.example.models.CredentialsModel;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final String EXCEL_PATH = "src/test/resources/data/testData.xlsx";
    private final Logs log = new Logs();

    public List<CredentialsModel> getCredentials() {
        log.debug("Leyendo credenciales: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), CredentialsModel.class);
    }
}

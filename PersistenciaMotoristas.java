import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PersistenciaMotoristas {
    private static final String SAMPLE_CSV_FILE_PATH = "motoristas.dat";

    public LinkedList<Motoristas> carregaMotoristas() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) { 
            LinkedList<Motoristas> listMotorista = new LinkedList<Motoristas>(); 
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String CPF = csvRecord.get(0);
                String Nome = csvRecord.get(1);
                String veic = csvRecord.get(2);
                FormaPGTO FormaPgto;
                switch(csvRecord.get(3)){
                    case "TODAS": 
                        FormaPgto = FormaPGTO.TODAS;
                        break;
                    case "CARTAO":
                        FormaPgto = FormaPGTO.CARTAO;
                        break;
                    default: 
                        FormaPgto = FormaPGTO.DINHEIRO;
                        break;             
                }
                listMotorista.add(new Motoristas(CPF, Nome, veic, FormaPgto));
            }
            return listMotorista;
        }
    }

    public void persisteMotoristas(LinkedList<Motoristas> list) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);){
            
        }
    } 
}
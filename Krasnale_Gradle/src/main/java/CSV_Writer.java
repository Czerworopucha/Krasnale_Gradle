import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CSV_Writer {
    public String filename;

    public CSV_Writer(String filename) {
        this.filename = filename;
    }

    public void saveSimulationData(String[] dataLine) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true), ',', CSVWriter.NO_QUOTE_CHARACTER)) {
            writer.writeNext(dataLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void flushCSVFile() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
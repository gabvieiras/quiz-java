package texto.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public String[][] readFile(String filePath) {
        String line;
        String cvsSplitBy = ",";
        String[][] questionsArray = new String[20][6];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Ignora a primeira linha (cabeçalho)
            br.readLine();


                // separa os campos do CSV
                for(int i =0; i < 20; i++) {
                    line = br.readLine();
                    for(int j =0; j < 6; j++) {
                        String[] data = line.split(cvsSplitBy);
                        questionsArray[i][j] = data[j];
                    }
                }
            return questionsArray;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

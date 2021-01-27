import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CollectData {

    String dataSet;

    public CollectData(String dataSet) {
        this.dataSet = dataSet;
    }

    // reads txt file into a string
    public String userDataIn() {
        String line = null;
        String inT = null;

        File file = new File(dataSet);

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Can't find file: " + file.toString());
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file.toString());
        }
        inT = sb.toString().replace("\t", " ");
        return inT;
    }

    // inserts data into 2D array
    public double[][] userData() {
        String userD = userDataIn();
        String[] results1 = userD.split(" ");

        double[] convertD = new double[results1.length];

        for (int i = 0; i < results1.length; i++) {
            convertD[i] = Double.parseDouble(results1[i]);
        }

        double[][] usr = new double[400][31];

        int k = 0;
        for (int i = 0; i < 400; i++) {

            for (int j = 0; j < 31; j++) {
                usr[i][j] = convertD[k++];
            }

        }

        return usr;
    }

}
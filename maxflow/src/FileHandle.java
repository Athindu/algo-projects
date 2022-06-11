import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandle {

    public static int[][] getGraph(String fileName) {


        Scanner sc = null;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int nodes = MaxFlow.V;

        int[][] myArray = new int[nodes][nodes];
        while (sc.hasNextLine()) {
            for (int i = 0; i < myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    myArray[i][j] = Integer.parseInt(line[j]);
                }
            }
        }

        return myArray;
    }
}
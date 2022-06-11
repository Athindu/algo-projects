import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ViewMatrix {
    public void view(int[][] myArray,int nodes) {
        System.out.print(" X-->");
        for (int i = 0; i < nodes; i++) {
            System.out.print(String.format("|%3d",i));
        }
        System.out.println(" |");
        System.out.println(" \\ Y /                                                                                                         ");
        for (int i = 0; i < nodes; i++) {
            System.out.print("| "+i+"  ");
            for (int j = 0; j < nodes; j++) {
                System.out.print(Menu.ANSI_BLUE+String.format("|%3d",myArray[i][j] ));
                // System.out.print(" "+myArray[i][j]+" ");
            }
            System.out.print(" |"+Menu.ANSI_RESET);
            System.out.println();
        }
//        try {
//            TimeUnit.SECONDS.sleep(5);
//            java.awt.Desktop.getDesktop().browse(URI.create("https://people.revoledu.com/kardi/tutorial/GraphTheory/Adjacency-Matrix.html"));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

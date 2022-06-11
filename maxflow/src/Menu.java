import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


//    static ViewMatrix matrix=new ViewMatrix();


    static   MaxFlow tester=new MaxFlow();


    public static void main(String[] args) {

        String name;
        System.out.println(ANSI_BLUE+"\n\t-----------------Welcome To Algorithm Cousework 2020-------------"+ANSI_RESET+"\n");

        System.out.println(ANSI_PURPLE+"Select the Graph that you need to find MaxFlow\n1)Graph 1 (6 Nodes)\n2)Graph 2 (12 Nodes)\n3)Graph 3 (24 Nodes)\n4)Graph 4 (48 Nodes)\n"+ANSI_RESET);

        String input=scanner.nextLine();

        if(input.equals("1")) {
            System.out.println(ANSI_BLUE+"You Selected Graph 01"+ANSI_RESET);


            MaxFlow.V=6;        //get the first line value from the inout file
            name = "cw.txt";
        } else if(input.equals("2")){
            System.out.println(ANSI_BLUE+"You Selected Graph 02"+ANSI_RESET);
            MaxFlow.V=8;
            name="life.txt";
        }else if(input.equals("3")) {
            System.out.println(ANSI_BLUE+"You Selected Graph 03"+ANSI_RESET);
            MaxFlow.V=6;
            name = "cw.txt";
        }else if(input.equals("4")) {
            System.out.println(ANSI_BLUE+"You Selected Graph 04"+ANSI_RESET);
            MaxFlow.V=6;
            name = "cw.txt";
        }else{
            System.out.println(ANSI_RED+"You Entered Wrong Value System Continues With Graph 1"+ANSI_RESET);
            MaxFlow.V=6;
            name="cw.txt";
        }

        System.out.println("Calculating Maximum possible flow of the Graph...\n\t\t"+ANSI_BLUE+"Nodes are Represented with Blue Color\n\t\t"+ANSI_YELLOW+"Flows are Represented with Yellow Color\n\t\t"+ANSI_PURPLE+"Capacities are Represented with Purple Color\n\t\t"+ANSI_RESET  );


//D:/MF/maxflow
//assign entered file name
        String fileName="D:/MF/maxflow/src/"+name;
        int graph[][]= FileHandle.getGraph(fileName);


        /*
        Calculating the time for the performance analysis
        */
        Instant start=Instant.now();
        System.out.println("The maximum possible flow is :" +ANSI_RED+
                tester.fordFulkerson(graph, 0, MaxFlow.V-1)+ANSI_RESET+"\n");
        Instant finish = Instant.now();

        double timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(ANSI_RED+"Elapsed Time :"+timeElapsed+ANSI_RESET+"\n");


        /*System.out.println("This is the Matrix of your Graph\n");
        matrix.view(graph,MaxFlow.V);*/


    }

}

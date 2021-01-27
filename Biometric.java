import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Biometric {

    static ArrayList<double[][]> userDataList = new ArrayList<>();
    static int n, userNumber;
    static double threshold;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        String s002file = "dataset/s002.txt";
        String s003file = "dataset/s003.txt";
        String s004file = "dataset/s004.txt";
        String s005file = "dataset/s005.txt";
        String s007file = "dataset/s007.txt";
        String s008file = "dataset/s008.txt";
        String s010file = "dataset/s010.txt";
        String s011file = "dataset/s011.txt";
        String s012file = "dataset/s012.txt";
        String s013file = "dataset/s013.txt";
        String s015file = "dataset/s015.txt";
        String s016file = "dataset/s016.txt";
        String s017file = "dataset/s017.txt";
        String s018file = "dataset/s018.txt";
        String s019file = "dataset/s019.txt";
        String s020file = "dataset/s020.txt";
        String s021file = "dataset/s021.txt";
        String s022file = "dataset/s022.txt";
        String s024file = "dataset/s024.txt";
        String s025file = "dataset/s025.txt";
        String s026file = "dataset/s026.txt";
        String s027file = "dataset/s027.txt";
        String s028file = "dataset/s028.txt";
        String s029file = "dataset/s029.txt";
        String s030file = "dataset/s030.txt";
        String s031file = "dataset/s031.txt";
        String s032file = "dataset/s032.txt";
        String s033file = "dataset/s033.txt";
        String s034file = "dataset/s034.txt";
        String s035file = "dataset/s035.txt";
        String s036file = "dataset/s036.txt";
        String s037file = "dataset/s037.txt";
        String s038file = "dataset/s038.txt";
        String s039file = "dataset/s039.txt";
        String s040file = "dataset/s040.txt";
        String s041file = "dataset/s041.txt";
        String s042file = "dataset/s042.txt";
        String s043file = "dataset/s043.txt";
        String s044file = "dataset/s044.txt";
        String s046file = "dataset/s046.txt";
        String s047file = "dataset/s047.txt";
        String s048file = "dataset/s048.txt";
        String s049file = "dataset/s049.txt";
        String s050file = "dataset/s050.txt";
        String s051file = "dataset/s051.txt";
        String s052file = "dataset/s052.txt";
        String s053file = "dataset/s053.txt";
        String s054file = "dataset/s054.txt";
        String s055file = "dataset/s055.txt";
        String s056file = "dataset/s056.txt";
        String s057file = "dataset/s057.txt";

        userDataList.add(new CollectData(s002file).userData());
        userDataList.add(new CollectData(s003file).userData());
        userDataList.add(new CollectData(s004file).userData());
        userDataList.add(new CollectData(s005file).userData());
        userDataList.add(new CollectData(s007file).userData());
        userDataList.add(new CollectData(s008file).userData());
        userDataList.add(new CollectData(s010file).userData());
        userDataList.add(new CollectData(s011file).userData());
        userDataList.add(new CollectData(s012file).userData());
        userDataList.add(new CollectData(s013file).userData());
        userDataList.add(new CollectData(s015file).userData());
        userDataList.add(new CollectData(s016file).userData());
        userDataList.add(new CollectData(s017file).userData());
        userDataList.add(new CollectData(s018file).userData());
        userDataList.add(new CollectData(s019file).userData());
        userDataList.add(new CollectData(s020file).userData());
        userDataList.add(new CollectData(s021file).userData());
        userDataList.add(new CollectData(s022file).userData());
        userDataList.add(new CollectData(s024file).userData());
        userDataList.add(new CollectData(s025file).userData());
        userDataList.add(new CollectData(s026file).userData());
        userDataList.add(new CollectData(s027file).userData());
        userDataList.add(new CollectData(s028file).userData());
        userDataList.add(new CollectData(s029file).userData());
        userDataList.add(new CollectData(s030file).userData());
        userDataList.add(new CollectData(s031file).userData());
        userDataList.add(new CollectData(s032file).userData());
        userDataList.add(new CollectData(s033file).userData());
        userDataList.add(new CollectData(s034file).userData());
        userDataList.add(new CollectData(s035file).userData());
        userDataList.add(new CollectData(s036file).userData());
        userDataList.add(new CollectData(s037file).userData());
        userDataList.add(new CollectData(s038file).userData());
        userDataList.add(new CollectData(s039file).userData());
        userDataList.add(new CollectData(s040file).userData());
        userDataList.add(new CollectData(s041file).userData());
        userDataList.add(new CollectData(s042file).userData());
        userDataList.add(new CollectData(s043file).userData());
        userDataList.add(new CollectData(s044file).userData());
        userDataList.add(new CollectData(s046file).userData());
        userDataList.add(new CollectData(s047file).userData());
        userDataList.add(new CollectData(s048file).userData());
        userDataList.add(new CollectData(s049file).userData());
        userDataList.add(new CollectData(s050file).userData());
        userDataList.add(new CollectData(s051file).userData());
        userDataList.add(new CollectData(s052file).userData());
        userDataList.add(new CollectData(s053file).userData());
        userDataList.add(new CollectData(s054file).userData());
        userDataList.add(new CollectData(s055file).userData());
        userDataList.add(new CollectData(s056file).userData());
        userDataList.add(new CollectData(s057file).userData());

        run();

    }

    public static void run() {

        Scanner kb = new Scanner(System.in);
        String option;
        int option2, userNumber;
        boolean again = true;
        boolean again2 = true;

        while (again) {

            System.out.println("Enter 'KH' for Key Hold.");
            System.out.println("Enter 'Int' for Interval to get FRR and FAR scores."); 
            System.out.println("Enter 'Other' for more options.");
            System.out.println("Enter 'Exit' to quit.");
            System.out.print("> ");
            option = kb.nextLine();

            switch (option.toLowerCase()) {
                case "kh":
                    runKH();

                    System.out.print("Press Enter to continue.");
                    kb.nextLine();
                    break;

                case "int":
                    runInt();
                    System.out.print("Press Enter to continue.");
                    kb.nextLine();
                    break;

                case "other":
                    while (again2) {
                        System.out.println("Choose an option: ");
                        System.out.println("Enter '1' to isplay Key Hold values for a user.");
                        System.out.println("Enter '2' to Display Interval values for a user.");
                        System.out.println("Enter '3' to Display Genuine Scores for a user.");
                        System.out.println("Enter '4' to Display Imposter Scores for a user.");
                        System.out.println("Enter '5' to Return.");
                        option2 = kb.nextInt();

                        if (option2 == 1) {
                            System.out.print("Enter a user number (1 - " + userDataList.size() + ") > ");
                            userNumber = kb.nextInt() - 1;
                            Calculate sample = new Calculate(userDataList.get(userNumber));
                            double[][] userKH = sample.getKH();
                            display2DArray(userKH);
                            kb.nextLine();
                            System.out.print("Press Enter to continue.");
                            kb.nextLine();

                        } else if (option2 == 2) {
                            System.out.print("Enter a user number (1 - " + userDataList.size() + ") > ");
                            userNumber = kb.nextInt() - 1;
                            Calculate sample = new Calculate(userDataList.get(userNumber));
                            double[][] userInt = sample.getInterval();
                            display2DArray(userInt);
                            kb.nextLine();
                            System.out.print("Press Enter to continue.");
                            kb.nextLine();
                        } else if (option2 == 3) {
                            System.out.print("Enter a user number (1 - " + userDataList.size() + ") > ");
                            int user = kb.nextInt();
                            userNumber = user - 1;
                            System.out.print("Enter an N value > ");
                            int n = kb.nextInt();
                            Calculate sample = new Calculate(userDataList.get(userNumber), userDataList, n);
                            ArrayList<double[]> userGSKH = sample.genuineScoreKH();
                            System.out.println();
                            System.out.println("Hey Hold Genuine Scores for User " + user);
                            displaySingleArray(userGSKH.get(userNumber));
                            System.out.println();
                            System.out.println("Interval Genuine Scores for User " + user);
                            ArrayList<double[]> userGSInt = sample.genuineScoreKH();
                            displaySingleArray(userGSInt.get(userNumber));
                            kb.nextLine();
                            System.out.print("Press Enter to continue.");
                            kb.nextLine();
                        } else if (option2 == 4) {
                            System.out.print("Enter a user number (1 - " + userDataList.size() + ") > ");
                            int user = kb.nextInt();
                            userNumber = user - 1;
                            System.out.print("Enter an N value > ");
                            int n = kb.nextInt();
                            Calculate sample = new Calculate(userDataList.get(userNumber), userDataList, n);
                            ArrayList<double[][]> userGSKH = sample.impostorScoreKH();                            
                            System.out.println();
                            System.out.println("Key Hold Impostor Scores for User " + user);
                            display2DArray(userGSKH.get(userNumber));
                            System.out.println();
                            System.out.println("Interval Impostor Scores for User " + user);
                            ArrayList<double[][]> userGSInt = sample.impostorScoreInt();
                            display2DArray(userGSInt.get(userNumber));
                            kb.nextLine();
                            System.out.print("Press Enter to continue.");
                            kb.nextLine();
                        } else if (option2 == 5) {
                            again2 = false;
                            kb.nextLine();
                        } else {
                            System.out.println("Invalid command.");
                        }
                    }
                    break;

                case "exit":
                    again = false;
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
 
    public static void runKH() {
        Scanner kb = new Scanner(System.in);
        
        double far = 0;
        
        double frr = 0;

        System.out.print("Enter an N value > ");
        n = kb.nextInt();
        System.out.print("Enter a user number (1 - " + userDataList.size() + ") > ");
        userNumber = (kb.nextInt() - 1);
        System.out.print("Enter a threshold (between 0 - 0.1) > ");
        threshold = kb.nextDouble();

        Calculate sample = new Calculate(userDataList.get(userNumber), userDataList, n);
        ArrayList<double[]> resultGS1 = sample.genuineScoreKH();
        sample = new Calculate(userDataList.get(userNumber), userDataList, n);
        ArrayList<double[][]> testIS2 = sample.impostorScoreKH();

        double[] cr = sample.calcRates(resultGS1, testIS2, threshold);
        

        DecimalFormat df = new DecimalFormat("###.##");
        far = (cr[3] / cr[2]) * 100;
        frr = (cr[1] / cr[0]) * 100;
        System.out.println("Key Hold results - False Accept Rate: " + df.format(far) + "% "  + " False Reject Rate: " + df.format(frr) + "%");
    }

    public static void runInt() {
        Scanner kb = new Scanner(System.in);
        
        double far = 0;
        double frr = 0;

        System.out.print("Enter an N value > ");
        n = kb.nextInt();
        System.out.print("Enter a user number (1 - " + userDataList.size() + ") > ");
        userNumber = (kb.nextInt() - 1);
        System.out.print("Enter a threshold (between 0 - 0.1) > ");
        threshold = kb.nextDouble();

        Calculate sample3 = new Calculate(userDataList.get(userNumber), userDataList, n);
        ArrayList<double[]> resultGS1 = sample3.genuineScoreInt();
        sample3 = new Calculate(userDataList.get(userNumber), userDataList, n);
        ArrayList<double[][]> testIS2 = sample3.impostorScoreInt();

        double[] cr = sample3.calcRates(resultGS1, testIS2, threshold);

        DecimalFormat df = new DecimalFormat("###.##");
        far = (cr[3] / cr[2]) * 100;
        frr = (cr[1] / cr[0]) * 100;
        System.out.println("Interval results - False Accept Rate: " + df.format(far) + "% " + " False Reject Rate: " + df.format(frr) + "%");
    }

    public static void display2DArray(double[][] arrayIn) {
        double[][] dA = arrayIn;

        for (int i = 0; i < dA.length; i++) {
            for (int c = 0; c < dA[i].length; c++) {
                System.out.print(dA[i][c] + " ");
            }
            System.out.println();
        }
    }
    

    public static void displaySingleArray(double[] arrayIn) {
        double[] sa = arrayIn;

        for (int i = 0; i < sa.length; i++) {
            System.out.println(sa[i] + " ");
        }
        System.out.println();
    }
}
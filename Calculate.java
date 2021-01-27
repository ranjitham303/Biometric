import java.util.ArrayList;

public class Calculate {

    ArrayList<double[][]> userDataList = new ArrayList<>();
    private double[][] userArray;
    private int nSample = 10;

    /* constructors */

    public Calculate(double[][] userArray, ArrayList<double[][]> alist, int n) {
        this.userArray = userArray;
        this.userDataList = alist;
        this.nSample = n;
    }

    public Calculate(double[][] userArray) {
        this.userArray = userArray;
    }

    public double[][] getKH() {
        double[][] getKH = userArray;
        double[][] userKH = new double[getKH.length][11];
        int k = 0;

        for (int i = 0; i < getKH.length; i++) {
            for (int c = 0; c < getKH[i].length; c += 3) {

                userKH[i][k++] = getKH[i][c];

            }
            k = 0;
        }
        return userKH;
    }

    public double[][] getInterval() {
        double[][] getInt = userArray;
        double[][] userKH = new double[getInt.length][10];
        int k = 0;

        for (int i = 0; i < getInt.length; i++) {
            for (int c = 2; c < getInt[i].length; c += 3) {

                userKH[i][k++] = getInt[i][c];

            }
            k = 0;
        }
        return userKH;
    }

    public double[][] getKHTemplate() {

        double[][] getKH = userArray;
        double[][] userTempKH = new double[nSample][11];
        int k = 0;

        // fill array for template
        for (int i = 0; i < nSample; i++) {
            for (int c = 0; c < getKH[i].length; c += 3) {

                userTempKH[i][k++] = getKH[i][c];

            }
            k = 0;
        }
        return userTempKH;
    }

    public double[][] getKHTesting() {
        double[][] getKH = userArray;
        int testing = getKH.length - nSample;
        double[][] userKH = new double[testing][11];
        int k = 0;

        // fill array for test sample
        for (int i = nSample; i < getKH.length; i++) {
            for (int c = 0; c < getKH[i].length; c += 3) {

                userKH[(i - nSample)][k++] = getKH[i][c];

            }
            k = 0;
        }
        return userKH;
    }

    public double[] calcMeanKHTemplate() {
        double[][] userKH = getKHTemplate();
        int k = userKH[0].length;

        double[] meanKH = new double[k];

        for (int c = 0; c < k; c++) {
            for (int i = 0; i < userKH.length; i++) {

                meanKH[c] += (userKH[i][c] / userKH.length);

            }
        }
        return meanKH;
    }

    public double[][] getIntervalTemplate() {

        double[][] getInt = userArray;
        double[][] userInt = new double[400][10];
        int k = 0;

        // fill array for template
        for (int i = 0; i < nSample; i++) {
            for (int c = 2; c < getInt[i].length; c += 3) {

                userInt[i][k++] = getInt[i][c];

            }
            k = 0;
        }
        return userInt;
    }

    public double[][] getIntervalTesting() {

        double[][] getInt = userArray;
        int testing = getInt.length - nSample;
        double[][] userInt = new double[testing][10];
        int k = 0;

        // fill array for test sample
        for (int i = nSample; i < getInt.length; i++) {
            for (int c = 2; c < getInt[i].length; c += 3) {

                userInt[i - nSample][k++] = getInt[i][c];

            }
            k = 0;
        }
        return userInt;
    }

    public double[] calcMeanIntervalTemplate() {
        double[][] userInt = getIntervalTemplate();
        int k = userInt[0].length;

        double[] meanInt = new double[k];

        for (int i = 0; i < userInt.length; i++) {
            for (int c = 0; c < userInt[i].length; c++) {

                meanInt[c] += (userInt[i][c] / userInt.length);

            }
        }
        return meanInt;
    }

    // compares template to test and displays Key Hold Genuine Score for one user in an array
    public ArrayList<double[]> genuineScoreKH() {

        int size = userDataList.size();
        ArrayList<double[][]> userList = userDataList;
        ArrayList<double[]> resultGS = new ArrayList<>();
        double[][] test = getKHTesting();

        double gs = 0;

        for (int x = 0; x < size; x++) {
            userArray = userList.get(x);
            double[] template = calcMeanKHTemplate();
            double[] genuineScore = new double[test.length];

            for (int i = 0; i < test.length; i++) {
                for (int j = 0; j < template.length; j++) {
                    gs += Math.abs(template[j] - test[i][j]);
                }
                gs = (gs / template.length);
                genuineScore[i] = gs;
                gs = 0;
            }
            resultGS.add(genuineScore);

        }

        return resultGS;

    }

    public ArrayList<double[]> genuineScoreInt() {

        int size = userDataList.size();
        ArrayList<double[][]> userList = userDataList;
        ArrayList<double[]> resultInt = new ArrayList<>();
        double[][] test = getIntervalTesting();

        double gs = 0;

        for (int x = 0; x < size; x++) {
            userArray = userList.get(x);
            double[] template = calcMeanIntervalTemplate();
            double[] genuineScore = new double[test.length];

            for (int i = 0; i < test.length; i++) {
                for (int j = 0; j < template.length; j++) {
                    gs += Math.abs(template[j] - test[i][j]);
                }
                gs = (gs / template.length);
                genuineScore[i] = gs;
                gs = 0;
            }
            resultInt.add(genuineScore);

        }

        return resultInt;

    }

    // calculate KH imposter score for a user
    public ArrayList<double[][]> impostorScoreKH() {

        ArrayList<double[][]> userList = userDataList;
        ArrayList<double[][]> resultIS = new ArrayList<>();
        int size = userDataList.size();
        int testsize = userArray.length - nSample;
        double[] userMeanTempKH = new double[11];
        double temp = 0;
        double[][] userIS = new double[testsize][11];

        double[][] template = userArray;

        userMeanTempKH = calcMeanKHTemplate();

        // use template to compare to different users
        for (int j = 0; j < size; j++) {

            if (template != userList.get(j)) {
                // set user to retrieve testing data each iteration
                userArray = userList.get(j);

                double[][] khTesting = new double[testsize][11];
                khTesting = getKHTesting();

                // iterate through each test
                for (int x = 0; x < testsize; x++) {

                    // compare  
                    for (int y = 0; y < khTesting[y].length; y++) {

                        temp = +Math.abs(userMeanTempKH[y] - khTesting[x][y]);

                        userIS[x][y] = temp;
                        temp = 0;
                    }

                }

            }

            resultIS.add(userIS);

        }

        return resultIS;
    }

    public ArrayList<double[][]> impostorScoreInt() {

        ArrayList<double[][]> userList = userDataList;
        ArrayList<double[][]> resultIS = new ArrayList<>();
        int size = userDataList.size();
        int testsize = userArray.length - nSample;
        double[] userMeanTempInt = new double[10];
        double temp = 0;
        double[][] userIS = new double[testsize][10];

        double[][] template = userArray;

        userMeanTempInt = calcMeanIntervalTemplate();

        // use template to compare to different users
        for (int j = 0; j < size; j++) {

            if (template != userList.get(j)) {
                // set user to retrieve testing data each iteration
                userArray = userList.get(j);

                double[][] intTesting = new double[testsize][10];
                intTesting = getIntervalTesting();

                // iterate through each test
                for (int x = 0; x < testsize; x++) {

                    // compare  
                    for (int y = 0; y < intTesting[y].length; y++) {

                        temp = +Math.abs(userMeanTempInt[y] - intTesting[x][y]);

                        userIS[x][y] = temp;
                        temp = 0;
                    }

                }

            }

            resultIS.add(userIS);

        }

        return resultIS;

    }

    public double[] calcRates(ArrayList<double[]> gS, ArrayList<double[][]> iS, double t) {
        ArrayList<double[]> genuineScore = gS;
        ArrayList<double[][]> imposterScore = iS;
        double threshhold = t;
        double[] gs;
        double[][] is;
        double[] result = new double[4];

        int frr = 0;
        int far = 0;
        int count = 0;

        // calculate FRR
        for (int i = 0; i < genuineScore.size(); i++) {
            gs = genuineScore.get(i);
            for (int j = 0; j < gs.length; j++) {

                count++;
                if (gs[j] > t) {
                    frr++;
                }
            }
        }
        result[0] = count;
        result[1] = frr;

        // calculate FAR
        count = 0;
        for (int i = 0; i < imposterScore.size(); i++) {
            is = imposterScore.get(i);
            for (int j = 0; j < is.length; j++) {
                for (int k = 0; k < is[j].length; k++) {
                    count++;
                    if (is[j][k] <= t) {
                        far++;
                    }
                }
            }
            result[2] = count;
            result[3] = far;
        }

        return result;
    }

}
import java.util.Arrays;

public class Calc {

    public static double getMean(PlayerData[] dataList) {
        return Arrays.stream(dataList).mapToDouble(data -> data.getCalcData()).average().getAsDouble();
    }

    public static double getStandardDeviation(PlayerData[] dataList) {
        double mean = getMean(dataList);
        double totalPlays = Arrays.stream(dataList).mapToInt(data -> data.getPlays()).sum();
        double sigma = Math.sqrt(Arrays.stream(dataList).mapToDouble(data -> Math.pow(data.getCalcData() - mean, 2) * data.getPlays()).sum() / totalPlays);
        return sigma;
    }

    public static double getStandardScore(double data, double mean, double sigma) {
        return (data - mean) / sigma;
    }

    public static double[] getWeightedScore(double[] data, double[] score) {
        if (data.length == score.length) {
            double[] weightedScore = new double[data.length];
            for (int i = 0; i < data.length; i++) {
                weightedScore[i] = data[i] * score[i];
            }
            return weightedScore;
        }
        return null;
    }

    public static double doCalc(PlayerData[] players, int toFind) {
        for (int i = 0; i < players.length; i++) {
            System.out.println(i + ":" + players[i].getCalcData());
        }
        double mean = Calc.getMean(players);
        System.out.println("MEAN = " + mean);
        double sigma = Calc.getStandardDeviation(players);
        System.out.println("SIGMA = " + sigma);
        double standardScore = Calc.getStandardScore(players[toFind].getCalcData(), mean, sigma);
        System.out.println(standardScore);
        return standardScore;
    }

    public static String getRank(double standardScore) {
        String[] ranks = {"Silver I", "Silver II", "Silver III", "Silver IV", "Silver V", "Nova I", "Nova II", "Nova III", "Nova IV", "Nova V", "Diamond I", "Diamond II", "Diamond III", "Diamond IV", "Diamond V", "Elite I", "Elite II", "Global Elite"};
        int minScore = -8;
        int scoreIndex = ((int) standardScore) - minScore;
        if (scoreIndex < 0) {
            return ranks[0];
        } else if (scoreIndex > ranks.length) {
            return ranks[ranks.length + 1];
        }
        return ranks[scoreIndex];
    }
}

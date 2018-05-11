public class InfPlayerData implements PlayerData {
    public int kill;
    public int win;
    public int death;
    public int loss;

    public InfPlayerData(int kill, int win, int death, int loss) {
        this.kill = kill;
        this.win = win;
        this.death = death;
        this.loss = loss;
    }

    @Override
    public double getCalcData() {
        double[] data = {kill, win, death, loss};
        double[] weight = {5, 15, 4, 10};
        double[] weighted = Calc.getWeightedScore(data, weight);
        return weighted[0] + weighted[1] - (weighted[2] + weighted[3]);
    }

    @Override
    public int getPlays() {
        return win + loss;
    }
}

public class InfCalcTest {
    public static void main(String[] args) {
        PlayerData player1 = new InfPlayerData(384, 115, 198, 128);
        PlayerData player2 = new InfPlayerData(285, 112, 306, 197);
        PlayerData player3 = new InfPlayerData(241, 105, 222, 147);
        PlayerData player4 = new InfPlayerData(29, 9, 24, 16);
        PlayerData player5 = new InfPlayerData(159, 43, 150, 101);
        PlayerData[] players = {player1, player2, player3, player4, player5};
        int mrk = (int) Calc.doCalc(players, 0);
        System.out.println(Calc.getRank(mrk));
    }
}

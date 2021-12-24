public class Task2 {
    public static void main(String[] args) {

        System.out.println(minimumNumberOfCoins(564));
    }

    static int countCoin1 = 0;
    static int countCoin5 = 0;
    static int countCoin10 = 0;
    static int countCoin20 = 0;
    static int countCoin50 = 0;
    static int countCoin100 = 0;

    public static int minimumNumberOfCoins(int sum) {


        while (sum >= 100) {
            sum = sum - 100;
            countCoin100 = countCoin100 + 1;
        }
        while (sum >= 50) {
                sum = sum - 50;
                countCoin50++;
        }
        while (sum >= 20) {
            sum = sum - 20;
            countCoin20++;
        }
        while (sum >= 10) {
            sum = sum - 10;
            countCoin10++;
        }
        while (sum >= 5) {
            sum = sum - 5;
            countCoin5++;
        }
        while (sum >= 1) {
            sum = sum - 1;
            countCoin1++;
        }

        return countCoin100 + countCoin50 + countCoin20 + countCoin10 + countCoin5 + countCoin1;
    }
}

import java.util.Arrays;
import java.util.Random;

public class FakeCoin {

    private class Coin {

        double weight;
        int position;

        public Coin(double weight, int position) {
            this.weight = weight;
            this.position = position;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    private Coin[] initializeCoin(int coinNum){
        Coin[] coinArray = new Coin[coinNum];
        for(int j = 0; j < coinArray.length; j++)
            coinArray[j] = new Coin(0.02, j);
        Random ran = new Random();
        Float f = coinNum * ran.nextFloat();
        int fakePosition = f.intValue();
        coinArray[fakePosition].setWeight(0.01);
        System.out.println("Position of fake coin: " + fakePosition);
        return coinArray;
    }

    private int compareCoin( Coin[] left, Coin[] right){
        if (left.length != right.length)
            System.out.println("Pile is unequal");
            double leftWeight = 0.0;
            for (Coin cLeft: left) {
                leftWeight += cLeft.getWeight();
            }

            double rightWeight = 0.0;
            for (Coin cRight: right) {
                rightWeight += cRight.getWeight();
            }

            if (leftWeight>rightWeight){
                return -1;
            }
            else if (leftWeight<rightWeight){
                return 1;
            }
            else {
                return 0;
            }
    }

    private void searchMessage(Coin[] coinArray){
        if (coinArray.length >= 1){
            System.out.println("Searching from " + coinArray[0].getPosition()+ " - "
                    + coinArray[coinArray.length - 1].getPosition());
        } else
            System.out.println("Empty array");
    }

    private int findFakeCoin(Coin[] coinArray){
        if(coinArray.length == 0)
            return -1;
        else if(coinArray.length == 1)
            return coinArray[0].getPosition();
        else {
            boolean oddNumCoin = coinArray.length % 2 == 1;
            int third = coinArray.length / 3;
            Coin[] leftCoin = Arrays.copyOfRange(coinArray, 0, third);
            Coin[] middleCoin = Arrays.copyOfRange(coinArray, third, 2 * third);
            Coin[] rightCoin = Arrays.copyOfRange(coinArray, 2 * third, coinArray.length);
            int result = compareCoin(leftCoin, middleCoin);
            if(result == 0) {
                searchMessage(rightCoin);
                return findFakeCoin(rightCoin);
            }
            else if (result == 1) {
                searchMessage(leftCoin);
                return findFakeCoin(leftCoin);
            }
            else if(result == -1){
                searchMessage(middleCoin);
                return findFakeCoin(middleCoin);
            }
            else if(oddNumCoin)
                return coinArray[coinArray.length-1].getPosition();
            else return -1;
        }
    }

    public static void main(String[] args) {
        FakeCoin fakeCoin = new FakeCoin();
        Coin[] coinArray = fakeCoin.initializeCoin(100);
        int fakeCoinPosition = fakeCoin.findFakeCoin(coinArray);
        System.out.println("Position of fake coin: " + fakeCoinPosition);
    }

}

public class BinarySearch {


        int binarySearch(int array[], int leftEle, int rightEle, int x)
        {
            if (rightEle >= leftEle) {
                int midValue = leftEle + (rightEle - leftEle) / 2;


                if (array[midValue] == x)
                    return midValue;


                if (array[midValue] > x)
                    return binarySearch(array, leftEle, midValue - 1, x);


                return binarySearch(array, midValue + 1, rightEle, x);
            }

            return -1;
        }


        public static void main(String args[])
        {
            BinarySearch bs = new BinarySearch();
            int array[] = { 2, 3, 4, 10, 40 };
            int n = array.length;
            int x = 40;
            int result = bs.binarySearch(array, 0, n - 1, x);
            if (result == -1) {
                System.out.println("Element is not in the array...");
            }
            else {
                System.out.println("Element found at index " + result + " ...");
            }
        }
}

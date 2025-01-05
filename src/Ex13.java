/** public class Ex13.
 * This class represents the all MAMAN questions.
 *
 * @author Emanuel Abraham
 * @version 4/1/2025 (2025a)
 */

public class Ex13 {

    /** Accepts an array and a median number and returns a special array.
     *
     * @param arr The array.
     * @param med The number in the array arr that n/2 of the elements in the array
     * are smaller than and n/2 of the elements in the array are larger than.
     * @return Spetial array.
     */
    public static int[] specialArr(int[] arr, int med) {
        int x = 0, y = 1;
        int[] arr1 = new int[arr.length];// new array
        for (int i = 0; i < arr1.length; i++) {
            if (arr[i] >= med) {// if array in index i >= to med, insert it to the new array in even index.
                arr1[x] = arr[i];
                x += 2;
            } else {// else, insert it to new array in odd number
                arr1[y] = arr[i];
                y += 2;
            }
        }
        return arr1;
    }


    /** The method returns the smallest positive number not found in the array.
     *
     * @param arr Unsorted array.
     * @return The smallest positive number not found in the array.
     */
    public static int first(int[] arr) {
        int x = 1, i, t;
        for (i = 0; i < arr.length; i++) {
            if ((arr[i] != i + 1) && (arr[i] <= arr.length) && (arr[i] > 0)) {// Place the numbers in their places in the array.
                t = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = t;
            }
        }
        for (i = 0; i < arr.length; i++) {// Check the first number that not in the array place.
            if (arr[i] == x) {
                x += 1;
            }
        }
        return x;
    }


    /** Gets an array and checks if there is a nearly palindromic sequence.
     *
     * @param arr Array.
     * @return Number of the largest sequence.
     */
    public static int longestNearlyPal(int[] arr) {
        return longestNearlyPal(arr, arr.length-1, 0, 0, 1);
    }

    /** Gets an array and checks if there is a nearly palindromic sequence.
     *
     * @param arr Array.
     * @param right Pointer.
     * @param left Pointer.
     * @param counter Counter of palindromic.
     * @param maxCount Max palindromic.
     * @return maxCount.
     */
    private static int longestNearlyPal(int[] arr, int right, int left, int counter, int maxCount) {
        if (right == 0){//pointer right
            return maxCount;
        }
        if(left == right) {//pointer left and right are equals
            return longestNearlyPal(arr, right-1, 0, 0, Math.max(counter, maxCount));
        }
        if ((arr[left] == arr[right]) && almostPalindrom(arr, right, left, 0)){// the bit of array is almost palindrom
            counter = right-left+1;
        }
        return longestNearlyPal(arr, right, left + 1, 0, Math.max(counter, maxCount));//return the number of the almost pal array.
    }

    /** Gets a small array and check if it is almost palindromic.
     *
     * @param arr Array.
     * @param right Pointer.
     * @param left Pointer.
     * @param flag If the array in pointers place are not equal.
     * @return True if the array is almost palindromic.
     */
    private static boolean almostPalindrom(int[] arr, int right, int left, int flag) {
        if (left >= right) {//pointers
            return true;
        }
        if (arr[left] != arr[right]) {// array in index of pointers are not equal.
            if (flag == 1) {// if there is more than one mismatched number in the array.
                return false;
            }
            return almostPalindrom(arr, right - 1, left, 1) || almostPalindrom(arr, right, left + 1, 1);
        }
        return almostPalindrom(arr, right - 1, left + 1, flag);// if the numbers are equals.
    }


    /** A method that accepts a two-dimensional square array mat filled with only real,
     * positive integers, and returns the value of the minimum number
     * among the maximum numbers in all possible paths.
     *
     * @param m Matrix array.
     * @return The value of the minimum number among the maximum numbers in all possible paths.
     */
    public static int extreme(int [][] m){
        return extreme(m,0,0,Integer.MIN_VALUE);
    }

    /** Auxiliary method for calculationץ
     *
     * @param m Matrix array.
     * @param i Row.
     * @param j Colum.
     * @param maxNumber Maximum number in the route.
     * @return The value of the minimum number among the maximum numbers in all possible paths.
     */
    private static int extreme(int [][] m, int i, int j, int maxNumber){

        if (i<0 || j<0 || i> m.length-1 || j> m.length-1 || m[i][j] == 0) {// cases that irrelevant for us.
            return Integer.MAX_VALUE;
        }

        if (i == m.length-1 && j == m.length-1){// when we reach the end of the matrix, return the max number in this route.
            return Math.max(maxNumber, m[i][j]);
        }

        int temp = m[i][j];
        m[i][j] = 0;

        int down = extreme(m, i + 1, j, Math.max(maxNumber, temp));// Go to the down square.
        int right = extreme(m, i, j + 1, Math.max(maxNumber, temp));// Go to the right square.
        int up = extreme(m, i - 1, j, Math.max(maxNumber, temp));// Go to the up square.
        int left = extreme(m, i, j - 1, Math.max(maxNumber, temp));// Go to the left square.

        m[i][j] = temp;
        return Math.min(Math.min(down, right), Math.min(up, left));// return value of the minimum number among the maximum numbers in all possible paths.
    }
}
public class Ex13 {
    public static int[] specialArr(int[] arr, int med) {
        int x = 0, y = 1;
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr[i] >= med) {
                arr1[x] = arr[i];
                x += 2;
            } else {
                arr1[y] = arr[i];
                y += 2;
            }
        }
        return arr1;
    }

    public static int first(int[] arr) {
        int x = 1, i, t;
        for (i = 0; i < arr.length; i++) {
            if ((arr[i] != i + 1) && (arr[i] <= arr.length) && (arr[i] > 0)) {
                t = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = t;
            }
        }
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                x += 1;
            }
        }
        return x;
    }


    public static int longestNearlyPal(int[] arr) {
        return longestNearlyPal(arr, arr.length-1, 0, 0, 0);
    }

    private static int longestNearlyPal(int[] arr, int right, int left, int counter, int maxCount) {
        if (right == 0){
            return maxCount;
        }
        if(left == right) {
            return longestNearlyPal(arr, right-1, 0, 0, Math.max(counter, maxCount));
        }
        if ((arr[left] == arr[right]) && almostPalindrom(arr, right, left, 0)){
            counter = right-left+1;
        }
        return longestNearlyPal(arr, right, left + 1, 0, Math.max(counter, maxCount));
    }

    private static boolean almostPalindrom(int[] arr, int right, int left, int flag) {
        if (left >= right) {
            return true;
        }
        if (arr[left] != arr[right]) {
            if (flag == 1) {
                return false;
            }
            return almostPalindrom(arr, right - 1, left, 1) || almostPalindrom(arr, right, left + 1, 1);
        }
        return almostPalindrom(arr, right - 1, left + 1, flag);
    }
}
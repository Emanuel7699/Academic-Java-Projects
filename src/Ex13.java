public class Ex13 {
    public static int[] specialArr (int[] arr, int med){
        int x=0, y=1;
        int[] arr1 = new int[arr.length];
        for(int i=0;i < arr1.length;i++){
         if (arr[i]>=med){
             arr1[x] = arr[i];
             x+=2;
         }
         else{
             arr1[y] = arr[i];
             y+=2;
         }
        }
        return arr1;
    }

    public static int first (int [] arr) {
        int x = 1, i, t;
        for(i = 0;i < arr.length;i++) {
            if ((arr[i] != i+1) && (arr[i] <= arr.length) && (arr[i] > 0)) {
                t = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = t;
            }
        }
        for(i = 0;i < arr.length;i++) {
            if (arr[i] == x) {
                x += 1;
            }
        }
        return x;
    }
}
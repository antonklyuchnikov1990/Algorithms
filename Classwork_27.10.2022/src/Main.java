public class Main {

    public static void main(String[] args) {
        int[] array = {98, 7, 65, 41, 23, 4, 5, 6, 7, 89, 4, 51, 1, 12, 33, 5, 48};
        getMin(array);
        getMin2(array);
    }

    public static void getMin(int[] array) {
        int minValue = array[0];
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        System.out.println("min value: " + minValue);
        System.out.println("index: " + minIndex);
    }

    public static void getMin2(int[] array) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int j : array) {
            if (j < min) {
                min2 = min;
                min = j;
            } else if (j < min2) {
                min2 = j;
            }
        }
        if (min2 != Integer.MAX_VALUE) {
            System.out.println("Min 2: " + min2);
        } else {
            System.out.println("Min 2 doesn not exist");
        }
        System.out.println("Min : " + min);
    }
}
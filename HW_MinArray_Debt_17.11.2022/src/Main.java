public class Main {

    public static void main(String[] args) {
        int[] array = {12, 42, 35, 3, 24, 6, 34, 6, 7, 35, 75, 47, 9, 8, 79, 0, 3, 25, 98, 74, 51, 5};
        System.out.println(firstMin(array));
        System.out.println(secondMin(array));
        System.out.println(thirdMin(array));
        System.out.println(fourthMin(array));
    }

    private static int fourthMin(int[] array) {
        int min3 = thirdMin(array);
        int min4 = array[0];
        for (int j : array) {
            if (j > min3 && j < min4) {
                min4 = j;
            }
        }
        return min4;
    }
    private static int thirdMin(int[] array) {
        int min2 = secondMin(array);
        int min3 = array[0];
        for (int j : array) {
            if (j > min2 && j < min3) {
                min3 = j;
            }
        }
        return min3;
    }

    private static int secondMin(int[] array) {
        int min = firstMin(array);
        int min2 = array[0];
        for (int j : array) {
            if (j > min && j < min2) {
                min2 = j;
            }
        }
        return min2;
    }

    private static int firstMin(int[] array) {
        int min = array[0];
        for (int j : array) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }


}

public class Main {

    public static void main(String[] args) {
        
        int[] array = {58, 8, 7, 65, 219, 84, 2};

        // divide()
        int arrayLength = array.length;
//        if (arrayLength == 1) {
//              break;
//        }
        int middle = arrayLength / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[arrayLength - middle];

        for (int index = 0; index < middle; index++) {
            leftArray[index] = array[index];
        }
        for (int index = middle; index < arrayLength; index++) {
            rightArray[index] = array[index];
        }

        // merge(array[], )
        int leftLengthArray = leftArray.length;
        int rightLengthArray = rightArray.length;

        int l = 0, r = 0, arrayIndex = 0;

        while (l < leftLengthArray && r < rightLengthArray) {
            if (leftArray[l] < rightArray[r]) {
                array[arrayIndex] = leftArray[l];
                l++;
                arrayIndex++;
            }
            if (rightArray[r] < leftArray[l]) {
                array[arrayIndex] = rightArray[r];
                r++;
                arrayIndex++;
            }
        }

        for (int ind = l; ind < leftLengthArray; ind++) {
            array[arrayIndex++] = leftArray[ind];
        }
        for (int ind = r; ind < rightLengthArray; ind++) {
            array[arrayIndex++] = rightArray[ind];
        }

    }

}

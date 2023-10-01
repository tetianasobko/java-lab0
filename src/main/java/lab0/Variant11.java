package lab0;

import java.util.Arrays;

public class Variant11 {

    public enum CORNERS_OF_THE_WORLD {
        N, W, S, E
    }

    /**
     * @param n is integer number
     * @return the last min or max index
     */
    public int minMaxTask(int n, int[] array) {
        if (n != array.length) {
            throw new IllegalArgumentException();
        }

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < n; i++) {
            if (array[i] >= array[maxIndex]) {
                maxIndex = i;
            }

            if (array[i] <= array[minIndex]) {
                minIndex = i;
            }
        }

        return Math.max(minIndex, maxIndex);
    }

    /**
     * @param number is a three-digit number
     * @return the sum and product of the digits.
     */

    public int[] integerNumbersTask(int number) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        int product = 1;

        for (int i = 0; i < 3; i++) {
            int digit = number % 10;
            number /= 10;

            sum += digit;
            product *= digit;
        }

        return new int[]{sum, product};
    }

    /**
     * @param numberA is integer number
     * @param numberB is integer number
     * @return true, if numbers A and B have the same parity
     */
    public boolean booleanTask(int numberA, int numberB) {
        return numberA % 2 == numberB % 2;
    }


    /**
     * @param numberA is integer number
     * @param numberB is integer number
     * @return transformed numbers.
     * Each variable will be assigned greater of these values.
     * And if they are equal, then the variables will be assigned zero values.
     */
    public int ifTask(int numberA, int numberB) {
        if (numberA == numberB) {
            numberA = numberB = 0;

        } else {
            numberA = numberB = Math.max(numberA, numberB);
        }
        return numberA;
    }


    /**
     * @param N1 - command
     * @param N2 - command
     * @return orientation of the locator;
     */
    public CORNERS_OF_THE_WORLD switchTask(int N1, int N2) {
        if (N1 != 1 && N1 != 2 && N1 != -1) {
            throw new IllegalArgumentException();
        }

        if (N2 != 1 && N2 != 2 && N2 != -1) {
            throw new IllegalArgumentException();
        }

        switch (Math.abs(N1 + N2)) {
            case (1) -> {
                return CORNERS_OF_THE_WORLD.E;
            }
            case (2) -> {
                return CORNERS_OF_THE_WORLD.S;
            }
            case (3) -> {
                return CORNERS_OF_THE_WORLD.W;
            }
            default -> {
                return CORNERS_OF_THE_WORLD.N;
            }
        }
    }


    /**
     * @param n is integer number
     * @return Find the sum N^2 + (N + 1)^2N + 2)^2n + … + (2·N)^2
     */
    public int forTask(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        int sum = 0;

        for (int i = n; i <= n * 2; i++) {
            sum += i * i;
        }

        return sum;
    }

    /**
     * @param n is an integer, greater than 1
     * @return k and sum, for which the sum 1 + 2 + ... + k will be greater than or equal to n
     */
    public int[] whileTask(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException();
        }

        int k = 1;
        int sum = 0;

        while ((sum += k) < n) {
            k++;
        }

        return new int[]{k, sum};
    }

    /**
     * @param array is an array of integers of length n
     * @param k is an integer, greater than 1 and less than n
     * @return array elements with sequence numbers that are multiples of K
     */
    public int[] arrayTask(int[] array, int k) {
        if (k <= 1 || k >= array.length) {
            throw new IllegalArgumentException();
        }

        int[] res = new int[array.length / k];

        for (int i = k; i < array.length; i += k) {
            res[i / k - 1] = array[i];
        }

        return res;
    }

    /**
     * @param array is a matrix of size M by N
     * @return transformed array, where its elements are in the following order:
     * the first line from left to right, the second line from right to left,
     * the third line from left to right, the fourth line from right to left, etc.
     */
    public int[][] twoDimensionArrayTask(int[][] array) {
        int m = array.length;
        int n = array[0].length;

        int[][] transformedArray = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                transformedArray[i] = Arrays.copyOf(array[i], n);
            } else {
                for (int j = 0; j < n; j++) {
                    transformedArray[i][j] = array[i][n - j - 1];
                }
            }

        }

        return transformedArray;
    }

    public static void main(String... strings) {

    }

}
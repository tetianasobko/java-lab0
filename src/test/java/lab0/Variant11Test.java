package lab0;

import lab0.Variant11.CORNERS_OF_THE_WORLD;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class Variant11Test {

    public static double EPS = 0.0000001;

    @Test
    public void MassTest(){
        assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    @Test(enabled = false)
    public void loginOld() {

        assertEquals(new Variant11().booleanTask(3, 8), false);

    }

    @Test(dataProvider = "minMaxProvider")
    public void inputTest(int p1, int[] p2, int p3) {
        assertEquals(new Variant11().minMaxTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] minMaxProvider() {
        return new Object[][] { { 2, new int[]{2, 4}, 1 }, { 6, new int[]{2, 4, 6, -1, 2, -1}, 5 } };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeInputTest() {
        new Variant11().minMaxTask(-2, new int[]{2, 4});
        new Variant11().minMaxTask(3, new int[]{2, 4});
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int[] p3) {
        assertEquals(new Variant11().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 100, new int[] {1, 0} }, { 121, new int[] {4, 2} }, { 139, new int[] {13, 27} } };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeIntegerTest() {
        new Variant11().integerNumbersTask(-2);
        new Variant11().integerNumbersTask(32);
        new Variant11().integerNumbersTask(3672);
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3) {
        assertEquals(new Variant11().ifTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 3, 3}, { 0, 0, 0 }, { -3, -3, 0 }, { 5, 3, 5 } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant11().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, 3, true }, { 0, 7, false }, { -3, 4, false } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, int p2, CORNERS_OF_THE_WORLD p3) {
        assertEquals(new Variant11().switchTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { -1, -1, CORNERS_OF_THE_WORLD.S }, { 1, -1, CORNERS_OF_THE_WORLD.N }, { 2, -1, CORNERS_OF_THE_WORLD.E }, { 1, 2, CORNERS_OF_THE_WORLD.W } };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void switchNegativeTest() {
        new Variant11().switchTask(10, 2);
        new Variant11().switchTask(1, -2);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, int p2) {
        assertEquals(new Variant11().forTask(n), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3, 86 }, { 7, 924 }, { 12, 4394 } };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void forNegativeTest() {
        new Variant11().forTask(-10);
        new Variant11().forTask(0);
    }

    ///////////////////////////////////////////////////

    //////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int[] b) {
        assertEquals(new Variant11().whileTask(a), b);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 10, new int[] {4, 10}}, { 12, new int[] {5, 15} }, { 35, new int[] {8, 36} }};
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeWhileTest() {
        new Variant11().whileTask(1);
        new Variant11().whileTask(-1);
    }

    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] array, int k, int[] res) {
        assertEquals(new Variant11().arrayTask(array, k), res);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new int[] { 10, 2, 3 }, 2, new int[] {3} }, { new int[] { 1, 12, 34, 57, 7, 2004, 196 }, 3, new int[] {57, 196} },
                { new int[] { 1511, 6, 53, 96, 4, 12, 72, 86, 66, 105, -3 }, 5, new int[] {12, -3} } };
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int[][] output) {
        assertEquals(Arrays.deepEquals(new Variant11().twoDimensionArrayTask(input), output), true);

    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input11 = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input12 = {{2, 3, 6, 9, -9},
                {1, 2, -9, 98, 34},
                {-4, 2, 1, 6, 1},
                {3, 5, 1, 8, -98}};

        int[][] input21 = {{-98, 8, 1, 5, 3},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {2, 3, 6, 9, -9}};

        int[][] input22 = {{-98, 8, 1, 5, 3},
                {1, 6, 1, 2, -4},
                {34, 98, -9, 2, 1},
                {-9, 9, 6, 3, 2}};

        return new Object[][] { {input11, input12}, { input21, input22 } };

    }

    @Test
    public void arrayTest2(){
        assertEquals(new int[]{2, 3}, new int[]{2, 3});
    }

}
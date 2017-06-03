package test.thoutWorks;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import thoutWorks.LifeGame;

/**
 * LifeGame Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 3, 2017</pre>
 */
public class LifeGameTest {
    LifeGame lifeGame;
    //		int array[][] = {{0,0,0},{1,0,1},{1,0,0}};
    //     	int array[][] = {{0,1,0},{1,1,1},{0,1,0}};
    //		int array[][] = {{0,0,0},{1,1,1},{0,0,0}};
    int array[][] = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};

    @Before
    public void before() throws Exception {
        lifeGame = new LifeGame();
    }

    /**
     * Method: updataLife(int[][] array, int[][] temp)
     */
    @Test
    public void testUpdataLife() throws Exception {
        int[][] test = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] temp = new int[test.length][test[0].length];
        assertArrayEquals(lifeGame.updataLife(array, temp), test);
    }

    /**
     * Method: check(int[][] array, int x, int y)
     */
    @Test
    public void testCheck() throws Exception {
        assertEquals(lifeGame.check(array, 0, 0), 0);
        assertEquals(lifeGame.check(array, 0, 1), 1);
        assertEquals(lifeGame.check(array, 1, 0), -1);


    }

    /**
     * Method: getCount(int[][] array, int x, int y)
     */
    @Test
    public void testGetCount() throws Exception {
        assertEquals(lifeGame.getCount(array, 0, 0), 2);
        assertEquals(lifeGame.getCount(array, 1, 1), 2);
    }

    /**
     * Method: checkLocation(int[][] array, int x, int y)
     */
    @Test
    public void testCheckLocation() throws Exception {
        assertEquals(lifeGame.checkLocation(array, 0, 0), true);
        assertEquals(lifeGame.checkLocation(array, -1, 0), false);
        assertEquals(lifeGame.checkLocation(array, 0, 3), false);
        assertEquals(lifeGame.checkLocation(array, 3, 0), false);
    }
}

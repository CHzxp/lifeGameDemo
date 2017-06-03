package thoutWorks;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LifeGame {
    private static  int N = 50;//矩阵维度
    private static  int M = 60;//矩阵维度
    private static final int time = 100;//显示间隔时间

    public static void main(String[] args) {

        int array[][] = initArray(N,M);
        int temp[][] = new int[N][M];
        for (int i = 0; i < 1000; i++) {
            new LifeGame().updataLife(array, temp);
            cycleTime();
            int[][] t = array;
            array = temp;
            temp = t;
        }
    }

    /**
     * 计算下一次的生命矩阵，并打印
     * @param array
     * @param temp
     * @return
     */
    public int[][] updataLife(int[][] array, int[][] temp) {
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                flag = check(array, i, j);
                switch (flag) {
                    case 1:
                        temp[i][j] = 1;
                        break;
                    case 0:
                        temp[i][j] = array[i][j];
                        break;
                    case -1:
                        temp[i][j] = 0;
                        break;
                }
            }
        }
        printArray(temp);
        return temp;
    }

    /**
     * 判断一个点的下一个状态
     *
     * @java_sam 2017年6月3日
     */
    public int check(int[][] array, int x, int y) {
        int flag = 0;
        int count = getCount(array, x, y);
        /**
         * 根据count判断生死
         */
        if (count == 3) {
            flag = 1;
        } else if (count == 2) {
            flag = 0;
        } else {
            flag = -1;
        }
        return flag;
    }


    /*
     * 该函数用来计算周围的存活点的个数
     */
    public int getCount(int[][] array, int x, int y) {
        int count = 0;//保存活点
        for (int i = -1; i <= 1; i++) {         //-1  0  1
            for (int j = -1; j <= 1; j++) {     //-1  0  1
                if (i == 0 && j == 0) {
                    continue;
                }
                if (checkLocation(array, x + i, y + j)) {
                    if (array[x + i][y + j] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /*
    * 检查下标是否合法
    */
    public boolean checkLocation(int[][] array, int x, int y) {
        if (x < 0 || y < 0 || x > array.length - 1 || y > array[0].length - 1) {
            return false;
        }
        return true;
    }

    /**
     * 该方法用来控制帧的显示频率
     */
    private static void cycleTime() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }


    /**
     * 使用随机数生成初始矩阵
     * @param n
     * @return
     */
    private static int[][] initArray(int n,int m) {
        Random random = new Random();
        int init[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                init[i][j] = random.nextInt(2);
            }
        }
        return init;
    }

    /**
     * 打印生命矩陣
     * @param temp
     */
    public void printArray(int[][] temp) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (temp[i][j] == 1) {
                    System.out.print("*");
                } else
                    System.out.print("-");
            }
            System.out.println();
        }
    }
}

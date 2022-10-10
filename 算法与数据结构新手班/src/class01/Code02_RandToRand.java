package class01;

import java.sql.SQLOutput;

/**
 * @Auther: Yangkf
 * @Description: class01
 */
public class Code02_RandToRand {
    //这是一个main方法，是程序的入口：
    public static void main(String[] args) {

        System.out.println("测试开始");


        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.3) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("======================");

        //[0,1)  -> [0,8)
        count = 0;
        //double ans = Math.random() * 8;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 5 / (double) 8);


        int K = 9;
        //[0,K) -> [0,8]
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * K); //[0,K-1)
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数,出现了 " + counts[i] + " 次");
        }

        System.out.println("============================");

        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = g();
            counts[num]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数,出现了 " + counts[i] + " 次");
        }

    }


    /**
     * 返回[0,1)的一个小数
     * 任意想x,x属于[0,1),[0,x)范围上的数出现概率由原来的x调整成x平方
     *
     * @return
     */
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    //lib里的，不能改！
    //0-5随机返回
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    //随机机制，只能用f1,
    //等概率返回0和1
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 得到000 ~ 111 做到0-7等概率返回
     */
    public static int f3() {
        return ((f2() << 2) + (f2() << 1) + (f2() << 0));//100 110 111
    }

    /**
     * 0-6等概率返回
     */
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    /**
     * 0-7等概率返回
     * @return
     */
    public static int g() {
        return f4() + 1;
    }

    //你只能知道，x会以固定概率返回0和1，你看不到！
    public static int x(){
        return Math.random()  < 0.85 ? 0:1;
    }

    //等概率返回0和1
    public static int y(){
        int ans = 0;
        do{
            ans = x();
        }while(ans == x());
        //ans = 0 1
        //ans = 1 0
        return ans;
    }
}

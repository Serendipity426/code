package class01;
/**
 * @Auther: Yangkf
 * @Description: class01
 */
public class Code01_SumOfFactorial {
    public static long f1(int N){
        long ans = 0;
        for(int i = 1; i <= N; i++){
            ans += factorial(i);
        }
        return ans;
    }

    public static long factorial(int N){
        long ans =1;
        for(int i = 1; i <= N; i++){
            ans *= i;
        }
        return ans;
    }

    public static long f2(int N){
        long ans = 0;
        int cur = 1;
        for(int i = 1; i <= N; i++){
            cur *= i;
            ans += cur;
        }
        return ans;
    }

    //这是一个main方法，是程序的入口：
    public static void main(String[] args) {
        int N = 10;
        System.out.println(f1(N));
        System.out.println(f2(N));
    }
}

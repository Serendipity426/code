package bit_operation;

/**
 * @Auther: Yangkf
 * @Description: bit_operation
 * 230827
 */
//打印二进制
public class print_binary {

    //打印函数
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1"); //& 当1左移到31位上时与num & 如果结果是0，说明，索引是31的位置上的数是,0，否则是1
        }
        System.out.println(); //pint() 调用之后，再换行
    }

    public static void main(String[] args) {
        // 32位 每一个数底层都是32位
//        int num = 1;
//        print(num);
//        print(num << 1); //一个数左移以后用0来补 一个数左移1位相当于num*2
//        print(num << 2);
//        print(num << 3);


//        int a = Integer.MAX_VALUE; // java中整形的最大值
//        System.out.println(a);
//        print(a);     //为什么不都占满呢，最高位不占，留着最高位的1有特殊含义，表示的最大值是2*32-1
//        print(-1);


//        int b = Integer.MIN_VALUE; //整数的最小值
//        print(b);
//        int c = 1672577;
//          print(c);
//          print(~c);
//
//          print(-5);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

//        int d = 12378;
//        int e = 16834;
//        print(d);
//        print(e);
//        System.out.println("=========================");
//        print(d | e);  //或    有一个是1 就为1
//        print(d & e);  //与    两 都为1  就为1
//        print(d ^ e);  //亦或  相同为0，不同为1

//        int f = Integer.MIN_VALUE;
//        int g = 1024;
//        print(f);
//        print(f >> 5);   // 拿符号位补的右移
//        print(f >>> 5);  //  不带符号右移，新位置用0补
//
//        print(g);
//        print(g >> 4);
//        print(g >>> 4);

        int h = -5;
        //int i = -5;
        int j = (~h + 1);
        System.out.println(h);
        //System.out.println(i);
        System.out.println(j);
    }
}

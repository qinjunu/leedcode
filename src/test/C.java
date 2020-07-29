package test;

import java.io.IOException;
import java.util.Scanner;

class D{
	
}
public class C implements A,B{
	D d = new D();
	static int[] test() {
		return new int[] {1,2};
	}
	public static void main(String[] args) throws IOException {
//		int[] array = new int[10];
//		int[][] array1 = {{1,2},{1,2,3}};
//		String str = "asd";
//		for(int i = 0; i < array.length; i++) {
//			array[i] = i;
//		}
//		for(int i:array) {
//			System.out.print(i);
//		}
//		Character c = '1';
//		System.out.println(Character.isDigit(c));
//		System.out.println(Arrays.toString(test()));
//		System.out.println(Arrays.toString(array1));
//		System.out.println(c.toString());
//		System.out.println(str.toString());
//		Date date = new Date();
//		SimpleDateFormat ft = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        System.out.println(date.toString());
//        System.out.println(ft.format(date));
//        System.out.println(String.valueOf(test()));
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("next方式接收：");
		if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
		
        scan.close();
	}

}

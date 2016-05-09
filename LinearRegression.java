package cn.sun.linear;
import java.util.Scanner;

/***
 * very easy linear regression for y=w*x+b
 * @author sun
 *
 */

public class EasyLinear {
	
	
	public static void main(String[] args){
		
		double[] x;      							//represent input  data (real)
		double[] y;      							//represent output data (real)
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入测试序列个数:");
		int len = scanner.nextInt();
		x = new double[len];        				//object-instantiated
		y = new double[len];        				//object-instantiated
		System.out.println("请输入各个x序列:");		
		for(int i=0; i<len; i++){
			x[i] = scanner.nextDouble();
		}
		System.out.println("请输入各个y序列:");		
		for(int i=0; i<len; i++){
			y[i] = scanner.nextDouble();
		}
		
		double[] result = linearRegression(x,y);    //for y=w*x+b to find w,b return as result
		
		System.out.println("*****************************************");
		System.out.println("测试结果如下:");
		System.out.printf("w = %.4f;  b= %.4f", result[0], result[1]);
		System.out.println();
		System.out.printf("最后结果符合函数： y = %.4f * x + %.4f", result[0], result[1]);
		System.out.println();
		System.out.println("*****************************************");
		
	}

	private static double[] linearRegression(double[] x, double[] y) {
		double[] result = new double[2];
		
		double sum_x = sum(x,1);                            //order x's sum 
		double avg_x = sum_x / x.length;                    //order x's avg
		double[] cal_w_up = new double[x.length];           //calculate w
		double cal_w_down = sum(x,2)-(sum_x*sum_x)/x.length;//calculate w
		for(int i=0; i<x.length; i++){              
			cal_w_up[i] = y[i] * (x[i] - avg_x);
		}
		result[0] = sum(cal_w_up,1)/cal_w_down;             //put w in the array [0] position
		
		double[] cal_b = new  double[x.length];
		for(int i=0; i<x.length; i++){
			cal_b[i] = y[i] - result[0]*x[i];
		}
		result[1] = sum(cal_b,1)/x.length;
		return result;
	}

	private static double sum(double[] array, int flag) {   //flag means whether array should be square
		double sum = 0;
		for(int i=0; i<array.length; i++){
			if(flag==1){
				sum += array[i];
			}
			else if(flag==2){
				sum += array[i]*array[i];				
			}
			else
				System.out.println("当计算总和时标记符号出错");
		}
		return sum;
	}

}

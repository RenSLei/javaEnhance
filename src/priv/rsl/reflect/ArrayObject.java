package priv.rsl.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

/** 
* @ClassName: ArrayObject 
* @Description: TODO  讲解数组与object的关系：
* 1、同一种类型的数组且维数相同所对应的字节码文件才是相同的；
* 2、int型的字节码文件的父类和String型的字节码文件的父类相同都是：java.lang.object
* 3、基本数据类型不能转换为object
* 4、对于Arrays中的asList方法处理int[]和String[]的差异：
* 	1) 对于int的数组，jak1.4不能处理，因为他的参数类型是:asList(object[] a)
* 	从而交给jdk1.5来处理：asList(T...a),于是就把一个数组当成了一个参数，而我们实际是想传递整个数组
* 	2) 对于String的数组，jak1.4就能处理，因为他的参数类型是:asList(object[] a)
* @author rsl
* @date 2018年2月26日 下午5:03:13 
*  
*/
public class ArrayObject {

    public static void main(String[] args) {
	int[] a1 = new int[] {3,5,6};
	int[] a2 = new int[4];
	int[][] a3 = new int[2][3];
	String[] a4 = new String[] {"world","java","hello"};
	
/*	同一种类型的数组且维数相同所对应的字节码文件才是相同的：
 * 	a1.getClass()和a2.getClass()相等
 * 	a1.getClass()和a3.getClass()不等
 * 	a1.getClass()和a4.getClass()不等
 * 
*/	
	System.out.println(a1.getClass()==a2.getClass());//true
	
	System.out.println(a1.getClass().getName());//[I   I表示是int型的
	System.out.println(a3.getClass().getName());//[[I
	System.out.println(a4.getClass().getName());//[Ljava.lang.String;
	
	//他们的父类都是java.lang.Object吗？是的
	
	System.out.println(a1.getClass().getSuperclass().getName());//java.lang.Object
	System.out.println(a4.getClass().getSuperclass().getName());//java.lang.Object
	
	//但是基本数据类型不是object，请看：
	Object obj1 = a1;
	Object obj2 = a4;
//	Object[] obj3 = a1;是不允许的,因为基本数据类型不能转换为object
	Object[] obj4 = a3;//允许因为a3是一个数组类型的数组，不是基本数据类型
	Object[] obj5 = a4;//允许，因为a4是String类型的数组，而String类型是可以转换为object的
	
	System.out.println(a1);//[I@7852e922
	//如何将数组中的内容一次性打出来呢？
	System.out.println(Arrays.asList(a1));//[[I@7852e922]
	System.out.println(Arrays.asList(a4));//[world, java, hello]
	//为什么对于整形类型的数组就不行，而对于String类型就可以呢？
/*	
	对于a1来说：是int的数组，jak1.4就不能处理，因为他的参数类型是:asList(object[] a)
	从而交给jdk1.5来处理：asList(T...a),于是就把一个数组当成了一个参数，而我们实际是想传递整个数组
	对于a4来说：是String的数组，jak1.4就能处理，因为他的参数类型是:asList(object[] a)
*/  
	
	printObject(a4);
	printObject("hello world");
	
	}

    /** 
    * @Title: printObject 
    * @Description: TODO
    * 用反射的方法操作数组：
    * 1、获取长度
    * 2、获取元素值
    *   
    * @param obj 
    * @return void
    * @throws 
    */
    public static void printObject(Object obj) {
	// 得到该对象的Class文件
	Class clazz = obj.getClass();
	if (clazz.isArray()) {
	    for (int i = 0; i < Array.getLength(obj); i++) {
		System.out.println(Array.get(obj, i));
	    }

	} else {
	    System.out.println(obj);
	}
    }
}

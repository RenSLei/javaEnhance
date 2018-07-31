package priv.rsl.reflect;

import java.lang.reflect.Constructor;

/** 
* @ClassName: ReflectConStructor 
* @Description: TODO -讲解:类Constructor
* java.lang.reflect.Constructor:类Constructor
* 
* @author rsl
* @date 2018年2月8日 下午5:00:53 
*  
*/
public class ReflectConstructor {

    public static void main(String[] args) throws Exception {
	// 演示通过反射实现：new String(new StringBuffer("abc"));//
	// 注意，String有很多构造方法，所以参数列表里要确定是获得哪一个构造方法
	Constructor<String> constructor1 = String.class.getConstructor(StringBuffer.class);// 通过Class类的方法获得该类的构造函数实例对象,
	String str2 = constructor1.newInstance(new StringBuffer("abc"));// 调用该对象的方法，实现：new String(new
									// StringBuffer("abc"));
	System.out.println(str2);// abc
	System.out.println(str2.toUpperCase());// ABC

	// Class类中也有newInstance方法，该方法就是创建一个它所表示的类的空参数的实例对象，这样就简化了创建实例对象的过程
	String str3 = String.class.newInstance();
	str3 = "fdsoigdaiogh";
	System.out.println(str3.toUpperCase());
    }

}

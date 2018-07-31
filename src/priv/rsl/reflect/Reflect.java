package priv.rsl.reflect;

/** 
* @ClassName: ReflectTest 
* @Description: TODO 
* 一：Class类：
* 	1、Class类概述：
* 	java程序中的各个java类属于同一类事物，描述这类事物的java类名就是Class。
* 	Class类描述了类的名字，访问属性，类所属的包名，字段名称的列表，方法名称的列表
* 	学习反射第一步要明白Class类 
*	2、Class类是代表java类，那么他的各个实例对象又分别对应什么呢？
* 	答：对应各个类在内存中的字节码；
* 	3、如何得到各个字节码对应的实例对象（Class类型）？
*	答：	1):类名.class,如String.class
*		2):对象.getClass();如：new String("abc").getClass();
*		3):Class.forName("类名");如：Class.forName("java.util.Date");
*		只要是同一种类，三种方法对应的Class实例对象相同。
*	4、总之，只要是在源程序中出现的类型，都有各自的实例对象，如int[]、void...
*二、反射概述：
*	反射就是将java类中的各种成分映射成相应的java类：
*	一个类中可能有：多个成员变量、多个方法、多个构造方法、包等等。
*	而Class类就提供了方法以获取表示上述java成分种类，
*	如Field、Method、Constructor、Package,它们表示java类中的字段类
*	方法类、构造函数类、包，而它们的对象就是对应的具体内容，如方法1、方法2...
* @author rsl
* @date 2018年2月8日 下午2:35:36 
*  
*/
public class Reflect {

    public static void main(String[] args) throws Exception {
	String str1 = "abc";
	System.out.println(str1.getClass()==String.class);//true
	System.out.println(String.class==Class.forName("java.lang.String"));//true
	
	//基本数据类型的类.TYPE也是该类对应的基本数据类型的字节码
	System.out.println(Integer.TYPE==int.class);//true
	
	//判断是不是原始基本数据类型
	System.out.println(str1.getClass().isPrimitive());//false:String类型不是基本数据类型
	System.out.println(int.class.isPrimitive());//true
	
	//判断是不是数组:Class.isArray();
	System.out.println(int[].class.isArray());//true
	
    }

}

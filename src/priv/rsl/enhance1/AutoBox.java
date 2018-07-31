package priv.rsl.enhance1;

/** 
* @ClassName: AutoBox 
* @Description: TODO  
* 讲解自动拆箱与装箱:(jdk1.5版本特性)：
* 装箱：将一个数据自动的封装为基本数据类型对象
* 拆箱：将一个基本数据类型对象自动的拆为基本数据
* 享元设计模式（flyweight）:享元模式：很多个重复使用的小对象，他们有一些共同的属性，将这个共同的属性(内部状态)抽取出来，形成一个对象，
	 而将不同的属性(外部状态)定义为外部的变量作为方法的参数传入.
* 
* @author rsl
* @date 2018年2月7日 上午11:43:52 
*  
*/
public class AutoBox {


    public static void main(String[] args) {
//	装箱：将一个数据自动的封装为基本数据类型对象
	Integer iObj = 3;
//	拆箱：将一个基本数据类型对象自动的拆为基本数据
	System.out.println(iObj+2);
	
	//引出一个小知识：
//先看关于String的比较：
	//s1和s2是两个对象
	String s1 = new String("abc");
	String s2 = new String("abc");
	
	//s3和s4是同一个对象，字符串String一旦初始化就不可更改
	String s3 = "abc";
	String s4 = "abc";
	
	System.out.println(s1==s2);//false
	System.out.println(s2==s3);//false
	System.out.println(s3==s4);//true
//再看关于装箱与拆箱的比较：
	Integer i1 = 5;//将5自动封装成Integer对象
	Integer i2 = 5;//将5自动封装成Integer对象
	
	Integer i3 = 137;//将137自动封装成Integer对象
	Integer i4 = 137;//将137自动封装成Integer对象
	
	System.out.println(i1==i2);//true
	System.out.println(i3==i4);//false,装出来的对象不一样
//	为什么是false？
//	答：因为jdk默认将-128—127之间的数字认为是经常使用的一些数字，所以在创建对象的时候就将相同值的对象默认是同一个对象
/*	** 这是一个设计模式：享元设计模式，比如英文26个字母重复构成单词一样，就只需要26个对象。这样大大节省了空间。
	**区别：每个对象有一个diaplay(int x ,int y),这样位置的不同就区别开来了。
	** 享元模式：很多个重复使用的小对象，他们有一些共同的属性，将这个共同的属性(内部状态)抽取出来，形成一个对象，
	 而将不同的属性(外部状态)定义为外部的变量作为方法的参数传入.
*/	
	
    }

}

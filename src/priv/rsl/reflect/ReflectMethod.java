package priv.rsl.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* @ClassName: ReflectMethod 
* @Description: TODO 
* 测试通过反射来调用类中的方法 
* @author rsl
* @date 2018年2月23日 下午3:45:31 
*  
*/
public class ReflectMethod {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
	    IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
	String str = "abc";
	Method methodCharAt = String.class.getMethod("charAt", int.class);
	System.out.println(methodCharAt.invoke(str, 1));

	// 调用接受数组参数的成员方法
	//一般的调用方法：
	TestArguments.main(new String[] { "442", "52345" });
	
	// 用反射进行调用:
	String startingClassName = args[0];
	Method mainMethod = Class.forName(startingClassName).getMethod("main", String[].class);

	// null是由于main方法是静态方法
	System.out.println(mainMethod.invoke(null, new Object[] { new String[] { "442", "52345" } }));
	// System.out.println(mainMethod.invoke(null, (Object)newString[]{"442","52345"}));
    }
}

/** 
* @ClassName: TestArguments 
* @Description: TODO
* 对接受数组参数的成员方法进行反射的测试类，该类中包含一个main方法，且参数是数组类型  
* 通过反射的方法进行传递参数该如何传递？
* @author rsl
* @date 2018年2月25日 下午4:13:24 
*  
*/
class TestArguments{
    public static void main(String[] args) {
	for(String arg : args) {
	    System.out.println(arg);
	}
    }
}
    

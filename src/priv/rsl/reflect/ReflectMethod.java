package priv.rsl.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* @ClassName: ReflectMethod 
* @Description: TODO 
* ����ͨ���������������еķ��� 
* @author rsl
* @date 2018��2��23�� ����3:45:31 
*  
*/
public class ReflectMethod {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
	    IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
	String str = "abc";
	Method methodCharAt = String.class.getMethod("charAt", int.class);
	System.out.println(methodCharAt.invoke(str, 1));

	// ���ý�����������ĳ�Ա����
	//һ��ĵ��÷�����
	TestArguments.main(new String[] { "442", "52345" });
	
	// �÷�����е���:
	String startingClassName = args[0];
	Method mainMethod = Class.forName(startingClassName).getMethod("main", String[].class);

	// null������main�����Ǿ�̬����
	System.out.println(mainMethod.invoke(null, new Object[] { new String[] { "442", "52345" } }));
	// System.out.println(mainMethod.invoke(null, (Object)newString[]{"442","52345"}));
    }
}

/** 
* @ClassName: TestArguments 
* @Description: TODO
* �Խ�����������ĳ�Ա�������з���Ĳ����࣬�����а���һ��main�������Ҳ�������������  
* ͨ������ķ������д��ݲ�������δ��ݣ�
* @author rsl
* @date 2018��2��25�� ����4:13:24 
*  
*/
class TestArguments{
    public static void main(String[] args) {
	for(String arg : args) {
	    System.out.println(arg);
	}
    }
}
    

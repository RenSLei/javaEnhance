package priv.rsl.reflect;

import java.lang.reflect.Constructor;

/** 
* @ClassName: ReflectConStructor 
* @Description: TODO -����:��Constructor
* java.lang.reflect.Constructor:��Constructor
* 
* @author rsl
* @date 2018��2��8�� ����5:00:53 
*  
*/
public class ReflectConstructor {

    public static void main(String[] args) throws Exception {
	// ��ʾͨ������ʵ�֣�new String(new StringBuffer("abc"));//
	// ע�⣬String�кܶ๹�췽�������Բ����б���Ҫȷ���ǻ����һ�����췽��
	Constructor<String> constructor1 = String.class.getConstructor(StringBuffer.class);// ͨ��Class��ķ�����ø���Ĺ��캯��ʵ������,
	String str2 = constructor1.newInstance(new StringBuffer("abc"));// ���øö���ķ�����ʵ�֣�new String(new
									// StringBuffer("abc"));
	System.out.println(str2);// abc
	System.out.println(str2.toUpperCase());// ABC

	// Class����Ҳ��newInstance�������÷������Ǵ���һ��������ʾ����Ŀղ�����ʵ�����������ͼ��˴���ʵ������Ĺ���
	String str3 = String.class.newInstance();
	str3 = "fdsoigdaiogh";
	System.out.println(str3.toUpperCase());
    }

}

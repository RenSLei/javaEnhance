package priv.rsl.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

/** 
* @ClassName: ArrayObject 
* @Description: TODO  ����������object�Ĺ�ϵ��
* 1��ͬһ�����͵�������ά����ͬ����Ӧ���ֽ����ļ�������ͬ�ģ�
* 2��int�͵��ֽ����ļ��ĸ����String�͵��ֽ����ļ��ĸ�����ͬ���ǣ�java.lang.object
* 3�������������Ͳ���ת��Ϊobject
* 4������Arrays�е�asList��������int[]��String[]�Ĳ��죺
* 	1) ����int�����飬jak1.4���ܴ�����Ϊ���Ĳ���������:asList(object[] a)
* 	�Ӷ�����jdk1.5������asList(T...a),���ǾͰ�һ�����鵱����һ��������������ʵ�����봫����������
* 	2) ����String�����飬jak1.4���ܴ�����Ϊ���Ĳ���������:asList(object[] a)
* @author rsl
* @date 2018��2��26�� ����5:03:13 
*  
*/
public class ArrayObject {

    public static void main(String[] args) {
	int[] a1 = new int[] {3,5,6};
	int[] a2 = new int[4];
	int[][] a3 = new int[2][3];
	String[] a4 = new String[] {"world","java","hello"};
	
/*	ͬһ�����͵�������ά����ͬ����Ӧ���ֽ����ļ�������ͬ�ģ�
 * 	a1.getClass()��a2.getClass()���
 * 	a1.getClass()��a3.getClass()����
 * 	a1.getClass()��a4.getClass()����
 * 
*/	
	System.out.println(a1.getClass()==a2.getClass());//true
	
	System.out.println(a1.getClass().getName());//[I   I��ʾ��int�͵�
	System.out.println(a3.getClass().getName());//[[I
	System.out.println(a4.getClass().getName());//[Ljava.lang.String;
	
	//���ǵĸ��඼��java.lang.Object���ǵ�
	
	System.out.println(a1.getClass().getSuperclass().getName());//java.lang.Object
	System.out.println(a4.getClass().getSuperclass().getName());//java.lang.Object
	
	//���ǻ����������Ͳ���object���뿴��
	Object obj1 = a1;
	Object obj2 = a4;
//	Object[] obj3 = a1;�ǲ������,��Ϊ�����������Ͳ���ת��Ϊobject
	Object[] obj4 = a3;//������Ϊa3��һ���������͵����飬���ǻ�����������
	Object[] obj5 = a4;//������Ϊa4��String���͵����飬��String�����ǿ���ת��Ϊobject��
	
	System.out.println(a1);//[I@7852e922
	//��ν������е�����һ���Դ�����أ�
	System.out.println(Arrays.asList(a1));//[[I@7852e922]
	System.out.println(Arrays.asList(a4));//[world, java, hello]
	//Ϊʲô�����������͵�����Ͳ��У�������String���;Ϳ����أ�
/*	
	����a1��˵����int�����飬jak1.4�Ͳ��ܴ�����Ϊ���Ĳ���������:asList(object[] a)
	�Ӷ�����jdk1.5������asList(T...a),���ǾͰ�һ�����鵱����һ��������������ʵ�����봫����������
	����a4��˵����String�����飬jak1.4���ܴ�����Ϊ���Ĳ���������:asList(object[] a)
*/  
	
	printObject(a4);
	printObject("hello world");
	
	}

    /** 
    * @Title: printObject 
    * @Description: TODO
    * �÷���ķ����������飺
    * 1����ȡ����
    * 2����ȡԪ��ֵ
    *   
    * @param obj 
    * @return void
    * @throws 
    */
    public static void printObject(Object obj) {
	// �õ��ö����Class�ļ�
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

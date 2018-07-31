package priv.rsl.reflect;

/** 
* @ClassName: ReflectTest 
* @Description: TODO 
* һ��Class�ࣺ
* 	1��Class�������
* 	java�����еĸ���java������ͬһ������������������java��������Class��
* 	Class��������������֣��������ԣ��������İ������ֶ����Ƶ��б��������Ƶ��б�
* 	ѧϰ�����һ��Ҫ����Class�� 
*	2��Class���Ǵ���java�࣬��ô���ĸ���ʵ�������ֱַ��Ӧʲô�أ�
* 	�𣺶�Ӧ���������ڴ��е��ֽ��룻
* 	3����εõ������ֽ����Ӧ��ʵ������Class���ͣ���
*	��	1):����.class,��String.class
*		2):����.getClass();�磺new String("abc").getClass();
*		3):Class.forName("����");�磺Class.forName("java.util.Date");
*		ֻҪ��ͬһ���࣬���ַ�����Ӧ��Classʵ��������ͬ��
*	4����֮��ֻҪ����Դ�����г��ֵ����ͣ����и��Ե�ʵ��������int[]��void...
*�������������
*	������ǽ�java���еĸ��ֳɷ�ӳ�����Ӧ��java�ࣺ
*	һ�����п����У������Ա���������������������췽�������ȵȡ�
*	��Class����ṩ�˷����Ի�ȡ��ʾ����java�ɷ����࣬
*	��Field��Method��Constructor��Package,���Ǳ�ʾjava���е��ֶ���
*	�����ࡢ���캯���ࡢ���������ǵĶ�����Ƕ�Ӧ�ľ������ݣ��緽��1������2...
* @author rsl
* @date 2018��2��8�� ����2:35:36 
*  
*/
public class Reflect {

    public static void main(String[] args) throws Exception {
	String str1 = "abc";
	System.out.println(str1.getClass()==String.class);//true
	System.out.println(String.class==Class.forName("java.lang.String"));//true
	
	//�����������͵���.TYPEҲ�Ǹ����Ӧ�Ļ����������͵��ֽ���
	System.out.println(Integer.TYPE==int.class);//true
	
	//�ж��ǲ���ԭʼ������������
	System.out.println(str1.getClass().isPrimitive());//false:String���Ͳ��ǻ�����������
	System.out.println(int.class.isPrimitive());//true
	
	//�ж��ǲ�������:Class.isArray();
	System.out.println(int[].class.isArray());//true
	
    }

}

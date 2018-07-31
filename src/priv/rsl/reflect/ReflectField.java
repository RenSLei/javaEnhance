package priv.rsl.reflect;

import java.lang.reflect.Field;

/** 
* @ClassName: ReflectField 
* @Description: TODO  ���⣺��Field
* java.lang.reflect.Constructor:��Field
* 
* @author rsl
* @date 2018��2��18�� ����11:22:10 
*  
*/
public class ReflectField {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	ReflectPoint pt1 = new ReflectPoint(3,5);
	
	//ע�⣺fieldY���Ƕ������ϵı������������ϵģ�Ҫ����ȥȡ��Ӧ�����϶�Ӧ��ֵ
	Field fieldY = pt1.getClass().getField("y");
	//��������Ӧ�ܶ���󣬲�ͬ�Ķ����Ӧ��yֵ��ͬ������Ҫ��ȷȡ�ĸ������ֵ��
	System.out.println(fieldY.get(pt1));
	
	
	// ע�⣺fieldX�����ϵı���������Ҫ��getDeclaredField()����ȡ(��Ϊ˽��);
	Field fieldX = pt1.getClass().getDeclaredField("x");
	//���˱�������Ϊ���Է��ʵ�
	fieldX.setAccessible(true);
	// ��ͬ�Ķ����Ӧ��yֵ��ͬ������ȡֵҪ��ȷ����һ�������ֵ��
	System.out.println(fieldX.get(pt1));
	
	//дһ����������һ�����е�����String���͵ı����е�b��Ϊa
	changeStringValue(pt1);
	System.out.println(pt1.toString());
    }

    private static void changeStringValue(Object obj) throws IllegalArgumentException, IllegalAccessException {
	Field[] fields = obj.getClass().getFields();
	for (Field field : fields) {
	    if(field.getType()==String.class) {
		String oldValue = (String)field.get(obj);
		String newValue = oldValue.replace('b', 'a');
		field.set(obj, newValue);
	    }
	}
    }
}

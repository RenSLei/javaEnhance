package priv.rsl.reflect;

import java.lang.reflect.Field;

/** 
* @ClassName: ReflectField 
* @Description: TODO  讲解：类Field
* java.lang.reflect.Constructor:类Field
* 
* @author rsl
* @date 2018年2月18日 上午11:22:10 
*  
*/
public class ReflectField {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	ReflectPoint pt1 = new ReflectPoint(3,5);
	
	//注意：fieldY不是对象身上的变量，而是类上的，要用它去取对应对象上对应的值
	Field fieldY = pt1.getClass().getField("y");
	//如果该类对应很多对象，不同的对象对应的y值不同，所以要明确取哪个对象的值。
	System.out.println(fieldY.get(pt1));
	
	
	// 注意：fieldX是类上的变量，而且要用getDeclaredField()方法取(因为私有);
	Field fieldX = pt1.getClass().getDeclaredField("x");
	//将此变量设置为可以访问的
	fieldX.setAccessible(true);
	// 不同的对象对应的y值不同，所以取值要明确是哪一个对象的值。
	System.out.println(fieldX.get(pt1));
	
	//写一个方法：将一个类中的所有String类型的变量中的b改为a
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

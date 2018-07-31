package priv.rsl.reflect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ArrayListHashSet {

    /** 
    * @Title: main 
    * @Description: TODO  
    * 1、先看ArrayList和HashSet的区别：
    * ArrayList底层是数组类型的，元素可以重复，有序号
    * HashSet底层是哈希表：元素是不可以重复的。
    * 2、关于HashCode：
    * 针对底层算法是HashCode算法的集合而言，集合会根据元素的自身属性进行一个hashCode值的计算，
    * 该计算结果就决定了该元素存放的引用的区域，那么在每存放一个新的元素的时候，根据要存储的元素的HashCod值在指定的区域查找
    * 比较是否是同一个元素，这样就节省了时间，从而保证这种集合不可以重复的特点；
    * 一般会在对象中同时覆盖equals方法和HashCode方法
    * 
    * 3、...
    */
    public static void main(String[] args) {
	//创建一个ArrayList集合
	Collection<ReflectPoint> arrayList = new ArrayList<ReflectPoint>();
	Collection<ReflectPoint> hashSet = new HashSet<ReflectPoint>();
	ReflectPoint pt1 = new ReflectPoint(3,3);
	ReflectPoint pt2 = new ReflectPoint(5,5);
	ReflectPoint pt3 = new ReflectPoint(3,3);
	
	//1、先看ArrayList和HashSet的区别：
	System.out.println(arrayList.add(pt1));//true
	System.out.println(arrayList.add(pt2));//true
	System.out.println(arrayList.add(pt3));//true
	System.out.println(arrayList.add(pt1));//true
	
	System.out.println(hashSet.add(pt1));//true
	System.out.println(hashSet.add(pt2));//true
	System.out.println(hashSet.add(pt1));//false
	
	//在ReflectPoint中重载了HashCode和equals方法以后就是false
	System.out.println(hashSet.add(pt3));//false
    }

}

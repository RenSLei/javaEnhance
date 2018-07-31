package priv.rsl.reflect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ArrayListHashSet {

    /** 
    * @Title: main 
    * @Description: TODO  
    * 1���ȿ�ArrayList��HashSet������
    * ArrayList�ײ����������͵ģ�Ԫ�ؿ����ظ��������
    * HashSet�ײ��ǹ�ϣ��Ԫ���ǲ������ظ��ġ�
    * 2������HashCode��
    * ��Եײ��㷨��HashCode�㷨�ļ��϶��ԣ����ϻ����Ԫ�ص��������Խ���һ��hashCodeֵ�ļ��㣬
    * �ü������;����˸�Ԫ�ش�ŵ����õ�������ô��ÿ���һ���µ�Ԫ�ص�ʱ�򣬸���Ҫ�洢��Ԫ�ص�HashCodֵ��ָ�����������
    * �Ƚ��Ƿ���ͬһ��Ԫ�أ������ͽ�ʡ��ʱ�䣬�Ӷ���֤���ּ��ϲ������ظ����ص㣻
    * һ����ڶ�����ͬʱ����equals������HashCode����
    * 
    * 3��...
    */
    public static void main(String[] args) {
	//����һ��ArrayList����
	Collection<ReflectPoint> arrayList = new ArrayList<ReflectPoint>();
	Collection<ReflectPoint> hashSet = new HashSet<ReflectPoint>();
	ReflectPoint pt1 = new ReflectPoint(3,3);
	ReflectPoint pt2 = new ReflectPoint(5,5);
	ReflectPoint pt3 = new ReflectPoint(3,3);
	
	//1���ȿ�ArrayList��HashSet������
	System.out.println(arrayList.add(pt1));//true
	System.out.println(arrayList.add(pt2));//true
	System.out.println(arrayList.add(pt3));//true
	System.out.println(arrayList.add(pt1));//true
	
	System.out.println(hashSet.add(pt1));//true
	System.out.println(hashSet.add(pt2));//true
	System.out.println(hashSet.add(pt1));//false
	
	//��ReflectPoint��������HashCode��equals�����Ժ����false
	System.out.println(hashSet.add(pt3));//false
    }

}

package priv.rsl.enhance1;

/** 
* @ClassName: VariableParameter 
* @Description: TODO
* �ɱ�������ڲ����б�����ʹ�ã�����... ������������ɫʱ���Զ�����һ�����飬����Ĳ����б����ǿ�������ı��  
* ���������ظ÷����ܶ��
* 
* ��������д��
* override����д��

���� 1��������������������ֵ��ͬ��

���� 2�����෽��������С���෽���ķ���Ȩ�ޡ�

���� 3�����෽�������׳��ȸ��෽��������쳣(�����෽�����Բ��׳��쳣)��

���� 4�������ڸ��������֮�䡣

���� 5������������Ϊfinal���ܱ���д��

��overload�����أ�

����1���������͡�������˳��������һ������ͬ�� 

����2����������ֻ�з���ֵ��ͬ�ķ�������

����3�������ڸ�������ࡢͬ���С�
* @author rsl
* @date 2018��2��7�� ����4:27:50 
*  
*/
public class VariableParameter {

    public static void main(String[] args) {
	System.out.println(getSum(23,436,6,57,2));
	System.out.println(getSum(23,436));
    }
    public static int getSum(int x ,int ... arr) {
	int sum = x;
	for (int i = 0; i < arr.length; i++) {
	   sum+=arr[i];
	}
	return sum;
    }

}

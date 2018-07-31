package priv.rsl.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/** 
* @ClassName: FrameworkReflect 
* @Description: TODO ��ܵĸ����Լ��÷��似��������ܵ�ԭ��
* �μ�FrameworkReflect1.jpg
* 
* ����Ƿ��似��������ܵ�ԭ��ֻ��Ҫ�������ļ�(config.properties)���޸������Ϳ���ʵ�ַ�����Ӧ������
* @author rsl
* @date 2018��2��27�� ����9:29:15 
*  
*/
public class FrameworkReflect {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	//��������һ����Դ�ļ������������ǵ�������config.properties
	//InputStream ips = new FileInputStream("config.properties");
	
	//����������ķ�ʽ������Դ�������ļ���ֻ�Ƕ���ʱ�������ֱȽϺã�������������ļ������ʱ�������ļ��ͱ������ˣ��������ļ�Ҫ����classPath��(src Ŀ¼��)
	InputStream ips = 
		FrameworkReflect.class.getClassLoader().getResourceAsStream("priv/rsl/reflect/config.properties");
	
	 /*���߼򻯲�����ֱ�ӷ��ļ�������ΪĬ��Ϊ�ð�Ŀ¼�� 
	InputStream ips =
	 FrameworkReflect.class.getResourceAsStream("config.properties");
	 
	 ���ߣ�
	 
	 */
	
	
	//���ȴ���Properties����
	Properties props = new Properties();
	//����һ������������
	props.load(ips);
	ips.close();//�ر���Դ
	//������ȡ����
	String className = props.getProperty("className");
	//�÷���ķ�ʽ������ȷ������Ķ���(�ؼ�)
	Collection collections = (Collection)Class.forName(className).newInstance();
/*	�ȼ��ڣ�Collection collections = new ArrayList();
*/	
	ReflectPoint pt1 = new ReflectPoint(3, 3);
	ReflectPoint pt2 = new ReflectPoint(5, 5);
	ReflectPoint pt3 = new ReflectPoint(3, 3);
	collections.add(pt1);
	collections.add(pt2);
	collections.add(pt1);

	System.out.println(collections.size());//
    }

}

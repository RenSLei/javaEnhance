package priv.rsl.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/** 
* @ClassName: FrameworkReflect 
* @Description: TODO 框架的概念以及用反射技术开发框架的原理
* 参见FrameworkReflect1.jpg
* 
* 这就是反射技术开发框架的原理，只需要在配置文件(config.properties)中修改类名就可以实现访问相应的类了
* @author rsl
* @date 2018年2月27日 下午9:29:15 
*  
*/
public class FrameworkReflect {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	//首先配置一个资源文件，里面存放我们的类名：config.properties
	//InputStream ips = new FileInputStream("config.properties");
	
	//用类加载器的方式管理资源和配置文件：只是读的时候用这种比较好，随着类加载器的加载类的时候，配置文件就被加载了，即配置文件要放在classPath下(src 目录下)
	InputStream ips = 
		FrameworkReflect.class.getClassLoader().getResourceAsStream("priv/rsl/reflect/config.properties");
	
	 /*或者简化操作：直接放文件名，因为默认为该包目录下 
	InputStream ips =
	 FrameworkReflect.class.getResourceAsStream("config.properties");
	 
	 或者：
	 
	 */
	
	
	//首先创建Properties对象
	Properties props = new Properties();
	//加载一个输入流进来
	props.load(ips);
	ips.close();//关闭资源
	//将类名取出来
	String className = props.getProperty("className");
	//用反射的方式创建不确定的类的对象：(关键)
	Collection collections = (Collection)Class.forName(className).newInstance();
/*	等价于：Collection collections = new ArrayList();
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

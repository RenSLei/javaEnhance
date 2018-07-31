package priv.rsl.reflect;

/** 
* @ClassName: ReflectPoint 
* @Description: TODO 创建一个用于测试Field类、HashSet的类  
* @author rsl
* @date 2018年2月18日 上午11:35:11 
*  
*/
public class ReflectPoint {
    private int x;
    public int y;
    public String str1 = "ball";
    public String str2 = "basketball";
    public String str3 = "home";
    public ReflectPoint(int x, int y) {
	super();
	this.x = x;
	this.y = y;
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + x;
	result = prime * result + y;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ReflectPoint other = (ReflectPoint) obj;
	if (x != other.x)
	    return false;
	if (y != other.y)
	    return false;
	return true;
    }

    public String toString() {
	return str1 + ";"+str2+";"+str3;
    }
    
}

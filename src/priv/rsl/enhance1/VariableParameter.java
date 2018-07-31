package priv.rsl.enhance1;

/** 
* @ClassName: VariableParameter 
* @Description: TODO
* 可变参数：在参数列表的最后使用：类型... 数组名，编译色时候自动生成一个数组，里面的参数列表长度是可以任意改变的  
* 而不用重载该方法很多次
* 
* 重载与重写：
* override（重写）

　　 1、方法名、参数、返回值相同。

　　 2、子类方法不能缩小父类方法的访问权限。

　　 3、子类方法不能抛出比父类方法更多的异常(但子类方法可以不抛出异常)。

　　 4、存在于父类和子类之间。

　　 5、方法被定义为final不能被重写。

　overload（重载）

　　1、参数类型、个数、顺序至少有一个不相同。 

　　2、不能重载只有返回值不同的方法名。

　　3、存在于父类和子类、同类中。
* @author rsl
* @date 2018年2月7日 下午4:27:50 
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

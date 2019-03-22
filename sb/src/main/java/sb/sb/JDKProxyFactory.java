package sb.sb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 代理工厂类
 * @author hyj
 *
 */
public class JDKProxyFactory implements InvocationHandler{
    //要返回的代理对象
   private Object obj;
   /**
    * 通过代理工厂的方式来创建代理类
    * @param obj  要代理的类的对象
    * @return
    */
   public Object createProxyIntance(Object obj){
       this.obj=obj;
       //第一个参数是目标对象的类加载器
       //第二个参数是目标对象实现的接口
       //第三个参数传入一个InvocationHandler实例，该参数和回调有关系。
       return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),this);
       
   }
    
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        // TODO Auto-generated method stub
        return null;
    }
   
   
}
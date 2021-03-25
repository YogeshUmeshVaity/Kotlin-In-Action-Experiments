package reifiedtypeparameters;

import reifiedtypeparameters.javainterop.JavaInteropKt;
import reifiedtypeparameters.javainterop.MyClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReifiedJavaTest {
    public static void main(String[] args) {
        // doSomething34("Hello");
        try {
            Method method = JavaInteropKt.class.getDeclaredMethod("doSomething34", Object.class);
            method.invoke("hello", Object.class);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Method method = MyClass.class.getDeclaredMethod("foo", Object.class);
            method.invoke(new MyClass(), Object.class);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

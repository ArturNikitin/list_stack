import classloader.MyClassloader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter jarPath, packagePath, className and method name");
        String jarName = reader.readLine();
        String packageName = reader.readLine();
        String className = reader.readLine();
        String methodName = reader.readLine();


        /*MyClassloader classloader = new MyClassloader("E:\\andetsen-training\\test-cases\\out\\artifacts\\test_project_jar\\test-project.jar", "load");

        Class<?> load = classloader.loadClass("LoadTest");
        Object obj = load.newInstance();
        Method test = load.getMethod("print");
        test.invoke(obj);*/

        MyClassloader classloader = new MyClassloader(jarName, packageName);

        Class<?> load = classloader.loadClass(className);
        Object obj = load.newInstance();
        Method test = load.getMethod(methodName);
        test.invoke(obj);

    }
}

package classloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MyClassloader extends ClassLoader {
    private Map<String, Class<?>> cache = new HashMap<>();

    private String jarName;
    private String packageName;

    public MyClassloader(String jarName, String packageName) {
        this.jarName = jarName;
        this.packageName = packageName;

        cacheClasses();
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = cache.get(name);

        if (result == null)
            result = cache.get(packageName + "." + name);

        if (result == null) {
            result = super.findSystemClass(name);
        }

        System.out.println("== loadClass(" + name + ")");
        return result;
    }

    private void cacheClasses() {
        try {
            JarFile jarFile = new JarFile(jarName);
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                if (match(normalize(jarEntry.getName()), packageName)) {
                    byte[] classData = loadClassData(jarFile, jarEntry);
                    if (classData != null) {
                        Class<?> clazz = defineClass(stripClassName(normalize(jarEntry.getName())), classData, 0, classData.length);
                        cache.put(clazz.getName(), clazz);
                        System.out.println("== class " + clazz.getName() + " loaded in cache");
                    }
                }
            }
        } catch (Exception exp) {
            System.out.println("JAR file was not found");
        }
    }

    private String stripClassName(String className) {
        return className.substring(0, className.length() - 6);
    }

    private String normalize(String className) {
        return className.replace('/', '.');
    }

    private boolean match(String className, String packageName) {
        return className.startsWith(packageName) && className.endsWith(".class");
    }

    private byte[] loadClassData(JarFile jarFile, JarEntry jarEntry) throws IOException {
        long size = jarEntry.getSize();
        if (size == -1 || size == 0)
            return null;
        byte[] data = new byte[(int)size];
        InputStream in = jarFile.getInputStream(jarEntry);
        in.read(data);
        return data;
    }
}

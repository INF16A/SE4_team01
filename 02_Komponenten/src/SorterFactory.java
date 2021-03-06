import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class SorterFactory {
    public static Object create() {
        Object sortPort = null;
        try {
            URL[] urls = {new File(Configuration.instance.getJarPath()).toURI().toURL()};
            URLClassLoader urlLoader = new URLClassLoader(urls, SorterFactory.class.getClassLoader());
            Class sorterClass = Class.forName(Configuration.instance.className, true, urlLoader);
            Object sorterInstance = sorterClass.getMethod("getInstance", new Class[0]).invoke(null);
            sortPort = sorterClass.getDeclaredField("port").get(sorterInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sortPort;
    }
}

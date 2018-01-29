import java.io.FileInputStream;
import java.util.Properties;

public enum Configuration {
    instance;

    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");

    public String sortingAlgorithm = "01";
    public String jarPath = "exchange_component_" + sortingAlgorithm + fileSeparator + "jar" + fileSeparator + "sorter.jar";
    public String fullJarPath = userDirectory + jarPath;
    public String className = "Sorter";

    public String propFile = "sorter.props";

    public SorterType getSorterType() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(userDirectory + fileSeparator + propFile);
            props.load(fis);
            fis.close();
            String selectedProp = props.getProperty("sorterType");
            switch (selectedProp) {
                case "intro":
                    return SorterType.intro;
                case "shaker":
                    return SorterType.shaker;
                default:
                    return null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}

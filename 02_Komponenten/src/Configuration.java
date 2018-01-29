public enum Configuration {
    instantce;

    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");

    public String sortingAlgorithm = "01";
    public String jarPath = "exchange_component_" + sortingAlgorithm + fileSeparator + "jar" + fileSeparator + "sorter.jar";
    public String fullJarPath = userDirectory + jarPath;
    public String className = "Sorter";

}

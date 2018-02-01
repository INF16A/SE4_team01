public enum Configuration {
    instance;

    //public MersenneTwister randomNumberGenerator = new MersenneTwister(System.currentTimeMillis());

    public String fileSeparator = System.getProperty("file.separator");
    public String lineSeparator = System.getProperty("line.separator");

    public String dataPath = "data" + fileSeparator;
    public String logPath = "log" + fileSeparator;

    public int maximumNumberOfTowns = 500;
    public int maximumNumberOfCustomers = 10000;
    public int maximumNumberOfProducts = 750;
    public int maximumNumberOfOrders = 1000000;
}
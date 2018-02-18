public interface IPrimeStrategy {
    public void addListener(IPrimeListener listener);

    public void removeListener(IPrimeListener listener);

    public void start();

    public void stop();
}

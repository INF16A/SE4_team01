public interface IPrimeGenerator {
     void addListener(IPrimeListener listener);

     void removeListener(IPrimeListener listener);

     void start();

     void stop();
}

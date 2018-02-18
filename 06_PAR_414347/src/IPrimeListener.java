import java.math.BigInteger;

public interface IPrimeListener {
    public void primeGenerated(BigInteger nextPrime);

    public void primeGeneratorStopped();
}

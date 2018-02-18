import java.math.BigInteger;
import java.util.List;

public class BlockResult implements Comparable<BlockResult> {
    private final BigInteger blockStart;
    private final BigInteger nextBlockStart;
    private final List<BigInteger> primes;

    public BlockResult(BigInteger blockStart, BigInteger nextBlock, List<BigInteger> primes) {
        this.blockStart = blockStart;
        this.nextBlockStart = nextBlock;
        this.primes = primes;
    }

    public BigInteger getBlockStart() {
        return blockStart;
    }

    public BigInteger getNextBlockStart() {
        return nextBlockStart;
    }

    public List<BigInteger> getPrimes() {
        return primes;
    }

    @Override
    public int compareTo(BlockResult o) {
        if (o == this) {
            return 0;
        }
        return blockStart.compareTo(o.blockStart);
    }
}

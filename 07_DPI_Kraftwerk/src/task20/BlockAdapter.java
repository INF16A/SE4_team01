package task20;

public class BlockAdapter extends Block implements IEnergyGenerationStrategy {
    private EnergyCollectionPoint energyCollectionPoint;

    public BlockAdapter(String type, EnergyCollectionPoint ecp) {
        super(type);
        this.energyCollectionPoint = ecp;
    }

    @Override
    public void generateNormalizedEnergy() {
        energyCollectionPoint.acceptEnergy(getNormalizedEnergy());
    }

    public String getNormalizedEnergy() {
        int counter0 = 0, counter1 = 1;
        String energy = generateEnergy();
        char[] normalizedEnergy = new char[2000]; //buffer has to be bigger
        for (int i = 0; i < energy.length(); i++) {
            char c = energy.charAt(i);
            if (c == '0') {
                normalizedEnergy[counter0] = '0';
                counter0 += 2;
            } else {
                normalizedEnergy[counter1] = '1';
                counter1 += 2;
            }
        }
        // now there are a bunch of zeroes at the end of the normalized energy
        // we need to find the first place where there is no zero in the array
        int endIndex = 1000;
        for (int i = 0; i < normalizedEnergy.length; i++) {
            char c = normalizedEnergy[i];
            if (c != '0' && c != '1') {
                endIndex = i - 1; // the unnecessary zero at the end has to be excluded
                break;
            }
        }
        return new String(normalizedEnergy, 0, endIndex);
    }
}

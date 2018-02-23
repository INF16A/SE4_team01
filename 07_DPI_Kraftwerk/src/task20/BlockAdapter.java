package task20;

public class BlockAdapter extends Block implements IEnergyGeneration {

    public BlockAdapter(String type) {
        super(type);
    }

    @Override
    public String generateNormalizedEnergy() {
        int counter0 = 0, counter1 = 1;
        String energy = generateEnergy();
        char[] normalizedEnergy = new char[1000];
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
        // now there are a bunch of ones at the end of the normalized energy
        // we need to find the first place where there is no zero in the array
        int endIndex = 500;
        for (int i = 0; i < normalizedEnergy.length; i++) {
            char c = normalizedEnergy[i];
            if (c != '0' && c != '1') {
                endIndex = i;
                break;
            }
        }
        return new String(normalizedEnergy, 0, endIndex);
    }
}

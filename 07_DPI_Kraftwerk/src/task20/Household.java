package task20;

class Household {
    void takeHouseHoldEnergy(String energy) {
        String[] energyBlocks = energy.split(" ");
        for (String energyBlock : energyBlocks) {
            if (energyBlock.length() != 4 || !energyBlock.equals("0101")) {
                throw new Error("unknown energy format");
            }
        }
    }
}

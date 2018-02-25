package task20;

public interface IEnergyGenerationStrategy {
    void generateNormalizedEnergy();

    void activate();

    void deactivate();

    boolean isActivated();
}

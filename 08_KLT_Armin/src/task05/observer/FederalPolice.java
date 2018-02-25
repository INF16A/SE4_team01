package task05.observer;

public class FederalPolice implements ISecurityCheckListener {
    public void validityProblemFound() {
        System.out.println("Suspicious passport found -> inquisition");
    }
}

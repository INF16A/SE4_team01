package task05;

import task05.observer.FederalPolice;
import task05.observer.ISecurityCheckListener;
import task05.securityChain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {

    private static final Application instance = new Application();
    private Random random = new Random();

    public static void main(String[] args) {
        FederalPolice police = new FederalPolice();
        SecurityCheck securityCheck = instance.generateChain(police);
        instance.generatePassports(30).forEach(securityCheck::inspect);
    }

    private SecurityCheck generateChain(ISecurityCheckListener listener) {
        SecurityCheck nonEu = new NonEuSecurityCheck(null);
        nonEu.AddListener(listener);

        SecurityCheck eu = new EuSecurityCheck(nonEu);
        eu.AddListener(listener);

        SecurityCheck diplomat = new DiplomatSecurityCheck(eu);
        diplomat.AddListener(listener);

        return diplomat;
    }

    private List<Passport> generatePassports(int count) {
        List<Passport> passports = new ArrayList<>();
        String[] memberships = {"EU", "nonEU", "diplomatic"};
        for (int i = 0; i < count; i++) {
            passports.add(new Passport(memberships[random.nextInt(3)], random.nextDouble() > 0.2));
        }
        return passports;
    }

}

package task05.securityChain;

import task05.observer.ISecurityCheckListener;

public class DiplomatSecurityCheck extends SecurityCheck {
    public DiplomatSecurityCheck(SecurityCheck successor) {
        this.setSucceedingCheck(successor);
    }

    public void inspect(Passport passport) {
        if (!passport.getMembership().equals("diplomatic")) {
            super.inspect(passport);
            return;
        }

        if (passport.IsValid()) {
            System.out.println("pass is valid - confirmed by " + this.getClass().getSimpleName());
            return;
        }
        listeners.forEach(ISecurityCheckListener::validityProblemFound);
    }
}

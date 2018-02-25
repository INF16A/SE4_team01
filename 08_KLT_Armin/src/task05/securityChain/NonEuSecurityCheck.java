package task05.securityChain;

import task05.observer.ISecurityCheckListener;

public class NonEuSecurityCheck extends SecurityCheck {
    public NonEuSecurityCheck(SecurityCheck successor) {
        setSucceedingCheck(successor);
    }

    public void inspect(Passport passport) {
        if (!passport.getMembership().equals("nonEU")) {
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

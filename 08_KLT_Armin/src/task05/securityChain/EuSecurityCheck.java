package task05.securityChain;


import task05.observer.ISecurityCheckListener;

public class EuSecurityCheck extends SecurityCheck {
    public EuSecurityCheck(SecurityCheck succeedingCheck) {
        setSucceedingCheck(succeedingCheck);
    }

    public void inspect(Passport passport) {
        if (!passport.getMembership().equals("EU")) {
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

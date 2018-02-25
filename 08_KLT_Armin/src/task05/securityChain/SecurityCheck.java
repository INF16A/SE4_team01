package task05.securityChain;

import task05.observer.ISecurityCheckListener;
import task05.observer.PassportChecker;

public class SecurityCheck extends PassportChecker {
    private SecurityCheck succeedingCheck;

    protected void setSucceedingCheck(SecurityCheck check) {
        this.succeedingCheck = check;
    }

    public void inspect(Passport passport) {
        if (succeedingCheck != null)
            succeedingCheck.inspect(passport);
        else
            for (ISecurityCheckListener listener : listeners)
                listener.validityProblemFound();
    }

}

package task05.securityChain;

public class Passport {
    private boolean isValid;
    private String membership;

    public Passport(String membership, boolean isValid) {
        this.membership = membership;
        this.isValid = isValid;
    }

    public boolean IsValid() {
        return isValid;
    }

    public String getMembership() {
        return membership;
    }
}

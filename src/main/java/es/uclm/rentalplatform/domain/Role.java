package es.uclm.rentalplatform.domain;

public enum Role {
    TENANT("Inquilino"),
    OWNER("Propietario");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

package ItamarAndOmer;

public enum Degree {
    BA,MA,PHD,PROFESSOR;

    @Override
    public String toString() {
        return switch (this) {
            case BA -> "Bachelor";
            case MA -> "Master";
            case PHD -> "PhD";
            case PROFESSOR -> "Professor";
        };
    }
}
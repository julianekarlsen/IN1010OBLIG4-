

public class UgyldigUtskrift extends RuntimeException {
    UgyldigListeIndeks(int indeks) {
        super("Ugyldig indeks: " + indeks);
    }
}
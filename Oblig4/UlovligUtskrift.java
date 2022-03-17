

public class UlovligUtskrift extends RuntimeException {
    UlovligUtskrift(Lege l, Legemiddler lm) {
        super("Lege " + l.hentNavn() + "har ikke lov aa skrive ut " + lm.hentNavn());
    }
}
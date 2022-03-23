class UlovligUtskrift extends Exception {
    UlovligUtskrift (Lege l, Legemiddel lm) {
	super("Legen " + l.henteUtNavn() + " har ikke lov til aa skrive ut " +
	      lm.hentNavn());
    }
}
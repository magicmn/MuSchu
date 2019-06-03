package de.muSchus.gso.database.util;

public enum Rolle {
    LOGGED_OUT(Constants.LOGGED_OUT),
    LOGGED_IN(Constants.LOGGED_IN),
    LEHRER(Constants.LEHRER),
    VERWALTUNG(Constants.VERWALTUNG);

    Rolle(String rolle) {
        if (!name().equals(rolle)) throw new IllegalArgumentException();
    }

    public static class Constants {
        public static final String LOGGED_OUT = "LOGGED_OUT";
        public static final String LOGGED_IN = "LOGGED_IN";
        public static final String LEHRER = "LEHRER";
        public static final String VERWALTUNG = "VERWALTUNG";
    }
}

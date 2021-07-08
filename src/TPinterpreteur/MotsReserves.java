package TPinterpreteur;


public enum MotsReserves {
    sin,cos,tan,abs,sqrt,log,print,let;
    public static boolean contains(String mot){
        for (Fonction_Standard f : Fonction_Standard.values()) {
            if (f.name().equals(mot)) {
                return true;
            }
        }
        return false;
    }
}


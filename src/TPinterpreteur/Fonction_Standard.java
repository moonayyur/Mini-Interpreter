package TPinterpreteur;

public enum Fonction_Standard {
    sin,cos,tan,abs,sqrt,log;

    public static boolean contains(String mot){
        for (Fonction_Standard f : Fonction_Standard.values()) {
            if (f.name().equals(mot)) {
                return true;
            }
        }
        return false;
    }
    public static Fonction_Standard getType(String nom){
        for (Fonction_Standard f : Fonction_Standard.values()) {
            if (f.name().equals(nom)) {
                return f;
            }
        }
        return sin;
    }

}

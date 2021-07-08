package TPinterpreteur;


public enum MotsReserves {
    sin,cos,tan,abs,sqrt,log,print,let;
    public static boolean contains(String mot){
        for (MotsReserves m : MotsReserves.values()) {
            if (m.name().equals(mot)) {
                return true;
            }
        }
        return false;
    }
}


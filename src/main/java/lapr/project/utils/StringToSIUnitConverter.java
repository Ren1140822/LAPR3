package lapr.project.utils;

/**
 *
 * @author Flavio Relvas
 */
public class StringToSIUnitConverter {

    public static double weight(String s) {
        double value = 0.0;
        if (s.contains("SI")) {
            s = s.replace("SI", "");
            value = Double.parseDouble(s);
        } else {
            if (s.contains("US")) {
                s = s.replace("US", "");
                value = Double.parseDouble(s) * 0.45359237;
            }
        }
        return value;
    }

    public static double volume(String s) {
        double value = 0.0;
        if (s.contains("SI")) {
            s = s.replace("SI", "");
            value = Double.parseDouble(s);
        } else {
            if (s.contains("US")) {
                s = s.replace("US", "");
                value = Double.parseDouble(s) * 0.00378541178;
            }
        }
        return value;
    }

    public static double area(String s) {
        double value = 0.0;
        if (s.contains("SI")) {
            s = s.replace("SI", "");
            value = Double.parseDouble(s);
        } else {
            if (s.contains("US")) {
                s = s.replace("US", "");
                value = Double.parseDouble(s) * 0.0929;
            }
        }
        return value;
    }

    public static double length(String s) {
        double value = 0.0;
        if (s.contains("SI") || s.contains("m")) {
            s = s.replace("SI", "");
            s = s.replace("m", "");
            value = Double.parseDouble(s);
        } else {
            if (s.contains("US")) {
                s = s.replace("US", "");
                value = Double.parseDouble(s) * 0.3048;
            }
        }
        return value;
    }

    public static double TSFC(String s) {
        double value = 0.0;
        if (s.contains("SI")) {
            s = s.replace("SI", "");
            value = Double.parseDouble(s);
        } else {
            if (s.contains("US")) {
                s = s.replace("US", "");
                value = Double.parseDouble(s) / 3600 * 101972;
            }
        }
        return value;
    }

    public static double speed(String s) {
        double value = 0.0;
        if (s.contains("SI") || s.contains("knot")) {
            s = s.replace("SI", "");
            s = s.replace("knot", "");
            value = Double.parseDouble(s);
        } else {
            if (s.contains("US")) {
                s = s.replace("US", "");
                value = Double.parseDouble(s) * 0.447;
            } else {
                if (s.contains("M")) {
                    s = s.replace("M", "");
                    value = Double.parseDouble(s) * 343.2;
                }
            }
        }
        return value;
    }

    public static double force(String s) {
        double value = 0.0;
        if (s.contains("SI")) {
            s = s.replace("SI", "");
            value = Double.parseDouble(s);
        } else {
            if (s.contains("US")) {
                s = s.replace("US", "");
                value = Double.parseDouble(s) * 0.004448;
            }
        }
        return value;
    }
}

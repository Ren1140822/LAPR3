package lapr.project.utils;

/**
 *
 * @author Flavio Relvas
 */
public class DistanceCalculator {

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371e3; // meters

        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = R * c;
        return d;
    }
}

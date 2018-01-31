import java.lang.reflect.Array;

public class Application {
    public static void main(String args) {
        IFlightControl flightControl = new FlightControl();
        Airplane F1 = new Airplane(flightControl);
        Airplane F2 = new Airplane(flightControl);
        Airport A = new Airport(flightControl, 0, 0);
        Airport B = new Airport(flightControl, 0, 1000);

        flightControl.registerAirplane(F1);
        flightControl.registerAirplane(F2);
        flightControl.registerAirport(A);
        flightControl.registerAirport(B);
    }
}

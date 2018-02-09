package taskgroup01.task38;

import java.util.*;

public class Reservation {
    Map<Integer, List<IReservationListener>> reservations = new HashMap<>();

    public Reservation() {
        for (int i = 0; i < 5; i++) {
            reservations.put(i + 1, new ArrayList<>());
        }

    }

    public void sendNotification(int type) {
        if(reservations.get(type).size() > 0) {
            IReservationListener listener = reservations.get(type).remove(0);
            listener.reservationNotification();
        }
    }

    public void addListener(int type, IReservationListener listener) {
        //listeners.add(listener);
        reservations.get(type).add(listener);
    }

    public void removeListener(int type, IReservationListener listener) {
        reservations.get(type).remove(listener);
    }
}

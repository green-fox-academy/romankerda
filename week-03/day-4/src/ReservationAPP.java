import com.greenfoxacademy.reservations.*;

import java.util.ArrayList;
import java.util.List;

public class ReservationAPP {
  public static void main(String[] args) {


    Reservation res1 = new Reservation();
    Reservation res2 = new Reservation();
    Reservation res3 = new Reservation();
    Reservation res4 = new Reservation();
    Reservation res5 = new Reservation();
    Reservation res6 = new Reservation();

    List<Reservation> reservationList = new ArrayList<>();

    reservationList.add(res1);
    reservationList.add(res2);
    reservationList.add(res3);
    reservationList.add(res4);
    reservationList.add(res5);
    reservationList.add(res6);

    for (Reservation r : reservationList) {
      System.out.printf("Booking# %s for %s\n", r.getCodeBooking(), r.getDowBooking());
    }
  }
}

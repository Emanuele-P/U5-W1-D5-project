package ep2024.u5w1d5;

import ep2024.u5w1d5.entities.ReservationList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReservationManagerRunner implements CommandLineRunner {

    @Autowired
    private ReservationList reservationList;

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Reservation List:");
            reservationList.getBuildings().forEach(System.out::println);

            System.out.println("\nGenerated Workstations:");
            reservationList.getWorkstations().forEach(System.out::println);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

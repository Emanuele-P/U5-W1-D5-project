package ep2024.u5w1d5;

import ep2024.u5w1d5.services.BuildingService;
import ep2024.u5w1d5.services.WorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReservationManagerRunner implements CommandLineRunner {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private WorkstationService workstationService;

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println(System.lineSeparator() + "Reservation List:");
            buildingService.findAll().forEach(System.out::println);

            System.out.println(System.lineSeparator() + "Generated Workstations:");
            workstationService.findAll().forEach(System.out::println);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

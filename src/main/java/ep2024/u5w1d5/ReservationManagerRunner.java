package ep2024.u5w1d5;

import ep2024.u5w1d5.entities.Reservation;
import ep2024.u5w1d5.entities.User;
import ep2024.u5w1d5.entities.Workstation;
import ep2024.u5w1d5.enums.WorkstationType;
import ep2024.u5w1d5.services.BuildingService;
import ep2024.u5w1d5.services.ReservationService;
import ep2024.u5w1d5.services.UserService;
import ep2024.u5w1d5.services.WorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ReservationManagerRunner implements CommandLineRunner {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private WorkstationService workstationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

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

        User user = new User("drinkAwayMySorrow", "Jack Sparrow", "blackpearl@example.com");
//        userService.save(user);
//        System.out.println("All users: ");
//        userService.findAll().forEach(System.out::println);
//
        User foundUser = userService.findById(2);
//        System.out.println("User found by ID: " + foundUser);
//
//        System.out.println("Users with username starting with '':");
//        userService.filterByUsername("l").forEach(System.out::println);

//        foundUser.setUsername("avadaKedavra");
//        foundUser.setFullname("Lord Voldemort");
//        foundUser.setEmail("darkLord77@example.com");
//        userService.findByIdAndUpdate(foundUser.getId(), foundUser);
//        System.out.println("User updated: " + foundUser);


        Workstation foundWorkstation = workstationService.findById(4);
        Reservation reservation = new Reservation(LocalDate.now().plusDays(1), foundWorkstation, foundUser);
//        reservationService.save(reservation);

        System.out.println("All reservations: ");
        reservationService.findAll().forEach(System.out::println);

        WorkstationType type = WorkstationType.OPENSPACE;
        String city = "Danniemouth";
        List<Workstation> searchResults = workstationService.findByTypeOrCity(type, city);
        System.out.println(System.lineSeparator() + "Search results for type " + type + " or city " + city);
        searchResults.forEach(System.out::println);

    }
}

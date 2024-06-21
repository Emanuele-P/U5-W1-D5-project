package ep2024.u5w1d5;

import ep2024.u5w1d5.entities.User;
import ep2024.u5w1d5.services.BuildingService;
import ep2024.u5w1d5.services.UserService;
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

    @Autowired
    private UserService userService;

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

        User user = new User("helloworld", "Lord Voldemort", "email@example.com");
//        userService.save(user);
//        System.out.println("All users: ");
//        userService.findAll().forEach(System.out::println);
//
//        User foundUser = userService.findById(1);
//        System.out.println("User found by ID: " + foundUser);
//
//        System.out.println("Users with username starting with '':");
//        userService.filterByUsername("l").forEach(System.out::println);
    }
}

package ep2024.u5w1d5.entities;

import com.github.javafaker.Faker;
import ep2024.u5w1d5.enums.WorkstationType;
import ep2024.u5w1d5.services.BuildingService;
import ep2024.u5w1d5.services.WorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private WorkstationService workstationService;

    @Bean
    public ReservationList initializeData() {
        Faker faker = new Faker();

        List<Building> buildings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Building building = new Building(faker.company().name(), faker.address().streetAddress(), faker.address().city());
            buildings.add(building);
        }
        buildingService.saveAll(buildings);

        List<Workstation> workstations = new ArrayList<>();
        for (Building building : buildings) {
            for (int i = 0; i < 2; i++) {
                Workstation workstation = new Workstation(faker.lorem().sentence(), faker.options().option(WorkstationType.PRIVATE, WorkstationType.OPENSPACE, WorkstationType.OPENSPACE), faker.number().numberBetween(2, 20), building);
                workstations.add(workstation);
            }
        }
        workstationService.saveAll(workstations);

        return new ReservationList(buildings, workstations);
    }
}

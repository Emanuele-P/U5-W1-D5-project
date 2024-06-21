package ep2024.u5w1d5.services;

import ep2024.u5w1d5.entities.Building;
import ep2024.u5w1d5.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    public void saveAll(List<Building> buildings) {
        buildingRepository.saveAll(buildings);
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }
}

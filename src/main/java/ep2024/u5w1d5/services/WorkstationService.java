package ep2024.u5w1d5.services;

import ep2024.u5w1d5.entities.Workstation;
import ep2024.u5w1d5.enums.WorkstationType;
import ep2024.u5w1d5.exceptions.ItemNotFoundException;
import ep2024.u5w1d5.repositories.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkstationService {

    @Autowired
    private WorkstationRepository workstationRepository;

    public void saveAll(List<Workstation> workstations) {
        workstationRepository.saveAll(workstations);
    }

    public List<Workstation> findAll() {
        return workstationRepository.findAll();
    }

    public Workstation findById(long id) {
        return workstationRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public List<Workstation> filterByTypeAndCity(WorkstationType type, String city) {
        return workstationRepository.findByTypeOrCity(type, city);
    }

}

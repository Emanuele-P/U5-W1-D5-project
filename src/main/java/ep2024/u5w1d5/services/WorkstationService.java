package ep2024.u5w1d5.services;

import ep2024.u5w1d5.entities.Workstation;
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

}

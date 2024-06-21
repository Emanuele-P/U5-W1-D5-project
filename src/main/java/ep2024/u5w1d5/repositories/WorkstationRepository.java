package ep2024.u5w1d5.repositories;

import ep2024.u5w1d5.entities.Workstation;
import ep2024.u5w1d5.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
    @Query("SELECT w FROM Workstation w WHERE w.type = :type AND LOWER(w.building.city) = LOWER(:city)")
    List<Workstation> findByTypeOrCity(@Param("type") WorkstationType type, @Param("city") String city);
}

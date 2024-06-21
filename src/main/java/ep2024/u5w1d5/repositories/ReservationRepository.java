package ep2024.u5w1d5.repositories;

import ep2024.u5w1d5.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r WHERE r.user.id = :userId AND r.reservationDate = :date")
    List<Reservation> findByUserAndDate(@Param("userId") long userId, @Param("date") LocalDate date);

    @Query("SELECT r FROM Reservation r WHERE r.workstation.id = :workstationId AND r.reservationDate = :date")
    List<Reservation> findByWorkstationAndDate(@Param("workstationId") long workstationId, @Param("date") LocalDate date);
}

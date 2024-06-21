package ep2024.u5w1d5.services;

import ep2024.u5w1d5.entities.Reservation;
import ep2024.u5w1d5.exceptions.DuplicateItemException;
import ep2024.u5w1d5.exceptions.ItemNotFoundException;
import ep2024.u5w1d5.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation) {
        LocalDate reservationDate = reservation.getReservationDate();
        long userId = reservation.getUser().getId();
        long workstationId = reservation.getWorkstation().getId();

        List<Reservation> userReservations = reservationRepository.findByUserAndDate(userId, reservationDate);
        if (!userReservations.isEmpty()) {
            throw new DuplicateItemException("User already has a reservation for this date");
        }

        List<Reservation> workstationReservations = reservationRepository.findByWorkstationAndDate(workstationId, reservationDate);
        if (!workstationReservations.isEmpty()) {
            throw new DuplicateItemException("Workstation is already reserved for this date");
        }

        System.out.println("Reservation with id " + reservation.getId() + " created successfully!");
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation findById(long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void deleteById(long id) {
        Reservation reservation = findById(id);
        reservationRepository.delete(reservation);
        System.out.println("Reservation with id " + id + "deleted!");
    }
}

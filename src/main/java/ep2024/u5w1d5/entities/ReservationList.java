package ep2024.u5w1d5.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ReservationList {
    private List<Building> buildings;
    private List<Workstation> workstations;
}

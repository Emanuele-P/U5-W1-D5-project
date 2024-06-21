package ep2024.u5w1d5.entities;

import ep2024.u5w1d5.enums.WorkstationType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workstations")
@NoArgsConstructor
@Getter
@Setter
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String description;

    @Enumerated(EnumType.STRING)
    private WorkstationType type;

    @Column(name = "max_num_of_occupants")
    private int maxNumOfOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "workstation")
    private List<Reservation> reservations = new ArrayList<>();

    public Workstation(String description, WorkstationType type, int maxNumOfOccupants, Building building) {
        this.description = description;
        this.type = type;
        this.maxNumOfOccupants = maxNumOfOccupants;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Workstation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", maxNumOfOccupants=" + maxNumOfOccupants +
                '}';
    }
}

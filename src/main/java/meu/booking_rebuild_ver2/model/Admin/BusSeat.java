package meu.booking_rebuild_ver2.model.Admin;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "bus_seat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "is_available")
    private boolean isAvailable;
    @Column(name = "name_seat")
    private String nameSeat;
    @Column(name = "floor_number")
    private int floorNumber;
    @OneToOne
    @JoinColumn(name = "id_bus_type")
    private BusTypes idBusTypes;
}
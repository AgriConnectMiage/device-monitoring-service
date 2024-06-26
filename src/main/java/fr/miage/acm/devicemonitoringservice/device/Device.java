package fr.miage.acm.devicemonitoringservice.device;

import fr.miage.acm.devicemonitoringservice.farmer.Farmer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    protected DeviceState state;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;


    public Device(Farmer farmer) {
        this.state = DeviceState.NOT_ASSIGNED;
        this.farmer = farmer;
    }

    public Device() {
        // Default constructor required by JPA
    }

}

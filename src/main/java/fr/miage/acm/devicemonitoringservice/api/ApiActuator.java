package fr.miage.acm.devicemonitoringservice.api;

import fr.miage.acm.devicemonitoringservice.device.DeviceState;
import fr.miage.acm.devicemonitoringservice.device.actuator.Actuator;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ApiActuator extends ApiDevice {

    private UUID id;
    private DeviceState state;
    private ApiField field;

    public ApiActuator(Actuator actuator) {
        super(new ApiFarmer(actuator.getFarmer()));
        this.id = actuator.getId();
        this.state = actuator.getState();
        this.field = new ApiField(actuator.getField());
    }

    public ApiActuator() {
    }

    public ApiActuator(UUID id, DeviceState state, ApiField field, ApiFarmer apiFarmer) {
        super(apiFarmer);
        this.id = id;
        this.state = state;
        this.field = field;
    }
}

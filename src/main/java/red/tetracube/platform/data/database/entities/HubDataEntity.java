package red.tetracube.platform.data.database.entities;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hubs")
public class HubDataEntity extends PanacheEntityBase {

    @Id
    public UUID id;

    @Column(name = "hub_name", nullable = false, unique = true)
    public String hubName;

    @Column(name = "hub_platform_version", nullable = false)
    public String hubPlatformVersion;

    @Column(name = "websocket_broker_url", nullable = false)
    public String websocketBrokerURL;
    
}

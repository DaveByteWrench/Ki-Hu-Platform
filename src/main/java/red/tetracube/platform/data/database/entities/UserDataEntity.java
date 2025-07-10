package red.tetracube.platform.data.database.entities;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import red.tetracube.platform.shared.enums.UserGroup;

@Entity
@Table(name = "users")
public class UserDataEntity extends PanacheEntityBase {
    
    @Id
    public UUID id;
    
    @Column(name = "username", nullable = false, unique = true)
    public String username;
    
    @Column(name = "user_secret", nullable = false)
    public String userSecret;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_group", nullable = false)
    public UserGroup userGroup;
    
    @JoinColumn(name = "hub_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = HubDataEntity.class)
    public HubDataEntity hub;
}

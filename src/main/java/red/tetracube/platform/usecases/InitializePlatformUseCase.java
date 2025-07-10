package red.tetracube.platform.usecases;

import java.util.Optional;
import java.util.UUID;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import red.tetracube.platform.data.database.entities.HubDataEntity;
import red.tetracube.platform.data.database.entities.UserDataEntity;
import red.tetracube.platform.shared.enums.UserGroup;

@ApplicationScoped
public class InitializePlatformUseCase {

    @ConfigProperty(name = "home-kit-red-platform.hub-name")
    String hubName;

    @ConfigProperty(name = "home-kit-red-platform.principal-username")
    String principalUsername;

    @ConfigProperty(name = "home-kit-red-platform.principal-password")
    String principalPassword;

    @ConfigProperty(name = "home-kit-red-platform.websocket-address")
    String websocketAddress;

    @ConfigProperty(name = "quarkus.application.version", defaultValue = "9.9.9-develop")
    String applicationVersion;

    private final static Logger LOGGER = LoggerFactory.getLogger(InitializePlatformUseCase.class);

    @Transactional
    public void runInitialization() {
        LOGGER.info("Check if platform is already initialized");
        var hub = getHubIfExists()
                .orElseGet(() -> initializeHub());
        LOGGER.info("Update platform version to {}", applicationVersion);
        hub.hubPlatformVersion = applicationVersion;
        hub.websocketBrokerURL = websocketAddress;
        hub.persist();

        LOGGER.info("Checking if principal user exists");
        if (principalExists()) {
            LOGGER.info("Principal exists, ignoring seed");
            return;
        }

        LOGGER.info("Seeding principal information");
        var user = initializePrincipal(hub);
        user.persist();
    }

    private HubDataEntity initializeHub() {
        LOGGER.info("Seeding hub information");
        var hub = new HubDataEntity();
        hub.id = UUID.randomUUID();
        hub.hubName = hubName;
        return hub;
    }

    private Optional<HubDataEntity> getHubIfExists() {
        return HubDataEntity.<HubDataEntity>findAll().stream().findFirst();
    }

    private boolean principalExists() {
        return UserDataEntity.count(
                "userGroup = :userGroup and username = :username",
                Parameters.with("userGroup", UserGroup.PRINCIPAL).and("username", principalUsername) //
        ) == 1;
    }

    private UserDataEntity initializePrincipal(HubDataEntity hub) {
        var user = new UserDataEntity();
        user.id = UUID.randomUUID();
        user.username = principalUsername;
        user.userSecret = BcryptUtil.bcryptHash(principalPassword);
        user.userGroup = UserGroup.PRINCIPAL;
        user.hub = hub;
        return user;
    }
}

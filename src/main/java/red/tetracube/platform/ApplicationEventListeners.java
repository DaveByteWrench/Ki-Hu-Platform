package red.tetracube.platform;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;

public class ApplicationEventListeners {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationEventListeners.class);

    @ConfigProperty(name = "quarkus.application.version")
    String version;


    public void initializeAppOnStartup(@Observes StartupEvent startupEvent) {
        LOGGER.info("Check if hub and principal user are initialized");
        LOGGER.info("Check Platform version, currently at {}", version);
        LOGGER.info("Check finished... the platform is ready");
    }
}

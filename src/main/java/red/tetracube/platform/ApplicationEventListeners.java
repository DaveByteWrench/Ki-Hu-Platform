package red.tetracube.platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import red.tetracube.platform.usecases.InitializePlatformUseCase;

public class ApplicationEventListeners {

    @Inject
    InitializePlatformUseCase initializePlatformUseCase;
    
    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationEventListeners.class);

    public void initializeAppOnStartup(@Observes StartupEvent startupEvent) {
        LOGGER.info("Check if hub and principal user are initialized");
        initializePlatformUseCase.runInitialization();
        LOGGER.info("Check finished... the platform is ready");
    }
}

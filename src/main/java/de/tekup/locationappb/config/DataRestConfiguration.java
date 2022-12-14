package de.tekup.locationappb.config;

import de.tekup.locationappb.entites.Car;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;

@Configuration
@AllArgsConstructor
public class DataRestConfiguration implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    //we will expose id for car api
//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//        config.exposeIdsFor(Car.class);
//        config.exposeIdsFor(Client.class);
//    }
}

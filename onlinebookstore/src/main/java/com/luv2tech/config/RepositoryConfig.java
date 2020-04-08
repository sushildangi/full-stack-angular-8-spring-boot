package com.luv2tech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    public RepositoryConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(
                entityManager.getMetamodel()
                        .getEntities()
                        .stream()
                        .map(Type::getJavaType)
                        .toArray(Class[]::new)
        );
    }
}

package com.practicar.examen.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory emf = buildEntityMangerFactory();

    private static EntityManagerFactory buildEntityMangerFactory() {
        return Persistence.createEntityManagerFactory("jpamysql");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    private void shutdown() {
        if (emf.isOpen() && emf != null) {
            emf.close();
        }
    }

}
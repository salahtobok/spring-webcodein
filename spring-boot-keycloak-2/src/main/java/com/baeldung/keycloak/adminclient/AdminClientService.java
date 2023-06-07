package com.baeldung.keycloak.adminclient;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminClientService {

    private static final Logger logger = LoggerFactory.getLogger(AdminClientService.class);
    private static final String REALM_NAME = "spring-boot";

    @Autowired
    private Keycloak keycloak;

    @PostConstruct
    public void searchUsers() {
        logger.info("Searching users in Keycloak {}", keycloak.serverInfo()
                .getInfo()
                .getSystemInfo()
                .getVersion());
        searchByUsername("root", true);
        searchByUsername("user", false);
        searchByUsername("1", false);
        searchByEmail("user2@test.com", true);
        searchByAttributes("DOB:2000-01-05");
        // searchByGroup("c67643fb-514e-488a-a4b4-5c0bdf2e7477");
    }

    private void searchByUsername(String username, boolean exact) {
        logger.info("Searching by username: {} (exact {})", username, exact);
        List<UserRepresentation> users = keycloak.realm(REALM_NAME)
                .users()
                .searchByUsername(username, exact);
        logger.info("Users found by username {}", users.stream()
                .map(user ->
                        user.getUsername() + " - " +
                                user.getEmail())
                .collect(Collectors.toList()));
    }

    private void searchByEmail(String email, boolean exact) {
        logger.info("Searching by email: {} (exact {})", email, exact);
        List<UserRepresentation> users = keycloak.realm(REALM_NAME)
                .users()
                .searchByEmail(email, exact);
        logger.info("Users found by email {}", users.stream()
                .map(user -> user.getEmail())
                .collect(Collectors.toList()));
    }

    private void searchByAttributes(String query) {
        logger.info("Searching by attributes: {}", query);
        List<UserRepresentation> users = keycloak.realm(REALM_NAME)
                .users()
                .searchByAttributes(query);
        logger.info("Users found by attributes {}", users.stream()
                .map(user -> user.getUsername() + " " + user.getAttributes())
                .collect(Collectors.toList()));
    }

    private void searchByGroup(String groupId) {
        logger.info("Searching by group: {}", groupId);
        List<UserRepresentation> users = keycloak.realm(REALM_NAME)
                .groups()
                .group(groupId)
                .members();
        logger.info("Users found by group {}", users.stream()
                .map(user -> user.getUsername())
                .collect(Collectors.toList()));
    }


}
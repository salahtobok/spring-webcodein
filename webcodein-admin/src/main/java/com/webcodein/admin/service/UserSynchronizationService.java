package com.webcodein.admin.service;

import com.webcodein.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserSynchronizationService {

    @Autowired
    UserRepository userRepository;


    private void syncWithDatabase(final OidcUserInfo userInfo) {
        /*
        User user = userRepository.findByExternalId(userInfo.getSubject());
        if (user == null) {
            log.info("adding new user after successful login: {}", userInfo.getSubject());
            user = new User();
            user.setExternalId(userInfo.getSubject());
        } else {
            log.info("updating existing user after successful login: {}", userInfo.getSubject());
        }
        user.setEmail(userInfo.getEmail());
        userRepository.save(user);
         */

    }

    @EventListener(AuthenticationSuccessEvent.class)
    public void onAuthenticationSuccessEvent(final AuthenticationSuccessEvent event) {
        System.out.println(" *************** AuthenticationSuccessEvent Checked *************** ");
        //final OidcUser oidcUser = ((OidcUser) event.getAuthentication().getPrincipal());
        //syncWithDatabase(oidcUser.getUserInfo());
    }

}
package com.webcodein;

import com.webcodein.admin.domain.Room;
import com.webcodein.admin.repository.RoomRepository;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = { "com.webcodein" })
@PropertySource("classpath:application.properties")
public class SpringWebcodeinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebcodeinApplication.class, args);
	}


	@RestController
	@RequestMapping("/rooms")
	public class RoomController{
		@Autowired
		private RoomRepository roomRepository;

		@GetMapping
		public Iterable<Room> getRooms(){
			return this.roomRepository.findAll();
		}
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


	@Bean
	Keycloak keycloak() {
		return KeycloakBuilder.builder()
				.serverUrl("http://localhost:8543")
				.realm("spring-boot")
				.clientId("webcodein-public")
				.grantType(OAuth2Constants.PASSWORD)
				.username("root")
				.password("root")
				.build();
	}


	/**
	 * @Bean
	 * public ClientRegistrationRepository clientRepository() {
	 *
	 * 	ClientRegistration keycloak = keycloakClientRegistration();
	 * 	return new InMemoryClientRegistrationRepository(keycloak);
	 * }
	 *
	 * private ClientRegistration keycloakClientRegistration() {
	 *
	 * 	return ClientRegistration.withRegistrationId("howtodoinjava-realm")
	 * 		.clientId("employee-management-api")
	 * 		.clientSecret("--generated--")
	 * 		.redirectUri("http://localhost:9090/login/oauth2/code/employee-management-api")
	 * 		.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
	 * 		.issuerUri("http://localhost:8180/realms/howtodoinjava-realm")
	 * 		.authorizationUri("http://localhost:8080/realms/howtodoinjava/protocol/openid-connect/auth")
	 * 		.tokenUri("http://localhost:8180/realms/howtodoinjava/protocol/openid-connect/token")
	 * 		.userInfoUri("http://localhost:8180/realms/howtodoinjava/protocol/openid-connect/userinfo")
	 * 		.build();
	 * }
	 */


}
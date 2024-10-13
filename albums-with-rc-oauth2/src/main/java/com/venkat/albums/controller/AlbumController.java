package com.venkat.albums.controller;

import com.venkat.albums.model.AlbumResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Controller
public class AlbumController {

    private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);

    //@Autowired
    private final OAuth2AuthorizedClientService oauth2AuthorizedClientService;
    //@Autowired
    private final RestTemplate restTemplate;

    public AlbumController(OAuth2AuthorizedClientService oauth2AuthorizedClientService, RestTemplate restTemplate) {
        this.oauth2AuthorizedClientService = oauth2AuthorizedClientService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/albums")
    public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {
        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            logger.info("OAuth2AuthenticationToken: {}, {}", oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());

            OAuth2AuthorizedClient oauth2AuthorizedClient = oauth2AuthorizedClientService.
                    loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());

            String jwtAccessToken = oauth2AuthorizedClient.getAccessToken().getTokenValue();
            String jwtRefreshToken = Objects.requireNonNull(oauth2AuthorizedClient.getRefreshToken()).getTokenValue();

            String url = "http://localhost:8090/albums";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + jwtAccessToken);
            HttpEntity<List<AlbumResponse>> entity = new HttpEntity<>(headers);
            ResponseEntity<List<AlbumResponse>> responseEntity = restTemplate
                    .exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<AlbumResponse>>() {
                    });

            List<AlbumResponse> albums = responseEntity.getBody();
            model.addAttribute("albums", albums);
            model.addAttribute("principal", principal);
            return "albums";
        }catch (Exception e){
            logger.error("Error fetching albums: ", e);
            model.addAttribute("error", "Failed to fetch albums: " + e.getMessage());
            return "error";

        }
    }
}

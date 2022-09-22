package dz.elit.controller;

import dz.elit.dto.auth.AuthenticationRequest;
import dz.elit.dto.auth.AuthenticationResponse;
import dz.elit.model.auth.ExtendedUser;
import dz.elit.service.auth.ApplicationUserDetailsService;
import dz.elit.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dz.elit.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity authenticate(@RequestBody AuthenticationRequest authenticationRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getLogin(),
                        authenticationRequest.getPassword()
                )
        );
        System.out.println("je dans l'authentification");
        final UserDetails userDetails = applicationUserDetailsService.loadUserByUsername(authenticationRequest.getLogin());
        final String jwt=jwtUtil.generateToken((ExtendedUser) userDetails);
        return ResponseEntity.ok( AuthenticationResponse.builder().jwtToken(jwt).build());
    }
}

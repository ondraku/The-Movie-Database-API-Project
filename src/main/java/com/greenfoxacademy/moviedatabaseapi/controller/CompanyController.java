package com.greenfoxacademy.moviedatabaseapi.controller;

import com.greenfoxacademy.moviedatabaseapi.model.CompanyDTO;
import com.greenfoxacademy.moviedatabaseapi.security.authentication.AuthenticationRequest;
import com.greenfoxacademy.moviedatabaseapi.security.authentication.AuthenticationResponse;
import com.greenfoxacademy.moviedatabaseapi.security.jwt.JwtUtil;
import com.greenfoxacademy.moviedatabaseapi.service.CompanyService;
import com.greenfoxacademy.moviedatabaseapi.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Value("${api.key}")
    private String apiKey;

    private final CompanyService companyService;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public CompanyController(CompanyService companyService, AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.companyService = companyService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/company/{companyId}")
    public CompanyDTO getCompanies(@PathVariable Long companyId) {
        return companyService.getCompanies(companyId, apiKey);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}

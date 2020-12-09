package com.example.auctionapp.service;

import com.example.auctionapp.exception.BadRequestException;
import com.example.auctionapp.model.LoginRequest;
import com.example.auctionapp.dto.AuthenticationDto;
import com.example.auctionapp.security.CustomUserDetails;
import com.example.auctionapp.security.JwtUtil;
import com.example.auctionapp.security.RepositoryAwareUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    private final AuthenticationManager authenticationManager;
    private final RepositoryAwareUserDetailsService userDetailsService;

    private final String SECRET_KEY;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager,
                                 RepositoryAwareUserDetailsService userDetailsService,
                                 @Value("${secret-key}") String SECRET_KEY) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.SECRET_KEY = SECRET_KEY;
    }

    public AuthenticationDto login(LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            logger.error(e.getMessage(), e);
            throw new Exception("Incorrect username or password", e);
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        final CustomUserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        final String token = JwtUtil.generateToken(userDetails, SECRET_KEY);

        return new AuthenticationDto(token);
    }

    public AuthenticationDto refresh(AuthenticationDto authenticationDto) {

        String token = authenticationDto.getToken();

        String username = JwtUtil.extractUsername(token, SECRET_KEY);

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if(!JwtUtil.validateTokenWithoutExpiration(token, userDetails, SECRET_KEY)) {
           throw new BadRequestException("Invalid token");
        }
        return new AuthenticationDto(JwtUtil.generateToken(userDetails, SECRET_KEY));
    }
}

package com.fsa.firststepapp.service.auth_service;

import com.fsa.firststepapp.models.Role;
import com.fsa.firststepapp.models.User;
import com.fsa.firststepapp.models.request.AuthenticationRequest;
import com.fsa.firststepapp.models.request.RegisterRequest;
import com.fsa.firststepapp.models.request.UpdateUserRequest;
import com.fsa.firststepapp.models.response.AuthenticationResponse;
import com.fsa.firststepapp.repository.FacultyRepository;
import com.fsa.firststepapp.repository.UniversityRepository;
import com.fsa.firststepapp.repository.UserRepository;
import com.fsa.firststepapp.service.jwt_service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements  IAuthenticationService{
    private final UserRepository userRepository;
    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        if(request.getName().isEmpty())
            return AuthenticationResponse.builder()
                    .errorMessage("Name cannot be empty inside the request body!").build();

        if(request.getEmail().isEmpty())
            return AuthenticationResponse.builder()
                    .errorMessage("Email cannot be empty inside the request body!").build();

        if(request.getPassword().isEmpty())
            return AuthenticationResponse.builder()
                    .errorMessage("Password cannot be empty inside the request body!").build();

        if(request.getFaculty().isEmpty())
            return AuthenticationResponse.builder()
                    .errorMessage("Faculty cannot be empty inside the request body!").build();

        if(request.getUniversity().isEmpty())
            return AuthenticationResponse.builder()
                    .errorMessage("University cannot be empty inside the request body!").build();

       if(userRepository.findByEmail(request.getEmail()).isPresent())
            throw new DuplicateKeyException("That email is already in use!");

        if(universityRepository.findUniversityByName(request.getUniversity()) == null)
            throw new NoSuchElementException("No university with that name was found!");

        if(facultyRepository.findFacultyByName(request.getFaculty()) == null)
            throw new NoSuchElementException("No faculty with that name was found!");

        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .university( universityRepository.findUniversityByName(request.getUniversity()).orElseThrow())
                .faculty(facultyRepository.findFacultyByName(request.getFaculty()).orElseThrow())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        if(request.getRole() != null) {
            user.setRole(Role.ADMIN);
        }

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        if(request.getEmail().isEmpty())
            return AuthenticationResponse.builder()
                    .errorMessage("Email cannot be empty inside the request body!").build();

        if(request.getPassword().isEmpty())
            return AuthenticationResponse.builder()
                    .errorMessage("Password cannot be empty inside the request body!").build();

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password!");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse updateUser(UpdateUserRequest request) {
        User user = this.userRepository.findByEmail(request.getOldEmail()).orElseThrow();

        if(!(request.getNewEmail().equals(request.getOldEmail())) && request.getNewEmail() != null){
            if(userRepository.findByEmail(request.getNewEmail()).isPresent()){
                return AuthenticationResponse.builder()
                        .errorMessage("The email is already in use!").build();
            }
            else user.setEmail(request.getNewEmail());
        }
        else if(request.getNewEmail() != null){
            user.setEmail(request.getNewEmail());
        }

        if(!(request.getName().isEmpty()))
            user.setName(request.getName());

        if(!(request.getPassword().isEmpty()))
            user.setPassword(passwordEncoder.encode(request.getPassword()));

        this.userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

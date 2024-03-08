package com.fsa.firststepapp.controller;

import com.fsa.firststepapp.models.dto.UserDto;
import com.fsa.firststepapp.models.request.UpdateUserRequest;
import com.fsa.firststepapp.service.auth_service.IAuthenticationService;
import com.fsa.firststepapp.service.user_service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Controlerul pentru gestionarea utilizatorilor.
 */
@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;
    private final IAuthenticationService authenticationService;

    @Autowired
    public UserController(IUserService userService, IAuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    /**
     * Endpoint pentru obținerea tuturor utilizatorilor.
     *
     * @return Lista de obiecte UserDto.
     */
    @GetMapping("")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint pentru actualizarea informațiilor unui utilizator.
     *
     * @param request Obiectul de tip UpdateUserRequest care conține informațiile necesare pentru actualizarea utilizatorului.
     * @return Răspunsul HTTP indicând reușita sau eșecul actualizării.
     */
    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserRequest request){
        try{
            var response = this.authenticationService.updateUser(request);

            if(response.getErrorMessage() != null)
                return ResponseEntity.badRequest().body(response.getErrorMessage());

            return ResponseEntity.ok(HttpStatus.OK.toString());
        }
        catch (NoSuchElementException noSuchElementException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user with that email was found!");
        }
    }
}

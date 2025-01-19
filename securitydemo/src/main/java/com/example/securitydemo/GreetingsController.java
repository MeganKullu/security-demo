package com.example.securitydemo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GreetingsController {

    //endpoint that is open to the public
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    //endpoint that is protected
    @GetMapping("/guest")
    public String sayHelloGuest() {
        return "Hello, Guest!";
    }

    //endpoint that is protected by role
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello, User!";
    }

    //endpoint that is protected by either role or authority
    @PreAuthorize("hasRole('ADMIN') or hasAuthority('MANAGE_ADMIN')")
    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello Admin!";
    }
}

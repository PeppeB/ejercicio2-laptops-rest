package com.example.ejercicio2laptopsrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Creating a Rest Controller class

@RestController
public class HelloController {

    // This is an annotated method by the @GetMapping annotation. The @GetMapping annotated methods in the
    // @Controller (in this case a @RestController) annotated classes handle the HTTP GET requests matched
    // with given URI expression. This method returns a web page with a greeting.
    @GetMapping("/hello")
    public String greet() {
        //System.out.println("Hello World!");
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Hello World - Spring Boot project</title>
                </head>
                <body>
                    <h1>Hello World from Spring Boot!</h1>
                </body>
                </html>
                """;
    }
}

package com.example.ejercicio2laptopsrest.controllers;

import com.example.ejercicio2laptopsrest.entities.Laptop;
import com.example.ejercicio2laptopsrest.repositories.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // attributes

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    // constructors
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // CRUD operations on the entity Laptop


    /**
     * Searching for all laptops in the database
     * http://localhost:8081/api/laptops
     *
     * @return the list of laptops in the database
     */
    @GetMapping("/api/laptops")
    @ApiOperation("Searching for all laptops in the database")
    public List<Laptop> findAll() {
        // retrieve and return laptops from the database
        return laptopRepository.findAll();
    }


    /**
     * Searching for one Laptop by id in the database
     * http://localhost:8081/api/laptops/1
     * http://localhost:8081/api/laptops/2
     * Request
     * Response
     * @param id
     * @return If a laptop entity with the given id exists in the database, returns a response with
     * this laptop entity and the status set to OK, otherwise returns a response with no body and a
     * NOT_FOUND status.
     */
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Searching for one laptop in the database")
    public ResponseEntity<Laptop> findOneById(@ApiParam("Primary key of type Long") @PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent()) {
            // A laptop with the given id exists
            // Create a response entity with the given body (the laptop entity with the
            // given id) and the status set to OK, and return the created response entity.
            return ResponseEntity.ok(laptopOpt.get());
        } else {
            // Create a builder with a NOT_FOUND status, build the response entity with no body and
            // return the response entity.
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Creating a new laptop in the database
     * @param laptop
     * @param headers
     * @return If the given laptop entity has an id, returns a response entity with no body and a
     * BAD_REQUEST status, otherwise returns a response entity with the given body (the laptop
     * which has been saved into database) and the status set to OK.
     */
    @PostMapping("/api/laptops")
    @ApiOperation("Creating a new laptop in the database")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));

        // Save the laptop received as a parameter in the database

        // If a laptop id exists (i.e. a request with a laptop having an id has been sent), it's
        // not a creation. In this case, create a builder with a BAD_REQUEST status and build
        // the response entity with no body.
        if(laptop.getId() != null) {
            log.warn("Trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }

        // The id does not exist (i.e. a request with a laptop having no id has been sent), so it's
        // a creation. In this case, create a primary key (id), save the laptop (with its primary key)
        // in the database, create a ResponseEntity with the given body (created laptop) and the
        // status set to OK and return the created ResponseEntity.
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);

        // This is the laptop object (in JSON format) which I used for the testing in Postman
        /*
		{
			"brand": "Lenovo",
			"model": "Legion 7 Gaming",
			"color": "Storm Grey",
			"display": "16.0 inches QHD IPS Display 160Hz",
			"graphicCard": "NVIDIA GeForce RTX 3080 16GB GDDR6",
			"processor": "AMD Ryzen™ 9 5900HX",
			"storage": "1TB SSD",
			"ram": "32GB DDR4",
			"microphoneType": "Internal Microphone",
			"webcamType": "Internal Webcam",
			"speakersType": null,
			"hasOpticalDrive": false,
			"hasFingerprintScanner": false,
			"hasBluetooth": true,
			"hasSdCardReader": null,
			"nrUsbPorts": 3,
			"batteryType": null,
			"operatingSystem": "Windows 11 Home 64-bit"
        }
		 */
    }


    /**
     * Updating a laptop existing in the database
     * @param laptop
     * @return If the given laptop exists in the database, returns a response entity with the given
     * body (the laptop updated) and the status set to OK, otherwise returns a response entity with
     * no body and a BAD_REQUEST or NOT_FOUND status.
     */
    @PutMapping("/api/laptops")
    @ApiOperation("Updating a laptop existing in the database")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        // If the given laptop does not have any id (primary key), it's a creation. In this case,
        // it's not possible to update.
        if(laptop.getId() == null) {
            log.warn("Trying to update a not existent laptop");
            return ResponseEntity.badRequest().build();
        }

        // If the given laptop has an id, and it does not exist any laptop having this id
        // in the database, it's not possible to update. In this case create a builder with a
        // NOT_FOUND status and build the response entity with no body.
        if(!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to update a not existent laptop");
            return ResponseEntity.notFound().build();
        }

        // The given laptop exists.

        log.info("REST Request for updating a laptop");

        // Update the laptop (with its primary key) in the database, create a
        // ResponseEntity with the given body (the updated laptop) and the status set to OK and
        // return the created ResponseEntity.
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(laptop);
    }


    /**
     * Deleting a laptop from the database
     * http://localhost:8081/api/laptops/1
     * http://localhost:8081/api/laptops/2
     * @param id
     * @return if a laptop with the given id exists, returns a response entity with no body and
     * a NO_CONTENT status, otherwise a response entity with no body and a NOT_FOUND status.
     */
    @DeleteMapping("/api/laptops/{id}")
    @ApiOperation("Deleting a laptop from the database")
    public ResponseEntity<Laptop> delete(@ApiParam("Primary key of type Long") @PathVariable Long id) {
        // If it does not exist any laptop having id as primary key, create a builder with a NOT_FOUND
        // status, build the response entity with no body and return the response entity.
        if(!laptopRepository.existsById(id)) {
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        // A laptop with the given id exists.

        log.info("REST Request for deleting one laptop");

        // Delete laptop with the given id from the database, create a builder with a NO_CONTENT
        // status, build the response entity with no body and return the response entity.
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    /**
     * Deleting all laptops from the database
     * http://localhost:8081/api/laptops
     * @return a response entity with no body
     */
    @DeleteMapping("/api/laptops")
    @ApiOperation("Deleting all laptops from the database")
    public ResponseEntity<Laptop> deleteAll() {
        log.info("REST Request for deleting all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}

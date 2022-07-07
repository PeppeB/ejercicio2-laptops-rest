package com.example.ejercicio2laptopsrest;

import com.example.ejercicio2laptopsrest.entities.Laptop;
import com.example.ejercicio2laptopsrest.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio2LaptopsRestApplication {

	public static void main(String[] args) {

		// Create a bean container
		ApplicationContext context = SpringApplication.run(Ejercicio2LaptopsRestApplication.class, args);
		// Return the bean instance that uniquely matches the given object type.
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// CRUD

		System.out.println("Number of laptop items present in the database: " + repository.findAll().size());

		// create laptops

		Laptop laptop1 = new Laptop(null, "Dell", "inspiron 15 3593", "black", "15.6 inches FHD Display",
				"2GB Nvidia MX-230", "Intel Core i7 10th Generation", "512 GB SSD", "8GB DDR4",
				"Internal Microphone", "Internal Webcam", "Stereo Speakers", false, false, true, true,
				3, "Li-Ion", "Windows 10 Home 64-bit");

		Laptop laptop2 = new Laptop(null, "HP", "Pavilion 15-er0225od X360", "Silver",
				"15.6 inches HD IPS LED X360 touchscreen Display", "Intel® Iris® Xᵉ Graphics",
				"Intel Core i5 11th Generation", "256 GB SSD", "8GB DDR4", "Internal Microphone",
				"Internal Webcam", "Dual Speakers", false, false,
				true, true, 3, "3-cell, 43 Wh Li-ion polymer",
				"Windows 11 Home 64-bit");

		// save laptops in the database
		repository.save(laptop1);
		repository.save(laptop2);

		System.out.println("Number of laptop items present in the database: " + repository.findAll().size());
	}

}

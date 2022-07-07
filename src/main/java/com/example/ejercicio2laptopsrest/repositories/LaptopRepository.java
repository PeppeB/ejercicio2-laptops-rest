package com.example.ejercicio2laptopsrest.repositories;

import com.example.ejercicio2laptopsrest.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// The LaptopRepository interface is annotated with the annotation @Repository, indicating that this
// interface is a Repository. It extends the JpaRepository interface. it’s parameterized, with the first
// parameter being the entity type which the repository has to persist, and the second parameter being the
// type of the entity ID property.
@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
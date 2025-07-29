package com.portfolio.user_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this as a Spring Data repository component
public interface UserRepository extends JpaRepository<User, Long> {

    // By extending JpaRepository, we get a ton of powerful database methods for free:
    //
    // - save(User entity): Saves a new user or updates an existing one.
    // - findById(Long id): Finds a user by their primary key.
    // - findAll(): Returns a list of all users in the database.
    // - deleteById(Long id): Deletes a user by their ID.
    // - count(): Counts the total number of users.
    //
    // We don't need to write any code inside this interface for now.
    // Spring Data JPA will automatically implement all these methods for us at runtime.
    // This is one of the most powerful features of Spring.

}

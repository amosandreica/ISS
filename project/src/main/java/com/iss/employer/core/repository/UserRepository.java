package com.iss.employer.core.repository;

import com.iss.employer.core.model.User;

import java.nio.channels.FileChannel;
import java.util.Optional;

public interface UserRepository extends AbstractRepository<User, Integer>{
    Optional<User> findByEmail(String email);
}

package com.godspeed.springBoot.service;

import org.springframework.data.repository.CrudRepository;

import com.godspeed.springBoot.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}

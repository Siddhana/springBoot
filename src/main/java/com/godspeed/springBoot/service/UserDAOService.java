package com.godspeed.springBoot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.godspeed.springBoot.entity.User;

@Repository
@Transactional
public class UserDAOService {
    
    @PersistenceContext
    private EntityManager em;
    
    public long insert(User user) {
        em.persist(user);
        return user.getId();
    }
    
    public List<User> findAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }
}

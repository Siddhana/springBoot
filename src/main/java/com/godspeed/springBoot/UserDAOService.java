package com.godspeed.springBoot;

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
}

package com.iss.employer.core.repository.impl;

import com.iss.employer.core.model.User;
import com.iss.employer.core.repository.UserRepository;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultUserRepository extends DefaultAbstractRepository<User, Integer> implements UserRepository {
    public DefaultUserRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Query<User> query = getSession()
                .createQuery("SELECT u FROM User AS u WHERE u.email = :email", User.class)
                .setParameter("email", email);

        try {
            List<User> result = query.getResultList();
            return Optional.ofNullable(result)
                    .stream()
                    .flatMap(Collection::stream)
                    .findFirst();
        } catch (HibernateException e) {
            return Optional.empty();
        }
    }
}

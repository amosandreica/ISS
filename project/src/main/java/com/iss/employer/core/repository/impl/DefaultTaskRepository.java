package com.iss.employer.core.repository.impl;

import com.iss.employer.core.model.Task;
import com.iss.employer.core.repository.TaskRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultTaskRepository extends DefaultAbstractRepository<Task, Integer> implements TaskRepository {
    public DefaultTaskRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

package com.iyzis.core.service;

import com.iyzis.core.domain.AbstractEntity;
import com.iyzis.core.repository.IRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService <T extends AbstractEntity, ID extends Serializable> implements IService<T, ID> {


    public abstract IRepository getRepository();


    @Override
    public T create(T entity) {
         return  (T) getRepository().save(entity);
    }

    @Override
    public void create(List<T> entities) {
         entities.forEach(e -> getRepository().save(e));
    }

    @Override
    public void update(T entity) {
         getRepository().save(entity);
    }

    @Override
    public void update(List<T> entities) {
         entities.forEach(e -> getRepository().save(e));
    }

    @Override
    public void delete(T entity) {
         getRepository().delete(entity);
    }

    @Override
    public void delete(List<T> entities) {
          entities.forEach(e -> getRepository().delete(e));
    }

    @Override
    public Optional<T> find(ID id) {
       return getRepository().findById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }
}

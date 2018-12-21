package com.iyzis.core.service;

import com.iyzis.core.domain.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IService<T extends AbstractEntity, ID extends Serializable> {

     T create(T entity);

    void create (List<T>entities);

    void update(T entity);

    void update(List<T> entities);

    void delete(T entity);

    void delete(List<T> entities);

    Optional<T> find(ID id);

    Iterable<T> findAll();

}

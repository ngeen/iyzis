package com.iyzis.core.facade;

import java.io.Serializable;
import java.util.List;

public interface IFacade<T> {

    T create(T dto);

    void create (List<T> dtos);

    void update(T dto);

    void update(List<T> dtos);

    void delete(T dto);

    void delete(List<T> dtos);

    T find(Serializable id);

    List<T> findAll();
}

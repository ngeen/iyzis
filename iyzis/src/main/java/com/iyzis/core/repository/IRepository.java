package com.iyzis.core.repository;

import com.iyzis.core.domain.AbstractEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface IRepository<T extends AbstractEntity, ID extends Serializable> extends CrudRepository<T, ID> {
}

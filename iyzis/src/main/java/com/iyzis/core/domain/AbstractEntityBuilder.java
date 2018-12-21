package com.iyzis.core.domain;

public abstract class AbstractEntityBuilder<E extends AbstractEntity, D extends AbstractDTO> {

    public abstract AbstractEntityBuilder dto(D dto);
    public abstract E build();
}

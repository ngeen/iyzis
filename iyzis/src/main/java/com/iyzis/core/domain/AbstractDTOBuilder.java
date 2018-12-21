package com.iyzis.core.domain;

public abstract class AbstractDTOBuilder<D extends AbstractDTO, E extends AbstractEntity> {

    public abstract AbstractDTOBuilder entity(E entity);
    public abstract D build();
}

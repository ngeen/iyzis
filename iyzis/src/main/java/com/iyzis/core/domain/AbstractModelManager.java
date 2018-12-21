package com.iyzis.core.domain;

public abstract class AbstractModelManager<E extends AbstractEntity,D extends AbstractDTO, B1 extends AbstractEntityBuilder, B2 extends AbstractDTOBuilder> {

    public AbstractModelManager(){}


    public abstract B1 getEntityBuilder();
    public abstract B2 getDtoBuilder();
    public abstract E convert(D dto);
    public abstract D convert(E entity);
}

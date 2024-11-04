package com.sn.onepay.usermanager.common.mapper;

public interface IMapper<E, D> {

    D asDTO(E entity);

    E asEntity(D dto);

}

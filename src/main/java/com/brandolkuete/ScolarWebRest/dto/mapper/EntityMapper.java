package com.brandolkuete.ScolarWebRest.dto.mapper;

import java.util.List;

public interface EntityMapper<D, M>{

    M toEntity(D dto);
    D toDto(M entity);
    List<M> toEntity(List<D> dtoList);
    List<D> toDto(List<M> entityList);
}

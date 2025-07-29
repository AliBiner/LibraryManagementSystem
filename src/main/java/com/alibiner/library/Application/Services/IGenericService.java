package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BaseDto;
import com.alibiner.library.Domain.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface IGenericService{
    <TDto extends BaseDto> boolean add(TDto dto);
    <TDto extends BaseDto> List<TDto> getAll();
    <TEntity extends BaseEntity> TEntity getByObject(TEntity entity);
}

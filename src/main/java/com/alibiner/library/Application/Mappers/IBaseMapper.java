package com.alibiner.library.Application.Mappers;

import com.alibiner.library.Application.DTOs.BaseDto;
import com.alibiner.library.Domain.BaseEntity;

public interface IBaseMapper<TEntity extends BaseEntity,TDto extends BaseDto> {
    TEntity get(TDto dto);
}

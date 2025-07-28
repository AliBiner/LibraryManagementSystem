package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BaseDto;
import com.alibiner.library.Application.Mappers.IBaseMapper;

public interface IGenericService{
    <TDto extends BaseDto> boolean add(TDto dto);
}

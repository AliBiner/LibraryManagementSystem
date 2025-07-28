package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BaseDto;

import java.util.List;

public interface IGenericService{
    <TDto extends BaseDto> boolean add(TDto dto);
    <TDto extends BaseDto> List<TDto> getAll();
}

package com.alibiner.library.Application.Services.Interfaces;

import com.alibiner.library.Application.DTOs.BaseDto;

import java.util.List;

public interface GenericService {
    <TDto extends BaseDto> boolean add(TDto dto);
    List<? extends BaseDto> getAll();
}

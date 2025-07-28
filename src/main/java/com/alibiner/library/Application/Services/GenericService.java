package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BaseDto;
import com.alibiner.library.Application.Mappers.IBaseMapper;
import com.alibiner.library.Domain.BaseEntity;
import com.alibiner.library.Infrastructure.GenericRepository;
import com.alibiner.library.Infrastructure.IGenericRepository;

public abstract class GenericService implements IGenericService {
    private final IBaseMapper mapper;
    private final IGenericRepository genericRepository;

    public <TDto extends BaseDto> GenericService(IBaseMapper mapper, IGenericRepository genericRepository) {
        this.mapper = mapper;
        this.genericRepository = genericRepository;
    }

    @Override
    public <TDto extends BaseDto> boolean add(TDto dto) {
        BaseEntity book = mapper.get(dto);
        return genericRepository.add(book);
    }
}

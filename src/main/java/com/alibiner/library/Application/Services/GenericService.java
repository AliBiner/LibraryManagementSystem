package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BaseDto;
import com.alibiner.library.Application.Mappers.Interfaces.IBaseMapper;
import com.alibiner.library.Domain.BaseEntity;
import com.alibiner.library.Infrastructure.IGenericRepository;

import java.util.List;

public abstract class GenericService<TEntity extends BaseEntity> implements IGenericService {
    private  IBaseMapper mapper;
    private final IGenericRepository genericRepository;

    public <TDto extends BaseDto> GenericService(IGenericRepository genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    public <TDto extends BaseDto> boolean add(TDto dto) {
        BaseEntity book = (BaseEntity) mapper.mapToEntity(dto);
        return genericRepository.add(book);
    }

    @Override
    public <TDto extends BaseDto> List<TDto> getAll() {
        List<TEntity> dbResult = genericRepository.getAll();
        return mapper.mapToDto(dbResult);
    }

    public void setMapper(IBaseMapper mapper) {
        this.mapper = mapper;
    }
}

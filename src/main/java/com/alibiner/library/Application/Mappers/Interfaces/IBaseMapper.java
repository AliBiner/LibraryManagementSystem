package com.alibiner.library.Application.Mappers.Interfaces;

import java.util.List;

public interface IBaseMapper<TEntity,TDto> {
     TEntity mapToEntity (TDto source);
     List<TEntity> mapToEntity (List<TDto> source);

     TDto mapToDto (TEntity source);
     List<TDto> mapToDto (List<TEntity> source);
}

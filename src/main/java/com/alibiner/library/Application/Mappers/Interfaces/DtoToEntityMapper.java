package com.alibiner.library.Application.Mappers.Interfaces;

import com.alibiner.library.Application.Mappers.BookMappers.BookDetailDtoMapper;
import com.alibiner.library.Application.Mappers.BookMappers.InsertBookDtoTo;

import java.util.List;

/**
 * DtoToEntityMapper is a generic interface for mapping DTO to Entity object.
 * <p>
 * It helps to convert one type of object to another (for example, from a DTO to an entity).
 * <p>
 * This interface is useful for separating data and logic between layers (data layer and service layer).
 *
 * @param <TEntity> the entity class (usually from the database)
 * @param <TDto> the data transfer object class (used to move data between layers)
 *
 * @see InsertBookDtoTo
 * @see BookDetailDtoMapper
 */
public interface DtoToEntityMapper<TEntity,TDto> {
    /**
     * Converts one DTO object to its Entity form.
     *
     * @param source the DTO object to convert
     * @return the converted Entity object
     */
    TEntity mapToEntity (TDto source);

    /**
     * Converts a list of DTO objects to a list of Entity objects.
     *
     * @param source the list of DTOs to convert
     * @return a list of converted Entity objects
     */
    List<TEntity> mapToEntity (List<TDto> source);
}

package com.alibiner.library.Application.Mappers.Interfaces;

import com.alibiner.library.Application.Mappers.BookMappers.BookDetailDtoMapper;
import com.alibiner.library.Application.Mappers.BookMappers.InsertBookDtoTo;

import java.util.List;

/**
 * EntityToDtoMapper is a generic interface for mapping Entity to DTO objects.
 * <p>
 * It helps to convert one type of object to another (for example, from a database entity to a DTO).
 * <p>
 * This interface is useful for separating data and logic between layers (data layer and service layer).
 *
 * @param <TEntity> the entity class (usually from the database)
 * @param <TDto> the data transfer object class (used to move data between layers)
 *
 * @see InsertBookDtoTo
 * @see BookDetailDtoMapper
 */
public interface EntityToDtoMapper<TEntity,TDto> {
    /**
     * Converts one Entity object to its DTO form.
     *
     * @param source the Entity object to convert
     * @return the converted DTO object
     */
    TDto mapToDto (TEntity source);

    /**
     * Converts a list of Entity objects to a list of DTO objects.
     *
     * @param source the list of Entities to convert
     * @return a list of converted DTO objects
     */
    List<TDto> mapToDto (List<TEntity> source);
}

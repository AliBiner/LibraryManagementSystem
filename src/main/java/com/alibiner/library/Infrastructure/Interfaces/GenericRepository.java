package com.alibiner.library.Infrastructure.Interfaces;

import com.alibiner.library.Domain.BaseEntity;

import java.util.List;

/**
 * GenericRepository is a base interface for data operations (like add, get, update).
 * <p>
 * It works with any class that extends {@link BaseEntity}.
 * <p>
 * This interface helps to manage basic actions for entities such as add, list, check exist, update and find by ID.
 *
 * @param <TEntity> the entity type that must extend BaseEntity
 */
public interface GenericRepository<TEntity extends BaseEntity> {
    /**
     * Adds a new entity to the data source.
     *
     * @param entity the object to add
     * @return true if added successfully, false otherwise
     */
    boolean add(TEntity entity);

    /**
     * Gets all entities from the data source.
     *
     * @return list of all entities
     */
    List<TEntity> getAll();

    /**
     * Checks if the given entity already exists.
     *
     * @param entity the object to check
     * @return true if it exists, false if not
     */
    boolean isExist(TEntity entity);

    /**
     * Updates an existing entity in the data source.
     *
     * @param entity the object with new values
     * @return true if updated successfully, false otherwise
     */
    boolean update(TEntity entity);

    /**
     * Finds an entity by its ID.
     *
     * @param id the ID to search
     * @return the entity with that ID, or null if not found
     */
    TEntity getById(long id);
}

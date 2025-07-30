package com.alibiner.library.Infrastructure;

import com.alibiner.library.Domain.BaseEntity;

import java.util.List;

public interface IGenericRepository<TEntity extends BaseEntity> {
    boolean add(TEntity entity);
    List<TEntity> getAll();
    boolean isExist(TEntity entity);
    TEntity getByObject (TEntity entity);
    boolean update(TEntity entity);
    TEntity getById(long id);
}

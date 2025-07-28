package com.alibiner.library.Infrastructure;

import com.alibiner.library.Domain.BaseEntity;

public interface IGenericRepository<TEntity extends BaseEntity> {
    boolean add(TEntity entity);
}

package com.alibiner.library.Infrastructure;

import com.alibiner.library.Domain.BaseEntity;

public interface IBookRepository<TEntity extends BaseEntity> {
    TEntity getByTitle(String title);
}

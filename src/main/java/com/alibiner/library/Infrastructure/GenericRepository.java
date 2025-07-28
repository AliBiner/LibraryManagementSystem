package com.alibiner.library.Infrastructure;

import com.alibiner.library.Domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<TEntity extends BaseEntity> implements IGenericRepository<TEntity>{
    private final List<TEntity> list = new ArrayList<>();

    @Override
    public boolean add(TEntity entity){
        boolean isTrue = list.add(entity);
        return isTrue;
    };
}

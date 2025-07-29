package com.alibiner.library.Infrastructure;

import com.alibiner.library.Domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<TEntity extends BaseEntity> implements IGenericRepository<TEntity>{
    private final List<TEntity> list = new ArrayList<>();

    @Override
    public boolean add(TEntity entity){
        entity.setId();
        return list.add(entity);
    }

    @Override
    public List<TEntity> getAll() {
        return list;
    }

    @Override
    public boolean isExist(TEntity entity) {
        for (TEntity entity1: list){
            boolean result = entity.equals(entity1);
        }
        boolean result = list.stream().anyMatch(element -> element.equals(entity));
        return result;
    }
}

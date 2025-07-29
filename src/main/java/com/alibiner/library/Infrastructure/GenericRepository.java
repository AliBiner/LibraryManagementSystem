package com.alibiner.library.Infrastructure;

import com.alibiner.library.Domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        boolean result = list.stream().anyMatch(element -> element.equals(entity));
        return result;
    }

    @Override
    public TEntity getByObject(TEntity entity) {
        return list.stream().filter(element -> element.equals(entity)).findFirst().get();
    }
}

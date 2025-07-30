package com.alibiner.library.Infrastructure;

import com.alibiner.library.Domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericRepository<TEntity extends BaseEntity> implements IGenericRepository<TEntity>{
    protected final List<TEntity> list = new ArrayList<>();

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
        return list.stream().filter(element -> element.equals(entity)).findFirst().orElse(null);
    }

    @Override
    public boolean update(TEntity entity) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(entity)){
                list.set(i,entity);
                return true;
            }
        }
        return false;
    }

    @Override
    public TEntity getById(long id) {
        return list.stream().filter(element -> element.getId()==id).findFirst().orElse(null);
    }

}

package com.alibiner.library.Infrastructure.Repositories;

import com.alibiner.library.Domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericRepository<TEntity extends BaseEntity> implements com.alibiner.library.Infrastructure.Interfaces.GenericRepository<TEntity> {
    protected final List<TEntity> list;

    public GenericRepository(List<TEntity> datalist) {
        this.list = datalist;
    }

    @Override
    public boolean add(TEntity entity){
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

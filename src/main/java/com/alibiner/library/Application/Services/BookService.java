package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.Mappers.Interfaces.IBaseMapper;
import com.alibiner.library.Infrastructure.IGenericRepository;

public class BookService extends GenericService {
    public BookService(IGenericRepository genericRepository) {
        super( genericRepository);
    }

}

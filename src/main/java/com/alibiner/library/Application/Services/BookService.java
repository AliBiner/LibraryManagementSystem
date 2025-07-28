package com.alibiner.library.Application.Services;

import com.alibiner.library.Application.DTOs.BaseDto;
import com.alibiner.library.Application.DTOs.InsertBookDto;
import com.alibiner.library.Application.Mappers.IBaseMapper;
import com.alibiner.library.Infrastructure.IGenericRepository;

public class BookService extends GenericService {
    public BookService(IBaseMapper mapper, IGenericRepository genericRepository) {
        super(mapper, genericRepository);
    }

}

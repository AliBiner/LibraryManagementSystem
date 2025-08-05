package com.alibiner.library.Application.DTOs;

import com.alibiner.library.Application.DTOs.Request.BookRequests.InsertBookDto;
import com.alibiner.library.Application.DTOs.Response.BookResponses.BookDetailDto;

/**
 * BaseDto is a marker interface used for all Data Transfer Objects (DTOs).
 * <p>
 * It helps create generic systems that only work with classes that represent data (DTOs).
 * <p>
 * For example, in a generic service or repository, we can use BaseDto to make sure
 * only valid DTOs are used.
 * <p>
 * This interface does not have any methods. It only gives a type limit (boundary)
 * for generic designs.
 *
 * @see InsertBookDto
 * @see BookDetailDto
 */
public interface BaseDto {
}

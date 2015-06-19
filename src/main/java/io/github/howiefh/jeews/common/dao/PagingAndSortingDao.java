/**
 * Copyright (c) 2015 https://github.com/howiefh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package io.github.howiefh.jeews.common.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 *
 * @author howiefh
 */
public interface PagingAndSortingDao<T, ID extends Serializable> extends CrudDao<T, ID>{
	List<T> findAllByPage(Pageable pageable);
}
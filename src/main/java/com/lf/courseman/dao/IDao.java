package com.lf.courseman.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDao<T> {
    int insert(T t);
    int update(UUID Id, T t);
    int delete(UUID Id);
    Optional<T> getById(UUID Id);
    List<T> getAll();
}

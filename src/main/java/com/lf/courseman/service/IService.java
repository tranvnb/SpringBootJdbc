package com.lf.courseman.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IService<T> {
    void add(T obj);
    void delete(UUID Id);
    void update(UUID Id, T obj);
    List<T> getAll();
    Optional<T> getById(UUID Id);
}

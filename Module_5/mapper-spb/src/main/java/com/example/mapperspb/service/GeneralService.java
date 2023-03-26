package com.example.mapperspb.service;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void delete(T t);

    void deleteById(Long id);
}

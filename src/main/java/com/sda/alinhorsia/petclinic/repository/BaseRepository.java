package com.sda.alinhorsia.petclinic.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {

    List<T> getAll();

    Optional<T> findById(int id);

    void create(T entity);

    void updateBYid(int id, T entity);

    void deleteById(int id);
}


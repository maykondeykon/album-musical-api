package com.mkdk.albummusicalapi.service;

import java.util.List;

public interface GenericServiceInterface<E> {
    E getBy(Integer id);

    E getBy(String termo);

    List<E> getAll();

    E save(E entity);

    E update(Integer id, E entity);

    void delete(Integer id);

    void delete(E entity);

}

package io.spotny.contacts.persistence.dal;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();

    T findById(String id);

    void insert(T element);

    void update(T element);

    void delete(T element);

    void delete(String id);
}

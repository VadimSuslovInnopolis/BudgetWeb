package main.model.dao;

import java.util.Collection;

/**
 * Created by admin on 21.04.2017.
 */
public interface DAO <PK, E> {

    Collection<E> getAll();

    E getById(PK id);

    PK insert(E entity);

    void update(E entity);

    void delete(E entity);
}

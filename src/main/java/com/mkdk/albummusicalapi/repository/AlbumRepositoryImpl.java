package com.mkdk.albummusicalapi.repository;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.repository.filter.AlbumFilter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepositoryImpl {
    @PersistenceContext
    private EntityManager manager;

    public List<Album> filtrar(AlbumFilter filter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Album> criteriaQuery = builder.createQuery(Album.class);

        Root<Album> root = criteriaQuery.from(Album.class);

        criteriaQuery.select(root)
                .where()
                .orderBy();

        return manager.createQuery(criteriaQuery).getResultList();
    }

    private Predicate[] criaRestricoes(AlbumFilter filter, CriteriaBuilder builder, Root<Album> root) {
        List<Predicate> predicates = new ArrayList<>();


        return predicates.toArray(new Predicate[predicates.size()]);
    }
}

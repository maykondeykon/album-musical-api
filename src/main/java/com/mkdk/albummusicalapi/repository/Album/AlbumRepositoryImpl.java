package com.mkdk.albummusicalapi.repository.Album;

import com.mkdk.albummusicalapi.model.Album;
import com.mkdk.albummusicalapi.repository.filter.AlbumFilter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepositoryImpl implements AlbumRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;

    public List<Album> filtrar(AlbumFilter filter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Album> criteriaQuery = builder.createQuery(Album.class);

        Root<Album> root = criteriaQuery.from(Album.class);

        Predicate[] restricoes = criaRestricoes(filter, builder, root);

        criteriaQuery.select(root)
                .where(restricoes)
                .orderBy(builder.asc(root.get("nome")));

        return manager.createQuery(criteriaQuery).getResultList();
    }

    private Predicate[] criaRestricoes(AlbumFilter filter, CriteriaBuilder builder, Root<Album> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getNome())) {
            predicates.add(builder.like(root.get("nome"), "%" + filter.getNome() + "%"));
        }

        if (filter.getAno() != null) {
            predicates.add(builder.equal(root.get("ano"), filter.getAno()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}

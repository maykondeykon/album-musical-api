package com.mkdk.albummusicalapi.repository.Musica;

import com.mkdk.albummusicalapi.model.Musica;
import com.mkdk.albummusicalapi.repository.filter.MusicaFilter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class MusicaRepositoryImpl implements MusicaRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Musica> filtrar(MusicaFilter filter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Musica> criteriaQuery = builder.createQuery(Musica.class);

        Root<Musica> root = criteriaQuery.from(Musica.class);

        Predicate[] restricoes = criaRestricoes(filter, builder, root);

        criteriaQuery.select(root)
                .where(restricoes)
                .orderBy(builder.asc(root.get("nome")));

        return manager.createQuery(criteriaQuery).getResultList();
    }

    private Predicate[] criaRestricoes(MusicaFilter filter, CriteriaBuilder builder, Root<Musica> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getNome())) {
            predicates.add(builder.like(root.get("nome"), "%" + filter.getNome() + "%"));
        }

        if (filter.getDuracao() != null) {
            predicates.add(builder.equal(root.get("duracao"), filter.getDuracao()));
        }

        if (!StringUtils.isEmpty(filter.getAutor())) {
            Join join = root.join("autores");
            predicates.add(builder.like(join.get("nome"), "%" + filter.getAutor() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}

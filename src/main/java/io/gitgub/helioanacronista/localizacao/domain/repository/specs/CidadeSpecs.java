package io.gitgub.helioanacronista.localizacao.domain.repository.specs;

import io.gitgub.helioanacronista.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;
/*
Pode criar Spces para nossas entidades

*/
public abstract class CidadeSpecs {

    public static Specification<Cidade> idEqual (Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal( root.get("id") , id);
    }

    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal( root.get("nome") , nome);
    }

    public static Specification<Cidade> habitantesGreaterThan(Long value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan( root.get("habitantes") , value );
    }

    public static Specification<Cidade> habitantesBetwenn (Long min, Long max) {
        return (root, query, cb ) -> cb.between( root.get("habitantes") , min, max );
    }

    public static Specification<Cidade> nomeLike (String nome) {
        return (root, query, cb) -> cb.like( cb.upper(root.get("nome")), "%" + nome +"%".toUpperCase());
    }
}

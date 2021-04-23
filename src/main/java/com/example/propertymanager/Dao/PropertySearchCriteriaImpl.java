package com.example.propertymanager.Dao;

import com.example.propertymanager.Entity.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertySearchCriteriaImpl implements PropertySearchCriteria {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Properties> findProperties(int categoryId, String searchStr, String sortBy, String sortOrder, Pageable page) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Properties> cq = cb.createQuery(Properties.class);
        Root<Properties> propertyRoot = cq.from(Properties.class);

        List<Predicate> list = new ArrayList<>();
        list.add(cb.like(propertyRoot.get("address"), "%" + searchStr + "%"));
        list.add(cb.like(propertyRoot.get("city"), "%" + searchStr + "%"));
        list.add(cb.like(propertyRoot.get("state"), "%" + searchStr + "%"));
        list.add(cb.like(propertyRoot.get("pincode"), "%" + searchStr + "%"));
        list.add(cb.equal(propertyRoot.get("categories"),categoryId));

        Predicate finalPredicate = cb.or(list.toArray(new Predicate[list.size()]));

        if (sortOrder.equalsIgnoreCase("asc")) {
            cq.where(finalPredicate).orderBy(cb.asc(propertyRoot.get(sortBy)));
        } else {
            cq.where(finalPredicate).orderBy(cb.desc(propertyRoot.get(sortBy)));
        }

        TypedQuery<Properties> query = entityManager.createQuery(cq);

        int totalRows = query.getResultList().size();
        query.setFirstResult(page.getPageNumber() * page.getPageSize());
        query.setMaxResults(page.getPageSize());

        Page<Properties> results = new PageImpl<>(query.getResultList(), page, totalRows);
        List<Properties> resultList = results.getContent();
        return resultList;
    }
}

package com.specification;

import com.model.EmployeeImportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpecificationCriteria {

    @Autowired
    EntityManager em;

    public List<EmployeeImportEntity> getListByCriteria(SearchRequest request){

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<EmployeeImportEntity> criteria = builder.createQuery(EmployeeImportEntity.class);
        Root<EmployeeImportEntity> root = criteria.from(EmployeeImportEntity.class);
        criteria.select(root);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if(request.getFullName()!=null){
            predicates.add(builder.equal(root.get("fullName"), request.getFullName()));
        }

        if(request.getJobTitle()!=null){
            predicates.add(builder.equal(root.get("jobTitle"), request.getJobTitle()));
        }
        if(request.getDepartment()!=null){
            predicates.add(builder.equal(root.get("department"), request.getDepartment()));
        }
        if (request.getBusinessUnit()!=null){
            predicates.add(builder.equal(root.get("businessUnit"), request.getBusinessUnit()));
        }
        criteria.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(criteria).getResultList();
    }

} //END CLASS

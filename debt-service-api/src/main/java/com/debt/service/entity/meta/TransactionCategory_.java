package com.debt.service.entity.meta;

import com.debt.service.common.TransactionCategoryEnum;
import com.debt.service.entity.TransactionCategoryEntity;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TransactionCategoryEntity.class)
public abstract class TransactionCategory_ {

    public static volatile SingularAttribute<TransactionCategoryEntity, TransactionCategoryEnum> type;
    public static volatile SingularAttribute<TransactionCategoryEntity, String> name;
    public static final String TYPE = "type";
    public static final String NAME = "name";
}
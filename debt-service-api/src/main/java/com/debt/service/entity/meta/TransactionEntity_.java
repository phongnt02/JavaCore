package com.debt.service.entity.meta;

import com.debt.service.common.TransactionTypeEnum;
import com.debt.service.entity.TransactionEntity;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TransactionEntity.class)
public abstract class TransactionEntity_ {

    public static volatile SingularAttribute<TransactionEntity, Integer> categoryId;
    public static volatile SingularAttribute<TransactionEntity, TransactionTypeEnum> type;
    public static volatile SingularAttribute<TransactionEntity, LocalDateTime> createdAt;
    public static final String CREATED_AT = "createdAt";
    public static final String TYPE = "type";
    public static final String CATEGORY_ID = "categoryId";
}
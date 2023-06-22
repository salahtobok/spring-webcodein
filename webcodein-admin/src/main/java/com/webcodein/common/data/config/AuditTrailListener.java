package com.webcodein.common.data.config;

import com.webcodein.common.data.entity.BasicEntity;
import jakarta.persistence.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

public class AuditTrailListener {

    private static Log log = LogFactory.getLog(AuditTrailListener.class);

    @PrePersist
    private void beforeCreate(BasicEntity auditedEntity) {
        auditedEntity.setCreatedOn(new Date());
    }
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(BasicEntity auditedEntity) {
        auditedEntity.setUpdatedOn(new Date());
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(BasicEntity auditedEntity) {
        auditedEntity.setUpdatedOn(new Date());
    }

    @PostLoad
    private void afterLoad(BasicEntity auditedEntity) {
    }
}

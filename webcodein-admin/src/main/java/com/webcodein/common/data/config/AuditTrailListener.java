package com.webcodein.common.data.config;

import com.webcodein.common.data.entity.AuditedEntity;
import jakarta.persistence.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

public class AuditTrailListener {

    private static Log log = LogFactory.getLog(AuditTrailListener.class);

    @PrePersist
    private void beforeCreate(AuditedEntity auditedEntity) {
        auditedEntity.setCreatedOn(new Date());
    }
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(AuditedEntity auditedEntity) {
        auditedEntity.setUpdatedOn(new Date());
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(AuditedEntity auditedEntity) {
        auditedEntity.setUpdatedOn(new Date());
    }

    @PostLoad
    private void afterLoad(AuditedEntity auditedEntity) {
    }
}


package com.admin.common.data.entity;


import com.admin.common.data.config.AuditTrailListener;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
//@ExcludeDefaultListeners
@EntityListeners(AuditTrailListener.class)
public abstract class AuditedEntity implements Serializable {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_by",updatable = false)
    private String CreatedBy;


    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }
}

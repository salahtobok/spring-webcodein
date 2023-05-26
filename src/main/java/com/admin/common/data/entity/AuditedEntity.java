
package com.admin.common.data.entity;


import com.admin.common.data.config.AuditTrailListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
//@ExcludeDefaultListeners
@EntityListeners(AuditTrailListener.class)
public abstract class AuditedEntity implements Serializable {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonbTransient
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonbTransient
    private Date updatedOn;

    @Column(name = "modified_by")
    @JsonbTransient
    private String modifiedBy;

    @Column(name = "created_by",updatable = false)
    @JsonbTransient
    private String CreatedBy;

}

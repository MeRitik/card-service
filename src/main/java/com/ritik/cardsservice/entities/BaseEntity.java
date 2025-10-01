package com.ritik.cardsservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @Column(updatable = false)
    @CreatedDate
    private Long createdAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;

    @Column(insertable = false)
    @LastModifiedDate
    private Long updatedAt;
}

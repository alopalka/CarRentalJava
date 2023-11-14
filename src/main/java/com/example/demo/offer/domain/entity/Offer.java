package com.example.demo.offer.domain.entity;

import com.example.demo.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Where(clause = "deleted = false")
@SQLDelete(sql = "update offers set deleted = true where id = ?1")
@EntityListeners(AuditingEntityListener.class)
public class Offer extends BaseEntity {

    private String description;

    // FIXME: 13.11.2023
//    private Car car ?

    private boolean deleted;

    private BigDecimal price;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
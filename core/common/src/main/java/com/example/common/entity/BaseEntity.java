package com.example.common.entity;

import com.example.common.converter.UuidConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Convert(converter = UuidConverter.class)
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @CreatedDate
    @Column(name = "created_at", nullable = false, columnDefinition= "timestamp with time zone")
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition= "timestamp with time zone")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private boolean deletedAt;

    @PrePersist
    public void generateUuid() {
        if (!StringUtils.hasLength(uuid)) {
            this.uuid = UUID.randomUUID().toString();
        }
    }
}

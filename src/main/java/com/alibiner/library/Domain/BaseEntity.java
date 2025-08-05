package com.alibiner.library.Domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * BaseEntity is an abstract class that provides common properties
 * for all entity classes in the system.
 * <p>
 * It gives each object a unique ID, status (active/inactive),
 * and tracks create, update, and delete times.
 * <p>
 * This class is used as a parent class for real entities like Book.
 */
public abstract class BaseEntity {
    /** A static ID generator. It increases by 1 each time a new object is created. */
    private static AtomicLong incrementId = new AtomicLong(0);

    /** Unique ID of the entity */
    private long id;

    /** Active or inactive status of the entity */
    private boolean status;

    /** The time when the entity was created */
    private LocalDateTime createdDate = null;

    /** The last time the entity was updated */
    private LocalDateTime updatedDate = null;

    /** The time when the entity was deleted (if any) */
    private LocalDateTime deletedDate = null;

    /** Shows if the entity is marked as deleted */
    private boolean isDeleted;

    /**
     * Constructor.
     * When called, sets default values:
     * - id as auto increment and closed modify
     * - status as true
     * - isDeleted as false
     * - createdDate as now
     */
    public BaseEntity() {
        setId();
        setStatus(true);
        setDeleted(false);
        setCreatedDate();
    }

    public long getId() {
        return id;
    }

    /**
     * Sets a new unique ID using the static counter.
     * Should be called only once during object creation.
     */
    private void setId() {
        this.id = incrementId.incrementAndGet();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the created date of the entity.
     * This method is private to prevent changes after creation.
     */
    private void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", deletedDate=" + deletedDate +
                ", isDeleted=" + isDeleted;
    }

}

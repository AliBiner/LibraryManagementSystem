package com.alibiner.library.Domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class BaseEntity {
    private static AtomicLong incrementId = new AtomicLong(0);
    private long id;
    private boolean status;
    private LocalDateTime createdDate = null;
    private LocalDateTime updatedDate = null;
    private LocalDateTime deletedDate = null;
    private boolean isDeleted;

    public BaseEntity() {
        setStatus(true);
        setDeleted(false);
        setCreatedDate(LocalDateTime.now());
    }

    public long getId() {
        return id;
    }

    public void setId() {
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

    private void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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

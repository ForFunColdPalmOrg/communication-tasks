package com.dk.tasks.persistence.entity;

import com.dk.tasks.service.dto.enums.TaskState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;

@Entity
//@Audited todo add
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerId;
    @Column(name = "deadline")
    private LocalDateTime deadline;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "assigned_to")
    private Integer assignedTo;
    @Column(name = "state")
    private TaskState state;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "description")
    private String description;
}

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
    @Column(name = "deadline")
    private LocalDateTime deadline;
    @Column(name = "created_by")
    private Integer createdBy; //todo to Entity
    @Column(name = "team_id")
    private Integer teamId; //todo to Entity
    @Column(name = "assigned_to")
    private Integer assignedTo; //todo to Entity
    @Column(name = "state")
    private TaskState state;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "description")
    private String description;
    @Column(name = "tax_code")
    private String taxCode;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "name")
    private String name;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "offer_id")
    private Integer offerId; //todo to Entity
}

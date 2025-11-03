package com.dk.tasks.persistence.entity;

import com.dk.tasks.service.dto.enums.EmployeePosition;
import com.dk.tasks.service.dto.enums.EmployeeTeam;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "team")
    private EmployeeTeam team;
    @Column(name = "position")
    private EmployeePosition position;
}

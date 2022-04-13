package com.iss.employer.core.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tasks")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false, unique = true)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignee;

}

package com.example.basicsubjectmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Teacher extends PersonBase {
    private String department;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}

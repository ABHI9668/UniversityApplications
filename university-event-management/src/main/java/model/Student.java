package model;
import jakarta.persistence.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "First name should start with a capital letter")
    private String firstName;

    private String lastName;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 25, message = "Age must not exceed 25")
    private int age;


    private Department department;
}

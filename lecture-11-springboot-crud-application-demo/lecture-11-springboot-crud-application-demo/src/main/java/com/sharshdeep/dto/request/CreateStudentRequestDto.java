package com.sharshdeep.dto.request;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank(message = "Name Cannot be empty blank or null")
    @Size(min = 2 ,max = 50 ,message = "Student should be between 2 and 50 character")
    private String name;

@Min(value = 18)
@NotNull(message = "Student age should e more than 18 yr or equal to")
    private Integer age;

@NotNull(message = "roll no is emty")
    private int rollNo;

    @Email(message = "Email is inavlid")
    private String email;

    @NotEmpty(message = "Subject is required")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

package com.test.demo.entity;

import com.test.demo.Enums.Education;
import com.test.demo.Enums.SexEnum;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NotNull(message = "性别不能是空")
    private SexEnum sex;
    @Column(nullable = false)
    @NotNull(message = "学历不能是空")
    private Education education;
    @Column(nullable = false)
    @Min(value = 12,message = "学生年龄最小不能低于12岁")
    @Max(value = 20, message = "学生年龄最大不能高于20岁")
    @NotNull(message = "年龄不能是空")
    private Integer age;
    private String email;
    @NotNull(message = "名字不能是空")
    @Column(nullable = false,unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

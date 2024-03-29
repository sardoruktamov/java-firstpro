package uz.mohirdev.lesson.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 150)
    private String lastName;

    @NotNull    // javani o`zi uchun
    @Size(min = 5, max = 50)    // javani o`zi uchun
    @Column(length = 50, unique = true)    // javani o`zi uchun
    @Email
    private String email;

    @ManyToOne  //name-jadval nomi,employee_id-birinchi ustun (id-qiymati),project_id-ikkinchi ustun
    @JoinTable(
            name = "dev_employee_project",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")}
    )
    private Department department;

    @OneToOne(optional = false) //nullable = false va optional = false  larni vazifasi birxil(yani null!=0)
    @JoinColumn(name = "account_id", unique = true, nullable = false)
    private Account account;

    @OneToMany
    private Set<Item> items;

    @ManyToMany
    private Set<Project> projects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}

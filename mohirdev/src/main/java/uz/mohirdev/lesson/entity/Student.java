package uz.mohirdev.lesson.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table()
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // ID - unic boladi va 1 dan kopayadi bu usulda
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    private String address;

}

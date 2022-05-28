package kodlamaio.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @NotBlank
    @Email
    @Size(max = 50)
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 256)
    @Column(name = "password")
    private String password;

    @Column(name = "email_validation_status")
    private boolean emailValidationStatus;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
}

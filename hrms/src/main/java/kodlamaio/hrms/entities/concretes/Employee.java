package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employee extends User {

    @NotNull
    @NotBlank
    @Size(max = 25)
    @Column(name = "name")
    private String name;

    @NotBlank
    @NotNull
    @Size(max = 25)
    @Column(name = "lastname")
    private String lastname;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^\\d{11}$", message = "National identity must be 11 digits")
    @Column(name = "identity_number", unique = true)
    private String identityNumber;

    @NotNull
    @Past
    @Column(name = "dateofbirth")
    private LocalDate dateofbirth;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"employee"})
    private List<Resume> resumes;
}

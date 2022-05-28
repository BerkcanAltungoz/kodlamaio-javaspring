package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "employee_id", referencedColumnName = "user_id")
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
    @Column(name = "identity_number")
    private String identityNumber;

    @NotNull
    @Past
    @Column(name = "dateofbirth")
    private LocalDate dateofbirth;

}

package kodlamaio.hrms.entities.concretes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "companies")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Company extends User{

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "website")
    private String website;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{10}$", message = "Telephone Number Must be 10 Digits")
    @Column(name = "telephone_number", unique = true)
    private String telephoneNumber;

    @Column(name = "personnel_validation_status")
    private boolean personnelValidationStatus;

    @Column(name = "date_verified")
    @PastOrPresent
    private LocalDateTime dateVerified;
}

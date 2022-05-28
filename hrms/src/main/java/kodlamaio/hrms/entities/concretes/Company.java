package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "company_id", referencedColumnName = "user_id")
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
    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "personnel_validation_status")
    private boolean personnelValidationStatus;

    private LocalDateTime dateVerified;
}

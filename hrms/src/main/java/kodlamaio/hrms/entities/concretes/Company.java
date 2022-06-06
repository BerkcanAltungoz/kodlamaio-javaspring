package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;


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
    @Column(name = "name", unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name = "website", unique = true)
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

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"company"})
    private List<JobPosting> jobPostings;
}

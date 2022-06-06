package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "job_postings")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "user_id")
    @JsonIgnoreProperties({"jobPostings"})
    private Company company;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"jobPostings"})
    private City city;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"jobPostings"})
    private Position position;

    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

    @NotNull
    @Positive
    @Column(name = "open_positions")
    private short openPositions;

    @PositiveOrZero
    @Column(name = "salary_max")
    private int salaryMax;

    @PositiveOrZero
    @Column(name = "salary_min")
    private int salaryMin;

    @NotNull
    @Future
    @Column(name = "last_application_date")
    private LocalDate lastApplicationDate;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "status")
    private boolean status;


}

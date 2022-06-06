package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employees")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ResumeExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    @JsonIgnoreProperties({"resumeExperiences"})
    private Resume resume;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    @JsonIgnoreProperties({"resumeExperiences"})
    private Position position;

    @Past
    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @NotNull
    @NotBlank
    @Size(max = 150)
    @Column(name = "workplace")
    private String workplace;
}

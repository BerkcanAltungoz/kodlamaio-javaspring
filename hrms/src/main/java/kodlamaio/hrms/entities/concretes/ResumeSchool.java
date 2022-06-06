package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "resume_schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ResumeSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    @JsonIgnoreProperties({"resumeSchools"})
    private Resume resume;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    @JsonIgnoreProperties({"resumeSchools"})
    private School school;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_department_id")
    @JsonIgnoreProperties({"resumeSchools"})
    private SchoolDepartment schoolDepartment;

    @NotNull
    @Past
    @Column(name = "enroll_date")
    private LocalDate enrollDate;

    @Column(name = "graduation_date")
    private LocalDate graduationDate;
}

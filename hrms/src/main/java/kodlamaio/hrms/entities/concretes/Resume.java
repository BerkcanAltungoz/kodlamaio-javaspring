package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties({"resumes"})
    private Employee employee;

    @NotNull
    @NotBlank
    @Column(name = "cover_letter")
    private String coverLetter;

    @NotNull
    @NotBlank
    @Size(max = 200)
    @Column(name = "github_account")
    private String githubAccount;

    @NotNull
    @NotBlank
    @Size(max = 200)
    @Column(name = "linkedin_account")
    private String linkedinAccount;

    @NotNull
    @NotBlank
    @Size(max = 200)
    @Column(name = "img_url")
    private String imgUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"resume"})
    private List<ResumeExperience> resumeExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"resume"})
    private List<ResumeLanguage> resumeLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"resume"})
    private List<ResumeProgrammingLanguage> resumeProgrammingLanguages;
}

package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "resume_programming_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ResumeProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    @JsonIgnoreProperties({"resumeProgrammingLanguages"})
    private Resume resume;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programming_language_id")
    @JsonIgnoreProperties({"resumeProgrammingLanguages"})
    private ProgrammingLanguage programmingLanguage;

    @NotNull
    @Min(1)
    @Max(5)
    @Column(name = "proficiency")
    private short proficiency;
}

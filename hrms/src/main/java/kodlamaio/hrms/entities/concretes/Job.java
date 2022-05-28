package kodlamaio.hrms.entities.concretes;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobID;

    @NotNull
    @Column(name = "company_id")
    private int companyID;

    @Column(name = "title")
    private String title;

    @Column(name = "field")
    private String field;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private int salary;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "location")
    private String location;


}

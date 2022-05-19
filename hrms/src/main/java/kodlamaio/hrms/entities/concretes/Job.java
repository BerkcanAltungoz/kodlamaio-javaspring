package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="jobs")
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue
    @Column(name = "job_id")
    private int jobID;

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

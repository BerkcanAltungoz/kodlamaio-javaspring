package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="jobs")
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

    public Job() {
    }

    public Job(int jobID, int companyID, String title, String field, String description, int salary, Date startDate, Date endDate, String location) {
        this.jobID = jobID;
        this.companyID = companyID;
        this.title = title;
        this.field = field;
        this.description = description;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }
}

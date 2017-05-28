package lv.javaguru.java2.domain;

import lv.javaguru.java2.domain.enumerations.Priorities;
import lv.javaguru.java2.domain.enumerations.TaskStates;

import javax.persistence.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "int(11)")
    private Long taskId;

    @Column(name="summary", columnDefinition = "char(128)")
    private String summary;

    @Column(name="content", columnDefinition = "text")
    private String description;

    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name="creation_date", columnDefinition = "datetime")
    private Date creationDate;

    @Column(name="estimate", columnDefinition = "datetime")
    private Date estimate;

    @Column(name="last_updated", columnDefinition = "datetime")
    private Date lastUpdated;

    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "updated_by")
    private User lastUpdatedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priorities priority;

    @Transient
    private List<Comment> comments = new ArrayList<Comment>();

    @Enumerated(EnumType.STRING)
    @Column(name = "task_state")
    private TaskStates taskState;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEstimate() {
        return estimate;
    }

    public void setEstimate(Date estimate) {
        this.estimate = estimate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(User lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Priorities getPriority() {
        return priority;
    }

    public void setPriority(Priorities priority) {
        this.priority = priority;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public TaskStates getTaskState() {
        return taskState;
    }

    public void setTaskState(TaskStates taskState) {
        this.taskState = taskState;
    }
}

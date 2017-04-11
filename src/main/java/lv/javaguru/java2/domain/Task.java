package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.annotations.Relation;
import lv.javaguru.java2.database.enumerations.RelationTypes;
import lv.javaguru.java2.domain.enumerations.Priorities;
import lv.javaguru.java2.domain.enumerations.TaskStates;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {

    private Long taskId;
    private String summary;
    private String description;

    @Relation(
            relationType = RelationTypes.MANY_TO_ONE,
            targetClass = User.class,
            columnName = "assigned_to"
    )
    private User assignedTo;

    @Relation(
            relationType = RelationTypes.MANY_TO_ONE,
            targetClass = User.class,
            columnName = "created_by"
    )
    private User createdBy;
    private Date creationDate;
    private Date estimate;
    private Date lastUpdated;

    @Relation(
            relationType = RelationTypes.MANY_TO_ONE,
            targetClass = User.class,
            columnName = "updated_by"
    )
    private User lastUpdatedBy;
    private Priorities priority;

    private List<Comment> comments = new ArrayList<Comment>();
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

package com.nativelabs.spring.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.Integer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notes")
@JsonIgnoreProperties(value = {"createDate", "updateDate"},
        allowGetters = true)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    private String title;

    @Lob
    @NotNull
    private String description;


    @ElementCollection
    private List<String> tags = new ArrayList<String>();

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;


    @Column(name="updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateDate;

    //Many courses for one Topic
    @ManyToOne
            //(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false)
    private Topic topic;

    public Note() {
    }

    public Note(Integer id, String title, List<String> tags, String description, Date createDate, Date updateDate, Integer  topicId) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.topic = new Topic(topicId,"", "");
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date whatIsTime(){
        return new Timestamp(new Date().getTime());
    }
}

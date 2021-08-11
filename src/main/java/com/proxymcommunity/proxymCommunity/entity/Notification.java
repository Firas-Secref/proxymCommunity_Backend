package com.proxymcommunity.proxymCommunity.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Developer developer;

    private String to_firstname;
    private String to_lastname;
    private Long to_userId;
    private String action;
    private String to_username;
    @Column(columnDefinition = "TEXT")
    private String notificationText;

    public Notification(Developer developer, String to_firstname, String to_lastname, Long to_userId, String action, String to_username, String notificationText) {
        this.developer = developer;
        this.to_firstname = to_firstname;
        this.to_lastname = to_lastname;
        this.to_userId = to_userId;
        this.action = action;
        this.to_username = to_username;
        this.notificationText = notificationText;
    }
}

package com.proxymcommunity.proxymCommunity.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Developer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String username;
    private String birthdate;

    @Column(unique = true)
    private String email;
    private String password;
    private String ville;
    private String address;
    private String pays;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String profileImage;


//    @ManyToOne
//    private Department department;

//    @ManyToOne
//    private Profile profile;
    private String departement;
    private String profile;
    private Long codePostal;
    private String aPropos;

    @OneToMany(mappedBy = "developer", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Notification> notifications;
//    @ManyToMany(mappedBy = "likes")
//    private List<Publication> likedPosts;

}

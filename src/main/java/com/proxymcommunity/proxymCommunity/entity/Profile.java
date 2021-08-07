package com.proxymcommunity.proxymCommunity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.criteria.internal.SelectionImplementor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String profileName;

//    @OneToMany(mappedBy = "profile")
//    private List<Developer> developers;

}

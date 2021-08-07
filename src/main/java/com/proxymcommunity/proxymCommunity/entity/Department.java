package com.proxymcommunity.proxymCommunity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String departmentName;

//    @OneToMany(mappedBy = "department")
//    private List<Developer> developers;

}

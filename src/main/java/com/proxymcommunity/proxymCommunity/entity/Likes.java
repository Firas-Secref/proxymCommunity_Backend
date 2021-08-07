package com.proxymcommunity.proxymCommunity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Likes implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    private Long liker_Id;
    private Long post_Id;

    public Likes(Long liker_Id, Long post_Id) {
        this.liker_Id = liker_Id;
        this.post_Id = post_Id;
    }
}


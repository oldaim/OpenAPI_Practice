package com.openapi.naverdata.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long id;

    @Column
    private String title;

    @Column
    private String keyword;

    @OneToMany(mappedBy = "result")
    List<ResultData> data = new ArrayList<>();

}

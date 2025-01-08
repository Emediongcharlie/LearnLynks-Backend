package com.project.LearnLynks.models;

import jakarta.persistence.*;

import lombok.*;

@Getter@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LearningMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private String filePath;
    @Lob
    private byte[] fileData;

}

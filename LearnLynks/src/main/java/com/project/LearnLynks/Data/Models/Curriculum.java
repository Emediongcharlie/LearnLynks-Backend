package com.project.LearnLynks.Data.Models;

import jakarta.persistence.*;

@Entity
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int curriculumId;
    private String name;
    private String description;
    private boolean archived;
    private String creator;

    public byte[] getMaterials() {
        return materials;
    }

    public void setMaterials(byte[] materials) {
        this.materials = materials;
    }

    private byte[] materials;

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}

package com.project.LearnLynks.dtos.request;

public class UpdateCurriculumRequest {


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

    private String name;
    private String description;
    private String creator;

    public byte[] getMaterials() {
        return materials;
    }

    public void setMaterials(byte[] materials) {
        this.materials = materials;
    }

    private byte[] materials;

}

package uz.mohirdev.lesson.entity;

import uz.mohirdev.lesson.entity.enummration.FileStorageStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class FileStorage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String extention;
    private Long fileSize;
    private String contentType;
    private String hashId;  // faylga takrorlanmas nom yasab chaqirish uchun

    private FileStorageStatus fileStorageStatus;
    private String uploadFolder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public FileStorageStatus getFileStorageStatus() {
        return fileStorageStatus;
    }

    public void setFileStorageStatus(FileStorageStatus fileStorageStatus) {
        this.fileStorageStatus = fileStorageStatus;
    }

    public String getUploadFolder() {
        return uploadFolder;
    }

    public void setUploadFolder(String uploadFolder) {
        this.uploadFolder = uploadFolder;
    }
}

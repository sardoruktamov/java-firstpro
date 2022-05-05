package uz.mohirdev.lesson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.mohirdev.lesson.entity.FileStorage;
import uz.mohirdev.lesson.entity.enummration.FileStorageStatus;
import uz.mohirdev.lesson.repository.FileStorageRepository;

@Service
public class FileStorageService {
    private final FileStorageRepository fileStorageRepository;

    // applecation.yml faylidagi upload malumotini qaytaradi
    @Value("${upload.server.folder}")   // serverFolderPath = /Users/DXM-HP/Documents/upload/
    private String serverFolderPath;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    public FileStorage save(MultipartFile multipartFile){
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setExtention(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileStorageStatus(FileStorageStatus.DRAFT);
        fileStorage = fileStorageRepository.save(fileStorage);

        //bu yerda serverFolderPath-static path; upload_folder-dinamic path
        // /serverFolderPath/upload_folder/2022/04/24/dsfsdvsd.pdf
        return fileStorage;
    }

    //fayl extenshinini ajratib ollish
    private String getExt(String fileName){
        String ext = null;

        if (fileName != null && !fileName.isEmpty()){
            int dot = fileName.lastIndexOf('.'); // nuqtagacha bolgan fayl nomini oldi
            if(dot > 0 && dot <= fileName.length()-2){
                ext = fileName.substring(dot+1);
            }
        }
        return ext;
    }
}

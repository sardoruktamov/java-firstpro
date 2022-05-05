package uz.mohirdev.lesson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.mohirdev.lesson.entity.FileStorage;
import uz.mohirdev.lesson.entity.enummration.FileStorageStatus;
import uz.mohirdev.lesson.repository.FileStorageRepository;

import java.io.File;
import java.util.Date;

@Service
public class FileStorageService {
    private final FileStorageRepository fileStorageRepository;

    // applecation.yml faylidagi upload malumotini qaytaradi (BU STATIC PATH)
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
        // /serverFolderPath/upload_files/2022/04/24/dsfsdvsd.pdf
        // ESLATMAAAA  Date() funksiyasi 1900 yildan boshlanadi, shuning uchun 1900 yilni qoshib qoyamiz
        // ESLATMAAAA  Date() funksiyasida oy boshi 0 dan boshlanadi, shuning uchun 1 ni qoshib qoyamiz

        Date now = new Date();  // bu javadagi tayyor class xozirgi vaqtni qaytaradi
        //formatlashning 1-usuli
//        File uploadFolder = new File(this.serverFolderPath + "/upload_files" +
//                1900+now.getYear() + "/" + 1 + now.getMonth() + "/" +now.getDate());
        //formatni yozishning 2-usuli
        String path = String.format("%s/upload_files/%d/%d/%d", this.serverFolderPath, 1900+now.getYear(),
                1 + now.getMonth(),now.getDate());
        File uploadFolder = new File(path);
        if(!uploadFolder.exists() && uploadFolder.mkdir()){
            System.out.println("Created folred");
        }

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

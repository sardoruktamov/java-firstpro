package uz.mohirdev.lesson.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.util.UriEncoder;
import uz.mohirdev.lesson.entity.FileStorage;
import uz.mohirdev.lesson.service.FileStorageService;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api")
public class FileStorageResource {

    private final FileStorageService fileStorageService;

    @Value("${upload.server.folder}")
    private String serverFolderPath;

    public FileStorageResource(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file")MultipartFile multipartFile){
        FileStorage fileStorage = fileStorageService.save(multipartFile);
        return ResponseEntity.ok(fileStorage);
    }

    // hashId orqali fayllarni o'qib olish
    @GetMapping("/file-preview/{hashId}")
    public ResponseEntity preview(@PathVariable String hashId) throws MalformedURLException {
        FileStorage fileStorage = fileStorageService.findByHashId(hashId); //fayl malumoti olindi

        //"inline;"  bo`lgan holatda fayllarni o'qish uchun ishlatamiz
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"inline; fileName=\""+ UriEncoder.encode(fileStorage.getName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .contentLength(fileStorage.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s",this.serverFolderPath, fileStorage.getUploadFolder())));
    }

    // hashId orqali fayllarni yuklab olish
    @GetMapping("/download/{hashId}")
    public ResponseEntity download(@PathVariable String hashId) throws MalformedURLException {
        FileStorage fileStorage = fileStorageService.findByHashId(hashId); //fayl malumoti olindi

        //"attachment;"  bo`lgan holatda fayllarni yuklash uchun ishlatamiz
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=\""+ UriEncoder.encode(fileStorage.getName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .contentLength(fileStorage.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s",this.serverFolderPath, fileStorage.getUploadFolder())));
    }

    @DeleteMapping("/delete/{hashId}")
    public ResponseEntity delete(@PathVariable String hashId){
        fileStorageService.delete(hashId);
        return ResponseEntity.ok("fayl o'chirildi!");
    }
}

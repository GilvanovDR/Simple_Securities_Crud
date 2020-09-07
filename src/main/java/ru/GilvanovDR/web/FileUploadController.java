package ru.GilvanovDR.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.GilvanovDR.service.UploadService;
import ru.GilvanovDR.util.exception.NotFoundException;


@Controller
@RequestMapping("/upload")
public class FileUploadController {
    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    private UploadService service;

    @PostMapping()
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        log.debug("UPLOAD file {}", file.getOriginalFilename());
        try {
            model.addAttribute("upload", "Всего загружено элементов " + service.uploadFile(file));
        } catch (NotFoundException e) {
            model.addAttribute("upload", "Ошибка в загружаемом файле! Файл не загружен!");
        }
        return "upload";
    }
}




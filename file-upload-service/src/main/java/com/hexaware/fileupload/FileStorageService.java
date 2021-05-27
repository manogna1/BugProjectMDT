package com.hexaware.fileupload;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
private Path fileStoragePath = Paths.get("C:\\Users\\49206\\BugProjectMDT\\uploads");
public String storeFile(MultipartFile file) {
	String fileName= StringUtils.cleanPath(file.getOriginalFilename());
	Path targetLocation = fileStoragePath.resolve(fileName);
	try {
		Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return fileName;
}
public Resource loadFile(String fileName) {
	Path filePath=fileStoragePath.resolve(fileName).normalize();
	Resource resource= null;
	try {
		resource=new UrlResource(filePath.toUri());
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return resource;
}
}

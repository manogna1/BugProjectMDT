package com.hexaware.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {
@Autowired
FileStorageService fileStorageService;
	@PostMapping("uploadFile")
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		String fileName= fileStorageService.storeFile(file);
		
		String downloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(fileName).toUriString();
		System.out.println(downloadUrl);
		return downloadUrl;
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName) {
		Resource resource=fileStorageService.loadFile(fileName);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName\"")
				.body(resource);
	}
}

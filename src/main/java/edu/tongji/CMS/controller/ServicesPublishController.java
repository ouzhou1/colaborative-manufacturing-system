package edu.tongji.CMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.tongji.CMS.Service.service.StorageService;

@Controller
public class ServicesPublishController {

	private final StorageService storageService;

	@Autowired
    public ServicesPublishController(StorageService storageService) {
        this.storageService = storageService;
    }

	@GetMapping("/services/hardresource/file")
	@ResponseBody
	public String listUploadedFiles() {

		return "uploadForm";
	}

	@PostMapping("/hardresource/filecreate")
	public String hardResourceFileCreate(@RequestParam("file") MultipartFile file) {

		JSONObject obj = new JSONObject(file);
		List<String> list = new ArrayList<String>();

		return "redirect:/services/hardresource/file";
	}
}
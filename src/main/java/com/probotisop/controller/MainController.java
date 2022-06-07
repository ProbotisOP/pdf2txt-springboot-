package com.probotisop.controller;
import com.spire.pdf.*;
import java.io.*;
import java.util.Scanner;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.probotisop.service.FileService;

@Controller
public class MainController {
	
	@Autowired
	FileService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/submit")

	public String pdf2txt(@RequestParam("file") MultipartFile f , Model model
			) throws IllegalStateException, IOException {
		
		System.out.println(f.getOriginalFilename());
		System.out.println(f.getContentType());
		
	//	java.io.File ff = service.multipartToFile(f, "file");
		
		
		 PdfDocument pdf = new PdfDocument(); 
		 pdf.loadFromBytes(f.getBytes());
	     
	        //Create a new txt file to save the extracted text  
	        String result = "src/main/resources/data.txt";  
	        java.io.File file = new File(result);  
	        if (!file.exists()) {  
	            file.delete();  
	        }  
	        file.createNewFile();  
	        FileWriter fw = new FileWriter(file);  
	        BufferedWriter bw = new BufferedWriter(fw);  
	        //Extract text from all the pages on the PDF  
	        PdfPageBase page;  
	        for (int i = 0; i < pdf.getPages().getCount(); i++) {  
	            page = pdf.getPages().get(i);  
	            String text = page.extractText(true);  
	            bw.write(text);  
	        }  
	        bw.flush();  
	        bw.close();  
	        fw.close(); 
	        
	        File data = new File("src/main/resources/data.txt");
	        Scanner s = new Scanner(data);
	        
	        StringBuffer sf = new StringBuffer();
	        
	        
	        
	        while(s.hasNext()) {
	        
	        	sf.append(s.nextLine());
	        }
	       
	       
	       
	       model.addAttribute("data", sf.toString());
	       
	       
	        
	        return "home";
	    }  

		
		
		
		
	}


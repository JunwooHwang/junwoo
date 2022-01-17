package org.jun.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("upload")
	public void uploadForm() {
		System.out.println("파일 업로드 화면....");
	}
	
	@GetMapping("uploadAjax")
	public void uploadAjax() {
		System.out.println("파일 업로드 화면....");
	}
	
	//upload.jsp에서 form태그를 이용해서 파일 업로드
	@PostMapping("uploadAction")
	public String uploadAcrion(MultipartFile[] uploadFile) {
		
		// 파일업로드 할 경로지정
		String uploadFolder="D:\\upload";
		//MultipartFile를 사용하면 DTO 필요없음
		//for(int i=0;i<uploadFile.length; i++) {
		for(MultipartFile multipartFile : uploadFile) {
			// 사용자가 업로드한 실제 파일이름
			System.out.println("MultipartFile = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드한 실제 파일크기		
			System.out.println("MultipartFile = " + multipartFile.getSize());
			// 사용자가 업로드한 실제 파일양식		
			System.out.println("MultipartFile = " + multipartFile.getContentType());
			
			// File 클래스 : 자바에서 file 입출력을 담당하는 클래스
			// 기본생성자 없음
			// uploadFolder에 저장되어 있는 경로로 실제 파일명으로 저장.
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());
			
			// transferTo를 사용하려면 예외처리 필수(try-catch)
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/upload";
	}
	
	//uploadAjax.jsp에서 ajax를 이용해서 파일 업로드 controller
	@PostMapping("uploadAjaxAction")
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		System.out.println("실행됨");
		// 파일업로드 할 경로지정
		String uploadFolder="D:\\upload";
		//MultipartFile를 사용하면 DTO 필요없음
		//for(int i=0;i<uploadFile.length; i++) {
		for(MultipartFile multipartFile : uploadFile) {
			// 사용자가 업로드한 실제 파일이름
			System.out.println("MultipartFile = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드한 실제 파일크기		
			System.out.println("MultipartFile = " + multipartFile.getSize());
			// 사용자가 업로드한 실제 파일양식		
			System.out.println("MultipartFile = " + multipartFile.getContentType());
			
			// File 클래스 : 자바에서 file 입출력을 담당하는 클래스
			// 기본생성자 없음
			// uploadFolder에 저장되어 있는 경로로 실제 파일명으로 저장.
			File saveFile=new File(uploadFolder,multipartFile.getOriginalFilename());
			
			// transferTo를 사용하려면 예외처리 필수(try-catch)
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

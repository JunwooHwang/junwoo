package org.jun.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.jun.domain.AttachFileDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

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
			} // try 끝
		} // for문 끝
		return "redirect:/upload";
	}
	
	// 년/월/일 폴더의 생성하기 위한 폴더 이름 추출하여 리턴
	private String getFolder() {
		// 현재날짜를 추출
		Date date = new Date();
		// Tue Jan 18 09:34:09 KST 2022 -> 2022-01-18(yyyy-mm-dd형식으로 변형)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 2022-01-18 폴더로 생성하려면 -> 2022\01\18
		String str = sdf.format(date);
		System.out.println("date = " + date);
		//               2022-01-18 -> 2022\01\18
		return str.replace("-", File.separator);
	}
	
	// 썸네일 이미지 생성을 할 것인지 안할 것인지에 대해 판단하는 메소드 (사용자가 업로드 한 파일이 이미지이면 생성, 그렇지 않으면 생성안함)
	private boolean checkImage(File file) {
		try {
			// 파일의 타입을 알아내는 probeContentType메소드 호출하여 사용
			String contentType = Files.probeContentType(file.toPath());
			// 그 파일의 타입이 image이면 true, 그렇지 않으면  false
			return contentType.startsWith("image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	//uploadAjax.jsp에서 ajax를 이용해서 파일 업로드 controller
	@PostMapping(value = "uploadAjaxAction",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ArrayList<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		// AttachFileDTO에 저장되는 값이 여러파일에 대한 값이면 배열로 처리가 되어야 하므로 ArrayList타입이 되어야 함.
		ArrayList<AttachFileDTO> list = new ArrayList<>();
		
		
		System.out.println("실행됨");
		// 파일업로드 할 경로지정
		String uploadFolder="D:\\upload";

		
		// 폴더 생성                              (기존 폴더          , 현재 폴더     )를 결합
		File uploadPath = new File(uploadFolder,getFolder());
		
		String uploadFolderPath = getFolder();
		
		
		
		System.out.println("uploadPath = " + uploadPath);
		
		// 현재 만들려고 하는 폴더가 없으면  폴더 생성
		if(uploadPath.exists()==false) {
			//mkdirs= make directroies
			uploadPath.mkdirs();
		}
		
		//MultipartFile를 사용하면 DTO 필요없음
		//for(int i=0;i<uploadFile.length; i++) {
		for(MultipartFile multipartFile : uploadFile) {
			
			// UploadController에 있는 메소드(uploadAjaxActiond)에서 AttachFileDTO를 사용해서 값을 저장해야 되는데
			// 이럴경우 UploadController에 AttachFileDTO가 없으면 사용할수가 없다.
			// 그래서 UploadController에 AttachFileDTO를 포함 시켜서 사용하여 값을 저장.
			AttachFileDTO attachdto = new AttachFileDTO();
			
			
			// 사용자가 업로드한 실제 파일이름
			System.out.println("MultipartFile = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드한 실제 파일크기		
			System.out.println("MultipartFile = " + multipartFile.getSize());
			// 사용자가 업로드한 실제 파일양식		
			System.out.println("MultipartFile = " + multipartFile.getContentType());
			//---------------------------------------------------------------------------
			// 파일 덮어쓰기 방지
			// 실제파일명 저장
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// 실제 파일명(uploadFileName)을 AttachFileDTO클래스(attachdto)에 fileName을 저장(setFileName)
			attachdto.setFileName(uploadFileName);
			
			// 중복이 되지않는 문자열을 생성
			UUID uuid = UUID.randomUUID();
			
			// UUID + "_" + getOriginalFilename()의 조합으로 파일명을 uploadFileName에 저장
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			// File 클래스 : 자바에서 file 입출력을 담당하는 클래스, 기본생성자 없음
			// uploadFolder에 저장되어 있는 경로로 실제 파일명으로 저장.
			File saveFile=new File(uploadPath,uploadFileName);
			
			try {
				// saveFile 변수에 저장되어 있는 폴더명으로 파일을 보내라
				multipartFile.transferTo(saveFile);
				
				// 실제 업로드경로(uploadFolderPath)을 AttachFileDTO클래스(attachdto)에 uploadPath을 저장(setUploadPath)
				attachdto.setUploadPath(uploadFolderPath);
				
				// uuid값(UUID)을 AttachFileDTO클래스(attachdto)에 uuid을 저장(setUuid)
				attachdto.setUuid(uuid.toString());
				
				// * 썸네일 생성 *
				// 2.image 파일이면
				if(checkImage(saveFile)) {
					// FileType값(image)을 AttachFileDTO클래스(attachdto)에 uuid을 저장(setImage)
					attachdto.setImage(true);
					// 썸네일 파일을 생성하기 전에 썸네일 파일 이름을 추출(기존 파일명에"s_" 추가)
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_" + uploadFileName));
					
					// 썸네일 파일을 생성함
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail , 100, 100);
					
					// 썸네일 종료(메모리 공간 환수)
					thumbnail.close();
				}
				// 화면에 썸네일을 보여주기 위해서 add()를 통해서 각 파일에 대한 정보들이 list에 들어오게 됨
				list.add(attachdto);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // transferTo를 사용하려면 예외처리 필수(try-catch) //try 끝
			
		} // for문 끝
		// 통신상태가 정상적(HttpStatus.OK)이면 ArrayList에 저장되어 있는 값을 웹브라우저에 보내라
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	

	
}

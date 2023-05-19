package com.trip.mukja.controller;

import com.trip.mukja.model.dto.FileInfoDTO;
import com.trip.mukja.model.dto.HotplaceDTO;
import com.trip.mukja.service.HotplaceService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// Swagger 주소
// http://localhost/swagger-ui/index.html
@RestController
@RequestMapping("/places")
@CrossOrigin("*")
@Api(tags = {"Hotplace 관리"})
public class HotplaceController {

    private final Logger logger = LoggerFactory.getLogger(HotplaceController.class);

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private HotplaceService hotplaceService;

    @Autowired
    public HotplaceController(HotplaceService hotplaceService) {
        this.hotplaceService = hotplaceService;
    }

    // Swagger
    @ApiOperation(value = "핫플레이스 목록", notes = "핫플레이스 목록 API")
    @ApiResponses({@ApiResponse(code = 200, message = "핫플레이스 목록 OK"), @ApiResponse(code = 500, message = "서버오류")})
    // 리스트
    @GetMapping
    public ResponseEntity<?> hotplaceList() {
        logger.debug("hotplaceList call");
        try {
            List<HotplaceDTO> list = hotplaceService.listHotplace(null);
            if (list != null & !list.isEmpty()) {
                return new ResponseEntity<List<HotplaceDTO>>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    private final String UPLOAD_PATH = "/upload";

    @ApiOperation(value = "핫플레이스 작성", notes = "핫플레이스 작성 API")
    @ApiResponses({@ApiResponse(code = 200, message = "핫플레이스 작성 OK"), @ApiResponse(code = 500, message = "서버오류")})
    // 작성
    @PostMapping
    public ResponseEntity<String> hotplaceWrite(
            HotplaceDTO hotplaceDTO,
            @RequestPart("file") List<MultipartFile> files

    ) throws IOException {

//        logger.debug("hotplaceWrite hotplaceDTO : {}", hotplaceDTO);
        System.out.println(files);
        //	FileUpload 관련 설정.
        logger.debug("MultipartFile.isEmpty : {}", files.isEmpty());

        //핫플레이스 DTO에 값 넣기
//        HotplaceDTO hotplaceDTO = new HotplaceDTO(userId, subject, tripDay, content, "테스트장소", "광주 광산구", "14.333", "14.333");
        if (!files.isEmpty()) {
//          String realPath = servletContext.getRealPath(UPLOAD_PATH);
//		    String realPath = servletContext.getRealPath("/resources/img");

            // 프로젝트 폴더에 저장하기 위해 절대경로를 설정 (Window 의 Tomcat 은 Temp 파일을 이용한다)
            String absolutePath = new File("").getAbsolutePath() + "\\";

            String today = new SimpleDateFormat("yyMMdd").format(new Date());
//          String saveFolder = realPath + File.separator + today;
//            String saveFolder = absolutePath + "hotplaceimages" + File.separator + today;
            String saveFolder = absolutePath + "hotplaceimages"; // today 날짜 폴더 없애기

            logger.debug("저장 폴더 : {}", saveFolder);

            File folder = new File(saveFolder);
            if (!folder.exists()) {
                // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
                folder.mkdirs();
            }
            // 반환을 할 파일 리스트
            List<FileInfoDTO> fileInfos = new ArrayList<FileInfoDTO>();

            for (MultipartFile mfile : files) {
                FileInfoDTO fileInfoDto = new FileInfoDTO();
                String originalFileName = mfile.getOriginalFilename();

                // jpeg, png, gif 파일들만 받아서 처리할 예정
                String contentType = mfile.getContentType();

                if (!originalFileName.isEmpty()) {
                    // UUID 고유 식별자 + 파일 이름 + 확장자
                    String saveFileName = UUID.randomUUID().toString()
                            + originalFileName.substring(originalFileName.lastIndexOf('.'));

                    fileInfoDto.setSaveFolder(today);
                    fileInfoDto.setOriginalFile(originalFileName);
                    fileInfoDto.setSaveFile(saveFileName);
                    logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
                    logger.info("저장 위치 : {}", saveFolder);
                    mfile.transferTo(new File(folder, saveFileName));
                }
                fileInfos.add(fileInfoDto);
            }

            hotplaceDTO.setFileInfos(fileInfos);
        }

        try {
            hotplaceService.writeHotplace(hotplaceDTO);
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
        }
    }

    // Swagger
//    @ApiOperation(value = "핫플레이스 작성", notes = "핫플레이스 작성 API")
//    @ApiResponses({@ApiResponse(code = 200, message = "핫플레이스 작성 OK"), @ApiResponse(code = 500, message = "서버오류")})
//    // 작성
//    @PostMapping
//    public ResponseEntity<String> hotplaceWrite(
////            @RequestBody HotplaceDTO hotplaceDTO
//            @RequestParam("userId") String userId,
//            @RequestParam("subject") String subject,
//            @RequestParam("tripDay") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tripDay,
//            @RequestParam("content") String content,
////            @RequestParam("placeName") String placeName,
////            @RequestParam("placeAddress") String placeAddress,
////            @RequestParam("placeX") String placeX,
////            @RequestParam("placeY") String placeY
//            @RequestParam("file") List<MultipartFile> files
//
//    ) throws IOException {
//
////        logger.debug("hotplaceWrite hotplaceDTO : {}", hotplaceDTO);
//        System.out.println(files);
//        //	FileUpload 관련 설정.
//        logger.debug("MultipartFile.isEmpty : {}", files.isEmpty());
//
//        //핫플레이스 DTO에 값 넣기
//        HotplaceDTO hotplaceDTO = new HotplaceDTO(userId, subject, tripDay, content, "테스트장소", "광주 광산구", "14.333", "14.333");
//        if (!files.isEmpty()) {
////          String realPath = servletContext.getRealPath(UPLOAD_PATH);
////		    String realPath = servletContext.getRealPath("/resources/img");
//
//            // 프로젝트 폴더에 저장하기 위해 절대경로를 설정 (Window 의 Tomcat 은 Temp 파일을 이용한다)
//            String absolutePath = new File("").getAbsolutePath() + "\\";
//
//            String today = new SimpleDateFormat("yyMMdd").format(new Date());
////          String saveFolder = realPath + File.separator + today;
//            String saveFolder = absolutePath + File.separator + today;
//
//            logger.debug("저장 폴더 : {}", saveFolder);
//
//            File folder = new File(saveFolder);
//            if (!folder.exists()) {
//                // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
//                folder.mkdirs();
//            }
//            // 반환을 할 파일 리스트
//            List<FileInfoDTO> fileInfos = new ArrayList<FileInfoDTO>();
//
//            for (MultipartFile mfile : files) {
//                FileInfoDTO fileInfoDto = new FileInfoDTO();
//                String originalFileName = mfile.getOriginalFilename();
//                if (!originalFileName.isEmpty()) {
//                    // UUID 고유 식별자 + 파일 이름 + 확장자
//                    String saveFileName = UUID.randomUUID().toString()
//                            + originalFileName.substring(originalFileName.lastIndexOf('.'));
//
//                    fileInfoDto.setSaveFolder(today);
//                    fileInfoDto.setOriginalFile(originalFileName);
//                    fileInfoDto.setSaveFile(saveFileName);
//                    logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
//                    mfile.transferTo(new File(folder, saveFileName));
//                }
//                fileInfos.add(fileInfoDto);
//            }
//
//            hotplaceDTO.setFileInfos(fileInfos);
//        }
//
//        try {
//            hotplaceService.writeHotplace(hotplaceDTO);
//            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//        }
//    }

    // Swagger
    @ApiOperation(value = "핫플레이스 상세보기", notes = "핫플레이스 상세보기 API")
    @ApiResponses({@ApiResponse(code = 200, message = "핫플레이스 상세보기 OK"), @ApiResponse(code = 500, message = "서버오류")})
    @ApiImplicitParam(name = "placeid", value = "게시물 번호", required = true, dataType = "int", paramType = "path")
    // 상세보기
    @GetMapping("/{placeid}")
    public ResponseEntity<?> hotplaceInfo(@PathVariable("placeid") int placeId) {
        logger.debug("hotplaceInfo placeid : {}", placeId);
        try {
            HotplaceDTO hotplaceDTO = hotplaceService.getHotplace(placeId);
            hotplaceService.updateHit(placeId);
            if (hotplaceDTO != null) {
                return new ResponseEntity<HotplaceDTO>(hotplaceDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    // Swagger
    @ApiOperation(value = "핫플레이스 수정", notes = "핫플레이스 수정 API")
    @ApiResponses({@ApiResponse(code = 200, message = "핫플레이스 수정 OK"), @ApiResponse(code = 500, message = "서버오류")})
//    @ApiImplicitParam(name = "placeid", value = "게시물 번호", required = true, dataType = "int", paramType = "path")
    // 업데이트
    @PutMapping(value = "/{placeid}")
    public ResponseEntity<?> hotplaceModify(@RequestBody HotplaceDTO hotplaceDTO) {
        logger.debug("hotplaceModify hotplaceDTO : {}", hotplaceDTO);
        try {
            hotplaceService.modifyHotplace(hotplaceDTO);
            List<HotplaceDTO> list = hotplaceService.listHotplace(null);
            return new ResponseEntity<List<HotplaceDTO>>(list, HttpStatus.OK);

        } catch (Exception e) {
            return exceptionHandling(e);
        }

    }

    // Swagger
    @ApiOperation(value = "핫플레이스 삭제", notes = "핫플레이스 삭제 API")
    @ApiResponses({@ApiResponse(code = 200, message = "핫플레이스 삭제 OK"), @ApiResponse(code = 500, message = "서버오류")})
    @ApiImplicitParam(name = "placeid", value = "게시물 번호", required = true, dataType = "int", paramType = "path")
    // 삭제
    @DeleteMapping(value = "/{placeid}")
    public ResponseEntity<?> hotplaceDelete(@PathVariable("placeid") int placeId) {
        logger.debug("hotplaceDelete placeid : {}", placeId);
        try {
            hotplaceService.deleteHotplace(placeId);
            List<HotplaceDTO> list = hotplaceService.listHotplace(null);
            return new ResponseEntity<List<HotplaceDTO>>(list, HttpStatus.OK);

        } catch (Exception e) {
            return exceptionHandling(e);
        }

    }

    @GetMapping(value = "image/{imagepath}")
    public ResponseEntity<Resource> getImage(@PathVariable String imagepath) throws IOException {
        // 이미지 파일을 읽어온 후 ResponseEntity로 반환합니다.
        // imageName을 사용하여 이미지 파일을 읽어올 수 있습니다.

        // 예시 코드:
        String imageFilePath = "/hotplaces/" + imagepath;
        File imageFile = new File(imageFilePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(imageFile));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .contentLength(imageFile.length())
                .body(resource);
    }

//    @ApiOperation(value = "feed image 조회 ", notes = "feed Image를 반환합니다. 못찾은경우 기본 image를 반환합니다.")
//    @GetMapping(value = "image/{imagepath}")
//    public ResponseEntity<Resource> userSearch(@PathVariable("imagepath") String imagepath) throws IOException {
//        String imageFilePath = "/hotplaces/" + imagepath;
//        System.out.println("들어옴?" + " " + imageFilePath);
//        File imageFile = new File(imageFilePath);
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(imageFile));
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
//                .contentLength(imageFile.length())
//                .body(resource);
//    }

    private ResponseEntity<?> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

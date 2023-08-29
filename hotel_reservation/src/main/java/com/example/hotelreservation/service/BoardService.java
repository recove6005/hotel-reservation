package com.example.hotelreservation.service;

import com.example.hotelreservation.domains.security.SecurityUser;
import com.example.hotelreservation.domains.vo.BoardVO;
import com.example.hotelreservation.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BoardService {
    String SAVE_PATH = "C:\\Users\\hanib\\OneDrive\\바탕 화면";

    @Autowired
    private BoardMapper boardMapper;

    public boolean post_board(SecurityUser user, BoardVO boardVO) {
        // 게시물 작성
        List<MultipartFile> files = boardVO.getImages();
        if(!check_files(files)) return false; // 파일 체크
        try {
            save_files(files); // 파일 저장
        } catch (IOException e) {
            return false;
        }

        // 게시자 설정
        boardVO.setId(user.getUsername());
    }

    private boolean check_files(List<MultipartFile> files) {
        List<String> fileNames = new ArrayList<>();

        for(MultipartFile file: files) {
            String fileName = file.getOriginalFilename();
            String contentType = file.getContentType();

//            String mimeType = contentType.split("/")[0];
//            if(!mimeType.equals("image")) return null;
            if(contentType.startsWith("image/")) return false;

            fileNames.add(fileName);
        }
        return true;
    }

    // 파일 저장
    private void save_files(List<MultipartFile> files) throws IOException {
        for(MultipartFile file: files) {
            String originFileName = file.getOriginalFilename();
            File saveFile = new File(SAVE_PATH, UUID.randomUUID() + "_"+originFileName);
            file.transferTo(saveFile);
        }



    }
}

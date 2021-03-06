package com.example.project2.Controller;


import com.example.project2.Service.CommentService;
import com.example.project2.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService ;



    @GetMapping
    public ResponseEntity<ArrayList<Comment>> getComment(){
        return ResponseEntity.status(200).body(commentService.getComment());
    }
}

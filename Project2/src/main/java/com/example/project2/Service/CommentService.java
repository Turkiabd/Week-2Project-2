package com.example.project2.Service;

import com.example.project2.model.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {
    ArrayList<Comment> comments = new ArrayList<>();
    public ArrayList<Comment> getComment() {

        return comments;
    }
}

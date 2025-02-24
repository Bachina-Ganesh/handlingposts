package com.ganesh.handlers;

import java.util.List;
import com.ganesh.pojo.Post;

public class DisplayHandlers {
    public static void displayPost(Post post) {
        System.out.println("=====================================");
        System.out.println("Post Id - "+post.getId());
        System.out.println("User Id - "+post.getUserId());
        System.out.println("Title - "+post.getTitle());
        System.out.println("Body - "+post.getBody());
        System.out.println("=====================================");
    }
    public static void displayPosts(List<Post> posts) {
        for(Post post: posts) {
            displayPost(post);
        }
    }
}

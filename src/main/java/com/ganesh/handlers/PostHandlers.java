package com.ganesh.handlers;

import com.ganesh.pojo.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PostHandlers {
    public static String url = null;
    static {
        url = "https://jsonplaceholder.typicode.com/posts";
    }
    public static Post getPost(int postId) {
        RestTemplate restTemplate = InputHandlers.getRestTemplate();
        String url = PostHandlers.url+"/{id}";
        try{
            ResponseEntity<Post> post = restTemplate.getForEntity(url, Post.class, postId);
            return post.getBody();
        }
        catch (HttpClientErrorException e) {
            if(e.getStatusCode().value() == 404) {
                System.out.println("--------------------");
                System.out.println("Post Doesn't Exist");
                System.out.println("---------------------");
            }
            else {
                System.out.println("--------------------------------------");
                System.out.println("Fetching Failed for post id "+postId);
                System.out.println("--------------------------------------");
            }
            return null;
        }
    }
    public static List<Post> getPosts() {
        RestTemplate restTemplate = InputHandlers.getRestTemplate();
        try {
            ResponseEntity<Post[]> posts = restTemplate.getForEntity(PostHandlers.url, Post[].class);
            List<Post> listPosts = new ArrayList<>(Arrays.asList(posts.getBody()));
            return listPosts;
        }
        catch (HttpClientErrorException e) {
            if(e.getStatusCode().value() == 404) {
                System.out.println("--------------------");
                System.out.println("Posts Doesn't Exist");
                System.out.println("---------------------");
            }
            else {
                System.out.println("--------------------------------------");
                System.out.println("Fetching Failed");
                System.out.println("--------------------------------------");
            }
            return null;
        }
    }
    public static Post createPost() {
        RestTemplate restTemplate = InputHandlers.getRestTemplate();
        Post post = new Post();
        Scanner scanner = InputHandlers.scanner;
        System.out.print("Enter the userId - ");
        post.setUserId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter the post title - ");
        post.setTitle(scanner.nextLine());
        System.out.print("Enter the post body - ");
        post.setBody(scanner.nextLine());
        try {
            ResponseEntity<Post> createdPost = restTemplate.postForEntity(PostHandlers.url, post, Post.class);
            return createdPost.getBody();
        }
        catch (HttpClientErrorException e) {
            System.out.println("==============================================");
            System.out.println("Exception occurred while creating a post");
            System.out.println("==============================================");
            return null;
        }
    }
}

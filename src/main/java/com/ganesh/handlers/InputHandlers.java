package com.ganesh.handlers;

import com.ganesh.pojo.Post;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import java.util.Scanner;

public class InputHandlers {
    public static RestTemplate restTemplate = null;
    public static Scanner scanner = null;
    static {
        restTemplate = new RestTemplate();
        scanner = new Scanner(System.in);
    }
    public static Scanner getScanner() {
        return InputHandlers.scanner;
    }
    public static RestTemplate getRestTemplate() {
//        get the rest template object
        return restTemplate;
    }
    public static void displayQueryInputMessage() {
        System.out.println("Welcome to Handling Posts Project");
        System.out.println("------------------------------------");
        System.out.println("1. Get all the Posts");
        System.out.println("2. Get specific Post");
        System.out.println("3. Create new Post");
        System.out.println("4. Delete a Post");
        System.out.println("5. Update the Post");
        System.out.println("6. Exit");
        System.out.println("------------------------------------");
    }
    public static void processUserInput(int queryInput) {
        switch (queryInput) {
            case 1:
                // get all the posts
                List<Post> posts = PostHandlers.getPosts();
                if(!posts.isEmpty()) {
                    DisplayHandlers.displayPosts(posts);
                }
                break;
            case 2:
                // get the specific post
                int postId;
                System.out.print("Enter the postId - ");
                postId = scanner.nextInt();
                Post post = PostHandlers.getPost(postId);
                if(post != null)
                    DisplayHandlers.displayPost(post);
                break;
            case 3:
//                create a new post
                Post createdPost = PostHandlers.createPost();
                if(createdPost != null) {
                    DisplayHandlers.displayPost(createdPost);
                }
                break;
            case 4:
//                delete a post
                System.out.print("Enter the postId - ");
                postId = scanner.nextInt();
                PostHandlers.deletePost(postId);
                break;
            case 5:
//                update a post
                post = PostHandlers.updatePost();
                if(post != null) {
                    DisplayHandlers.displayPost(post);
                }
                else {
                    System.out.println("=============================");
                    System.out.println("Post is not updated");
                    System.out.println("=============================");
                }
                break;
            default:
//                exit
                System.exit(0);
        }
    }
}

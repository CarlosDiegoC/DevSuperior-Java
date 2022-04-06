package application;

import entities.Comment;
import entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        Date moment = sdf.parse("21/06/2018 13:05:44");
        String title = "Traveling to New Zealand";
        String content = "I'm going to visit this wonderful country!";
        int likes = 12;
        Post post1 = new Post(moment, title, content, likes);

        post1.addComment(new Comment("Have a nice trip"));
        post1.addComment(new Comment("Wow that's awesome"));

        System.out.println(post1);


        Post post2 = new Post();
        post2.setMoment(sdf.parse("28/07/2018 23:14:19"));
        post2.setTitle("Good night guys");
        post2.setContent("See you tomorrow");
        post2.setLikes(5);
        post2.getComments().add(new Comment("Good night"));
        post2.getComments().add(new Comment("May the force be with you"));

        System.out.println(post2);
    }


}

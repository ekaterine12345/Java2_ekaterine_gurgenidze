package com.exam.assignment.utils;

import com.exam.assignment.models.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostUtil {
    public PostUtil() {
    }
    public static void insertPost(Post post) throws SQLException {
        String insertSQL = "INSERT INTO POSTS_TB(YEAR, AUTHOR, TITLE, TOPIC, FONT_OF_TEXT) VALUES("
                +post.getYear()+","
                +"'"+post.getAuthor()+"', "
                +"'"+post.getTitle()+"', "
                +"'"+post.getTopic()+"', "
                +"'"+post.getFontOfText()+"');";

        JDBCUtil.getStatement().executeUpdate(insertSQL);
        System.out.println("Insert into "+post.getTopic()+ " has been inserted successfully!");
    }

    public static List<Post> selectPosts() throws SQLException {
        String selectSQL = "SELECT * FROM POSTS_TB";
        List<Post> postList = new ArrayList<>();

        ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectSQL);

        while (resultSet.next()){
            postList.add(new Post(resultSet.getInt("YEAR"),
                    resultSet.getString("AUTHOR"),
                    resultSet.getString("TITLE"),
                    resultSet.getString("TOPIC"),
                    resultSet.getString("FONT_OF_TEXT")));
        }
        //   System.out.println(postList);
        return postList;
    }

}

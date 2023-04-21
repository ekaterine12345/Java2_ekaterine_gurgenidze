package com.exam.assignment;

import com.exam.assignment.models.Post;
import com.exam.assignment.utils.PostUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name ="postServlet", value = "/post-servlet")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        List<Post> postList;

        try {
            postList = PostUtil.selectPosts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PrintWriter writer = resp.getWriter();

        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Table of Posts</title>");
        writer.print("<style>" +
                " table, th, td {"
                +" border: 1px solid black;"
                +" border-collapse: collapse;"
                +"}");
        writer.print("</style>");
        writer.print("</head>");
        writer.print("<body>");

        writer.print("<table style=\"border: 1px solid black\">");

        writer.print("<thead>");
        writer.print("<th>id</th>");
        writer.print("<th>year</th>");
        writer.print("<th>author</th>");
        writer.print("<th>title</th>");
        writer.print("<th>topic</th>");
        writer.print("<th>fontOfText</th>");
        writer.print("</thead>");

        writer.print("<tbody>");

        for (int i=1; i< postList.size(); i++){
            writer.print("<tr>");
            writer.print("<td>"+i+"</td>");
            writer.print("<td>"+postList.get(i).getYear()+"</td>");
            writer.print("<td>"+postList.get(i).getAuthor()+"</td>");
            writer.print("<td>"+postList.get(i).getTitle()+"</td>");
            writer.print("<td>"+postList.get(i).getTopic()+"</td>");
            writer.print("<td>"+postList.get(i).getFontOfText()+"</td>");
            writer.print("</tr>");
        }
        writer.print("</tbody>");

        writer.print("</table>");
        writer.print("</body>");
        writer.print("</html>");

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   super.doPost(req, resp);

        int year = Integer.parseInt(req.getParameter("year"));
        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String topic = req.getParameter("topic");
        String fontOfText = req.getParameter("fontOfText");
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>JSP - hello world</title>");
        writer.print("</head>");

        writer.print("<body>");
        writer.print("<p>"+year+"</p>");
        writer.print("<p>"+author+"</p>");
        writer.print("<p>"+title+"</p>");
        writer.print("<p>"+topic+"</p>");
        writer.print("<p>"+fontOfText+"</p>");

//        writer.print("<p>"+last_name+"</p>");
//        writer.print("<p>"+age+"</p>");
        writer.print("</body>");


        writer.print("</html>");

        try {
            PostUtil.insertPost(new Post(year, author, title, topic, fontOfText));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.close();
    }
}

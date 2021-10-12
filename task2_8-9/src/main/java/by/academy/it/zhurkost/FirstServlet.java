package by.academy.it.zhurkost;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String OUTPUT_FILE_PATH = "\\resources\\task2_8\\";
    private static final String OUTPUT_FILE_NAME = "output.txt";
    private static int pageHitCount = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        pageHitCount++;
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>FirstServlet</title></head>");
        out.println("<body><h1>This is First Servlet</h1>");
        out.println("Page was visited " + pageHitCount + " times");
        out.println("</body></html>");
        String tomcatPath = System.getProperty("catalina.base");
        String resourcesFilePath = tomcatPath + OUTPUT_FILE_PATH;
        File outputFilePath = new File(resourcesFilePath);

        try {
            outputFilePath.mkdirs();
            FileWriter fileWriter = new FileWriter(resourcesFilePath + OUTPUT_FILE_NAME);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Page was visited " + pageHitCount + " times");
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
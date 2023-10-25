package top.org.music_catalog.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.org.music_catalog.entity.Music;
import top.org.music_catalog.rdb.DbClient;
import top.org.music_catalog.rdb.DbManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Collection;

@WebServlet(name = "testServlet", value = "/test-servlet")
public class TestServlet extends HttpServlet {
    private DbClient dbClient;

    public void init() {
        String host = "127.0.0.1";
        String user = "root";
        String password = "root";
        String dbName = "music";
        try {
            dbClient = new DbClient(
                    new DbManager(host, user, password, dbName)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            Collection<Music> musics = dbClient.selectAllMusic();
            for (Music music : musics) {
                response.getWriter().println(music + "<br>");
            }
        } catch (Exception e) {
            response.getWriter().println("error: " + e.getMessage());
        }
    }
}

package top.org.music_catalog.rdb;

import java.sql.Connection;
import top.org.music_catalog.entity.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

public class DbClient {
    private final DbManager dbManager;

    public DbClient(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    // получение всех объектов из базы
    public Collection<Music> selectAllMusic() throws SQLException {

        try (Connection connection = dbManager.getDbConnection()){
            String sql = "SELECT * FROM song;";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            LinkedList<Music> musics = new LinkedList<>();
            while (result.next()) {
                Music music = readMusicFromRow(result);
                musics.add(music);
            }
            return musics;
        }
    }

    private Music readMusicFromRow(ResultSet result) throws SQLException{
        Integer id = result.getInt(1);
        String title = result.getString(2);
        String singer = result.getString(3);
        String authorship = result.getString(4);
        Integer duration = result.getInt(5);
        Integer year = result.getInt(6);
        return new Music(id, title, singer, authorship, duration, year);
    }

}

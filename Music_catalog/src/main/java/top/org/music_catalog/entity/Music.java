package top.org.music_catalog.entity;
// Сущность "Music" для хранения информации о музыке
public class Music {
    // поля
    private Integer id;         // первичный ключ
    private String title;       // название песни
    private String singer;      // исполнитель
    private String authorship;  // автор
    private Integer year;       // год выпуска
    private Integer duration;   // время песни

    public Music() {
    }

    public Music(Integer id, String title, String singer, String authorship, Integer year, Integer duration) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.authorship = authorship;
        this.year = year;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public String getAuthorship() {
        return authorship;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setAuthorship(String authorship) {
        this.authorship = authorship;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", authorship='" + authorship + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                '}';
    }


}

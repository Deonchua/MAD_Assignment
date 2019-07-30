package sg.edu.np.s10179199k.myapplication;

import java.io.Serializable;

public class Note implements Serializable {
    /*private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }*/

    private String id;
    private String title;
    private String desc;
    private String date;


    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getTitle(){return title;}

    public void setTitle (String title){this.title = title;}

    public String getDesc(){return desc;}

    public void setDesc(String description){this.desc = desc;}

    public Note(String id,String title, String desc, String date ) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.date = date;


    }
    public Note() {
    }


}

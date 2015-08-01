package mobile.pk.com.yifymovies.businessobjects;

import java.io.Serializable;

/**
 * Created by hello on 8/1/2015.
 */
public class MovieFilter implements Serializable{
    private String name;
    private String value;
    private String display;

    public MovieFilter(String name, String value, String display)
    {
        this.name = name;
        this.display = display;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDisplay() {
        return display;
    }
}

package view;

public class ListMenu {
    private String[] headers;
    private String caption;

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ListMenu() {
    }

    public ListMenu(String caption, String[] headers) {
        this.headers = headers;
        this.caption = caption;
    }

    public void show() {
        int count = 0;
        System.out.println(caption);
        for (String title :
                headers) {
            System.out.printf("%3s. %-5s\n",++count,title);
        }
        System.out.printf("%3s. %-5s","#","Trở lại\n");
    }
}

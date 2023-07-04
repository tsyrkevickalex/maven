package org.example.oop;

public class Settings {
    double w;
    double h;
    int fontSize;
    String fontType;
    String color;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Settings{");
        sb.append("w=").append(w);
        sb.append(", h=").append(h);
        sb.append(", fontSize=").append(fontSize);
        sb.append(", fontType='").append(fontType).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class WindowSettings {
    private Settings settings;
    private static WindowSettings instance;

    private WindowSettings(){
        settings = new Settings();
        settings.h = 480;
        settings.w = 640;
        settings.color = "White";
        settings.fontSize = 16;
        settings.fontType = "Arial";
        System.out.println("WindowSettings init:" + this);
    }

    public static WindowSettings getSettings(){
        if(instance == null){
            instance = new WindowSettings();
        }
        return instance;
    }

    public void resize(double w, double h){
        settings.w = w;
        settings.h = h;
    }

    public void showSettings(){
        System.out.println(settings);
    }

}


class Client {
    public static void main(String[] args) {
        WindowSettings settings = WindowSettings.getSettings();
        settings.showSettings();
        settings.resize(800, 600);
        settings.showSettings();


        WindowSettings settings2 = WindowSettings.getSettings();
        settings2.resize(500, 600);


        settings.showSettings();
    }
}

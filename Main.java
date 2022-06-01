package com.company;

import java.util.ArrayList;
import java.util.List;

interface Observable {
    void notifyObservers();
    void regObserver(Observer observer);
}
interface Observer{
    void Notification(String news);
}
class Groups implements Observable{
    List<Observer> list = new ArrayList<>();
    String news;
    void setNews(String news){
        this.news = news;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: list){
            observer.Notification(news);
        }
    }

    @Override
    public void regObserver(Observer observer) {
        list.add(observer);
    }
}
class Subscribers implements Observer{
    String name;
    public Subscribers(String name){
        this.name = name;
    }

    @Override
    public void Notification(String news) {
        System.out.println(name + " получил оповещение: " + news);
    }
}
public class Main {
    public static void main(String[] args) {
        Groups Webm = new Groups();
        Groups It = new Groups();
        Groups Rip = new Groups();
        Groups Tatoo = new Groups();

        Subscribers sub1 = new Subscribers("Lofi");
        Subscribers sub2 = new Subscribers("Pop");

        Webm.regObserver(sub1);
        Webm.regObserver(sub2);
        It.regObserver(sub1);
        It.regObserver(sub2);
        Rip.regObserver(sub1);
        Rip.regObserver(sub2);
        Tatoo.regObserver(sub2);

        Webm.setNews("Паблик добавил новые видеозаписи" + "\n");
        It.setNews("IT - специалисты из России стали крайне востребованными в США" + "\n");
        Rip.setNews("MGK и новый альбом - " + "Hotel Diablo" + "\n");
        Tatoo.setNews("Эскины татуировок в новом стиле Blood" + "\n");

    }
}


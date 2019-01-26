package com.questions.java.designpattern.behavorial.observer;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class MyTopicSubscriber implements Observer {

    private String name;
    private Subject topic;

    public MyTopicSubscriber(String nm){
        this.name=nm;
    }
    @Override
    public void getUpdate() {
        String msg = (String) topic.update();
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
            System.out.println(name+":: Consuming message::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }
}

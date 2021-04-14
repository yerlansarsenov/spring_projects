package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml"
        );
        Music music = context.getBean("rock", RockMusic.class);

        System.out.println(music.getSong());

        context.close();
    }
}

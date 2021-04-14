package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml"
        );
        Music music = context.getBean("musicBean", RockMusic.class);

        MusicPlayer musicPlayer = context.getBean("musicPlayerBean", MusicPlayer.class);
        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName().concat(Integer.toString(musicPlayer.getVolume())));
        context.close();
    }
}

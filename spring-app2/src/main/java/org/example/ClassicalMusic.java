package org.example;

import org.springframework.stereotype.Component;

@Component("classic")
public class ClassicalMusic implements Music{
    @Override
    public String getSong() {
        return "Лебединое озеро";
    }
}

package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("other")
public class OtherProperties {

    private final int millis; // the property is some.millis

    public OtherProperties(int millis) {
        this.millis = millis;
    }

    public int getMillis() {
        return millis;
    }

}

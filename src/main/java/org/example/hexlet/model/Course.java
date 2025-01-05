package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
public final class Course {
    private static AtomicLong courseCount = new AtomicLong(0);
    private Long id;
    @ToString.Include
    private String name;
    private String description;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = courseCount.incrementAndGet();
    }
}

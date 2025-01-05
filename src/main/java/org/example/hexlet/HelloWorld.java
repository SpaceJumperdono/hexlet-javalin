package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.Arrays;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var courses = new ArrayList<>(
                Arrays.asList(
                        new Course("Java", "Java backend developer"),
                        new Course("C++", "C++ developer")
                )
        );

        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        // Описываем, что загрузится по адресу /
        app.get("/courses", ctx -> {
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });
        app.get("/courses/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();
            try {
                courses.get(id - 1);
            } catch (IndexOutOfBoundsException e) {
                throw new NotFoundResponse();
            }
            var header = "Курс " + courses.get(id - 1).getName();
            var page = new CoursePage(courses.get(id - 1), header);
            ctx.render("courses/course-page.jte", model("page", page));
        });
        app.start(7070); // Стартуем веб-сервер
    }
}
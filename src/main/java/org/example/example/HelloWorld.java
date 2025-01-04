package org.example.example;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config ->
            config.bundledPlugins.enableDevLogging()
        );
        // Описываем, что загрузится по адресу /
        app.get("/users/{id}/post/{postId}", ctx -> {
            var userId = ctx.pathParam("id");
            var postId = ctx.pathParam("postId");
            ctx.result("User Id: " + userId + " Post Id: " + postId);
        });
        app.start(7070); // Стартуем веб-сервер
    }
}
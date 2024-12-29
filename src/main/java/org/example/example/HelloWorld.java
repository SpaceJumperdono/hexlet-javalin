package org.example.example;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config ->
            config.bundledPlugins.enableDevLogging()
        );
        // Описываем, что загрузится по адресу /
        app.get("/hello", ctx -> {
            var param = ctx.queryParam("name");
            if (param != null)
                ctx.result("Hello," + param + "!");
            else
                ctx.result("Hello, World!");
        });
        app.start(7070); // Стартуем веб-сервер
    }
}
@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<html lang="en">
    <head>
        <title>Хекслет</title>
        <meta charset="utf-8">
    </head>
    <body>
        <h1>${page.getHeader()}</h1>
        <div>
            <h2>${page.getCourse().getName()}</h2>
            <p>${page.getCourse().getDescription()}</p>
        </div>
    </body>
</html>
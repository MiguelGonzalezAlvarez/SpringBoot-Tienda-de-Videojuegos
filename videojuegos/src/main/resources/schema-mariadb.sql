drop table if exists videojuego;
drop table if exists distribuidor;

create table videojuego(
    id int primary key auto_increment,
    nombre varchar(200) not null,
    descripcion varchar(3000),
    imagen_url varchar(500)
);

create table distribuidor(
    id int primary key auto_increment,
    nombre varchar(200) not null,
    sitio_web varchar(500)
);

insert into videojuego
(nombre, descripcion, imagen_url) values
("Dark Souls", "Dark Souls es un videojuego de rol de acción, desarrollado por la empresa From Software para las plataformas PlayStation 3, PlayStation 4, Xbox 360 y Microsoft Windows, distribuido por Namco Bandai Games. Anteriormente conocido como Project Souls, es el segundo videojuego de la serie Souls.", "https://static.wikia.nocookie.net/dark-souls/images/b/b9/Dark_Souls_Portada.jpg/revision/latest?cb=20160801012652&path-prefix=es"),
("Bloodborne", "Bloodborne es un videojuego de rol de acción dirigido por Hidetaka Miyazaki, desarrollado por From Software y JapanStudio distribuido por Sony Computer Entertainment para la plataforma de PlayStation 4.", "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2014/12/428442-bloodborne-ps4-6-claves.png"),
("Sekiro Shadows Die Twice", "Sekiro: Shadows Die Twice es un videojuego de acción y aventura desarrollado por From Software y distribuido por Activision.​ El juego fue lanzado el 22 de marzo de 2019 en las plataformas PlayStation 4, Xbox One y Microsoft Windows.", "https://compass-ssl.xbox.com/assets/d5/54/d554ce9b-cca1-4ad0-88d3-6811cb007ddc.jpg?n=Sekiro-Shadows-Die-Twice_GLP-Page-Hero-1084_1920x1080.jpg"),
("Elden Ring", "Elden Ring será un juego de rol de acción desarrollado por FromSoftware y publicado por Bandai Namco Entertainment. El juego es un esfuerzo de colaboración entre el director del juego Hidetaka Miyazaki y el novelista de fantasía George R. R. Martin.", "https://www.esportmaniacos.com/wp-content/uploads/2021/03/wp4674137-elden-ring-wallpapers-770x433-1-1.png");

insert into distribuidor 
(nombre, sitio_web) values
("FromSoftware","https://www.fromsoftware.jp/ww/"),
("Activision", "https://www.activision.com/es/home");

alter table videojuego
add column distribuidor_id,
add foreign key (distribuidor_id) references distribuidor(id);

update videojuego set distribuidor_id = 1 where id in (1,2,3,4);
update videojuego set distribuidor_id = 2 where id in (5,6,7,8);

alter table videojuego
modify distribuidor_id int not null;
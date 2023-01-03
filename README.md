# ☕🎯 Proyecto Final de ET 35 - Juego App Buzios - JAVA

  Este proyecto fue desarrollado como trabajo final de la carrera Técnico en Computación de la Escuela Técnica N°35 "Ing. Eduardo Latzina" , Ciudad de Buenos Aires.

## Índice

- [Motivación](#-motivacin)
- [Objetivo del Juego](#-objetivo-del-juego)
- [Play](#-play)
- [Documentación Técnica de la Solución](#-documentacin-tcnica-de-la-solucin)
    - [Diagrama de Arquitectura](#diagrama-de-arquitectura)
    - [Diagrama de Componentes](#diagrama-de-componentes)
    - [Modelo de Base de Datos](#-modelo-de-base-de-datos)
    - [Diagrama de Clases](#diagrama-de-clases)
      - [Módulo de Ciudades](#modulo-de-ciudades)
      - [Módulo de Edificios](#modulo-de-edificios)
      - [Módulo de Investigación](#modulo-de-investigacin)
    - [Tecnologías](#-tecnologas)
    - [Remasterización](#-remasterizacin)
    - [Endpoints](#-endpoints)
- [Documentación Funcional de la Solución](#-documentacin-funcional-de-la-solucin)
    - [Casos de Uso](#diagrama-de-casos-de-uso)
    - [Demo](#diagrama-de-casos-de-uso)

## 🚀 Motivación

   Este proyecto fue desarrollado como trabajo final de la carrera Técnico en Computación de la Escuela Técnica N°35 "Ing. Eduardo Latzina" , Ciudad de Buenos Aires.
La temática del mismo está basado en un juego online ya existente llamado Ikariam. La idea del proyecto era emular en un entorno de escritorio las funcionalidades del juego, por lo cual , la mayoria de las pantallas e imagenes son parecidas al juego online. 

## 🚀 Objetivo del Juego 
    
   El juego Buzios consiste en construir ciudades del imperio de China. Para lograrlo, el jugador debe interactuar con la isla en la que esta ubicada su Ciudad, para obtener los recursos naturales, podes así
construir los edificios de su ciudad. Los recursos naturales que no consiga en su isla, los conseguirá a través del Comercio con otros jugadores. A medida que va avanzando tiempo en el juego, debe construir y "evolucionar" cada uno de los edificios para ir desbloqueando "unidades militares" y "acciones en el juego". También tiene posibilidades de ejercer "acciones militares" como saqueos de ciudades, ocupación militar. El objetivo final es lograr crear un imperior lo más fuerte posible y ser el mejor imperio de todo el Mundo.

## 🚀 Play

* Si es la primera vez que va ejecutar el proyecto en su máquina, ejecutar el archivo execute-1-instalacion.sh
* Para inicializar el entorno de datos ejecutar execute-2-configuracion.sh
* Por último, para jugar el juego, debe ejecutar execute-3-execute.sh

Notas: Recuerde que cada vez que ejecute execute-2-configuracion.sh se pisaran los datos de las partidas que ya haya jugado.
Nota2: Cada vez que quiera jugar el juego solo tiene que ejecutar execute-3-execute.sh

## 🚀 Documentación Técnica de la Solución

### Diagrama de Arquitectura

### Diagrama de Componentes

### Modelo de Base de Datos
![Modelo de Base de Datos](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DER_m.png)

### Diagrama de Clases
  A continuación se presentan los diagramas de clases de los módulos principales de la app Buzios
#### Módulo de Ciudades
![Módulo de Ciudades](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DC_ciudad.png)
#### Módulo de Edificios
![Módulo de Edificios](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DC_Edificio.png)
#### Módulo de Investigaciones

Nota: las investigaciones en el juego, desbloquean nuevas acciones a realizar. Por ejemplo construir edificios,
construir nuevas unidades militares, etc

![Módulo de Investigaciones](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DC_Investigacion.png)

### Remasterización

   Cuando se desarrolló este juego, se usó JDK 1.8. Es por esta razón que decidí actualizarlo para que sea un proyecto spring-boot con maven, y un JDK 17.

Tareas Pendiente: Implementar algún ORM como spring-jpa-data, o spring-mongodb y sacar la lógica implementada en la base de datos a través de procedimientos almacenados.

### Tecnologías

* JDK 17
* Mysql
* Librerias: AbsoluteLayout.jar y EdisoncorSX.jar (para interfaz gráfica desktop)
* Spring Boot 2.7.5
* Maven
* Docker (solamente para la BBDD mysql)


## 🚀 Documentación Funcional de la Solución
### 🚀 Demo

   
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/1.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/2.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/3.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/4.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/5.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/6.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/7.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/8.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/9.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/10.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/11.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/12.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/13.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/14.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/15.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/16.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/17.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/18.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/19.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/20.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/21.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/22.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/23.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/24.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/25.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/26.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/27.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/28.png)
![Demo](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/29.png)




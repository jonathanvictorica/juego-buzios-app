# ☕🎯 Proyecto Final de ET 35 - Juego App Buzios - JAVA

  Este proyecto fue desarrollado como trabajo final de la carrera Técnico en Computación de la Escuela Técnica N°35 "Ing. Eduardo Latzina" , Ciudad de Buenos Aires.

## Índice

- [Motivación](#-motivacin)
- [Objetivo del Juego](#-objetivo-del-juego)
- [Play](#-play)
- [Documentación Técnica de la Solución](#-documentacin-tcnica-de-la-solucin)
    - [Diagrama de Componentes](#diagrama-de-componentes)
    - [Modelo de Base de Datos](#-modelo-de-base-de-datos)
    - [Diagrama de Clases](#diagrama-de-clases)
      - [Módulo de Ciudades](#modulo-de-ciudades)
      - [Módulo de Edificios](#modulo-de-edificios)
      - [Módulo de Investigación](#modulo-de-investigacin)
    - [Tecnologías](#-tecnologas)
    - [Remasterización](#-remasterizacin)
    - [Endpoints](#-endpoints)
- [Demo](#diagrama-de-casos-de-uso)

## 🚀 Motivación

   Este proyecto fue desarrollado como trabajo final de la carrera Técnico en Computación de la Escuela Técnica N°35 "Ing. Eduardo Latzina", 
   Ciudad de Buenos Aires. La temática del mismo está basado en un juego online ya existente llamado Ikariam. 
   La idea del proyecto era emular en un entorno de escritorio las funcionalidades del juego, por lo cual, la mayoría de las pantallas e imágenes 
   son parecidas al juego online. 

## 🚀 Objetivo del Juego 
    
   El juego Buzios consiste en construir ciudades del imperio de China. Para lograrlo, el jugador debe interactuar con la isla en la que está ubicada su Ciudad, para obtener los recursos naturales, podes así
construir los edificios de su ciudad. Los recursos naturales que no consiga en su isla, los conseguirá a través del Comercio con otros jugadores. A medida que va avanzando tiempo en el juego, debe construir y "evolucionar" cada uno de los edificios para ir desbloqueando "unidades militares" y "acciones en el juego". También tiene posibilidades de ejercer "acciones militares" como saqueos de ciudades, ocupación militar. El objetivo final es lograr crear un imperior lo más fuerte posible y ser el mejor imperio de todo el Mundo.

## 🚀 Play

* Si es la primera vez que va a ejecutar el proyecto en su máquina, ejecutar el archivo execute-1-instalacion.sh
* Para inicializar el entorno de datos ejecutar execute-2-configuracion.sh
* Por último, para jugar el juego, debe ejecutar execute-3-execute.sh

Notas: Recuerde que cada vez que ejecute execute-2-configuracion.sh se pisaran los datos de las partidas que ya haya jugado.

Nota2: Cada vez que quiera jugar el juego solo tiene que ejecutar execute-3-execute.sh

## 🚀 Documentación Técnica de la Solución

### Diagrama de Componentes
![Diagrama de Componentes](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DiagramaComponentesBuzios.png)

<table>
<thead><tr><th>Componente</th><th>Descripción</th></tr></thead>
<tbody>
  <tr><td>Ciudad</td><td>Administra las ciudades/colonias del Imperio y su evolución a nivel edificios.</td></tr>
  <tr><td>Comercio</td><td>Módulo que permite el intercambio de recursos entre jugadores, jugador-juego para obtener diferentes bienes</td></tr>
  <tr><td>Isla</td><td>Permite interactuar con los productores de recursos de las islas y ciudades que están habitando la misma</td></tr>
  <tr><td>Edificio</td><td>Permite gestionar los edificios de una ciudad</td></tr>
  <tr><td>Investigación</td><td>A través de las investigaciones, el jugador desbloquea acciones en el juego</td></tr>
  <tr><td>Jugador</td><td>Administra información básica y partidas del jugador</td></tr>
  <tr><td>Acciones Militares</td><td>Permite a los jugadores realizar, saqueos, bloqueos de puerto y guerras entre ciudades de jugadores</td></tr>
  <tr><td>Unidades Militares</td><td>Permite construir unidades terrestres y marítimas (con asignación de armas) para fortalecer las bases militares del imperior y efectuaur acciones militares</td></tr>
</tbody>
</table>

### Modelo de Base de Datos
   En este diagrama se presentan las entidades más relevantes de la base de datos.
![Modelo de Base de Datos](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DER_m.png)

### Diagrama de Clases
  A continuación se presentan los diagramas de clases de los módulos principales de la app Buzios

#### Módulo de Ciudades
   El módulo principal del juego son las ciudades. Cuanto más ciudades tenga un jugador, más grande y poderoso
es su imperio. Cuando comienza una partida, su ciudad inicial se convierte en la capital de su imperio. Para fundar
nuevas ciudades (en el juego se denominan colonias), debe ampliar el nivel de su edificio Palacio. Gracias a las nuevas
ciudades que vaya construyendo, en diferentes Islas del juego, podrá conseguir distintos recursos (madera, vino, mármol), que 
le permitirá ejecutar diferentes acciones en el juego. Una ciudad tiene edificios, recursos, unidades militares (terrestres 
   y marítimas). También tiene un Puerto comercial, que a través de sus barcos mercantes intercambia recursos entre sus colonias
y ciudades de otros jugadores.

![Módulo de Ciudades](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DC_ciudad.png)

#### Módulo de Edificios

   Los edificios son una parte fundamental del juego. A medida que van creciendo y subiendo de nivel, permiten al jugador
nuevas acciones. Para subir de nivel, es necesario contar con recursos en la ciudad (madera,mármol, cristal) y oro. 
Conseguir estos recursos no es una tarea sencilla. Puede ser a través del Comercio con otros jugadores, comprando Ofertas
en el Mercado de Intercambio, o saqueando una ciudad. 

![Módulo de Edificios](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DC_Edificio.png)

#### Módulo de Investigaciones

  Las investigaciones en el juego, desbloquean nuevas acciones a realizar. Por ejemplo construir edificios,
construir nuevas unidades militares, etc

![Módulo de Investigaciones](https://github.com/jonathanvictorica/juego-buzios-app/blob/develop/docs/DC_Investigacion.png)

### Remasterización

   Cuando se desarrolló este juego, se usó JDK 1.8. Es por esta razón que decidí actualizarlo para que sea un proyecto spring-boot con maven, y un JDK 17.

Tareas Pendiente: Implementar algún ORM como spring-jpa-data, o spring-mongodb y sacar la lógica implementada en la base de datos a través de procedimientos almacenados.

### Tecnologías

* JDK 17
* Mysql
* Librerías: AbsoluteLayout.jar y EdisoncorSX.jar (para interfaz gráfica desktop)
* Spring Boot 2.7.5
* Maven
* Docker (solamente para la BBDD mysql)


## 🚀 Demo
   
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




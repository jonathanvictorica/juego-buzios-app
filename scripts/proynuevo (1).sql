-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-02-2015 a las 19:16:25
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proynuevo`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_azufre_hora`()
begin
    declare nivel int;
    DECLARE DONE BOOL DEFAULT FALSE;
   DECLARE codigo_ciudad int;
   DECLARE cantidad_hora int;
   declare fecha_actualizacion datetime;
   declare porcentaje_de_produccion int;
   declare plusdeproduccion int;
   declare cantidadagregar int;
   declare codigo_recurso int;
   declare cantidadminutos int;
   
  
   DECLARE ciudades CURSOR FOR SELECT  ciudadproduccion.codigociudad, ciudadproduccion.cantidadhora,concat( ciudadproduccion.fechaactualizacion," ",ciudadproduccion.horaactualizacion) from ciudadproduccion,recurso where ciudadproduccion.codigorecurso= recurso.codigorecurso and recurso.nombre="Azufre"; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
   set codigo_recurso = (select codigorecurso from recurso where nombre="Azufre");
		   OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_ciudad,cantidad_hora,fecha_actualizacion;
		          set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                  SELECT CANTIDADMINUTOS;
                  
                  if(cantidadminutos>=60) then
                 set nivel=(select edificionivel.nivel from ciudadedificionivel,edificionivel,edificio where ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel and 
   edificionivel.codigoedificio = edificio.codigoedificio and ciudadedificionivel.codigociudad=codigo_ciudad and edificio.nombre = "Torre del Alquimista");
                     IF(NIVEL<>NULL) THEN
                 
                 set porcentaje_de_produccion = 2*nivel;
                 ELSE
                 SET porcentaje_de_produccion=0;
                 END IF;
                  
                 
                set plusdeproduccion=(porcentaje_de_produccion*cantidad_hora)/100;
                
                set cantidadagregar=plusdeproduccion+cantidad_hora;
                  
                 update ciudadrecurso set cantidad=cantidad+cantidadagregar
                 where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
              
                 update ciudadproduccion  set fechaactualizacion = curdate(), horaactualizacion = curtime()  where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
               
                  end if;
                 
                 IF done THEN
					  LEAVE read_loop;
					END IF;
				   
				  
				
				 
		   END LOOP;
		   CLOSE ciudades;





end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_cristal_hora`()
begin
    declare nivel int;
    DECLARE DONE BOOL DEFAULT FALSE;
   DECLARE codigo_ciudad int;
   DECLARE cantidad_hora int;
   declare fecha_actualizacion datetime;
   declare porcentaje_de_produccion int;
   declare plusdeproduccion int;
   declare cantidadagregar int;
   declare codigo_recurso int;
   declare cantidadminutos int;
   
  
   DECLARE ciudades CURSOR FOR SELECT  ciudadproduccion.codigociudad, ciudadproduccion.cantidadhora,concat( ciudadproduccion.fechaactualizacion," ",ciudadproduccion.horaactualizacion) from ciudadproduccion,recurso where ciudadproduccion.codigorecurso= recurso.codigorecurso and recurso.nombre="Cristal"; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
   set codigo_recurso = (select codigorecurso from recurso where nombre="Cristal");
		   OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_ciudad,cantidad_hora,fecha_actualizacion;
		          set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                  SELECT CANTIDADMINUTOS;
                  
                  if(cantidadminutos>=60) then
                 set nivel=(select edificionivel.nivel from ciudadedificionivel,edificionivel,edificio where ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel and 
   edificionivel.codigoedificio = edificio.codigoedificio and ciudadedificionivel.codigociudad=codigo_ciudad and edificio.nombre = "Optico");
                     IF(NIVEL<>NULL) THEN
                 
                 set porcentaje_de_produccion = 2*nivel;
                 ELSE
                 SET porcentaje_de_produccion=0;
                 END IF;
                  
                 
                set plusdeproduccion=(porcentaje_de_produccion*cantidad_hora)/100;
                
                set cantidadagregar=plusdeproduccion+cantidad_hora;
                  
                 update ciudadrecurso set cantidad=cantidad+cantidadagregar
                 where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
              
                 update ciudadproduccion  set fechaactualizacion = curdate(), horaactualizacion = curtime()  where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
               
                  end if;
                 
                 IF done THEN
					  LEAVE read_loop;
					END IF;
				   
				  
				
				 
		   END LOOP;
		   CLOSE ciudades;





end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_habitantes_hora`()
begin
  DECLARE DONE BOOL DEFAULT FALSE;
   declare codigo_ciudad int;
   declare habitantes_ciudad int;
   declare fecha_actualizacion datetime;
   declare cantidadminutos int;
   declare crecimiento_habitante int;
   declare codigonivel int;
   declare cantidadmaxima int;
   declare vinoservido int;
   declare diferencia int;
   DECLARE ciudades CURSOR FOR SELECT  codigociudad, cantidadhabitantes, crecimientodehabitante ,fechaactualizacion,nivel from ciudad; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   
   
   
    OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_ciudad,habitantes_ciudad,crecimiento_habitante,fecha_actualizacion,codigonivel;
				   
				     set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                  SELECT CANTIDADMINUTOS;
                  
				  set cantidadmaxima= (select capacidadhabitante from nivelciudad where nivel=codigonivel);
                  if(cantidadminutos>=60) then
                         
                         if(crecimiento_habitante>0) then
						     if(habitantes_ciudad<=cantidadmaxima) then
							       if((cantidadmaxima-habitantes_ciudad)<10) then
								        update ciudad set cantidadhabitantes=cantidadhabitantes+(cantidadmaxima-habitantes_ciudad)
							
										where codigociudad=codigo_ciudad;
								   else
								        update ciudad set cantidadhabitantes=cantidadhabitantes+10
							
										where codigociudad=codigo_ciudad;
								   end if;
							
							 
							 end if;
						 
						 else
						      if(habitantes_ciudad>=0) then
							       if((habitantes_ciudad)<10) then
								        update ciudad set cantidadhabitantes=cantidadhabitantes-(habitantes_ciudad)
							
										where codigociudad=codigo_ciudad;
								   else
								        update ciudad set cantidadhabitantes=cantidadhabitantes-10
							
										where codigociudad=codigo_ciudad;
								   end if;
							
							 
							 end if;
						 
						 end if;
					
					    set vinoservido =(select cantidadvinoservido from ciudadtaberna where codigociudad= codigo_ciudad);
						set diferencia=vinoservido-habitantes_ciudad+100;
						
				        update ciudad set fechaactualizacion = now(),crecimientodehabitante=diferencia
						where codigociudad=codigo_ciudad;
				   
				   
				        
						
					
				   end if;
				   
				   
				   	 IF done THEN
							  LEAVE read_loop;
							END IF;
				  
				
				 
		   END LOOP;
		   CLOSE ciudades;


end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ACTUALIZAR_INVESTIGADORES`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(30), IN `cant_investigadores_actualizados` INT)
begin
     CALL BUSCARCIUDAD(nickjugador, nombreciudad,@CODIGO_CIUDAD);
	 update ciudadacademia set investigadores=CANT_INVESTIGADORES_ACTUALIZADOS where codigociudad = @codigo_ciudad;
	 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_investigadores_hora`()
begin


    DECLARE DONE BOOL DEFAULT FALSE;
   DECLARE codigo_ciudad int;
   DECLARE cantidad_hora int;
   declare fecha_actualizacion datetime;


   declare cantidadminutos int;
     declare codigo_jugador int;
  
   DECLARE ciudades CURSOR FOR SELECT  codigociudad, investigadores,concat( fechaactualizacion," ",horaactualizacion) from ciudadacademia; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
  
		   OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_ciudad,cantidad_hora,fecha_actualizacion;
		          set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                  SELECT CANTIDADMINUTOS;
                  
                  if(cantidadminutos>=60) then
                      set codigo_jugador= (select codigojugador from ciudad where codigociudad=codigo_ciudad);
                      
                 update puntosjugador set puntosinvestigacion=puntosinvestigacion+cantidad_hora
                 where codigojugador=codigo_jugador ;
              
                 update ciudadacademia  set fechaactualizacion = curdate(), horaactualizacion = curtime()  where codigociudad=codigo_ciudad;
               
              
                 
                 END IF;
                  
                 
               
                 
                 IF done THEN
					  LEAVE read_loop;
					END IF;
				   
				  
				
				 
		   END LOOP;
		   CLOSE ciudades;





end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_madera_hora`()
begin
    declare nivel int;
    DECLARE DONE BOOL DEFAULT FALSE;
   DECLARE codigo_ciudad int;
   DECLARE cantidad_hora int;
   declare fecha_actualizacion datetime;
   declare porcentaje_de_produccion int;
   declare plusdeproduccion int;
   declare cantidadagregar int;
   declare codigo_recurso int;
   declare cantidadminutos int;
   
  
   DECLARE ciudades CURSOR FOR SELECT  ciudadproduccion.codigociudad, ciudadproduccion.cantidadhora,concat( ciudadproduccion.fechaactualizacion," ",ciudadproduccion.horaactualizacion) from ciudadproduccion,recurso where ciudadproduccion.codigorecurso= recurso.codigorecurso and recurso.nombre="Madera"; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
   set codigo_recurso = (select codigorecurso from recurso where nombre="Madera");
		   OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_ciudad,cantidad_hora,fecha_actualizacion;
		          set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                  SELECT CANTIDADMINUTOS;
                  
                  if(cantidadminutos>=60) then
                 set nivel=(select edificionivel.nivel from ciudadedificionivel,edificionivel,edificio where ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel and 
   edificionivel.codigoedificio = edificio.codigoedificio and ciudadedificionivel.codigociudad=codigo_ciudad and edificio.nombre = "Carpinteria");
                     IF(NIVEL<>NULL) THEN
                 
                 set porcentaje_de_produccion = 2*nivel;
                 ELSE
                 SET porcentaje_de_produccion=0;
                 END IF;
                  
                 
                set plusdeproduccion=(porcentaje_de_produccion*cantidad_hora)/100;
                
                set cantidadagregar=plusdeproduccion+cantidad_hora;
                  
                 update ciudadrecurso set cantidad=cantidad+cantidadagregar
                 where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
              
                 update ciudadproduccion  set fechaactualizacion = curdate(), horaactualizacion = curtime()  where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
               
                  end if;
                 
                 IF done THEN
					  LEAVE read_loop;
					END IF;
				   
				  
				
				 
		   END LOOP;
		   CLOSE ciudades;





end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_marmol_hora`()
begin
    declare nivel int;
    DECLARE DONE BOOL DEFAULT FALSE;
   DECLARE codigo_ciudad int;
   DECLARE cantidad_hora int;
   declare fecha_actualizacion datetime;
   declare porcentaje_de_produccion int;
   declare plusdeproduccion int;
   declare cantidadagregar int;
   declare codigo_recurso int;
   declare cantidadminutos int;
   
  
   DECLARE ciudades CURSOR FOR SELECT  ciudadproduccion.codigociudad, ciudadproduccion.cantidadhora,concat( ciudadproduccion.fechaactualizacion," ",ciudadproduccion.horaactualizacion) from ciudadproduccion,recurso where ciudadproduccion.codigorecurso= recurso.codigorecurso and recurso.nombre="Marmol"; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
   set codigo_recurso = (select codigorecurso from recurso where nombre="Marmol");
		   OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_ciudad,cantidad_hora,fecha_actualizacion;
		          set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                  SELECT CANTIDADMINUTOS;
                  
                  if(cantidadminutos>=60) then
                 set nivel=(select edificionivel.nivel from ciudadedificionivel,edificionivel,edificio where ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel and 
   edificionivel.codigoedificio = edificio.codigoedificio and ciudadedificionivel.codigociudad=codigo_ciudad and edificio.nombre = "Oficina del Arquitecto");
                     IF(NIVEL<>NULL) THEN
                 
                 set porcentaje_de_produccion = 2*nivel;
                 ELSE
                 SET porcentaje_de_produccion=0;
                 END IF;
                  
                 
                set plusdeproduccion=(porcentaje_de_produccion*cantidad_hora)/100;
                
                set cantidadagregar=plusdeproduccion+cantidad_hora;
                  
                 update ciudadrecurso set cantidad=cantidad+cantidadagregar
                 where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
              
                 update ciudadproduccion  set fechaactualizacion = curdate(), horaactualizacion = curtime()  where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
               
                  end if;
                 
                 IF done THEN
					  LEAVE read_loop;
					END IF;
				   
				  
				
				 
		   END LOOP;
		   CLOSE ciudades;





end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_vino_hora`()
begin
    declare nivel int;
    DECLARE DONE BOOL DEFAULT FALSE;
   DECLARE codigo_ciudad int;
   DECLARE cantidad_hora int;
   declare fecha_actualizacion datetime;
   declare porcentaje_de_produccion int;
   declare plusdeproduccion int;
   declare cantidadagregar int;
   declare codigo_recurso int;
   declare cantidadminutos int;
   
  
   DECLARE ciudades CURSOR FOR SELECT  ciudadproduccion.codigociudad, ciudadproduccion.cantidadhora,concat( ciudadproduccion.fechaactualizacion," ",ciudadproduccion.horaactualizacion) from ciudadproduccion,recurso where ciudadproduccion.codigorecurso= recurso.codigorecurso and recurso.nombre="Vino"; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
   set codigo_recurso = (select codigorecurso from recurso where nombre="Vino");
		   OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_ciudad,cantidad_hora,fecha_actualizacion;
		          set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                  SELECT CANTIDADMINUTOS;
                  
                  if(cantidadminutos>=60) then
                 set nivel=(select edificionivel.nivel from ciudadedificionivel,edificionivel,edificio where ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel and 
   edificionivel.codigoedificio = edificio.codigoedificio and ciudadedificionivel.codigociudad=codigo_ciudad and edificio.nombre = "Prensa de Vino");
                     IF(NIVEL<>NULL) THEN
                 
                 set porcentaje_de_produccion = 2*nivel;
                 ELSE
                 SET porcentaje_de_produccion=0;
                 END IF;
                  
                 
                set plusdeproduccion=(porcentaje_de_produccion*cantidad_hora)/100;
                
                set cantidadagregar=plusdeproduccion+cantidad_hora;
                  
                 update ciudadrecurso set cantidad=cantidad+cantidadagregar
                 where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
              
                 update ciudadproduccion  set fechaactualizacion = curdate(), horaactualizacion = curtime()  where codigociudad=codigo_ciudad and  codigorecurso=codigo_recurso;
               
                  end if;
                 
                 IF done THEN
					  LEAVE read_loop;
					END IF;
				   
				  
				
				 
		   END LOOP;
		   CLOSE ciudades;





end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `acutalizar_madera_hora`()
begin
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AGREGAR_BARCO`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `barcoacomprar` VARCHAR(30))
BEGIN
     
     CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
	 CALL BUSCAR_BARCO_MERCANTE(barcoacomprar,@CODIGOBARCOMERCANTE);
	
	 set @codigobarcomercante = 1;
	 if((select count(*) from ciudadbarco where codigobarco=@codigobarcomercante and codigociudad=@codigo_ciudad) =0) then
	    insert into ciudadbarco values(@codigo_ciudad,@codigobarcomercante,1,1);
	 else
	 update ciudadbarco set cantidaddisponible = cantidaddisponible + 1,cantidadtotal = cantidadtotal+1
	 where codigociudad = @codigo_ciudad and codigobarco = @CODIGOBARCOMERCANTE;
	 end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `almacenar_ataque`(IN `codigo_ciudad_atacante` INT, IN `codigo_ciudad_atacado` INT, IN `mision_militar` VARCHAR(30), IN `tiempotarda` INT, OUT `codigo_ataque` INT)
begin
     declare codigo_mision_militar int;
	  DECLARE FECHA_LLEGADA DATETIME;
	  declare horallegada time;
	  declare fechallegada date;
	  declare fechasalida datetime;
	  
	  set fechasalida = (select now());
	  
	  set FECHA_LLEGADA =(select fechasalida + interval tiempotarda  minute);
	  set horallegada=time(FECHA_LLEGADA);
	  SET fechallegada = DATE(FECHA_LLEGADA);
	  
	 set codigo_mision_militar=(select codigomision from misionmilitar where nombremision=mision_militar);
	 
	 insert into ataque(codigociudadjugatacante,
	 codigociudadjugatacado, fechasalida,
	 horasalida,fechallegada,horallegada,
	 codigomision,codjugadorganador,vigencia) values
	 (codigo_ciudad_atacante,codigo_ciudad_atacado,
	 date(fechasalida),time(fechasalida),fechallegada,
	 horallegada,codigo_mision_militar,null,true);
	 
	 set codigo_ataque=(select max(codigoataque) from ataque);

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_BARCOS_DE_MOVIMIENTO`(IN `CODIGOMOVIMIENTO` INT, IN `NOMBREBARCO` VARCHAR(30), IN `CANTIDAD` INT)
BEGIN
    CALL BUSCAR_BARCO_MERCANTE(NOMBREBARCO,@CODIGOBARCOMERCANTE);
    INSERT INTO BARCOMOVIMIENTO VALUES(codigomovimiento,@codigobarcomercante,cantidad);

	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_CARGA_EN_BARCOS`(IN `CODIGOMOVIMIENTO` INT, IN `NOMBRERECURSO` VARCHAR(25), IN `CANTIDADALMACENAR` INT)
BEGIN
      CALL BUSCARRECURSO(NOMBRERECURSO,@codigo_recurso);
	  INSERT INTO CARGA VALUES(CODIGOMOVIMIENTO,@codigo_recurso,CANTIDADALMACENAR);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_GUERRA`(IN `jugadoratacador` VARCHAR(30), IN `bandoatacador` INT, IN `jugadoratacado` VARCHAR(30), IN `bandoatacado` INT)
BEGIN
    declare codigojugadoratacador int;
	declare codigojugadoratacado int;
	declare codigo_guerra int;
	
	

	 set codigojugadoratacador =(select codigojugador from jugador where nick=jugadoratacador);
	 

	 set codigojugadoratacado=(select codigojugador from jugador where nick=jugadoratacado);
	
	 insert into guerra(guerraactiva,fechainicio,horainicio) values(true,curdate(),curtime());
	 
	 set codigo_guerra = (select max(codigoguerra) from guerra);
	 
	 insert into GuerraParticipante(codigoguerra,codigojugador,puntaje,bando,activo) values( codigo_guerra,codigojugadoratacador,0,bandoatacador,true);
	 
	 insert into GuerraParticipante(codigoguerra,codigojugador,puntaje,bando,activo) values( codigo_guerra,codigojugadoratacado,0,bandoatacado,true);
	 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_GUERRERO`(IN codigoguera int, in nickjugador varchar(30), in bando int)
begin
    declare codigojugador int;
	set codigojugador = ( select codigojugador from jugador where nick=nickjugador);
	insert into GuerraParticipante(codigoguerra,codigojugador,puntaje,bando,activo) values( codigoguerra,codigojugador,0,bando,true);
	 
	
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_INVESTIGACION_DE_JUGADOR`(IN `nombrejugador` VARCHAR(30), IN `codigoinvestigacion` INT)
BEGIN
      declare codigo_jugador int;
      set codigo_jugador = (select codigojugador from jUGADOR where nick=nombrejugador);
	 insert into INVESTIGACIONJUGADOR values(codigoinvestigacion,codigo_jugador);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_JUGADOR`(IN `nickjugador` VARCHAR(30), IN `clave` VARCHAR(10))
BEGIN
declare codigo_jugador int;
    insert into jugador(nick,clave,oro,fechaingreso,horaingreso) values(nickjugador,clave,1000,curdate(),curtime());
    set codigo_jugador =(select max(codigojugador) from jugador);
    insert into puntosjugador values(codigo_jugador,0,0,0,0,0);
	
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_MOVIMIENTO`(IN `nickjugadorsalida` VARCHAR(30), IN `ciudadsalida` VARCHAR(25), IN `nickjugadorllegada` VARCHAR(30), IN `ciudadllegada` VARCHAR(25), IN `tiempotarda` INT, OUT `fechallegada` DATE, OUT `horallegada` TIME, OUT `codigomovimiento` INT)
BEGIN
  DECLARE codigociudadsalida int;
	  declare codigociudadllegada int;
	  DECLARE FECHA_LLEGADA DATETIME;
	  
	  declare fechasalida datetime;
	  
	  set fechasalida = (select now());
	  
	  set FECHA_LLEGADA =(select fechasalida + interval tiempotarda minute);
	  set horallegada=time(FECHA_LLEGADA);
	  SET fechallegada = DATE(FECHA_LLEGADA);
      CALL BUSCARCIUDAD(nickjugadorsalida, ciudadsalida,@CODIGO_CIUDAD);
	  set codigociudadsalida= @CODIGO_CIUDAD;
	  
	  CALL BUSCARCIUDAD(nickjugadorllegada, ciudadllegada,@CODIGO_CIUDAD);
	  set codigociudadllegada= @CODIGO_CIUDAD;
	  
	  insert into MOVIMIENTOBARCOACTUAL(codigociudadsalida,codigociudaddestino,fechasalida,horasalida,fechallegada,horallegada) values(codigociudadsalida,codigociudadllegada,date(fechasalida),time(fechasalida),fechallegada,horallegada);
	  

	  set codigomovimiento = (select max(codigomov) from MOVIMIENTOBARCOACTUAL);
     
         
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_MOVIMIENTO_MILITAR`(IN `nicksalida` VARCHAR(30), IN `ciudadsalida` VARCHAR(25), IN `nickllegada` VARCHAR(30), IN `ciudadllegada` VARCHAR(25), IN `tiempotarda` INT, IN `codigoataque` INT, OUT `codigomov` INT)
BEGIN
  CALL   ALMACENAR_MOVIMIENTO(nicksalida,ciudadsalida,nickllegada,ciudadllegada,tiempotarda,@fechallegada,@horallegada,@codigomovimiento);
	  

	  
      insert into MOVIMIENTOMILITAR values (@codigomovimiento,codigoataque);
	  
	  set codigomov = @codigomovimiento;
	  
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `almacenar_recursos_ciudad_destino`(in codigomov_mov int,in codigociudaddestino_mov int)
begin
    DECLARE DONE BOOL DEFAULT FALSE;
	declare codigo_recurso int;
	declare cantidad_recurso int;
 DECLARE recursosmovimiento CURSOR FOR SELECT codigorecurso,cantidad from  carga where codigomov = codigomov_mov; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   
    OPEN recursosmovimiento;
		   read_loop: LOOP
		   
		           FETCH recursosmovimiento INTO codigo_recurso,cantidad_recurso;
                    update ciudadrecurso set cantidad=cantidad+cantidad_recurso where codigociudad=codigociudaddestino_mov and codigorecurso=codigo_recurso;
				   
				   
					IF done THEN
							  LEAVE read_loop;
							END IF;
				  
				
				 
		   END LOOP;
	CLOSE recursosmovimiento;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_RECURSOS_EN_CIUDAD`(IN `NICKJUGADOR` VARCHAR(30), IN `NOMBRECIUDAD` VARCHAR(30), IN `NOMBRERECURSO` VARCHAR(25), IN `CANTIDADRECURSO` INT)
begin
   declare codigorecursoalmacenar int;
   CALL BUSCARCIUDAD(NICKJUGADOR,NOMBRECIUDAD,@codigo_ciudad);
	
	set codigorecursoalmacenar = (select codigorecurso from recurso where nombre=NOMBRERECURSO);
	
	
	update CIUDADRECURSO set cantidad=cantidad + CANTIDADRECURSO
	where codigociudad = @codigo_ciudad and codigorecurso=codigorecursoalmacenar;


end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_RECURSO_MERCADO`(IN `NICKJUGADOR` VARCHAR(30), IN `RECURSO` VARCHAR(25), IN `CANTIDADDEPOSITAR` INT)
BEGIN

    declare codigojug int;
    set codigojug=(select codigojugador from jugador where nick=NICKJUGADOR);
	CALL BUSCARRECURSO(RECURSO,@codigo_recurso);
	
	
	
	IF((SELECT COUNT(*) FROM DEPOSITOMERCADO WHERE CODIGOJUGADOR = CODIGOJUG AND CODIGORECURSO = @codigo_recurso)=1) THEN
	    UPDATE DEPOSITOMERCADO SET CANTIDAD =CANTIDAD + CANTIDADDEPOSITAR
		WHERE CODIGOJUGADOR = codigojug AND CODIGORECURSO = @codigo_recurso;
	ELSE
	    INSERT INTO DEPOSITOMERCADO VALUES(codigojug,@codigo_recurso,CANTIDADDEPOSITAR);
	END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_UNIDADES_MILITARES_COMBATE_CON_ARMA`(IN `codigo_ataque` INT, IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreunidad` VARCHAR(30), IN `NOMBREARMA` VARCHAR(30), IN `cantidad` INT)
BEGIN
     declare codigociudadenviada int;
	 declare atacante boolean;

	 CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
	
	 set codigociudadenviada=@codigo_ciudad;
	 
	 call buscar_unidad_militar(nombreunidad,@codigo_unidad);
	
	 
	 if((select codigociudadjugatacante  from ataque where codigoataque = codigo_ataque)=codigociudadenviada) then
	     set atacante = true;
     else
	       set atacante = false;
     end if;
	 
	   call buscar_arma(NOMBREARMA,@codigo_arma);
	 
	 insert into ATAQUEUNIDADDECOMBATE values(codigo_ataque,@codigo_unidad,@codigo_arma,atacante,cantidad);
	 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ALMACENAR_UNIDADES_MILITARES_COMBATE_SIN_ARMA`(IN `codigo_ataque` INT, IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreunidad` VARCHAR(30), IN `cantidad` INT)
BEGIN
     declare codigociudadenviada int;
	 declare atacante boolean;
	
	 CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
	
	 set codigociudadenviada=@codigo_ciudad;
	 
	 call buscar_unidad_militar(nombreunidad,@codigo_unidad);
	
	 
	 if((select codigociudadjugatacante  from ataque where codigoataque = codigo_ataque limit 1)=codigociudadenviada) then
	     set atacante = true;
     else
	       set atacante = false;
     end if;
	 
	 insert into ATAQUEUNIDADDECOMBATE values(codigo_ataque,@codigo_unidad,27,atacante,cantidad);
	 
	 
	 

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ASIGNAR_NUEVOS_TRABAJADORES`(IN `nombrejugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `recurso` VARCHAR(25), IN `cantidadtrabajadores` INT)
BEGIN
     declare codigorec int;
    
     CALL BUSCARCIUDAD(nombrejugador,nombreciudad,@codigo_ciudad);
	  set codigorec = (select codigorecurso from recurso where nombre=recurso);
      if((select count(*) from ciudadproduccion where codigociudad=@codigo_ciudad and codigorecurso = codigorec)=0) then
         insert into ciudadproduccion                                                   values(@codigo_ciudad,codigorec,cantidadtrabajadores,curdate(),curtime());
      else

	  update ciudadproduccion set cantidadhora=cantidadtrabajadores
	  where codigociudad=@codigo_ciudad and codigorecurso=codigorec;
      end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `aumentar_capacidad_disponible_barcos`(in codigomov_mov int,in codigociudadsalida_mov int)
begin
    DECLARE DONE BOOL DEFAULT FALSE;
	declare codigo_barco int;
	declare cantidad_barco int;
 DECLARE movimientobarco CURSOR FOR SELECT codigobarco,cantidad from  barcomovimiento where codigomov = codigomov_mov; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   
    OPEN movimientobarco;
		   read_loop: LOOP
		   
		           FETCH movimientobarco into codigo_barco,cantidad_barco;
				   
				   update ciudadbarco set cantidaddisponible=cantidaddisponible+cantidad_barco where codigociudad=codigociudadsalida_mov and codigobarco=codigo_barco;
				   
				   
					IF done THEN
							  LEAVE read_loop;
							END IF;
				  
				
				 
		   END LOOP;
	CLOSE movimientobarco;
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AUMENTAR_HABITANTES_DISPONIBLES`(IN `nombreciudad` VARCHAR(25), IN `nombrejugador` VARCHAR(30), IN `cantidad` INT)
BEGIN
     CALL BUSCARCIUDAD(nombrejugador,nombreciudad,@codigo_ciudad);
	 update ciudad set cantidadhabitantesdisponibles=cantidadhabitantesdisponibles+cantidad
	 where codigociudad = @codigo_ciudad;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AUMENTAR_UNIDADES_SIN_ARMA`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreunidad` VARCHAR(30), IN `cantidad` INT)
BEGIN
declare codigo_unidad int;
 declare codigounidadarma int;
     CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
     select @codigo_ciudad;
	 set codigo_unidad=(select codigounidad from unidadmilitar where nombre=nombreunidad);
     select codigo_unidad;
	 set codigounidadarma = ( select codigounidadciudad from CIUDADEJERCITO where codigociudad=@codigo_ciudad and codigounidad = codigo_unidad);
     select codigounidadarma;
     update CIUDADEJERCITO set cantidadsinarma=cantidadsinarma+cantidad, capacidaddisponiblesinarma=capacidaddisponiblesinarma+cantidad
	 where codigounidadciudad=codigounidadarma;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCARCIUDAD`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), OUT `CODIGO_CIUDAD` INT)
BEGIN
     SET CODIGO_CIUDAD = (SELECT ciudad.codigociudad FROM ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad)));

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAREDIFICIONIVEL`(IN NOMBREEDIFICO VARCHAR(30),IN NIVEL INT,OUT CODIGOEDIFICIO INT)
BEGIN
    SET CODIGOEDIFICIO = (SELECT edificionivel.codigoedifnivel FROM edificionivel INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio WHERE (((edificio.nombre)=NOMBREEDIFICO) AND ((edificionivel.nivel)=NIVEL)));

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCARRECURSO`(IN `nombrerecurso` VARCHAR(25), OUT `codigo_recurso` INT)
BEGIN
   SET codigo_recurso = (SELECT codigorecurso FROM RECURSO WHERE nombre=nombrerecurso);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCARUNIDADMILITAR`(IN `NOMBREUNIDAD` VARCHAR(30), OUT `CODIGOUNIDADMILITAR` INT)
BEGIN
  SET CODIGOUNIDADMILITAR=(SELECT CODIGOUNIDAD FROM UNIDADMILITAR WHERE NOMBRE=NOMBREUNIDAD);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_arma`(IN `arma` VARCHAR(30), OUT `CODIGO_ARMA` INT)
begin

   set CODIGO_ARMA = (select codigoarma from arma where nombrearma=arma);
 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_BARCO_MERCANTE`(IN `NOMBREBARCO` VARCHAR(30), OUT `CODIGOBARCOMERCANTE` INT)
BEGIN
     SET CODIGOBARCOMERCANTE = (SELECT CODIGOBARCO FROM BARCOS WHERE nombre=NOMBREBARCO);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_CANTIDAD_CIUDADES`(IN NICKJUGADOR VARCHAR(30),OUT CANTIDADCIUDADES INT)
BEGIN
      set @cantidadciudades = (SELECT COUNT(ciudad.codigociudad) FROM jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador WHERE (((jugador.nick)=NICKJUGADOR)));


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_CANTIDAD_HABITANTES`(IN NICKJUGADOR VARCHAR(30), NOMBRECIUDAD VARCHAR(30), OUT CANTIDADHABITANTES INT)
begin
   set @CANTIDADHABITANTES= (SELECT ciudad.cantidadhabitantes FROM jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador WHERE (((ciudad.nombre)=NOMBRECIUDAD) AND ((jugador.nick)=NICKJUGADOR)));
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_CANTIDAD_INVESTIGADORES_CIUDAD`(IN NICKJUGADOR VARCHAR(30), NOMBRECIUDAD VARCHAR(30), out CANTIDADINVESTIGADORES INT)
BEGIN
 set @CANTIDADINVESTIGADORES =(SELECT ciudadacademia.investigadores FROM jugador INNER JOIN (ciudad INNER JOIN ciudadacademia ON ciudad.codigociudad = ciudadacademia.codigociudad) ON jugador.codigojugador = ciudad.codigojugador WHERE (((ciudad.nombre)=NOMBRECIUDAD) AND ((jugador.nick)=NICKJUGADOR)));

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_CAPACIDAD_MAXIMA_HABITANTE`(IN NICKJUGADOR VARCHAR(30), NOMBRECIUDAD VARCHAR(30), OUT CAPACIDADMAXIMA INT)
begin
  set @capacidadmaxima = (SELECT nivelciudad.capacidadhabitante FROM (jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador) INNER JOIN nivelciudad ON ciudad.nivel = nivelciudad.nivel WHERE (((ciudad.nombre)=NOMBRECIUDAD) AND ((jugador.nick)=NICKJUGADOR)));

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_ISLA`(IN COORDENADA_X INT,COORDENADA_Y INT, OUT CODIGOISLA INT)
BEGIN
 SET @CODIGOISLA = (SELECT CODIGOISLA FROM ISLA WHERE COODENADAX=COORDENADA_X AND COORDENADAY=COORDENADA_Y);
 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_LISTA_CONSTRUCCION`(IN `NOMBREEDIFICIO` VARCHAR(30), IN `NIVEL` INT, OUT `MADERA` INT, OUT `MARMOL` INT, OUT `CRISTAL` INT, OUT `AZUFRE` INT)
begin
CALL BUSCAREDIFICIONIVEL(nombreedificio,NIVEL,@CODIGOEDIFICIO);

set madera=(select cantidadrecurso from edificiorecurso,recurso where edificiorecurso.codigorecurso= recurso.codigorecurso and
recurso.nombre="Madera" and edificiorecurso.codigoedifnivel=@CODIGOEDIFICIO);

set cristal=(select cantidadrecurso from edificiorecurso,recurso where edificiorecurso.codigorecurso= recurso.codigorecurso and
recurso.nombre="Cristal" and edificiorecurso.codigoedifnivel=@CODIGOEDIFICIO);
set azufre=(select cantidadrecurso from edificiorecurso,recurso where edificiorecurso.codigorecurso= recurso.codigorecurso and
recurso.nombre="Azufre" and edificiorecurso.codigoedifnivel=@CODIGOEDIFICIO);
set marmol=(select cantidadrecurso from edificiorecurso,recurso where edificiorecurso.codigorecurso= recurso.codigorecurso and
recurso.nombre="Marmol" and edificiorecurso.codigoedifnivel=@CODIGOEDIFICIO);

if madera =null then
set madera=0;
end if;
if marmol =null then
set marmol=0;
end if;
if  cristal=null then
set cristal=0;
end if;
if azufre =null then
set azufre=0;
end if;



end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_PUNTOS_INVESTIGACION_JUGADOR`(IN `nombrejugador` VARCHAR(30), OUT `puntosinvestigacion` INT)
BEGIN
    set puntosinvestigacion     =(SELECT puntosjugador.puntosinvestigacion FROM puntosjugador INNER JOIN jugador ON puntosjugador.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=nombrejugador)));

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BUSCAR_RECURSO_UNIDAD_MILITAR`(IN `NOMBREUNIDAD` VARCHAR(30), OUT `MADERA` INT, OUT `MARMOL` INT, OUT `VINO` INT, OUT `CRISTAL` INT, OUT `AZUFRE` INT)
begin
   set madera = 0;
   set marmol = 0;
   set vino =0;
   set azufre =0;
   set cristal = 0;
   
   set madera = (SELECT unidadmilitarconstruccion.cantidad FROM recurso INNER JOIN (unidadmilitarconstruccion INNER JOIN unidadmilitar ON unidadmilitarconstruccion.codigounidad = unidadmilitar.codigounidad) ON recurso.codigorecurso = unidadmilitarconstruccion.codigorecurso WHERE (((recurso.nombre)="Madera") AND ((unidadmilitar.nombre)=NOMBREUNIDAD)));
   set marmol = (SELECT unidadmilitarconstruccion.cantidad FROM recurso INNER JOIN (unidadmilitarconstruccion INNER JOIN unidadmilitar ON unidadmilitarconstruccion.codigounidad = unidadmilitar.codigounidad) ON recurso.codigorecurso = unidadmilitarconstruccion.codigorecurso WHERE (((recurso.nombre)="Marmol") AND ((unidadmilitar.nombre)=NOMBREUNIDAD)));
   set vino =(SELECT unidadmilitarconstruccion.cantidad FROM recurso INNER JOIN (unidadmilitarconstruccion INNER JOIN unidadmilitar ON unidadmilitarconstruccion.codigounidad = unidadmilitar.codigounidad) ON recurso.codigorecurso = unidadmilitarconstruccion.codigorecurso WHERE (((recurso.nombre)="Vino") AND ((unidadmilitar.nombre)=NOMBREUNIDAD)));
   set azufre =(SELECT unidadmilitarconstruccion.cantidad FROM recurso INNER JOIN (unidadmilitarconstruccion INNER JOIN unidadmilitar ON unidadmilitarconstruccion.codigounidad = unidadmilitar.codigounidad) ON recurso.codigorecurso = unidadmilitarconstruccion.codigorecurso WHERE (((recurso.nombre)="Azufre") AND ((unidadmilitar.nombre)=NOMBREUNIDAD)));
   set cristal = (SELECT unidadmilitarconstruccion.cantidad FROM recurso INNER JOIN (unidadmilitarconstruccion INNER JOIN unidadmilitar ON unidadmilitarconstruccion.codigounidad = unidadmilitar.codigounidad) ON recurso.codigorecurso = unidadmilitarconstruccion.codigorecurso WHERE (((recurso.nombre)="Cristal") AND ((unidadmilitar.nombre)=NOMBREUNIDAD)));
   
   if(madera=NULL) then
      set madera=0;
   end if;
   if(marmol=NULL) then
      set marmol=0;
   end if;
   
   if(vino=NULL) then
      set vino=0;
   end if;
   
   if(azufre=NULL) then
      set azufre=0;
   end if;
   
   if(cristal=NULL) then
      set cristal=0;
   end if;
   
   
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_ultima_investigacion`(in nombrejugador varchar(30), in temainvestigacion varchar(25), out numeroinvestigacion int)
begin
     declare codigo_jugador int;
	 declare codigo_tema_investigacion int;
	 set codigo_tema_investigacion=(select codigotema from temainvestigacion where tema=temainvestigacion);
	 
	 set codigo_jugador=(select codigojugador from jugador where nick=nombrejugador);
    if((select count(*) from investigacionjugador,investigacion where investigacion.codigotema = codigo_tema_investigacion and investigacionjugador.codigojugador=codigo_jugador and investigacionjugador.codigoinvestigacion=investigacion.codigoinvestigacion )=0) then
        set numeroinvestigacion=0;
	 
	 else
	     set numeroinvestigacion=(select investigacion.numeroorden from investigacionjugador,investigacion where investigacion.codigotema = codigo_tema_investigacion and investigacionjugador.codigojugador=codigo_jugador and investigacionjugador.codigoinvestigacion=investigacion.codigoinvestigacion order by investigacion.numeroorden desc limit 1);
	 
	 end if;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_unidad_militar`(IN `unidad` VARCHAR(30), OUT `codigo_unidad` INT)
begin
   set codigo_unidad = (select codigounidad from unidadmilitar where nombre=unidad);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `calculargastoinvestigadores`(in codigo_ciudad int, out dinero_investigadores int)
begin
	       set dinero_investigadores=((select investigadores from ciudadacademia where codigociudad=codigo_ciudad )*3);
		   
	  end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `calculargastotropas`(in codigo_ciudad int, out dinero_tropas int)
begin
	       DECLARE DONE BOOL DEFAULT FALSE;
		   declare codigo_unidad_ejercito int;
		 declare cantidadtotalsinarma int default 0;
		   declare fecha_actualizacion datetime;
		   declare cantidadtotal int default 0;
		   
			DECLARE ciudadesjugador CURSOR FOR SELECT  codigounidadciudad  from ciudadejercito where codigociudad=codigo_ciudad;
		   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
		   set dinero_tropas=0;
		  
	   OPEN ciudadesjugador;
		   read_loop: LOOP
		   
		           FETCH ciudadesjugador INTO  codigo_unidad_ejercito;
				   
				 set cantidadtotal=( select sum(unidadmilitar.costo* ciudadejercitoarma.cantidad) from ciudadejercitoarma,ciudadejercito,unidadmilitar where ciudadejercitoarma.codigounidadciudad = ciudadejercito.codigounidadciudad and ciudadejercitoarma.codigounidadciudad=codigo_unidad_ejercito and ciudadejercito.codigounidad = unidadmilitar.codigounidad);
				   
				   
				   if(cantidadtotal>0) then
				   
				   set dinero_tropas=dinero_tropas+cantidadtotal;
				  
				   end if;
				
				   set cantidadtotalsinarma=( select sum(unidadmilitar.costo* ciudadejercito.cantidadsinarma) from ciudadejercito,unidadmilitar where  ciudadejercito.codigounidadciudad=codigo_unidad_ejercito and ciudadejercito.codigounidad = unidadmilitar.codigounidad);
				 if(cantidadtotalsinarma>0) then
				   
				   set dinero_tropas=dinero_tropas+cantidadtotalsinarma;
				  
				   end if;
				   
				   
				   
					IF done THEN
										  LEAVE read_loop;
										END IF;
							  
							
							 
					   END LOOP;
				CLOSE ciudadesjugador;
	  end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_gastos`(in codigo_jugador int,out gastostotales int)
begin
 DECLARE DONE BOOL DEFAULT FALSE;
   declare codigo_ciudad int;
 
   declare fecha_actualizacion datetime;
   declare cantidadminutos int;
   
    DECLARE ciudadesjugador CURSOR FOR SELECT  codigociudad  from ciudad where codigojugador=codigo_jugador and activa=true;
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  set gastostotales = 0;
    OPEN ciudadesjugador;
		   read_loop: LOOP
		   
		           FETCH ciudadesjugador INTO  codigo_ciudad;
						  call calculargastotropas(codigo_ciudad, @dinero_tropas);
						 call calculargastoinvestigadores(codigo_ciudad,@dinero_investigadores);
						 
						 if(@dinero_tropas>0) then
			              set gastostotales = gastostotales + @dinero_tropas;
                         end if;
						 
						 if(@dinero_investigadores>0) then
						  set gastostotales = gastostotales + @dinero_investigadores;
						 end if;
						 
    	                   IF done THEN
							  LEAVE read_loop;
							END IF;
				  
				
				 
		   END LOOP;
	CLOSE ciudadesjugador;


					 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CALCULAR_TIEMPO_LLEGADA`(IN `nickjugadorsalida` VARCHAR(30), IN `ciudadsalida` VARCHAR(25), IN `nickjugadorllegada` VARCHAR(30), IN `ciudadllegada` VARCHAR(25), OUT `tiempotarda` INT)
begin


end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CALCULAR_UNIDAD_MILITAR_SIN_ARMA`(IN `NICKJUGADOR` VARCHAR(30), IN `NOMBRECIUDAD` VARCHAR(25), IN `NOMBREUNIDAD` VARCHAR(30), OUT `CANTIDADSINARMA` INT)
begin
   set CANTIDADSINARMA = (SELECT ciudadejercito.cantidadsinarma FROM (ciudadejercito INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadejercito.codigociudad = ciudad.codigociudad) INNER JOIN unidadmilitar ON ciudadejercito.codigounidad = unidadmilitar.codigounidad WHERE (((ciudad.nombre)=NOMBRECIUDAD) AND ((jugador.nick)=NICKJUGADOR) AND ((unidadmilitar.nombre)=NOMBREUNIDAD)));

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CAMBIAR_NICK`(IN `nickjugador` VARCHAR(30), IN `nickacambiar` VARCHAR(30))
BEGIN
      update jugador set nick=nickacambiar
	  where nick=nickjugador;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CAMBIAR_NOMBRE`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreciudadnuevo` VARCHAR(25))
BEGIN
    CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
	
	
	
	update ciudad set nombre=nombreciudadnuevo
	where codigociudad= @codigo_ciudad;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CARGAR_UNIDADES_MILITARES`(in codigomovimiento int, in unidadmilitarenviar varchar(30), in armaenviar varchar(30),in cantidad int)
begin 
       if(armaenviar="") then
	      call buscar_unidad_militar(unidadmilitarenviar,@codigounidad);
		  insert into cargamilitar values(codigomovimiento,@codigounidad,null,cantidad);
	   else
	      call buscar_unidad_militar(unidadmilitarenviar,@codigounidad);
		  call buscar_arma(armaenviar,@codigoarma);
		  insert into cargamilitar values(codigomovimiento,@codigounidad,@codigoarma,cantidad);
	   end if;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CIUDADEDIFICIONIVEL_CONSTRUIREDIFICIO`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `nombreedificio` VARCHAR(30), IN `lugarciudad` INT)
BEGIN
   CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
   CALL BUSCAREDIFICIONIVEL(nombreedificio,1,@CODIGOEDIFICIO);
   INSERT INTO CIUDADEDIFICIONIVEL VALUES(@codigo_ciudad,@CODIGOEDIFICIO,lugarciudad);
   
    if(nombreedificio="Deposito") then
    update ciudad set capacidadrecurso= capacidadrecurso+8000
    where codigociudad=@codigo_ciudad;
    end if;
    if(nombreedificio="Almacen") then
     update ciudad set capacidadrecurso= capacidadrecurso+32000
    where codigociudad=@codigo_ciudad;
    
    
    end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `COMUNICAR_A_MIEMBROS_NUEVO_INGRESO`(IN codigoguera int, in nickjugador varchar(30), in bando int)
begin

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSTRUIR_CIUDAD_EN_ISLA`(IN `nickjugador` VARCHAR(30), IN `cx` INT, IN `cy` INT, IN `lugarenisla` INT)
begin
   declare codigo_jugador_nuevo int;
   declare codigo_isla int;
  
   declare codigo_estado int;
   declare nombre_ciudad varchar(25);
   declare cantidadciudades int;
   declare capitalciudad boolean;
   declare codigo_ciudad int;
   set capitalciudad=false;
   
    set codigo_jugador_nuevo =(select codigojugador from jugador where nick=nickjugador limit 1);
    
  
  if((select count(*) from ciudad where                                        codigojugador=codigo_jugador_nuevo)=0) then
     set cantidadciudades=1;
      set capitalciudad=true;
     else
     set cantidadciudades=((select count(*) from ciudad where codigojugador=codigo_jugador_nuevo)+1);
    
     end if;
   
   
   set codigo_estado= (select codigoestado from estadociudad where estado="Normal" limit 1);
   
   
   set codigo_isla=(select codigoisla from isla where coordenadax=cx and coordenaday=cy limit 1);
  
   set nombre_ciudad = CONCAT("Ciudad ",cantidadciudades);
   insert into ciudad(codigojugador,nombre,codigoisla,nivel,                  capacidadrecurso,cantidadhabitantes,crecimientodehabitante,gradodesatisfacciontotal,codigoestado,numeroposicionisla,activa,capital,cantidadhabitantesdisponibles) values(codigo_jugador_nuevo,nombre_ciudad,codigo_isla,1,2000,100,100,100,codigo_estado,lugarenisla,true,capitalciudad,100);
   
   call BUSCAREDIFICIONIVEL("Intendencia",1,@CODIGOEDIFICIO);
   set codigo_ciudad =(select max(codigociudad) from ciudad);
   
   insert into ciudadedificionivel values(codigo_ciudad,@CODIGOEDIFICIO,4);
   
   insert into ciudadacademia values(codigo_ciudad,0,curdate(),curtime());
   insert into ciudadrecurso values
   (codigo_ciudad,6,4000,curdate(),curtime()),
   (codigo_ciudad,9,4000,curdate(),curtime()),
   (codigo_ciudad,12,4000,curdate(),curtime()),
   (codigo_ciudad,14,4000,curdate(),curtime()),
   (codigo_ciudad,15,4000,curdate(),curtime());
   
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `construir_unidades_militares`(IN `jugadornombre` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `nombreunidad` VARCHAR(30), IN `cantidadsoldados` INT)
begin
declare codigo_ciudad int;
declare codigo_unidad_militar int;
SET codigo_ciudad = (SELECT ciudad.codigociudad FROM ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=jugadornombre) AND ((ciudad.nombre)=nombreciudad)) limit 1);
set codigo_unidad_militar = (select codigounidad from unidadmilitar where unidadmilitar.nombre like nombreunidad );
if((select count(*) from ciudadejercito where codigociudad=codigo_ciudad and codigounidad=codigo_unidad_militar)=0)then
insert into ciudadejercito(codigociudad,codigounidad,cantidadtotal,cantidadsinarma,capacidaddisponiblesinarma) values(codigo_ciudad,codigo_unidad_militar,cantidadsoldados,cantidadsoldados,cantidadsoldados);
else
update  ciudadejercito set cantidadtotal=cantidadtotal+cantidadsoldados, cantidadsinarma =cantidadsinarma+cantidadsoldados,capacidaddisponiblesinarma=capacidaddisponiblesinarma+cantidadsoldados
where codigociudad=codigo_ciudad and codigounidad=codigo_unidad_militar;

end if;


end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSTRUIR_Y_ASIGNAR_ARMAS`(IN `jugadornombre` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `nombreunidad` VARCHAR(30), IN `nombre_arma` VARCHAR(30), IN `cantidadasignar` INT)
begin
    declare codigo_ciudad int;
	declare codigo_unidad_militar int;
	declare codigo_ciudad_ejercito int;
	declare codigo_arma int;
		
	SET codigo_ciudad = (SELECT ciudad.codigociudad FROM ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=jugadornombre) AND ((ciudad.nombre)=nombreciudad)) limit 1);
	set codigo_unidad_militar = (select codigounidad from unidadmilitar where nombre = nombreunidad );
	set codigo_arma= (select codigoarma from arma where nombrearma=nombre_arma);
	set codigo_ciudad_ejercito=(select codigounidadciudad from ciudadejercito where codigociudad=codigo_ciudad and codigounidad=codigo_unidad_militar);

	if((select count(*) from ciudadejercitoarma where codigounidadciudad=codigo_ciudad_ejercito and codigoarma=codigo_arma)=0)then
		insert into ciudadejercitoarma values(codigo_ciudad_ejercito,codigo_arma,cantidadasignar,cantidadasignar);
		
	else
	   update ciudadejercitoarma set cantidad=cantidad+cantidadasignar, cantidaddisponibleciudad=cantidaddisponibleciudad+cantidadasignar
	   where codigounidadciudad=codigo_ciudad_ejercito and codigoarma=codigo_arma;
	end if;
   update ciudadejercito set cantidadsinarma = cantidadsinarma-cantidadasignar , capacidaddisponiblesinarma = capacidaddisponiblesinarma-cantidadasignar   where codigociudad=codigo_ciudad and codigounidad=codigo_unidad_militar;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CREAR_JUGADOR`(in nicknuevo varchar(30), in clavenueva varchar(10),out mensaje varchar(120))
BEGIN
     CALL VERIFICAR_JUGADOR(nicknuevo,@codigo_jugador);
	 if(@codigo_jugador=0) then
	    call insertar_jugador(nicknuevo,clavenueva);
		set mensaje=("Bienvenido al juego.");
	 else
	   set mensaje=("Lo sentimos, pero el nick que ha ingresado esta siendo usado por otro jugador, vuelva a ingrear un nick distinto. ");
	 end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `crear_oferta`(in recurso_oferta varchar(25), in cantidad int, orobuscado boolean, recurso_buscado varchar(25), in jugador_buscado varchar(30))
begin
    declare codigo_recurso int;
	declare codigo_recurso_buscado int;
    declare codigo_jugador int ;
    declare codigo_oferta int;
	 
	set codigo_recurso =(select codigorecurso from recurso where nombre=recurso_oferta);
	set codigo_recurso_buscado = NULL;
	
	if(orobuscado=false) then
	
	   set codigo_recurso_buscado=(select codigorecurso from recurso where nombre=recurso_buscado);
	
	end if;
	insert into oferta(codigorecurso,cantidadofrecida,orobuscado,codigorecursobuscado,jugador) values (codigo_recurso,cantidad, orobuscado, codigo_recurso_buscado,false);
	
	
	
	if(jugador_buscado<>"") then
	    

	   set codigo_jugador = (select codigojugador from jugador where nick=jugador_buscado);
	   set codigo_oferta=(select codigooferta from oferta order by codigooferta desc limit 1);
	   update oferta set jugador=true where codigooferta=codigo_oferta;
	   insert into ofertajugador values(codigo_oferta,codigo_jugador);
	   
	end if;
	
	
	

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTAR_BARCOS_DISPONIBLES_EN_CIUDAD`(in nickjugador varchar(30), in nombreciudad varchar(25), in nombrebarco varchar(30), in cantidad int)
begin
     CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigociudad);
	 CALL BUSCAR_BARCO_MERCANTE(NOMBREBARCO,@CODIGOBARCOMERCANTE);
	 
	 update ciudadbarco set cantidaddisponible = cantidaddisponible - cantidad
	 where codigociudad = @codigociudad and codigobarco = @CODIGOBARCOMERCANTE;
	 
	
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTAR_CAPACIDAD_ISLA`(IN `coordenada_x` INT, IN `coordenada_y` INT)
BEGIN
   
     UPDATE ISLA set capacidaddisponible=capacidaddisponible-1 where coordenadax=coordenada_x and coordenaday=coordenada_y;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTAR_HABITANTES`(IN `NICKJUGADOR` VARCHAR(30), IN `NOMBRECIUDAD` VARCHAR(30), IN `CANTIDADDESCONTAR` INT)
BEGIN
     CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
	 
	 UPDATE CIUDAD SET cantidadhabitantes= cantidadhabitantes - CANTIDADDESCONTAR,cantidadhabitantesdisponibles=cantidadhabitantesdisponibles-cantidaddescontar
	 where codigociudad = @codigo_ciudad;
     
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `descontar_habitantes_disponibles`(IN `nombreciudad` VARCHAR(25), IN `nombrejugador` VARCHAR(30), IN `cantidad` INT)
BEGIN
     CALL BUSCARCIUDAD(nombrejugador,nombreciudad,@codigo_ciudad);
	 update ciudad set cantidadhabitantesdisponibles=cantidadhabitantesdisponibles-cantidad
	 where codigociudad = @codigo_ciudad;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `descontar_oro_hora`()
begin
    DECLARE DONE BOOL DEFAULT FALSE;
   declare codigo_jugador int;
 
   declare fecha_actualizacion datetime;
   declare cantidadminutos int;
   
    DECLARE ciudades CURSOR FOR SELECT  codigojugador, fechaactualizacionoro  from jugador;
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   
    OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_jugador,fecha_actualizacion;
				   
				     set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                     SELECT CANTIDADMINUTOS;
				  
				  if(cantidadminutos>=60) then
					 call recaudarimpuesto(codigo_jugador, @dineroimpuesto);
					 call calcular_gastos(codigo_jugador,@gastostotales);
					
					 IF(@gastostotales>0) then
					 
					 update jugador set fechaactualizacionoro=now(), oro=oro-@gastostotales
					 where codigojugador=codigo_jugador;
					 end if;
					 
					 
					 IF(@dineroimpuesto>0) then
					 
					 update jugador set fechaactualizacionoro=now(), oro=oro+@dineroimpuesto
					 where codigojugador=codigo_jugador;
					 end if;
	               end if;
				  
   
    	                   IF done THEN
							  LEAVE read_loop;
							END IF;
				  
				
				 
		   END LOOP;
	CLOSE ciudades;


end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTAR_PUNTOS_INVESTIGACION`(IN `nombrejugador` VARCHAR(30), IN `puntos_investigacion` INT)
BEGIN
	 declare codigo_jugador int;
	
	 set codigo_jugador = (select codigojugador from jUGADOR where nick=nombrejugador);
	 update puntosjugador set puntosinvestigacion=puntosinvestigacion-puntos_investigacion
	 where codigojugador = codigo_jugador;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `descontar_recursos`(IN `nick_jugador` VARCHAR(30), IN `nombre_ciudad` VARCHAR(25), IN `nombrerecur` VARCHAR(25), IN `madera` INT)
BEGIN
        declare codigo_recurso tinyint;
        declare codigo_ciudad int;
      SET codigo_ciudad = (SELECT ciudad.codigociudad FROM ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=nick_jugador) AND ((ciudad.nombre)=nombre_ciudad)));
	  set codigo_recurso = (select codigorecurso from recurso where nombre=nombrerecur);

	  
   
	  UPDATE ciudadrecurso SET cantidad=cantidad-madera WHERE codigociudad=codigo_ciudad and codigorecurso = codigo_recurso;
	  
	   
		  
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTAR_RECURSOS_OFERTA`(IN `CODIGOOFERTAS` INT, IN `cantidaddescuento` INT)
begin
    update OFERTA SET cantidadofrecida=cantidadofrecida-cantidaddescuento
	where codigooferta=CODIGOOFERTAS;
	
	IF((SELECT COUNT(*) FROM OFERTA WHERE CODIGOOFERTA=CODIGOOFERTAS AND cantidadofrecida=0)=1) then
    delete from ofertajugador where codigooferta=codigoofertas;
	  DELETE FROM OFERTA WHERE CODIGOOFERTA=CODIGOOFERTAS;
      
	end if;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTAR_RECURSO_MERCADO`(IN `NICKJUGADOR` VARCHAR(30), IN `RECURSO` VARCHAR(25), IN `CANTIDADDEPOSITAR` INT)
BEGIN
      declare codigojug int;
	  declare codigorec int;
	  set codigojug = (select codigojugador from jugador where nick=NICKJUGADOR);
	  set codigorec = (select codigorecurso from recurso where nombre=RECURSO);
	  update depositomercado set cantidad = cantidad-cantidaddepositar
	  where codigojugador=codigojug and codigorecurso = codigorec;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTAR_UNIDADES_MILITARES_DISPONIBLES_CON_ARMA`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreunidad` VARCHAR(30), IN `NOMBREARMA` VARCHAR(30), IN `cantidad` INT)
BEGIN
       declare codigounidadmilitar int;
	  
	  set codigounidadmilitar = (SELECT ciudadejercito.codigounidadciudad FROM (ciudadejercito INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadejercito.codigociudad = ciudad.codigociudad) INNER JOIN unidadmilitar ON ciudadejercito.codigounidad = unidadmilitar.codigounidad WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad) AND ((unidadmilitar.nombre)=nombreunidad)));
      
	  call buscar_arma(NOMBREARMA,@codigo_arma);
	  
      select @codigo_arma;
      select codigounidadmilitar;
	  update CIUDADEJERCITOARMA set cantidaddisponibleciudad=cantidaddisponibleciudad- cantidad
	  where codigounidadciudad=codigounidadmilitar and codigoarma=@codigo_arma;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTAR_UNIDADES_MILITARES_DISPONIBLES_SIN_ARMA`(in nombreciudad varchar(25), in nickjugador varchar(30), in nombreunidad varchar(30), in cantidad int)
BEGIN
      declare codigounidadmilitar int;
	  
	  set codigounidadmilitar = (SELECT ciudadejercito.codigounidadciudad FROM (ciudadejercito INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadejercito.codigociudad = ciudad.codigociudad) INNER JOIN unidadmilitar ON ciudadejercito.codigounidad = unidadmilitar.codigounidad WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad) AND ((unidadmilitar.nombre)=nombreunidad)));
      
	  update CIUDADEJERCITO set capacidaddisponiblesinarma=capacidaddisponiblesinarma- cantidad
	  where codigounidadciudad=codigounidadmilitar;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `descontar_vino_hora`()
begin
  DECLARE DONE BOOL DEFAULT FALSE;
   declare codigo_ciudad int;
 
   declare fecha_actualizacion datetime;
   declare cantidadminutos int;
   declare cantidadvinociudad int;
   declare vinoservido int;
   declare diferencia int;
   declare codigo_recurso int;
   DECLARE ciudades CURSOR FOR SELECT  codigociudad, cantidadvinoservido, concat(fechaactualizacion," ", horaactualizacion) from ciudadtaberna; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   
    OPEN ciudades;
		   read_loop: LOOP
		   
		           FETCH ciudades INTO  codigo_ciudad,vinoservido,fecha_actualizacion;
				   
				     set cantidadminutos=(select timestampdiff(minute,fecha_actualizacion,now()));
                     SELECT CANTIDADMINUTOS;
				  
				  if(cantidadminutos>=60) then
				         set codigo_recurso=(select codigorecurso from recurso where nombre="Vino");
				         set cantidadvinociudad= (select cantidad from ciudadrecurso where codigociudad=codigo_ciudad and codigorecurso=codigo_recurso);
						 
						 if(cantidadvinociudad>=vinoservido) then
						     update ciudadrecurso set cantidad=cantidad-cantidadvinociudad
							 where codigociudad=codigo_ciudad and codigorecurso= codigo_recurso;
							 
							 update ciudadtaberna set fechaactualizacion = date(now()), horaactualizacion=time(now())
							 where codigociudad=codigo_ciudad;
							 
						 
						 else
						     update ciudadtaberna set fechaactualizacion = date(now()), horaactualizacion=time(now()),cantidadvinoservido=0
							 where codigociudad=codigo_ciudad;
						 
						     	set diferencia=(select cantidadhabitantes from ciudad where codigociudad=codigo_ciudad)+100;
						
							update ciudad set crecimientodehabitante=diferencia
							where codigociudad=codigo_ciudad;
				   
						 end if;
				  
				  
				  
				  end if;
				  
   
    	                   IF done THEN
							  LEAVE read_loop;
							END IF;
				  
				
				 
		   END LOOP;
	CLOSE ciudades;

 
 
 end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `desembarcar_barcos_recursos`()
begin
    DECLARE DONE BOOL DEFAULT FALSE;
   DECLARE codigomov_mov        int(11);
 DECLARE codigociudadsalida_mov  int(11);
DECLARE codigociudaddestino_mov  int(11);
DECLARE fechasalida_mov          date;
 DECLARE horasalida_mov           time;
DECLARE fechallegada_mov        date;
DECLARE horallegada_mov          time;

declare fechallegada datetime;
declare fechasalida datetime;
declare cantidadminutos int;
   DECLARE movimiento CURSOR FOR SELECT * from  movimientobarcoactual; 
   DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   
    OPEN movimiento;
		   read_loop: LOOP
		   
		           FETCH movimiento INTO  codigomov_mov,codigociudadsalida_mov,codigociudaddestino_mov,fechasalida_mov,horasalida_mov,fechallegada_mov,horallegada_mov;
				    set fechallegada=(select concat(fechallegada_mov," ",horallegada_mov));
                         set cantidadminutos=(select timestampdiff(minute,fechallegada,now()));
                  SELECT cantidadminutos;
                  
				 
                  if(cantidadminutos>=0) then
                              
                       call almacenar_recursos_ciudad_destino(codigomov_mov,codigociudaddestino_mov);
					   call aumentar_capacidad_disponible_barcos(codigomov_mov,codigociudadsalida_mov);
					   delete from barcomovimiento where codigomov=codigomov_mov;
					   delete from carga where codigomov=codigomov_mov;
					   delete from movimientobarcoactual  where codigomov=codigomov_mov;



                 end if;




					IF done THEN
							  LEAVE read_loop;
							END IF;
				  
				
				 
		   END LOOP;
	CLOSE movimiento;




end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DESTRUIR_EDIFICIO`(IN `NOMBRECIUDAD` VARCHAR(25), IN `NOMBREJUGADOR` VARCHAR(30), IN `NOMBREEDIFICIO` VARCHAR(30))
BEGIN
     declare codigo_edificio int;
     declare niveledificio int;
     
     set niveledificio =  (SELECT edificionivel.nivel FROM ((ciudadedificionivel INNER JOIN (jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador) ON ciudadedificionivel.codigociudad = ciudad.codigociudad) INNER JOIN edificionivel ON ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel) INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio WHERE (((jugador.nick)=NOMBREJUGADOR) AND ((ciudad.nombre)=NOMBRECIUDAD) AND ((edificio.nombre)=NOMBREEDIFICIO)));
	 set codigo_edificio = (SELECT ciudadedificionivel.codigoedificio FROM ((ciudadedificionivel INNER JOIN (jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador) ON ciudadedificionivel.codigociudad = ciudad.codigociudad) INNER JOIN edificionivel ON ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel) INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio WHERE (((jugador.nick)=NOMBREJUGADOR) AND ((ciudad.nombre)=NOMBRECIUDAD) AND ((edificio.nombre)=NOMBREEDIFICIO)));
    call BUSCARCIUDAD(NOMBREJUGADOR, NOMBRECIUDAD,@CODIGO_CIUDAD);
 
	 delete from ciudadedificionivel where codigociudad = @CODIGO_CIUDAD and codigoedificio = codigo_edificio;
     
      if(nombreedificio="Deposito") then
    update ciudad set capacidadrecurso= capacidadrecurso-(8000*niveledificio)
    where codigociudad=@codigo_ciudad;
    end if;
    if(nombreedificio="Almacen") then
     update ciudad set capacidadrecurso= capacidadrecurso-(32000*niveledificio)
    where codigociudad=@codigo_ciudad;
    
    
    end if;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ELEVAR_EDIFICIO`(IN `NOMBRECIUDAD` VARCHAR(25), IN `NOMBREJUGADOR` VARCHAR(30), IN `NOMBREEDIFICIO` VARCHAR(30), IN `NIVELVIEJO` INT)
begin  
	DECLARE codigoedificionivel int;
	DECLARE codigoedificioviejo int;
	DECLARE codigoedificionuevo int;
	
	CALL BUSCAREDIFICIONIVEL(nombreedificio,NIVELVIEJO,@CODIGOEDIFICIO);
	set codigoedificioviejo = @CODIGOEDIFICIO;
	
	set NIVELVIEJO = NIVELVIEJO+1;
	CALL BUSCAREDIFICIONIVEL(nombreedificio,NIVELVIEJO,@CODIGOEDIFICIO);
	set codigoedificionuevo = @CODIGOEDIFICIO;
	
	CALL BUSCARCIUDAD(NOMBREJUGADOR,NOMBRECIUDAD,@codigo_ciudad);
	
	
	UPDATE CIUDADEDIFICIONIVEL SET codigoedificio=codigoedificionuevo
	where codigociudad=@codigo_ciudad and codigoedificio=codigoedificioviejo;
    
    if(nombreedificio="Intendencia") then
  update ciudad set nivel=nivel+1 where codigociudad=@codigo_ciudad;
    end if;
    if(nombreedificio="Deposito") then
    update ciudad set capacidadrecurso= capacidadrecurso+8000
    where codigociudad=@codigo_ciudad;
    end if;
    if(nombreedificio="Almacen") then
     update ciudad set capacidadrecurso= capacidadrecurso+32000
    where codigociudad=@codigo_ciudad;
    
    
    end if;
   end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_ARMAS_UNIDAD_MILITAR`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `nombreunidad` VARCHAR(30), IN `nombre_arma` VARCHAR(30), IN `cantidadp` INT)
BEGIN
   declare codigounidadarma int;
 
   declare codigo_unidad int;
   declare codigo_arma int;

  	 CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
     
	 set codigo_unidad = (select codigounidad from unidadmilitar where nombre=nombreunidad limit 1);
     select codigo_unidad;
   
	 set codigo_arma =(select codigoarma from arma where nombrearma=nombre_arma limit 1);
     select codigo_arma;
	  set codigounidadarma = ( select codigounidadciudad from CIUDADEJERCITO where codigociudad=@codigo_ciudad and codigounidad = codigo_unidad);

    select codigounidadarma;
	 update CIUDADEJERCITOARMA set cantidaddisponibleciudad=cantidaddisponibleciudad-cantidadp , cantidad=cantidad-cantidadp
	 where codigounidadciudad=codigounidadarma and codigoarma=codigo_arma;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ELIMINAR_CIUDAD_JUGADOR`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25))
begin
    declare codigo_jugador int;
    set codigo_jugador= (select codigojugador from jugador where nick=nickjugador);
    update  ciudad  set activa = false where codigojugador=codigo_jugador and nombre=nombreciudad;
    end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ELIMINAR_UNIDADES`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreunidad` VARCHAR(30), IN `cantidad` INT)
begin
     declare codigounidadarma int;
     CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigo_ciudad);
	 call buscarunidadmilitar(nombreunidad,@codigounidad);
	 set codigounidadarma = ( select codigounidadciudad from CIUDADEJERCITO where codigociudad=@codigo_ciudad and codigounidad = @codigounidad);
     update CIUDADEJERCITO set cantidadsinarma=cantidadsinarma-cantidad, capacidaddisponiblesinarma=capacidaddisponiblesinarma-cantidad
	 where codigounidadciudad=codigounidadarma;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EMPEZAR_MISION`(in codigomisionjuego int , in nickjugador varchar(30))
BEGIN
  declare codigojug int;
  declare tiempotarda int;
  declare fechaempieza datetime;
  declare fechafin datetime;
  
  
  set tiempotarda = (SELECT misionjuego.tiempo FROM misionjuego WHERE (((misionjuego.codigomision)=codigomisionjuego)));

  set codigojug = (select codigojugador from jugador where nick=nickjugador);
  set fechaempieza = (select now());
	  
    set fechafin =(select fechaempieza + interval tiempotarda minute);
	  

  insert into MISIONJUEGOJUGADOR(codigomision,codigojugador , fechainicio, horainicio, fechafin , horafin, activa) values(codigomisionjuego,codigojug,date(fechaempieza),time(fechaempieza),date(fechafin), time(fechafin), true);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ENVIARMENSAJE`(IN `NICKJUGADOR` VARCHAR(30), IN `NICKRECEPTOR` VARCHAR(30), IN `MENSAJE` VARCHAR(255), IN `TITULO` VARCHAR(30))
BEGIN
    declare codigojugemite int;
	declare codigojugrec int;
	
    
	 set codigojugemite = (select codigojugador from jugador where nick=NICKJUGADOR);
	 
	
	 set codigojugrec = (select codigojugador from jugador where nick=NICKRECEPTOR);
	 INSERT INTO MENSAJEPRIVADO(codigojugadorremi,codigojugadorrec,mensaje,titulo,fecha,hora,leido) VALUES(CODIGOJUGEMITE,CODIGOJUGREC,MENSAJE, titulo,curdate(),curtime(),FALSE);
	  
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INICIALIZAR_ACADEMIA_DE_CIUDAD`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), OUT `cantidadinvestigadores` INT)
BEGIN
   set cantidadinvestigadores = (SELECT ciudadacademia.investigadores FROM ciudadacademia INNER JOIN (jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador) ON ciudadacademia.codigociudad = ciudad.codigociudad WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad)));

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INICIALIZAR_DATOS_CIUDAD`(IN nombrejugador varchar(30),in nombreciudad varchar(25),out ciudadnombre varchar(25),out nivel int, out capacidadmilitarterrestre int, out capacidadhabitantes int, out impuestociudadano int , out capacidadmilitarnaval int, out cantidadmaderamaxima int, out cantidadrecursomaxima int, out imagenciudadisla int, out codigoimagenciudad int, out capacidadrecurso int, out cantidadhabitante int, out crecimientodehabitante int, out gradodesatisfacciontotal int, out numeroposicionisla int, out capital boolean)
BEGIN
         DECLARE DONE BOOL DEFAULT FALSE;
		
		 declare nombre_ciudad varchar(30);
		 declare nivel_ciudad int;
		 declare capacidad_habitantes int;
		 declare capacidad_militar_terrestre int;
		 declare  impuesto_ciudadano int;
		 declare  capacidad_militar_naval int;
		 declare  cantidad_madera_maxima  int;
		 declare  cantidad_recurso_maxima int;
		 declare  direccion_imagen_ciudad varchar(100);
		 declare  capacidad_recurso int;
		 declare  cantidad_habitante int;
		 declare  crecimiento_de_habitante int;
		 declare  grado_satisfaccion_total int;
		 declare  numero_posicion_isla int;
		 declare  ciudad_capital boolean;
		 
	     DECLARE inicializardatosciudad CURSOR FOR SELECT ciudad.nombre, nivelciudad.nivel, nivelciudad.capacidadhabitante, nivelciudad.capacidadmilitarterrestre, nivelciudad.impuestociudadano, nivelciudad.capacidadmilitarnaval, nivelciudad.cantidadmaderamaxima, nivelciudad.cantidadrecursomaxima, imagenes.direccion, ciudad.capacidadrecurso, ciudad.cantidadhabitantes, ciudad.crecimientodehabitante, ciudad.gradodesatisfacciontotal, ciudad.numeroposicionisla, ciudad.capital FROM (nivelciudad INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON nivelciudad.nivel = ciudad.nivel) INNER JOIN imagenes ON (nivelciudad.codigoimagenciudad = imagenes.codigoimagen) AND (nivelciudad.codigoimagen = imagenes.codigoimagen) WHERE (((ciudad.activa)=True) AND ((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nombrejugador));
         DECLARE CONTINUE HANDLER FOR NOT FOUND 
		 SET done = TRUE;
		   
		 OPEN inicializardatosciudad;
		 read_loop: LOOP
		   
		 FETCH inicializardatosciudad INTO nombre_ciudad,nivel_ciudad,capacidad_habitantes,capacidad_militar_terrestre,impuesto_ciudadano,capacidad_militar_naval,cantidad_madera_maxima ,cantidad_recurso_maxima,direccion_imagen_ciudad,capacidad_recurso,cantidad_habitante,crecimiento_de_habitante,grado_satisfaccion_total,numero_posicion_isla,ciudad_capital;
		    
			 set @ciudadnombre = nombre_ciudad;
			 set @nivel=nivel_ciudad;
			 set @capacidadmilitarterrestre =capacidad_militar_terrestre;
			    set @capacidadhabitantes=   capacidad_habitantes;
			 set @impuestociudadano =impuesto_ciudadano;
			 set @capacidadmilitarnaval =capacidad_militar_naval;
			 set @cantidadmaderamaxima =cantidad_madera_maxima;
			 set @cantidadrecursomaxima = cantidad_recurso_maxima;
			 set @imagenciudadisla =direccion_imagen_ciudad; 
			 set @codigoimagenciudad =null;
			 set @capacidadrecurso = capacidad_recurso;
			 set @cantidadhabitante =cantidad_habitante; 
			 set @crecimientodehabitante =crecimiento_de_habitante; 
			 set @gradodesatisfacciontotal =grado_satisfaccion_total;
			 set @numeroposicionisla =numero_posicion_isla; 
			 set @capital =ciudad_capital;
			  
			 IF done THEN
				  LEAVE read_loop;
			 END IF;
		 END LOOP;
	 CLOSE inicializardatosciudad;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INICIALIZAR_EDIFICIOS_DE_CIUDAD`(in nombreciudad varchar(25), in nickjugador varchar(30),in lugarciudad int, out nombreedificio varchar(30),out direccionimagen varchar(100), out niveledificio int, out lugaredificiociudad int)
BEGIN
        	        	     set nombreedificio =    (SELECT edificio.nombre FROM (((ciudadedificionivel INNER JOIN (jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador) ON ciudadedificionivel.codigociudad = ciudad.codigociudad) INNER JOIN edificionivel ON ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel) INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio) INNER JOIN imagenes ON edificio.codigoimagen = imagenes.codigoimagen WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad) AND ((ciudadedificionivel.lugarciudad)=lugarciudad)));
	
			 set direccionimagen=   (SELECT imagenes.direccion FROM (((ciudadedificionivel INNER JOIN (jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador) ON ciudadedificionivel.codigociudad = ciudad.codigociudad) INNER JOIN edificionivel ON ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel) INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio) INNER JOIN imagenes ON edificio.codigoimagen = imagenes.codigoimagen WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad) AND ((ciudadedificionivel.lugarciudad)=lugarciudad)));
	
			 set niveledificio =    (SELECT edificionivel.nivel FROM (((ciudadedificionivel INNER JOIN (jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador) ON ciudadedificionivel.codigociudad = ciudad.codigociudad) INNER JOIN edificionivel ON ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel) INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio) INNER JOIN imagenes ON edificio.codigoimagen = imagenes.codigoimagen WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad) AND ((ciudadedificionivel.lugarciudad)=lugarciudad)));
	
			 set lugaredificiociudad =    (SELECT ciudadedificionivel.lugarciudad FROM (((ciudadedificionivel INNER JOIN (jugador INNER JOIN ciudad ON jugador.codigojugador = ciudad.codigojugador) ON ciudadedificionivel.codigociudad = ciudad.codigociudad) INNER JOIN edificionivel ON ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel) INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio) INNER JOIN imagenes ON edificio.codigoimagen = imagenes.codigoimagen WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad) AND ((ciudadedificionivel.lugarciudad)=lugarciudad)));
	
	    
		   
       
		   
        

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INICIALIZAR_ESTADO_CIUDAD`(in nickjugador varchar(30), nombreciudad varchar(25), out codigoestado int, out nombreestado varchar(30))
BEGIN
         DECLARE DONE BOOL DEFAULT FALSE;
		 declare estado_ciudad varchar(30);
		 declare codigo_estado int;
	     DECLARE inicializarestadociudad CURSOR FOR SELECT estadociudad.codigoestado, estadociudad.estado FROM (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN estadociudad ON ciudad.codigoestado = estadociudad.codigoestado WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad));
		 DECLARE CONTINUE HANDLER FOR NOT FOUND 
		 SET done = TRUE;
		   
		 OPEN inicializarestadociudad;
		 read_loop: LOOP
		   
		 FETCH inicializarestadociudad INTO codigo_estado,estado_ciudad;
		     set @codigoestado = codigo_estado;
			 set @nombreestado=estado_ciudad;
			 
	     IF done THEN
			  LEAVE read_loop;
	     END IF;
		 END LOOP;
	 CLOSE inicializarestadociudad;





END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INICIALIZAR_OFERTA`(IN `codigooferta` INT, OUT `recursoofertado` VARCHAR(25), OUT `cantidad` INT, OUT `orobuscado` BOOLEAN, OUT `recursobuscado` VARCHAR(25))
BEGIN
     declare codigo_recurso int;
     declare codigo_oferta int;
     declare codigo_recurso_2 int;
     set codigo_oferta=codigooferta;
     select codigo_oferta;
     set codigo_recurso=(select codigorecurso from oferta where   codigooferta=codigo_oferta limit 1);
     set recursoofertado=(select nombre from recurso where codigorecurso=codigo_recurso  limit 1);
     
     set cantidad=(select cantidadofrecida from oferta where codigooferta=
     codigo_oferta  limit 1);
     
     if((select orobuscado from oferta where codigooferta=
     codigo_oferta  limit 1)=true) then
          
         set orobuscado=true;
         
     else
         set orobuscado=false;
             set codigo_recurso_2=(select codigorecursobuscado from oferta where codigooferta=codigo_oferta  limit 1);
   
     set recursobuscado=(select nombre from recurso where codigorecurso=codigo_recurso_2  limit 1);
     end if;
   
     
     
     

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INICIALIZAR_PRODUCCION_CIUDAD`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), OUT `cantidadmadera` INT, OUT `recursolujo` VARCHAR(25), OUT `cantidadrecursolujo` INT)
BEGIN
   set cantidadmadera = ( SELECT ciudadproduccion.cantidadhora FROM (ciudadproduccion INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadproduccion.codigociudad = ciudad.codigociudad) INNER JOIN recurso ON ciudadproduccion.codigorecurso = recurso.codigorecurso WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((recurso.nombre)="Madera")));
    
   set recursolujo = (SELECT recurso.nombre FROM ((ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN (islarecurso INNER JOIN isla ON islarecurso.codigoisla = isla.codigoisla) ON ciudad.codigoisla = isla.codigoisla) INNER JOIN recurso ON islarecurso.codigorecurso = recurso.codigorecurso WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((recurso.nombre)<>"Madera")));
   
    set cantidadrecursolujo = ( SELECT ciudadproduccion.cantidadhora FROM (ciudadproduccion INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadproduccion.codigociudad = ciudad.codigociudad) INNER JOIN recurso ON ciudadproduccion.codigorecurso = recurso.codigorecurso WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((recurso.nombre)=recursolujo)));
   
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INICIALIZAR_RECURSOS_CIUDAD`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), OUT `cantidadmadera` INT, OUT `cantidadvino` INT, OUT `cantidadmarmol` INT, OUT `cantidadazufre` INT, OUT `cantidadcristal` INT)
BEGIN
  set cantidadmadera = (SELECT ciudadrecurso.cantidad FROM recurso INNER JOIN ((ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN ciudadrecurso ON ciudad.codigociudad = ciudadrecurso.codigociudad) ON recurso.codigorecurso = ciudadrecurso.codigorecurso WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((recurso.nombre)="Madera")));
  set cantidadvino = (SELECT ciudadrecurso.cantidad FROM recurso INNER JOIN ((ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN ciudadrecurso ON ciudad.codigociudad = ciudadrecurso.codigociudad) ON recurso.codigorecurso = ciudadrecurso.codigorecurso WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((recurso.nombre)="Vino")));
  set cantidadmarmol = (SELECT ciudadrecurso.cantidad FROM recurso INNER JOIN ((ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN ciudadrecurso ON ciudad.codigociudad = ciudadrecurso.codigociudad) ON recurso.codigorecurso = ciudadrecurso.codigorecurso WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((recurso.nombre)="Marmol")));
  set cantidadcristal = (SELECT ciudadrecurso.cantidad FROM recurso INNER JOIN ((ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN ciudadrecurso ON ciudad.codigociudad = ciudadrecurso.codigociudad) ON recurso.codigorecurso = ciudadrecurso.codigorecurso WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((recurso.nombre)="Cristal")));
  set cantidadazufre = (SELECT ciudadrecurso.cantidad FROM recurso INNER JOIN ((ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN ciudadrecurso ON ciudad.codigociudad = ciudadrecurso.codigociudad) ON recurso.codigorecurso = ciudadrecurso.codigorecurso WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((recurso.nombre)="Azufre")));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarinvestigacion`(in titulo varchar(100), in descripcion text ,in puntosinve int,in tema_elegido varchar(25),efecto varchar(200),numeroinvestigacion int)
begin

    declare codigo_tema int;
	set codigo_tema =(select codigotema from temainvestigacion where tema=tema_elegido);
    insert into investigacion(titulo,descripcion,puntosinvestigacion,codigotema,Efecto,numeroorden) values
	(titulo,descripcion,puntosinve,codigo_tema,efecto,numeroinvestigacion);
	
	
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarinvestigaciones`(in titulo varchar(100), in descripcion text ,in puntosinve int,in tema_elegido varchar(25),efecto varchar(200),numeroinvestigacion int)
begin

    declare codigo_tema int;
	set codigo_tema =(select codigotema from temainvestigacion where tema=tema_elegido);
    insert into investigacion(titulo,descripcion,puntosinvestigacion,codigotema,Efecto,numeroorden) values
	(titulo,descripcion,puntosinve,codigo_tema,efecto,numeroinvestigacion);
	
	
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_armas`(in nombre_arma varchar(30), in puntosataques int, in puntosdefensa int, direccionimagen varchar(100), in costo int)
begin
     declare codigo_imagen int;
	 insert into imagenes(direccion) values(direccionimagen);
	 set codigo_imagen = (select max(codigoimagen) from imagenes);
	 insert into arma(nombrearma,puntosataque,puntosdefensa,costo,codigoimagen) values(nombre_arma,puntosataques,puntosdefensa,costo,codigo_imagen);
	 
	 

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_arma_construccion`(in nombre_arma varchar(30), nombre_recurso varchar(25), cantidad int)
begin
    declare codigoimagen int;
	declare codigoarma int;
     declare codigo_recurso int;
	 if((select count(*) from recurso where nombre=nombre_recurso)=0) then
		 insert into imagenes(direccion) values(nombre_recurso);
		 set codigoimagen = (Select max(codigoimagen) from imagenes);
	    insert into recurso(nombre,codigoimagen) values(nombre_recurso,codigoimagen);
		
	 end if;
	 set codigo_recurso = (select codigorecurso from recurso where nombre=nombre_recurso);
	 
	 
	 set codigoarma =(select codigoarma from arma where nombrearma=nombre_arma);
	 
	 insert into armaconstruccion values(codigoarma,codigo_recurso,cantidad);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_arma_construccion_1`(IN `nombre_arma` VARCHAR(30), IN `nombre_recurso` VARCHAR(25), IN `cantidadrecurso` INT)
begin
    declare codigo_arma int;
	declare codigo_recurso int;
	
	set codigo_arma = (select codigoarma from arma where nombrearma= nombre_arma);
	set codigo_recurso = (select codigorecurso from recurso where nombre = nombre_recurso);
	insert into armaconstruccion  values(codigo_arma,codigo_recurso,cantidadrecurso);
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_arma_unidad_militar`(IN `nombre_unidad` VARCHAR(30), IN `nombre_arma` VARCHAR(30))
begin
declare codigo_arma int;
     declare codigo_unidad int;
	 set codigo_arma =(select codigoarma from arma where nombrearma=nombre_arma);
	 
set codigo_unidad = (select codigounidad from unidadmilitar where nombre =nombre_unidad);

insert into armaunidad values(codigo_unidad,codigo_arma);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_ciudades`(IN `nick_jugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `nombreisla` VARCHAR(25), IN `nivel` TINYINT, IN `capacidadrecurso` INT, IN `cantidadhabitantes` INT, IN `estadociudad` VARCHAR(30), IN `numeroposicionisla` INT, IN `capital` BOOLEAN)
BEGIN
    DECLARE codigo_isla int;
	DECLARE codigo_jugador int;
	declare codigo_estado int;
    declare codigo_ciudad int;
	set codigo_isla = (select codigoisla from isla where nombre=nombreisla);

	set codigo_jugador=(select codigojugador from jugador where nick=nick_jugador);
	set codigo_estado = (select codigoestado from estadociudad where estado=estadociudad);
	insert into ciudad(codigojugador,nombre,codigoisla,nivel,capacidadrecurso,cantidadhabitantes,codigoestado,numeroposicionisla,activa,capital) values (codigo_jugador,nombreciudad,codigo_isla,nivel,capacidadrecurso,cantidadhabitantes,codigo_estado,numeroposicionisla,true,capital);
    set codigo_ciudad =(select max(codigociudad) from ciudad);
    insert into ciudadacademia values(codigo_ciudad,0,curdate(),curtime());
    


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERTAR_EDIFICIOS_BD`(in nombre_edificio varchar(30), in descripcion text(600), in costo int)
begin
     declare codigoimagen int;
	 declare direccionimagen varchar(100);
     if((select count(*) from imagenes where direccion = nombre_edificio)=0)then
     insert into imagenes(direccion) values(nombre_edificio);
	 end if;
	 set direccionimagen = nombre_edificio;
	 set codigoimagen = (select codigoimagen from imagenes where direccion =direccionimagen);
     insert into edificio(nombre,codigoimagen,costo,descripcion) values(nombre_edificio,codigoimagen,costo,descripcion);
	 

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_edificios_en_ciudades`(in nombrejugador varchar(30), in nombreciudad varchar(25), in nombreedificio varchar(30), in nivel int, lugarciudad int)
BEGIN
     DECLARE CODIGOEDIFICIO INT;
     declare codigo_ciudad int;
	 declare codigo_edificio_nivel int;
      CALL BUSCARCIUDAD(nombrejugador, nombreciudad,@CODIGOCIUDAD);
	  set codigo_ciudad= @CODIGOCIUDAD;
	  set codigo_edificio_nivel =(select codigoedifnivel from  edificio,edificionivel where  edificionivel.codigoedificio=edificio.codigoedificio AND nombre=nombreedificio and edificionivel.nivel = nivel);
	  
	  insert into ciudadedificionivel values(codigo_ciudad,codigo_edificio_nivel,lugarciudad);
	  
	 


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_islas`(in nombreisla varchar(25), coordenadax int, coordenaday int, nombreimagenisla varchar(100),in cantidadciudadesconstruir int,capacidaddisponible int,in recursoextra varchar(25), in recursomadera varchar(25))
begin
   declare codigoimagen int;
   declare codigorecursoextra int;
   declare codigorecursomadera int;
   declare codigoisla int;
   
   
   set codigoimagen = 1;
   
   insert into isla(nombre,coordenadax,coordenaday,codigoimagen,capacidadciudades,capacidaddisponible) values(nombreisla,coordenadax,coordenaday,codigoimagen,cantidadciudadesconstruir,capacidaddisponible);
   
    set codigoisla = (select codigoisla from isla WHERE NOMBRE=NOMBREISLA);
   
   set codigorecursoextra =(select codigorecurso from recurso where nombre= recursoextra);
   set codigorecursomadera = (select codigorecurso from recurso where nombre= "Madera");
   
  
   insert into islarecurso values((select codigoisla from isla WHERE NOMBRE=NOMBREISLA),codigorecursoextra);
   insert into islarecurso values((select codigoisla from isla WHERE NOMBRE=NOMBREISLA),codigorecursomadera);
   
   

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERTAR_JUGADOR`(in nick varchar(30),IN clave varchar(10))
begin
    INSERT INTO JUGADOR(nick,clave,fechaingreso,estado,puntostotales,protegido,vacaciones) values(nick,clave,now(),activo,0,true,false);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERTAR_JUGADORES`(in nick varchar(30), in clave varchar(10),in oro int, in fechaingreso date, puntostotales int, protegido boolean, vacaciones boolean)
BEGIN
    INSERT INTO JUGADOR(NICK,CLAVE,ORO,FECHAINGRESO,HORAINGRESO,PUNTOSTOTALES,PROTEGIDO,VACACIONES) VALUES(nick,clave,oro,fechaingreso,curtime(),puntostotales,protegido,vacaciones);
	

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERTAR_RECURSOS_NIVEL_BD`(IN nombre_edificio varchar(30), nivel_poner int, recurso_poner varchar(25), cantidad_recurso int)
BEGIN
DECLARE CODIGO_EDIFICIO INT;
declare codigo_recurso int;
declare codigoimagen int;

	 SET CODIGO_EDIFICIO = (SELECT CODIGOEDIFICIO FROM edificio where nombre=nombre_edificio);
	 IF((SELECT COUNT(*) from edificionivel where codigoedificio = codigo_edificio and nivel =nivel_poner)=0) then
	        insert into edificionivel(codigoedificio,nivel) values(codigo_edificio,nivel_poner);
	 end if;
	 
	 set codigo_edificio =(select codigoedifnivel from edificionivel where codigoedificio = codigo_edificio and nivel =nivel_poner);
	 
	
	 set codigo_recurso = (select codigorecurso from recurso where nombre=recurso_poner);
	 
	 insert into edificiorecurso values(codigo_edificio,codigo_recurso,cantidad_recurso);
	 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_unidades_militares_bd`(in nombre varchar(30), in descripcion text(700), costo int, puntosdefensivos int, puntosataque int, barco boolean,nivelnecesario int, carga int)
begin
    
	 insert into unidadmilitar(nombre,descripcion,codigoimagen,costo,puntosdefensivos,puntosataque,barco,nivelnecesario,carga) values (nombre,descripcion,31,costo,puntosdefensivos,puntosataque,barco,nivelnecesario,carga);
	 
	 

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_unidad_militar_construccion`( in nombre_unidad varchar(30), in recurso_poner varchar(25), in cantidad int)
begin
     declare codigo_unidad int;
	 declare codigo_recurso int;
  

   set codigo_unidad = (select codigounidad from unidadmilitar where nombre =nombre_unidad);
	 
	
	 set codigo_recurso = (select codigorecurso from recurso where nombre=recurso_poner);
	 
	 insert into unidadmilitarconstruccion values(codigo_unidad,codigo_recurso,cantidad);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `MODIFICAR_CONTRASENIA`(in nickjugador varchar(30), in clavenueva varchar(10))
BEGIN
    update jugador set clave = clavenueva
	where nick=nickjugador;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PAGAR_ORO`(IN `NICKJUGADOR` VARCHAR(30), IN `CANTIDADORO` INT)
BEGIN
     UPDATE JUGADOR SET ORO=ORO-CANTIDADORO WHERE NICK=NICKJUGADOR;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `recaudarimpuesto`(in codigo_jugador int, out dineroimpuesto int)
begin

				   
    set dineroimpuesto=(select sum(ciudad.cantidadhabitantes * nivelciudad.impuestociudadano) as cantidad from ciudad,nivelciudad where ciudad.nivel=nivelciudad.nivel and ciudad.codigojugador=codigo_jugador);


end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RECIBIR_ORO`(IN `NICKJUGADOR` VARCHAR(30), IN `CANTIDADORO` INT)
BEGIN
     UPDATE JUGADOR SET ORO=ORO+CANTIDADORO WHERE NICK=NICKJUGADOR;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RESERVAR_OFERTA`(IN `NICKJUGADOR` VARCHAR(30), IN `RECURSOAVENDER` VARCHAR(25), IN `CANTIDAD` INT, IN `RECURSOACAMBIO` VARCHAR(25), IN `ORO` BOOLEAN)
BEGIN
    DECLARE CODIGORECURSOOFERTADO INT;
	DECLARE CODIGORECURSOBUSCADO INT;
	DECLARE CODIGO_OFERTA INT;
	DECLARE codigo_jugador int;
    set codigo_jugador = (select codigojugador from jugador 
                          where nick=NICKJUGADOR);
	
	CALL BUSCARRECURSO(RECURSOAVENDER, @codigo_recurso);
	SET CODIGORECURSOOFERTADO =  @codigo_recurso;
	
	IF(ORO=TRUE) THEN
	    set CODIGORECURSOBUSCADO =NULL;
	ELSE
	     CALL BUSCARRECURSO(RECURSOACAMBIO, @codigo_recurso);
	     SET CODIGORECURSOBUSCADO =  @codigo_recurso;
	END IF;
	
	INSERT INTO OFERTA(codigorecurso,cantidadofrecida,orobuscado,codigorecursobuscado,jugador,fecha) values (CODIGORECURSOOFERTADO,cantidad,oro,CODIGORECURSOBUSCADO,true,now());
    
     SET CODIGO_OFERTA = (SELECT CODIGOOFERTA FROM OFERTA ORDER BY  CODIGOOFERTA DESC  LIMIT 1);
	 
	 INSERT INTO OFERTAJUGADOR VALUES(CODIGO_OFERTA,codigo_jugador);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RESTAR_HABITANTES_DISPONIBLES`(in nombreciudad varchar(25), in nickjugador varchar(30), in cantidad int)
BEGIN
     CALL BUSCARCIUDAD(nickjugador,nombreciudad,@codigociudad);
	 update ciudad set cantidadhabitantesdisponible=cantidadhabitantesdisponible-cantidad
	 where codigociudad = @codigociudad;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SERVIR_VINO`(IN `nombreciudad` VARCHAR(25), IN `nombrejugador` VARCHAR(30), IN `cantidadvino` INT)
begin
      CALL BUSCARCIUDAD(nombrejugador,nombreciudad,@codigo_ciudad);
      if((select count(*) from ciudadtaberna where codigociudad=@codigo_ciudad)=0) then
        insert into ciudadtaberna values(@codigo_ciudad,cantidadvino,curdate(),curtime());
      else
	  update CIUDADTABERNA set cantidadvinoservido=cantidadvino
	  where codigociudad=@codigo_ciudad;
      end if;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_ACADEMIA_CONSTRUIDA`(IN NICKJUGADOR VARCHAR(30), NOMBRECIUDAD VARCHAR(25), OUT ACADAMIACONSTRUIDA BOOLEAN)
BEGIN
   if((SELECT count(*) FROM ((ciudadedificionivel INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadedificionivel.codigociudad = ciudad.codigociudad) INNER JOIN edificionivel ON ciudadedificionivel.codigoedificio = edificionivel.codigoedifnivel) INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((edificio.nombre)="Academia")))=0) then
     set @ACADAMIACONSTRUIDA=false;
   else
   set @ACADAMIACONSTRUIDA=true;
   end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_ASTILLERO_DE_GUERRA_VACIO`(IN NICKJUGADOR VARCHAR(30), IN NOMBRECIUDAD VARCHAR(25), OUT CUARTELVACIO BOOLEAN)
BEGIN
if((SELECT Sum(ciudadejercito.cantidadtotal) AS Expr1 FROM (ciudadejercito INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadejercito.codigociudad = ciudad.codigociudad) INNER JOIN unidadmilitar ON ciudadejercito.codigounidad = unidadmilitar.codigounidad WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((unidadmilitar.barco)=true)))=null)  then
      set @cuartelvacio = true;
    else
	 set @cuartelvacio = false;
	
	end if;



END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_CANTIDAD_ASIGNAMIENTO_ARMA`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `nombreunidad` VARCHAR(30), IN `nombrearma` VARCHAR(30), IN `cantidad` INT, OUT `existe` BOOLEAN)
BEGIN
  
   declare cantidadasignada int;
   
   set cantidadasignada = (SELECT ciudadejercitoarma.cantidaddisponibleciudad FROM (ciudadejercitoarma INNER JOIN ((ciudadejercito INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadejercito.codigociudad = ciudad.codigociudad) INNER JOIN unidadmilitar ON ciudadejercito.codigounidad = unidadmilitar.codigounidad) ON ciudadejercitoarma.codigounidadciudad = ciudadejercito.codigounidadciudad) INNER JOIN arma ON ciudadejercitoarma.codigoarma = arma.codigoarma WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((unidadmilitar.nombre)=nombreunidad) AND ((arma.nombrearma)=nombrearma)));

   if(cantidadasignada >=cantidad) then
       set existe = true;
   else
    set existe = false;
   end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_CANTIDAD_A_COMPRAR`(IN `codigooferta` INT, IN `cantidad` INT, OUT `tiene` BOOLEAN)
BEGIN
      declare codigodeoferta int;
	  set codigodeoferta = codigooferta;
	  
	  if((SELECT oferta.cantidadofrecida FROM oferta WHERE (((oferta.codigooferta)=codigodeoferta)))>=cantidad)  then
	       set tiene = true;
	  else 
	    set tiene = false;
	  end if;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_CANTIDAD_HABITANTES`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `CANTIDADHABITANTES` INT, OUT `suficienteshabitantes` BOOLEAN)
BEGIN 
     declare habitantes int;
	 
	 set habitantes = (SELECT ciudad.cantidadhabitantesdisponibles FROM ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador)));
     if(habitantes >=CANTIDADHABITANTES) then
	      set @suficienteshabitantes=true;
	 else
	 set @suficienteshabitantes=false;
	 end if;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_CIUDAD_SIN_PROCESO_DE_ATAQUE`(IN `NOMBRECIUDAD` VARCHAR(25), IN `NICKJUGADOR` VARCHAR(30), IN `TIPOATAQUE` VARCHAR(30), OUT `PROCESOATAQUE` BOOLEAN)
BEGIN
  set PROCESOATAQUE=false;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_CONTRASENIA_DISTINTA_A_LA_ANTIGUA`(IN `nickjugador` VARCHAR(30), IN `clavenueva` VARCHAR(10), OUT `igual` BOOLEAN)
BEGIN
      if((SELECT count(*) FROM jugador WHERE (((jugador.nick)=nickjugador) AND ((jugador.clave)=clavenueva)))=0) then
	     set igual = false;
	  
	  else
	  set igual = true;
	  end if;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_CUARTEL_VACIO`(IN NICKJUGADOR VARCHAR(30), IN NOMBRECIUDAD VARCHAR(25), OUT CUARTELVACIO BOOLEAN)
BEGIN
    if((SELECT Sum(ciudadejercito.cantidadtotal) AS Expr1 FROM (ciudadejercito INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadejercito.codigociudad = ciudad.codigociudad) INNER JOIN unidadmilitar ON ciudadejercito.codigounidad = unidadmilitar.codigounidad WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador) AND ((unidadmilitar.barco)=False)))=null)  then
      set @cuartelvacio = true;
    else
	 set @cuartelvacio = false;
	
	end if;
      
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_DEPOSITO_VACIO`(IN NICKJUGADOR VARCHAR(30), IN NOMBRECIUDAD VARCHAR(25),IN DEPOSITO BOOLEAN, OUT VACIO BOOLEAN)
BEGIN

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_JUGADOR_EXISTE_EN_GUERRA`(in codigoguera int, in nickjugador varchar(30), out existe boolean)
BEGIN
  declare codigodeguerra int;
  set codigodeguerra = codigoguerra;
   if((SELECT Count(*) AS Expr1 FROM guerraparticipante INNER JOIN jugador ON guerraparticipante.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=nickjugador) AND ((guerraparticipante.codigoguerra)=codigodeguerra)))=0) then
        set @existe = false;
   else
    set @existe = true;
   end if;


END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_JUGADOR_MISIONES`(IN nickjugador varchar(30),out tienemision boolean)
BEGIN
   
   
   set @tienemision = (SELECT misionjuegojugador.activa FROM misionjuegojugador INNER JOIN jugador ON misionjuegojugador.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=nickjugador)) ORDER BY misionjuegojugador.fechainicio DESC limit 1);
 
 if (@tienemision = NULL) then
  set @tienemision = false;
 end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_JUGADOR_SIN_MISMA_GUERRA`(IN nickjugadoratacador varchar(30),in nickjugadoratacado varchar(30), out singuerra boolean)
BEGIN

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_LUGAR_EN_ISLA`(IN `COORX` INT, IN `COORY` INT, OUT `LUGARPARACONSTRUIR` BOOLEAN)
begin
  
  declare cantidad int;
  
  set cantidad=(select capacidaddisponible from isla where coordenadax=coorx and coordenaday=coory);
  if(cantidad=0) then
  set LUGARPARACONSTRUIR=false;
  
  else
  set LUGARPARACONSTRUIR=true;
  
  end if;
  
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_MERCADO_SIN_DEPOSITO`(IN NICKJUGADOR VARCHAR(30), IN NOMBRECIUDAD VARCHAR(25), OUT DEPOSITOVACIO BOOLEAN)
BEGIN
    if((SELECT Sum(depositomercado.cantidad) AS Expr1 	FROM depositomercado INNER JOIN jugador ON depositomercado.codigojugador = jugador.codigojugador	WHERE (((jugador.nick)="nickjugador")))=null) then
        set @DEPOSITOVACIO=true;
	else
  set @DEPOSITOVACIO=false;
	end if;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_NICK_DISPONIBLE`(IN `nickjugador` VARCHAR(30), IN `nickacambiar` VARCHAR(30), OUT `nickdisponible` BOOLEAN)
BEGIN
           if((select count(*) from jugador where nick=nickacambiar)=0) then
		        set nickdisponible=true;
		   else
		   
		    set nickdisponible=false;
		   end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_NOMBRE_DE_CIUDAD_DISPONIBLE`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreciudadnuevo` VARCHAR(25), OUT `disponible` BOOLEAN)
BEGIN
      if((SELECT count(*) FROM ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador WHERE (((ciudad.nombre)=nombreciudadnuevo) AND ((jugador.nick)=nickjugador)) and ciudad.activa=true)>0) then
	        set disponible = false;
	  else
	          set disponible = true;
	  end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_NO_SUPERAR_CAPACIDAD_MILITAR`(IN `nickjugador` VARCHAR(30), IN `nombreciudad` VARCHAR(25), IN `BARCO` BOOLEAN, IN `cantidad` INT, OUT `capacidadsuperada` BOOLEAN)
BEGIN
   declare capacidadmilitar int;
   if(barco=false) then
        set capacidadmilitar =(SELECT nivelciudad.capacidadmilitarterrestre FROM (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN nivelciudad ON ciudad.nivel = nivelciudad.nivel WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador)));
           
   else
       set capacidadmilitar =(SELECT  nivelciudad.capacidadmilitarnaval FROM (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) INNER JOIN nivelciudad ON ciudad.nivel = nivelciudad.nivel WHERE (((ciudad.nombre)=nombreciudad) AND ((jugador.nick)=nickjugador)));
         
   end if;
        if(cantidad<=capacidadmilitar) then
			    set @capacidadsuperada=false;
		    else
				 set @capacidadsuperada=true;
			end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_ORO`(IN `NICKJUGADOR` VARCHAR(30), IN `CANTIDADORO` INT, OUT `TIENE` BOOLEAN)
BEGIN
    IF((SELECT COUNT(*) FROM JUGADOR WHERE NICK=NICKJUGADOR AND ORO>=CANTIDADORO)=1) THEN
       SET TIENE = TRUE;
	ELSE
	   SET TIENE = FALSE;
	END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_PALACIO_Y_CIUDADES`(IN `nickjugador` VARCHAR(30), IN `cantidadciudades` INT, OUT `capacidaconstruirciudad` BOOLEAN)
begin
    declare nivelpalacio int;
	set nivelpalacio = (SELECT edificionivel.nivel FROM edificio INNER JOIN (edificionivel INNER JOIN (ciudadedificionivel INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadedificionivel.codigociudad = ciudad.codigociudad) ON edificionivel.codigoedifnivel = ciudadedificionivel.codigoedificio) ON edificio.codigoedificio = edificionivel.codigoedificio WHERE (((jugador.nick)=nickjugador) AND ((edificio.nombre)="Palacio")));
select nivelpalacio;  
 
        if(nivelpalacio>cantidadciudades) then
          set capacidaconstruirciudad=true;
        else
           set capacidaconstruirciudad=false;
        end if;
    

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_POSIBLE_AMPLIACION`(IN `nombreedificio` VARCHAR(30), IN `nivel` INT, OUT `ampliacionposible` BOOLEAN)
begin
    DECLARE NIVELMAXIMO INT;   
    SET NIVELMAXIMO=( SELECT max(edificionivel.nivel) FROM edificionivel INNER JOIN edificio ON edificionivel.codigoedificio = edificio.codigoedificio WHERE (edificio.nombre)=nombreedificio) ;

	IF(nivel<=NIVELMAXIMO) THEN
	  SET ampliacionposible=true;
	ELSE
	 SET ampliacionposible=false;
	END IF;
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_PUERTO_NO_BLOQUEADO`(in nick varchar(30), ciudad varchar(25), out nobloqueado boolean)
begin

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_RECURSO_EN_CIUDAD`(IN `NICKJUGADOR` VARCHAR(30), IN `NOMBRECIUDAD` VARCHAR(25), IN `nombrerecurso` VARCHAR(25), IN `cantidadaverificar` INT, OUT `recursosdisponible` BOOLEAN)
begin
     DECLARE codigo_recurso int;
     declare cantidadtengo int;
    call buscarciudad(NICKJUGADOR,NOMBRECIUDAD,@CODIGO_CIUDAD);
    set codigo_recurso =(select codigorecurso from recurso where nombre = nombrerecurso);
    set cantidadtengo=(select cantidad from ciudadrecurso where codigorecurso=codigo_recurso and codigociudad=@CODIGO_CIUDAD);
    if(cantidadaverificar<=cantidadtengo) then
       set recursosdisponible=true;
    else
        set recursosdisponible=false;
    end if;
    
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_RECURSO_MERCADO`(IN `NICKJUGADOR` VARCHAR(30), IN `RECURSO` VARCHAR(25), IN `CANTIDADVERIFICAR` INT, OUT `RECURSODISPONIBLE` BOOLEAN)
BEGIN
   declare cantidadendeposito int;
   
   set cantidadendeposito = (SELECT depositomercado.cantidad FROM (depositomercado INNER JOIN recurso ON depositomercado.codigorecurso = recurso.codigorecurso) INNER JOIN jugador ON depositomercado.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=NICKJUGADOR) AND ((recurso.nombre)=RECURSO)));

   if(cantidadendeposito>=CANTIDADVERIFICAR) then
	       set RECURSODISPONIBLE = true;
	  else 
	    set RECURSODISPONIBLE = false;
	  end if;
   
   
   
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_TEMA_INVESTIGADO`(in nickjugador varchar(30), in temainvestigar varchar(100), out temainvestigado boolean)
BEGIN
   if((SELECT count(*) FROM (investigacionjugador INNER JOIN investigacion ON investigacionjugador.codigoinvestigacion = investigacion.codigoinvestigacion) INNER JOIN jugador ON investigacionjugador.codigojugador = jugador.codigojugador WHERE (((jugador.nick)=nickjugador) AND ((investigacion.titulo)=temainvestigar)))=0) then
      set @temainvestigado=false;
   else
    set @temainvestigado=true;
   end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_UNIDAD_MILITAR_CON_ARMA`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreunidad` VARCHAR(30), IN `NOMBREARMA` VARCHAR(30), IN `cantidad` INT, OUT `tiene` BOOLEAN)
BEGIN
   declare cantidadconarma int;
   set cantidadconarma = (SELECT ciudadejercitoarma.cantidaddisponibleciudad FROM (ciudadejercitoarma INNER JOIN ((ciudadejercito INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadejercito.codigociudad = ciudad.codigociudad) INNER JOIN unidadmilitar ON ciudadejercito.codigounidad = unidadmilitar.codigounidad) ON ciudadejercitoarma.codigounidadciudad = ciudadejercito.codigounidadciudad) INNER JOIN arma ON ciudadejercitoarma.codigoarma = arma.codigoarma WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad) AND ((unidadmilitar.nombre)=nombreunidad) AND ((arma.nombrearma)=NOMBREARMA)));
   
   IF(cantidadconarma >=cantidad) then
	  set tiene = true;
	else
	 set tiene = false;
	end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `VERIFICAR_UNIDAD_MILITAR_SIN_ARMA`(IN `nombreciudad` VARCHAR(25), IN `nickjugador` VARCHAR(30), IN `nombreunidad` VARCHAR(30), IN `cantidad` INT, OUT `tiene` BOOLEAN)
BEGIN
    declare cantidadsinarma int;
	
	set cantidadsinarma = (SELECT ciudadejercito.capacidaddisponiblesinarma FROM (ciudadejercito INNER JOIN (ciudad INNER JOIN jugador ON ciudad.codigojugador = jugador.codigojugador) ON ciudadejercito.codigociudad = ciudad.codigociudad) INNER JOIN unidadmilitar ON ciudadejercito.codigounidad = unidadmilitar.codigounidad WHERE (((jugador.nick)=nickjugador) AND ((ciudad.nombre)=nombreciudad) AND ((unidadmilitar.nombre)=nombreunidad)));

	if(cantidadsinarma>=cantidad) then
	  set tiene = true;
	else
	 set tiene = false;
	end if;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apostamientotropa`
--

CREATE TABLE IF NOT EXISTS `apostamientotropa` (
  `codigoapostamiento` int(11) NOT NULL,
  `codigociudapostador` int(11) NOT NULL,
  `codigociudadapostada` int(11) NOT NULL,
  `fechaapostamiento` date NOT NULL,
  `horaapostamiento` time NOT NULL,
  `vigencia` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigoapostamiento`),
  KEY `codigociudapostador` (`codigociudapostador`),
  KEY `codigociudadapostada` (`codigociudadapostada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apostamientounidad`
--

CREATE TABLE IF NOT EXISTS `apostamientounidad` (
  `codigoapostamiento` int(11) NOT NULL,
  `codigounidad` int(11) NOT NULL,
  `codigoarma` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigoapostamiento`,`codigounidad`,`codigoarma`),
  KEY `codigounidad` (`codigounidad`),
  KEY `codigoarma` (`codigoarma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arma`
--

CREATE TABLE IF NOT EXISTS `arma` (
  `codigoarma` int(11) NOT NULL AUTO_INCREMENT,
  `nombrearma` varchar(30) NOT NULL,
  `puntosataque` int(11) DEFAULT NULL,
  `puntosdefensa` int(11) DEFAULT NULL,
  `costo` int(11) DEFAULT NULL,
  `codigoimagen` int(11) NOT NULL,
  PRIMARY KEY (`codigoarma`),
  UNIQUE KEY `nombrearma` (`nombrearma`),
  KEY `codigoimagen` (`codigoimagen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Volcado de datos para la tabla `arma`
--

INSERT INTO `arma` (`codigoarma`, `nombrearma`, `puntosataque`, `puntosdefensa`, `costo`, `codigoimagen`) VALUES
(1, 'Arco Compuesto', 60, 20, 2, 94),
(2, 'Ariete Medieval', 100, 100, 5, 95),
(3, 'Ariete Cubierto', 110, 100, 6, 96),
(4, 'Ariete de Asedio', 150, 100, 7, 97),
(5, 'Longbow', 80, 30, 4, 98),
(6, 'Ballesta', 90, 50, 6, 99),
(7, 'Ballista', 100, 60, 7, 100),
(8, 'Mangonel', 80, 50, 9, 101),
(9, 'Petrary', 90, 60, 9, 102),
(10, 'Trebuchet', 150, 100, 10, 103),
(11, 'Gladius', 80, 20, 4, 104),
(12, 'Claymore', 100, 10, 5, 105),
(13, 'Falcata', 90, 30, 5, 106),
(14, 'Carabina', 80, 10, 4, 107),
(15, 'Escopeta', 100, 10, 5, 108),
(16, 'Espada de bronce', 100, 80, 6, 109),
(17, 'Espada de hierro', 100, 100, 8, 110),
(18, 'Espada de acero', 120, 100, 8, 111),
(19, 'bolas explosivas', 100, 10, 7, 112),
(20, 'Barril explosivo', 150, 10, 10, 113),
(21, 'Honda', 50, 10, 2, 114),
(22, 'Daga', 50, 10, 2, 115),
(23, 'Jabalina', 70, 10, 4, 116),
(24, 'Tridente', 80, 80, 7, 117),
(25, 'Pica', 90, 50, 7, 118),
(26, 'Mortero', 100, 70, 10, 120),
(27, 'Ninguna', NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `armaconstruccion`
--

CREATE TABLE IF NOT EXISTS `armaconstruccion` (
  `codigoarma` int(11) NOT NULL DEFAULT '0',
  `codigorecurso` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigoarma`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `armaconstruccion`
--

INSERT INTO `armaconstruccion` (`codigoarma`, `codigorecurso`, `cantidad`) VALUES
(1, 6, 20),
(2, 6, 80),
(3, 6, 80),
(3, 9, 20),
(4, 6, 100),
(4, 9, 20),
(4, 12, 10),
(5, 6, 50),
(6, 6, 60),
(6, 9, 30),
(7, 6, 60),
(7, 9, 20),
(7, 12, 20),
(8, 6, 90),
(8, 9, 20),
(9, 6, 100),
(9, 9, 20),
(10, 6, 100),
(10, 9, 50),
(11, 6, 30),
(11, 9, 20),
(12, 6, 40),
(12, 9, 20),
(13, 6, 30),
(13, 9, 30),
(14, 6, 70),
(14, 9, 50),
(15, 6, 70),
(15, 9, 70),
(19, 9, 70),
(20, 6, 80),
(20, 9, 60),
(21, 6, 30),
(21, 9, 10),
(22, 6, 20),
(22, 12, 20),
(23, 6, 60),
(23, 9, 30),
(24, 6, 50),
(24, 9, 60),
(25, 6, 50),
(25, 9, 30),
(25, 12, 20),
(26, 6, 60),
(26, 9, 80);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `armaunidad`
--

CREATE TABLE IF NOT EXISTS `armaunidad` (
  `codigounidad` int(11) NOT NULL DEFAULT '0',
  `codigoarma` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codigounidad`,`codigoarma`),
  KEY `codigoarma` (`codigoarma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `armaunidad`
--

INSERT INTO `armaunidad` (`codigounidad`, `codigoarma`) VALUES
(25, 1),
(28, 2),
(28, 3),
(28, 4),
(25, 5),
(25, 6),
(25, 7),
(29, 8),
(29, 9),
(29, 10),
(21, 11),
(23, 11),
(23, 12),
(23, 13),
(26, 14),
(26, 15),
(32, 19),
(32, 20),
(27, 21),
(27, 22),
(30, 22),
(21, 23),
(24, 23),
(24, 24),
(24, 25),
(30, 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asalto`
--

CREATE TABLE IF NOT EXISTS `asalto` (
  `codigoataque` int(11) NOT NULL,
  `codigorecurso` tinyint(3) unsigned NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigoataque`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataque`
--

CREATE TABLE IF NOT EXISTS `ataque` (
  `codigoataque` int(11) NOT NULL AUTO_INCREMENT,
  `codigociudadjugatacante` int(11) NOT NULL,
  `codigociudadjugatacado` int(11) NOT NULL,
  `fechasalida` date NOT NULL,
  `horasalida` time NOT NULL,
  `fechallegada` date NOT NULL,
  `horallegada` time NOT NULL,
  `codigomision` int(11) NOT NULL,
  `codjugadorganador` int(11) DEFAULT NULL,
  `vigencia` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoataque`),
  KEY `codigociudadjugatacante` (`codigociudadjugatacante`),
  KEY `codigociudadjugatacado` (`codigociudadjugatacado`),
  KEY `codigomision` (`codigomision`),
  KEY `codjugadorganador` (`codjugadorganador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataqueunidaddecombate`
--

CREATE TABLE IF NOT EXISTS `ataqueunidaddecombate` (
  `codigoataque` int(11) NOT NULL DEFAULT '0',
  `codigounidad` int(11) NOT NULL DEFAULT '0',
  `codigoarma` int(11) NOT NULL DEFAULT '0',
  `atacante` tinyint(1) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigoataque`,`codigounidad`,`codigoarma`),
  KEY `codigounidad` (`codigounidad`),
  KEY `codigoarma` (`codigoarma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barcomovimiento`
--

CREATE TABLE IF NOT EXISTS `barcomovimiento` (
  `codigomov` int(11) NOT NULL DEFAULT '0',
  `codigobarco` int(11) NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigomov`,`codigobarco`),
  KEY `codigobarco` (`codigobarco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `barcomovimiento`
--

INSERT INTO `barcomovimiento` (`codigomov`, `codigobarco`, `cantidad`) VALUES
(3, 1, 7),
(4, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barcos`
--

CREATE TABLE IF NOT EXISTS `barcos` (
  `codigobarco` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(240) NOT NULL,
  `codigoimagen` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `costo` float DEFAULT NULL,
  PRIMARY KEY (`codigobarco`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `codigoimagen` (`codigoimagen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `barcos`
--

INSERT INTO `barcos` (`codigobarco`, `nombre`, `descripcion`, `codigoimagen`, `capacidad`, `costo`) VALUES
(1, 'Barco Mercante', 'El barco mercante sirve para transpotar recursos y soldados entre las ciudades de los jugadores', 47, 1000, 500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carga`
--

CREATE TABLE IF NOT EXISTS `carga` (
  `codigomov` int(11) NOT NULL DEFAULT '0',
  `codigorecurso` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigomov`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carga`
--

INSERT INTO `carga` (`codigomov`, `codigorecurso`, `cantidad`) VALUES
(3, 6, 6008),
(3, 9, 0),
(3, 12, 0),
(3, 14, 0),
(3, 15, 0),
(4, 6, 717),
(4, 9, 0),
(4, 12, 0),
(4, 14, 0),
(4, 15, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargamilitar`
--

CREATE TABLE IF NOT EXISTS `cargamilitar` (
  `codigomov` int(11) NOT NULL DEFAULT '0',
  `codigounidad` int(11) NOT NULL DEFAULT '0',
  `codigoarma` int(11) NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigomov`,`codigounidad`,`codigoarma`),
  KEY `codigounidad` (`codigounidad`),
  KEY `codigoarma` (`codigoarma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE IF NOT EXISTS `ciudad` (
  `codigociudad` int(11) NOT NULL AUTO_INCREMENT,
  `codigojugador` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `codigoisla` int(11) NOT NULL,
  `nivel` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `capacidadrecurso` int(11) NOT NULL DEFAULT '2000',
  `cantidadhabitantes` int(11) DEFAULT '0',
  `crecimientodehabitante` int(11) DEFAULT '0',
  `gradodesatisfacciontotal` int(11) DEFAULT '0',
  `codigoestado` tinyint(3) unsigned NOT NULL,
  `numeroposicionisla` tinyint(3) unsigned NOT NULL,
  `activa` tinyint(1) NOT NULL DEFAULT '1',
  `capital` tinyint(1) NOT NULL,
  `cantidadhabitantesdisponibles` int(11) DEFAULT NULL,
  `fechaactualizacion` datetime DEFAULT NULL,
  PRIMARY KEY (`codigociudad`),
  UNIQUE KEY `codigojugador` (`codigojugador`,`nombre`),
  KEY `codigoisla` (`codigoisla`),
  KEY `nivel` (`nivel`),
  KEY `codigoestado` (`codigoestado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=69 ;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`codigociudad`, `codigojugador`, `nombre`, `codigoisla`, `nivel`, `capacidadrecurso`, `cantidadhabitantes`, `crecimientodehabitante`, `gradodesatisfacciontotal`, `codigoestado`, `numeroposicionisla`, `activa`, `capital`, `cantidadhabitantesdisponibles`, `fechaactualizacion`) VALUES
(1, 6, 'Naci?n de Fuego', 50, 20, 42000, 801, -300, 0, 1, 1, 1, 1, 801, '2014-11-18 00:46:41'),
(2, 6, 'Ba Sing Se', 51, 19, 2000, 1100, NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:41'),
(3, 6, 'Isla Kioshy', 52, 18, 2000, 1100, NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:41'),
(4, 6, 'Isla de Roku', 53, 17, 2000, 1100, -300, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:41'),
(5, 6, 'Nomadas Aire', 54, 16, 2000, 1100, NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:43'),
(6, 6, 'Omashu', 55, 15, 2000, 1100, -300, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:44'),
(7, 6, 'Polo Sur', 56, 14, 2000, 1100, NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:45'),
(8, 6, 'Polo Norte', 57, 13, 2000, 1100, NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:45'),
(9, 7, 'Imperio Cesar I', 58, 12, 2000, 1100, NULL, 0, 1, 1, 1, 1, 1100, '2014-11-18 00:46:45'),
(10, 7, 'Imperio Cesar II', 50, 11, 2000, 1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:45'),
(11, 7, 'Imperio Cesar III', 51, 10, 2000, 1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'),
(12, 7, 'Imperio Cesar IV', 52, 9, 2000, 1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'),
(13, 7, 'Imperio Cesar V', 53, 8, 2000, 1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'),
(14, 7, 'Imperio Cesar VI', 54, 7, 2000, 1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'),
(15, 8, 'Grecia I', 55, 14, 10000, 1100, -300, 0, 1, 2, 1, 1, 1100, '2014-11-18 00:46:46'),
(16, 8, 'Grecia II', 56, 5, 2000, 1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'),
(17, 8, 'Grecia III', 57, 7, 2000, 1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'),
(18, 8, 'Grecia IV', 58, 3, 2000, 1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'),
(19, 9, 'Lukario I', 54, 20, 444000, 1100, -300, 0, 1, 3, 1, 1, 1100, '2014-11-18 00:46:47'),
(20, 9, 'Lukario II', 55, 7, 2000, 1100, NULL, 0, 1, 4, 1, 0, 1100, '2014-11-18 00:46:47'),
(21, 9, 'Lukario III', 56, 7, 2000, 1100, NULL, 0, 1, 5, 1, 0, 1100, '2014-11-18 00:46:47'),
(38, 30, 'Ciudad 1', 50, 1, 2000, 1100, NULL, 100, 1, 13, 1, 1, 1100, '2014-11-18 00:46:48'),
(45, 9, 'HJ', 54, 2, 10000, 1100, 100, 100, 1, 4, 0, 0, 1100, NULL),
(46, 9, 'Ciudad 5', 54, 2, 10000, 1100, 100, 100, 1, 10, 0, 0, 1100, NULL),
(47, 9, 'Ciudad 6', 54, 1, 2000, 1100, 100, 100, 1, 11, 0, 0, 1100, NULL),
(48, 40, 'CIudad Nueva', 50, 9, 690000, 1020, 500, 100, 1, 0, 1, 1, 125, NULL),
(49, 40, 'Emporio', 58, 2, 2000, 1100, 500, 100, 1, 9, 1, 0, 1100, NULL),
(50, 40, 'Ciudad 3', 52, 4, 42000, 1000, 100, 100, 1, 7, 0, 0, 1000, NULL),
(53, 40, 'Ciudad 4', 52, 2, 10000, 1040, 100, 100, 1, 14, 1, 0, 290, NULL),
(54, 40, 'Ciudad 5', 50, 1, 2000, 200, 100, 100, 1, 6, 0, 0, 200, NULL),
(55, 40, 'Ciudad 6', 51, 2, 34000, 120, 100, 100, 1, 7, 1, 0, 120, NULL),
(56, 41, 'Ciudad 1', 50, 1, 66000, 95, 100, 100, 1, 3, 1, 1, 1, NULL),
(57, 42, 'Ciudad 1', 50, 1, 2000, 100, 100, 100, 1, 4, 1, 1, 100, NULL),
(58, 43, 'Principal de Fuego', 50, 1, 2000, 1200, 100, 100, 1, 5, 1, 1, 700, NULL),
(59, 43, 'Ba Sing Se', 50, 1, 2000, 1200, 100, 100, 1, 15, 1, 0, 700, NULL),
(60, 43, 'Isla Kioshy', 53, 1, 2000, 1200, 100, 100, 1, 8, 1, 0, 702, NULL),
(61, 43, 'Isla de Roku', 56, 1, 2000, 1200, 100, 100, 1, 7, 1, 0, 700, NULL),
(62, 43, 'Ciudad de Fuego', 51, 1, 2000, 1200, 100, 100, 1, 4, 1, 0, 700, NULL),
(63, 43, 'Polo Norte', 54, 2, 2000, 1200, 100, 100, 1, 7, 1, 0, 700, NULL),
(64, 43, 'Nación del Fuego', 58, 1, 42000, 1200, 100, 100, 1, 11, 1, 0, 700, NULL),
(65, 43, 'Ciudad Capital', 52, 1, 2000, 1200, 100, 100, 1, 12, 1, 0, 700, NULL),
(66, 44, 'Ciudad 1', 50, 1, 2000, 100, 100, 100, 1, 7, 1, 1, 100, NULL),
(67, 45, 'Ciudad 1', 50, 2, 2000, 92, 100, 100, 1, 8, 1, 1, 92, NULL),
(68, 45, 'Imperio 1', 58, 4, 170000, 100, 100, 100, 1, 7, 1, 0, 100, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadacademia`
--

CREATE TABLE IF NOT EXISTS `ciudadacademia` (
  `codigociudad` int(11) NOT NULL DEFAULT '0',
  `investigadores` int(11) DEFAULT '0',
  `fechaactualizacion` date DEFAULT NULL,
  `horaactualizacion` time DEFAULT NULL,
  PRIMARY KEY (`codigociudad`),
  KEY `fechaactualizacion` (`fechaactualizacion`,`horaactualizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudadacademia`
--

INSERT INTO `ciudadacademia` (`codigociudad`, `investigadores`, `fechaactualizacion`, `horaactualizacion`) VALUES
(1, 100, '2014-11-18', '00:46:40'),
(2, 0, '2014-11-18', '00:46:41'),
(3, 0, '2014-11-18', '00:46:41'),
(4, 0, '2014-11-18', '00:46:43'),
(5, 0, '2014-11-18', '00:46:44'),
(6, 0, '2014-11-18', '00:46:44'),
(7, 0, '2014-11-18', '00:46:44'),
(8, 0, '2014-11-18', '00:46:44'),
(9, 0, '2014-11-18', '00:46:45'),
(10, 0, '2014-11-18', '00:46:45'),
(11, 0, '2014-11-18', '00:46:45'),
(12, 0, '2014-11-18', '00:46:45'),
(13, 0, '2014-11-18', '00:46:45'),
(14, 0, '2014-11-18', '00:46:45'),
(15, 0, '2014-11-18', '00:46:46'),
(16, 0, '2014-11-18', '00:46:46'),
(17, 0, '2014-11-18', '00:46:46'),
(18, 0, '2014-11-18', '00:46:46'),
(19, 40, '2014-11-18', '00:46:46'),
(20, 0, '2014-11-18', '00:46:46'),
(21, 0, '2014-11-18', '00:46:46'),
(38, 0, '2014-11-18', '00:46:47'),
(45, 0, '2014-11-18', '00:46:48'),
(46, 0, '2014-11-18', '00:46:48'),
(47, 0, '2014-11-18', '00:46:48'),
(48, 40, '2014-11-18', '00:46:48'),
(49, 0, '2014-11-18', '00:46:48'),
(50, 0, '2014-11-18', '00:46:48'),
(53, 0, '2014-11-18', '15:09:14'),
(54, 0, '2014-11-20', '12:42:01'),
(55, 0, '2014-11-20', '13:37:31'),
(56, 0, '2014-11-28', '14:57:21'),
(57, 0, '2014-11-28', '15:05:47'),
(58, 0, '2014-12-14', '11:40:32'),
(59, 0, '2014-12-14', '11:43:52'),
(60, 0, '2014-12-14', '11:44:01'),
(61, 0, '2014-12-14', '11:44:10'),
(62, 0, '2014-12-14', '11:44:33'),
(63, 0, '2014-12-14', '11:44:44'),
(64, 0, '2014-12-14', '11:44:56'),
(65, 0, '2014-12-14', '11:45:07'),
(66, 0, '2015-01-26', '12:46:24'),
(67, 0, '2015-02-19', '16:35:27'),
(68, 0, '2015-02-19', '16:49:02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadbarco`
--

CREATE TABLE IF NOT EXISTS `ciudadbarco` (
  `codigociudad` int(11) NOT NULL,
  `codigobarco` int(11) NOT NULL,
  `cantidadtotal` int(11) NOT NULL,
  `cantidaddisponible` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigociudad`,`codigobarco`),
  KEY `codigobarco` (`codigobarco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudadbarco`
--

INSERT INTO `ciudadbarco` (`codigociudad`, `codigobarco`, `cantidadtotal`, `cantidaddisponible`) VALUES
(1, 1, 8, 2),
(48, 1, 10, 3),
(56, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadedificionivel`
--

CREATE TABLE IF NOT EXISTS `ciudadedificionivel` (
  `codigociudad` int(11) NOT NULL,
  `codigoedificio` int(11) NOT NULL,
  `lugarciudad` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`codigociudad`,`codigoedificio`),
  KEY `codigoedificio` (`codigoedificio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudadedificionivel`
--

INSERT INTO `ciudadedificionivel` (`codigociudad`, `codigoedificio`, `lugarciudad`) VALUES
(1, 17, 11),
(1, 21, 6),
(1, 30, 3),
(1, 36, 8),
(1, 130, 7),
(1, 160, 4),
(1, 165, 9),
(1, 178, 12),
(1, 183, 2),
(1, 211, 13),
(1, 292, 15),
(1, 312, 14),
(1, 392, 10),
(2, 34, 6),
(2, 71, 8),
(2, 101, 3),
(2, 159, 4),
(2, 164, 9),
(2, 182, 2),
(2, 196, 12),
(2, 210, 13),
(2, 332, 10),
(3, 35, 6),
(3, 75, 8),
(3, 102, 3),
(3, 158, 4),
(3, 181, 2),
(3, 196, 12),
(3, 209, 13),
(4, 78, 8),
(4, 101, 3),
(4, 116, 6),
(4, 157, 4),
(4, 180, 2),
(4, 196, 12),
(4, 208, 13),
(5, 30, 3),
(5, 79, 8),
(5, 117, 6),
(5, 156, 4),
(5, 181, 2),
(5, 196, 12),
(5, 207, 13),
(6, 29, 3),
(6, 80, 8),
(6, 118, 6),
(6, 155, 4),
(6, 182, 2),
(6, 196, 12),
(6, 206, 13),
(6, 392, 15),
(7, 81, 8),
(7, 103, 3),
(7, 119, 6),
(7, 154, 4),
(7, 180, 2),
(7, 196, 12),
(7, 205, 13),
(8, 82, 8),
(8, 104, 3),
(8, 120, 6),
(8, 153, 4),
(8, 179, 2),
(8, 195, 12),
(8, 204, 13),
(9, 65, 2),
(9, 102, 3),
(9, 152, 4),
(9, 176, 12),
(9, 203, 13),
(10, 64, 2),
(10, 85, 8),
(10, 101, 3),
(10, 122, 7),
(10, 151, 4),
(10, 194, 12),
(10, 202, 13),
(11, 18, 8),
(11, 30, 3),
(11, 63, 2),
(11, 123, 7),
(11, 150, 4),
(11, 194, 12),
(11, 201, 13),
(12, 19, 8),
(12, 29, 3),
(12, 62, 2),
(12, 124, 7),
(12, 149, 4),
(12, 194, 12),
(12, 200, 13),
(13, 20, 8),
(13, 30, 3),
(13, 51, 9),
(13, 61, 2),
(13, 125, 7),
(13, 148, 4),
(13, 194, 12),
(13, 199, 13),
(14, 28, 3),
(14, 52, 9),
(14, 62, 2),
(14, 71, 8),
(14, 126, 7),
(14, 147, 4),
(14, 194, 12),
(14, 198, 13),
(15, 16, 10),
(15, 27, 3),
(15, 36, 9),
(15, 51, 6),
(15, 59, 12),
(15, 63, 2),
(15, 129, 7),
(15, 153, 4),
(15, 292, 8),
(16, 15, 13),
(16, 20, 8),
(16, 26, 3),
(16, 50, 4),
(16, 54, 9),
(16, 64, 2),
(16, 69, 12),
(16, 128, 7),
(17, 14, 13),
(17, 27, 3),
(17, 65, 2),
(17, 69, 12),
(17, 71, 8),
(17, 129, 7),
(17, 146, 4),
(17, 161, 9),
(18, 13, 13),
(18, 19, 8),
(18, 28, 3),
(18, 48, 4),
(18, 69, 12),
(18, 161, 9),
(18, 179, 2),
(19, 17, 15),
(19, 27, 3),
(19, 31, 14),
(19, 36, 8),
(19, 160, 4),
(19, 162, 9),
(19, 176, 12),
(19, 181, 2),
(19, 292, 7),
(19, 393, 10),
(20, 27, 3),
(20, 33, 7),
(20, 54, 9),
(20, 64, 2),
(20, 68, 12),
(20, 85, 8),
(20, 147, 4),
(20, 198, 13),
(21, 28, 3),
(21, 31, 5),
(21, 53, 9),
(21, 63, 2),
(21, 68, 12),
(21, 75, 8),
(21, 147, 4),
(21, 197, 13),
(21, 392, 7),
(38, 31, 7),
(38, 46, 4),
(45, 16, 7),
(45, 31, 13),
(45, 36, 10),
(45, 47, 4),
(45, 51, 9),
(45, 292, 11),
(45, 392, 6),
(46, 16, 5),
(46, 31, 9),
(46, 36, 13),
(46, 47, 4),
(46, 51, 7),
(46, 292, 6),
(46, 392, 11),
(47, 31, 9),
(47, 46, 4),
(47, 51, 7),
(48, 15, 8),
(48, 18, 7),
(48, 54, 13),
(48, 60, 6),
(48, 63, 2),
(48, 100, 9),
(48, 115, 3),
(48, 130, 10),
(48, 131, 11),
(48, 149, 4),
(48, 254, 14),
(48, 294, 15),
(48, 318, 5),
(48, 333, 12),
(49, 11, 7),
(49, 31, 9),
(49, 47, 4),
(49, 51, 11),
(49, 332, 13),
(49, 352, 8),
(49, 372, 10),
(49, 392, 6),
(50, 11, 9),
(50, 21, 10),
(50, 33, 14),
(50, 36, 8),
(50, 49, 4),
(50, 51, 7),
(50, 61, 2),
(50, 313, 6),
(50, 334, 15),
(50, 373, 11),
(53, 11, 13),
(53, 16, 14),
(53, 26, 3),
(53, 31, 6),
(53, 36, 5),
(53, 47, 4),
(53, 179, 2),
(53, 292, 9),
(53, 312, 15),
(53, 332, 12),
(53, 352, 10),
(53, 372, 11),
(53, 392, 8),
(54, 46, 4),
(54, 51, 9),
(55, 12, 7),
(55, 16, 5),
(55, 21, 13),
(55, 35, 11),
(55, 47, 4),
(55, 253, 6),
(56, 22, 7),
(56, 31, 9),
(56, 46, 4),
(56, 61, 2),
(57, 16, 8),
(57, 31, 9),
(57, 46, 4),
(58, 46, 4),
(58, 51, 7),
(58, 178, 8),
(59, 46, 4),
(60, 46, 4),
(61, 46, 4),
(62, 46, 4),
(63, 13, 7),
(63, 47, 4),
(63, 51, 8),
(64, 11, 12),
(64, 16, 8),
(64, 21, 9),
(64, 26, 2),
(64, 31, 10),
(64, 36, 6),
(64, 46, 4),
(64, 51, 7),
(64, 61, 3),
(64, 252, 15),
(64, 292, 13),
(64, 312, 14),
(64, 332, 11),
(64, 372, 5),
(65, 46, 4),
(66, 46, 4),
(67, 26, 2),
(67, 31, 7),
(67, 47, 4),
(67, 57, 9),
(67, 61, 3),
(68, 11, 11),
(68, 25, 8),
(68, 36, 9),
(68, 49, 4),
(68, 51, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadejercito`
--

CREATE TABLE IF NOT EXISTS `ciudadejercito` (
  `codigounidadciudad` int(11) NOT NULL AUTO_INCREMENT,
  `codigociudad` int(11) NOT NULL,
  `codigounidad` int(11) NOT NULL,
  `cantidadtotal` int(11) DEFAULT NULL,
  `cantidadsinarma` int(11) DEFAULT NULL,
  `capacidaddisponiblesinarma` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigounidadciudad`),
  UNIQUE KEY `codigociudad` (`codigociudad`,`codigounidad`),
  KEY `codigounidad` (`codigounidad`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=324 ;

--
-- Volcado de datos para la tabla `ciudadejercito`
--

INSERT INTO `ciudadejercito` (`codigounidadciudad`, `codigociudad`, `codigounidad`, `cantidadtotal`, `cantidadsinarma`, `capacidaddisponiblesinarma`) VALUES
(37, 2, 21, 500, 500, 500),
(38, 2, 24, 500, 500, 500),
(39, 2, 23, 500, 500, 500),
(40, 2, 25, 500, 500, 500),
(41, 2, 26, 500, 500, 500),
(42, 2, 27, 500, 500, 500),
(43, 2, 28, 500, 500, 500),
(44, 2, 29, 500, 500, 500),
(45, 2, 30, 500, 500, 500),
(46, 2, 31, 500, 500, 500),
(47, 2, 20, 500, 500, 500),
(48, 2, 32, 500, 500, 500),
(49, 15, 21, 500, 500, 500),
(50, 15, 24, 500, 500, 500),
(51, 15, 23, 500, 500, 500),
(52, 15, 25, 500, 500, 500),
(53, 15, 26, 500, 500, 500),
(54, 15, 27, 500, 500, 500),
(55, 15, 28, 0, 0, 0),
(56, 15, 29, 0, 0, 0),
(57, 15, 30, 0, 0, 0),
(58, 15, 31, 0, 0, 0),
(59, 15, 20, 0, 0, 0),
(60, 15, 32, 0, 0, 0),
(61, 16, 21, 500, 500, 500),
(62, 16, 24, 500, 500, 500),
(63, 16, 23, 500, 500, 500),
(64, 16, 25, 500, 500, 500),
(65, 16, 26, 500, 500, 500),
(66, 16, 27, 0, 0, 0),
(67, 16, 28, 0, 0, 0),
(68, 16, 29, 0, 0, 0),
(69, 16, 30, 0, 0, 0),
(70, 16, 31, 0, 0, 0),
(71, 16, 20, 0, 0, 0),
(72, 16, 32, 0, 0, 0),
(73, 17, 21, 500, 500, 500),
(74, 17, 24, 500, 500, 500),
(75, 17, 23, 500, 500, 500),
(76, 17, 25, 500, 500, 500),
(77, 17, 26, 0, 0, 0),
(78, 17, 27, 0, 0, 0),
(79, 17, 28, 0, 0, 0),
(80, 17, 29, 0, 0, 0),
(81, 17, 30, 0, 0, 0),
(82, 17, 31, 0, 0, 0),
(83, 17, 20, 0, 0, 0),
(84, 17, 32, 0, 0, 0),
(85, 18, 21, 500, 500, 500),
(86, 18, 24, 500, 500, 500),
(87, 18, 23, 500, 500, 500),
(88, 18, 25, 0, 0, 0),
(89, 18, 26, 0, 0, 0),
(90, 18, 27, 0, 0, 0),
(91, 18, 28, 0, 0, 0),
(92, 18, 29, 0, 0, 0),
(93, 18, 30, 0, 0, 0),
(94, 18, 31, 0, 0, 0),
(95, 18, 20, 0, 0, 0),
(96, 18, 32, 0, 0, 0),
(97, 9, 21, 500, 500, 500),
(98, 9, 24, 500, 500, 500),
(99, 9, 23, 500, 500, 500),
(100, 9, 25, 500, 500, 500),
(101, 9, 26, 500, 500, 500),
(102, 9, 27, 500, 500, 500),
(103, 9, 28, 500, 500, 500),
(104, 9, 29, 500, 500, 500),
(105, 9, 30, 500, 500, 500),
(106, 9, 31, 500, 500, 500),
(107, 9, 20, 0, 0, 0),
(108, 9, 32, 0, 0, 0),
(109, 10, 21, 500, 500, 500),
(110, 10, 24, 500, 500, 500),
(111, 10, 23, 500, 500, 500),
(112, 10, 25, 500, 500, 500),
(113, 10, 26, 500, 500, 500),
(114, 10, 27, 500, 500, 500),
(115, 10, 28, 500, 500, 500),
(116, 10, 29, 500, 500, 500),
(117, 10, 30, 500, 500, 500),
(118, 10, 31, 500, 500, 500),
(119, 10, 20, 0, 0, 0),
(120, 10, 32, 0, 0, 0),
(121, 11, 21, 500, 500, 500),
(122, 11, 24, 500, 500, 500),
(123, 11, 23, 500, 500, 500),
(124, 11, 25, 500, 500, 500),
(125, 11, 26, 500, 500, 500),
(126, 11, 27, 500, 500, 500),
(127, 11, 28, 500, 500, 500),
(128, 11, 29, 500, 500, 500),
(129, 11, 30, 500, 500, 500),
(130, 11, 31, 500, 500, 500),
(131, 11, 20, 0, 0, 0),
(132, 11, 32, 0, 0, 0),
(133, 12, 21, 500, 500, 500),
(134, 12, 24, 500, 500, 500),
(135, 12, 23, 500, 500, 500),
(136, 12, 25, 500, 500, 500),
(137, 12, 26, 500, 500, 500),
(138, 12, 27, 500, 500, 500),
(139, 12, 28, 500, 500, 500),
(140, 12, 29, 500, 500, 500),
(141, 12, 30, 500, 500, 500),
(142, 12, 31, 0, 0, 0),
(143, 12, 20, 0, 0, 0),
(144, 12, 32, 0, 0, 0),
(145, 13, 21, 500, 500, 500),
(146, 13, 24, 500, 500, 500),
(147, 13, 23, 500, 500, 500),
(148, 13, 25, 500, 500, 500),
(149, 13, 26, 500, 500, 500),
(150, 13, 27, 500, 500, 500),
(151, 13, 28, 500, 500, 500),
(152, 13, 29, 500, 500, 500),
(153, 13, 30, 0, 0, 0),
(154, 13, 31, 0, 0, 0),
(155, 13, 20, 0, 0, 0),
(156, 13, 32, 0, 0, 0),
(157, 14, 21, 500, 500, 500),
(158, 14, 24, 500, 500, 500),
(159, 14, 23, 500, 500, 500),
(160, 14, 25, 500, 500, 500),
(161, 14, 26, 500, 500, 500),
(162, 14, 27, 500, 500, 500),
(163, 14, 28, 500, 500, 500),
(164, 14, 29, 0, 0, 0),
(165, 14, 30, 0, 0, 0),
(166, 14, 31, 0, 0, 0),
(167, 14, 20, 0, 0, 0),
(168, 14, 32, 0, 0, 0),
(169, 4, 21, 500, 500, 500),
(170, 4, 24, 500, 500, 500),
(171, 4, 23, 500, 500, 500),
(172, 4, 25, 500, 500, 500),
(173, 4, 26, 500, 500, 500),
(174, 4, 27, 500, 500, 500),
(175, 4, 28, 500, 500, 500),
(176, 4, 29, 500, 500, 500),
(177, 4, 30, 500, 500, 500),
(178, 4, 31, 500, 500, 500),
(179, 4, 20, 500, 500, 500),
(180, 4, 32, 500, 500, 500),
(181, 3, 21, 500, 500, 500),
(182, 3, 24, 500, 500, 500),
(183, 3, 23, 500, 500, 500),
(184, 3, 25, 500, 0, 0),
(185, 3, 26, 500, 500, 500),
(186, 3, 27, 500, 500, 500),
(187, 3, 28, 500, 500, 500),
(188, 3, 29, 500, 500, 500),
(189, 3, 30, 500, 500, 500),
(190, 3, 31, 500, 500, 500),
(191, 3, 20, 500, 500, 500),
(192, 3, 32, 500, 500, 500),
(193, 19, 21, 520, 520, 470),
(194, 19, 24, 500, 500, 500),
(195, 19, 23, 500, 500, 450),
(196, 19, 25, 500, 500, 300),
(197, 19, 26, 500, 500, 500),
(198, 19, 27, 500, 500, 500),
(199, 19, 28, 0, 0, 0),
(200, 19, 29, 0, 0, 0),
(201, 19, 30, 0, 0, 0),
(202, 19, 31, 0, 0, 0),
(203, 19, 20, 0, 0, 0),
(204, 19, 32, 0, 0, 0),
(205, 20, 21, 500, 500, 500),
(206, 20, 24, 500, 500, 500),
(207, 20, 23, 500, 500, 500),
(208, 20, 25, 500, 500, 500),
(209, 20, 26, 500, 500, 500),
(210, 20, 27, 500, 500, 500),
(211, 20, 28, 500, 500, 500),
(212, 20, 29, 0, 0, 0),
(213, 20, 30, 0, 0, 0),
(214, 20, 31, 0, 0, 0),
(215, 20, 20, 0, 0, 0),
(216, 20, 32, 0, 0, 0),
(217, 21, 21, 500, 500, 500),
(218, 21, 24, 500, 500, 500),
(219, 21, 23, 500, 500, 500),
(220, 21, 25, 500, 500, 500),
(221, 21, 26, 500, 500, 500),
(222, 21, 27, 500, 500, 500),
(223, 21, 28, 0, 0, 0),
(224, 21, 29, 0, 0, 0),
(225, 21, 30, 0, 0, 0),
(226, 21, 31, 0, 0, 0),
(227, 21, 20, 0, 0, 0),
(228, 21, 32, 0, 0, 0),
(229, 1, 21, 543, 543, 543),
(230, 1, 24, 510, 510, 510),
(231, 1, 23, 510, 510, 510),
(232, 1, 25, 500, 188, -72),
(233, 1, 26, 500, 500, 500),
(234, 1, 27, 500, 500, 500),
(235, 1, 28, 500, 488, 488),
(236, 1, 29, 500, 500, 500),
(237, 1, 30, 500, 500, 500),
(238, 1, 31, 500, 500, 500),
(239, 1, 20, 510, 510, 510),
(240, 1, 32, 510, 510, 510),
(241, 5, 21, 500, 500, 500),
(242, 5, 24, 500, 500, 500),
(243, 5, 23, 500, 500, 500),
(244, 5, 25, 500, 500, 500),
(245, 5, 26, 500, 500, 500),
(246, 5, 27, 500, 500, 500),
(247, 5, 28, 500, 500, 500),
(248, 5, 29, 500, 500, 500),
(249, 5, 30, 500, 500, 500),
(250, 5, 31, 500, 500, 500),
(251, 5, 20, 500, 500, 500),
(252, 5, 32, 0, 0, 0),
(253, 6, 21, 500, 500, 500),
(254, 6, 24, 500, 500, 500),
(255, 6, 23, 500, 500, 500),
(256, 6, 25, 500, 500, 500),
(257, 6, 26, 500, 500, 500),
(258, 6, 27, 500, 500, 500),
(259, 6, 28, 500, 500, 500),
(260, 6, 29, 500, 500, 500),
(261, 6, 30, 500, 500, 500),
(262, 6, 31, 500, 500, 500),
(263, 6, 20, 500, 500, 500),
(264, 6, 32, 0, 0, 0),
(265, 8, 21, 500, 500, 500),
(266, 8, 24, 500, 500, 500),
(267, 8, 23, 500, 500, 500),
(268, 8, 25, 500, 500, 500),
(269, 8, 26, 500, 500, 500),
(270, 8, 27, 500, 500, 500),
(271, 8, 28, 500, 500, 500),
(272, 8, 29, 500, 500, 500),
(273, 8, 30, 500, 500, 500),
(274, 8, 31, 500, 500, 500),
(275, 8, 20, 0, 0, 0),
(276, 8, 32, 0, 0, 0),
(277, 7, 21, 500, 500, 500),
(278, 7, 24, 500, 500, 500),
(279, 7, 23, 500, 500, 500),
(280, 7, 25, 500, 500, 500),
(281, 7, 26, 500, 500, 500),
(282, 7, 27, 500, 500, 500),
(283, 7, 28, 500, 500, 500),
(284, 7, 29, 500, 500, 500),
(285, 7, 30, 500, 500, 500),
(286, 7, 31, 500, 500, 500),
(287, 7, 20, 0, 0, 0),
(288, 7, 32, 0, 0, 0),
(289, 19, 33, 20, 10, 10),
(290, 48, 21, 22, 22, 22),
(291, 48, 24, 22, 20, 20),
(292, 48, 36, 13, 3, 3),
(293, 48, 34, 34, 29, 29),
(294, 48, 37, 5, 5, 5),
(295, 48, 38, 1, 1, 1),
(296, 48, 39, 1, 1, 1),
(297, 48, 33, 12, 6, 6),
(298, 48, 35, 11, 9, 9),
(299, 48, 40, 20, 16, 16),
(300, 48, 23, 20, 10, 10),
(301, 48, 25, 50, 8, 8),
(302, 48, 26, 20, 20, 20),
(303, 48, 27, 20, 17, 17),
(304, 48, 28, 10, 10, 10),
(305, 48, 29, 20, 13, 13),
(306, 48, 30, 20, 0, 0),
(307, 48, 31, 20, 20, 20),
(308, 48, 32, 10, 8, 8),
(309, 48, 20, 42, 42, 39),
(310, 53, 21, 25, 15, 15),
(311, 53, 24, 20, 20, 20),
(312, 53, 34, 10, 10, 10),
(313, 53, 36, 10, 10, 10),
(314, 1, 34, 24, 24, 24),
(315, 1, 35, 12, 12, 12),
(316, 1, 36, 12, 12, 12),
(317, 1, 37, 12, 12, 12),
(318, 1, 39, 12, 12, 12),
(319, 50, 23, 100, 50, 50),
(320, 55, 21, 50, 50, 50),
(321, 55, 26, 30, 25, 25),
(322, 56, 21, 5, 4, 4),
(323, 67, 24, 8, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadejercitoarma`
--

CREATE TABLE IF NOT EXISTS `ciudadejercitoarma` (
  `codigounidadciudad` int(11) NOT NULL DEFAULT '0',
  `codigoarma` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `cantidaddisponibleciudad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigounidadciudad`,`codigoarma`),
  KEY `codigoarma` (`codigoarma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudadejercitoarma`
--

INSERT INTO `ciudadejercitoarma` (`codigounidadciudad`, `codigoarma`, `cantidad`, `cantidaddisponibleciudad`) VALUES
(232, 1, 100, 100),
(232, 5, 100, 100),
(232, 7, 0, 0),
(235, 2, 12, 12),
(300, 13, 10, 0),
(301, 1, 38, 35),
(303, 21, 3, 0),
(305, 10, 7, 4),
(310, 11, 10, 10),
(319, 11, 50, 50),
(321, 15, 5, 5),
(322, 11, 1, 1),
(323, 23, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadproduccion`
--

CREATE TABLE IF NOT EXISTS `ciudadproduccion` (
  `codigociudad` int(11) NOT NULL DEFAULT '0',
  `codigorecurso` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `cantidadhora` int(11) DEFAULT '0',
  `fechaactualizacion` date DEFAULT NULL,
  `horaactualizacion` time DEFAULT NULL,
  PRIMARY KEY (`codigociudad`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`),
  KEY `fechaactualizacion` (`fechaactualizacion`,`horaactualizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudadproduccion`
--

INSERT INTO `ciudadproduccion` (`codigociudad`, `codigorecurso`, `cantidadhora`, `fechaactualizacion`, `horaactualizacion`) VALUES
(1, 6, 0, '2014-12-14', '12:05:15'),
(19, 6, 0, '2014-12-14', '12:05:15'),
(48, 6, 685, '2014-12-14', '12:05:15'),
(48, 9, 175, '2014-12-14', '12:05:45'),
(50, 6, 0, '2014-12-14', '12:05:15'),
(53, 6, 375, '2014-12-14', '12:05:15'),
(53, 12, 375, '2014-12-14', '12:05:53'),
(56, 6, 42, '2014-12-14', '12:05:15'),
(56, 9, 52, '2014-12-14', '12:05:45'),
(58, 6, 250, '2014-12-14', '12:05:15'),
(58, 9, 250, '2014-12-14', '12:05:45'),
(59, 6, 250, '2014-12-14', '12:05:15'),
(59, 9, 250, '2014-12-14', '12:05:45'),
(60, 6, 248, '2014-12-14', '12:05:15'),
(60, 12, 250, '2014-12-14', '12:05:53'),
(61, 6, 250, '2014-12-14', '12:05:15'),
(61, 12, 250, '2014-12-14', '12:05:53'),
(62, 6, 250, '2014-12-14', '12:05:15'),
(62, 9, 250, '2014-12-14', '12:05:45'),
(63, 6, 250, '2014-12-14', '12:05:15'),
(63, 12, 250, '2014-12-14', '12:05:53'),
(64, 6, 250, '2014-12-14', '12:05:15'),
(64, 9, 250, '2014-12-14', '12:05:45'),
(65, 6, 250, '2014-12-14', '12:05:15'),
(65, 12, 250, '2014-12-14', '12:05:53');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadrecurso`
--

CREATE TABLE IF NOT EXISTS `ciudadrecurso` (
  `codigociudad` int(11) NOT NULL,
  `codigorecurso` tinyint(3) unsigned NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fechaactualizacion` date DEFAULT NULL,
  `horaactualizacion` time DEFAULT NULL,
  PRIMARY KEY (`codigociudad`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`),
  KEY `codigociudad` (`codigociudad`,`codigorecurso`,`fechaactualizacion`,`horaactualizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudadrecurso`
--

INSERT INTO `ciudadrecurso` (`codigociudad`, `codigorecurso`, `cantidad`, `fechaactualizacion`, `horaactualizacion`) VALUES
(1, 6, 50000, '2001-00-00', '01:00:00'),
(1, 9, 50000, '2014-10-23', '14:35:12'),
(1, 12, 50000, '2014-10-26', '00:36:47'),
(1, 14, 50000, '2014-10-26', '00:36:48'),
(1, 15, 50000, '2014-10-26', '00:36:49'),
(2, 6, 50000, '2014-10-26', '00:36:45'),
(2, 9, 50000, '2014-10-26', '00:36:46'),
(2, 12, 50000, '2014-10-26', '00:36:47'),
(2, 14, 50000, '2014-10-26', '00:36:48'),
(2, 15, 50000, '2014-10-26', '00:36:49'),
(3, 6, 50000, '2014-10-26', '00:36:45'),
(3, 9, 50000, '2014-10-26', '00:36:46'),
(3, 12, 50000, '2014-10-26', '00:36:47'),
(3, 14, 50000, '2014-10-26', '00:36:48'),
(3, 15, 50000, '2014-10-26', '00:36:48'),
(4, 6, 50000, '2014-10-26', '00:36:45'),
(4, 9, 50000, '2014-10-26', '00:36:46'),
(4, 12, 50000, '2014-10-26', '00:36:47'),
(4, 14, 50000, '2014-10-26', '00:36:48'),
(4, 15, 50000, '2014-10-26', '00:36:48'),
(5, 6, 50000, '2014-10-26', '00:36:45'),
(5, 9, 50000, '2014-10-26', '00:36:46'),
(5, 12, 50000, '2014-10-26', '00:36:47'),
(5, 14, 50000, '2014-10-26', '00:36:48'),
(5, 15, 50000, '2014-10-26', '00:36:48'),
(6, 6, 50000, '2014-10-26', '00:36:45'),
(6, 9, 50000, '2014-10-26', '00:36:46'),
(6, 12, 50000, '2014-10-26', '00:36:47'),
(6, 14, 50000, '2014-10-26', '00:36:48'),
(6, 15, 50000, '2014-10-26', '00:36:48'),
(7, 6, 50000, '2014-10-26', '00:36:45'),
(7, 9, 50000, '2014-10-26', '00:36:46'),
(7, 12, 50000, '2014-10-26', '00:36:47'),
(7, 14, 50000, '2014-10-26', '00:36:48'),
(7, 15, 50000, '2014-10-26', '00:36:48'),
(8, 6, 50000, '2014-10-26', '00:36:45'),
(8, 9, 50000, '2014-10-26', '00:36:46'),
(8, 12, 50000, '2014-10-26', '00:36:47'),
(8, 14, 50000, '2014-10-26', '00:36:48'),
(8, 15, 50000, '2014-10-26', '00:36:48'),
(9, 6, 50000, '2014-10-26', '00:36:45'),
(9, 9, 50000, '2014-10-26', '00:36:46'),
(9, 12, 50000, '2014-10-26', '00:36:47'),
(9, 14, 50000, '2014-10-26', '00:36:48'),
(9, 15, 50000, '2014-10-26', '00:36:48'),
(10, 6, 50000, '2014-10-26', '00:36:45'),
(10, 9, 50000, '2014-10-26', '00:36:46'),
(10, 12, 50000, '2014-10-26', '00:36:47'),
(10, 14, 50000, '2014-10-26', '00:36:47'),
(10, 15, 50000, '2014-10-26', '00:36:48'),
(11, 6, 50000, '2014-10-26', '00:36:45'),
(11, 9, 50000, '2014-10-26', '00:36:46'),
(11, 12, 50000, '2014-10-26', '00:36:47'),
(11, 14, 50000, '2014-10-26', '00:36:47'),
(11, 15, 50000, '2014-10-26', '00:36:48'),
(12, 6, 50000, '2014-10-26', '00:36:45'),
(12, 9, 50000, '2014-10-26', '00:36:46'),
(12, 12, 50000, '2014-10-26', '00:36:46'),
(12, 14, 50000, '2014-10-26', '00:36:47'),
(12, 15, 50000, '2014-10-26', '00:36:48'),
(13, 6, 50000, '2014-10-26', '00:36:45'),
(13, 9, 50000, '2014-10-26', '00:36:45'),
(13, 12, 50000, '2014-10-26', '00:36:46'),
(13, 14, 50000, '2014-10-26', '00:36:47'),
(13, 15, 50000, '2014-10-26', '00:36:48'),
(14, 6, 50000, '2014-10-26', '00:36:44'),
(14, 9, 50000, '2014-10-26', '00:36:45'),
(14, 12, 50000, '2014-10-26', '00:36:46'),
(14, 14, 50000, '2014-10-26', '00:36:47'),
(14, 15, 50000, '2014-10-26', '00:36:48'),
(15, 6, 50000, '2014-10-26', '00:36:44'),
(15, 9, 50000, '2014-10-26', '00:36:45'),
(15, 12, 50000, '2014-10-26', '00:36:46'),
(15, 14, 50000, '2014-10-26', '00:36:47'),
(15, 15, 50000, '2014-10-26', '00:36:48'),
(16, 6, 50000, '2014-10-26', '00:36:44'),
(16, 9, 50000, '2014-10-26', '00:36:45'),
(16, 12, 50000, '2014-10-26', '00:36:46'),
(16, 14, 50000, '2014-10-26', '00:36:47'),
(16, 15, 50000, '2014-10-26', '00:36:48'),
(17, 6, 50000, '2014-10-26', '00:36:44'),
(17, 9, 50000, '2014-10-26', '00:36:45'),
(17, 12, 50000, '2014-10-26', '00:36:46'),
(17, 14, 50000, '2014-10-26', '00:36:47'),
(17, 15, 50000, '2014-10-26', '00:36:48'),
(18, 6, 50000, '2014-10-26', '00:36:44'),
(18, 9, 50000, '2014-10-26', '00:36:45'),
(18, 12, 50000, '2014-10-26', '00:36:46'),
(18, 14, 50000, '2014-10-26', '00:36:47'),
(18, 15, 50000, '2014-10-26', '00:36:48'),
(19, 6, 50000, '2014-10-26', '00:36:44'),
(19, 9, 50000, '2014-10-26', '00:36:45'),
(19, 12, 50000, '2014-10-26', '00:36:46'),
(19, 14, 50000, '2014-10-26', '00:36:47'),
(19, 15, 50000, '2014-10-26', '00:36:48'),
(20, 6, 50000, '2014-10-26', '00:36:45'),
(20, 9, 50000, '2014-10-26', '00:36:45'),
(20, 12, 50000, '2014-10-26', '00:36:46'),
(20, 14, 50000, '2014-10-26', '00:36:47'),
(20, 15, 50000, '2014-10-26', '00:36:48'),
(21, 6, 50000, '2014-10-26', '00:36:44'),
(21, 9, 50000, '2014-10-26', '00:36:45'),
(21, 12, 50000, '2014-10-26', '00:36:46'),
(21, 14, 50000, '2014-10-26', '00:36:47'),
(21, 15, 50000, '2014-10-26', '00:36:48'),
(38, 6, 50000, '2014-10-31', '02:31:37'),
(38, 9, 50000, '2014-10-31', '02:31:37'),
(38, 12, 50000, '2014-10-31', '02:31:37'),
(38, 14, 50000, '2014-10-31', '02:31:37'),
(38, 15, 50000, '2014-10-31', '02:31:37'),
(45, 6, 50000, '2014-11-10', '09:12:30'),
(45, 9, 50000, '2014-11-10', '09:12:30'),
(45, 12, 50000, '2014-11-10', '09:12:30'),
(45, 14, 50000, '2014-11-10', '09:12:30'),
(45, 15, 50000, '2014-11-10', '09:12:30'),
(46, 6, 50000, '2014-11-10', '09:26:12'),
(46, 9, 50000, '2014-11-10', '09:26:12'),
(46, 12, 50000, '2014-11-10', '09:26:12'),
(46, 14, 50000, '2014-11-10', '09:26:12'),
(46, 15, 50000, '2014-11-10', '09:26:12'),
(47, 6, 50000, '2014-11-10', '09:28:27'),
(47, 9, 50000, '2014-11-10', '09:28:27'),
(47, 12, 50000, '2014-11-10', '09:28:27'),
(47, 14, 50000, '2014-11-10', '09:28:27'),
(47, 15, 50000, '2014-11-10', '09:28:27'),
(48, 6, 50000, '2014-11-12', '00:09:47'),
(48, 9, 50000, '2014-11-12', '00:09:47'),
(48, 12, 50000, '2014-11-12', '00:09:47'),
(48, 14, 50000, '2014-11-12', '00:09:47'),
(48, 15, 50000, '2014-11-12', '00:09:47'),
(49, 6, 50000, '2014-11-12', '00:48:48'),
(49, 9, 50000, '2014-11-12', '00:48:48'),
(49, 12, 50000, '2014-11-12', '00:48:48'),
(49, 14, 50000, '2014-11-12', '00:48:48'),
(49, 15, 50000, '2014-11-12', '00:48:48'),
(50, 6, 50000, '2014-11-12', '00:54:10'),
(50, 9, 50000, '2014-11-12', '00:54:10'),
(50, 12, 50000, '2014-11-12', '00:54:10'),
(50, 14, 50000, '2014-11-12', '00:54:10'),
(50, 15, 50000, '2014-11-12', '00:54:10'),
(53, 6, 50000, '2014-11-18', '15:09:14'),
(53, 9, 50000, '2014-11-18', '15:09:14'),
(53, 12, 50000, '2014-11-18', '15:09:14'),
(53, 14, 50000, '2014-11-18', '15:09:14'),
(53, 15, 50000, '2014-11-18', '15:09:14'),
(54, 6, 50000, '2014-11-20', '12:42:01'),
(54, 9, 50000, '2014-11-20', '12:42:01'),
(54, 12, 50000, '2014-11-20', '12:42:01'),
(54, 14, 50000, '2014-11-20', '12:42:01'),
(54, 15, 50000, '2014-11-20', '12:42:01'),
(55, 6, 50000, '2014-11-20', '13:37:31'),
(55, 9, 50000, '2014-11-20', '13:37:31'),
(55, 12, 50000, '2014-11-20', '13:37:31'),
(55, 14, 50000, '2014-11-20', '13:37:31'),
(55, 15, 50000, '2014-11-20', '13:37:31'),
(56, 6, 50000, '2014-11-28', '14:57:21'),
(56, 9, 50000, '2014-11-28', '14:57:21'),
(56, 12, 50000, '2014-11-28', '14:57:21'),
(56, 14, 50000, '2014-11-28', '14:57:21'),
(56, 15, 50000, '2014-11-28', '14:57:21'),
(57, 6, 50000, '2014-11-28', '15:05:47'),
(57, 9, 50000, '2014-11-28', '15:05:47'),
(57, 12, 50000, '2014-11-28', '15:05:47'),
(57, 14, 50000, '2014-11-28', '15:05:47'),
(57, 15, 50000, '2014-11-28', '15:05:47'),
(58, 6, 49952, '2014-12-14', '11:40:33'),
(58, 9, 671, '2014-12-14', '11:40:33'),
(58, 12, 50000, '2014-12-14', '11:40:33'),
(58, 14, 50000, '2014-12-14', '11:40:33'),
(58, 15, 50000, '2014-12-14', '11:40:33'),
(59, 6, 50000, '2014-12-14', '11:43:52'),
(59, 9, 50000, '2014-12-14', '11:43:52'),
(59, 12, 50000, '2014-12-14', '11:43:52'),
(59, 14, 50000, '2014-12-14', '11:43:52'),
(59, 15, 50000, '2014-12-14', '11:43:52'),
(60, 6, 50000, '2014-12-14', '11:44:01'),
(60, 9, 50000, '2014-12-14', '11:44:01'),
(60, 12, 50000, '2014-12-14', '11:44:01'),
(60, 14, 50000, '2014-12-14', '11:44:01'),
(60, 15, 50000, '2014-12-14', '11:44:01'),
(61, 6, 50000, '2014-12-14', '11:44:10'),
(61, 9, 50000, '2014-12-14', '11:44:10'),
(61, 12, 50000, '2014-12-14', '11:44:10'),
(61, 14, 50000, '2014-12-14', '11:44:10'),
(61, 15, 50000, '2014-12-14', '11:44:10'),
(62, 6, 50000, '2014-12-14', '11:44:33'),
(62, 9, 50000, '2014-12-14', '11:44:33'),
(62, 12, 50000, '2014-12-14', '11:44:33'),
(62, 14, 50000, '2014-12-14', '11:44:33'),
(62, 15, 50000, '2014-12-14', '11:44:33'),
(63, 6, 50000, '2014-12-14', '11:44:44'),
(63, 9, 50000, '2014-12-14', '11:44:44'),
(63, 12, 50000, '2014-12-14', '11:44:44'),
(63, 14, 50000, '2014-12-14', '11:44:44'),
(63, 15, 50000, '2014-12-14', '11:44:44'),
(64, 6, 50000, '2014-12-14', '11:44:56'),
(64, 9, 50000, '2014-12-14', '11:44:56'),
(64, 12, 50000, '2014-12-14', '11:44:56'),
(64, 14, 50000, '2014-12-14', '11:44:56'),
(64, 15, 50000, '2014-12-14', '11:44:56'),
(65, 6, 50000, '2014-12-14', '11:45:07'),
(65, 9, 50000, '2014-12-14', '11:45:07'),
(65, 12, 50000, '2014-12-14', '11:45:07'),
(65, 14, 50000, '2014-12-14', '11:45:07'),
(65, 15, 50000, '2014-12-14', '11:45:07'),
(66, 6, 50000, '2015-01-26', '12:46:24'),
(66, 9, 50000, '2015-01-26', '12:46:24'),
(66, 12, 50000, '2015-01-26', '12:46:24'),
(66, 14, 50000, '2015-01-26', '12:46:24'),
(66, 15, 50000, '2015-01-26', '12:46:24'),
(67, 6, 49340, '2015-02-19', '16:35:27'),
(67, 9, 49790, '2015-02-19', '16:35:27'),
(67, 12, 50000, '2015-02-19', '16:35:27'),
(67, 14, 50000, '2015-02-19', '16:35:27'),
(67, 15, 50000, '2015-02-19', '16:35:27'),
(68, 6, 39561, '2015-02-19', '16:49:02'),
(68, 9, 91783, '2015-02-19', '16:49:02'),
(68, 12, 41216, '2015-02-19', '16:49:02'),
(68, 14, 50000, '2015-02-19', '16:49:02'),
(68, 15, 42313, '2015-02-19', '16:49:02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadtaberna`
--

CREATE TABLE IF NOT EXISTS `ciudadtaberna` (
  `codigociudad` int(11) NOT NULL DEFAULT '0',
  `cantidadvinoservido` int(11) DEFAULT '0',
  `fechaactualizacion` date DEFAULT NULL,
  `horaactualizacion` time DEFAULT NULL,
  PRIMARY KEY (`codigociudad`),
  KEY `fechaactualizacion` (`fechaactualizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudadtaberna`
--

INSERT INTO `ciudadtaberna` (`codigociudad`, `cantidadvinoservido`, `fechaactualizacion`, `horaactualizacion`) VALUES
(1, 0, '2014-11-18', '00:46:41'),
(4, 0, '2014-11-18', '00:46:41'),
(6, 0, '2014-11-18', '00:46:41'),
(15, 0, '2014-11-18', '00:46:42'),
(19, 0, '2014-11-18', '00:46:42'),
(48, 30, '2014-11-18', '00:46:42'),
(49, 0, '2014-11-18', '00:46:43'),
(55, 28, '2014-11-20', '13:38:53'),
(63, 90, '2014-12-14', '12:06:49');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depositomercado`
--

CREATE TABLE IF NOT EXISTS `depositomercado` (
  `codigojugador` int(11) NOT NULL DEFAULT '0',
  `codigorecurso` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigojugador`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `depositomercado`
--

INSERT INTO `depositomercado` (`codigojugador`, `codigorecurso`, `cantidad`) VALUES
(9, 6, 78),
(9, 15, 67677),
(40, 6, 36645),
(40, 9, 9000),
(40, 14, 35706),
(43, 6, 49329),
(45, 9, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `edificio`
--

CREATE TABLE IF NOT EXISTS `edificio` (
  `codigoedificio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `codigoimagen` int(11) DEFAULT NULL,
  `costo` float DEFAULT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`codigoedificio`),
  KEY `codigoimagen` (`codigoimagen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Volcado de datos para la tabla `edificio`
--

INSERT INTO `edificio` (`codigoedificio`, `nombre`, `codigoimagen`, `costo`, `descripcion`) VALUES
(1, 'Taberna', 12, 50, 'Despu?s de un d?a de arduo trabajo no hay nada m?s reconfortante que un fresco jarro lleno de Vino. Es por eso que los Ciudadanos se re?nen en la Taberna. Cuando cae la noche y ya no quedan m?s canciones por cantar emprenden la vuelta serenos y alegres a sus hogares. Cada ampliaci?n en tu Taberna te permite servir m?s Vino y, as?, aumentar la Satisfacci?n.'),
(2, 'Academia', 1, 100, 'La Academia en Ikariam es la meca de la sabidur?a, donde el conocimiento arraigado en la tradici?n se funde con las m?s modernas t?cnicas. ?Las mentes m?s inteligentes de tu ciudad esperan ser aceptadas! Ten en consideraci?n que cada investigador necesita un laboratorio, lo cual genera gastos.'),
(3, 'Almacen', 2, 20, 'El Almac?n en Ikariam te permite almacenar mayores cantidades de Recursos. Cada nivel de ampliaci?n puede contener 32,000 unidades de cada tipo de Recurso. No obstante, el Almac?n no est? protegido contra Saqueos. Para construir el Almac?n, es necesario haber completado la Investigaci?n de Almac?n '),
(4, 'Astillero de Guerra', 3, 150, '?Que ser?a de un imperio situado en una isla sin su flota? ?En el astillero de guerra se construyen y reparan las m?s poderosas naves de guerra que surcar?n los 7 mares estremeciendo sus alrededores! Astilleros de Guerra m?s grandes permiten construir m?s r?pido los barcos.Es necesario investigar Carenero.'),
(5, 'Cuartel', 4, 120, 'En el Cuartel de Ikariam, los j?venes m?s impetuosos son adiestrados como audaces guerreros. Tus soldados dominan el arte de la espada, la lanza y la catapulta. Adem?s saben maniobrar las m?s poderosas m?quinas de guerra en el campo de Batalla. Si amplias el Cuartel, el tiempo necesario para instruir a tus soldados disminuir?.'),
(6, 'Deposito', 5, 50, 'El Dep?sito en Ikariam te permite almacenar Recursos en tu ciudad aunque solo una parte de tus suministros se protegen all?. Son protegidos de infames saqueos, como tambi?n de las tormentas, p?jaros y par?sitos.'),
(7, 'Embajada', 6, 70, 'La Embajada de Ikariam es un sitio din?mico: Diplom?ticos de todo el mundo pactan aqu? tratados y forjan Alianzas. Para que tu Alianza crezca, debes ampliar tu Embajada. Por cada ampliaci?n aumentan tus puntos de diplomacia. A partir del 3? nivel puedes fundar una Alianza'),
(8, 'Intendencia', 7, 175, 'En el coraz?n de la ciudad se halla la Intendencia de Ikariam. Con ella crece y se desarrolla la ciudad, sus id?neos funcionarios brindan a todo momento informaci?n actualizada acerca de los habitantes locales.'),
(9, 'Mercado', 8, 50, 'Mercaderes y comerciantes hacen sus negocios en la Tienda. All? se cierra siempre alguna que otra transacci?n o se encuentran ofertas, buenas oportunidades. ?Mercaderes de tierras lejanas dirigen afamadas y colosales Tiendas!Cada dos ampliaciones se extiende el radio de b?squeda de tu Tienda.En la Tienda puedes comprar y vender los Recursos que necesites, con el Oro como moneda de cambio, con otros jugadores cercanos. '),
(10, 'Palacio', 9, 350, 'Desde el Palacio de Ikariam puedes conducir el destino de tu imperio. As? mismo te ofrece una vista maravillosa hacia el mar. Cada ampliaci?n realizada en el Palacio de tu Capital, te permite fundar una nueva colonia. '),
(11, 'Puerto', 10, 100, 'El puerto, lugar de origen con rumbo hacia el mundo. Aqu? puedes reclutar Barcos Mercantes y prepararlos para viajes a lugares lejanos. Asimismo puedes recibir bienes preciosos de todo el mundo. En Puertos m?s grandes, los barcos son cargados m?s r?pido.'),
(12, 'Residencia del Gobernador', 11, 350, 'Un gobernador en tu colonia garantiza que todos los asuntos administrativos diarios est?n al d?a. Adem?s, reduce el nivel de Corrupci?n en tu colonia. La Residencia del Gobernador puede ser ampliada a Palacio por si quieres trasladar tu Capital.'),
(23, 'Cabaña del guarda Bosque', 89, 75, 'Caba?a del GuardabosquesLos fuertes le?adores pueden cortar incluso los ?rboles m?s grandes. Pero ellos tambi?n saben que un bosque debe ser cultivado con la ayuda de la Caba?a del Guardabosques y nuevos ?rboles deben ser plantados, de modo que nosotros podamos seguir usando s?lo los mejores bosques para nuestras casas.;La producci?n de Madera aumenta un 2% por cada nivel de ampliaci?n del edificio (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolecci?n de Recursos (Econom?a) para poder construir este edificio.'),
(24, 'Cantero', 54, 80, 'Un cantero bien entrenado siempre rompe con sus brazos fuertes los mejores bloques de m?rmol As? no se rompen muchas bloques y nuestros constructores tienen siempre el material que necesitan.;La producci?n de M?rmol aumenta un 2% por cada nivel de extensi?n (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolecci?n de Recursos (Econom?a) para poder construir este edificio.'),
(25, 'Soplador de Vidrio', 55, 80, 'Los verdaderos maestros de su arte crean pedazos brillantes en la casa del Soplador de Vidrio. Soplan tubos, cristales y todo tipo de aparatos que s?lo nuestros cient?ficos entienden. Y son tan diestros, que las cosas se rompen s?lo muy de vez en cuando.;La producci?n de Cristal aumenta un 2% por cada nivel de extensi?n (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolecci?n de Recursos (Econom?a) para poder construir el Soplador de Vidrio.'),
(26, 'Torre del Alquimista', 56, 80, 'Cuando el viento del Oeste sopla, un olor llena las calles alrededor de la Torre del Alquimista y son muchos los Ciudadanos que abandonan sus hogares con una mota en su nariz. Nuestros alquimistas trabajan sin descanso para encontrar la mezcla perfecta y as? procurar sacar m?s Azufre del volc?n.;La producci?n de Azufre aumenta un 2% por cada nivel de ampliaci?n (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolecci?n de Recursos (Econom?a) para poder construir la Torre del Alquimista.'),
(27, 'Vinicultor', 57, 80, 'Vinicultor habilidoso escoge s?lo colinas soleadas para cubrirlas con el verde de la vid. As? es como los Vi?edos producen mejores uvas para una excelente cosecha.;La producci?n de Vino aumenta un 2% por cada nivel de ampliaci?n (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolecci?n de Recursos (Econom?a) para poder construir el Vinicultor.'),
(28, 'Carpinteria', 58, 80, 'S?lo la mejor Madera es elaborada en el taller del Carpintero. Por lo tanto nuestros habilidosos artesanos son capaces de construir un marco s?lido y nuestras casas no tienen que ser reparadas todo el tiempo. ;Cada nivel de la Carpinter?a reduce la demanda de Madera en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de Madera en todos los Edificios, Unidades y Barcos de Guerra. Por esta raz?n es aconsejable tener una Carpinter?a en todas tus ciudades.;Este edificio no afecta a los costes de la donaciones a los Aserraderos, Canteras, Minas de Azufre, Vi?edos ni Minas de Cristal en la Isla.'),
(29, 'Prensa de Vino', 59, 80, 'S?lo los vinos m?s puros maduran en las profundas y frescas bodegas de la ciudad. El Maestro de la Prensa de Vino cuida de que no se filtre nada y de que todo el vino pueda fluir por las gargantas de tus Ciudadanos.;Cada nivel de la Prensa de Vino reduce la demanda de Vino en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de Vino en la Construcci?n del Palacio, las Residencias del Gobernador, el consumo de Vino en la Taberna  y el coste de entrenamiento de Cocineros en el Cuartel.;Este edificio no afecta a los costes de la donaciones a las Maravillas en la Isla.'),
(30, 'Oficina del Arquitecto', 60, 80, '?ngulo, comp?s y regla: la Oficina del Arquitecto provee de todo lo necesario para construir tejados estables y paredes rectas. Y un edificio bien dise?ado requiere de menos m?rmol que uno chapucero. Por cada nivel disminuye el m?rmol necesario en la ciudad un 1% del valor base.;Cada nivel del Oficina del Arquitecto reduce la demanda de M?rmol en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de M?rmol en todos los Edificios, excepto la Academia y el Templo. Algunos edificios no se ver?n afectados en los niveles m?s bajos ya que solo requieren Madera para ser ampliados.;Este edificio no afecta a los costes de la donaciones a las Maravillas en la Isla.'),
(31, 'Optico', 61, 80, 'Las lentillas y lupas no s?lo ayudan a nuestros Cient?ficos a ver claramente y encontrar papeles importantes sobre su escritorio, tambi?n son necesarias para inventar todas las nuevas tecnolog?as que nos hace ser tan orgullosos. El ?ptico guarda cuidadosamente todo lo que necesitan nuestros cient?ficos. As? se pierden menos cosas y la demanda del Cristal disminuye.;Cada nivel del ?ptico reduce la demanda de Cristal en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de Cristal en la Construcci?n del Palacio y de las Residencias del Gobernador.;Tambi?n reduce el coste de las Mejoras de Unidades y Mejoras de Barcos (en el Taller de Invenciones) y el entrenamiento de M?dicos (en el Cuartel) y la construcci?n de Submarinos (en el Astillero).;El ?ptico reduce el coste de los Experimentos en la Academia hasta en un 32%.;Este edificio no afecta a los costes de la donaciones a las Maravillas en la Isla.'),
(32, 'Area de Pruebas Pirotecnicas', 93, 80, 'Las pruebas con fuegos artificiales no s?lo hacen que la noche brille, a veces tambi?n brillan los edificios circundantes. Nuestros investigadores, sin embargo, s?lo pueden optimizar la demanda del azufre cuando prueban nuevas mezclas una y otra vez.;Cada nivel del Area de Pruebas Pirot?cnicas reduce la demanda de Azufre en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de Azufre en la Construcci?n del Palacio y de las Residencias del Gobernador, en las Unidades (excepto en Cocineros, M?dicos, Arietes, Honderos y Lanceros) y en los Barcos de Guerra (excepto Submarinos).;Este edificio no afecta a los costes de la donaciones a las Maravillas en la Isla.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `edificionivel`
--

CREATE TABLE IF NOT EXISTS `edificionivel` (
  `codigoedifnivel` int(11) NOT NULL AUTO_INCREMENT,
  `codigoedificio` int(11) NOT NULL,
  `nivel` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`codigoedifnivel`),
  UNIQUE KEY `codigoedificio` (`codigoedificio`,`nivel`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=412 ;

--
-- Volcado de datos para la tabla `edificionivel`
--

INSERT INTO `edificionivel` (`codigoedifnivel`, `codigoedificio`, `nivel`) VALUES
(11, 1, 1),
(12, 1, 2),
(13, 1, 3),
(14, 1, 4),
(15, 1, 5),
(197, 1, 6),
(198, 1, 7),
(199, 1, 8),
(200, 1, 9),
(201, 1, 10),
(202, 1, 11),
(203, 1, 12),
(204, 1, 13),
(205, 1, 14),
(206, 1, 15),
(207, 1, 16),
(208, 1, 17),
(209, 1, 18),
(210, 1, 19),
(211, 1, 20),
(16, 2, 1),
(17, 2, 2),
(18, 2, 3),
(19, 2, 4),
(20, 2, 5),
(71, 2, 6),
(72, 2, 7),
(73, 2, 8),
(74, 2, 9),
(75, 2, 10),
(76, 2, 11),
(77, 2, 12),
(78, 2, 13),
(79, 2, 14),
(80, 2, 15),
(81, 2, 16),
(82, 2, 17),
(83, 2, 18),
(84, 2, 19),
(85, 2, 20),
(21, 3, 1),
(22, 3, 2),
(23, 3, 3),
(24, 3, 4),
(25, 3, 5),
(86, 3, 6),
(87, 3, 7),
(88, 3, 8),
(89, 3, 9),
(90, 3, 10),
(91, 3, 11),
(92, 3, 12),
(93, 3, 13),
(94, 3, 14),
(95, 3, 15),
(96, 3, 16),
(97, 3, 17),
(98, 3, 18),
(99, 3, 19),
(100, 3, 20),
(26, 4, 1),
(27, 4, 2),
(28, 4, 3),
(29, 4, 4),
(30, 4, 5),
(101, 4, 6),
(102, 4, 7),
(103, 4, 8),
(104, 4, 9),
(105, 4, 10),
(106, 4, 11),
(107, 4, 12),
(108, 4, 13),
(109, 4, 14),
(110, 4, 15),
(111, 4, 16),
(112, 4, 17),
(113, 4, 18),
(114, 4, 19),
(115, 4, 20),
(31, 5, 1),
(32, 5, 2),
(33, 5, 3),
(34, 5, 4),
(35, 5, 5),
(116, 5, 6),
(117, 5, 7),
(118, 5, 8),
(119, 5, 9),
(120, 5, 10),
(121, 5, 11),
(122, 5, 12),
(123, 5, 13),
(124, 5, 14),
(125, 5, 15),
(126, 5, 16),
(127, 5, 17),
(128, 5, 18),
(129, 5, 19),
(130, 5, 20),
(36, 6, 1),
(37, 6, 2),
(38, 6, 3),
(39, 6, 4),
(40, 6, 5),
(131, 6, 6),
(132, 6, 7),
(133, 6, 8),
(134, 6, 9),
(135, 6, 10),
(136, 6, 11),
(137, 6, 12),
(138, 6, 13),
(139, 6, 14),
(140, 6, 15),
(141, 6, 16),
(142, 6, 17),
(143, 6, 18),
(144, 6, 19),
(145, 6, 20),
(41, 7, 1),
(42, 7, 2),
(43, 7, 3),
(44, 7, 4),
(45, 7, 5),
(46, 8, 1),
(47, 8, 2),
(48, 8, 3),
(49, 8, 4),
(50, 8, 5),
(146, 8, 6),
(147, 8, 7),
(148, 8, 8),
(149, 8, 9),
(150, 8, 10),
(151, 8, 11),
(152, 8, 12),
(153, 8, 13),
(154, 8, 14),
(155, 8, 15),
(156, 8, 16),
(157, 8, 17),
(158, 8, 18),
(159, 8, 19),
(160, 8, 20),
(51, 9, 1),
(52, 9, 2),
(53, 9, 3),
(54, 9, 4),
(55, 9, 5),
(161, 9, 6),
(162, 9, 7),
(163, 9, 8),
(164, 9, 9),
(165, 9, 10),
(166, 9, 11),
(167, 9, 12),
(168, 9, 13),
(169, 9, 14),
(170, 9, 15),
(171, 9, 16),
(172, 9, 17),
(173, 9, 18),
(174, 9, 19),
(175, 9, 20),
(56, 10, 1),
(57, 10, 2),
(58, 10, 3),
(59, 10, 4),
(60, 10, 5),
(176, 10, 6),
(177, 10, 7),
(178, 10, 8),
(61, 11, 1),
(62, 11, 2),
(63, 11, 3),
(64, 11, 4),
(65, 11, 5),
(179, 11, 6),
(180, 11, 7),
(181, 11, 8),
(182, 11, 9),
(183, 11, 10),
(184, 11, 11),
(185, 11, 12),
(186, 11, 13),
(187, 11, 14),
(188, 11, 15),
(189, 11, 16),
(190, 11, 17),
(191, 11, 18),
(192, 11, 19),
(193, 11, 20),
(66, 12, 1),
(67, 12, 2),
(68, 12, 3),
(69, 12, 4),
(70, 12, 5),
(194, 12, 6),
(195, 12, 7),
(196, 12, 8),
(392, 23, 1),
(393, 23, 2),
(394, 23, 3),
(395, 23, 4),
(396, 23, 5),
(397, 23, 6),
(398, 23, 7),
(399, 23, 8),
(400, 23, 9),
(401, 23, 10),
(402, 23, 11),
(403, 23, 12),
(404, 23, 13),
(405, 23, 14),
(406, 23, 15),
(407, 23, 16),
(408, 23, 17),
(409, 23, 18),
(410, 23, 19),
(411, 23, 20),
(212, 24, 1),
(213, 24, 2),
(214, 24, 3),
(215, 24, 4),
(216, 24, 5),
(217, 24, 6),
(218, 24, 7),
(219, 24, 8),
(220, 24, 9),
(221, 24, 10),
(222, 24, 11),
(223, 24, 12),
(224, 24, 13),
(225, 24, 14),
(226, 24, 15),
(227, 24, 16),
(228, 24, 17),
(229, 24, 18),
(230, 24, 19),
(231, 24, 20),
(232, 25, 1),
(233, 25, 2),
(234, 25, 3),
(235, 25, 4),
(236, 25, 5),
(237, 25, 6),
(238, 25, 7),
(239, 25, 8),
(240, 25, 9),
(241, 25, 10),
(242, 25, 11),
(243, 25, 12),
(244, 25, 13),
(245, 25, 14),
(246, 25, 15),
(247, 25, 16),
(248, 25, 17),
(249, 25, 18),
(250, 25, 19),
(251, 25, 20),
(252, 26, 1),
(253, 26, 2),
(254, 26, 3),
(255, 26, 4),
(256, 26, 5),
(257, 26, 6),
(258, 26, 7),
(259, 26, 8),
(260, 26, 9),
(261, 26, 10),
(262, 26, 11),
(263, 26, 12),
(264, 26, 13),
(265, 26, 14),
(266, 26, 15),
(267, 26, 16),
(268, 26, 17),
(269, 26, 18),
(270, 26, 19),
(271, 26, 20),
(272, 27, 1),
(273, 27, 2),
(274, 27, 3),
(275, 27, 4),
(276, 27, 5),
(277, 27, 6),
(278, 27, 7),
(279, 27, 8),
(280, 27, 9),
(281, 27, 10),
(282, 27, 11),
(283, 27, 12),
(284, 27, 13),
(285, 27, 14),
(286, 27, 15),
(287, 27, 16),
(288, 27, 17),
(289, 27, 18),
(290, 27, 19),
(291, 27, 20),
(292, 28, 1),
(293, 28, 2),
(294, 28, 3),
(295, 28, 4),
(296, 28, 5),
(297, 28, 6),
(298, 28, 7),
(299, 28, 8),
(300, 28, 9),
(301, 28, 10),
(302, 28, 11),
(303, 28, 12),
(304, 28, 13),
(305, 28, 14),
(306, 28, 15),
(307, 28, 16),
(308, 28, 17),
(309, 28, 18),
(310, 28, 19),
(311, 28, 20),
(312, 29, 1),
(313, 29, 2),
(314, 29, 3),
(315, 29, 4),
(316, 29, 5),
(317, 29, 6),
(318, 29, 7),
(319, 29, 8),
(320, 29, 9),
(321, 29, 10),
(322, 29, 11),
(323, 29, 12),
(324, 29, 13),
(325, 29, 14),
(326, 29, 15),
(327, 29, 16),
(328, 29, 17),
(329, 29, 18),
(330, 29, 19),
(331, 29, 20),
(332, 30, 1),
(333, 30, 2),
(334, 30, 3),
(335, 30, 4),
(336, 30, 5),
(337, 30, 6),
(338, 30, 7),
(339, 30, 8),
(340, 30, 9),
(341, 30, 10),
(342, 30, 11),
(343, 30, 12),
(344, 30, 13),
(345, 30, 14),
(346, 30, 15),
(347, 30, 16),
(348, 30, 17),
(349, 30, 18),
(350, 30, 19),
(351, 30, 20),
(352, 31, 1),
(353, 31, 2),
(354, 31, 3),
(355, 31, 4),
(356, 31, 5),
(357, 31, 6),
(358, 31, 7),
(359, 31, 8),
(360, 31, 9),
(361, 31, 10),
(362, 31, 11),
(363, 31, 12),
(364, 31, 13),
(365, 31, 14),
(366, 31, 15),
(367, 31, 16),
(368, 31, 17),
(369, 31, 18),
(370, 31, 19),
(371, 31, 20),
(372, 32, 1),
(373, 32, 2),
(374, 32, 3),
(375, 32, 4),
(376, 32, 5),
(377, 32, 6),
(378, 32, 7),
(379, 32, 8),
(380, 32, 9),
(381, 32, 10),
(382, 32, 11),
(383, 32, 12),
(384, 32, 13),
(385, 32, 14),
(386, 32, 15),
(387, 32, 16),
(388, 32, 17),
(389, 32, 18),
(390, 32, 19),
(391, 32, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `edificiorecurso`
--

CREATE TABLE IF NOT EXISTS `edificiorecurso` (
  `codigoedifnivel` int(11) NOT NULL DEFAULT '0',
  `codigorecurso` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `cantidadrecurso` int(11) NOT NULL,
  PRIMARY KEY (`codigoedifnivel`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `edificiorecurso`
--

INSERT INTO `edificiorecurso` (`codigoedifnivel`, `codigorecurso`, `cantidadrecurso`) VALUES
(11, 6, 101),
(12, 6, 222),
(13, 6, 367),
(14, 6, 541),
(14, 15, 94),
(15, 6, 750),
(15, 15, 122),
(16, 6, 64),
(17, 6, 68),
(18, 6, 115),
(19, 6, 263),
(20, 6, 382),
(20, 9, 225),
(21, 6, 640),
(21, 9, 384),
(21, 12, 701),
(21, 15, 497),
(22, 6, 1152),
(22, 9, 845),
(22, 12, 1146),
(22, 15, 932),
(23, 6, 1766),
(23, 9, 1398),
(23, 12, 1668),
(23, 15, 1445),
(24, 6, 2504),
(24, 9, 2061),
(24, 12, 2278),
(24, 15, 2051),
(25, 6, 3388),
(25, 9, 2858),
(25, 12, 2991),
(25, 15, 2762),
(26, 6, 105),
(27, 6, 202),
(28, 6, 324),
(29, 6, 477),
(30, 6, 671),
(31, 6, 49),
(32, 6, 114),
(33, 6, 195),
(34, 6, 296),
(35, 6, 420),
(36, 6, 160),
(37, 6, 288),
(38, 6, 442),
(39, 6, 626),
(39, 15, 96),
(40, 6, 847),
(40, 15, 211),
(47, 6, 158),
(48, 6, 335),
(49, 6, 623),
(50, 6, 923),
(50, 15, 285),
(51, 6, 48),
(52, 6, 173),
(53, 6, 346),
(54, 6, 581),
(55, 6, 896),
(55, 15, 540),
(56, 6, 712),
(57, 6, 5823),
(57, 15, 1433),
(58, 6, 16048),
(58, 9, 3088),
(58, 15, 4546),
(59, 6, 36496),
(59, 9, 10300),
(59, 15, 10770),
(60, 6, 77392),
(60, 9, 24725),
(60, 12, 21188),
(60, 15, 23218),
(61, 6, 60),
(62, 6, 150),
(63, 6, 274),
(64, 6, 429),
(65, 6, 637),
(66, 6, 712),
(67, 6, 5823),
(67, 15, 1433),
(68, 6, 16048),
(68, 9, 3088),
(68, 15, 4546),
(69, 6, 36496),
(69, 9, 10300),
(69, 15, 10770),
(70, 6, 77392),
(70, 9, 24725),
(70, 12, 21188),
(70, 15, 23218),
(71, 6, 573),
(71, 12, 337),
(72, 6, 859),
(72, 12, 505),
(73, 6, 1288),
(73, 12, 757),
(74, 6, 1932),
(74, 12, 1135),
(75, 6, 2898),
(75, 12, 1702),
(76, 6, 4347),
(76, 12, 2553),
(77, 6, 6520),
(77, 12, 3829),
(78, 6, 9780),
(78, 12, 5743),
(79, 6, 14670),
(79, 12, 8614),
(80, 6, 22005),
(80, 12, 12921),
(81, 6, 33007),
(81, 12, 19381),
(82, 6, 49510),
(82, 12, 29071),
(83, 6, 74265),
(83, 12, 43606),
(84, 6, 111397),
(84, 12, 65409),
(85, 6, 167095),
(85, 12, 98113),
(86, 6, 4517),
(86, 9, 3810),
(86, 12, 3988),
(86, 15, 3682),
(87, 6, 6022),
(87, 9, 5080),
(87, 12, 5317),
(87, 15, 4909),
(88, 6, 8029),
(88, 9, 6773),
(88, 12, 7089),
(88, 15, 6545),
(89, 6, 10705),
(89, 9, 9030),
(89, 12, 9452),
(89, 15, 8726),
(90, 6, 14273),
(90, 9, 12040),
(90, 12, 12602),
(90, 15, 11634),
(91, 6, 19030),
(91, 9, 16053),
(91, 12, 16802),
(91, 15, 15512),
(92, 6, 25373),
(92, 9, 21404),
(92, 12, 22402),
(92, 15, 20682),
(93, 6, 33830),
(93, 9, 28538),
(93, 12, 29869),
(93, 15, 27576),
(94, 6, 45106),
(94, 9, 38050),
(94, 12, 39825),
(94, 15, 36768),
(95, 6, 60141),
(95, 9, 50733),
(95, 12, 53100),
(95, 15, 49024),
(96, 6, 80188),
(96, 9, 67644),
(96, 12, 70800),
(96, 15, 65365),
(97, 6, 106917),
(97, 9, 90192),
(97, 12, 94400),
(97, 15, 87153),
(98, 6, 142556),
(98, 9, 120256),
(98, 12, 125866),
(98, 15, 116204),
(99, 6, 190074),
(99, 9, 160341),
(99, 12, 167821),
(99, 15, 154938),
(100, 6, 253432),
(100, 9, 213788),
(100, 12, 223761),
(100, 15, 206584),
(101, 6, 894),
(102, 6, 1192),
(103, 6, 1589),
(104, 6, 2118),
(105, 6, 2824),
(106, 6, 3765),
(107, 6, 5020),
(108, 6, 6693),
(109, 6, 8924),
(110, 6, 11898),
(111, 6, 15864),
(112, 6, 21152),
(113, 6, 28202),
(114, 6, 37602),
(115, 6, 50136),
(116, 6, 560),
(117, 6, 746),
(118, 6, 994),
(119, 6, 1325),
(120, 6, 1766),
(121, 6, 2354),
(122, 6, 3138),
(123, 6, 4184),
(124, 6, 5578),
(125, 6, 7437),
(126, 6, 9916),
(127, 6, 13221),
(128, 6, 17628),
(129, 6, 23504),
(130, 6, 31338),
(131, 6, 1129),
(131, 15, 281),
(132, 6, 1505),
(132, 15, 374),
(133, 6, 2006),
(133, 15, 498),
(134, 6, 2674),
(134, 15, 664),
(135, 6, 3565),
(135, 15, 885),
(136, 6, 4753),
(136, 15, 1180),
(137, 6, 6337),
(137, 15, 1573),
(138, 6, 8449),
(138, 15, 2097),
(139, 6, 11265),
(139, 15, 2796),
(140, 6, 15020),
(140, 15, 3728),
(141, 6, 20026),
(141, 15, 4970),
(142, 6, 26701),
(142, 15, 6626),
(143, 6, 35601),
(143, 15, 8834),
(144, 6, 47468),
(144, 15, 11778),
(145, 6, 63290),
(145, 15, 15704),
(146, 6, 1230),
(146, 15, 380),
(147, 6, 1640),
(147, 15, 506),
(148, 6, 2186),
(148, 15, 674),
(149, 6, 2914),
(149, 15, 898),
(150, 6, 3885),
(150, 15, 1197),
(151, 6, 5180),
(151, 15, 1596),
(152, 6, 6906),
(152, 15, 2128),
(153, 6, 9208),
(153, 15, 2837),
(154, 6, 12277),
(154, 15, 3782),
(155, 6, 16369),
(155, 15, 5042),
(156, 6, 21825),
(156, 15, 6722),
(157, 6, 29100),
(157, 15, 8962),
(158, 6, 38800),
(158, 15, 11949),
(159, 6, 51733),
(159, 15, 15932),
(160, 6, 68977),
(160, 15, 21242),
(161, 6, 1194),
(161, 15, 720),
(162, 6, 1592),
(162, 15, 960),
(163, 6, 2122),
(163, 15, 1280),
(164, 6, 2829),
(164, 15, 1706),
(165, 6, 3772),
(165, 15, 2274),
(166, 6, 5029),
(166, 15, 3032),
(167, 6, 6705),
(167, 15, 4042),
(168, 6, 8940),
(168, 15, 5389),
(169, 6, 11920),
(169, 15, 7185),
(170, 6, 15893),
(170, 15, 9580),
(171, 6, 21190),
(171, 15, 12773),
(172, 6, 28253),
(172, 15, 17030),
(173, 6, 37670),
(173, 15, 22706),
(174, 6, 50226),
(174, 15, 30274),
(175, 6, 66968),
(175, 15, 40365),
(176, 6, 103189),
(176, 9, 32966),
(176, 12, 28250),
(176, 15, 30957),
(177, 6, 137585),
(177, 9, 43954),
(177, 12, 37666),
(177, 14, 10898),
(177, 15, 41276),
(178, 6, 183446),
(178, 9, 58605),
(178, 12, 50221),
(178, 14, 22110),
(178, 15, 55034),
(179, 6, 849),
(180, 6, 1132),
(181, 6, 1509),
(182, 6, 2012),
(183, 6, 2682),
(184, 6, 3576),
(185, 6, 4768),
(186, 6, 6357),
(187, 6, 8476),
(188, 6, 11301),
(189, 6, 15068),
(190, 6, 20090),
(191, 6, 26786),
(192, 6, 35714),
(193, 6, 47618),
(194, 6, 103189),
(194, 9, 32966),
(194, 12, 28250),
(194, 15, 30957),
(195, 6, 137585),
(195, 9, 43954),
(195, 12, 37666),
(195, 14, 10898),
(195, 15, 41276),
(196, 6, 183446),
(196, 9, 58605),
(196, 12, 50221),
(196, 14, 22110),
(196, 15, 55034),
(197, 6, 1000),
(197, 15, 162),
(198, 6, 1333),
(198, 15, 216),
(199, 6, 1777),
(199, 15, 288),
(200, 6, 2369),
(200, 15, 384),
(201, 6, 3158),
(201, 15, 512),
(202, 6, 4210),
(202, 15, 682),
(203, 6, 5613),
(203, 15, 909),
(204, 6, 7484),
(204, 15, 1212),
(205, 6, 9978),
(205, 15, 1616),
(206, 6, 13304),
(206, 15, 2154),
(207, 6, 17738),
(207, 15, 2872),
(208, 6, 23650),
(208, 15, 3829),
(209, 6, 31533),
(209, 15, 5105),
(210, 6, 42044),
(210, 15, 6806),
(211, 6, 56058),
(211, 15, 9074),
(212, 6, 274),
(212, 14, 274),
(212, 15, 0),
(213, 6, 467),
(213, 14, 467),
(213, 15, 116),
(214, 6, 718),
(214, 14, 718),
(214, 15, 255),
(215, 6, 1045),
(215, 14, 1045),
(215, 15, 436),
(216, 6, 1469),
(216, 14, 1469),
(216, 15, 671),
(217, 6, 2203),
(217, 14, 2203),
(217, 15, 1006),
(218, 6, 3304),
(218, 14, 3304),
(218, 15, 1509),
(219, 6, 4956),
(219, 14, 4956),
(219, 15, 2263),
(220, 6, 7434),
(220, 14, 7434),
(220, 15, 3394),
(221, 6, 11151),
(221, 14, 11151),
(221, 15, 5091),
(222, 6, 16726),
(222, 14, 16726),
(222, 15, 7636),
(223, 6, 25089),
(223, 14, 25089),
(223, 15, 11454),
(224, 6, 37633),
(224, 14, 37633),
(224, 15, 17181),
(225, 6, 56449),
(225, 14, 56449),
(225, 15, 25771),
(226, 6, 84673),
(226, 14, 84673),
(226, 15, 38656),
(227, 6, 127009),
(227, 14, 127009),
(227, 15, 57984),
(228, 6, 190513),
(228, 14, 190513),
(228, 15, 86976),
(229, 6, 285769),
(229, 14, 285769),
(229, 15, 130464),
(230, 6, 428653),
(230, 14, 428653),
(230, 15, 195696),
(231, 6, 642979),
(231, 14, 642979),
(231, 15, 293544),
(232, 6, 274),
(232, 15, 0),
(233, 6, 467),
(233, 15, 116),
(234, 6, 718),
(234, 15, 255),
(235, 6, 1045),
(235, 15, 436),
(236, 6, 1469),
(236, 15, 671),
(237, 6, 2203),
(237, 15, 1006),
(238, 6, 3304),
(238, 15, 1509),
(239, 6, 4956),
(239, 15, 2263),
(240, 6, 7434),
(240, 15, 3394),
(241, 6, 11151),
(241, 15, 5091),
(242, 6, 16726),
(242, 15, 7636),
(243, 6, 25089),
(243, 15, 11454),
(244, 6, 37633),
(244, 15, 17181),
(245, 6, 56449),
(245, 15, 25771),
(246, 6, 84673),
(246, 15, 38656),
(247, 6, 127009),
(247, 15, 57984),
(248, 6, 190513),
(248, 15, 86976),
(249, 6, 285769),
(249, 15, 130464),
(250, 6, 428653),
(250, 15, 195696),
(251, 6, 642979),
(251, 15, 293544),
(252, 6, 274),
(252, 15, 0),
(253, 6, 467),
(253, 15, 116),
(254, 6, 718),
(254, 15, 255),
(255, 6, 1045),
(255, 15, 436),
(256, 6, 1469),
(256, 15, 671),
(257, 6, 2203),
(257, 15, 1006),
(258, 6, 3304),
(258, 15, 1509),
(259, 6, 4956),
(259, 15, 2263),
(260, 6, 7434),
(260, 15, 3394),
(261, 6, 11151),
(261, 15, 5091),
(262, 6, 16726),
(262, 15, 7636),
(263, 6, 25089),
(263, 15, 11454),
(264, 6, 37633),
(264, 15, 17181),
(265, 6, 56449),
(265, 15, 25771),
(266, 6, 84673),
(266, 15, 38656),
(267, 6, 127009),
(267, 15, 57984),
(268, 6, 190513),
(268, 15, 86976),
(269, 6, 285769),
(269, 15, 130464),
(270, 6, 428653),
(270, 15, 195696),
(271, 6, 642979),
(271, 15, 293544),
(272, 6, 274),
(272, 15, 0),
(273, 6, 467),
(273, 15, 116),
(274, 6, 718),
(274, 15, 255),
(275, 6, 1045),
(275, 15, 436),
(276, 6, 1469),
(276, 15, 671),
(277, 6, 2203),
(277, 15, 1006),
(278, 6, 3304),
(278, 15, 1509),
(279, 6, 4956),
(279, 15, 2263),
(280, 6, 7434),
(280, 15, 3394),
(281, 6, 11151),
(281, 15, 5091),
(282, 6, 16726),
(282, 15, 7636),
(283, 6, 25089),
(283, 15, 11454),
(284, 6, 37633),
(284, 15, 17181),
(285, 6, 56449),
(285, 15, 25771),
(286, 6, 84673),
(286, 15, 38656),
(287, 6, 127009),
(287, 15, 57984),
(288, 6, 190513),
(288, 15, 86976),
(289, 6, 285769),
(289, 15, 130464),
(290, 6, 428653),
(290, 15, 195696),
(291, 6, 642979),
(291, 15, 293544),
(292, 6, 63),
(292, 15, 0),
(293, 6, 121),
(293, 15, 0),
(294, 6, 187),
(294, 15, 0),
(295, 6, 266),
(295, 15, 0),
(296, 6, 357),
(296, 15, 0),
(297, 6, 535),
(297, 15, 0),
(298, 6, 802),
(298, 15, 0),
(299, 6, 1203),
(299, 15, 0),
(300, 6, 1804),
(300, 15, 0),
(301, 6, 2706),
(301, 15, 0),
(302, 6, 4059),
(302, 15, 0),
(303, 6, 6088),
(303, 15, 0),
(304, 6, 9132),
(304, 15, 0),
(305, 6, 13698),
(305, 15, 0),
(306, 6, 20547),
(306, 15, 0),
(307, 6, 30820),
(307, 15, 0),
(308, 6, 46230),
(308, 15, 0),
(309, 6, 69345),
(309, 15, 0),
(310, 6, 104017),
(310, 15, 0),
(311, 6, 156025),
(311, 15, 0),
(312, 6, 339),
(312, 15, 123),
(313, 6, 423),
(313, 15, 198),
(314, 6, 520),
(314, 15, 285),
(315, 6, 631),
(315, 15, 387),
(316, 6, 758),
(316, 15, 504),
(317, 6, 1137),
(317, 15, 756),
(318, 6, 1705),
(318, 15, 1134),
(319, 6, 2557),
(319, 15, 1701),
(320, 6, 3835),
(320, 15, 2551),
(321, 6, 5752),
(321, 15, 3826),
(322, 6, 8628),
(322, 15, 5739),
(323, 6, 12942),
(323, 15, 8608),
(324, 6, 19413),
(324, 15, 12912),
(325, 6, 29119),
(325, 15, 19368),
(326, 6, 43678),
(326, 15, 29052),
(327, 6, 65517),
(327, 15, 43578),
(328, 6, 98275),
(328, 15, 65367),
(329, 6, 147412),
(329, 15, 98050),
(330, 6, 221118),
(330, 15, 147075),
(331, 6, 331677),
(331, 15, 220612),
(332, 6, 185),
(332, 15, 106),
(333, 6, 291),
(333, 15, 158),
(334, 6, 413),
(334, 15, 218),
(335, 6, 555),
(335, 15, 286),
(336, 6, 720),
(336, 15, 364),
(337, 6, 1080),
(337, 15, 546),
(338, 6, 1620),
(338, 15, 819),
(339, 6, 2430),
(339, 15, 1228),
(340, 6, 3645),
(340, 15, 1842),
(341, 6, 5467),
(341, 15, 2763),
(342, 6, 8200),
(342, 15, 4144),
(343, 6, 12300),
(343, 15, 6216),
(344, 6, 18450),
(344, 15, 9324),
(345, 6, 27675),
(345, 15, 13986),
(346, 6, 41512),
(346, 15, 20979),
(347, 6, 62268),
(347, 15, 31468),
(348, 6, 93402),
(348, 15, 47202),
(349, 6, 140103),
(349, 15, 70803),
(350, 6, 210154),
(350, 15, 106204),
(351, 6, 315231),
(351, 15, 159306),
(352, 6, 119),
(352, 15, 0),
(353, 6, 188),
(353, 15, 35),
(354, 6, 269),
(354, 15, 96),
(355, 6, 362),
(355, 15, 167),
(356, 6, 471),
(356, 15, 249),
(357, 6, 706),
(357, 15, 373),
(358, 6, 1059),
(358, 15, 559),
(359, 6, 1588),
(359, 15, 838),
(360, 6, 2382),
(360, 15, 1257),
(361, 6, 3573),
(361, 15, 1885),
(362, 6, 5359),
(362, 15, 2827),
(363, 6, 8038),
(363, 15, 4240),
(364, 6, 12057),
(364, 15, 6360),
(365, 6, 18085),
(365, 15, 9540),
(366, 6, 27127),
(366, 15, 14310),
(367, 6, 40690),
(367, 15, 21465),
(368, 6, 61035),
(368, 15, 32197),
(369, 6, 91552),
(369, 15, 48295),
(370, 6, 137328),
(370, 15, 72442),
(371, 6, 205992),
(371, 15, 108663),
(372, 6, 272),
(372, 15, 135),
(373, 6, 353),
(373, 15, 212),
(374, 6, 445),
(374, 15, 302),
(375, 6, 551),
(375, 15, 405),
(376, 6, 673),
(376, 15, 526),
(377, 6, 1009),
(377, 15, 789),
(378, 6, 1513),
(378, 15, 1183),
(379, 6, 2269),
(379, 15, 1774),
(380, 6, 3403),
(380, 15, 2661),
(381, 6, 5104),
(381, 15, 3991),
(382, 6, 7656),
(382, 15, 5986),
(383, 6, 11484),
(383, 15, 8979),
(384, 6, 17226),
(384, 15, 13468),
(385, 6, 25839),
(385, 15, 20202),
(386, 6, 38758),
(386, 15, 30303),
(387, 6, 58137),
(387, 15, 45454),
(388, 6, 87205),
(388, 15, 68181),
(389, 6, 130807),
(389, 15, 102271),
(390, 6, 196210),
(390, 15, 153406),
(391, 6, 294315),
(391, 15, 230109),
(392, 6, 250),
(392, 15, 0),
(393, 6, 430),
(393, 15, 104),
(394, 6, 664),
(394, 15, 237),
(395, 6, 968),
(395, 15, 410),
(396, 6, 1364),
(396, 15, 635),
(397, 6, 2046),
(397, 15, 952),
(398, 6, 3069),
(398, 15, 1428),
(399, 6, 4603),
(399, 15, 2142),
(400, 6, 6904),
(400, 15, 3213),
(401, 6, 10356),
(401, 15, 4819),
(402, 6, 15534),
(402, 15, 7228),
(403, 6, 23301),
(403, 15, 10842),
(404, 6, 34951),
(404, 15, 16263),
(405, 6, 52426),
(405, 15, 24394),
(406, 6, 78639),
(406, 15, 36591),
(407, 6, 117958),
(407, 15, 54886),
(408, 6, 176937),
(408, 15, 82329),
(409, 6, 265405),
(409, 15, 123493),
(410, 6, 398107),
(410, 15, 185239),
(411, 6, 597160),
(411, 15, 277858);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadociudad`
--

CREATE TABLE IF NOT EXISTS `estadociudad` (
  `codigoestado` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `estado` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigoestado`),
  UNIQUE KEY `estado` (`estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `estadociudad`
--

INSERT INTO `estadociudad` (`codigoestado`, `estado`) VALUES
(1, 'Normal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guerra`
--

CREATE TABLE IF NOT EXISTS `guerra` (
  `codigoguerra` int(11) NOT NULL AUTO_INCREMENT,
  `guerraactiva` tinyint(1) NOT NULL DEFAULT '1',
  `fechainicio` date NOT NULL,
  `horainicio` time NOT NULL,
  `fechafin` date DEFAULT NULL,
  `horafin` time DEFAULT NULL,
  `bandoganador` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoguerra`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `guerra`
--

INSERT INTO `guerra` (`codigoguerra`, `guerraactiva`, `fechainicio`, `horainicio`, `fechafin`, `horafin`, `bandoganador`) VALUES
(1, 1, '2014-11-20', '12:07:50', NULL, NULL, NULL),
(2, 1, '2014-11-20', '12:08:05', NULL, NULL, NULL),
(3, 1, '2014-11-20', '12:13:08', NULL, NULL, NULL),
(4, 1, '2014-11-28', '15:01:09', NULL, NULL, NULL),
(5, 1, '2014-11-28', '15:01:14', NULL, NULL, NULL),
(6, 1, '2014-11-28', '15:01:16', NULL, NULL, NULL),
(7, 1, '2014-11-28', '15:01:19', NULL, NULL, NULL),
(8, 1, '2014-11-28', '15:01:21', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guerraataque`
--

CREATE TABLE IF NOT EXISTS `guerraataque` (
  `codigoguerra` int(11) NOT NULL,
  `codigoataque` int(11) NOT NULL,
  PRIMARY KEY (`codigoguerra`,`codigoataque`),
  KEY `codigoataque` (`codigoataque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guerraparticipante`
--

CREATE TABLE IF NOT EXISTS `guerraparticipante` (
  `codigoguerra` int(11) NOT NULL,
  `codigojugador` int(11) NOT NULL,
  `puntaje` int(11) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `bando` int(11) NOT NULL,
  PRIMARY KEY (`codigoguerra`,`codigojugador`),
  KEY `codigojugador` (`codigojugador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `guerraparticipante`
--

INSERT INTO `guerraparticipante` (`codigoguerra`, `codigojugador`, `puntaje`, `activo`, `bando`) VALUES
(1, 30, 0, 1, 2),
(1, 40, 0, 1, 1),
(2, 7, 0, 1, 2),
(2, 40, 0, 1, 1),
(3, 7, 0, 1, 2),
(3, 40, 0, 1, 1),
(4, 30, 0, 1, 2),
(4, 41, 0, 1, 1),
(5, 30, 0, 1, 2),
(5, 41, 0, 1, 1),
(6, 30, 0, 1, 2),
(6, 41, 0, 1, 1),
(7, 30, 0, 1, 2),
(7, 41, 0, 1, 1),
(8, 30, 0, 1, 2),
(8, 41, 0, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilitarmision`
--

CREATE TABLE IF NOT EXISTS `habilitarmision` (
  `codigoinvestigacion` int(11) NOT NULL DEFAULT '0',
  `codigomision` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codigoinvestigacion`,`codigomision`),
  KEY `codigomision` (`codigomision`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagenes`
--

CREATE TABLE IF NOT EXISTS `imagenes` (
  `codigoimagen` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigoimagen`),
  UNIQUE KEY `direccion` (`direccion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=129 ;

--
-- Volcado de datos para la tabla `imagenes`
--

INSERT INTO `imagenes` (`codigoimagen`, `direccion`) VALUES
(94, 'arcocompuesto'),
(30, 'Ariete'),
(96, 'arietecubierto'),
(97, 'arietedeasedio'),
(95, 'arietemedieval'),
(39, 'Arquero'),
(19, 'Azufre'),
(99, 'ballesta'),
(100, 'ballista'),
(47, 'barcomercante'),
(113, 'barrilexplosivo'),
(112, 'bolasexplosivas'),
(107, 'carabina'),
(31, 'Catapulta'),
(105, 'claymore'),
(16, 'Cristal'),
(115, 'daga'),
(1, 'edificioacademia'),
(2, 'edificioalmacen'),
(93, 'edificioareapirotecnia'),
(3, 'edificioastillerodeguerra'),
(89, 'edificiocabañaguardabosque'),
(54, 'edificiocantero'),
(58, 'edificiocarpinteria'),
(4, 'edificiocuartel'),
(5, 'edificiodeposito'),
(6, 'edificioembajada'),
(7, 'edificiointendencia'),
(8, 'edificiomercado'),
(60, 'edificiooficinadelarquitecto'),
(61, 'edificiooptico'),
(9, 'edificiopalacio'),
(59, 'edificioprensadevino'),
(10, 'edificiopuerto'),
(11, 'edificioresidenciadelgobernador'),
(55, 'edificiosopladordevidrio'),
(12, 'edificiotaberna'),
(56, 'edificiotorredelalquimista'),
(57, 'edificiovinicultor'),
(108, 'escopeta'),
(37, 'Espadachin'),
(111, 'espadadeacero'),
(109, 'espadadebronce'),
(110, 'espadadehierro'),
(28, 'Espartano'),
(106, 'falcata'),
(40, 'Fusilero'),
(26, 'Gigante a Vapor'),
(45, 'Girocoptero'),
(104, 'gladius'),
(46, 'Globo Bombardero'),
(114, 'honda'),
(29, 'Hondero'),
(27, 'Hoplita'),
(121, 'imagenciudad1'),
(123, 'imagenciudad2'),
(48, 'imagenciudad3'),
(124, 'imagenciudad4'),
(125, 'imagenciudad5'),
(126, 'imagenciudad6'),
(127, 'imagenciudad7'),
(128, 'imagenciudad8'),
(52, 'islavacia1'),
(49, 'islavacia2'),
(50, 'islavacia3'),
(116, 'jabalina'),
(38, 'Lancero'),
(98, 'longbow'),
(14, 'Madera'),
(101, 'mangonel'),
(21, 'Marmol'),
(32, 'Mortero'),
(120, 'mortero_1'),
(102, 'petrary'),
(118, 'pica'),
(103, 'trebuchet'),
(117, 'tridente'),
(20, 'Vino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigacion`
--

CREATE TABLE IF NOT EXISTS `investigacion` (
  `codigoinvestigacion` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `puntosinvestigacion` int(11) NOT NULL,
  `codigotema` int(11) NOT NULL,
  `Efecto` varchar(200) NOT NULL,
  `numeroorden` int(11) NOT NULL,
  `codigoinvestigacionanterior` int(11) NOT NULL,
  PRIMARY KEY (`codigoinvestigacion`),
  KEY `codigotema` (`codigotema`),
  KEY `titulo` (`titulo`,`codigotema`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Volcado de datos para la tabla `investigacion`
--

INSERT INTO `investigacion` (`codigoinvestigacion`, `titulo`, `descripcion`, `puntosinvestigacion`, `codigotema`, `Efecto`, `numeroorden`, `codigoinvestigacionanterior`) VALUES
(1, 'Conservaci?n', 'Hemos aprendido c?mo almacenar y proteger nuestros recursos y en el largo plazo. Tambi?n una parte de nuestros recursos est? a salvo de piratas y otros villanos que quieren robar a nosotros!', 12, 4, 'Permite la construcci?n de Naves', 1, 0),
(2, 'Poleas', 'Una idea brillante: Una cuerda que se tira m?s de un rollo de un hombre sencillo da la fuerza de H?rcules. As? que ahora los trabajadores pueden levantar enormes bloques de piedra por su propia cuenta y construir nuestros edificios, incluso m?s r?pido!', 24, 4, '2% de disminuci?n en los costos de la construcci?n', 2, 0),
(3, 'La riqueza, el bien de excavaci?n', '?La tierra acuna preciados tesoros! ?Hemos aprendido a producir azufre, cristal y m?rmol - a cultivar la vid en nuestras f?rtiles colinas y producir delicioso vino! Gozaremos una nueva era de bienestar si sabemos utilizar estos recursos. En nuestras tiendas podremos vender los bienes generados y proveernos de cuanto recurso nos sea necesario. Efecto: Permite la explotaci?n de materias primas y la construcci?n de tiendas', 112, 4, 'Permite la extracci?n de productos del comercio y la construcci?n de puestos de comercio', 3, 0),
(4, 'Viticultura', 'A las necesidades de la poblaci?n felices fiestas en las que pueden pasar horas y deleit?ndose potable nuestros fant?sticos fluido vino. Dionisio le gusta vernos disfrutar de lo que ?l nos ha dado!', 336, 4, 'Permite la creaci?n de Tabernas', 4, 0),
(5, 'Mejora de Recolecci?n de Recursos', 'Ha pasado alg?n tiempo desde que aprend? a usar los tesoros de nuestra isla para nuestras necesidades. Ahora debemos educar a nuestros trabajadores y dejar que cada bosque, cantera o vi?edo, cada hoyo de azufre o de administrar las minas de cristal por los hombres que no s?lo son fuertes, pero tambi?n h?bil. De esta manera vamos a reunir a?n m?s los ingresos y nuestra civilizaci?n se hacen m?s ricos que nunca!', 1204, 4, 'Permite la construcci?n de la casa forestal, Glassblower, Alquimista''s Tower, viticultor, y picapedrero.', 5, 0),
(6, 'Geometr?a', 'Derecho ?ngulos, tri?ngulos, c?rculos - algunos brillantes mentes pueden calcular c?mo podemos construir nuestros edificios, incluso mejor y m?s hermoso. Nuestras ciudades, y pronto servir? como ejemplo para el mundo entero!', 2236, 4, 'Disminuci?n adicional del 4% en los costos de la construcci?n (6% del total)', 6, 0),
(7, 'Arquitectura', 'Una buena casa pueden soportar los m?s duros elementos. Puede soportar a?n mejor cuando una brillante mente se ocupa de ella con muchos dibujos y un poco de matem?ticas antes de mano, de modo que todas las paredes son rectas y el techo es apretado. Gracias a la br?jula y el ?ngulo de nuestros edificios ser? mucho m?s estable y bien protegido de la lluvia. Un arquitecto `s Mesa ahorrarnos mucho m?rmol, s?lo pensar en el ahorro de la construcci?n de un nuevo edificio! Permite: Construcci?n de oficinas de arquitecto `s', 3672, 4, 'Permite edificio del arquitecto Oficina', 7, 0),
(8, 'Disminuci?n de costos', 'El agua es siempre todav?a. Debemos utilizar este conocimiento para que nuestros edificios cada vez, tambi?n! Nuestra ciudad ser? cada vez m?s hermosa y vamos a utilizar menos la piedra y la madera para la construcci?n de nuestros edificios!', 25632, 4, 'Disminuci?n adicional del 8% en los costos de la construcci?n (14% total)', 8, 0),
(9, 'Bodegas', '?Qu? un evento anual de las fiestas son el vino! Toda la ciudad est? en sus pies cuando las mejores uvas est?n dando en vino y cuando el oro l?quido en torno a las salpicaduras, los ni?os tienen sus m?s divertido! Con un vino de prensa, sin embargo, a cargo de un experimentado en?logo, perder?amos mucho menos. El winemaster tambi?n podr?a ocuparse de un almacenamiento adecuado que nos permite dejar que el vino de la edad madura y bien!', 48000, 4, 'Permite la construcci?n de Bodegas', 9, 0),
(10, 'Futuro de la Econom?a', 'Nuestros ciudadanos viven en la riqueza y el mercado se extienda con las delicias de todo el mundo! Las calles est?n limpias y desarrollados, de esta manera el material de construcci?n que llega a la obra de construcci?n m?s r?pido.', 532800, 4, '10 y 20 de satisfacci?n ciudadana n?mero m?ximo en cada ciudad. Multiplicado por el nivel de esta investigaci?n.', 10, 0),
(11, 'Astillero de Guerra', '?Una cuenca sobre el mar cuyo agua nos es posible drenar! ?Finalmente podemos construir barcos y hacerlos a la mar! ?Que maravilla, una flota de guerra tan poderosa que mostrar? a nuestros enemigos el significado del miedo!', 24, 2, 'Permite la creaci?n de los Astilleros.', 1, 0),
(12, 'Cartograf?a', 'Las largas marchas por monta?as y pantanos implican un gran desgaste de material. Si dibujamos los caminos m?s propicios por donde puedan pasar los soldados de forma de que no pierdan tiempo entre las malezas o se llenen de lodo, habremos de lavar menos sus uniformes. ', 24, 2, '2% m?s bajo para el mantenimiento de unidades de tierra.', 2, 0),
(13, 'Ej?rcito Profesional', '?Con un ej?rcito profesional podemos defendernos mucho mejor de piratas, b?rbaros y dem?s villanos! Cuesta m?s dinero que cuando mandamos a nuestros ciudadanos a la guerra, pero nuestras tropas saben ahora manejar espadas, lanzas y escudos.', 336, 2, 'Reclutar espadachines y Hoplitas en el cuartel.', 3, 0),
(14, 'Asedio', 'Con un ariete de cabeza de metal y la fuerza de 10 hombres podemos incluso derrumbar muros de ciudad enteros. ?A nuestros soldados les ser? algo m?s f?cil conquistar todas las ciudades!', 1032, 2, 'Construcci?n de arietes en el cuartel', 4, 0),
(15, 'C?digo de Honor', '?Nuestros soldados se sienten orgullosos de servir a su unidad y a su imperio! Con sus nuevos uniformes son m?s cuidados, as? que no los debemos zurcir o reparar tanto.', 2236, 2, '4% menos de manutenci?n', 5, 0),
(16, 'Bal?stica', 'Finalmente sabemos como hacer para disparar mejor la flechas sobre nuestro enemigo. Con estos conocimientos deber?amos empezar a instruir soldados en este arte. ?Pronto podremos enviar arqueros a la guerra!', 3264, 2, 'Arqueros', 6, 0),
(17, 'Regla de la Palanca', '?Con esta t?cnica podemos desatar fuerzas incre?bles, incluso podemos arrojar enormes rocas por los aires! ?Si estas rocas son lo suficientemente grandes, podremos tambi?n derribar los muros de cualquier ciudad!', 7020, 2, 'Construcci?n de catapultas en el cuartel', 7, 0),
(18, 'Gobernador', 'Si empleamos un funcionario, podremos no solo saquear la ciudad enemiga, sino tambi?n utilizarla y gerenciarla. ?Pronto gozaremos del bienestar de otros y nuestras ciudades florecer?n con sus recursos!', 11592, 2, 'Ocupaci?n', 8, 0),
(19, 'Astillero de Guerra', '?Una cuenca sobre el mar cuyo agua nos es posible drenar! ?Finalmente podemos construir barcos y hacerlos a la mar! ?Que maravilla, una flota de guerra tan poderosa que mostrar? a nuestros enemigos el significado del miedo!', 24, 2, 'Permite la creaci?n de los Astilleros.', 1, 0),
(20, 'Cartograf?a', 'Las largas marchas por monta?as y pantanos implican un gran desgaste de material. Si dibujamos los caminos m?s propicios por donde puedan pasar los soldados de forma de que no pierdan tiempo entre las malezas o se llenen de lodo, habremos de lavar menos sus uniformes. ', 24, 2, '2% m?s bajo para el mantenimiento de unidades de tierra.', 2, 0),
(21, 'Ej?rcito Profesional', '?Con un ej?rcito profesional podemos defendernos mucho mejor de piratas, b?rbaros y dem?s villanos! Cuesta m?s dinero que cuando mandamos a nuestros ciudadanos a la guerra, pero nuestras tropas saben ahora manejar espadas, lanzas y escudos.', 336, 2, 'Reclutar espadachines y Hoplitas en el cuartel.', 3, 0),
(22, 'Asedio', 'Con un ariete de cabeza de metal y la fuerza de 10 hombres podemos incluso derrumbar muros de ciudad enteros. ?A nuestros soldados les ser? algo m?s f?cil conquistar todas las ciudades!', 1032, 2, 'Construcci?n de arietes en el cuartel', 4, 0),
(23, 'C?digo de Honor', '?Nuestros soldados se sienten orgullosos de servir a su unidad y a su imperio! Con sus nuevos uniformes son m?s cuidados, as? que no los debemos zurcir o reparar tanto.', 2236, 2, '4% menos de manutenci?n', 5, 0),
(24, 'Bal?stica', 'Finalmente sabemos como hacer para disparar mejor la flechas sobre nuestro enemigo. Con estos conocimientos deber?amos empezar a instruir soldados en este arte. ?Pronto podremos enviar arqueros a la guerra!', 3264, 2, 'Arqueros', 6, 0),
(25, 'Regla de la Palanca', '?Con esta t?cnica podemos desatar fuerzas incre?bles, incluso podemos arrojar enormes rocas por los aires! ?Si estas rocas son lo suficientemente grandes, podremos tambi?n derribar los muros de cualquier ciudad!', 7020, 2, 'Construcci?n de catapultas en el cuartel', 7, 0),
(26, 'Gobernador', 'Si empleamos un funcionario, podremos no solo saquear la ciudad enemiga, sino tambi?n utilizarla y gerenciarla. ?Pronto gozaremos del bienestar de otros y nuestras ciudades florecer?n con sus recursos!', 11592, 2, 'Ocupaci?n', 8, 0),
(27, 'Pirotecnia', '?El azufre es una sustancia rar?sima! Y con cada nueva mezcla que realizamos, logramos un impacto mayor de este precioso recurso. Un campo de pr?cticas seguro permitir?a probar nuestras nuevas invenciones sin da?os colaterales a los dem?s edificios. Con mejores p?lvora y explosivos ?ahorraremos much?simas cantidades de azufre!', 19908, 2, 'Construir Campo de Pr?cticas de Fuegos Artificiales', 9, 0),
(28, 'Log?stica', 'Nuestros solados puede luchar mucho mejor si no tienen que andar acarreando tantos b?rtulos. Adem?s los uniformes no se ven tan deteriorados despu?s de largas marchas, con lo cual no deben de ser reparados tan a menudo.', 25632, 2, '8% menos de manutenci?n para soldados', 10, 0),
(29, 'P?lvora', '?Esta mezcla negra creada en la cocina del alquimista puede, con un ruidoso estruendo, atizar fuego, lo que nos permite poner en marcha cosas realmente diab?licas! ?Ahora podemos cargar tubos de hierro con este polvo para disparar pesadas bolas por los aires!', 38400, 2, 'Formar fusileros en el cuartel', 11, 0),
(30, 'Rob?tica', '?Nuestros investigadores han construido un gigante mec?nico, con m?sculos de metal y coraz?n de vapor! ?Solo los soldados m?s valientes y h?biles pueden controlar semejante monstruo, que atormentar? al enemigo a diestra y siniestra en el campo de batalla!', 106560, 2, 'Construir gigantes a vapor en el cuartel', 12, 0),
(31, 'Fundici?n de Ca?ones', 'Nuestro hierro es cada vez mas pesado y duro. ?Ahora nos es posible fabricar tubos por donde tirar bolas gigantes a nuestros enemigos! ?Si podemos disparar bombas de largo alcance, nuestros enemigos y sus muros temblar?n del miedo!', 209040, 2, 'Construcci?n de morteros en el cuartel', 13, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigaciondescuentos`
--

CREATE TABLE IF NOT EXISTS `investigaciondescuentos` (
  `codigoinvestigacion` int(11) NOT NULL DEFAULT '0',
  `descripcion` varchar(50) NOT NULL,
  `descuento` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoinvestigacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigacionedificio`
--

CREATE TABLE IF NOT EXISTS `investigacionedificio` (
  `codigoinvestigacion` int(11) NOT NULL DEFAULT '0',
  `codigoedificio` int(11) NOT NULL,
  PRIMARY KEY (`codigoinvestigacion`),
  KEY `codigoedificio` (`codigoedificio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigacionjugador`
--

CREATE TABLE IF NOT EXISTS `investigacionjugador` (
  `codigoinvestigacion` int(11) NOT NULL DEFAULT '0',
  `codigojugador` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codigoinvestigacion`,`codigojugador`),
  KEY `codigojugador` (`codigojugador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `investigacionjugador`
--

INSERT INTO `investigacionjugador` (`codigoinvestigacion`, `codigojugador`) VALUES
(1, 40),
(2, 40),
(11, 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigacionopmilitar`
--

CREATE TABLE IF NOT EXISTS `investigacionopmilitar` (
  `codigoinvestigacion` int(11) NOT NULL DEFAULT '0',
  `codigoopmilitar` int(11) NOT NULL,
  PRIMARY KEY (`codigoinvestigacion`),
  KEY `codigoopmilitar` (`codigoopmilitar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigacionunidad`
--

CREATE TABLE IF NOT EXISTS `investigacionunidad` (
  `codigoinvestigacion` int(11) NOT NULL DEFAULT '0',
  `codigounidad` int(11) NOT NULL,
  PRIMARY KEY (`codigoinvestigacion`),
  KEY `codigounidad` (`codigounidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `isla`
--

CREATE TABLE IF NOT EXISTS `isla` (
  `codigoisla` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `coordenadax` int(2) DEFAULT NULL,
  `coordenaday` int(2) DEFAULT NULL,
  `codigoimagen` int(11) NOT NULL,
  `capacidadciudades` int(11) NOT NULL,
  `capacidaddisponible` int(11) NOT NULL,
  PRIMARY KEY (`codigoisla`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `codigoimagen` (`codigoimagen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=59 ;

--
-- Volcado de datos para la tabla `isla`
--

INSERT INTO `isla` (`codigoisla`, `nombre`, `coordenadax`, `coordenaday`, `codigoimagen`, `capacidadciudades`, `capacidaddisponible`) VALUES
(50, 'Ares', 11, 11, 49, 16, 5),
(51, 'Enduos', 11, 22, 50, 15, 11),
(52, 'Zeuz', 11, 33, 52, 14, 10),
(53, 'Hades', 22, 11, 49, 16, 13),
(54, 'Marte', 22, 22, 50, 15, 11),
(55, 'Mercurio', 22, 33, 52, 14, 11),
(56, 'Saturno', 33, 11, 49, 16, 12),
(57, 'Urano', 33, 22, 50, 15, 13),
(58, 'Neptuno', 33, 33, 52, 14, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `islarecurso`
--

CREATE TABLE IF NOT EXISTS `islarecurso` (
  `codigoisla` int(11) NOT NULL,
  `codigorecurso` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`codigoisla`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `islarecurso`
--

INSERT INTO `islarecurso` (`codigoisla`, `codigorecurso`) VALUES
(50, 9),
(51, 9),
(58, 9),
(52, 12),
(53, 12),
(54, 12),
(55, 14),
(57, 14),
(56, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE IF NOT EXISTS `jugador` (
  `codigojugador` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(30) NOT NULL,
  `clave` varchar(10) NOT NULL,
  `oro` int(11) DEFAULT NULL,
  `fechaingreso` date NOT NULL,
  `horaingreso` time NOT NULL,
  `puntostotales` int(11) DEFAULT '0',
  `protegido` tinyint(1) NOT NULL DEFAULT '1',
  `vacaciones` tinyint(1) NOT NULL DEFAULT '0',
  `fechaactualizacionoro` datetime DEFAULT NULL,
  PRIMARY KEY (`codigojugador`),
  UNIQUE KEY `nick` (`nick`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`codigojugador`, `nick`, `clave`, `oro`, `fechaingreso`, `horaingreso`, `puntostotales`, `protegido`, `vacaciones`, `fechaactualizacionoro`) VALUES
(6, 'Jonathan Victorica', '1234', 33333, '2014-09-30', '18:54:51', 780000, 0, 0, '2014-11-11 12:00:00'),
(7, 'Martin', '1234', 33333, '2014-09-30', '18:54:51', 500000, 0, 0, '2014-11-11 12:00:00'),
(8, 'Guillermo', '1234', 33333, '2014-09-30', '18:54:51', 250000, 0, 0, '2014-11-11 12:00:00'),
(9, 'Jonathan M', '1234', 33333, '2014-09-30', '18:54:51', 150000, 0, 0, '2014-11-11 12:00:00'),
(30, 'Guillermo II', '1234', 33333, '2014-09-30', '02:31:37', 0, 1, 0, '2014-11-11 12:00:00'),
(40, 'usuario 1', '1234', 33333, '2014-11-12', '00:09:46', 0, 1, 0, '2014-11-11 12:00:00'),
(41, 'aletg', '1234', 33333, '2014-11-28', '14:57:20', 0, 1, 0, NULL),
(42, 'JOHNNY', '1234', 33333, '2014-11-28', '15:05:46', 0, 1, 0, NULL),
(43, 'Señor del Fuego', '1234', 33283, '2014-12-14', '11:40:32', 0, 1, 0, NULL),
(44, 'Jonathan Martin', '1234', 33333, '2015-01-26', '12:46:23', 0, 1, 0, NULL),
(45, 'Pablo', '1234', 23163, '2015-02-19', '16:35:26', 0, 1, 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajeprivado`
--

CREATE TABLE IF NOT EXISTS `mensajeprivado` (
  `codigomensaje` int(11) NOT NULL AUTO_INCREMENT,
  `codigojugadorremi` int(11) DEFAULT NULL,
  `codigojugadorrec` int(11) NOT NULL,
  `mensaje` varchar(255) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `leido` tinyint(1) NOT NULL,
  PRIMARY KEY (`codigomensaje`),
  KEY `codigojugadorremi` (`codigojugadorremi`),
  KEY `codigojugadorrec` (`codigojugadorrec`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `mensajeprivado`
--

INSERT INTO `mensajeprivado` (`codigomensaje`, `codigojugadorremi`, `codigojugadorrec`, `mensaje`, `titulo`, `fecha`, `hora`, `leido`) VALUES
(1, 40, 9, 'Felicidades, un jugador ha comprado algo o el total de tu oferta en el mercado', 'HAZ HECHO NEGOCIO', '2014-11-20', '04:55:47', 0),
(2, 40, 9, 'Felicidades, un jugador ha comprado algo o el total de tu oferta en el mercado', 'HAZ HECHO NEGOCIO', '2014-11-20', '05:10:10', 0),
(3, 40, 7, 'que carajos es esto', 'Para vos', '2014-11-20', '12:08:32', 0),
(4, 41, 30, 'putoo!', 'yo', '2014-11-28', '15:01:30', 0),
(5, 43, 43, 'hols', 'hola', '2014-12-14', '12:07:51', 0),
(6, 43, 43, 'bien', 'bien', '2014-12-14', '12:08:19', 0),
(7, 43, 9, 'Felicidades, un jugador ha comprado algo o el total de tu oferta en el mercado', 'HAZ HECHO NEGOCIO', '2014-12-14', '12:14:04', 0),
(8, 43, 45, 'Felicidades, un jugador ha comprado algo o el total de tu oferta en el mercado', 'HAZ HECHO NEGOCIO', '2015-02-19', '16:55:03', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `misionmilitar`
--

CREATE TABLE IF NOT EXISTS `misionmilitar` (
  `codigomision` int(11) NOT NULL AUTO_INCREMENT,
  `nombremision` varchar(30) NOT NULL,
  PRIMARY KEY (`codigomision`),
  UNIQUE KEY `nombremision` (`nombremision`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `misionmilitar`
--

INSERT INTO `misionmilitar` (`codigomision`, `nombremision`) VALUES
(2, 'Apostar Barcos'),
(1, 'Apostar Tropas'),
(4, 'Bloquear Puerto'),
(5, 'Defender Puerto'),
(3, 'Saquear');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientobarcoactual`
--

CREATE TABLE IF NOT EXISTS `movimientobarcoactual` (
  `codigomov` int(11) NOT NULL AUTO_INCREMENT,
  `codigociudadsalida` int(11) NOT NULL,
  `codigociudaddestino` int(11) NOT NULL,
  `fechasalida` date NOT NULL,
  `horasalida` time NOT NULL,
  `fechallegada` date NOT NULL,
  `horallegada` time NOT NULL,
  PRIMARY KEY (`codigomov`),
  KEY `codigociudadsalida` (`codigociudadsalida`),
  KEY `codigociudaddestino` (`codigociudaddestino`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `movimientobarcoactual`
--

INSERT INTO `movimientobarcoactual` (`codigomov`, `codigociudadsalida`, `codigociudaddestino`, `fechasalida`, `horasalida`, `fechallegada`, `horallegada`) VALUES
(1, 1, 2, '2014-11-19', '09:55:42', '2014-11-19', '10:05:42'),
(2, 1, 2, '2014-11-19', '09:55:57', '2014-11-19', '10:05:57'),
(3, 48, 53, '2014-11-20', '12:44:01', '2014-11-20', '12:54:01'),
(4, 56, 38, '2014-11-28', '15:03:54', '2014-11-28', '15:13:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientomilitar`
--

CREATE TABLE IF NOT EXISTS `movimientomilitar` (
  `codigomov` int(11) NOT NULL DEFAULT '0',
  `codigoataque` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigomov`),
  KEY `codigoataque` (`codigoataque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivelciudad`
--

CREATE TABLE IF NOT EXISTS `nivelciudad` (
  `nivel` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `capacidadhabitante` int(11) DEFAULT NULL,
  `capacidadmilitarterrestre` int(11) DEFAULT NULL,
  `capacidadmilitarnaval` int(11) DEFAULT NULL,
  `impuestociudadano` int(11) DEFAULT NULL,
  `codigoimagen` int(11) NOT NULL,
  `cantidadmaderamaxima` int(11) NOT NULL,
  `cantidadrecursomaxima` int(11) NOT NULL,
  `codigoimagenciudad` int(11) NOT NULL,
  PRIMARY KEY (`nivel`),
  KEY `codigoimagen` (`codigoimagen`),
  KEY `codigoimagenciudad` (`codigoimagenciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nivelciudad`
--

INSERT INTO `nivelciudad` (`nivel`, `capacidadhabitante`, `capacidadmilitarterrestre`, `capacidadmilitarnaval`, `impuestociudadano`, `codigoimagen`, `cantidadmaderamaxima`, `cantidadrecursomaxima`, `codigoimagenciudad`) VALUES
(1, 500, 1000, 100, 5, 121, 250, 250, 1),
(2, 750, 2000, 200, 5, 121, 375, 375, 1),
(3, 1000, 3000, 300, 5, 121, 500, 500, 1),
(4, 1250, 4000, 400, 5, 123, 625, 625, 1),
(5, 1500, 5000, 500, 5, 123, 750, 750, 1),
(6, 1750, 6000, 600, 5, 48, 875, 875, 1),
(7, 2000, 7000, 700, 5, 48, 1000, 1000, 1),
(8, 2250, 8000, 800, 5, 124, 1125, 1125, 1),
(9, 2500, 9000, 900, 5, 124, 1250, 1250, 1),
(10, 2750, 10000, 1000, 10, 125, 1375, 1375, 1),
(11, 3000, 11000, 1100, 10, 125, 1500, 1500, 1),
(12, 3250, 12000, 1200, 10, 126, 1625, 1625, 1),
(13, 3500, 13000, 1300, 10, 126, 1750, 1750, 1),
(14, 3750, 14000, 1400, 10, 126, 1875, 1875, 1),
(15, 4000, 15000, 1500, 10, 126, 2000, 2000, 1),
(16, 4250, 16000, 1600, 10, 127, 2125, 2125, 1),
(17, 4500, 17000, 1700, 10, 127, 2250, 2250, 1),
(18, 4750, 18000, 1800, 10, 127, 2375, 2375, 1),
(19, 5000, 19000, 1900, 10, 128, 2500, 2500, 1),
(20, 5250, 20000, 2000, 10, 128, 2625, 2625, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE IF NOT EXISTS `oferta` (
  `codigooferta` int(11) NOT NULL AUTO_INCREMENT,
  `codigorecurso` tinyint(3) unsigned NOT NULL,
  `cantidadofrecida` int(11) DEFAULT NULL,
  `orobuscado` int(11) DEFAULT NULL,
  `codigorecursobuscado` tinyint(3) unsigned DEFAULT NULL,
  `jugador` tinyint(1) NOT NULL DEFAULT '0',
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`codigooferta`),
  KEY `codigorecurso` (`codigorecurso`),
  KEY `codigorecursobuscado` (`codigorecursobuscado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`codigooferta`, `codigorecurso`, `cantidadofrecida`, `orobuscado`, `codigorecursobuscado`, `jugador`, `fecha`) VALUES
(1, 6, 217, 1, NULL, 0, '2014-10-29 23:54:12'),
(6, 15, 29667, 0, 9, 1, '2014-10-29 23:54:12'),
(7, 15, 22400, 0, 9, 1, '2014-10-29 23:54:12'),
(8, 15, 5600, 0, 6, 1, '2014-10-29 23:54:12'),
(10, 9, 12000, 0, 15, 1, '2014-10-29 23:54:12'),
(11, 9, 30000, 0, 6, 1, '2014-10-29 23:54:12'),
(12, 9, 3922, 0, 6, 1, '2014-10-29 23:54:12'),
(16, 14, 22, 1, NULL, 0, '2014-10-29 23:54:12'),
(21, 6, 8994, 0, 15, 1, '2014-10-30 11:21:50'),
(22, 6, 200000, 0, 15, 1, '2014-10-30 11:52:27'),
(23, 14, 10000, 0, 6, 1, '2014-10-30 12:04:41'),
(24, 6, 10000, 0, 15, 1, '2014-10-30 12:09:15'),
(25, 15, 2900, 0, 6, 1, '2014-10-30 14:57:55'),
(28, 6, 10000, 0, 15, 1, '2014-11-12 10:25:33'),
(29, 6, 1000000000, 0, 15, 1, '2014-12-14 12:15:52'),
(30, 6, 1000000000, 0, 14, 1, '2014-12-14 12:16:16'),
(31, 6, 147483647, 0, 15, 1, '2014-12-14 12:16:43'),
(33, 6, 888, 1, NULL, 1, '2015-02-19 16:59:32');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertajugador`
--

CREATE TABLE IF NOT EXISTS `ofertajugador` (
  `codigooferta` int(11) NOT NULL DEFAULT '0',
  `codigojugador` int(11) NOT NULL,
  PRIMARY KEY (`codigooferta`),
  KEY `codigojugador` (`codigojugador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ofertajugador`
--

INSERT INTO `ofertajugador` (`codigooferta`, `codigojugador`) VALUES
(6, 8),
(7, 8),
(8, 8),
(10, 9),
(11, 9),
(12, 9),
(21, 9),
(22, 9),
(23, 9),
(24, 9),
(25, 9),
(28, 40),
(29, 43),
(30, 43),
(31, 43),
(33, 45);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntosjugador`
--

CREATE TABLE IF NOT EXISTS `puntosjugador` (
  `codigojugador` int(11) NOT NULL AUTO_INCREMENT,
  `puntosconstructor` int(11) DEFAULT '0',
  `puntossoldado` int(11) DEFAULT '0',
  `puntosdefenta` int(11) DEFAULT '0',
  `puntosataque` int(11) DEFAULT '0',
  `puntosinvestigacion` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codigojugador`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Volcado de datos para la tabla `puntosjugador`
--

INSERT INTO `puntosjugador` (`codigojugador`, `puntosconstructor`, `puntossoldado`, `puntosdefenta`, `puntosataque`, `puntosinvestigacion`) VALUES
(6, 10, 10, 10, 10, 30000100),
(7, 10, 10, 10, 10, 30000000),
(8, 10, 10, 10, 10, 30000000),
(9, 10, 10, 10, 10, 29999984),
(30, 0, 0, 0, 0, 30000000),
(40, 0, 0, 0, 0, 29042074),
(41, 0, 0, 0, 0, 0),
(42, 0, 0, 0, 0, 0),
(43, 0, 0, 0, 0, 0),
(44, 0, 0, 0, 0, 0),
(45, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recurso`
--

CREATE TABLE IF NOT EXISTS `recurso` (
  `codigorecurso` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `codigoimagen` int(11) NOT NULL,
  PRIMARY KEY (`codigorecurso`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `codigoimagen` (`codigoimagen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `recurso`
--

INSERT INTO `recurso` (`codigorecurso`, `nombre`, `codigoimagen`) VALUES
(6, 'Madera', 14),
(9, 'Azufre', 16),
(12, 'Cristal', 16),
(14, 'Vino', 20),
(15, 'Marmol', 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temainvestigacion`
--

CREATE TABLE IF NOT EXISTS `temainvestigacion` (
  `codigotema` int(11) NOT NULL DEFAULT '0',
  `tema` varchar(25) NOT NULL,
  PRIMARY KEY (`codigotema`),
  KEY `tema` (`tema`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `temainvestigacion`
--

INSERT INTO `temainvestigacion` (`codigotema`, `tema`) VALUES
(3, 'Ciencia'),
(4, 'Economìa'),
(2, 'Milicia'),
(1, 'Navegaci?n');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipomision`
--

CREATE TABLE IF NOT EXISTS `tipomision` (
  `codigomision` int(11) NOT NULL DEFAULT '0',
  `tipomision` varchar(30) NOT NULL,
  PRIMARY KEY (`codigomision`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidadmilitar`
--

CREATE TABLE IF NOT EXISTS `unidadmilitar` (
  `codigounidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `descripcion` text NOT NULL,
  `codigoimagen` int(11) NOT NULL,
  `costo` int(11) DEFAULT NULL,
  `puntosdefensivos` int(11) DEFAULT NULL,
  `puntosataque` int(11) DEFAULT NULL,
  `barco` tinyint(1) NOT NULL,
  `nivelnecesario` int(11) NOT NULL,
  `carga` int(11) DEFAULT NULL,
  `cantidadhabitantes` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigounidad`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `codigoimagen` (`codigoimagen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Volcado de datos para la tabla `unidadmilitar`
--

INSERT INTO `unidadmilitar` (`codigounidad`, `nombre`, `descripcion`, `codigoimagen`, `costo`, `puntosdefensivos`, `puntosataque`, `barco`, `nivelnecesario`, `carga`, `cantidadhabitantes`) VALUES
(20, 'Gigante a Vapor', 'Esta m?quina poderosa se mueve como un humano en el campo de Batalla, pero tiene una fuerza de golpe sobrehumana. Piedras, flechas y espadas rebotan contra esta m?quina. ?Ay de aqu?l que se atreva a oponerse! ', 31, 2, 3, 42, 0, 14, 10, 1),
(21, 'Hoplita', 'Los Hoplitas en Ikariam son pesados hombres armados con lanzas que provienen de la clase media de la ciudad. Forman el coraz?n de cada ej?rcito griego. En la conocida como formaci?n "en Falange", avanzan como una pared imparable de lanzas y escudos. ', 31, 1, 1, 18, 0, 1, 15, 1),
(23, 'Espadachin', 'Los espadachines apenas est?n acorazados y luchan sin escudo para conservar su movilidad. De este modo, ellos pueden rodear las inm?viles formaciones de Hoplitas y atacar desde los flancos.', 31, 1, 0, 10, 0, 3, 15, 1),
(24, 'Lancero', 'Los Lanceros son reclutas de la poblaci?n rural que se lanzan a la Batalla equipados con una armadura ligera y una simple lanza. No suelen tener ninguna posibilidad contra la mayor?a de los soldados profesionales.', 31, 1, 0, 4, 0, 1, 10, 1),
(25, 'Arquero', 'El arco es un instrumento de caza muy difundido, as? que no cuesta mucho esfuerzo reclutarlos de entre los ciudadanos. Con una formaci?n militar, los simples ciudadanos se convertir?n en una tropa formidable de combate a distancia. ', 31, 1, 0, 5, 0, 4, 15, 1),
(26, 'Fusilero', 'Los disparos del fusilero pueden penetran hasta en los blindajes m?s resistentes. Sin embargo, debido a su l?nea de visi?n, solamente una fila de tiradores pueden disparar, mientras el resto tiene que recargar. Investigaci?n Requerida: P?lvora (Milicia)', 31, 1, 0, 15, 0, 5, 15, 1),
(27, 'Hondero', 'Las hondas son armas ligeras y baratas. No infligen mucho da?o en los oponentes bien armados, pero al menos su munici?n est? f?cilmente disponible.', 31, 1, 0, 3, 0, 6, 15, 1),
(28, 'Ariete', 'Hombres robustos balancean el tronco macizo de un ?rbol contra los portones enemigos hasta que ?stos ceden y los hombres corren para buscar cubierta bajo el tejado. Bien es verdad que es ?til solamente para derribar portones de madera o muros, pero hay que ver que no necesita ning?n tipo de munici?n.', 31, 5, 1, 45, 0, 7, 10, 1),
(29, 'Catapulta', 'Las catapultas lanzan grandes rocas contra las instalaciones de defensa del enemigo, destruyendo de este modo hasta los muros de piedra m?s robustos. No obstante, son poco eficaces en defensa contra ej?rcitos enemigos.', 31, 5, 0, 70, 0, 8, 15, 1),
(30, 'Mortero', 'El mortero dispara balas explosivas contra los muros de una ciudad sitiada. No hay edificio que pueda resistir a su fuerza de destrucci?n. No obstante, la escasa munici?n tiene que ser tra?da adicionalmente, por ello, los disparos deben estar bien dirigidos.', 31, 5, 0, 140, 0, 9, 15, 1),
(31, 'Girocoptero', 'Una nave muy novedosa que es muy r?pida, f?cil de manejar y que no depende de la direcci?n del viento. ?Con esta m?quina podemos dar caza a nuestros enemigos que nos quieren atacar cobardemente desde el cielo! ', 31, 3, 0, 17, 0, 11, 15, 1),
(32, 'Globo Bombardero', 'Nuestros inventores han descubierto que el sol es tan caliente porque atrae aire caliente. Es por eso que un globo lleno de aire caliente asciende en direcci?n al sol. Con este m?todo, nuestros soldados pueden tirar desde arriba barriles explosivos a nuestros enemigos. ', 31, 5, 0, 48, 0, 17, 15, 1),
(33, 'Barco Espolon', 'Equipado con un simple espol?n en la proa del barco, este barco es el barco de guerra elemental de la marina. Una docena de remeros fuertes hacen que este barco tome una gran velocidad para hundir con toda fuerza el espol?n en el casco enemigo. A menudo esto es suficiente para hundir un barco enemigo. Investigaci?n Requerida: Ninguna', 31, 1, 10, 5, 1, 14, 0, 3),
(34, 'Barco Lanzallamas', 'En la proa del barco lanza llamas se encuentra un lanzallamas que echa fuego griego sobre el mar. Hasta en la superficie del oc?ano, la mezcla sigue quemando y creando de esta manera una alfombra de llamas.;?Un barco de combate muy terror?fico! ;Investigaci?n Requerida: Fuego Griego (Navegaci?n)', 31, 2, 15, 10, 1, 1, 0, 3),
(35, 'Barco Espolon a vapor', 'Al igual que el barco-espol?n, el barco-espol?n de vapor est? equipado con un espol?n en la proa. Sin embargo, se trata de una versi?n mucho m?s avanzada.Gracias a su mecanismo accionado por vapor, este barco es capaz de acelerar a?n m?s deprisa y causar tremendos da?os al enemigo.El barco-espol?n de vapor es la nave m?s peligrosa de la l?nea de batalla. ;Investigaci?n Requerida: Espol?n Macizo (Navegaci?n)', 31, 3, 20, 15, 1, 3, 0, 3),
(36, 'Barco Ballesta', 'Este barco esta provisto de una ballesta que estaba predestinada para disparar ganchos de abordaje.Sin embargo, la ballesta, como arma precisa de lucha a distancia, es muy valiosa para acertar a los enemigos bajo la l?nea de agua; aunque no provoque graves da?os. ;Investigaci?n Requerida: Armamento en cubierta (Navegaci?n)', 31, 2, 10, 15, 1, 1, 0, 3),
(37, 'Barco Catapulta', 'La catapulta sobre la cubierta de este barco es m?s peque?a que su equivalente en tierra debido al espacio.Las olas del oc?ano hacen que esta no sea precisa, no obstante, esta catapulta dispara orzas con aceite candente que dejan peligrosas mareas negras sobre el mar. ;Investigaci?n Requerida: Contrapeso (Navegaci?n)', 31, 3, 10, 20, 1, 4, 0, 3),
(38, 'barco Mortero', 'El barco-mortero tiene un casco sumamente ancho con un elevado desplazamiento de agua a fin de que pueda resistir la enorme repercusi?n del mortero.Si la mecha de un proyectil es medida correctamente, el potente proyectil explota justo sobre la cubierta del enemigo. ;Investigaci?n Requerida: Base para morteros (Navegaci?n)', 31, 3, 10, 30, 1, 5, 0, 3),
(39, 'Submarino', 'Un barco que navega por debajo de la superficie es el arma definitiva de los mares.Puede pasar casi desapercibido hasta las filas enemigas y ah? provocar da?os terribles.;Investigaci?n Requerida: C?mara hiperb?rica (Ciencia)', 31, 5, 25, 20, 1, 6, 0, 3),
(40, 'Barco LanzaMisiles', 'Gracias a sus investigaciones, nuestros cient?ficos han conseguido rellenar con ingentes cantidades de polvo explosivo un dep?sito de madera.Si es encendido correctamente, puede recorrer varios cientos de metros sobre la superficie del mar y causar una formidable explosi?n al chocar contra los barcos enemigos.?Que tiemblen nuestros adversarios ante esta nueva arma! ;Investigaci?n Requerida: P?lvora (Milicia)', 31, 5, 15, 40, 1, 9, 0, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidadmilitarconstruccion`
--

CREATE TABLE IF NOT EXISTS `unidadmilitarconstruccion` (
  `codigounidad` int(11) NOT NULL DEFAULT '0',
  `codigorecurso` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigounidad`,`codigorecurso`),
  KEY `codigorecurso` (`codigorecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `unidadmilitarconstruccion`
--

INSERT INTO `unidadmilitarconstruccion` (`codigounidad`, `codigorecurso`, `cantidad`) VALUES
(20, 6, 130),
(20, 9, 180),
(21, 6, 40),
(21, 9, 30),
(23, 6, 30),
(23, 9, 30),
(24, 6, 30),
(25, 6, 30),
(25, 9, 25),
(26, 6, 50),
(26, 9, 150),
(27, 6, 20),
(28, 6, 220),
(29, 6, 260),
(29, 9, 300),
(30, 6, 300),
(30, 9, 1250),
(31, 6, 25),
(31, 9, 100),
(32, 6, 40),
(32, 9, 250),
(33, 6, 250),
(33, 9, 0),
(33, 12, 0),
(34, 6, 80),
(34, 9, 230),
(34, 12, 0),
(35, 6, 400),
(35, 9, 800),
(35, 12, 0),
(36, 6, 180),
(36, 9, 160),
(36, 12, 0),
(37, 6, 180),
(37, 9, 140),
(37, 12, 0),
(38, 6, 220),
(38, 9, 900),
(38, 12, 0),
(39, 6, 160),
(39, 9, 100),
(39, 12, 750),
(40, 6, 200),
(40, 9, 1200),
(40, 12, 0);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `apostamientotropa`
--
ALTER TABLE `apostamientotropa`
  ADD CONSTRAINT `apostamientotropa_ibfk_1` FOREIGN KEY (`codigoapostamiento`) REFERENCES `ataque` (`codigoataque`),
  ADD CONSTRAINT `apostamientotropa_ibfk_2` FOREIGN KEY (`codigociudapostador`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `apostamientotropa_ibfk_3` FOREIGN KEY (`codigociudadapostada`) REFERENCES `ciudad` (`codigociudad`);

--
-- Filtros para la tabla `apostamientounidad`
--
ALTER TABLE `apostamientounidad`
  ADD CONSTRAINT `apostamientounidad_ibfk_1` FOREIGN KEY (`codigoapostamiento`) REFERENCES `apostamientotropa` (`codigoapostamiento`),
  ADD CONSTRAINT `apostamientounidad_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
  ADD CONSTRAINT `apostamientounidad_ibfk_3` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);

--
-- Filtros para la tabla `arma`
--
ALTER TABLE `arma`
  ADD CONSTRAINT `arma_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);

--
-- Filtros para la tabla `armaconstruccion`
--
ALTER TABLE `armaconstruccion`
  ADD CONSTRAINT `armaconstruccion_ibfk_1` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`),
  ADD CONSTRAINT `armaconstruccion_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `armaunidad`
--
ALTER TABLE `armaunidad`
  ADD CONSTRAINT `armaunidad_ibfk_1` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
  ADD CONSTRAINT `armaunidad_ibfk_2` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);

--
-- Filtros para la tabla `asalto`
--
ALTER TABLE `asalto`
  ADD CONSTRAINT `asalto_ibfk_1` FOREIGN KEY (`codigoataque`) REFERENCES `ataque` (`codigoataque`),
  ADD CONSTRAINT `asalto_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `ataque`
--
ALTER TABLE `ataque`
  ADD CONSTRAINT `ataque_ibfk_1` FOREIGN KEY (`codigociudadjugatacante`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `ataque_ibfk_2` FOREIGN KEY (`codigociudadjugatacado`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `ataque_ibfk_3` FOREIGN KEY (`codigomision`) REFERENCES `misionmilitar` (`codigomision`),
  ADD CONSTRAINT `ataque_ibfk_4` FOREIGN KEY (`codjugadorganador`) REFERENCES `jugador` (`codigojugador`);

--
-- Filtros para la tabla `ataqueunidaddecombate`
--
ALTER TABLE `ataqueunidaddecombate`
  ADD CONSTRAINT `ataqueunidaddecombate_ibfk_1` FOREIGN KEY (`codigoataque`) REFERENCES `ataque` (`codigoataque`),
  ADD CONSTRAINT `ataqueunidaddecombate_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
  ADD CONSTRAINT `ataqueunidaddecombate_ibfk_3` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);

--
-- Filtros para la tabla `barcomovimiento`
--
ALTER TABLE `barcomovimiento`
  ADD CONSTRAINT `barcomovimiento_ibfk_1` FOREIGN KEY (`codigomov`) REFERENCES `movimientobarcoactual` (`codigomov`),
  ADD CONSTRAINT `barcomovimiento_ibfk_2` FOREIGN KEY (`codigobarco`) REFERENCES `barcos` (`codigobarco`);

--
-- Filtros para la tabla `barcos`
--
ALTER TABLE `barcos`
  ADD CONSTRAINT `barcos_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);

--
-- Filtros para la tabla `carga`
--
ALTER TABLE `carga`
  ADD CONSTRAINT `carga_ibfk_1` FOREIGN KEY (`codigomov`) REFERENCES `movimientobarcoactual` (`codigomov`),
  ADD CONSTRAINT `carga_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `cargamilitar`
--
ALTER TABLE `cargamilitar`
  ADD CONSTRAINT `cargamilitar_ibfk_1` FOREIGN KEY (`codigomov`) REFERENCES `movimientomilitar` (`codigomov`),
  ADD CONSTRAINT `cargamilitar_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
  ADD CONSTRAINT `cargamilitar_ibfk_3` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);

--
-- Filtros para la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`),
  ADD CONSTRAINT `ciudad_ibfk_2` FOREIGN KEY (`codigoisla`) REFERENCES `isla` (`codigoisla`),
  ADD CONSTRAINT `ciudad_ibfk_3` FOREIGN KEY (`nivel`) REFERENCES `nivelciudad` (`nivel`),
  ADD CONSTRAINT `ciudad_ibfk_4` FOREIGN KEY (`codigoestado`) REFERENCES `estadociudad` (`codigoestado`);

--
-- Filtros para la tabla `ciudadacademia`
--
ALTER TABLE `ciudadacademia`
  ADD CONSTRAINT `ciudadacademia_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`);

--
-- Filtros para la tabla `ciudadbarco`
--
ALTER TABLE `ciudadbarco`
  ADD CONSTRAINT `ciudadbarco_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `ciudadbarco_ibfk_2` FOREIGN KEY (`codigobarco`) REFERENCES `barcos` (`codigobarco`);

--
-- Filtros para la tabla `ciudadedificionivel`
--
ALTER TABLE `ciudadedificionivel`
  ADD CONSTRAINT `ciudadedificionivel_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `ciudadedificionivel_ibfk_2` FOREIGN KEY (`codigoedificio`) REFERENCES `edificionivel` (`codigoedifnivel`);

--
-- Filtros para la tabla `ciudadejercito`
--
ALTER TABLE `ciudadejercito`
  ADD CONSTRAINT `ciudadejercito_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `ciudadejercito_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`);

--
-- Filtros para la tabla `ciudadejercitoarma`
--
ALTER TABLE `ciudadejercitoarma`
  ADD CONSTRAINT `ciudadejercitoarma_ibfk_1` FOREIGN KEY (`codigounidadciudad`) REFERENCES `ciudadejercito` (`codigounidadciudad`),
  ADD CONSTRAINT `ciudadejercitoarma_ibfk_2` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);

--
-- Filtros para la tabla `ciudadproduccion`
--
ALTER TABLE `ciudadproduccion`
  ADD CONSTRAINT `ciudadproduccion_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `ciudadproduccion_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `ciudadrecurso`
--
ALTER TABLE `ciudadrecurso`
  ADD CONSTRAINT `ciudadrecurso_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `ciudadrecurso_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `ciudadtaberna`
--
ALTER TABLE `ciudadtaberna`
  ADD CONSTRAINT `ciudadtaberna_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`);

--
-- Filtros para la tabla `depositomercado`
--
ALTER TABLE `depositomercado`
  ADD CONSTRAINT `depositomercado_ibfk_1` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`),
  ADD CONSTRAINT `depositomercado_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `edificio`
--
ALTER TABLE `edificio`
  ADD CONSTRAINT `edificio_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);

--
-- Filtros para la tabla `edificionivel`
--
ALTER TABLE `edificionivel`
  ADD CONSTRAINT `edificionivel_ibfk_1` FOREIGN KEY (`codigoedificio`) REFERENCES `edificio` (`codigoedificio`);

--
-- Filtros para la tabla `edificiorecurso`
--
ALTER TABLE `edificiorecurso`
  ADD CONSTRAINT `edificiorecurso_ibfk_1` FOREIGN KEY (`codigoedifnivel`) REFERENCES `edificionivel` (`codigoedifnivel`),
  ADD CONSTRAINT `edificiorecurso_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `guerraataque`
--
ALTER TABLE `guerraataque`
  ADD CONSTRAINT `guerraataque_ibfk_1` FOREIGN KEY (`codigoguerra`) REFERENCES `guerra` (`codigoguerra`),
  ADD CONSTRAINT `guerraataque_ibfk_2` FOREIGN KEY (`codigoataque`) REFERENCES `ataque` (`codigoataque`);

--
-- Filtros para la tabla `guerraparticipante`
--
ALTER TABLE `guerraparticipante`
  ADD CONSTRAINT `guerraparticipante_ibfk_1` FOREIGN KEY (`codigoguerra`) REFERENCES `guerra` (`codigoguerra`),
  ADD CONSTRAINT `guerraparticipante_ibfk_2` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`);

--
-- Filtros para la tabla `investigacion`
--
ALTER TABLE `investigacion`
  ADD CONSTRAINT `investigacion_ibfk_1` FOREIGN KEY (`codigotema`) REFERENCES `temainvestigacion` (`codigotema`);

--
-- Filtros para la tabla `investigaciondescuentos`
--
ALTER TABLE `investigaciondescuentos`
  ADD CONSTRAINT `investigaciondescuentos_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`);

--
-- Filtros para la tabla `investigacionedificio`
--
ALTER TABLE `investigacionedificio`
  ADD CONSTRAINT `investigacionedificio_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`),
  ADD CONSTRAINT `investigacionedificio_ibfk_2` FOREIGN KEY (`codigoedificio`) REFERENCES `edificio` (`codigoedificio`);

--
-- Filtros para la tabla `investigacionjugador`
--
ALTER TABLE `investigacionjugador`
  ADD CONSTRAINT `investigacionjugador_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`),
  ADD CONSTRAINT `investigacionjugador_ibfk_2` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`);

--
-- Filtros para la tabla `investigacionopmilitar`
--
ALTER TABLE `investigacionopmilitar`
  ADD CONSTRAINT `investigacionopmilitar_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`),
  ADD CONSTRAINT `investigacionopmilitar_ibfk_2` FOREIGN KEY (`codigoopmilitar`) REFERENCES `misionmilitar` (`codigomision`);

--
-- Filtros para la tabla `investigacionunidad`
--
ALTER TABLE `investigacionunidad`
  ADD CONSTRAINT `investigacionunidad_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`),
  ADD CONSTRAINT `investigacionunidad_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`);

--
-- Filtros para la tabla `isla`
--
ALTER TABLE `isla`
  ADD CONSTRAINT `isla_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);

--
-- Filtros para la tabla `islarecurso`
--
ALTER TABLE `islarecurso`
  ADD CONSTRAINT `islarecurso_ibfk_1` FOREIGN KEY (`codigoisla`) REFERENCES `isla` (`codigoisla`),
  ADD CONSTRAINT `islarecurso_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `mensajeprivado`
--
ALTER TABLE `mensajeprivado`
  ADD CONSTRAINT `mensajeprivado_ibfk_1` FOREIGN KEY (`codigojugadorremi`) REFERENCES `jugador` (`codigojugador`),
  ADD CONSTRAINT `mensajeprivado_ibfk_2` FOREIGN KEY (`codigojugadorrec`) REFERENCES `jugador` (`codigojugador`);

--
-- Filtros para la tabla `movimientobarcoactual`
--
ALTER TABLE `movimientobarcoactual`
  ADD CONSTRAINT `movimientobarcoactual_ibfk_1` FOREIGN KEY (`codigociudadsalida`) REFERENCES `ciudad` (`codigociudad`),
  ADD CONSTRAINT `movimientobarcoactual_ibfk_2` FOREIGN KEY (`codigociudaddestino`) REFERENCES `ciudad` (`codigociudad`);

--
-- Filtros para la tabla `movimientomilitar`
--
ALTER TABLE `movimientomilitar`
  ADD CONSTRAINT `movimientomilitar_ibfk_1` FOREIGN KEY (`codigomov`) REFERENCES `movimientobarcoactual` (`codigomov`),
  ADD CONSTRAINT `movimientomilitar_ibfk_2` FOREIGN KEY (`codigoataque`) REFERENCES `ataque` (`codigoataque`);

--
-- Filtros para la tabla `nivelciudad`
--
ALTER TABLE `nivelciudad`
  ADD CONSTRAINT `nivelciudad_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`),
  ADD CONSTRAINT `nivelciudad_ibfk_2` FOREIGN KEY (`codigoimagenciudad`) REFERENCES `imagenes` (`codigoimagen`);

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `oferta_ibfk_1` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`),
  ADD CONSTRAINT `oferta_ibfk_2` FOREIGN KEY (`codigorecursobuscado`) REFERENCES `recurso` (`codigorecurso`);

--
-- Filtros para la tabla `ofertajugador`
--
ALTER TABLE `ofertajugador`
  ADD CONSTRAINT `ofertajugador_ibfk_1` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`),
  ADD CONSTRAINT `ofertajugador_ibfk_2` FOREIGN KEY (`codigooferta`) REFERENCES `oferta` (`codigooferta`);

--
-- Filtros para la tabla `puntosjugador`
--
ALTER TABLE `puntosjugador`
  ADD CONSTRAINT `puntosjugador_ibfk_1` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`);

--
-- Filtros para la tabla `recurso`
--
ALTER TABLE `recurso`
  ADD CONSTRAINT `recurso_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);

--
-- Filtros para la tabla `unidadmilitar`
--
ALTER TABLE `unidadmilitar`
  ADD CONSTRAINT `unidadmilitar_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);

--
-- Filtros para la tabla `unidadmilitarconstruccion`
--
ALTER TABLE `unidadmilitarconstruccion`
  ADD CONSTRAINT `unidadmilitarconstruccion_ibfk_1` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
  ADD CONSTRAINT `unidadmilitarconstruccion_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

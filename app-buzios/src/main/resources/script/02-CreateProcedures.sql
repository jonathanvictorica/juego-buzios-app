
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
INSERT INTO jugador(nick,clave,fechaingreso,estado,puntostotales,protegido,vacaciones) values(nick,clave,now(),activo,0,true,false);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERTAR_JUGADORES`(in nick varchar(30), in clave varchar(10),in oro int, in fechaingreso date, puntostotales int, protegido boolean, vacaciones boolean)
BEGIN
INSERT INTO jugador(NICK,CLAVE,ORO,FECHAINGRESO,HORAINGRESO,PUNTOSTOTALES,PROTEGIDO,VACACIONES) VALUES(nick,clave,oro,fechaingreso,curtime(),puntostotales,protegido,vacaciones);


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
UPDATE jugador SET ORO=ORO-CANTIDADORO WHERE NICK=NICKJUGADOR;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `recaudarimpuesto`(in codigo_jugador int, out dineroimpuesto int)
begin


    set dineroimpuesto=(select sum(ciudad.cantidadhabitantes * nivelciudad.impuestociudadano) as cantidad from ciudad,nivelciudad where ciudad.nivel=nivelciudad.nivel and ciudad.codigojugador=codigo_jugador);


end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RECIBIR_ORO`(IN `NICKJUGADOR` VARCHAR(30), IN `CANTIDADORO` INT)
BEGIN
UPDATE jugador SET ORO=ORO+CANTIDADORO WHERE NICK=NICKJUGADOR;
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
    IF((SELECT COUNT(*) FROM jugador WHERE NICK=NICKJUGADOR AND ORO>=CANTIDADORO)=1) THEN
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



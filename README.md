# FindECI

## Integrantes y Roles

|     Nombre    |     Rol         |
|:--------------:|:-------------: |
|Sebastian Henao|Product Owner    |
|Nicolas Cortes |Team Developer   |
|Andrés Quintero|Team Developer   |
|Jimmy Chirivi  |Team Developer   |

## Estado del Proyecto
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4a6a74e870f249488c6e5cf64756b313)](https://www.codacy.com/gh/FindECI/find-eci?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=FindECI/find-eci&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/FindECI/find-eci.svg?style=svg)](https://circleci.com/gh/FindECI/find-eci)
## Descripción del proyecto

Por medio de esta aplicación, la comunidad estudiantil de la Escuela Colombiana de Ingenieria podra establecer citas y conversaciones por medio de sus redes sociales para conocersen y poder llegar a tener una relación del tipo que los usuarios deseen. Adicionalmente permite que las personas que se conozcan tengan gustos similares y congenien más de la cuenta. 


## Cronograma de Find Eci

Como grupo utilizamos el metodo de Scrum para poder llevar acabado cada proceso del proyecto acontinuacion se muestra los avances del proyecto: 

- https://tree.taiga.io/project/jchirivi97-find-eci/timeline

## Diseño de interfaz gráfica 

Para realizar el modelo inicial de la interfaz gráfica de nuestro proyecto usamos la herramienta mockflow:

* https://wireframepro.mockflow.com/view/M5ba6b261fd09d3616ff208cc7ec17c1a1582298444241

## Link a nuestra aplicación 
* http://find-eci.herokuapp.com/

## Diagrama de componentes
![Components](https://user-images.githubusercontent.com/47215172/76792730-a981db00-6791-11ea-853a-ade23b1034a3.PNG)
## Casos de uso
![casos_de_uso](https://user-images.githubusercontent.com/48091585/82500436-fb5c1f80-9ab8-11ea-9b07-f42faf213199.png)
##  Diagrama de clases
![clases](https://user-images.githubusercontent.com/48091585/82500557-2fcfdb80-9ab9-11ea-93ab-68af914b8c93.png)
##  Diagrama de Bases de Datos
![Entidad_relacion_final](https://user-images.githubusercontent.com/48091585/82500468-0911a500-9ab9-11ea-9612-363c13771113.png)
## Diagrama de Despliegue
![despliegue](https://user-images.githubusercontent.com/48091585/77484985-03ba1600-6dfa-11ea-97a7-550069c2801b.png)

## Manual de uso:
A continuación se mostrara una guia de inicio para navegar y usar la aplicación:
* La página incial muestra el formulario para realizar inicio de sesion en los campos debera poner su correo electronico e.g "usuario@mail.com" y la contraseña que ha puesto en el registro

![guia1](https://user-images.githubusercontent.com/48091585/82501357-c18c1880-9aba-11ea-807b-f0d282403d17.png)

* En caso de no estár registrado debe hacer click en el boton rojo "!Registrate!", el cual lo redirige al formulario en donde debe ingresar sus datos personales, como se muestra en la imagen

![guia2](https://user-images.githubusercontent.com/48091585/82501842-86d6b000-9abb-11ea-8680-ac4f5fe8b32f.png)

Al dar click en continuar se le informara que el usuario fue creado exitosamente, y tendra que escoger la carrera que está cursando actualmente y elgir el semestre que está cursando, como se muestra en la imagen

![guia3](https://user-images.githubusercontent.com/48091585/82502092-049abb80-9abc-11ea-8a31-86f0265c9eb7.png)

Al dar click en continuar se le informara que la carrera se registro correctamente, y a continuacion se mostrara el formulario en donde debe escoger su genero de interes, el tipo de relacion que desea y seleccionar los intereses que desearia tener en común con su posible pareja.

![guia4](https://user-images.githubusercontent.com/48091585/82502414-a6220d00-9abc-11ea-91b6-39e3653532e3.png)

Al dar click en continuar se le notificara que sus intereses fueron guardados satisfactoriamente. Ahora encontrará un formulario donde debe seleccionar sus generos favoritos de peliculas.

![guia5](https://user-images.githubusercontent.com/48091585/82502625-2cd6ea00-9abd-11ea-93d9-d70d3937cbf2.png)

Se le informará que fueron guardados sus gustos de peliculas, y ahora tendra que escoger sus gustos musicales. Como se muestra a continuación 

![guia6](https://user-images.githubusercontent.com/48091585/82503087-3ca2fe00-9abe-11ea-9a06-75a2e3e16b72.png)

Ahora tendra que escoger sus gustos de comida 

![guia7](https://user-images.githubusercontent.com/48091585/82503318-a6bba300-9abe-11ea-8552-0fa0772020c3.png)

Se le informará que completó su registro y sera redirigido a la página principal. Debe utilizar los datos que registró para hacer posible la autenticación. Deberá dar click en ingresar

![guia8](https://user-images.githubusercontent.com/48091585/82503721-732d4880-9abf-11ea-96c9-1766799046be.png)

Al ingresar verá la pantalla inicial donde se parecian los datos principales de usuarios candidatos a ser un posible match. Tendrá la opción de de darle me gusta o no me gusta 

![guia9](https://user-images.githubusercontent.com/48091585/82504063-2007c580-9ac0-11ea-898b-f6755c54b171.png)

Para ver las fotos del otro usuario debes ir a la parte inferior de la página y dar click en ver fotos, adicionalmente podra ver los gustos de la otra persona 

![guia10](https://user-images.githubusercontent.com/48091585/82504359-ca7fe880-9ac0-11ea-84c0-b666512ed943.png)

Por medio del botón "Mi perfil" podra ver su informacion personal y podra actualizarla 

![guia11](https://user-images.githubusercontent.com/48091585/82504499-29ddf880-9ac1-11ea-976a-5ff5cf8b3816.png)

En la parte inferior podra ver sus intereses y sus gustos, de igual manera podra actualizarlos. Adicionalmente podra actualizar sus imagenes

![guia12](https://user-images.githubusercontent.com/48091585/82504748-c0aab500-9ac1-11ea-8b9f-07df7ab8e2ce.png)

Para añadir sus fotos deberá dar en el botón anteriormente mencionado de actualizar galeria, el cual lo redirige a la siguiente página. En ella deberá dar click en el botón que aparece en la esquina inferior derecha. Tendrá que ponerle un titulo a la imagen, el cual será visible para todos los usuarios.Deberá dar en "Selecciona tu imagen" para seleccionar su imagen y despues de asiganr el titulo y seleccionar la imágen debe hacer click en "Subir" la página actualizara automaticamente mostrando la imágen que acabo de subir.

![guia13](https://user-images.githubusercontent.com/48091585/82505120-9a394980-9ac2-11ea-87eb-793569815676.png)

![guia14](https://user-images.githubusercontent.com/48091585/82505251-d53b7d00-9ac2-11ea-8fdc-01821a801cc4.png)

![guia15](https://user-images.githubusercontent.com/48091585/82505334-09af3900-9ac3-11ea-90d5-efffba3558f5.png)

En el botón match podrá ver los usuarios con lo que ha hecho match, cuando tengas alguno

![guia17](https://user-images.githubusercontent.com/48091585/82505786-e1740a00-9ac3-11ea-96ba-2910937454bb.png)

En el boton de conversaciones podrá ver con los usuarios que has hablado y poder continuar hablando con ellos.

![guia16](https://user-images.githubusercontent.com/48091585/82505536-9823ba80-9ac3-11ea-9194-b9fb94a4c516.png)

Finalmente podrá cerrar su sesión por medio del botón "Cerrar Sesión" y será redirigido a la pagina de inicio de sesión


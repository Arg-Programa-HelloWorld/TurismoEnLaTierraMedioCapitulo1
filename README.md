# TurismoEnLaTierraMedioCapitulo1

Trabajo Práctico, Capítulo I

Este trabajo tiene como objetivo afianzar la práctica de la Programación Orientada a Objetos. En particular, de los mecanismos de herencia, polimorfismo, clases abstractas e interfaces.
Turismo en la Tierra Media

1. Planteo
La Secretaría de Turismo de la Tierra Media ha decidido crear un sistema para promocionar el turismo en su territorio. Éste contará con la información de las distintas atracciones de toda la Tierra Media.
El sistema deberá ser capaz de sugerir visitas a los visitantes y también de generar itinerarios a partir de la información de preferencias disponible en el perfil de los usuarios. Se espera que las personas que accedan al sistema puedan descargarse a futuro una aplicación móvil que les permita interactuar con el mismo y los vaya guiando en su recorrido.
Dado el alcance del sistema y la limitación de tiempo, varios equipos han sido contratados para el desarrollo.

En el caso de su equipo, debe implementar sólamente la lógica para sugerir visitas e itinerarios respetando las siguientes especificaciones:

*Cada atracción cuenta con su costo de visita, el promedio de tiempo necesario para realizarla, el cupo de personas que pueden visitarlo a diario y el tipo de atracción (paisaje, de aventura, de degustación).
*Por su parte, para cada usuario el sistema conoce su presupuesto, el tiempo disponible para visitas y el tipo de atracción preferida.
*En la generación de las sugerencias deben contemplarse las promociones vigentes. Cada promoción incluye una o varias atracciones y beneficia al usuario con una reducción del costo total. Se espera que el sistema permita la definición de promociones de tres tipos: 

  -Promociones porcentuales (X % de descuento en el costo total)
  -Promociones absolutas ($ X por todo el paquete)
  -Promociones A x B (si el usuario compra A, B, C entonces tiene gratis D). 
  
2. Ejemplos
2.1. Atracciones

[---------------------------------------------------------------------------------------]
    Nombre          Costo(monedas de oro)     Tiempo(horas)     Cupo      Tipo
[---------------------------------------------------------------------------------------]
    Moria           10                        2                 6         Aventura
    Minas Tirith    5                         2.5               25        Paisaje
    La Comarca      3                         6.5               150       Degustación
    Mordor          25                        3                 4         Aventura
    Abismo de Helm  5                         2                 15        Paisaje
    Lothlórien      35                        1                 30        Degustación
    Erebor          12                        3                 32        Paisaje
    Bosque Negro    3                         4                 12        Aventura
[---------------------------------------------------------------------------------------]

2.2. Perfiles de usuario
Se proporcionan ejemplos de posibles perfiles. El sistema no se limita a ellos.

-Eowyn. Le gusta la aventura, pero tiene un presupuesto escaso: sólo puede gastar 10 monedas. Dispone de mucho tiempo: 8 horas.
-Gandalf. Prefiere ver paisajes, y si bien tiene un presupuesto de 100 monedas, sólo dispone de 5 horas.
-Sam. Su preferencia son los banquetes. Posee un presupuesto de 36 monedas y también tiene 8 horas disponibles.
-Galadriel. Le gustan los paseos contemplativos, y a pesar de un presupuesto holgado de 120 monedas, su tiempo en la Tierra Media está fuertemente limitado y solo cuenta con 6 horas.

2.3. Promociones
Se proporciona un ejemplo de cada una. El grupo es responsable de ampliar las promociones. Las promociones siempre son del mismo tipo.
-Pack aventura: Bosque Negro y Mordor con un 20% de descuento si se compran ambas.
-Pack degustación: Lothlórien y La Comarca a 36 monedas.
-Pack paisajes: Comprando Minas Tirith y el Abismo de Helm, Erebor es gratis.

3. Uso del Sistema
  3.1. El sistema lee los archivos de entrada (elegir formatos adecuados):
      a. Usuarios con sus preferencias
      b. Atracciones con sus características
      c. Promociones a ofrecer
  3.2. Para cada usuario, el sistema:
      a. Sugerirá una atracción que coincida con sus preferencias, costos y tiempos.
        i. Deberá priorizarse la oferta de promociones, las atracciones más caras y que requieran mayor tiempo, en ese orden.
        ii. No deberá ofertarse una atracción o promoción que no pueda costearse o para la cual no tenga tiempo disponible.
        iii. Tampoco deberá ofertarse una atracción que ya haya sido incluida en una promoción anteriormente comprada por el mismo usuario.
        iv. Una vez agotadas las ofertas que coincidan con sus intereses, se ofertarán aquellas que no coincidan, bajo el mismo criterio.
      b. Si el usuario acepta, se guardará dentro de su sugerencia.
         Una atracción o promoción aceptada no podrá cancelarse.
      c. Se repetirá el proceso hasta que no quede tiempo disponible, monedas, o cupo para el itinerario, conforme las ofertas restantes.
      d. Se mostrará un resumen de todo su itinerario, contabilizando las horas necesarias para realizarlo y las monedas que deberá gastar.
      e. Se repetirá para el siguiente usuario.
      f. La interacción se realizará por medio de la línea de comandos.

  3.3. Finalizado el procesamiento, se obtendrá un archivo de salida para cada usuario, con los datos del usuario, su compra, los totales a pagar y el tiempo que deberá invertir en dicha salida.

4. Formalidades
El trabajo se realizará en forma grupal, con equipos de 4 a 6 personas. Deberá trabajarse utilizando git y GitHub.

Deberán entregarse, todo dentro de un mismo archivo .zip:
Enlace al repositorio de GitHub
Diagrama de clases
Un archivo .zip con la resolución del problema
La resolución debe incluir pruebas unitarias de las funcionalidades de paquete, totalizador de itinerarios y el ofertador de atracciones/paquetes.
Enlace a un breve video (subir como privado a YouTube) mostrando en 5 minutos o menos cómo funciona el programa entregado. No explicar código

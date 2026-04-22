🐾 Sistema de Gestión Veterinaria
📌 Objetivo del avance

El presente proyecto tiene como objetivo desarrollar un sistema web para la gestión básica de una veterinaria, permitiendo administrar información de usuarios, mascotas y citas.

En este avance se ha implementado la estructura base del sistema, incluyendo autenticación de usuarios, registro y gestión de mascotas, así como la interacción con base de datos mediante el patrón DAO.

⚙️ Tecnologías utilizadas
•Lenguaje: Java
•Framework web: Jakarta EE (Servlets + JSP)
•Arquitectura: MVC (Modelo - Vista - Controlador)
•Persistencia: JDBC
•Base de datos: (MySQL o la que estés usando, puedes especificarla)
•Servidor: Apache Tomcat
•Gestión de dependencias: Maven
•Frontend: HTML, CSS

🧱 Estructura del proyecto
•model/ → Clases entidad (Usuario, Mascota)
•dao/ → Acceso a datos (UsuarioDAO, MascotaDAO)
•servlet/ → Controladores (LoginServlet, MascotaServlet)
•util/ → Conexión a base de datos
•webapp/ → Vistas JSP
▶️ Pasos de ejecución
1.Clonar el repositorio
•git clone https://github.com/tu-usuario/tu-repositorio.git

2.Abrir el proyecto en tu IDE
•Recomendado: NetBeans o IntelliJ IDEA

3.Configurar la base de datos
•Crear la base de datos en MySQL
•Ejecutar los scripts necesarios (tablas de usuarios, mascotas, etc.)
•Configurar las credenciales en la clase:

 Conexion.java

4.Configurar el servidor
•Instalar Apache Tomcat
•Agregar el proyecto al servidor desde el IDE

5.Compilar y ejecutar
•Ejecutar el proyecto desde el IDE
•Acceder en el navegador:
http://localhost:8080/veterinaria

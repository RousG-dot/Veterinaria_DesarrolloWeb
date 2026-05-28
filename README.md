# 🐾 Sistema de Gestión Veterinaria - PetSociety

## 📌 Descripción del Proyecto

PetSociety es un sistema web desarrollado para optimizar la gestión administrativa de una clínica veterinaria. El sistema permite administrar clientes, mascotas, inventario y citas médicas mediante una interfaz intuitiva y conectada a una base de datos relacional.

El proyecto fue desarrollado siguiendo una arquitectura MVC utilizando tecnologías Java Web y conexión con MySQL mediante JDBC.

## 🚀 Funcionalidades Implementadas

### 👤 Gestión de Usuarios

* Inicio de sesión mediante autenticación.
* Validación de credenciales desde base de datos.

### 🐶 Gestión de Mascotas

* Registro de mascotas.
* Visualización de mascotas registradas.
* Edición y eliminación de registros.

### 📅 Gestión de Citas

* Programación de citas médicas.
* Selección dinámica de mascotas registradas.
* Restricción de horarios de atención.
* Interfaz de agenda veterinaria.

### 📦 Gestión de Inventario

* Registro de productos veterinarios.
* Visualización y edición de inventario.

### 👥 Gestión de Clientes

* Registro de clientes.
* Edición y eliminación de información.

## ⚙️ Tecnologías Utilizadas

| Tecnología    | Descripción                       |
| ------------- | --------------------------------- |
| Java          | Lenguaje principal del proyecto   |
| Jakarta EE    | Desarrollo web con Servlets y JSP |
| Maven         | Gestión de dependencias           |
| MySQL         | Sistema gestor de base de datos   |
| JDBC          | Conexión entre Java y MySQL       |
| Apache Tomcat | Servidor de aplicaciones          |
| HTML/CSS      | Diseño e interfaz gráfica         |
| MVC           | Arquitectura del sistema          |

## 🧱 Arquitectura del Proyecto
```text
src/main/java
│
├── model/        → Clases entidad
├── dao/          → Acceso a datos
├── servlet/      → Controladores
├── util/         → Conexión y utilidades
│
src/main/webapp
│
├── css/          → Estilos del sistema
├── *.jsp         → Interfaces del sistema
```

## 🗄️ Base de Datos

La base de datos utilizada es:
```text
veterinaria_db
```
El archivo SQL se encuentra incluido dentro de:
```text
database/veterinaria_db.sql
```
## ▶️ Pasos de Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/RousG-dot/Veterinaria_DesarrolloWeb.git
```

### 2. Importar la base de datos

Importar el archivo:
```text
database/db_veterinaria.sql
```
en MySQL mediante phpMyAdmin o MySQL Workbench.

### 3. Configurar conexión
Verificar el puerto MySQL utilizado en:
```text
Conexion.java
```
o
```text
database.properties
```
según el entorno local.

### 4. Ejecutar XAMPP / MySQL
Asegurarse de tener activo:
* Apache
* MySQL
  
### 5. Ejecutar el proyecto
Abrir el proyecto en NetBeans y ejecutar mediante Apache Tomcat.

## 📚 Estado del Proyecto
Proyecto académico desarrollado como parte del curso de Desarrollo Web / Ingeniería de Sistemas.

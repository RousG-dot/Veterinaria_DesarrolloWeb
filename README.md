# 🐾 Sistema de Gestión Veterinaria

## 📌 Objetivo del avance

El presente proyecto tiene como objetivo desarrollar un sistema web para la gestión básica de una veterinaria, permitiendo administrar información de usuarios, mascotas y citas.

En este avance se ha implementado la estructura base del sistema, incluyendo autenticación de usuarios, registro y gestión de mascotas, así como la interacción con base de datos mediante el patrón DAO.

---

## ⚙️ Tecnologías utilizadas

- **Lenguaje:** Java  
- **Framework web:** Jakarta EE (Servlets + JSP)  
- **Arquitectura:** MVC (Modelo - Vista - Controlador)  
- **Persistencia:** JDBC  
- **Base de datos:** MySQL  
- **Servidor:** Apache Tomcat  
- **Gestión de dependencias:** Maven  
- **Frontend:** HTML, CSS  

---

## 🧱 Estructura del proyecto

- `model/` → Clases entidad (Usuario, Mascota)  
- `dao/` → Acceso a datos (UsuarioDAO, MascotaDAO)  
- `servlet/` → Controladores (LoginServlet, MascotaServlet)  
- `util/` → Conexión a base de datos  
- `webapp/` → Vistas JSP  

---

## ▶️ Pasos de ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/tu-repositorio.git

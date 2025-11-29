<div align="center">

# 🔐 Login System with Spring Security

### Sistema de Autenticación Empresarial con Control de Acceso Basado en Roles

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)](https://spring.io/projects/spring-security)
[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)](https://www.thymeleaf.org/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](./LICENSE)

**Sistema completo de autenticación** con Spring Security 6, control de acceso basado en roles (RBAC), redirección dinámica por rol, y cifrado BCrypt. Implementa las mejores prácticas de seguridad en aplicaciones Java empresariales.

[🚀 Comenzar](#-instalación) • [📖 Características](#-características) • [🔧 Configuración](#-configuración-de-seguridad) • [👤 Autor](#-autor)

---

</div>

## ✨ Características

<table>
<tr>
<td width="50%">

### 🔒 Seguridad
- **Spring Security 6** con configuración moderna
- **BCrypt** para cifrado de contraseñas
- **CSRF Protection** habilitado
- **Session Management** seguro
- Invalidación de sesión en logout

</td>
<td width="50%">

### 👥 Control de Acceso (RBAC)
- **3 roles** predefinidos: ADMIN, USER, GUEST
- **Redirección automática** por rol después del login
- Rutas protegidas por autorización
- Páginas públicas configurables

</td>
</tr>
<tr>
<td width="50%">

### 🎨 Frontend
- **Thymeleaf** con integración Spring Security
- Templates responsivos
- Login page personalizada
- Dashboards específicos por rol

</td>
<td width="50%">

### 🗄️ Persistencia
- **Spring Data JPA** ready
- **H2 Database** para desarrollo
- Usuarios en memoria para demo
- Fácil migración a PostgreSQL/MySQL

</td>
</tr>
</table>

---

## 🏗️ Arquitectura

```
src/main/java/com/duoc/seguridadcalidad/
├── config/
│   └── WebSecurityConfig.java      # Configuración de Spring Security
├── controller/
│   ├── AdminController.java        # Endpoints /admin/**
│   ├── UserController.java         # Endpoints /user/**
│   └── HomeController.java         # Endpoints públicos y login
├── model/
│   └── User.java                   # Entidad de usuario
├── repository/
│   └── UserRepository.java         # JPA Repository
├── service/
│   └── UserService.java            # Lógica de negocio
└── SeguridadcalidadApplication.java
```

---

## 🔧 Configuración de Seguridad

### Roles y Permisos

| Rol | Rutas Permitidas | Redirección Post-Login |
|-----|------------------|------------------------|
| `ADMIN` | `/admin/**`, `/home`, `/` | `/admin/dashboard` |
| `USER` | `/user/**`, `/home`, `/` | `/user/programar_cita` |
| `GUEST` | `/guest/**`, `/home`, `/` | `/guest/welcome` |

### Usuarios de Prueba

| Usuario | Contraseña | Rol |
|---------|------------|-----|
| `admin` | `admin123` | ADMIN |
| `cliente` | `cliente123` | USER |
| `guest` | `guest123` | GUEST |

---

## 🚀 Instalación

### Prerrequisitos

- Java 17+
- Maven 3.8+

### Ejecutar el Proyecto

```bash
# Clonar el repositorio
git clone https://github.com/RodrigoSanchezDev/LoginSystem-SpringSecurity.git
cd LoginSystem-SpringSecurity

# Ejecutar con Maven
./mvnw spring-boot:run

# O compilar y ejecutar
./mvnw clean package
java -jar target/seguridadcalidad-0.0.1-SNAPSHOT.jar
```

### Acceder a la Aplicación

```
🌐 http://localhost:8080
📊 H2 Console: http://localhost:8080/h2-console
```

---

## 📁 Vistas Disponibles

| Ruta | Descripción | Acceso |
|------|-------------|--------|
| `/` | Página principal | Público |
| `/login` | Formulario de login | Público |
| `/admin/dashboard` | Panel de administración | Solo ADMIN |
| `/admin/registrar_paciente` | Registro de pacientes | Solo ADMIN |
| `/user/programar_cita` | Programar citas | Solo USER |
| `/guest/welcome` | Bienvenida invitados | Solo GUEST |

---

## 🔐 Características de Seguridad Implementadas

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/home", "/login", "/css/**").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/user/**").hasRole("USER")
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .successHandler(customAuthenticationSuccessHandler())
            .permitAll()
        )
        .logout(logout -> logout
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
        );
    return http.build();
}
```

---

## 🛠️ Tech Stack

<div align="center">

<img src="https://skillicons.dev/icons?i=java,spring,maven,html,css&theme=dark" alt="Tech Stack"/>

</div>

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Spring Boot | 3.4.3 | Framework base |
| Spring Security | 6.x | Autenticación y autorización |
| Spring Data JPA | 3.x | Persistencia |
| Thymeleaf | 3.x | Motor de plantillas |
| H2 Database | 2.x | Base de datos en memoria |
| BCrypt | - | Cifrado de contraseñas |

---

## 📈 Próximas Mejoras

- [ ] JWT Token Authentication
- [ ] OAuth2 / Social Login
- [ ] Two-Factor Authentication (2FA)
- [ ] Password Reset via Email
- [ ] Audit Logging
- [ ] Rate Limiting

---

## 👤 Autor

<div align="center">

**Rodrigo Sanchez**

[![Portfolio](https://img.shields.io/badge/Portfolio-sanchezdev.com-A855F7?style=for-the-badge&logo=googlechrome&logoColor=white)](https://sanchezdev.com)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-sanchezdev-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sanchezdev)
[![GitHub](https://img.shields.io/badge/GitHub-RodrigoSanchezDev-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/RodrigoSanchezDev)

</div>

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

---

<div align="center">

**⭐ Si este proyecto te fue útil, considera darle una estrella ⭐**

</div>

# TA-IND-02 — Análisis de Consistencia y Replicación en Bases de Datos Distribuidas

## Caso de estudio: Sistema de Control de Laboratorios Informáticos (SCLI)

Este repositorio contiene el informe académico **TA-IND-02**, correspondiente al análisis de mecanismos de **consistencia, replicación, disponibilidad y tolerancia a fallos** en bases de datos distribuidas.

El análisis se aplica al **Sistema de Control de Laboratorios Informáticos (SCLI)**, desarrollado como parte del Proyecto Final de Curso por el equipo **ForaCode**.

Además, se incluye la práctica **Banco del Austro**, un prototipo implementado con Spring Boot, PostgreSQL y Docker para demostrar la distribución de datos entre dos nodos independientes.

---

## Información académica

| Campo | Información |
|---|---|
| Autor | Freddy Farinango |
| Equipo PFC | ForaCode |
| Universidad | Universidad Técnica Estatal de Quevedo (UTEQ) |
| Carrera | Ingeniería de Software |
| Asignatura | Aplicaciones Distribuidas |
| Código | ISR-701 |
| Unidad | Unidad 3 |
| Docente | Prof. Guerrero Ulloa G. C. |
| Periodo académico | 2026-2027 |

---

## Objetivo

Analizar técnicamente diferentes estrategias de consistencia y replicación que podrían aplicarse al Sistema de Control de Laboratorios Informáticos, considerando:

- Consistencia transaccional.
- Replicación síncrona y asíncrona.
- Disponibilidad del sistema.
- Tolerancia a fallos.
- Recuperación ante la caída de nodos.
- Promoción de réplicas.
- Redirección de conexiones.
- Puntos únicos de fallo.
- Aplicación del teorema CAP.
- Equilibrio entre consistencia, disponibilidad y partición de red.

---

## Caso de estudio SCLI

El **Sistema de Control de Laboratorios Informáticos** permite administrar procesos relacionados con:

- Usuarios y roles.
- Reservas de laboratorios.
- Registro de asistencia.
- Inventario de equipos.
- Gestión de incidencias.
- Reportes académicos y administrativos.

El informe analiza una arquitectura en la que PostgreSQL puede utilizar mecanismos de replicación para mejorar la disponibilidad de los datos.

La replicación síncrona puede reducir el riesgo de pérdida de información, pero no elimina por sí sola un punto único de fallo. Una solución completa también requiere:

- Detección automática de fallos.
- Promoción controlada de una réplica.
- Redirección de conexiones.
- Monitoreo de los nodos.
- Copias de seguridad.
- Pruebas periódicas de failover.
- Políticas de recuperación ante desastres.

---

# Práctica Banco del Austro

## Descripción

La práctica **Banco del Austro** implementa un prototipo académico de base de datos distribuida.

Se levantan dos nodos PostgreSQL independientes mediante Docker:

- **Nodo Cuenca**
- **Nodo Quito**

Cada nodo posee sus propias tablas y registros. La aplicación Spring Boot determina qué nodo debe consultar según el número de cuenta proporcionado.

Este prototipo permite demostrar los siguientes conceptos:

- Distribución de datos entre nodos.
- Separación física de bases de datos.
- Configuración de múltiples fuentes de datos.
- Selección dinámica del nodo de consulta.
- Acceso a información distribuida desde una aplicación central.
- Independencia entre nodos PostgreSQL.

> La práctica Banco del Austro es una demostración académica complementaria y no representa la arquitectura completa del SCLI.

---

## Arquitectura general

```text
                         Cliente
                            |
                            v
                  Aplicación Spring Boot
                            |
                +-----------+-----------+
                |                       |
                v                       v
        PostgreSQL Cuenca       PostgreSQL Quito
             Nodo 1                  Nodo 2
```

La aplicación funciona como una capa de acceso que selecciona el nodo correspondiente mediante la lógica implementada en el servicio.

---

## Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- PostgreSQL
- Docker
- Docker Compose
- IntelliJ IDEA
- LaTeX
- IEEEtran
- Git
- GitHub

---

## Estructura del repositorio

```text
Practa-aulaYTAInformeindividual-FreddyFarinango/
│
├── Informe/
│   └── TA-IND-02_Farinango_ForaCode/
│       ├── TA-IND-02_Farinango_ForaCode.tex
│       ├── TA-IND-02_Farinango_ForaCode.pdf
│       └── references.bib
│
├── uteq/
│   └── banco-austro/
│       ├── docker-compose.yml
│       ├── pom.xml
│       │
│       ├── sql-cuenca/
│       │   ├── 01_schema.sql
│       │   └── 02_datos.sql
│       │
│       ├── sql-quito/
│       │   ├── 01_schema.sql
│       │   └── 02_datos.sql
│       │
│       └── src/
│           └── main/
│               ├── java/
│               │   └── ec/edu/uteq/bancoaustro/
│               │       ├── config/
│               │       ├── controller/
│               │       └── service/
│               │
│               └── resources/
│                   └── application.yml
│
├── .gitignore
└── README.md
```

---

## Archivos del informe

### `TA-IND-02_Farinango_ForaCode.tex`

Archivo fuente principal del informe académico.

Características:

- Clase documental `IEEEtran`.
- Formato de conferencia.
- Presentación en dos columnas.
- Figuras elaboradas con TikZ.
- Tablas ajustadas mediante `tabularx`.
- Referencias en formato IEEE.
- Análisis técnico aplicado al SCLI.

### `TA-IND-02_Farinango_ForaCode.pdf`

Documento final compilado para revisión y entrega académica.

### `references.bib`

Archivo de respaldo que contiene las referencias académicas en formato BibTeX, incluyendo información como:

- Autores.
- Título.
- Año de publicación.
- Revista, conferencia o editorial.
- DOI.
- ISBN, cuando corresponde.

---

# Ejecución de la práctica Banco del Austro

## Requisitos

Para ejecutar el proyecto se necesita:

- Java.
- Maven.
- Docker Desktop.
- Docker Compose.
- Git.
- IntelliJ IDEA o un IDE compatible.

---

## 1. Clonar el repositorio

```bash
git clone https://github.com/ffarinangog2/Practa-aulaYTAInformeindividual-FreddyFarinango.git
```

Ingresar al proyecto:

```bash
cd Practa-aulaYTAInformeindividual-FreddyFarinango/uteq/banco-austro
```

---

## 2. Levantar los nodos PostgreSQL

Ejecutar el siguiente comando:

```bash
docker compose up -d
```

Este comando crea e inicia los contenedores correspondientes a:

- PostgreSQL Cuenca.
- PostgreSQL Quito.

Los scripts almacenados en las carpetas `sql-cuenca` y `sql-quito` inicializan las tablas y los datos de cada nodo.

---

## 3. Verificar los contenedores

```bash
docker ps
```

Los dos contenedores PostgreSQL deben aparecer en estado activo.

Para revisar los registros de ejecución:

```bash
docker compose logs
```

---

## 4. Ejecutar la aplicación Spring Boot

Desde la carpeta `uteq/banco-austro`, ejecutar:

```bash
mvn spring-boot:run
```

También se puede abrir el proyecto en IntelliJ IDEA y ejecutar la clase principal de Spring Boot.

---

## 5. Detener los contenedores

Para detener el entorno:

```bash
docker compose down
```

Para detener los contenedores y eliminar los volúmenes:

```bash
docker compose down -v
```

> El comando `docker compose down -v` elimina los datos almacenados en los volúmenes y debe utilizarse únicamente cuando se desea reinicializar completamente la práctica.

---

# Compilación del informe LaTeX

## Requisitos

Se recomienda utilizar:

- Overleaf, o
- Una distribución completa de TeX Live.

El entorno debe incluir la clase:

```text
IEEEtran.cls
```

En TeX Live, esta clase se encuentra normalmente en el paquete:

```text
texlive-publishers
```

---

## Paquetes utilizados

El informe utiliza los siguientes paquetes de LaTeX:

```text
booktabs
tabularx
array
tikz
amsmath
placeins
hyperref
```

---

## Compilación desde la terminal

Ingresar a la carpeta del informe:

```bash
cd Informe/TA-IND-02_Farinango_ForaCode
```

Ejecutar dos veces el comando de compilación:

```bash
pdflatex TA-IND-02_Farinango_ForaCode.tex
pdflatex TA-IND-02_Farinango_ForaCode.tex
```

La doble compilación permite resolver correctamente:

- Citas.
- Referencias internas.
- Numeración de figuras.
- Numeración de tablas.
- Enlaces internos.

El archivo `references.bib` se conserva como respaldo organizado de las referencias utilizadas.

---

# Consideraciones técnicas

El análisis no asume que PostgreSQL proporcione automáticamente consistencia fuerte en toda una arquitectura distribuida.

Se consideran los siguientes aspectos:

- Cada nodo mantiene consistencia transaccional local.
- El nivel de aislamiento predeterminado de PostgreSQL es `READ COMMITTED`.
- `READ COMMITTED` no garantiza una ejecución equivalente a un nivel serializable.
- Las réplicas asíncronas pueden presentar retrasos respecto al nodo principal.
- Las réplicas síncronas reducen la ventana de pérdida de datos.
- La replicación no elimina automáticamente un punto único de fallo.
- El failover requiere coordinación, monitoreo y redirección de conexiones.
- La disponibilidad depende de la base de datos, la aplicación y la infraestructura.
- Las decisiones de replicación deben considerar latencia, rendimiento y tolerancia a fallos.

---

# Verificación previa a la entrega

Antes de entregar el proyecto se debe comprobar que:

- El informe utilice correctamente la clase `IEEEtran`.
- La Figura 1 permanezca dentro de una sola columna.
- La Figura 2 no invada otras secciones.
- Las tablas permanezcan dentro de los márgenes.
- No existan citas representadas con `?`.
- No existan referencias internas representadas con `??`.
- Las referencias mantengan el formato IEEE.
- Los DOI sean verificables.
- El nombre del autor sea Freddy Farinango.
- El nombre del equipo sea ForaCode.
- El PDF corresponda con la versión actual del archivo `.tex`.
- Los dos nodos PostgreSQL puedan iniciar correctamente.
- La aplicación Spring Boot pueda conectarse a ambos nodos.

---

# Alcance académico

Este repositorio fue desarrollado con fines educativos para la asignatura **Aplicaciones Distribuidas** de la carrera de Ingeniería de Software de la Universidad Técnica Estatal de Quevedo.

La arquitectura presentada corresponde a un prototipo académico. Una implementación en producción requeriría medidas adicionales como:

- Autenticación y autorización.
- Cifrado de comunicaciones.
- Gestión segura de credenciales.
- Balanceo de carga.
- Monitoreo centralizado.
- Copias de seguridad automatizadas.
- Recuperación ante desastres.
- Automatización del failover.
- Auditoría de operaciones.
- Pruebas de rendimiento.
- Pruebas de concurrencia.
- Pruebas de recuperación ante fallos.

---

## Autor

**Freddy Farinango**  
Estudiante de Ingeniería de Software  
Universidad Técnica Estatal de Quevedo  
Equipo PFC: **ForaCode**

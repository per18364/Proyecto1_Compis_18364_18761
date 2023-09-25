# Proyecto 1 - Construcción de Compiladores

## Integrantes

- [Jorge Perez, 18364]
- [Diego Ruiz, 18761]

## Descripción

Este proyecto combina el poder de Angular.js para el frontend y Django para el backend, creando una experiencia de pila completa perfecta.

## Project Structure

- `/frontend` - Contiene el código de la interfaz de usuario con el framework Angular.js.
- `/backend` - Contiene el código del servidor con el framework Django.

## Prerequisites

1. Python 3.x
2. Node.js y npm
3. Virtualenv (Opcional, pero recomendado)

## Setup e instalación

### Backend (Django)

1. Navegar al directorio `backend`:

   ```bash
   cd backend
   ```

2. (Opcional) Set up el entorno virtual:

   ```bash
   python -m venv venv
   source venv/bin/activate  # En Windows se usa `venv\Scripts\activate`
   ```

3. Instalar los requerimientos:

   ```bash
   pip install -r requirements.txt
   ```

4. Correr las migraciones de Django:

   ```bash
   python manage.py migrate
   ```

5. Iniciar el servidor de desarrollo de Django:
   ```bash
   python manage.py runserver
   ```

### Frontend (Angular.js)

1. Navegar al directorio `frontend`:

   ```bash
   cd interfaz-proyecto1-compis
   ```

2. Instalar los modulos de Node.js:

   ```bash
   npm install
   ```

3. iniciar el servidor de desarrollo de Angular.js:
   ```bash
   ng serve
   ```

Ahora, deberías poder acceder al frontend en `http://localhost:4200/` y al backend en `http://localhost:8000/`.

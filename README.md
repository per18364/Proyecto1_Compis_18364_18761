# Proyecto 1 - Construcción de Compiladores

## Integrantes

- [Jorge Perez, 18364]
- [Diego Ruiz, 18761]

## Descripción

Este proyecto combina el poder de Angular.js para el frontend y Django para el backend, creando una experiencia de pila completa perfecta.

## Project Structure

- `/frontend` - Contains the Angular.js frontend code.
- `/backend` - Contains the Django backend code.

## Prerequisites

1. Python 3.x
2. Node.js and npm
3. Virtualenv (Optional, but recommended)

## Setup & Installation

### Backend (Django)

1. Navigate to the `backend` directory:

   ```bash
   cd backend
   ```

2. (Optional) Set up a virtual environment:

   ```bash
   python -m venv venv
   source venv/bin/activate  # On Windows use `venv\Scripts\activate`
   ```

3. Install the required packages:

   ```bash
   pip install -r requirements.txt
   ```

4. Run the Django migrations:

   ```bash
   python manage.py migrate
   ```

5. Start the Django server:
   ```bash
   python manage.py runserver
   ```

### Frontend (Angular.js)

1. Navigate to the `frontend` directory:

   ```bash
   cd frontend
   ```

2. Install the necessary node modules:

   ```bash
   npm install
   ```

3. Start the Angular development server:
   ```bash
   ng serve
   ```

Now, you should be able to access the frontend at `http://localhost:4200/` and the backend API at `http://localhost:8000/`.

## Contributing

Feel free to submit issues and pull requests, they are always welcome!

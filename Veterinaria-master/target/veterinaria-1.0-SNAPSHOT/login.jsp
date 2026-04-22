<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - PetSociety</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
        <style>
            :root {
                --primary: #0f766e;
                --primary-hover: #0d9488;
                --bg: #f8fafc;
                --surface: #ffffff;
                --text-main: #0f172a;
                --text-light: #64748b;
                --border: #e2e8f0;
                --focus-ring: rgba(15, 118, 110, 0.15);
            }

            body {
                margin: 0;
                font-family: 'Inter', sans-serif;
                background: var(--bg);
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                font-size: 16px;
            }

            @keyframes slideUpFade {
                from {
                    opacity: 0;
                    transform: translateY(20px);
                }
                to {
                    opacity: 1;
                    transform: translateY(0);
                }
            }

            .login-container {
                background: var(--surface);
                padding: 56px 48px;
                border-radius: 20px;
                width: 100%;
                max-width: 440px;
                box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04);
                border: 1px solid var(--border);
                box-sizing: border-box;
                animation: slideUpFade 0.6s cubic-bezier(0.16, 1, 0.3, 1) forwards;
            }

            .header-section {
                text-align: center;
                margin-bottom: 40px;
                opacity: 0;
                animation: slideUpFade 0.6s cubic-bezier(0.16, 1, 0.3, 1) 0.1s forwards;
            }

            .header-section img {
                width: 88px;
                height: auto;
                margin-bottom: 20px;
                border-radius: 16px;
                box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
                transition: transform 0.3s ease;
            }

            .header-section img:hover {
                transform: scale(1.05);
            }

            .header-section h1 {
                font-size: 2.25rem;
                font-weight: 700;
                color: var(--primary);
                margin: 0 0 8px 0;
                letter-spacing: -0.03em;
            }

            .header-section h2 {
                font-size: 1.1rem;
                font-weight: 500;
                color: var(--text-light);
                margin: 0;
                text-transform: uppercase;
                letter-spacing: 0.08em;
            }

            .form-group {
                margin-bottom: 24px;
                opacity: 0;
                animation: slideUpFade 0.6s cubic-bezier(0.16, 1, 0.3, 1) 0.2s forwards;
            }

            .form-group:nth-child(2) {
                animation-delay: 0.3s;
            }

            label {
                display: block;
                margin-bottom: 10px;
                font-size: 1.05rem;
                font-weight: 600;
                color: var(--text-main);
            }

            input[type="email"],
            input[type="password"] {
                width: 100%;
                padding: 16px;
                border: 2px solid var(--border);
                border-radius: 10px;
                box-sizing: border-box;
                font-family: inherit;
                font-size: 1.1rem;
                color: var(--text-main);
                background: #f8fafc;
                transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
            }

            input[type="email"]:focus,
            input[type="password"]:focus {
                outline: none;
                border-color: var(--primary);
                background: var(--surface);
                box-shadow: 0 0 0 4px var(--focus-ring);
                transform: translateY(-2px);
            }

            input::placeholder {
                color: #94a3b8;
            }

            button[type="submit"] {
                width: 100%;
                padding: 16px;
                background: var(--primary);
                color: white;
                border: none;
                border-radius: 10px;
                font-weight: 600;
                font-size: 1.15rem;
                cursor: pointer;
                transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
                margin-top: 16px;
                opacity: 0;
                animation: slideUpFade 0.6s cubic-bezier(0.16, 1, 0.3, 1) 0.4s forwards;
            }

            button[type="submit"]:hover {
                background: var(--primary-hover);
                transform: translateY(-2px);
                box-shadow: 0 10px 15px -3px rgba(15, 118, 110, 0.3);
            }

            button[type="submit"]:active {
                transform: translateY(0);
            }
        </style>
    </head>
    <body>
        
        <div class="login-container">
            <div class="header-section">
                <img src="img/logo.jpg" alt="PetSociety Logo"/>
                <h1>PetSociety</h1>   
                <h2>Panel Administrativo</h2> 
            </div>
            
            <form method="POST" action="LoginServlet">
                <div class="form-group">
                    <label>Correo Electrónico</label>
                    <input type="email" name="txtemail" placeholder="usuario@petsociety.com" required>
                </div>
                
                <div class="form-group">
                    <label>Contraseña</label>
                    <input type="password" name="txtpass" placeholder="••••••••" required>
                </div>
                
                <button type="submit">Ingresar al Sistema</button>
            </form>
        </div>
        
    </body>
</html>
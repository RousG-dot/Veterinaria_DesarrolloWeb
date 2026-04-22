<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Panel Administrativo - PetSociety</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
        <style>
            :root {
                --primary: #0f766e;
                --primary-hover: #0d9488;
                --sidebar-bg: #1e293b;
                --sidebar-hover: #334155;
                --bg: #f1f5f9;
                --surface: #ffffff;
                --text-main: #0f172a;
                --text-light: #64748b;
                --border: #e2e8f0;
                --danger: #ef4444;
            }
            body { margin: 0; font-family: 'Inter', sans-serif; background: var(--bg); color: var(--text-main); display: flex; height: 100vh; overflow: hidden; }
            .sidebar { width: 260px; background: var(--sidebar-bg); color: white; display: flex; flex-direction: column; flex-shrink: 0; }
            .sidebar-header { padding: 24px; font-size: 1.25rem; font-weight: 600; border-bottom: 1px solid var(--sidebar-hover); letter-spacing: 0.5px; }
            .nav-links { display: flex; flex-direction: column; padding: 16px 0; flex: 1; }
            .nav-link { padding: 16px 24px; color: #cbd5e1; text-decoration: none; display: flex; align-items: center; gap: 12px; transition: all 0.2s ease; font-weight: 500; }
            .nav-link:hover { background: var(--sidebar-hover); color: white; }
            .nav-link.danger { margin-top: auto; color: #fca5a5; }
            .nav-link.danger:hover { background: rgba(239, 68, 68, 0.1); color: var(--danger); border-left-color: var(--danger); }
            
            .main-content { flex: 1; padding: 40px; overflow-y: auto; box-sizing: border-box; }
            
            .welcome-section { margin-bottom: 40px; }
            .welcome-section h1 { font-size: 2rem; font-weight: 700; color: var(--text-main); margin: 0 0 8px 0; letter-spacing: -0.02em; }
            .welcome-section p { font-size: 1.1rem; color: var(--text-light); margin: 0; }
            
            .admin-container {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
                gap: 24px;
            }
            
            .card {
                background: var(--surface);
                padding: 32px 24px;
                border-radius: 12px;
                text-align: center;
                box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.05);
                border: 1px solid var(--border);
                cursor: pointer;
                transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
                display: flex;
                flex-direction: column;
                align-items: center;
                text-decoration: none;
            }
            
            .card:hover { 
                transform: translateY(-4px); 
                box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1);
                border-color: var(--primary);
            }
            
            .card-icon {
                background: #f0fdfa;
                color: var(--primary);
                width: 64px;
                height: 64px;
                border-radius: 16px;
                display: flex;
                align-items: center;
                justify-content: center;
                margin-bottom: 16px;
                transition: background 0.2s;
            }
            
            .card-icon svg { width: 32px; height: 32px; }
            
            .card h3 { font-size: 1.25rem; font-weight: 600; color: var(--text-main); margin: 0 0 8px 0; }
            .card p { font-size: 0.95rem; color: var(--text-light); margin: 0; }
            
            .card.danger-card:hover { border-color: var(--danger); }
            .card.danger-card .card-icon { background: #fef2f2; color: var(--danger); }
            .card.danger-card h3 { color: var(--danger); }
        </style>
    </head>
    <body>
        <aside class="sidebar">
            <div class="sidebar-header">PetSociety Admin</div>
            <nav class="nav-links">
                <a href="mascotas.jsp" class="nav-link">
                    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                    Mascotas
                </a>
                <a href="registroCita.jsp" class="nav-link">
                    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg>
                    Citas
                </a>
                <a href="inventario.jsp" class="nav-link">
                    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><line x1="16.5" y1="9.4" x2="7.5" y2="4.21"></line><path d="M21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16z"></path><polyline points="3.27 6.96 12 12.01 20.73 6.96"></polyline><line x1="12" y1="22.08" x2="12" y2="12"></line></svg>
                    Inventario
                </a>
                <a href="index.jsp" class="nav-link danger">
                    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path><polyline points="16 17 21 12 16 7"></polyline><line x1="21" y1="12" x2="9" y2="12"></line></svg>
                    Salir
                </a>
            </nav>
        </aside>

        <main class="main-content">
            <div class="welcome-section">
                <h1>Bienvenido al Sistema PetSociety</h1>
                <p>Seleccione una opción para gestionar la veterinaria</p>
            </div>

            <div class="admin-container">
                <a href="mascotas.jsp" class="card">
                    <div class="card-icon">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                    </div>
                    <h3>Mascotas</h3>
                    <p>Gestionar pacientes</p>
                </a>

                <a href="registroCita.jsp" class="card">
                    <div class="card-icon">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect><line x1="16" y1="2" x2="16" y2="6"></line><line x1="8" y1="2" x2="8" y2="6"></line><line x1="3" y1="10" x2="21" y2="10"></line></svg>
                    </div>
                    <h3>Citas</h3>
                    <p>Programar atención</p>
                </a>

                <a href="inventario.jsp" class="card">
                    <div class="card-icon">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><line x1="16.5" y1="9.4" x2="7.5" y2="4.21"></line><path d="M21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16z"></path><polyline points="3.27 6.96 12 12.01 20.73 6.96"></polyline><line x1="12" y1="22.08" x2="12" y2="12"></line></svg>
                    </div>
                    <h3>Inventario</h3>
                    <p>Medicamentos y stock</p>
                </a>
                
                <a href="index.jsp" class="card danger-card">
                    <div class="card-icon">
                        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"></path><polyline points="16 17 21 12 16 7"></polyline><line x1="21" y1="12" x2="9" y2="12"></line></svg>
                    </div>
                    <h3>Salir</h3>
                    <p>Cerrar sesión</p>
                </a>
            </div>
        </main>
    </body>
</html>
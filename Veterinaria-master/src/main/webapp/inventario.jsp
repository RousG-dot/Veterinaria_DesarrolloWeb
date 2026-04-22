<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inventario - PetSociety</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap" rel="stylesheet">
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
            .nav-link.active { background: var(--sidebar-hover); color: white; border-left: 4px solid var(--primary); }
            .nav-link.danger { margin-top: auto; color: #fca5a5; }
            .nav-link.danger:hover { background: rgba(239, 68, 68, 0.1); color: var(--danger); border-left-color: var(--danger); }
            .main-content { flex: 1; padding: 40px; overflow-y: auto; box-sizing: border-box; }
            
            .card { background: var(--surface); border-radius: 12px; padding: 32px; box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.05); border: 1px solid var(--border); }
            .header-title { font-size: 1.5rem; font-weight: 600; margin: 0 0 24px 0; }
            
            table { width: 100%; border-collapse: collapse; }
            th, td { padding: 16px; text-align: left; border-bottom: 1px solid var(--border); }
            th { background: #f8fafc; font-weight: 600; color: var(--text-light); text-transform: uppercase; font-size: 0.75rem; letter-spacing: 0.05em; }
            tr:hover td { background: #f1f5f9; }
            td { font-size: 0.9rem; }
            
            .badge { display: inline-block; padding: 4px 10px; border-radius: 9999px; font-size: 0.75rem; font-weight: 600; }
            .badge-success { background: #dcfce7; color: #166534; }
            .badge-warning { background: #fef9c3; color: #854d0e; }

            .action-footer {
                margin-top: 24px;
                padding-top: 20px;
                border-top: 1px solid var(--border);
                display: flex;
                justify-content: flex-start;
            }
            .btn-return {
                display: inline-flex;
                align-items: center;
                gap: 8px;
                color: var(--text-light);
                text-decoration: none;
                font-weight: 500;
                font-size: 0.9rem;
                padding: 8px 12px;
                border-radius: 6px;
                transition: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
                background: transparent;
            }
            .btn-return:hover {
                color: var(--primary-hover);
                background: #f0fdfa;
                transform: translateX(-4px);
            }
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
                <a href="inventario.jsp" class="nav-link active">
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
            <div class="card">
                <h1 class="header-title">Inventario de Medicamentos</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Categoría</th>
                            <th>Stock</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Antipulgas</td>
                            <td>Farmacia</td>
                            <td>15 unidades</td>
                            <td><span class="badge badge-success">Disponible</span></td>
                        </tr>
                        <tr>
                            <td>Vacuna Triple Felina</td>
                            <td>Vacunas</td>
                            <td>5 unidades</td>
                            <td><span class="badge badge-warning">Stock Bajo</span></td>
                        </tr>
                    </tbody>
                </table>

                <div class="action-footer">
                    <a href="panelAdmin.jsp" class="btn-return">
                        <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                            <line x1="19" y1="12" x2="5" y2="12"></line>
                            <polyline points="12 19 5 12 12 5"></polyline>
                        </svg>
                        Volver al Panel Administrativo
                    </a>
                </div>
            </div>
        </main>
    </body>
</html>
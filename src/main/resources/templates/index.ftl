<#-- index.ftl -->
<!DOCTYPE html>
<html lang="${lang.languageCode}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle!lang.pageTitle!"Jolt Template"}</title>
    <!-- Bootstrap CSS -->
    <link nonce="${nonce()}"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Votre CSS personnalisé -->
    <link nonce="${nonce()}" href="/style/root.css" rel="stylesheet">
</head>
<body>
    <!-- Inclusion des flashes (succès / erreur) -->
    <#include "/components/flash.ftl">

    <!-- ============================= -->
    <!-- 1. NAVBAR FIXE EN HAUT       -->
    <!-- ============================= -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm">
      <div class="container">
        <a class="navbar-brand" href="/">Jolt Framework</a>
        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false"
                aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/">${lang.nav.home!""}</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#about">${lang.nav.about!""}</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#getting-started">${lang.nav.gettingStarted!""}</a>
            </li>
          </ul>
          <div class="d-flex">
            <div class="dropdown">
              <button class="btn btn-light dropdown-toggle" type="button"
                      id="langDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                ${lang.nav.language!""}
              </button>
              <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="langDropdown">
                <li><a class="dropdown-item" href="/change-lang?lang=en">English</a></li>
                <li><a class="dropdown-item" href="/change-lang?lang=fr">Français</a></li>
                <!--
                <li><a class="dropdown-item" href="/change-lang?lang=es">Español</a></li>
                -->
              </ul>
            </div>
          </div>
        </div>
      </div>
    </nav>

    <!-- ============================= -->
    <!-- 2. SECTION “HERO” D’ACCUEIL   -->
    <!-- ============================= -->
    <header class="bg-light py-5">
      <div class="container text-center">
        <h1 class="display-4 fw-bold">${lang.hero.title!""}</h1>
        <p class="lead mb-4">${lang.hero.subtitle!""}</p>
        <a href="https://github.com/T1WiLLi/JoltExamples" class="btn btn-primary btn-lg" target="_blank">
          ${lang.hero.cta!""}
        </a>
      </div>
    </header>

    <!-- ============================= -->
    <!-- 3. SECTION “À PROPOS”         -->
    <!-- ============================= -->
    <section id="about" class="py-5 bg-white">
      <div class="container">
        <h2 class="mb-4 text-center">${lang.about.title!""}</h2>
        <p class="text-center mb-5">${lang.about.description!""}</p>
        <div class="row justify-content-center">
          <div class="col-md-8">
            <ul class="list-group list-group-flush">
              <li class="list-group-item">${lang.about.point1!""}</li>
              <li class="list-group-item">${lang.about.point2!""}</li>
              <li class="list-group-item">${lang.about.point3!""}</li>
            </ul>
          </div>
        </div>
      </div>
    </section>

    <!-- ============================= -->
    <!-- 4. SECTION “GETTING STARTED”   -->
    <!-- ============================= -->
    <section id="getting-started" class="py-5 bg-light">
      <div class="container">
        <h2 class="mb-4 text-center">${lang.gettingStarted.title!""}</h2>
        <p class="text-center mb-4">${lang.gettingStarted.subtitle!""}</p>
        <div class="row justify-content-center">
          <div class="col-md-8">
            <div class="card shadow-sm">
              <div class="card-body">
                <pre class="bg-dark text-white p-3 rounded">
<code>
# Cloner le dépôt d'exemple
git clone https://github.com/T1WiLLi/jolt-template
cd JoltExamples/jolt-template

# Construire et lancer avec Docker Compose
docker compose up --watch
</code>
                </pre>
                <p class="mt-3">${lang.gettingStarted.note!""}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- ============================= -->
    <!-- 5. FOOTER                     -->
    <!-- ============================= -->
    <footer class="bg-primary text-white py-4">
      <div class="container text-center">
        <small>${lang.footer!""}</small>
      </div>
    </footer>

    <!-- ============================= -->
    <!-- SCRIPTS BOOTSTRAP + APP.JS     -->
    <!-- ============================= -->
    <script nonce="${nonce()}"
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
    </script>
    <script type="module" nonce="${nonce()}" src="/js/App.js"></script>
    <script type="module" nonce="${nonce()}">
      import App from '/js/App.js';
      document.addEventListener('DOMContentLoaded', () => {
        const app = new App();
      });
  </script>
</body>
</html>

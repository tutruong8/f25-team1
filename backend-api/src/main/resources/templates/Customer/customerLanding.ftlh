<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Customer Home</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.4/css/bulma.min.css">
  <link rel="stylesheet" href="styles.css"> <!-- Sidebar CSS -->
  <script defer src="https://use.fontawesome.com/releases/v6.4.0/js/all.js"></script>
  
</head>
<body class="has-background-link">

  <!-- Navbar -->
  <nav class="navbar is-link" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <a class="navbar-item" id="sidebarToggle"><strong>DreamBuilds</strong></a>
      <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarMenu">
        <span aria-hidden="true"></span><span aria-hidden="true"></span><span aria-hidden="true"></span>
      </a>
    </div>

    <div id="navbarMenu" class="navbar-menu">
      <div class="navbar-start">
        <a class="navbar-item">Build</a>
        <a class="navbar-item">Pre-Built</a>
        <a class="navbar-item">About</a>
      </div>

      <div class="navbar-end">
        <div class="navbar-item has-dropdown is-hoverable">
          <a class="navbar-link">
            <span class="icon"><i class="fas fa-user"></i></span>
            <span>Profile</span>
          </a>
          <div class="navbar-dropdown is-right">
            <a class="navbar-item">Account</a>
            <a class="navbar-item">Settings</a>
            <hr class="navbar-divider">
            <a class="navbar-item" href="/f25-team1/high-fidelity-prototype/CustomerLogin.html">Logout</a>
          </div>
        </div>
      </div>
    </div>
  </nav>

  <!-- Sidebar -->
  <div class="sidebar is-primary" id="sidebar">
    <aside class="menu">
      <p class="menu-label">Navigation</p>
      <ul class="menu-list">
        <li><a href="#">Reviews</a></li>
        <li><a href="#">Orders</a></li>
      </ul>
      <p class="menu-label">Other</p>
      <ul class="menu-list">
        <li><a href="#">Help</a></li>
      </ul>
    </aside>
  </div>
  <div class="sidebar-overlay" id="sidebarOverlay"></div>

  <!-- Hero Section -->
  <section class="hero is-dark is-fullheight-with-navbar">
    <div class="hero-body">
      <div class="container has-text-centered">
        <h1 class="title">Welcome to DreamBuilds</h1>
        <h2 class="subtitle">Explore our Specials offers, New arrivals, or Build your own PC/Laptop!</h2>
      </div>
    </div>
  </section>

  <!-- Top cards/buttons -->
  <section class="section top-cards container">
    <div class="columns is-variable is-8">
      <div class="column">
        <div class="card has-text-centered" onclick="alert('Redirect to build page')">
          <div class="card-content">
            <p class="title">Get Started on a Build</p>
            <p class="subtitle">Customize your own PC or Laptop</p>
          </div>
        </div>
      </div>
      <div class="column">
        <div class="card has-text-centered" onclick="alert('Redirect to pre-built page')">
          <div class="card-content">
            <p class="title">Pre-Built PCs & Laptops</p>
            <p class="subtitle">Browse available pre-built systems</p>
          </div>
        </div>
      </div>
    </div>
  </section>



 
</body>
</html>

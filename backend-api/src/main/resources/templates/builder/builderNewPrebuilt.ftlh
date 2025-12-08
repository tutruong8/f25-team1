<!DOCTYPE html>
<html lang="en">

<!--Header of html for about page. Imports Bulma CSS and local style.css-->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bulma@1.0.4/css/bulma.min.css"
    >
    <title>Builder's Services</title>
</head>

<body>
<nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item" href="/builder/${builder.id}">
        Profile
      </a>
      <a class="navbar-item is-active" href="/builder/${builder.id}/services">
        Services
      </a>
      <a class="navbar-item" href="/builder/${builder.id}/customer-statistics">
        Customer Statistics
      </a>
      <a class="navbar-item" href="/builder/${builder.id}/reviews">
        Your Reviews
      </a>
    </div>
  </div>
</nav>

<h1 class="title">
      General Info
    </h1>
<form class="box">
  <div class="field">
    <div class="columns">
  <div class="column">Type name of PC Here
    <input class="input" type="email" placeholder="e.g. Tu's PC" />
  </div>
  <div class="column">Type Description Here
    <input class="input" type="email" placeholder="e.g. Gaming and Work PC" />
  </div>
  <div class="column">Set Price
    <input class="input" type="email" placeholder="e.g. $2,500" />
  </div>
</div>
  </div>
</form>

<h1 class="title">
      CPU
    </h1>
<form class="box">
  <div class="field">
    <label class="label">Type name of CPU</label>
    <div class="control">
      <input class="input" type="email" placeholder="e.g. AMD Ryzen 7 5700X3D" />
    </div>
  </div>
</form>

<h1 class="title">
      GPU
    </h1>
<form class="box">
  <div class="field">
    <label class="label">Type name of GPU here</label>
    <div class="control">
      <input class="input" type="email" placeholder="e.g. AMD Radeon RX 9070 XT" />
    </div>
  </div>
</form>

<h1 class="title">
      RAM
    </h1>
<form class="box">
  <div class="field">
    <label class="label">Type name of RAM here</label>
    <div class="control">
      <input class="input" type="email" placeholder="e.g. Corsair Vengeance 32GB RAM" />
    </div>
  </div>
</form>

<h1 class="title">
      Storage
    </h1>
<form class="box">
  <div class="field">
    <label class="label">Type name of storage here</label>
    <div class="control">
      <input class="input" type="email" placeholder="e.g. W.D.Black 2TB NVme 4.0" />
    </div>
  </div>
</form>

<h1 class="title">
      PC Case
    </h1>
<form class="box">
  <div class="field">
    <label class="label">Type name of PC Case here</label>
    <div class="control">
      <input class="input" type="email" placeholder="e.g. Lian Li A3" />
    </div>
  </div>
</form>

<h1 class="title">
      Cooling (CPU Coolers/Fans)
    </h1>
<form class="box">
  <div class="field">
    <label class="label">Type cooling devices here. Sepearate items with columns to add multiple</label>
    <div class="control">
      <input class="input" type="email" placeholder="e.g. Thermalright Phantom Spirit 120 SE, Arctic P20, Arctic P20" />
    </div>
  </div>
</form>

  <button class="button">Add</button>
<script>
    document.addEventListener('DOMContentLoaded', () => {

      // Get all "navbar-burger" elements
      const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

      // Add a click event on each of them
      $navbarBurgers.forEach( el => {
        el.addEventListener('click', () => {

          // Get the target from the "data-target" attribute
          const target = el.dataset.target;
          const $target = document.getElementById(target);

          // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
          el.classList.toggle('is-active');
          $target.classList.toggle('is-active');

        });
      });

    });
</script>

</body>
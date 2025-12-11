<!DOCTYPE html>
<html lang="en">

<!--Header of html for about page. Imports Bulma and local style.css-->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bulma@1.0.4/css/bulma.min.css"
    >
    <title>Builder's Statistics</title>
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
      <a class="navbar-item" href="/builder/${builder.id}/services">
        Services
      </a>
      <a class="navbar-item is-active" href="/builder/${builder.id}/reviews">
        Your Reviews
      </a>
    </div>
  </div>
</nav>

<#list reviews as r>
    <div class="card" style="margin: 20px;">
      <header class="card-header">
        <p class="card-header-title">
          ${r.customer.name!"Anonymous"}
        </p>
        <p class="subtitle is-6">Rating: ${r.rating}/10</p>
      </header>

      <div class="card-content">
        <div class="content">
          ${r.comment}
        </div>

        <#if r.reply??>
            <strong>Your Reply:</strong><br>
            ${r.reply}
        </#if>
      </div>

      <footer class="card-footer">
        <a href="/builder/${builderId}/reviews/${r.id}/reply"
           class="card-footer-item">Reply/Edit Reply</a>
      </footer>
    </div>
</#list>

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
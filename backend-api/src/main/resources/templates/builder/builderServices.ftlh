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
      <a class="navbar-item" href="/builder/${builder.id}/reviews">
        Your Reviews
      </a>
    </div>
  </div>
</nav>

    <a href="/pcpart/new?builderId=${builder.id}" class="button">
      Add Computer Part
    </a>

    <div class="card">
      <header class="card-header">
        <p class="card-header-title">Parts</p>
        <button class="card-header-icon" aria-label="more options">
          <span class="icon">
            <i class="fas fa-angle-down" aria-hidden="true"></i>
          </span>
        </button>
      </header>
      <div class="card-content">
        <div class="content">
          <div class="columns">
            <div class="column">Name</div>
            <div class="column">Price</div>
            <div class="column">Quantity</div>
            <div class="column">Type</div>
            <div class="column">Description</div>
            <div class="column">Customer Statistics (No. Saved/Customers)</div>
            <div class="column is-narrow"></div>
          </div>
          <#list builder.parts as p>
            <div class="columns">
              <div class="column">${p.name}</div>
              <div class="column">$${p.price}</div>
              <div class="column">${p.quantity!0}</div>
              <div class="column">${p.partType}</div>
              <div class="column">${p.description}</div>
              <div class="column">
                ${p.customerCount?c}
                <div class="dropdown is-hoverable is-right">
                  <div class="dropdown-trigger">
                    <button class="button is-small" aria-haspopup="true" aria-controls="dropdown-menu">
                      <span>Details</span>
                      <span class="icon is-small">
                        <i class="fas fa-angle-down" aria-hidden="true"></i>
                      </span>
                    </button>
                  </div>
                  <div class="dropdown-menu" id="dropdown-menu" role="menu">
                    <div class="dropdown-content">
                      <#if p.customers?size == 0>
                        <div class="dropdown-item">No customers yet</div>
                          <#else>
                          <#list p.customers as c>
                            <div class="dropdown-item">
                                ${c.name}
                            </div>
                          </#list>
                      </#if>
                    </div>
                  </div>
                </div>
              </div>
              <div class="column is-narrow">
                <a class="button is-small is-info" 
                  href="/pcpart/${p.id}/edit?builderId=${builder.id}">
                  Edit
                </a>
              </div>
            </div>
          </#list>
        </div>
      </div>
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
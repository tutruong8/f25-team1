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
    <title>Builder's Profile</title>
</head>

<!-- The Goal of this profile screen is to have everything on one screen as much as possible. 
 One screen for showing current login info and options to change info. 
 Password however won't be viewable for security reasons. 
 If you are able to remember and log in, then you should be able to remember how to get in. -->
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
      <a class="navbar-item is-active" href="/builder/${builder.id}">
        Profile
      </a>
      <a class="navbar-item" href="/builder/${builder.id}/services">
        Services
      </a>
      <a class="navbar-item" href="/builder/${builder.id}/reviews">
        Your Reviews
      </a>
    </div>
  </div>
</nav>


<form id="updateBuilder" action="/builder/${builder.id}" method="post">
  <div class="field">
        <label class="label">Username</label>
        <input class="input" id="name" type="text" name="name" value="${builder.name!}" placeholder="Enter new username">
    </div>

    <div class="field">
        <label class="label">New Password</label>
        <input class="input" id="password" type="password" name="password" placeholder="Enter new password">
    </div>

    <div class="field">
        <label class="label">Email</label>
        <input class="input" id="email" type="text" name="email" value="${builder.email!}" placeholder="Enter new email">
    </div>

    <div class="field">
        <label class="label">Address</label>
        <input class="input" id="address" type="text" name="address" value="${builder.address!}" placeholder="Enter new address">
    </div>
    <div class="field">
      <button class="button is-success">Update</button>
    </div>
</form>

<a href="/builder/existing" class="button">
  Log Out
</a>

<a href="/builder/delete/${builder.id}" class="btn btn-danger">Delete</a>
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

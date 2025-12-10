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

<form class="box" method="post" action="/computer">
    <input type="hidden" name="builderId" value="${builder.id}">
    <h1 class="title">General Info</h1>
    <div class="columns">
        <div class="column">
            <label class="label">PC Name</label>
            <input class="input" type="text" name="name" placeholder="e.g. Tu's PC" />
        </div>
        <div class="column">
            <label class="label">Description</label>
            <input class="input" type="text" name="description" placeholder="e.g. Gaming and Work PC" />
        </div>
        <div class="column">
            <label class="label">Price</label>
            <input class="input" type="text" name="price" placeholder="e.g. 2500.00" />
        </div>
    </div>
    <div class="field">
        <label class="label">Image URL</label>
        <input class="input" type="text" name="imageUrl" placeholder="https://example.com/pc.png" />
    </div>
    <h1 class="title">CPU</h1>
    <div class="field">
        <label class="label">Choose CPU</label>
        <div class="select is-fullwidth">
            <select name="cpuId">
                <#list cpuParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <h1 class="title">GPU</h1>
    <div class="field">
        <label class="label">Choose GPU</label>
        <div class="select is-fullwidth">
            <select name="gpuId">
                <#list gpuParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <h1 class="title">RAM</h1>
    <div class="field">
        <label class="label">Choose RAM</label>
        <div class="select is-fullwidth">
            <select name="ramId">
                <#list ramParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <h1 class="title">Storage</h1>
    <div class="field">
        <label class="label">Choose Storage</label>
        <div class="select is-fullwidth">
            <select name="storageId">
                <#list storageParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <h1 class="title">Case</h1>
    <div class="field">
        <label class="label">Choose Case</label>
        <div class="select is-fullwidth">
            <select name="caseId">
                <#list caseParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <h1 class="title">Cooler</h1>
    <div class="field">
        <label class="label">Choose Cooler</label>
        <div class="select is-fullwidth">
            <select name="coolerId">
                <#list coolerParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <h1 class="title">Power Supply</h1>
    <div class="field">
        <label class="label">Choose PSU</label>
        <div class="select is-fullwidth">
            <select name="psuId">
                <#list psuParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <h1 class="title">Motherboard</h1>
    <div class="field">
        <label class="label">Choose Motherboard</label>
        <div class="select is-fullwidth">
            <select name="moboId">
                <#list moboParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <h1 class="title">Fans</h1>
    <div class="field">
        <label class="label">Choose Fans</label>
        <div class="select is-fullwidth">
            <select name="fanId">
                <#list fanParts as p>
                    <option value="${p.id}">${p.name} — $${p.price}</option>
                </#list>
            </select>
        </div>
    </div>
    <button class="button is-success is-large">Create Prebuilt</button>
</form>

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
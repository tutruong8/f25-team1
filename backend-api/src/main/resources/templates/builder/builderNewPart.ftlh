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

<form class="box" method="post" action="/pcpart">
  <input type="hidden" name="builderId" value="${builder.id}">

  <div class="field">
    <label class="label">Type of Part</label>
    <div class="select">
      <select name="partType">
      <#list partTypes as t>
          <option value="${t}">${t}</option>
      </#list>
      </select>
    </div>
  </div>

  <div class="field">
    <label class="label">Name of Part</label>
    <div class="control">
      <input class="input" id="name" name="name" value="${part.name!}" type="text" placeholder="e.g. AMD Radeon RX 9070 XT" />
    </div>
  </div>

  <div class="field">
    <label class="label">Description</label>
    <div class="control">
      <input class="input" id="description" name="description" value="${part.description!}" type="text" placeholder="e.g. 1440p gaming" />
    </div>
  </div>

  <div class="field">
    <label class="label">Set Price</label>
    <div class="control">
      <input class="input" id="price" name="price" value="${part.price!}" type="text" placeholder="e.g. 1008.00" />
    </div>
  </div>

  <div class="field">
    <label class="label">Set Quantity</label>
    <div class="control">
      <input class="input" id="quantity" name="quantity" value="${part.quantity!}" type="text" placeholder="e.g. 67" />
    </div>
  </div>
  <div class="field">
    <button class="button is-success">Add</button>
  </div>

  <!-- CPU fields -->
<#if part.partType == "CPU">
<div class="field">
  <label class="label">Socket</label>
  <input class="input" name="socket" value="${part.socket!}" placeholder="e.g. AM4, LGA1700">
</div>
</#if>

<!-- Motherboard fields -->
<#if part.partType == "MOTHERBOARD">
<div class="field">
  <label class="label">Socket</label>
  <input class="input" name="socket" value="${part.socket!}" placeholder="e.g. AM4">
</div>

<div class="field">
  <label class="label">RAM Type</label>
  <input class="input" name="ramType" value="${part.ramType!}" placeholder="e.g. DDR4 or DDR5">
</div>

<div class="field">
  <label class="label">Form Factor</label>
  <input class="input" name="formFactor" value="${part.formFactor!}" placeholder="ATX, MicroATX">
</div>
</#if>

<!-- RAM fields -->
<#if part.partType == "RAM">
<div class="field">
  <label class="label">RAM Type</label>
  <input class="input" name="ramType" value="${part.ramType!}" placeholder="DDR4, DDR5">
</div>
</#if>

<!-- GPU fields -->
<#if part.partType == "GPU">
<div class="field">
  <label class="label">Required PSU Wattage</label>
  <input class="input" type="number" name="requiredWatt" value="${part.requiredWatt!}">
</div>

<div class="field">
  <label class="label">GPU Length (mm)</label>
  <input class="input" type="number" name="gpuLength" value="${part.gpuLength!}">
</div>
</#if>

<!-- Case fields -->
<#if part.partType == "CASE">
<div class="field">
  <label class="label">Max GPU Length (mm)</label>
  <input class="input" type="number" name="gpuMaxLength" value="${part.gpuMaxLength!}">
</div>

<div class="field">
  <label class="label">Supported Form Factor</label>
  <input class="input" name="formFactor" value="${part.formFactor!}" placeholder="ATX, mATX">
</div>
</#if>

<!-- PSU fields -->
<#if part.partType == "PSU">
<div class="field">
  <label class="label">Wattage</label>
  <input class="input" type="number" name="wattage" value="${part.wattage!}">
</div>
</#if>

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
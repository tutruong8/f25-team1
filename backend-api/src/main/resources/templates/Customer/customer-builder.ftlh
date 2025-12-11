<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Build Your PC</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.4/css/bulma.min.css">
  <link rel="stylesheet" href="styles.css"> <!-- Sidebar CSS -->
  <script defer src="https://use.fontawesome.com/releases/v6.4.0/js/all.js"></script>

</head>

<body class="has-background-black-ter">

  <!-- Navbar Start -->
  <nav class="navbar is-link" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <a class="navbar-item" id="sidebarToggle"><strong>DreamBuilds</strong></a>
      <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarMenu">
        <span aria-hidden="true"></span><span aria-hidden="true"></span><span aria-hidden="true"></span>
      </a>
    </div>

    <div id="navbarMenu" class="navbar-menu">
      <div class="navbar-start">
        <a href="customerBuilds.html" class="navbar-item">Build</a>
      </div>

      <div class="navbar-end">
        <div class="navbar-item has-dropdown is-hoverable">
          <a class="navbar-link">
            <span class="icon"><i class="fas fa-user"></i></span>
            <span>Profile</span>
          </a>
          <div class="navbar-dropdown is-right">
            <a href="customerProfile.html" class="navbar-item">Account</a>
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
        <li><a href="customerLanding.html">Home</a></li>
        <li><a href="customerReviews.html">Reviews</a></li>
      </ul>
      <p class="menu-label">Other</p>
      <ul class="menu-list">
        <li><a href="customerProfile.html">Account</a></li>
      </ul>
    </aside>
  </div>
  <div class="sidebar-overlay" id="sidebarOverlay"></div>
  <!-- Navbar End -->

<!-- PC Builder Section -->
<section class="section is-dark">
  <div class="container">
    <h1 class="title has-text-centered has-text-white">Build Your Own PC</h1>
    <p class="subtitle has-text-centered has-text-light">
      Choose your components and see your build update in real time!
    </p>

    <!-- LEFT SIDE -->
    <div class="columns is-variable is-6">
      <div class="column is-two-thirds">
        <div class="box">
          <p class="has-text-weight-semibold mb-3">Core Components</p>

          <!-- CPU -->
          <div class="box builder-row" data-type="cpu">
            <div class="level">
              <div class="level-left">
                <div>
                  <p class="heading">CPU</p>
                  <p class="title is-6" id="label-cpu">Not selected</p>
                </div>
              </div>
              <div class="level-right">
                <p class="mr-3">$<span id="price-cpu">0.00</span></p>
                <button class="button is-link is-light is-small select-part" data-type="cpu">
                  Customize
                </button>
              </div>
            </div>
          </div>

          <!-- GPU -->
          <div class="box builder-row" data-type="gpu">
            <div class="level">
              <div class="level-left">
                <div>
                  <p class="heading">GPU</p>
                  <p class="title is-6" id="label-gpu">Not selected</p>
                </div>
              </div>
              <div class="level-right">
                <p class="mr-3">$<span id="price-gpu">0.00</span></p>
                <button class="button is-link is-light is-small select-part" data-type="gpu">
                  Customize
                </button>
              </div>
            </div>
          </div>

          <!-- Motherboard -->
          <div class="box builder-row" data-type="motherboard">
            <div class="level">
              <div class="level-left">
                <div>
                  <p class="heading">Motherboard</p>
                  <p class="title is-6" id="label-motherboard">Not selected</p>
                </div>
              </div>
              <div class="level-right">
                <p class="mr-3">$<span id="price-motherboard">0.00</span></p>
                <button class="button is-link is-light is-small select-part" data-type="motherboard">
                  Customize
                </button>
              </div>
            </div>
          </div>

          <!-- RAM -->
          <div class="box builder-row" data-type="ram">
            <div class="level">
              <div class="level-left">
                <div>
                  <p class="heading">Memory (RAM)</p>
                  <p class="title is-6" id="label-ram">Not selected</p>
                </div>
              </div>
              <div class="level-right">
                <p class="mr-3">$<span id="price-ram">0.00</span></p>
                <button class="button is-link is-light is-small select-part" data-type="ram">
                  Customize
                </button>
              </div>
            </div>
          </div>

          <!-- Storage -->
          <div class="box builder-row" data-type="storage">
            <div class="level">
              <div class="level-left">
                <div>
                  <p class="heading">Storage</p>
                  <p class="title is-6" id="label-storage">Not selected</p>
                </div>
              </div>
              <div class="level-right">
                <p class="mr-3">$<span id="price-storage">0.00</span></p>
                <button class="button is-link is-light is-small select-part" data-type="storage">
                  Customize
                </button>
              </div>
            </div>
          </div>

          <!-- PSU -->
          <div class="box builder-row" data-type="psu">
            <div class="level">
              <div class="level-left">
                <div>
                  <p class="heading">Power Supply</p>
                  <p class="title is-6" id="label-psu">Not selected</p>
                </div>
              </div>
              <div class="level-right">
                <p class="mr-3">$<span id="price-psu">0.00</span></p>
                <button class="button is-link is-light is-small select-part" data-type="psu">
                  Customize
                </button>
              </div>
            </div>
          </div>

          <!-- Case -->
          <div class="box builder-row" data-type="case">
            <div class="level">
              <div class="level-left">
                <div>
                  <p class="heading">Case</p>
                  <p class="title is-6" id="label-case">Not selected</p>
                </div>
              </div>
              <div class="level-right">
                <p class="mr-3">$<span id="price-case">0.00</span></p>
                <button class="button is-link is-light is-small select-part" data-type="case">
                  Customize
                </button>
              </div>
            </div>
          </div>

        </div>
      </div>

      <!-- RIGHT: Summary -->
      <div class="column is-one-third">
        <div class="box">
          <p class="has-text-weight-semibold mb-3">Build Summary</p>

          <ul id="summaryList" class="mb-3"></ul>

          <hr>
          <p class="is-size-5">
            <strong>Total: $<span id="totalPrice">0.00</span></strong>
          </p>

          <button id="saveBuildBtn" class="button is-link is-fullwidth mt-3">
           Save Dream Build
          </button>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Part selection modal -->
<div class="modal" id="partModal">
  <div class="modal-background"></div>
  <div class="modal-card">
    <header class="modal-card-head">
      <p class="modal-card-title" id="modalTitle">Select Part</p>
      <button class="delete" aria-label="close" id="closeModal"></button>
    </header>
    <section class="modal-card-body" id="modalBody">
      
    </section>
  </div>
</div>

<!-- CPU -->
<div id="template-cpu" class="is-hidden">
  <#list cpus as p>
    <button class="button is-fullwidth part-option"
            data-type="cpu"
            data-id="${p.id}"
            data-name="${p.name}"
            data-price="${p.price}"
            data-socket="${p.socket!}">
      <span>${p.name}</span><span>$${p.price}</span>
    </button>
    <hr>
  </#list>
</div>

<!-- GPU -->
<div id="template-gpu" class="is-hidden">
  <#list gpus as p>
    <button class="button is-fullwidth part-option"
            data-type="gpu"
            data-id="${p.id}"
            data-name="${p.name}"
            data-price="${p.price}"
            data-requiredWatt="${p.requiredWatt!}"
            data-gpuLength="${p.gpuLength!}">
      <span>${p.name}</span><span>$${p.price}</span>
    </button>
    <hr>
  </#list>
</div>

<!-- Motherboard -->
<div id="template-motherboard" class="is-hidden">
  <#list mobos as p>
    <button class="button is-fullwidth part-option"
            data-type="motherboard"
            data-id="${p.id}"
            data-name="${p.name}"
            data-price="${p.price}"
            data-socket="${p.socket!}"
            data-ramType="${p.ramType!}"
            data-formFactor="${p.formFactor!}">
      <span>${p.name}</span><span>$${p.price}</span>
    </button>
    <hr>
  </#list>
</div>

<!-- RAM -->
<div id="template-ram" class="is-hidden">
  <#list rams as p>
    <button class="button is-fullwidth part-option"
            data-type="ram"
            data-id="${p.id}"
            data-name="${p.name}"
            data-price="${p.price}"
            data-ramType="${p.ramType!}">
      <span>${p.name}</span><span>$${p.price}</span>
    </button>
    <hr>
  </#list>
</div>

<!-- Storage -->
<div id="template-storage" class="is-hidden">
  <#list storages as p>
    <button class="button is-fullwidth part-option"
            data-type="storage"
            data-id="${p.id}"
            data-name="${p.name}"
            data-price="${p.price}">
      <span>${p.name}</span><span>$${p.price}</span>
    </button>
    <hr>
  </#list>
</div>

<!-- PSU -->
<div id="template-psu" class="is-hidden">
  <#list psus as p>
    <button class="button is-fullwidth part-option"
            data-type="psu"
            data-id="${p.id}"
            data-name="${p.name}"
            data-price="${p.price}"
            data-wattage="${p.wattage!}">
      <span>${p.name}</span><span>$${p.price}</span>
    </button>
    <hr>
  </#list>
</div>

<!-- Case -->
<div id="template-case" class="is-hidden">
  <#list cases as p>
    <button class="button is-fullwidth part-option"
            data-type="case"
            data-id="${p.id}"
            data-name="${p.name}"
            data-price="${p.price}"
            data-gpuMaxLength="${p.gpuMaxLength!}">
      <span>${p.name}</span><span>$${p.price}</span>
    </button>
    <hr>
  </#list>
</div>

<script>

const CUSTOMER_ID = "${customer.customerId!0}";

// Sidebar toggle
const sidebar = document.getElementById('sidebar');
const sidebarToggle = document.getElementById('sidebarToggle');
const overlay = document.getElementById('sidebarOverlay');

sidebarToggle.addEventListener('click', () => {
  sidebar.classList.toggle('is-active');
  overlay.classList.toggle('is-active');
});
overlay.addEventListener('click', () => {
  sidebar.classList.remove('is-active');
  overlay.classList.remove('is-active');
});


//LOGIC
const selectedParts = {};

const partModal = document.getElementById('partModal');
const modalTitle = document.getElementById('modalTitle');
const modalBody = document.getElementById('modalBody');
const closeModalBtn = document.getElementById('closeModal');


// OPEN MODAL
function openModal(type) {
  modalTitle.textContent = "Select " + type.toUpperCase();

  const template = document.getElementById("template-" + type);
  modalBody.innerHTML = template.innerHTML;

  partModal.classList.add("is-active");

  // Attach click handlers to each part option
  document.querySelectorAll(".part-option").forEach(btn => {
    btn.addEventListener("click", () => selectPart(btn));
  });
}


// CLOSE MODAL
function closeModal() {
  partModal.classList.remove("is-active");
}
closeModalBtn.addEventListener("click", closeModal);
partModal.querySelector(".modal-background").addEventListener("click", closeModal);


// SELECT PART
function selectPart(btn) {
  const type = btn.dataset.type;

  selectedParts[type] = {
    id: btn.dataset.id,
    name: btn.dataset.name,
    price: Number(btn.dataset.price),

  };

  
  updateRow(type);
  updateSummary();
  closeModal();
}


// UPDATE ROW UI
function updateRow(type) {
  const label = document.getElementById(`label-${type}`);
  const priceSpan = document.getElementById(`price-${type}`);
  const part = selectedParts[type];

  label.textContent = part ? part.name : "Not selected";
  priceSpan.textContent = part ? part.price.toFixed(2) : "0.00";
}


// UPDATE SUMMARY
function updateSummary() {
  const summaryList = document.getElementById("summaryList");
  const totalPriceEl = document.getElementById("totalPrice");
  let total = 0;

  summaryList.innerHTML = "";

  Object.keys(selectedParts).forEach(type => {
    const part = selectedParts[type];
    total += part.price;
    const li = document.createElement("li");
    li.innerHTML = `<strong>${type.toUpperCase()}:</strong> ${part.name} – $${part.price.toFixed(2)}`;
    summaryList.appendChild(li);
  });

  totalPriceEl.textContent = total.toFixed(2);
}


// Hook "Customize" buttons
document.querySelectorAll(".select-part").forEach(btn => {
  btn.addEventListener("click", () => openModal(btn.dataset.type));
});



</script>


 


</body>

</html>
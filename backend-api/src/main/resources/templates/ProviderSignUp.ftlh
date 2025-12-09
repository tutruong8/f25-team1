<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Provider Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.4/css/bulma.min.css">
</head>

<body>
    <section class="hero is-fullheight">
        <div class="hero-body">
            <div class="container">
                <div class="columns is-centered">
                    <div class="column is-5-desktop">
                        <div class="box">
                            <h1 class="title has-text-centered">Provider Register</h1>
                            <form id="new-builder" action="/builder" method="post">
                                <div class="field">
                                    <label class="label">Full Name</label>
                                    <input class="input" id="name" name="name" type="text" placeholder="Enter full name">
                                </div>
                                <div class="field">
                                    <label class="label">Email</label>
                                    <input class="input" id="email" name="email" type="text" placeholder="Enter email">
                                </div>
                                <div class="field">
                                    <label class="label">Address</label>
                                    <input class="input" id="address" name="address" type="text" placeholder="Enter address">
                                </div>
                                <div class="field">
                                    <label class="label">Password</label>
                                    <input class="input" id="password" name="password" type="text" placeholder="Enter Password">
                                </div>
                                <div class="field">
                                    <button class="button is-success is-fullwidth">Register</button>
                                    
                                </div>
                            </form>
                            <p class="has-text-centered mt-4">
                                Already have an account? <a href="/builder/existing">Login here</a>
                            </p>
                            <p class="has-text-centered">
                                Are you a Customer? <a href="/customer/new">Register here</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>

</html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Provider Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.4/css/bulma.min.css">
</head>

<body>
    <section class="hero is-fullheight">
        <div class="hero-body">
            <div class="container">
                <div class="columns is-centered">
                    <div class="column is-4-desktop">
                        <div class="box">
                            <h1 class="title has-text-centered">Provider Login</h1>
                            <form id="existing-builder" action="/builder/signin" method="post">
                                <div class="field">
                                    <label class="label">Email</label>
                                    <div class="control">
                                        <input class="input" id="email" name="email" type="text" placeholder="Enter email required>
                                        <span class="icon is-small is-left">
                                            <i class="fas fa-user"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Password</label>
                                    <div class="control">
                                        <input class="input" id="password" name="password" type="password" placeholder="Enter password" required>
                                        <span class="icon is-small is-left">
                                            <i class="fas fa-lock"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="field">
                                    <button class="button is-success is-fullwidth">Login</button>
                                </div>
                            </form>
                            <p class="has-text-centered mt-4">
                                Don’t have an account? <a href="/builder/new">Sign up</a>
                            </p>
                            <p class="has-text-centered">
                                Are you a Customer? <a href="CustomerLogin.html">Login here</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>

</html>
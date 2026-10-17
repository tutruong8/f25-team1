## Title
> DreamBuild - Build Your Dream Computer

## Team Members
> Bryan Palma \
> Travis Truong

## Description
> This app is a PC and Laptop building service for those who want a specific build or recommended PCs that would fit the general need of the user. 
> The customer will have an array of options from different company brands as well as specific parts to get started from just the home page. Additionally the customer will have the option for a diy build or recommended builds. Within the diy builds the customer will then mix and match whatever parts they want in their laptop/desktop builds including but not limited to, specific cpu, gpu, how much ram, type of ram (DDR3, DDR4, DDR5, etc.), cooling (specific for desktop), how much storage, and more. They will have the freedom to build whatever they dream of so long as the parts are compatible with each other which the program will let the customer know. On the other side of thing, the recommended tab will ask the user a few questions in order to obtain the build that is suitable for the customers needs/wants. Think of it like a glorified filtering system.
> The customer will also be able to log in to wishlist parts as well as save the builds they want for later. They can also subscribe to the site to get newsletters of future deals or product availability/new hardware.
> The builders can manage the PC parts available for a build, and track customer's activity such as seeing what parts are commonly selected, and interacting with users reviews or any questions or inquires.

## App Functions
1. Customer (the user with the customer role):
    1. Create/modify customer profile - register themselves as a custumer via a new login account through the account icon at the bottom left of the page.
    2. View available services - Front page will have different catalogs of specs to browse as well as two buttons that will take customers to a diy builds sections in which they will browse any specs of thier choosing to build their dream laptops or PCs or the other taking them to recommended builds in which customers who are overwhelmed by the numerous choices in the diy section can narrow down their builds with their specific needs in mind.
    3. Subscribe to available services - Access services and weekly newsletters.
    4. Write reviews for subscribed services - Review quality of product and delivery.
2. Provider (the user with the provider role):
    1. Create/modify/remove provider profile - The provider shall be able to be registered to the app via a registration form. Additionally, a provider can modify this profile. Lastly, the provider can remove themself from the server if needed.
    2. Create services - The Provider shall provide customer parts to let customers access a menu that allows the user to pick different parts for a PC, all based on availability. The provider shall also be able to contact customers in case the customer has any questions or concerns.
    3. View customer statistics - The builder shall be able to view the statisitics of what PC parts customers prefer.
    4. Reply to reviews - The builder shall be able to respond to a customer's review if a customer leaves either a positive or negative review.

## Status
The provider (builder) side is complete: parts inventory (add, edit, delete), per-part customer statistics, and replies to customer reviews. The customer-facing flow was not finished before the course ended.

## Tech Stack
Java 21, Spring Boot 3.5, Spring Data JPA/Hibernate, PostgreSQL, FreeMarker, Maven

## Running Locally
You need a PostgreSQL database (a free Neon project works; tables are created on first run). Set `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` (see `application.properties.example`), then:
cd backend-api
./mvnw spring-boot:run
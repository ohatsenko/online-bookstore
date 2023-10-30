<div align="center"><h1>Welcome to the Bookworm's Haven</h1></div>

#### Dive into the world of books with our online bookstore.

Welcome to the Bookworm's Haven, a Java Spring Boot application that is designed to make your project development
journey smoother and more efficient. This platform combines a rich set of features and modern technologies to create a
secure and user-friendly e-commerce experience. Below, you'll discover the key elements and functionalities of the
application.

- [Introduction](#introduction)
- [Technologies & Tools](#technologies)
- [Functionalities](#functionalities)
- [Getting Started](#setup)
- [Video Guide](#video-instruction)
- [Testing Tools](#usage-tools)
- [Contribute](#contribute)

<div id="introduction">
    <br>
    <p>
        Welcome to the Bookworm's Haven, a delightful application created for book enthusiasts. It provides you with the ability to select the perfect book, search through our extensive library, and compile your order effortlessly. This project encompasses various domain models including Users, Roles, Books, Categories, Shopping Carts, Cart Items, Orders, and Order Items. Users can register, log in, explore books, add them to their shopping cart, and complete orders. Administrators have the authority to manage books, bookshelf sections, and oversee and modify order statuses.
        This README will guide you through using the application and setting it up on your local machine.
    </p>
</div>
<hr>

<div id="technologies">
    <h3> Technologies & Tools </h3>
    <p>
        Our web application is built on Spring Boot and utilizes a range of modern technologies and tools to ensure robustness and scalability, including:
       <br> - Spring Boot Framework for the backend 
       <br> - Spring Security for authentication and security
       <br> - Spring Data JPA for database interaction
       <br> - Swagger for API documentation
       <br> - Maven for library management and project building
       <br> - IntelliJ IDEA as the recommended development environment
       <br> - Docker for running in an isolated environment on different platforms
       <br> - Liquibase for managing database schema changes and revisions 
       <br> - Spring Testing for quality assurance
</p>
</div>
<hr>

<div id="functionalities">
    <h3> Functionalities </h3>
    <p>
        This project features two user roles, ROLE_USER (default) and ROLE_ADMIN, each with their respective capabilities:
        <br> Book Buyers (Users) can:
        <br> - Sign up and log in to access the store.
        <br> - Explore a diverse collection of books.
        <br> - Easily search for specific books.
        <br> - Add books to their shopping cart.
        <br> - Review and manage the items in their shopping cart.
        <br> - Place orders and view their order history.
        <br> Managers (Admins) can:
        <br> - Effectively manage the store's book inventory.
        <br> - Create, modify, and retrieve information about all the books in the store.
        <br> - Track and modify order statuses to enhance order management processes.
</p>
<table>
    <tr>
        <th>Action</th>
        <th>Endpoint</th>
        <th>Access</th>
    </tr>
    <tr class="user">
        <td>Register a new user</td>
        <td>POST:/api/auth/register</td>
        <th>all</th>
    </tr>
    <tr class="user">
        <td>Log in</td>
        <td>POST:/api/auth/login</td>
        <th>all</th>
    </tr>
    <tr class="user">
        <td>Get all books</td>
        <td>GET:/api/books</td>
        <th>user</th>
    </tr>
    <tr class="user">
        <td>Get a certain book by id</td>
        <td>GET:/api/books/{id}</td>
        <th>user</th>
    </tr>
    <tr class="admin">
        <td>Add a new book</td>
        <td>POST:/api/books</td>
        <th>admin</th>
    </tr>
    <tr class="admin">
        <td>Delete an existing book by id</td>
        <td>DELETE:/api/books/{id}</td>
        <th>admin</th>
    </tr>
    <tr class="admin">
        <td>Update an existing book by id</td>
        <td>PUT:/api/books/{id}</td>
        <th>admin</th>
    </tr>
    <tr class="user">
        <td>Get books of the category</td>
        <td>GET:/api/categories/{id}/book</td>
        <th>user</th>
    </tr>
    <tr class="user">
        <td>Get all categories</td>
        <td>GET:/api/categories</td>
        <th>user</th>
    </tr>
    <tr class="user">
        <td>Get a certain category by id</td>
        <td>GET:/api/categories/{id}</td>
        <th>user</th>
    </tr>
    <tr class="admin">
        <td>Add a new book category</td>
        <td>POST:/api/categories</td>
        <th>admin</th>
    </tr>
    <tr class="admin">
        <td>Change category by id</td>
        <td>PUT:/api/categories/{id}</td>
        <th>admin</th>
    </tr>
    <tr class="admin">
        <td>Delete an existing category by id</td>
        <td>DELETE:/api/categories/{id}</td>
        <th>admin</th>
    </tr>
    <tr class="user">
        <td>Add a book to a shopping cart</td>
        <td>POST:/api/сart</td>
        <th>user</th>
    </tr>
    <tr class="user">
        <td>Get a user's shopping cart</td>
        <td>GET:/api/сart</td>
        <th>user</th>
    </tr>
        <tr class="user">
        <td>Update a cart item by its id</td>
        <td>PUT:/api/cart/cart-item/{id}</td>
        <th>user</th>
    </tr>
    <tr class="user">
        <td>Delete a cart item by its id</td>
        <td>DELETE:/api/cart/cart-items/{id}</td>
        <th>user</th>
    </tr>
        <tr class="user">
        <td>Get all orders</td>
        <td>GET:/api/orders</td>
        <th>user</th>
    </tr>
        <tr class="user">
        <td>Get  order items by order id</td>
        <td>GET:/api/orders/{id}/items</td>
        <th>user</th>
    </tr>
    <tr class="user">
        <td>Get a certain order item by an order id and its id</td>
        <td>GET:/api/orders/{orderId}/items/{id}</td>
        <th>user</th>
    </tr>
    <tr class="admin">
        <td>Update a status of an order by an order id</td>
        <td>PATCH:/api/orders/{id}</td>
        <th>admin</th>
    </tr>
</table>

</div>
<hr>

<div id="setup">
    <h3> Getting Started </h3>
    <p>
        Getting started with this project is a breeze. Follow these steps to set up the project on your local machine:
        <br> Prerequisites:<br>
        <br> Before you begin, make sure you meet the following requirements:
        <br> 0. Install Postman (for making requests to endpoints or use a web browser).
        <br> 1. Install JDK.
        <br> 2. Have MySQL, PostgreSQL, or another preferred relational database installed.
        <br> 3. Ensure you have Maven for building the project.
        <br> 4. Docker (for running the project in a virtual container).
        <br>Running on your local machine:<br>
        <br> 1. Clone this repository: `git clone https://github.com/ohatsenko/online-bookstore`.
        <br> 2. Configure the application.properties file to connect to the database before running the app.
        <br> 3. Build the project: `mvn clean install`.
        <br> 4. Run the app: `mvn spring-boot:run`.
        <br>Running with Docker on your machine:<br>
        <br> 0. Install Docker Desktop (Optional): <a href="https://www.docker.com/products/docker-desktop/" target="_blank" class="social-icon">
        https://www.docker.com/products/docker-desktop/</a>
        <br> 1. Run the command to build the Docker image: `docker-compose build`.
        <br> 2. Start the Docker container: `docker-compose up`.
        <br> 3. To stop the containers when needed: `docker-compose down`.
        <br> While the application is running, you can access the Swagger UI for API documentation and testing (Optional):
        <br> 1. Swagger UI URL: <a href="http://localhost:8080/swagger-ui/index.html" target="_blank" class="social-icon">
        http://localhost:8080/swagger-ui/index.html</a>
</p>
</div>
<hr>

<div id="video-instruction">
    <h3> Video Guide </h3>
    <p>
        For a quick visual introduction to our application, check out our short video guide:
        <br> - <a href="https://cutt.ly/RwEHebGI" target="_blank" class="social-icon">
Video Guide</a>.
    </p>
</div>
<hr>

<div id="usage-tools">
    <h3> Testing Tools </h3>
    <p>
        This project provides an intuitive interface and detailed API documentation through Swagger, which can be accessed at <a href="http://localhost:8088/swagger-ui/index.html" target="_blank" class="social-icon">
        http://localhost:8080/swagger-ui/index.html</a>. 
        Additionally, a collection of Postman requests is available in the root directory of this project.
        `BookStore.postman_collection.json`

By default, a user with the role of admin is already saved in the database,
so you can register as a moderator or log in as an admin using these credentials:

`"email": "admin@mail.com"`

`"password": "adminadmin"`
</p>
</div>
<hr>



<div id="contribute">
    <h3> Contribute </h3>
    <p>
        We welcome contributions! If you'd like to contribute or have any questions, please reach out to us on LinkedIn
    </p>
<a href="https://www.linkedin.com/in/oleksandr-hatsenko/" target="_blank" class="social-icon">
LinkedIn profile</a>

</div>
<hr>

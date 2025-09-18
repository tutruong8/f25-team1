# Software Requirements Specification
## For DreamBuild

Version 0.1  
Prepared by Travis Truong and Bryan Palma
CSC340-02  
9/17/2025 

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)

* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)


## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|   Bryan   |   9/16      |      Initial SRS	        |     1.0      |
|  Travis   |     9/16    |         Initial SRS       |    1.0       |
|      |         |                     |           |

## 1. Introduction

### 1.1 Document Purpose
The purpose of this Software Requirements Document (SRD) is to describe the client-view and developer-view requirements for the DreamBuild application.
Client-oriented requirements describe the system from the client’s perspective . These requirements include a description of the different types of users served by the system (Customer and Builder).
Developer-oriented requirements describe the system from a software developer’s perspective. These requirements include a detailed description of functional, data, performance, and other important requirements.

### 1.2 Product Scope
The purpose of the DreamBuild system is to create a way for a customer to easily build their own laptop or desktop with any parts of and specs of their choosing, as well as for the builder to have a convient way to reach their customer base, manage their stock and follow the criteria that the customer wished for. The system is a web-based application to simplify its subscrption and product management functions. We will have an application to become a builder for this site and get the product to the consumer at a timely manner. Above all, we hope to provide a comfortable user experience along with the best offerings available.

### 1.3 Definitions, Acronyms and Abbreviations                                                                                                                             
| Reference   | Definition |
|-------------|------------|
| **Java**        | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build the backend service for LocalHarvest Hub |
| **PostgreSQL**  | Open-source relational database management system. |
| **SpringBoot**  | An open-source Java-based framework used to create a microservice. This will be used to create and run our application. |
| **Spring MVC**  | Model-View-Controller. This is the architectural pattern that will be used to implement our system. |
| **Spring Web**  | Will be used to build our web application by using Spring MVC. This is one of the dependencies of our system. |
| **API**         | Application Programming Interface. This will be used to interface the backend and the frontend of our application. |
| **HTML**        | Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content. |
| **CSS**         | Cascading Style Sheets. Will be used to add styles and appearance to the web app. |
| **JavaScript**  | An object-oriented computer programming language commonly used to create interactive effects within web browsers. Will be used in conjunction with HTML and CSS to make the web app. |
| **VS Code**     | An integrated development environment (IDE) for Java. This is where our system will be created. |
                                             |

### 1.4 References
https://spring.io/guides 

### 1.5 Document Overview
Section 1 is a general introduction to the document, intended for any readers. Section 2 is focused on the product and its features. This section is for customers. Section 3 specifies the requirements and constraints for the product and development process. This section is intended especially for the development team.

## 3. Requirements

### 3.1 Functional Requirements 

* The customer shall be able to enter their log in or sign up and create a new log in if one does not exist.
* The customer shall be able to browse the various selection of computer parts and specs.
  - The program shall have a search and filter option for compatibility, brand, pricing, etc.
* The customer shall access a pc builder terminal in which they can build their desired pc or laptop.
* The customer will be able to modify their account at any given time.
* The customer will be able to rate and review the product and service.
* Be verifiable (e.g., the requirement realization can be proven to the customer's satisfaction)
* Conform to agreed upon syntax, keywords, and terms.



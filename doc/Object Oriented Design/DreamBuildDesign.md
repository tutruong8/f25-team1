# DreamBuild - Software Design 

Version 1  
Prepared by Travis Truong and Bryan Palma\
DreamBuild\
Oct 8, 2025

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Use Cases](#2-use-cases)
  * 2.1 [Use Case Model](#21-use-case-model)
  * 2.2 [Use Case Descriptions](#22-use-case-descriptions)
    * 2.2.1 [Actor: Builder](#221-actor-farmer)
    * 2.2.2 [Actor: Customer](#222-actor-customer) 
* 3 [UML Class Diagram](#3-uml-class-diagram)
* 4 [Database Schema](#4-database-schema)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|  Al  |10/8     | Initial Design      |    1      |
|      |         |                     |           |
|      |         |                     |           |

## 1. Product Overview
DreamBuild is a web-based app that allows customers to access prebuilt computers or choose parts to build their own, all provided by builders. Customers can also leave revies and builders can also reply back. Builders can also look at statistics of what PC builds or parts are popular with customers.

## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/tutruong8/f25-team1/blob/main/doc/Object%20Oriented%20Design/UseCaseDiagram.png)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Builder
##### 2.2.1.1 Sign Up
A builder can sign up to create their profile with their name, email, password, and phone number. Emails must be unique.
##### 2.2.1.2 Log In
A builder shall be able to sign in using their registered email and password. After logging in, the farmer shall be directed their dashboard where they see an overview of their provided Prebuilt computers, PC parts, and stats.
##### 2.2.1.3 Update Profile
A builder shall be to modify their profile by going to their profile page. They can change their email, password, and address.
##### 2.2.1.4 Create Prebuilts
The builder shall be able to create a listing for a Prebuilt Computer. They would provide the CPU, GPU, RAM, Storage(s), Cooling Components such as PC Fans and CPU Cooler, description, and price. This prebuilt will be created to be associated with only this builder.
##### 2.2.1.5 List Computer Parts for DIY
The builder shall be able to create a listing for computer parts for customers that would like to build their own computer instead or want the builder to build it but want full control on what's in it.. They would provide component listings for CPU, GPU, RAM, Storage(s), and Cooling Components such as PC Fans and CPU Cooler. These parts would have a name, description, and price. Aditionally, builders should let the user know if there is any compatibility issues with chosen parts.
##### 2.2.1.6 View Customer Stats and Reviews
A builder will be able to view the amount of views a prebuilt computer or a certain pc part has or one that is most bought. Additionally, the builder shall be able to view and reply to reviews.

#### 2.2.2 Actor: Customer
##### 2.2.2.1 Sign Up
A customer can sign up to create their profile with their name, email, password, and address. Emails must be unique.
##### 2.2.2.2 Log In
A customer shall be able to sign in using their registred email and password. After logging in, the customer shall be directed to the home menu where they can see and browse the latest and greatest products available or on sale. Additionally the customer shall be able to select whether they want to build a pc from scratch or browse pre-built models.
##### 2.2.2.3 Browse PC products and parts
A customer shall be able to view available PC parts or pre-built PCs . They can do this from the home page or using a search function. They can also filter parts by name, descriptions, or brands. They will also be able to select one of the parts and view more details as well as see what other parts are compatible with the specified part.
##### 2.2.1.4 Subscribe to Newsletters
Upon logging in a prompt to will appear allowing the user to opt in or out of monthly newsletters, a customer shall be able to subscribe for the newsletter using the opt-in or opt-out buttons. This will then appear in their email and dashboard, and they will be able to ammend the subscription.
##### 2.2.1.5 Review Service
A customer may write a review for the PC/part that they received. They will be able to rate the service 1-5.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/csc340-uncg/f25-team1/blob/main/doc/Object%20Oriented%20Design/UML$20class.png)
## 4. Database Schema
![Database Schema](https://github.com/tutruong8/f25-team1/blob/main/doc/Object%20Oriented%20Design/DatabaseSchema.png)

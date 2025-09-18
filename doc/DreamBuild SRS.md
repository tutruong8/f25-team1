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
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|      |         |                     |           |
|      |         |                     |           |
|      |         |                     |           |

## 1. Introduction

### 1.1 Document Purpose

### 1.2 Product Scope

### 1.3 Definitions, Acronyms and Abbreviations                                                                                                                                                                          |

### 1.4 References

### 1.5 Document Overview

## 2. Product Overview
DreamBuild is a web-based app that allows customers to access prebuilt computers or choose parts to build their own, all provided by builders. Customers can also leave revies and builders can also reply back. Builders can also look at statistics of what PC builds or parts are popular with customers.

### 2.1 Product Functions
DreamBuild is a web-based app that provides a service for customers that allows customers to get the exact desktop or laptop they want. Customers are able to create and login into their account along with modifying their laptop to buy prebuilt computers from builders or laptops or let them choose each part for their desktop or laptop and have a builder either build it for them or let the customer build it if they choose. Customers should also be able to provide reviews. Builders are allowed to provide a DIY service or prebuilt to users, check user reviews, and reply to reviews.

### 2.2 Product Constraints
From when this SRS is made, this program should able to be run on a computer with Java JDK 21. Given that the assignment is due at the beginning of December, there also could be feature cuts due to time constraints.
  
### 2.3 User Characteristics
Users should know how to use a web browser before using this application. Users with basic computer hardware knowledge should be a expert within using this software after a few times.

### 2.4 Assumptions and Dependencies
Java will be used and the app will depend on Spring and Spring Boot. The app will be developed in VS Code or VS Codium. Aditionally, there should also be a API that lets user access computer parts and their specifications.

## 3. Requirements

### 3.1 Functional Requirements 
- The builder shall be able to be registered to the app via a registration form. Additionally, a builder can modify this profile. Lastly, the builder can remove themself from the from the server if needed.
- The builder shall let customers either pick from a prebuilt laptop or PC or let users access a menu that allows the user to pick different parts for a laptop or PC, all based on availability. 
- The builder shall also be able to contact customers in case the customer has any questions or concerns. Additionally, the builder should be able to manage the inventory of computer parts in stock and have a newsletter that users can subscribe to for new items, updated stock and sales. Lastly, the builder should also be able to give a option if for the chosen parts that the customer picked for if they want to build the PC themselves or if the builder builds it for a extra service charge.
- The builder shall be able to view the statisitcs of what customers prefer, such as seeing which prebuilt machine most customers are buying. Additionally, the builder shall also be able to see the statistics of what parts are more commonly selected when users want to build the PC or machine themselves.
- The builder shall be able to respond to a customer's review if a customer leaves either a positive or negative review.

#### 3.1.1 User interfaces
The web app's interfave shall be webpages using HTML, CSS, and JavaScript.

#### 3.1.2 Hardware interfaces
Devices that have access to any web browser. This can range from either a Chromium-based web browser (Chrome, Edge, Brave, Vivaldi), Gecko Engine based web browser (Firefox, Librewolf, Floorp, Zen), Apple's Safari, or any mobile browser.

#### 3.1.3 Software interfaces
- Java jdk 21
- PostgreSQL 17
- SpringBoot 3.4.5

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
- NFR0: The DreamBuild system will consume less than 100 MB of memory
- NFR1: The novice user will be able to add and manage produce a DIY or Prebuilt computer in less than 5 minutes.
- NFR2: The expert user will be able to add and manage produce a DIY or Prebuilt computer in less than 1 minute.


#### 3.2.2 Security
- NFR3: The system is available only through login and password.

#### 3.2.3 Reliability


#### 3.2.4 Availability
- NFR4: DreamBuild will be up 24/7. The only time the website will be down is around midnight EST when the app needs a update.

#### 3.2.5 Compliance
- NFR5: DreamBuild shall not go beyond what CSC340 teaches

#### 3.2.6 Cost
- NFR6: Zero dollars is expected to be spent.

#### 3.2.7 Deadline
- NFR7: The final product must be delivered by December 2025.

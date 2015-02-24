#Project Aiden [![Build Status](https://travis-ci.org/windweller/Spray-Blog.svg?branch=Spray-Blog)](https://travis-ci.org/windweller/Spray-Blog)

Project Aiden is to build a NLP interface that contains open-source underline modules, specifically designed
for online tasks.

The first phase of Project Aiden is the birth of Sally, the first personal AI assitant.

Sally is not a library, but a collection of services built upon natural language processing. Since it is the beta version, we call it Sally. Nowadays, people see natural language processing as an "add-on", but it should not be. Natural language processing should be used as a foundation and build everything else on top of it. However, due to time and technology constraint, Sally can be treated as a blogging platform (but is nothing like Wordpress or NodeJS powered blogging platforms).

Sally has a super modular design. All modules (except core modules) can be changed based on user's preference. Currently Sally is built upon Spray (the HTTP server) and Scala. The interface of Sally is composed of HTML with JavaScript (jQuery) providing asynchronous service.

We welcome anyone who is interested. You can find contact email at the bottom of this file. 

##Module
There are a list of modules that are being developed, or planned on building in the near future.
* Blogging Module - **planned** | **in development**
* Conversation Module - **planned** | **in development**
* Knowledge Search Module - **planned**
  - js supported chart data display
  - does Sally know this person?
* Geolocation Module - **planned**
* Social Platform Integration Module - **planned**
* Information Access Module - **planned**
* Personality Module - **planned**

##Architectual Design
Sally is designed to be reactive, self-healing, and ability to reverse actions. It connects with three databases to mock the functionality of human memory. It uses PostgreSQL to mock the semantic memory, which tends to be more structural and fact-based. It uses MongoDB to mimic episodic memory, which tends to be unstable, and retrieved by associations (with many errors). At last, in order to speed up the program, and make the program itself remain as stateless as possible, Sally employs Reddit to persist its in-memory data.

Sally builds upon Spray and Akka. Spray is perfect for routing and REST API design (which has been almost abandoned since Sally might use WebScoket to handle most of the front-back interactions).

##Notice
The view folder is temporarily removed and may be created as a different github project. View, just like the rest of modules can be seperated from the main structure easily. Unlike templates created for Ghost.js or Wordpress, view for Sally's blogging service only needs to subscribe our specific websocket channels. In the far far far future, we might provide our own blogging js library that fully wrap around our service. Essentially you should be able to render any content on your page with ease.

##Dependency
Right now there are libraries and frameworks that Sally depends upon:
* [CRF Tagger](https://github.com/tomtung/nlp-class/tree/master/hw4): developed by @tomgtung using Breeze. It will be modified to better suit the functionality of Sally in the future.
* [ClearNLP](http://www.clearnlp.com/): developed by my mentor Dr. Jinho Choi.
* Other Machine Learning libraries

Contact: anie@emory.edu

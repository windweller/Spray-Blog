#Billy [![Build Status](https://travis-ci.org/windweller/Spray-Blog.svg?branch=Spray-Blog)](https://travis-ci.org/windweller/Spray-Blog)

Billy is not a library, but a collection of services built upon natural language processing. Since it is the beta version, we call it Billy. Nowadays, people see natural language processing as an "add-on", but it should not be. Natural language processing should be used as a foundation and build everything else on top of it. However, due to time and technology constraint, Billy can be treated as a blogging platform (but is nothing like Wordpress or NodeJS powered blogging platforms).

Billy has a super modular design. All modules (except core modules) can be changed based on user's preference. Currently Billy is built upon Spray (the HTTP server) and Scala. The interface of Billy is composed of HTML with JavaScript (jQuery) providing asynchronous service.

We welcome anyone who is interested. You can find contact email at the bottom of this file. 

##Module
There are a list of modules that are being developed, or planned on building in the near future.
* Blogging Module - **active** | **being developed** 
* Conversation Module - **planned**
* Knowledge Search Module - **planned**
  - js supported chart data display
* Geolocation Module - **planned**
* File Management Module - **planned**
* Social Platform Management Module - **planned**
* Security Module - **planned**
* Personality Module - **planned**

##Notice
The view folder is temporarily removed and may be created as a different github project. View, just like the rest of modules can be seperated from the main structure easily. Unlike templates created for Ghost.js or Wordpress, view for Billy's blogging service only needs to subscribe our specific websocket channels. In the far far far future, we might provide our own blogging js library that fully wrap around our service. Essentially you should be able to render any content on your page with ease.

##Dependency
Right now there are libraries and frameworks that Billy depends upon:
* [Jacana](https://code.google.com/p/jacana/): from Google code, handles part of Billy's Knowledge Search functionality, connecting to [FreeBase](freebase.com).
* [CRF Tagger](https://github.com/tomtung/nlp-class/tree/master/hw4): developed by @tomgtung using Breeze. It will be modified to better suit the functionality of Billy in the future.

Contact: anie@emory.edu

#Billy [![Build Status](https://travis-ci.org/windweller/Spray-Blog.svg?branch=Spray-Blog)](https://travis-ci.org/windweller/Spray-Blog)

First, Billy is not a library, but a service that is tightly integrated with other services such as blogging, file management, knowledge searching, Social Media managing. It has a super modular design. All modules (except core modules) can be changed based on user's preference. Currently Billy is built upon Spray (the HTTP server) and Scala. The interface of Billy is composed of HTML with JavaScript (jQuery) providing asynchronous service.

##Module
There are a list of modules that are being developed, or planned on building in the near future.
* Blogging Module - **active** | **being developed** 
* Conversation Module - **planned**
* Knowledge Search Module - **planned**
* File Management Module - **planned**
* Social Platform Management Module - **planned**
* Security Module - **planned**
* Personality Module - **planned**

##Dependency
Right now there are libraries and frameworks that Billy depends upon:
* [Jacana](https://code.google.com/p/jacana/): from Google code, handles part of Billy's Knowledge Search functionality, connecting to [FreeBase](freebase.com).

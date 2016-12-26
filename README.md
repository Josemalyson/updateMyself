# UpdateMyself
Is an project built to learn about the Spring Cloud Netflix.

* Description of project

  The fluxe main is when the user does login in application project Web and have access at funcionalitys of an information panel of music, movies and news update in real time. The architecture of project is base in Spring Cloud Netflix. 

#MusicServices

* Description of project

  The music project have a responsibility of find sites and information about a music search by user. Rendered the information to the client via consuming of Rest Server.

* URL

  http://localhost:8081/v1/musics

#MoviesServices


* Description of project

  The movies project have a responsibility of find sites and information about a movie search by user. Rendered the information to the client via consuming of Rest Server.

* URL
  
  http://localhost:8082/v1/movies

#NewsServices

* Description of project

  The news project have a responsibility of find sites and information about a news search by user. Rendered the information to the client via consuming of Rest Server.

* URL
    
  http://localhost:8083/v1/news
 
#Zuul

* Description of project

  The Zuul project is it gateway, responsible by serve as one router and filter to the requests of project Web.
  
* URL

  http://localhost:8080/

#Web

* Description of project

  Project consuming of services musicServices, moviesServices, newsServices using a route through of Zuul project.
  
* URL
  

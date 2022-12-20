package restAssured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestIntegracionServicios {
    
    //Direccion URL JSON Place Holder
    public final static String URL= "https://jsonplaceholder.typicode.com/posts";

    // post elegido para la busqueda, actualizacion y eliminacion
    public final static int POST_SELECCIONADO = 1;

    /**
     * Como cliente yo obtengo todos los posts
     */
    @Test
    public  void findAllTest(){
        given()
                .log().all()
        .when()
                .get(URL)
        .then()
                .log().all();
    }


    /**
     * Dado un post que yo elegí procedo a ver los comentarios de ese post
     */
    @Test
    public  void findByIdCommentsTest(){
        given()
                .log().all()
        .when()
                .get(URL.concat("/"+POST_SELECCIONADO+"/comments"))
        .then()
                .log().all();
    }

    /**
     * 	Actualizo ese post
     */
    @Test
    public  void updateByIdTest(){
        given()
                .body("{\n" +
                        "  \"title\":\"title test update\",\n" +
                        "  \"body\":boby test update\",\n" +
                        "  \"userId\":1\n" +
                        "}\n")
                .log().all()
        .when()
                .put(URL.concat("/"+POST_SELECCIONADO))
        .then()
                .log().all();
    }

    /**
     * Elimino el post
     */
    @Test
    public  void deleteByIdTest(){
        given()
                .log().all()
        .when()
                .delete(URL.concat("/"+POST_SELECCIONADO))
        .then()
                .log().all();
    }

}

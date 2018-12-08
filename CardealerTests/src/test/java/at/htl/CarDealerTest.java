package at.htl;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarDealerTest {
    private Client client;
    private WebTarget target;

    private final JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/cardealerManagement");
    }
    @Test
    public void t010_crud_CarExemplarEndpoint(){
        //Create
        this.target = client.target("http://localhost:8080/cardealerManagement/rs/carExemplars/insertCarExemplar");
        JsonObject carExemplar = jsonBuilder
                .add("mileage", 25)
                .add("horsepower", 90)
                .add("color", "Grau")
                .add("carType", Json.createObjectBuilder().add("brand", "Seat").add("model", "Leon"))
                .build();

        Response response =this.target
                .request()
                .post(Entity.json(carExemplar));

        JsonObject entity = response.readEntity(JsonObject.class);
        int id = entity.getInt("id");
        System.out.println(id);
        assertThat(response.getStatus(), is(200));
        assertThat(entity.getInt("mileage"), is(25));

        //Get
        this.target = client.target("http://localhost:8080/cardealerManagement/rs/carExemplars/getCarExemplar/"+id);
        carExemplar = this.target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertThat(carExemplar.getInt("mileage"), is(25));
        assertThat(carExemplar.getInt("horsepower"), is(90));
        assertThat(carExemplar.getString("color"), is("Grau"));

        //Update
        this.target = client.target("http://localhost:8080/cardealerManagement/rs/carExemplars/updateCarExemplar/" + id);
        carExemplar = jsonBuilder
                .add("mileage", 30)
                .add("horsepower", 120)
                .add("color", "Grau")
                .add("carType", Json.createObjectBuilder().add("brand", "Seat").add("model", "Leon"))
                .build();

        response = target.request()
                .put(Entity.json(carExemplar));
        entity = response.readEntity(JsonObject.class);
        assertThat(entity.getInt("mileage"), is(30));
        assertThat(entity.getInt("horsepower"), is(120));

        //Delete
        this.target = client.target("http://localhost:8080/cardealerManagement/rs/carExemplars/deleteCarExemplar/" + id);
        this.target.request().delete();
    }

    @Test
    public void t020_crud_CustomerEndpoint(){

        //Create
        this.target = client.target("http://localhost:8080/cardealerManagement/rs/customers/insertCustomer");
        JsonObject customer = jsonBuilder
                .add("firstName", "Max")
                .add("lastName", "Mustermann")
                .add("phoneNumber", "+4369916589003")
                .add("city", "Linz")
                .add("street", "Hafenstraße")
                .add("zipCode", 4020)
                .add("birthDate", "1998-05-06")
                .add("IBAN", "AL90208110080000001039531801")
                .build();

        Response response =this.target
                .request()
                .post(Entity.json(customer));

        JsonObject entity = response.readEntity(JsonObject.class);
        int id = entity.getInt("id");
        System.out.println(id);
        assertThat(response.getStatus(), is(200));
        assertThat(entity.getString("phoneNumber"), is("+4369916589003"));
        assertThat(entity.getString("birthDate"), is("1998-05-06"));

        //Get
        this.target = client.target("http://localhost:8080/cardealerManagement/rs/customers/getCustomer/"+id);
        customer = this.target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertThat(customer.getString("phoneNumber"), is("+4369916589003"));

        //Update
        this.target = client.target("http://localhost:8080/cardealerManagement/rs/customers/updateCustomer/" + id);
        customer = jsonBuilder
                .add("firstName", "Max")
                .add("lastName", "Mustermann")
                .add("phoneNumber", "+4369989546220")
                .add("city", "Linz")
                .add("street", "Hafenstraße")
                .add("zipCode", 4020)
                .add("birthDate", "1998-05-06")
                .add("IBAN", "AL90208110080000001039531801")
                .build();

        response = target.request()
                .put(Entity.json(customer));
        entity = response.readEntity(JsonObject.class);
        assertThat(entity.getString("phoneNumber"), is("+4369989546220"));

        //Delete
        this.target = client.target("http://localhost:8080/cardealerManagement/rs/customers/deleteCustomer/" + id);
        this.target.request().delete();
    }
}

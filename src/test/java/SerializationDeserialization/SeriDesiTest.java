package SerializationDeserialization;

import static org.testng.Assert.assertEquals;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SeriDesiTest {

	private static final ObjectMapper MAPPER=new ObjectMapper();
	public static void main(String[] args) throws JsonProcessingException {		
		//-----------Serialization-------------
		Booking b1=new Booking();
		Bookingdates bd1=new Bookingdates();
		b1.setFirstname("Harish");
		b1.setLastname("Pant");
		b1.setTotalprice(100);
		b1.setDepositpaid(true);
		
		bd1.setCheckin("2023-01-01");
		bd1.setCheckout("2023-01-05");
		b1.setBookingdates(bd1);
		b1.setAdditionalneeds("Lunch");
		
		System.out.println(b1.toString());
		
		String json1=MAPPER.writeValueAsString(b1);
		String posturl="https://restful-booker.herokuapp.com/booking";
		Response res=RestAssured.given().contentType("application/json")
					.log().all(true).body(json1).post(posturl).andReturn();
		System.out.println(res.body().asString());
		res.prettyPrint();
		assertEquals(res.getStatusCode(),200,"HTTP Message..");
		//------------Deserialization------------
		int postBookingid = JsonPath.from(res.body().asString()).get("bookingid");
		System.out.println("postBookingid - "+postBookingid);
		String geturl1="https://restful-booker.herokuapp.com/booking/"+postBookingid;
		Booking getRes=RestAssured.given().get(geturl1).as(Booking.class);
		System.out.println("Get Response :- "+getRes.toString());
		
		//to print all records
//		String geturl2="https://restful-booker.herokuapp.com/booking";
//		
//		java.lang.reflect.Type type=new TypeReference<List<Booking>>() {}.getType();
//		
//		List<Booking> BookingList=RestAssured.given().get(geturl2).as(type);
//		System.out.println("All List"+BookingList);
		
		
	}
}

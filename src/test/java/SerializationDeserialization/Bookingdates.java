package SerializationDeserialization;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"checkin",
"checkout"
})

public class Bookingdates {

@JsonProperty("checkin")
private String checkin;
@JsonProperty("checkout")
private String checkout;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("checkin")
public String getCheckin() {
return checkin;
}

@JsonProperty("checkin")
public void setCheckin(String checkin) {
this.checkin = checkin;
}

@JsonProperty("checkout")
public String getCheckout() {
return checkout;
}

@JsonProperty("checkout")
public void setCheckout(String checkout) {
this.checkout = checkout;
}


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(Bookingdates.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("checkin");
sb.append('=');
sb.append(((this.checkin == null)?"<null>":this.checkin));
sb.append(',');
sb.append("checkout");
sb.append('=');
sb.append(((this.checkout == null)?"<null>":this.checkout));
sb.append(',');
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}
package kodlama.io.ecommerce.business.dto.response.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

}

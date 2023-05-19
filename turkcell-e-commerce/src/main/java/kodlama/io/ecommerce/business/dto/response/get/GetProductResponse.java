package kodlama.io.ecommerce.business.dto.response.get;

import kodlama.io.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponse {
    private int id;
    private int categoryId;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;

    private Status status;

}

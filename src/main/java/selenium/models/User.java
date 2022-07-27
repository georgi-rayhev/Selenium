package selenium.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    public String firstName , lastName, email, password;
}

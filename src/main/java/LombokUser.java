import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(toBuilder = true)
public class LombokUser {

    @NonNull
    private Long id;
    @NonNull
    private String username;
}

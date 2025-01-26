package testAutomationApi.pojo.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // JSON'da tanımlanmayan alanları yoksayar
public class CreatePetResponse {

    @JsonProperty("id") // API'deki "id" alanı
    private int id;

    @JsonProperty("name") // API'deki "name" alanı
    private String name;

    @JsonProperty("status") // API'deki "status" alanı
    private String status;

    // Varsayılan (no-args) constructor - JSON dönüşümü için gerekli
    public CreatePetResponse() {
    }

    // Getter ve Setter'lar
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Loglama ve hata ayıklama için faydalı toString metodu
    @Override
    public String toString() {
        return "CreatePetResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

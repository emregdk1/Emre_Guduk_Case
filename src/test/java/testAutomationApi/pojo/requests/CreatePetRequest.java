package testAutomationApi.pojo.requests;

public class CreatePetRequest {

    private int id;
    private String name;
    private String status;

    // No-args constructor (JSON dönüştürme için gerekli olabilir)
    public CreatePetRequest() {
    }

    // Parametreli constructor
    public CreatePetRequest(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    // Loglama veya hata ayıklama sırasında faydalı olabilir
    @Override
    public String toString() {
        return "CreatePetRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

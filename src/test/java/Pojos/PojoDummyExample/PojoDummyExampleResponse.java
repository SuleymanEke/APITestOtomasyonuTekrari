package Pojos.PojoDummyExample;

public class PojoDummyExampleResponse {

    //1 - tum variable'lari private olarak olustur
    private String status;
    private PojoDummyExampleData data;
    private String message;

    //2 - tum variable'lar icin getter ve setter metodlari olusturalim
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PojoDummyExampleData getData() {
        return data;
    }

    public void setData(PojoDummyExampleData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //3 - tum parametreleri kullanarak bor constructor olusturalim
    public PojoDummyExampleResponse(String status, PojoDummyExampleData data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    //4 - default constructor yerine manuel olarak parametresiz bir constructor olusturalim
    public PojoDummyExampleResponse() {
    }

    //5 - toString metodu olusturalim
    @Override
    public String toString() {
        return "PojoDummyExampleResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}

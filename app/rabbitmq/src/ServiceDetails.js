import axios from "axios";
class ServiceDetails {
  PostDetails(student) {
    return axios.post("http://localhost:8080/rabbitmq/json", student);
  }
}
export default new ServiceDetails();

import axios from 'axios'

const DRIVER_REST_API_URL = 'http://localhost:8080/api/drivers'

class DriverService {
    getDriver() {
        axios.get(DRIVER_REST_API_URL);
    }
}

export default new DriverService()

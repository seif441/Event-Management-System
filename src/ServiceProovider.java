
public class ServiceProovider extends PERSON {
    private static final Role DEFAULT_ROLE = Role.ServiceProovider;

    private Request[] requests;
    private Service[] services;
    private int requestCount;
    private int serviceCount;

    public ServiceProovider(String Name, String Email, String Phone, String Password) {
        super(Name, Email, Phone, Password, DEFAULT_ROLE);

        this.requests = new Request[100];
        this.services = new Service[50];
        this.requestCount = 0;
        this.serviceCount = 0;
        initializeServices();
    }

    private void initializeServices() {
        addService(new Service("Catering", 1500.0));
        addService(new Service("Audio-Visual Setup", 2000.0));
        addService(new Service("Photography", 1000.0));
        addService(new Service("Event Decoration", 2500.0));
    }

    private void addService(Service service) {
        if (serviceCount < services.length) {
            services[serviceCount++] = service;
        } else {
            System.out.println("Service array is full.");
        }
    }
    public void receiveRequest(int id, String description) {
        if (requestCount < requests.length) {
            requests[requestCount++] = new Request(id, description);
            System.out.println("Request received: " + description);
        } else {
            System.out.println("Request array is full.");
        }
    }

    public void priceRequest(int requestId, double price) {
        Request request = findRequestById(requestId);
        if (request != null) {
            request.setPrice(price);
            System.out.println("Request ID " + requestId + " priced at: $" + price);
        } else {
            System.out.println("Request with ID " + requestId + " not found.");
        }
    }

    public void setReadyDate(int requestId, String readyDate) {
        Request request = findRequestById(requestId);
        if (request != null) {
            request.setReadyDate(readyDate);
            System.out.println("Request ID " + requestId + " ready by: " + readyDate);
        } else {
            System.out.println("Request with ID " + requestId + " not found.");
        }
    }

    public void displayServices() {
        System.out.println("=== Available Services ===");
        for (int i = 0; i < serviceCount; i++) {
            System.out.println("- " + services[i].getName() + ": $" + services[i].getPrice());
        }
    }

    public double getServicePrice(String serviceName) {
        for (int i = 0; i < serviceCount; i++) {
            if (services[i].getName().equalsIgnoreCase(serviceName)) {
                return services[i].getPrice();
            }
        }
        System.out.println("Service not found: " + serviceName);
        return -1.0; // Indicates service not found
    }

    public double calculateBill(int requestId) {
        Request request = findRequestById(requestId);
        if (request != null) {
            return request.getPrice();
        }
        System.out.println("Request with ID " + requestId + " not found.");
        return 0.0;
    }

    private Request findRequestById(int requestId) {
        for (int i = 0; i < requestCount; i++) {
            if (requests[i].getId() == requestId) {
                return requests[i];
            }
        }
        return null;
    }
}
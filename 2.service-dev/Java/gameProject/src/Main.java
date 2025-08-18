import input.InputHandler;
import start.App;

public class Main {
    public static void main(String[] ignoredArgs) {
        App app = new App();
        try (InputHandler _ = new InputHandler()) {
            app.start();
        } catch (Exception e) {
            System.out.println("Error initializing input handler: " + e.getMessage());
        }

        // The application will run until the user chooses to exit.
    }
}

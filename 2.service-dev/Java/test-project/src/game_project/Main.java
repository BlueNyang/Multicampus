package game_project;

import game_project.input.InputHandler;
import game_project.start.App;

public class Main {
    public static void main(String[] ignoredArgs){
        App app = new App();
        try (InputHandler _ = new InputHandler()) {
            app.start();
        } catch (Exception e) {
            System.out.println("Error initializing input handler: " + e.getMessage());
        }

        // The application will run until the user chooses to exit.
    }
}

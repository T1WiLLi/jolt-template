package jolt.template;

import io.github.t1willi.core.JoltApplication;
import io.github.t1willi.openapi.annotations.OpenApi;

@OpenApi(title = "Jolt-Template OpenAPI", version = "1.0.0", description = "A template project for Jolt applications")
public class Main extends JoltApplication {
    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void init() {
        // Routes defined in controller classes
    }
}
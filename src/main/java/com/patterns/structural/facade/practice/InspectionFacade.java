package com.patterns.structural.facade.practice;

public class InspectionFacade {
    private final Stage stage;
    private final Handler handler;
    private final Camera camera;

    public InspectionFacade(Stage stage, Handler handler, Camera camera)
    {
        this.stage = stage;
        this.handler = handler;
        this.camera = camera;
    }

    public void initializeAllComponents()
    {
        stage.initialize();
        handler.initialize();
        camera.initialize();
    }

    public void doInspection(int port, int slot, int x, int y) throws InterruptedException {
        handler.getWaferFromCassetteToStage(port, slot);
        stage.move(x, y);
        camera.focusOnWafer();
    }
}

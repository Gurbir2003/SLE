import uk.ac.rhul.cs.csle.art.util.ARTException;
import uk.ac.rhul.cs.csle.art.value.*;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.scene.transform.Rotate;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;



public class ValueUserPlugin implements ValueUserPluginInterface {

            @Override
            public String name() {
                return "Esos Rules 3D objects";
            }

            @Override
            public Value user(Value... args) throws ARTException {
                String commandName = String.valueOf(args[0].value());
                switch (commandName) {
                    case "coneCreation":
                        if (args.length >= 4) {
                            coneCreation(args);
                        } else {
                            System.out.println("Not enough arguments for cone creation.");
                        }
                        break;
                    case "sphereCreation":
                        sphereCreation(args);
                        break;
                    case "cylinderCreation":
                        cylinderCreation(args);
                        break;
                    case "cubeCreation":
                        cubeCreation(args);
                        break;
                    case "cuboidCreation":
                        cuboidCreation(args);
                        break;
                    case "pyramidCreation":
                        pyramidCreation(args);
                        break;
                     case "torusCreation":
                        torusCreation(args);
                        break;
                    case "hexagonalPrismCreation":
                        if (args.length >= 3) {
                        hexagonalPrismCreation(args);
                        } else {
                        System.out.println("Not enough arguments for hexagonal prism creation.");
                        }
                        break;
                    default:
                        System.out.println("Command " + commandName + " is not supported.");
                }

                return new __string("Command has been executed: " + commandName);
            }

private void coneCreation(Value[] args) throws ARTException {
    double baseRadius = ((Number) args[1].value()).doubleValue();
    double height = ((Number) args[2].value()).doubleValue();

    Platform.runLater(() -> {
        Group root = new Group();
        Cylinder cone = new Cylinder(baseRadius, height, 75);
        cone.setScaleY(0.25);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.PURPLE);
        cone.setMaterial(material);

        setupScene(root, cone, "Cone(3D)");
    });
}

            
private void sphereCreation(Value[] args) throws ARTException {
    double radius = ((Number) args[1].value()).doubleValue();

    Platform.runLater(() -> {
        Group root = new Group();
        Sphere sphere = new Sphere(radius);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.GREEN);
        sphere.setMaterial(material);

        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        sphere.getTransforms().add(rotateY);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> rotateY.setAngle(rotateY.getAngle() + 5));
            }
        }).start();

        setupScene(root, sphere, "Dynamically displayed 3D Sphere");
    });
}


private void cylinderCreation(Value[] args) throws ARTException {
    double radius = ((Number) args[1].value()).doubleValue();
    double height = ((Number) args[2].value()).doubleValue();

    Platform.runLater(() -> {
        Group root = new Group();
        Cylinder cylinder = new Cylinder(radius, height);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.RED);
        cylinder.setMaterial(material);

        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        cylinder.getTransforms().add(rotateY);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> rotateY.setAngle(rotateY.getAngle() + 5));
            }
        }).start();

        setupScene(root, cylinder, "Dynamically displayed 3D Cylinder");
    });
}


            
private void cubeCreation(Value[] args) throws ARTException {
                double width = ((Number) args[1].value()).doubleValue();
                double height = ((Number) args[2].value()).doubleValue();
                double depth = ((Number) args[3].value()).doubleValue();

                Platform.runLater(() -> {
                    Group root = new Group();
                    Box cube = new Box(width, height, depth);
                    PhongMaterial material = new PhongMaterial();
                    material.setDiffuseColor(Color.DARKBLUE);
                    cube.setMaterial(material);
                    Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
                    cube.getTransforms().add(rotateY);

                    new Thread(() -> {
                        while (true) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Platform.runLater(() -> rotateY.setAngle(rotateY.getAngle() + 5));
                        }
                    }).start();

                    final int windowX = 1000;
                    final int windowY = 800;
                    root.getChildren().add(cube);

                    Scene scene = new Scene(root, windowX, windowY, true);
                    scene.setFill(Color.LIGHTGRAY);

                    PerspectiveCamera camera = new PerspectiveCamera(false);
                    camera.setTranslateX(-0.30 * windowX);
                    camera.setTranslateY(-0.8 * windowY);
                    scene.setCamera(camera);

                    Stage stage = new Stage();
                    stage.setTitle("Dynamically displayed 3D cube");
                    stage.setScene(scene);
                    stage.show();
                });
            }
            
private void cuboidCreation(Value[] args) throws ARTException {
    double width = ((Number) args[1].value()).doubleValue();
    double height = ((Number) args[2].value()).doubleValue();
    double depth = ((Number) args[3].value()).doubleValue();

    Platform.runLater(() -> {
        Group root = new Group();
        Box cuboid = new Box(width, height, depth);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BROWN);
        cuboid.setMaterial(material);

        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        cuboid.getTransforms().add(rotateY);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> rotateY.setAngle(rotateY.getAngle() + 5));
            }
        }).start();

        setupScene(root, cuboid, "Dynamically displayed 3D Cuboid");
    });
}

private void pyramidCreation(Value[] args) throws ARTException {
    double baseWidth = ((Number) args[1].value()).doubleValue();
    double height = ((Number) args[2].value()).doubleValue();

    Platform.runLater(() -> {
        Group root = new Group();

        float hw = (float) baseWidth / 2;
        float[] points = {
                -hw, 0, -hw, 
                hw, 0, -hw,  
                hw, 0, hw,  
                -hw, 0, hw,  
                0, (float) height, 0 
        };
        float[] texCoords = {
                0.5f, 0,
                1, 1,
                0, 1
        };
        int[] faces = {
                0,0,  2,1,  1,2,
                0,0,  3,1,  2,2,
                0,0,  1,1,  4,2,
                1,0,  2,1,  4,2,
                2,0,  3,1,  4,2,
                3,0,  0,1,  4,2
        };

        TriangleMesh pyramidMesh = new TriangleMesh();
        pyramidMesh.getPoints().addAll(points);
        pyramidMesh.getTexCoords().addAll(texCoords);
        pyramidMesh.getFaces().addAll(faces);

        MeshView pyramid = new MeshView(pyramidMesh);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BROWN);
        pyramid.setMaterial(material);

        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        pyramid.getTransforms().add(rotateY);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> rotateY.setAngle(rotateY.getAngle() + 5));
            }
        }).start();

        setupScene(root, pyramid, "Dynamically displayed 3D Pyramid");
    });
}

private void torusCreation(Value[] args) throws ARTException {
    double majorRadius = ((Number) args[1].value()).doubleValue();
    double minorRadius = ((Number) args[2].value()).doubleValue();

    Platform.runLater(() -> {
        Group root = new Group();
        MeshView torus = createTorus(majorRadius, minorRadius, 100, 100);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.ORANGE);
        torus.setMaterial(material);

        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        torus.getTransforms().add(rotateY);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> rotateY.setAngle(rotateY.getAngle() + 5));
            }
        }).start();

        setupScene(root, torus, "Dynamically displayed 3D Torus");
    });
}

public MeshView createTorus(double R, double r, int N, int n) {
    TriangleMesh mesh = new TriangleMesh();
    for (int i = 0; i < N; i++) {
        double phi = 2 * Math.PI * i / N;
        for (int j = 0; j < n; j++) {
            double theta = 2 * Math.PI * j / n;
            double x = (R + r * Math.cos(theta)) * Math.cos(phi);
            double y = (R + r * Math.cos(theta)) * Math.sin(phi);
            double z = r * Math.sin(theta);
            mesh.getPoints().addAll((float) x, (float) y, (float) z);
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < n; j++) {
            int p0 = i * n + j;
            int p1 = (i * n + ((j + 1) % n)) % (N * n);
            int p2 = ((i + 1) % N) * n + ((j + 1) % n);
            int p3 = ((i + 1) % N) * n + j;

            mesh.getFaces().addAll(p0, 0, p1, 0, p2, 0);
            mesh.getFaces().addAll(p0, 0, p2, 0, p3, 0);
        }
    }

    mesh.getTexCoords().addAll(0, 0);
    return new MeshView(mesh);
}

private void hexagonalPrismCreation(Value[] args) throws ARTException {
    double radius = ((Number) args[1].value()).doubleValue();
    double height = ((Number) args[2].value()).doubleValue();

    Platform.runLater(() -> {
        Group root = new Group();
        TriangleMesh mesh = new TriangleMesh();


        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            float x = (float) (radius * Math.cos(angle));
            float z = (float) (radius * Math.sin(angle));
            mesh.getPoints().addAll(x, 0, z);
        }


        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            float x = (float) (radius * Math.cos(angle));
            float z = (float) (radius * Math.sin(angle));
            mesh.getPoints().addAll(x, (float) height, z);
        }

        mesh.getTexCoords().addAll(0, 0);

        for (int i = 0; i < 6; i++) {
            int next = (i + 1) % 6;
            mesh.getFaces().addAll(
                i, 0, next, 0, i + 6, 0,
                next, 0, next + 6, 0, i + 6, 0
            );
        }

  
        for (int i = 0; i < 6; i++) {
            int next = (i + 1) % 6;
            mesh.getFaces().addAll(
                0, 0, i, 0, next, 0
            );
            mesh.getFaces().addAll(
                6, 0, next + 6, 0, i + 6, 0
            );
        }

        MeshView hexagonalPrism = new MeshView(mesh);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.GREEN);
        hexagonalPrism.setMaterial(material);

        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        hexagonalPrism.getTransforms().add(rotateY);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> rotateY.setAngle(rotateY.getAngle() + 5));
            }
        }).start();

        setupScene(root, hexagonalPrism, "Dynamically displayed 3D Hexagonal Prism");
    });
}

private void setupScene(Group root, javafx.scene.Node shape, String title) {
                root.getChildren().add(shape);

                final int windowX = 1000;
                final int windowY = 800;
                Scene scene = new Scene(root, windowX, windowY, true);
                scene.setFill(Color.LIGHTGRAY);

                PerspectiveCamera camera = new PerspectiveCamera(false);
                camera.setTranslateX(-0.27 * windowX);
                camera.setTranslateY(-0.6 * windowY);
                scene.setCamera(camera);

                Stage stage = new Stage();
                stage.setTitle(title);
                stage.setScene(scene);
                stage.show();
            }
        }


package dad.ventana.memoria.main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import dad.ventana.memoria.MemoriaController;
import dad.ventana.memoria.MemoriaModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private MemoriaController controller;
	
	public void Inicio(File ficherito) throws IOException {
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(ficherito));
		String configuracion = "";
		configuracion += "background.red=255\n";
		configuracion += "background.green=255\n";
		configuracion += "background.blue=255\n";
		configuracion += "size.width=420\n";
		configuracion += "size.height=200\n";
		configuracion += "lcoation.x=300\n";
		configuracion += "lcoation.y=200\n";
		
		
		bWriter.write(configuracion);
		bWriter.close();
	}
	
	@Override
	public void init() throws Exception {
		
		String ruta = System.getProperty("user.home");
		Properties pro = new Properties();
		File ficherito = new File(ruta + "\\Desktop\\GitHub\\Ventana-Memoria\\ventana.config");
		
		Inicio(ficherito);
		
		pro.load(new FileInputStream(ficherito));
		controller = new MemoriaController(pro);
		
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene scene = new Scene(controller.getView(), controller.getModel().getAnchura(), controller.getModel().getAltura());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ventana-Memoria");
		primaryStage.setX(controller.getModel().getLocationX());
		primaryStage.setY(controller.getModel().getLocationY());
		primaryStage.show();
		
	}
	
	@Override
	public void stop() throws Exception {
		
		String ruta = System.getProperty("user.home");
		Properties pro = new Properties();
		File ficherito = new File(ruta + "\\Desktop\\GitHub\\Ventana-Memoria\\ventana.config");
		MemoriaModel model = controller.getModel();
		
		pro.setProperty("background.red", String.valueOf(model.getRed()));
		pro.setProperty("background.green", String.valueOf(model.getGreen()));
		pro.setProperty("background.blue", String.valueOf(model.getBlue()));
		pro.setProperty("size.width", String.valueOf(model.getAnchura()));
		pro.setProperty("size.height", String.valueOf(model.getAltura()));
		pro.setProperty("lcoation.x", String.valueOf(model.getLocationX()));
		pro.setProperty("lcoation.y", String.valueOf(model.getLocationY()));
		
		pro.store(new FileWriter(ficherito), null);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
